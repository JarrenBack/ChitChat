import java.io.IOException;
import java.net.Socket;

public class Client extends Thread {
	String msg, hostname;
	int portNum;
	
	
	public Client(String msg, String hostname, int portNum) {
		this.msg = msg;
		this.hostname = hostname;
		this.portNum = portNum;
	}
	
	@Override
	public void run() {
		try {
			Socket s = new Socket(hostname, portNum);
			s.getOutputStream().write(msg.getBytes());
			s.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
