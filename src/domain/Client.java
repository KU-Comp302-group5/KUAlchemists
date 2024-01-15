package domain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client implements Runnable {
	
	private Socket client;
	private ObjectInputStream in;
	private ObjectOutputStream out;

	public Client() {
	}
	
	public void broadcastChange(GameState state) {
		try {
			out.writeObject(state);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		try {
			client = new Socket("127.0.0.1", 9999);
			out = new ObjectOutputStream(client.getOutputStream());
			in = new ObjectInputStream(client.getInputStream());
			
			GameState gameState;
			try {
				while(( gameState = (GameState)in.readObject() ) != null  ) {
					//get incoming game state and handle here.
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void shutdown() {
		try {
			in.close();
			out.close();
			if (! client.isClosed()) {
				client.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
