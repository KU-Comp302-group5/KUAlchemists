package domain;

import java.util.ArrayList;
import java.util.List;

public class Player {
	private String username;
	private int avatar;
	private List<Ingredient> ingredients ;
	private List<ArtifactCard> artifacts ;
	private List<Potion> potions ;
	private int gold;
	private int reputation;
	private int sickness;
	private List<IngListener> ingListeners;
	private List<ArtListener> artListeners;
	private List<PotListener> potListeners;
	
	public Player(String username, int avatar) {
		
		this.username = username;
		this.avatar = avatar;
		this.ingredients = new ArrayList<Ingredient>();
		this.artifacts = new ArrayList<ArtifactCard>();
		this.potions = new ArrayList<Potion>();
		this.ingListeners = new ArrayList<>();
		this.artListeners = new ArrayList<>();
		this.potListeners = new ArrayList<>();
		this.gold = 10;
		this.reputation = 0;
		this.sickness = 0;
	}
	
	public void addIngListener(IngListener lis) {
		ingListeners.add(lis);
	}
	
	public void addArtListener(ArtListener lis) {
		artListeners.add(lis);
	}
	
	public void addPotListener(PotListener lis) {
		potListeners.add(lis);
	}
	
	public void publishPotEvent() {
		for(PotListener l: potListeners)
			l.onPotChange();
	}
	
	
	public void publishIngEvent() {
		for(IngListener l: ingListeners)
			l.onIngChange();
	}
	
	public void publishArtEvent() {
		for(ArtListener l: artListeners)
			l.onArtChange();
	}
	
	public void forageIngredient() {
		Ingredient ingr = IngredientDeck.getInstance().getTopCard();
		if (ingr != null) {
			addIngredient(ingr);
			System.out.println("\n"+ this.getUsername()+" got ingredient card: "+ ingr.getName());
		}
		publishIngEvent();
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
	
	/**
	 * REQUIRES: Ingredient ingr, gold_num as int.
	 * MODIFIES: player.ingredients, player.gold
	 * EFFECTS: The given ingredients is removed from player's ingredient list if it has.
	 * 			The gold number of player increased by gold_num.
	 * 			publishIngEvent is notified.
	 */
	public void transmuteIngredient(Ingredient ingr, int gold_num) {
		if (this.ingredients.contains(ingr) && gold_num > 0) {
			this.ingredients.remove(ingr);
			increaseGold(gold_num);
			System.out.println("\n"+ this.getUsername()+" transmuted ingredient card: "+ ingr.getName());
			publishIngEvent();
		}
	}

	public void getArtFromDeck() {
		ArtifactCard boughtCard = ArtifactDeck.getInstance().getTopCard();
		if (boughtCard != null) {
			this.artifacts.add(boughtCard);
			System.out.println("\n"+ this.getUsername()+" bought artifact card: "+ boughtCard.getName());
			this.decreaseGold(3);
		}
		publishArtEvent();
	}
	
	public void removeArtifactCard(ArtifactCard artifactCard) {
		if (this.artifacts.contains(artifactCard)) {
			this.artifacts.remove(artifactCard);
			publishArtEvent();
		}
	}
	
	public void discardIngredients(Ingredient ingr1, Ingredient ingr2) {
		if (this.ingredients.contains(ingr1) && (this.ingredients.contains(ingr2))) {
			this.ingredients.remove(ingr1);
			this.ingredients.remove(ingr2);
			publishIngEvent();
		}
	}
	
	public void addPotion(Potion p) {
		this.potions.add(p);
		publishPotEvent();
	}
	
	public void makePublication(Ingredient ingr, AlchemyMarker marker) {
		
	}
	

	public void decreaseGold(int i) {
		this.gold-=i;
	}
	
	public void increaseGold(int i) {
		this.gold+=i;
	}
	
	public void decreaseSickness(int i) {
		this.sickness-=i;
	}
	
	public void increaseSickness(int i) {
		this.sickness+=i;
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

	public int getAvatar() {
		return avatar;
	}
	
	public List<Potion> getPotions() {
		return potions;
	}

	public void setPotions(List<Potion> potions) {
		this.potions = potions;
	}

	@Override
	public String toString() {
		return "Player [username=" + username + ", ingredients=" + ingredients + ", artifacts=" + artifacts + ", gold="
				+ gold + ", reputation=" + reputation + ", sickness=" + sickness + "]";
	}

	public void increaseReputation(int i) {
		reputation += i;
	}

	

}
