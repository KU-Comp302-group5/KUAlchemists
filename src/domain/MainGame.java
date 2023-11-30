package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MainGame {

	public static void main(String[] args) {
		System.out.println("Welcome to KUAlchemists!!!");
		System.out.println("You need to create your player!");
		System.out.println("Enter your player's name:");
		
		Scanner input = new Scanner(System.in);
		String name1 = input.nextLine();
		
		System.out.println("Initializing the game...");
		Aspect as1 = new Aspect(true, true);
		Aspect as2 = new Aspect(true, true);
		Aspect as3 = new Aspect(true, true);
		
		Ingredient toad = new Ingredient("toad", 1, as1, as2, as3);
		Ingredient claw = new Ingredient("claw", 2, as1, as2, as3);
		Ingredient scorpion = new Ingredient("scorpion", 3, as1, as2, as3);
		
		List<Ingredient> ingr_list1 = new ArrayList<Ingredient>();
		ingr_list1.add(toad);
		ingr_list1.add(claw);
		ingr_list1.add(scorpion);
		
		IngredientDeck ingr_deck = new IngredientDeck(3, ingr_list1);
		
		System.out.println("Creating player...");
		Ingredient toad2 = new Ingredient("toad", 4, as1, as2, as3);
		Ingredient claw2 = new Ingredient("claw", 5, as1, as2, as3);
		
		List<Ingredient> ingr_list2 = new ArrayList<Ingredient>();
		ingr_list2.add(toad2);
		ingr_list2.add(claw2);
		
		Player p1 = new Player(name1, ingr_list2, 10, 0, 0);
		
		System.out.println("player created!");
		System.out.println("Current ingredient storage:");
		System.out.println(Arrays.toString(p1.getIngredients().toArray()));
		
		String action = "";
		
		do {
			System.out.println("What do you do? forage, transmute, or exit");
			action = input.nextLine();
			
			if (action.equals("forage")) {
				System.out.println("Foraging for ingredient!");
				Ingredient ingr_temp = p1.forageIngredient(ingr_deck);
				System.out.println(ingr_temp);
			}
			} while (! action.equals("exit"));
		 

	}

}
