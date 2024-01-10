package domain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server implements Runnable {

	private ArrayList<ConnectionHandler> connections;
	private ServerSocket server;
	private boolean accepting;
	private ExecutorService pool;
	
	public Server() {
		connections = new ArrayList<ConnectionHandler>();
		accepting = true;
	}

	@Override
	public void run() {
		
		try {
			while(accepting) {
				server = new ServerSocket(9999);
				pool = Executors.newCachedThreadPool();
				Socket client = server.accept();
				ConnectionHandler connectionHandler = new ConnectionHandler(client);
				connections.add(connectionHandler);
				pool.execute(connectionHandler);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void broadcastGameState() {
		for (ConnectionHandler ch: connections) {
			if (ch != null) {
				ch.sendGameState();
			}
		}
	}
	
	public void shutdown() {
		accepting = false;
		if (! server.isClosed()) {
			try {
				server.close();
				
				for (ConnectionHandler ch: connections) {
					ch.shutdown();
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	class ConnectionHandler implements Runnable {
		
		private Socket client;
		private BufferedReader in; //should change
		private PrintWriter out; //should change
		
		public ConnectionHandler(Socket client) {
			this.client = client;
		}

		@Override
		public void run() {
			
			try {
				out = new PrintWriter(client.getOutputStream());
				in = new BufferedReader(new InputStreamReader(client.getInputStream()));
				// get Game State here
				while (true) {
					broadcastGameState();
				}
				//shutdown();
			} catch (IOException e) {
				
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	
		public void sendGameState() {
		
		}
		
		public void shutdown() {
			if (! client.isClosed()) {
				try {
					in.close();
					out.close();
					client.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
