package d1;

import java.util.List;

public class Player {
	private String username;
	private Avatar avatar;
	private List<Ingredient> ingredients ;
	private List<Artifact> artifacts ;
	private List<Potion> potions ;
	private List<Theory> theories ;
	private int gold;
	private int reputation;
	private int sickness;
	
	
	public Player(String username, Avatar avatar, List<Ingredient> ingredients, List<Artifact> artifacts,
			List<Potion> potions, List<Theory> theories, int gold, int reputation, int sickness) {
		super();
		this.username = username;
		this.avatar = avatar;
		this.ingredients = ingredients;
		this.artifacts = artifacts;
		this.potions = potions;
		this.theories = theories;
		this.gold = gold;
		this.reputation = reputation;
		this.sickness = sickness;
	}

	public void getIntFromDeck(){
		
	}
	
	public void getArtFromDeck(){
		
	}
    
    public void decreaseGold(int amount) {
    	
    }
    
    public void increaseGold(int amount) {
    	
    }
    
    public void decreaseReputation(int amount) {
    	
    }
    
    public void increaseReputation(int amount) {
    	
    }
    
    public void removeArtifactCard(ArtifactCard artif) {
    	
    }
    
    public void addTheory(Theory theory) {
    	
    }
    
    public void discardIngredients(Ingredient ingr1, Ingredient ingr2) {
    	
    }
}
