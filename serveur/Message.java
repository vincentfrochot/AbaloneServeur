import java.io.*;

public class Message implements Serializable {
	String contenu;
	public Message(String unMessage) {
		this.contenu = unMessage;
	}
	public String toString() {
		return(this.contenu);
	}
}
