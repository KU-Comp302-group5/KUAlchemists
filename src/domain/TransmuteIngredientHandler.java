package domain;

public class TransmuteIngredientHandler {
	
	public void transmuteIngredient(Player player, Ingredient ingredient) {
		player.transmuteIngredient(ingredient);
	}
	
	// not necessary
	/*
	
	public Ingredient getChosenIngr(Player player) {
		return player.chooseIngr();
	}
	
	public void transmuteIngredient(Player player) {
		Ingredient ingr = getChosenIngr(player);
		player.transmuteIngredient(ingr, 1);
	}
	*/

}
