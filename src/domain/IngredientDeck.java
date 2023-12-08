package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IngredientDeck {
	private static IngredientDeck instance;
	
    private int cardNum;
    private List<Ingredient> ingredients ;
    
    public static IngredientDeck getInstance() {
    	
		if (instance == null) {
			instance = new IngredientDeck();
		}
		return instance;
	}

    public IngredientDeck() {
		this.cardNum = 3;
		
		List<Ingredient> ingrs = new ArrayList<Ingredient>();
		
		Aspect as1 = new Aspect(true, true);
		Aspect as2 = new Aspect(true, true);
		Aspect as3 = new Aspect(true, true);
		
		Ingredient toad = new Ingredient("toad", 1, as1, as2, as3);
		Ingredient claw = new Ingredient("claw", 2, as1, as2, as3);
		Ingredient scorpion = new Ingredient("scorpion", 3, as1, as2, as3);
		
		ingrs.add(toad);
		ingrs.add(claw);
		ingrs.add(scorpion);
		
		//Collections.shuffle(ingrs);
		
		this.ingredients = ingrs;
		
	}

    
    // for Elixir of insight
    public List<Ingredient> getTopThreeCards(){
    	if (cardNum < 3) {
    		return null;
    	}
    	else {
    		Ingredient ingr;
    		List<Ingredient> topThreeIngredientList = new ArrayList<>();
    		for (int i = 1; i < 4 ; i++) {
    			ingr = ingredients.get(cardNum - i);
    			topThreeIngredientList.add(ingr);
    		}
    		return topThreeIngredientList;
    	}
    }
    
	public Ingredient getTopCard() {
		if (cardNum > 0) {
			Ingredient ingr = ingredients.get(cardNum-1);
	    	ingredients.remove(cardNum-1);
	    	cardNum--;
	    	return ingr;
		}
		else {
			System.out.println("No cards to draw in the ingredients deck");
			return null;
		}
    }
	
	// getter for ingredients
	public List<Ingredient> getIngredients() {
        return ingredients;
    }

    // Setter method for ingredients
    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
    
 // Getter method for cardNum
    public int getCardNum() {
        return cardNum;
    }

    // Setter method for cardNum
    public void setCardNum(int cardNum) {
        this.cardNum = cardNum;
    }

	@Override
	public String toString() {
		return "IngredientDeck [cardNum=" + cardNum + ", ingredients=" + ingredients + "]";
	}

}