package domain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class Server extends Thread {

	private ServerSocket serverSocket;

	public Server(int port) throws IOException {
		serverSocket = new ServerSocket(port);
	}
	
	
public void startServer() {
		// Port number
		int port = 6066;
		
		try {
			
			// Server thread
			Thread t = new Server(port);
			t.start();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

public void run() {
	while (true) {
		try {
			
			// Create server socket for connection
			System.out.println("Waiting for players on port " + serverSocket.getLocalPort() + "...");
			Socket clientPlayer = serverSocket.accept();
            System.out.println("A player connected.");
            
            ObjectOutputStream objectOutput = new ObjectOutputStream(clientPlayer.getOutputStream());
            
            serverSocket.close();


		} catch (SocketTimeoutException s) {
			System.out.println("Socket timed out!");
			break;
		} catch (IOException e) {
			e.printStackTrace();
			break;
		}
	}
}

}
