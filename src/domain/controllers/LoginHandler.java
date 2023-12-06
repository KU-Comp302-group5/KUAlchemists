package domain.controllers;

import domain.Player;

public class LoginHandler {
	
	private Player player1;
	private Player player2;
	
	// Method to perform login
    public void login1(String username, int avatar) {
    	
    	player1 = new Player(username, avatar);

    }
    
    public void login2(String username, int avatar) {
    	
    	player2 = new Player(username, avatar);

    }

	public Player getPlayer1() {
		return player1;
	}

	public void setPlayer1(Player player1) {
		this.player1 = player1;
	}

	public Player getPlayer2() {
		return player2;
	}

	public void setPlayer2(Player player2) {
		this.player2 = player2;
	}
    
    
}
