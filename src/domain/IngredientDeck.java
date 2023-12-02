package domain;

import java.util.List;

public class IngredientDeck {
    private int cardNum;
    private List<Ingredient> ingredients ;

    public IngredientDeck(int cardNum, List<Ingredient> ingredients) {
		this.cardNum = cardNum;
		this.ingredients = ingredients;
	}

}