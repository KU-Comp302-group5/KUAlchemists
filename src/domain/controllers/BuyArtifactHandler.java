package domain.controllers;

import domain.Player;

public class BuyArtifactHandler {
	
	public void buyArtifact(Player player) {
		player.getArtFromDeck();
	}
	
}
