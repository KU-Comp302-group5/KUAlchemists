package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import domain.Aspect;
import domain.ElixirOfInsightArtifact;
import domain.Ingredient;
import domain.IngredientDeck;


public class ElixirofInsightTest {
	@Test
	public void testUseCard_ValidInput() {
		
		Aspect as1 = new Aspect(true, true);
		Aspect as2 = new Aspect(true, false);
		Aspect as3 = new Aspect(false, false);
		Aspect as4 = new Aspect(false, true);
		Ingredient toad = new Ingredient("toad", 1, as3, as1, as4);
		Ingredient claw = new Ingredient("claw", 2, as1, as1, as1);
		Ingredient scorpion = new Ingredient("scorpion", 3, as3, as1, as4);
	    List<Ingredient> ingredients = new ArrayList<>();
	    ingredients.add(toad);
	    ingredients.add(claw);
	    ingredients.add(scorpion);
	    
	    IngredientDeck ingrDeck = IngredientDeck.getInstance();
	    //ingrDeck.getIngredients().add(scorpion);
	    //ingrDeck.getIngredients().add(toad);
	    //ingrDeck.getIngredients().add(claw);
	    int initialCardNum = ingrDeck.getCardNum();
	    
	    ElixirOfInsightArtifact artifactObject = new ElixirOfInsightArtifact();
	    artifactObject.useCard(ingredients);
	    
	    int finalCardNum = ingrDeck.getCardNum();
	    
	    // Assert that the total number of cards did not change after using the method
	    assertEquals(initialCardNum, finalCardNum);
	    
	    // Assert that the last three ingredients added to the deck are the provided ingredients
	    List<Ingredient> deckIngredients = ingrDeck.getIngredients();
	    assertEquals(toad, deckIngredients.get(finalCardNum - 3));
	    assertEquals(claw, deckIngredients.get(finalCardNum - 2));
	    assertEquals(scorpion, deckIngredients.get(finalCardNum - 1));
	}
	
	@Test
	public void testUseCard_NullInput() {
		
	    List<Ingredient> ingredients = null;
        assertThrows(IllegalArgumentException.class, () -> {
        	ElixirOfInsightArtifact artifactObject = new ElixirOfInsightArtifact();
    	    artifactObject.useCard(ingredients);
        });
	}
	
	@Test
	public void testUseCard_ExcessiveIngredients() {
		Aspect as1 = new Aspect(true, true);
		Aspect as2 = new Aspect(true, false);
		Aspect as3 = new Aspect(false, false);
		Aspect as4 = new Aspect(false, true);
		Ingredient toad = new Ingredient("toad", 1, as3, as1, as4);
		Ingredient claw = new Ingredient("claw", 2, as1, as1, as1);
		Ingredient scorpion = new Ingredient("scorpion", 3, as3, as1, as4);
		Ingredient fern = new Ingredient("fern", 4, as2, as2, as2);
	    List<Ingredient> ingredients = new ArrayList<>();
	    ingredients.add(toad);
	    ingredients.add(claw);
	    ingredients.add(scorpion);
	    ingredients.add(fern);
	    
	    assertThrows(IllegalArgumentException.class, () -> {
        	ElixirOfInsightArtifact artifactObject = new ElixirOfInsightArtifact();
    	    artifactObject.useCard(ingredients);
        });
	}
	
	@Test
	public void testUseCard_LackingIngredients() {
		Aspect as1 = new Aspect(true, true);
		Aspect as2 = new Aspect(true, false);
		Aspect as3 = new Aspect(false, false);
		Aspect as4 = new Aspect(false, true);
		Ingredient toad = new Ingredient("toad", 1, as3, as1, as4);
		Ingredient claw = new Ingredient("claw", 2, as1, as1, as1);
		Ingredient scorpion = new Ingredient("scorpion", 3, as3, as1, as4);
		Ingredient fern = new Ingredient("fern", 4, as2, as2, as2);
	    List<Ingredient> ingredients = new ArrayList<>();
	    ingredients.add(toad);
	    ingredients.add(claw);
	    
	    assertThrows(IllegalArgumentException.class, () -> {
        	ElixirOfInsightArtifact artifactObject = new ElixirOfInsightArtifact();
    	    artifactObject.useCard(ingredients);
        });
	}
	
	@Test
	public void testUseCard_EmptyDeck() {
		Aspect as1 = new Aspect(true, true);
		Aspect as2 = new Aspect(true, false);
		Aspect as3 = new Aspect(false, false);
		Aspect as4 = new Aspect(false, true);
		Ingredient toad = new Ingredient("toad", 1, as3, as1, as4);
		Ingredient claw = new Ingredient("claw", 2, as1, as1, as1);
		Ingredient scorpion = new Ingredient("scorpion", 3, as3, as1, as4);
	    List<Ingredient> ingredients = new ArrayList<>();
	    ingredients.add(toad);
	    ingredients.add(claw);
	    ingredients.add(scorpion);
	    
	    IngredientDeck ingrDeck = IngredientDeck.getInstance();
	    ingrDeck.setCardNum(2);
	    
	    ElixirOfInsightArtifact artifactObject = new ElixirOfInsightArtifact();
	    
	    assertThrows(IllegalStateException.class, () -> {
        	artifactObject.useCard(ingredients);
        });
	}
	
}
