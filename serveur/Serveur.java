import java.io.*;
import java.net.*;

public class Serveur {
//	public static volatile VectorJoueurs joueursConnectes; // un vecteur de joueurs contenant 
//	public static volatile Partie[] parties; // la liste des salles avec lesquelles on peut interagir
	public static volatile int nbMessagesEnvoyes;	
//	long startTime = System.currentTimeMillis();

	public static void main(String[] args) {
		nbMessagesEnvoyes = 0;
//		joueursConnectes = new Vector();
		
		try {
			ServerSocket srvskt = new ServerSocket(11111);

			// on attend maintenant les connexions
			while(true) {
				
//				joueursConnectes[nombreJoueursConnectes] = srvskt.accept();
				(new Thread(new CommunicationServeur(srvskt.accept()))).start(); // c'est un Runnable object qu'on lui passe (sa methode run() sera executee).
			}			
			
		}
		catch (IOException e) {
			
		}
	}
}