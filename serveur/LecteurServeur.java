import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.*;

public class LecteurServeur implements Runnable {
	ObjectInputStream ois;
	Object o;
	Mouvement m;	
	public LecteurServeur(Socket s) {
		try {			
			this.ois = new ObjectInputStream(
					s.getInputStream()
			);
		}
		catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	public void run() {
		System.out.println("Je suis dans le run()");
	}
}
