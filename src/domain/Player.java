package domain;

import java.util.ArrayList;
import java.util.List;

public class Player {
	private String username;
	//private Avatar avatar;
	//private List<Ingredient> ingredients ;
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
		//this.ingredients = ingredients;
		this.artifacts = new ArrayList<ArtifactCard>();
		//this.potions = potions;
		//this.theories = theories;
		this.gold = gold;
		this.reputation = reputation;
		this.sickness = sickness;
	}
	
	public void getArtFromDeck(ArtifactDeck artfdeck) {
		ArtifactCard boughtCard = artfdeck.getTopCard();
		this.artifacts.add(boughtCard);
		System.out.println("\n"+ this.getUsername()+" bought artifact card: "+ boughtCard.getName());
		this.decreaseGold(3);
		
	}

	private void decreaseGold(int i) {
		this.gold-=i;
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

	
}
