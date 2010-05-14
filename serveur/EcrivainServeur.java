import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.*;


public class EcrivainServeur implements Runnable {
	ObjectOutputStream oos;
	Object o;
	Mouvement m;	
	public EcrivainServeur(Socket s) {
		try {	
			System.out.println("Je cree oos.");
			this.oos = new ObjectOutputStream(
						s.getOutputStream()
				);
			System.out.println("Je write oos.");
			oos.writeObject(new Integer(1));
			System.out.println("Je flush oos.");
			oos.flush();	
		}
		catch (IOException e) {
			e.printStackTrace();
		}			
	}
	
	public void run() {
		System.out.println("Je suis dans le run de oos");
	}
}
