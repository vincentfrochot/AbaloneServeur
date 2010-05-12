import java.net.*;
import java.util.*;

/**
 * need serialVersion UID ?
 */
public class VecteurJoueurs extends Vector <Socket> {

	public VecteurJoueurs() {
		
	}
	
	public synchronized void ajouter(Socket s) {
		this.add(s);
	}
	
	public synchronized void retirer(Socket s) {
		this.remove(s);
	}
	
	public synchronized void afficherListe() {
		for(Socket s : this)
			System.out.println(s);
	}
}
