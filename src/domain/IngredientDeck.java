package domain;

import java.util.List;

public class IngredientDeck {
    private int cardNum;
    private List<Ingredient> ingredients ;

    public IngredientDeck(int cardNum, List<Ingredient> ingredients) {
		this.cardNum = cardNum;
		this.ingredients = ingredients;
	}

	public Ingredient getTopCard() {
		int position = ingredients.size() - 1
		Ingredient ingr = ingredients.get(position);
		ingredients.remove(cardNu)
    }

    private void decreaseNumCards() {  
    }
}