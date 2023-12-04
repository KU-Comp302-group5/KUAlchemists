package domain;

public class TransmuteIngredientHandler {
	
	public Ingredient getChosenIngr(Player player) {
		return player.chooseIngr();
	}
	
	public void transmuteIngredient(Player player) {
		Ingredient ingr = getChosenIngr(player);
		player.transmuteIngredient(ingr, 1);
	}

}
