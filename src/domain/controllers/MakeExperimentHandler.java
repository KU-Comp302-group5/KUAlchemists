package domain.controllers;

import domain.Ingredient;
import domain.Player;
import domain.Potion;
import domain.PotionMaker;

public class MakeExperimentHandler {

    public MakeExperimentHandler() {
    }

    public void makeExperiment(Ingredient ingr1, Ingredient ingr2, String experimental, Player player) {
    	
    	System.out.println("in exp handler: ingr1: "+ingr1.toString()+"ingr 2: " +ingr2.toString());
    	PotionMaker pm = new PotionMaker();
    	
		Potion potion = pm.mixIngredients(ingr1, ingr2);
		
		int tryResult = pm.tryPotion(experimental);
		if(tryResult==0) {
			player.decreaseGold(1);
		}
		if(tryResult==1) {
			player.increaseSickness(1);
		}
		player.discardIngredients(ingr1, ingr2);
		player.addPotion(potion);
    }
}