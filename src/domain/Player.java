package domain;

import java.util.List;

public class Player {
	private String username;
	//private Avatar avatar;
	private List<Ingredient> ingredients ;
	//private List<ArtifactCard> artifacts ;
	//private List<Potion> potions ;
	//private List<Theory> theories ;
	private int gold;
	private int reputation;
	private int sickness;
	
	
	public Player(String username, 
			//Avatar avatar, 
			List<Ingredient> ingredients, 
			//List<ArtifactCard> artifacts, List<Potion> potions, List<Theory> theories, 
			int gold, int reputation, int sickness) {
		
		this.username = username;
		//this.avatar = avatar;
		this.ingredients = ingredients;
		//this.artifacts = artifacts;
		//this.potions = potions;
		//this.theories = theories;
		this.gold = gold;
		this.reputation = reputation;
		this.sickness = sickness;
	}
	
	public void forageIngredient(IngredientDeck deck) {
		Ingredient ingr1 = deck.getTopCard();
		
		
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public List<Ingredient> getIngredients() {
		return ingredients;
	}


	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}


	public int getGold() {
		return gold;
	}


	public void setGold(int gold) {
		this.gold = gold;
	}


	public int getReputation() {
		return reputation;
	}


	public void setReputation(int reputation) {
		this.reputation = reputation;
	}


	public int getSickness() {
		return sickness;
	}


	public void setSickness(int sickness) {
		this.sickness = sickness;
	}

	
}
