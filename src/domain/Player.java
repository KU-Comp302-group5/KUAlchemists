package domain;

import java.util.ArrayList;
import java.util.List;

public class Player {
	private String username;
	//private Avatar avatar;
	private List<Ingredient> ingredients ;
	private List<ArtifactCard> artifacts ;
	//private List<Potion> potions ;
	//private List<Theory> theories ;
	private int gold;
	private int reputation;
	private int sickness;
	
	public Player(String username, 
			//Avatar avatar, 
			//List<Ingredient> ingredients, List<Potion> potions, List<Theory> theories, 
			int gold, int reputation, int sickness) {
		
		this.username = username;
		//this.avatar = avatar;
		this.ingredients = new ArrayList<Ingredient>();
		this.artifacts = new ArrayList<ArtifactCard>();
		this.getArtFromDeck(); //to try UI
		this.getArtFromDeck(); //to try UI
		this.forageIngredient(); //to try UI
		this.forageIngredient(); //to try UI
		//this.potions = potions;
		//this.theories = theories;
		this.gold = gold;
		this.reputation = reputation;
		this.sickness = sickness;
	}
	
	public void forageIngredient() {
		Ingredient ingr = IngredientDeck.getInstance().getTopCard();
		addIngredient(ingr);
		System.out.println("\n"+ this.getUsername()+" got ingredient card: "+ ingr.getName());
	}
	
	public void addIngredient(Ingredient ingr) {
		this.ingredients.add(ingr);
	}
		
	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}
	
	public Ingredient chooseIngr() {
		return ingredients.get(ingredients.size()-1);
	}
	
	public void transmuteIngredient(Ingredient ingr, int gold_num) {
		if (this.ingredients.contains(ingr)) {
			this.ingredients.remove(ingr);
			increaseGold(gold_num);
			System.out.println("\n"+ this.getUsername()+" transmuted ingredient card: "+ ingr.getName());
		}
	}

	public void getArtFromDeck() {
		ArtifactCard boughtCard = ArtifactDeck.getInstance().getTopCard();
		this.artifacts.add(boughtCard);
		System.out.println("\n"+ this.getUsername()+" bought artifact card: "+ boughtCard.getName());
		this.decreaseGold(3);
	}
	
	public void removeArtifactCard(ArtifactCard artifactCard) {
		if (this.artifacts.contains(artifactCard)) {
			this.artifacts.remove(artifactCard);
		}
	}

	private void decreaseGold(int i) {
		this.gold-=i;
	}
	
	private void increaseGold(int i) {
		this.gold+=i;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<ArtifactCard> getArtifacts() {
		return artifacts;
	}

	public void setArtifacts(List<ArtifactCard> artifacts) {
		this.artifacts = artifacts;
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

	@Override
	public String toString() {
		return "Player [username=" + username + ", ingredients=" + ingredients + ", artifacts=" + artifacts + ", gold="
				+ gold + ", reputation=" + reputation + ", sickness=" + sickness + "]";
	}

}
