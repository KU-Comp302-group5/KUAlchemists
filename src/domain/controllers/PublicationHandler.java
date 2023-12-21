package domain.controllers;

import java.util.List;

import domain.AlchemyMarker;
import domain.Ingredient;
import domain.KUAlchemistsGame;
import domain.Player;
import domain.PublicationTrack;

public class PublicationHandler {
	
	public void makePublication(String ingr, String marker, int playerNo){
		
		Ingredient ingredient = PublicationTrack.getInstance().getIngredientByName(ingr);
		AlchemyMarker alchemyMarker = PublicationTrack.getInstance().getMarkerByName(marker);
		
		PublicationTrack.getInstance().publishTheory(ingredient, alchemyMarker, playerNo);
		KUAlchemistsGame.getInstance().getPlayer(playerNo).decreaseGold(1);
		KUAlchemistsGame.getInstance().getPlayer(playerNo).increaseReputation(1);
	}
	
	public List<AlchemyMarker> getAvailableAlchemies() {
		return PublicationTrack.getInstance().getAvailableAlchemies();
	}

	public List<Ingredient> getAvailableIngredients() {
		return PublicationTrack.getInstance().getAvailableIngredients();
	}
}
