package domain.controllers;

import java.util.List;

import domain.ArtifactCard;
import domain.Ingredient;
import domain.IngredientDeck;
import domain.Player;

public class ElixirOfInsightHandler {
	
	// handles the rearrangement of cards
	// takes in a List<Ingredient> which stores the clicked ingredients,
	// the first clicked at index 0 will be third from top
	// the last clicked will be the top card
	public void handleClickedIngredientOrder(List<Ingredient> clickedIngredientOrder) {
		IngredientDeck ingrDeck = IngredientDeck.getInstance();
		int cardNum = ingrDeck.getCardNum();
		for (int i = 1; i < 4; i++) {
			ingrDeck.getIngredients().remove(cardNum - i);
		}
		for (int i = 0 ; i < 3; i++  ) {
			ingrDeck.getIngredients().add(clickedIngredientOrder.get(i));
		}
	}
}
