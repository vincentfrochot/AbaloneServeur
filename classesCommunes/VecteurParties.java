import java.util.*;
import java.lang.*;

public class VecteurParties extends Vector <Partie> {
	public VecteurParties() {
		
	}
	
	public synchronized void ajouter(Partie p) {
		this.add(p);
	}
	
	public synchronized void supprimer(Partie p) {
		this.remove(p);
	}
	
	public synchronized void afficher() {
		for(Partie p : this)
			System.out.println(p);
	}
/*	a utiliser au cas ou les parties n'ont pas besoin d'etre indexees par le numPartie.
	public synchronized VecteurParties trier() {
		VecteurParties clone = new VecteurParties();
		int i;
		for(this element : curr) {
			this.insertElementAt(clone.firstElement(), i++);
			clone.removeElement(clone.firstElement());
		}
		return clone;
	}
*/
 }
