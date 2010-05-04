import java.io.*;
import java.net.*;

public class Client {

	public static void main(String[] args) {
		Socket s;
		short test;
		
		Mouvement m = new Mouvement((byte)(1),(byte)(2),(byte)(3));
		// test = CommunicationClient.codeMouvement(m);
		// System.out.println(m);
		try {
			s = new Socket("192.168.12.101", 11111);
			(new Thread(new CommunicationClient(s))).start();
		}
		catch (IOException e) {
			 e.printStackTrace();	
		}
	}
}

