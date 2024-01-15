package domain.controllers;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import domain.Client;
import domain.GameState;
import domain.KUAlchemistsGame;

public class JoinHandler {
	
	private Client client;
	private ExecutorService pool;
	
	public void connectToServer(String address, String port) {
		int portNo = Integer.valueOf(port);
		client = new Client(address, portNo);
		pool = Executors.newCachedThreadPool();
		pool.execute(client);
	}
	
	public void broadcastGameState(boolean isNewPlayer, boolean start, boolean quit){
		GameState state = new GameState(isNewPlayer, start, quit);
		client.broadcastChange(state);
	}
	
	public void login(String username, int avatar) {
		KUAlchemistsGame.getInstance().createPlayer(username, avatar);
		broadcastGameState(true, false, false);
	}
	
}
