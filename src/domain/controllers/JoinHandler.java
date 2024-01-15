package domain.controllers;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import domain.Client;
import domain.GameState;

public class JoinHandler {
	
	private Client client;
	private ExecutorService pool;
	
	public void connectToServer(String address, int port) {
		client = new Client(address, port);
		pool = Executors.newCachedThreadPool();
		pool.execute(client);
	}
	
	public void broadcastGameState(boolean isNewPlayer, boolean quit ){
		GameState state = new GameState(isNewPlayer, quit);
		client.broadcastChange(state);
	}
}
