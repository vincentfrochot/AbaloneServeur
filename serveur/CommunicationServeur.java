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
		try {	
			this.oos = new ObjectOutputStream(
					new BufferedOutputStream(
						sock.getOutputStream()
					)
				);
			oos.flush();
			this.ois = new ObjectInputStream(
					new BufferedInputStream(
						sock.getInputStream()
					)
				);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
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