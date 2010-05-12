import java.io.*;
import java.net.*;

class CommunicationServeur implements Runnable {
	ObjectInputStream ois;
	ObjectOutputStream oos;
	Object o;
	private Mouvement myMouvement;
	private Message myMessage;
//	private VectorParties;
	
	public CommunicationServeur(Socket sock) {	
		(new Thread(new EcrivainServeur(sock))).start();
		(new Thread(new LecteurServeur(sock))).start();		


		/*		try {	
			System.out.println("Je cree oos.");
			this.oos = new ObjectOutputStream(
						sock.getOutputStream()
				);
			System.out.println("Je flush oos.");
			oos.close();
			System.out.println("J'écris sur oos.");
			oos.writeObject(new Integer(1));
			System.out.println("Je suis pret a recevoir des ordres1.");
			oos.flush();
			System.out.println("Je suis pret a recevoir des ordres2.");

			System.out.println("Je suis pret a recevoir des ordres.");
			this.ois = new ObjectInputStream(
						sock.getInputStream()
				);
System.out.println("Je suis pret a recevoir des ordres.");
			try {
				System.out.println("Je suis pret a recevoir des ordres.");
				Integer i = (Integer)ois.readObject();
				System.out.println("Je suis pret a recevoir des ordres.");
			}
			catch (ClassNotFoundException e) {
				
			}			
			System.out.println("Je suis pret a recevoir des ordres.");
		}
		catch (IOException e) {
			e.printStackTrace();
		}
*/	}
	
/*	
	public Mouvement decodeMouvement(){
=======
	public static void main(String[] args) {
		System.out.println(decodeMouvement((short)531));
	}
	
	/** Code un mouvement en binaire pour l'envoi vers le serveur.
	*
	* @param code Le code a decoder en mouvement
	* @return Le Mouvement 
	*
	*  codage : 
	*     6bits premiere bille
	*     6bits deuxieme bille
	*     3bits le vecteur de deplacement
	*/
	public static Mouvement decodeMouvement(short code){
		int premiere;
		int deuxieme;
		int vecteur;
		
		premiere = (code & 077000) >> 9;
		deuxieme = (code & 0770) >> 3;
		vecteur = (code & 07);
		
		Mouvement m = new Mouvement((byte)premiere, (byte)deuxieme, (byte)vecteur);
		
		return m;
	}
	
	public void run() {
		Serveur.joueursConnectes.afficherListe();
		o = new Object();
		myMouvement = new Mouvement((byte)1, (byte)12, (byte)2);
		// on doit recuperer les identifiants de connexion et verifier qu'ils sont corrects.
		
		// s'ils sont corrects on envoie un objet Joueur qui va être instancié par le client.
		// sinon on essaie de fermer la connexion (comment faire ?)
		
		
		
		while(o != null) {
		
			try {
				Thread.currentThread().sleep(3000);
			}
			catch(InterruptedException e) {
				System.err.println("interrupted");
			}

			try {
				oos.writeObject(myMouvement);
				oos.flush();
				Serveur.joueursConnectes.afficherListe();
/*				
				o = (ois.readObject());
				if(o instanceof Mouvement) {
					System.out.println("Ceci est un mouvement...");
					myMouvement = (Mouvement)o;
					System.out.println(myMouvement);
					// on doit l'enregistrer dans la bdd et l'envoyer à tous les clients.
				}
				else if(o instanceof Message) {
					myMessage = (Message)o;
					System.out.println(myMessage);
				}
*/
				
				
/*
 				else if(o instanceof CreationPartie) {
 					Partie partie = new Partie(Serveur.getNbParties()); // la partie devra contenir son numero de partie puisque le Client doit pouvoir l'identifier (ce numéro de partie sera généré par le serveur en fonction du nombre de parties actuellement jouees).
					this.VectorParties.add(partie, partie.getNumPartie()); // on place la partie à la position partie.getNumPartie() : le client la placera à la meme position pour facilement y acceder ?
				}
*/
			}
/*			catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
*/			catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
}