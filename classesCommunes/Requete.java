import java.util.*;
import java.io.*;

/**
 * sert a formuler des requetes au serveur.
 *
 */
public class Requete implements Serializable {
	public String commande;
	
	public Requete() {
		this.commande = ""; // mettre par defaut la commande la plus courante
	}
	
	public Requete(String comm) {
		this.commande = comm;
	}
}
