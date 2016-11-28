import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server extends Thread {
	ServerSocket server;
	int portNum = 8877;
	ChitChat gui;
	
	public Server (ChitChat gui, int portNum) {
		this.gui = gui;
		this.portNum = portNum;
		try {
			server = new ServerSocket(portNum);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		Socket clientSocket;
		try {
			while ((clientSocket = server.accept()) != null) {
				InputStream is = clientSocket.getInputStream();
				BufferedReader br = new BufferedReader(new InputStreamReader(is));
				Scanner s = new Scanner(br);
				String theName = s.nextLine();
				System.out.println(theName);
				String theIP = s.nextLine();
				System.out.println(theIP);
				String theMsg = s.nextLine();
				System.out.println(theMsg);
				s.close();
				System.out.println("Before null test");
				if (theMsg != null) {
					gui.addAMessage(theName, theIP, theMsg);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}