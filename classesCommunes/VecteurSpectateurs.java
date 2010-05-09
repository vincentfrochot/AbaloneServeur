import java.net.*;
import java.util.*;

/**
 * need serialVersion UID ?
 */
public class VecteurSpectateurs extends Vector <Socket> {

	public synchronized void ajouter(Socket s) {
		this.add(s);
	}
	
	public synchronized void retirer(Socket s) {
		this.remove(s);
	}
}
