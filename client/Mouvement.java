import java.io.*;

/** Code un mouvement
 * 
 * La premiere bille deplace et la derniere (s'il s'agit d'une poussee la premiere bille = la deuxieme bille).
 * La direction du mouvement.
 */

public class Mouvement implements Serializable {
	/** Determine s'il s'agit d'un mouvement réelle lors d'une partie (true) 
	* ou d'une bille placé lors d'une édition par exemple (false)*/
	private boolean estMouvement;
	/** Numero de la premiere bille*/
	private byte premiere;
	/** Numero de la bille d'arrivee*/
	private byte derniere;
	/** Vecteur de deplacement (direction) */
	private byte vecteur;
	
	/** Vecteur en haut a gauche*/
	public static final byte HD = 0;
	/** Vecteur a droite*/
	public static final byte DD = 1;
	/** Vecteur en bas a droite*/
	public static final byte BD = 2;
	/** Vecteur en bas a gauche*/
	public static final byte BG = 3;
	/** Vecteur a gauche*/
	public static final byte GG = 4;
	/** Vecteur en haut a gauche*/
	public static final byte HG = 5;
	
	public Mouvement(byte prem, byte dern, byte vect){
		this.premiere = prem;
		this.derniere = dern;
		this.vecteur = vect;
		this.estMouvement = true;
	}
	
	/** Renvoie vrai s'il s'agit d'un vrai deplacement et faux s'il s'agit d'une edition.
	*
	* @return true c'est un vrai deplacement
	* @return false c'est une edition
	*/
	public boolean getEstMouvement(){
		return estMouvement;
	}
	
	/** Renvoie la premiere bille du deplacement.
	*
	* @return la premiere bille du deplacement
	*/
	public byte getPremiere(){
		return premiere;
	}
	
	/** Renvoie la derniere bille du deplacement.
	*
	* @return la derniere bille du deplacement
	*/
	public byte getDerniere(){
		return derniere;
	}
	
	/** Renvoie la direction du deplacement.
	*
	* @return la direction du deplacement
	*/
	public byte getVecteur(){
		return vecteur;
	}
	
	public String toString(){
		String res="";
		
		res = res+"Premiere : "+this.premiere+"\n"+"Deuxieme : "+this.derniere+"\n"+"Vecteur : "+this.vecteur+"\n";

		return res;
	}
}