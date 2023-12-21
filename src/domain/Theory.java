package domain;

public class Theory {
	
	private Ingredient ingredient;
	private AlchemyMarker marker;
	private int playerNo;

	public Theory(Ingredient ingr, AlchemyMarker marker, int playerNo2) {
		this.ingredient = ingredient;
		this.marker = marker;
		this.playerNo = playerNo;
	}

	public Ingredient getIngredient() {
		return ingredient;
	}

	public void setIngredient(Ingredient ingredient) {
		this.ingredient = ingredient;
	}
	
}
