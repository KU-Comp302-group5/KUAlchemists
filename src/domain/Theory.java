package domain;

import java.io.Serializable;

public class Theory implements Serializable {
	
	private Ingredient ingredient;
	private AlchemyMarker marker;
	private int playerNo;

	public Theory(Ingredient ingr, AlchemyMarker marker, int playerNum) {
		this.ingredient = ingr;
		this.marker = marker;
		this.playerNo = playerNum;
	}

	public Ingredient getIngredient() {
		return ingredient;
	}

	public void setIngredient(Ingredient ingredient) {
		this.ingredient = ingredient;
	}

	public AlchemyMarker getMarker() {
		return marker;
	}

	public void setMarker(AlchemyMarker marker) {
		this.marker = marker;
	}

	public int getPlayerNo() {
		return playerNo;
	}

	public void setPlayerNo(int playerNo) {
		this.playerNo = playerNo;
	}
	
}
