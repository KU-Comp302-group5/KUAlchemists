package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

import domain.Aspect;
import domain.Ingredient;
import domain.Player;

public class TransmuteIngredientTest {
    
	Player testPlayer = new Player("mert", 1);
	
	Aspect as1 = new Aspect(true, true);
	Aspect as2 = new Aspect(true, false);
	Aspect as3 = new Aspect(false, false);
	Aspect as4 = new Aspect(false, true);
	Ingredient toad = new Ingredient("toad", 1, as3, as1, as4);
	Ingredient claw = new Ingredient("claw", 2, as1, as1, as1);
	Ingredient scorpion = new Ingredient("scorpion", 3, as3, as1, as4);
	
    @Test
    @DisplayName("Test for a succesful transmute")
    public void testASuccesfulTransmute() {
    	testPlayer.addIngredient(toad);
    	testPlayer.addIngredient(claw);
    	testPlayer.addIngredient(scorpion);
    	
    	testPlayer.transmuteIngredient(claw, 1);
    	
        assertEquals(2, testPlayer.getIngredients().size(), "Size should be 2.");
        assertEquals(11, testPlayer.getGold(), "Gold should be 11.");
    }
    
    @Test
    @DisplayName("Test for an unsuccesful transmute")
    public void testAnUnsuccesfulTransmute() {
    	testPlayer.addIngredient(toad);
    	
    	testPlayer.transmuteIngredient(claw, 1);
    	
        assertEquals(1, testPlayer.getIngredients().size(), "Size should be 1.");
        assertEquals(10, testPlayer.getGold(), "Gold should be 10.");
    }
    
    @Test
    @DisplayName("Test for negative gold number")
    public void testMultipleSuccesfulTransmute() {
    	testPlayer.addIngredient(toad);
    	testPlayer.addIngredient(scorpion);
    	
    	testPlayer.transmuteIngredient(toad, -1);
    	
        assertEquals(2, testPlayer.getIngredients().size(), "Size should be 2.");
        assertEquals(10, testPlayer.getGold(), "Gold should be 10.");
    }
    
    @Test
    @DisplayName("Test for multiple succesful transmute of same ingredient")
    public void testMultipleUnsuccesfulTransmute() {
    	testPlayer.addIngredient(toad);
    	testPlayer.addIngredient(toad);
    	testPlayer.addIngredient(claw);
    	
    	testPlayer.transmuteIngredient(toad, 1);
    	testPlayer.transmuteIngredient(toad, 1);
    	
        assertEquals(1, testPlayer.getIngredients().size(), "Size should be 1.");
        assertEquals(12, testPlayer.getGold(), "Gold should be 12.");
    }
    
    @Test
    @DisplayName("Test for a succesful and an unsuccesful transmute")
    public void testSuccesfulAndUnsuccesfulTransmute() {
    	testPlayer.addIngredient(toad);
    	testPlayer.addIngredient(claw);
    	testPlayer.addIngredient(scorpion);
    	
    	testPlayer.transmuteIngredient(claw, 1);
    	testPlayer.transmuteIngredient(claw, 1);
    	
        assertEquals(2, testPlayer.getIngredients().size(), "Size should be 2.");
        assertEquals(11, testPlayer.getGold(), "Gold should be 11.");
    } 
}
