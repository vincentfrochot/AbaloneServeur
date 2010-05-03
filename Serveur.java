import java.io.*;

public class Serveur {
	public static volatile Vector joueursConnectes;
	public static volatile Partie[] parties; // la liste des salles avec lesquelles on peut interagir
	public static volatile int nbParties, nbMessagesEnvoyes, nombreJoueursConnectes;	
	
	public static void main(String[] args) {
		nbMessagesEnvoyes = 0;
		nombreJoueursConnectes = 0;
		joueursConnectes = new Vector();
		
		try {
			
		}
		catch (IOException e) {
				
		}
	}
}