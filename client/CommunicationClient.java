 

public class CommunicationClient{
	
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
	* @param m Le mouvement à coder
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