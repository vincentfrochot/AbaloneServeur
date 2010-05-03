public class Client{
	public static void main(String[] args) {
		short test;
		
		Mouvement m = new Mouvement((byte)(1),(byte)(2),(byte)(3));
		test = CommunicationClient.codeMouvement(m);
		System.out.println(test);
	}
	
}

