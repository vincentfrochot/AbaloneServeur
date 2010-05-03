class CommunicationServeur implements Runnable {
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
	
	public void run(){
		
	}
}