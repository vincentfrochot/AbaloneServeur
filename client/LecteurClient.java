import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.*;

public class LecteurClient implements Runnable {
	ObjectInputStream ois;
	Object o;
	Mouvement m;	
	public LecteurClient(Socket s) {
		try {			
			this.ois = new ObjectInputStream(
					s.getInputStream()
			);
			try {
				System.out.println("Je vais lire.");
				Integer i = (Integer)ois.readObject();
				System.out.println("J'ai lu.");
			}
			catch (ClassNotFoundException e) {
				
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	public void run() {
		System.out.println("Je suis dans le run()");
	}
}
