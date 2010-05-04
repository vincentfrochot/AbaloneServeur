import java.io.*;
import java.net.*;

public class Client{
	public static void main(String[] args) {
		Socket s;
		short test;
		
		Mouvement m = new Mouvement((byte)(1),(byte)(2),(byte)(3));
		test = CommunicationClient.codeMouvement(m);
		System.out.println(test);
		try {
			s = new Socket("127.0.0.1", 11111);
			ObjectOutputStream oos = new ObjectOutputStream(
						new BufferedOutputStream(
							s.getOutputStream()
						)
				);
			oos.writeObject(new Mouvement((byte)1,(byte)1,(byte)1));
			oos.close();
		}
		catch (IOException e) {
			 e.printStackTrace();	
		}
	}
}

