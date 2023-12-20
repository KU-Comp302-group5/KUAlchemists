package domain;

import java.util.List;

public class ElixirOfInsightArtifact implements ArtifactBehavior {
	@Override
	public void useCard(List<?> list) { // list stores the clicked ingredients in order
				
		IngredientDeck ingrDeck = IngredientDeck.getInstance();
		int cardNum = ingrDeck.getCardNum();
		
		// remove the top three ingredients from ingredient deck
		for (int i = 1; i < 4; i++) {
			ingrDeck.getIngredients().remove(cardNum - i);
		}
		
		// insert the ingredients in the new order
		for (Ingredient ingr : (List <Ingredient>) list) {
			ingrDeck.getIngredients().add(ingr);
		}
		
	}


}
