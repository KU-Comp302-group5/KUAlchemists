package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

import domain.Aspect;
import domain.Ingredient;
import domain.Player;

public class TransmuteIngredientTest {
    
	Player playerMert = new Player("mert", 1);
	
	Aspect as1 = new Aspect(true, true);
	Aspect as2 = new Aspect(true, false);
	Aspect as3 = new Aspect(false, false);
	Aspect as4 = new Aspect(false, true);
	Ingredient toad = new Ingredient("toad", 1, as3, as1, as4);
	Ingredient claw = new Ingredient("claw", 2, as1, as1, as1);
	Ingredient scorpion = new Ingredient("scorpion", 3, as3, as1, as4);
	
    @Test
    @DisplayName("Test for a succesful transmute")
    public void testSuccesfulTransmute() {
    	playerMert.addIngredient(toad);
    	playerMert.addIngredient(claw);
    	playerMert.addIngredient(scorpion);
    	
    	playerMert.transmuteIngredient(claw, 1);
    	
        assertEquals(2, playerMert.getIngredients().size(), "Size should be 2.");
        assertEquals(11, playerMert.getGold(), "Gold should be 11.");
    }
    
    @Test
    @DisplayName("Test for a unsuccesful transmute")
    public void testUnsuccesfulTransmute() {
    	playerMert.addIngredient(toad);
    	playerMert.addIngredient(scorpion);
    	
    	playerMert.transmuteIngredient(claw, 1);
    	
        assertEquals(2, playerMert.getIngredients().size(), "Size should be 2.");
        assertEquals(10, playerMert.getGold(), "Gold should be 10.");
    }
    
    
    
    
    
    
    
}
