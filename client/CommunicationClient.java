import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;



public class CommunicationClient implements Runnable{
	ObjectInputStream ois;
	ObjectOutputStream oos;
	Object o;
	Mouvement m;		
	
	public CommunicationClient(Socket s) {
		try {	
			this.oos = new ObjectOutputStream(
					new BufferedOutputStream(
						s.getOutputStream()
					)
				);
			oos.flush();
			this.ois = new ObjectInputStream(
					new BufferedInputStream(
						s.getInputStream()
					)
				);			
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
			// connexion : on doit envoyer un Identifiant de connexion et attendre la reponse du serveur.
			// j = new Joueur();
			//joueurConnectes.add(j);
			
			// on doit ici initialiser les valeurs par défaut des différents objets que l'on pourra récupérer.
			Mouvement m = new Mouvement((byte)(1),(byte)(2),(byte)(3));
//			boolean m = true;
			
			
			Object o = new Object();
			while(o != null) {
/*				
				System.out.println("pause");
				try {
					Thread.currentThread().sleep(3000);
				}
				catch(InterruptedException e) {
					System.err.print("zut");
				}
*/				
				try {
					oos.writeObject(m); // ces actions sont déclenchées par un click
					oos.flush();
					try  { // si c'est un Mouvement que l'on vient d'envoyer, on doit se mettre en écoute
						o = ois.readObject(); // les clients sont constamment à l'écoute du serveur : seules les actions via la souris permettent d'envoyer des messages au serveur.
						// ici on doit maintenant tester via instanceof l'objet reçu et modifier notre interface de façon appropriée.
					}
					catch (ClassNotFoundException e) {
						
					}
				}
				catch (IOException e) {
					
				}			
			}
	}
	/*
		Liste des actions:
		    0000 : CreerPartie
		    0001 : rejoindrePartie
		    0010 : JouerMouvement
		    0011 : Abandonner
		    0100 : ReprendreUnCoup
		    0101 : AccepterRepriseCoup
		    0110 : RefuserRepriseCoup
		    0111 : PlacerUneBille (editer)
		    1000 : PlacerUnSymbole (editer)
		    1001 : RevenirAUnCoupPrecis (editer)
		    1010 : EcrireChat
		    1011 : 
	*/
	
	
	/** Code un mouvement en binaire pour l'envoi vers le serveur.
	*
	* @param m Le mouvement Ã  coder
	* @return Le mouvement coder en binaire 
	*
	*  codage : 
	*     6bits premiere bille
	*     6bits deuxieme bille
	*     3bits le vecteur de deplacement
	*/
	public static short codeMouvement(Mouvement m){
		int mouv=0;
		
		//La premiere bille
		mouv = m.getPremiere();
		//La deuxieme bille
		mouv = mouv << 6;
		mouv += m.getDerniere();
		//Le vecteur
		mouv = mouv << 3;
		mouv += m.getVecteur();
		
		return (short)(mouv);
	}
}