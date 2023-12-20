package domain.controllers;

import domain.AlchemyMarker;
import domain.Ingredient;
import domain.Player;

public class PublishHandler {
	
	public PublishHandler() {
	}
	
	public void makePublication(Player player, Ingredient ingr, AlchemyMarker marker){
		player.makePublication(ingr, marker);
	}
	
	
}
