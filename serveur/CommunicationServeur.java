import java.io.*;
import java.net.*;

class CommunicationServeur implements Runnable {
	ObjectInputStream ois;
	ObjectOutputStream oos;
	Object o;
	Mouvement m;
	
	public CommunicationServeur(Socket sock) {
		try {
			ois = new ObjectInputStream(
					new BufferedInputStream(
						sock.getInputStream()
					)
				);
			oos = new ObjectOutputStream(
					new BufferedOutputStream(
						sock.getOutputStream()	
					)
				);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
/*	
	public Mouvement decodeMouvement(){
		
	}
*/	
	public void run() {
		
		
		while(o != null) {
			try {
				o = (ois.readObject());
				m = (Mouvement)o;
				System.out.println("La premiere est : "+m.getPremiere());
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();	
			}
			catch(IOException e) {
				e.printStackTrace();	
			}
		}
	}
}