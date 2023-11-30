package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MainGame {

	public static void main(String[] args) {
		System.out.println("Welcome to KUAlchemists!!!");
		
		System.out.println("Player I Name:");
		
		Scanner input = new Scanner(System.in);
		String name1 = input.nextLine();
		

		Player p1 = new Player(name1, 10, 0, 0);
		
		System.out.println("Player II Name:");
		
		String name2 = input.nextLine();
		

		Player p2 = new Player(name2, 10, 0, 0);

		System.out.println("Players created!");
		
	    ArtifactCard elixirOfInsight = new ArtifactCard("Elixir of Insight", 0);
	    ArtifactCard philosophersCompass = new ArtifactCard("Philosopher's Compass", 1);
	    
		/*Aspect as1 = new Aspect(true, true);
		Aspect as2 = new Aspect(true, true);
		Aspect as3 = new Aspect(true, true);
		
		Ingredient toad = new Ingredient("toad", 1, as1, as2, as3);
		Ingredient claw = new Ingredient("claw", 2, as1, as2, as3);
		Ingredient scorpion = new Ingredient("scorpion", 3, as1, as2, as3);
		*/
		List<ArtifactCard> artf_list1 = new ArrayList<ArtifactCard>();
		artf_list1.add(philosophersCompass);
		artf_list1.add(elixirOfInsight);
		
		ArtifactDeck artf_deck = new ArtifactDeck(2, artf_list1);
		
		/*
		Ingredient toad2 = new Ingredient("toad", 4, as1, as2, as3);
		Ingredient claw2 = new Ingredient("claw", 5, as1, as2, as3);
		
		List<Ingredient> ingr_list2 = new ArrayList<Ingredient>();
		ingr_list2.add(toad2);
		ingr_list2.add(claw2);
		*/
		
		System.out.println("\nPlayer I artifact storage:");
		System.out.println(Arrays.toString(p1.getArtifacts().toArray()));
		System.out.println("Player I gold:" + p1.getGold());
		
		System.out.println("\nPlayer II artifact storage:");
		System.out.println(Arrays.toString(p2.getArtifacts().toArray()));
		System.out.println("Player II gold:" + p2.getGold());
		
		System.out.println("\nArtifact Deck artifact storage:");
		System.out.println(Arrays.toString(artf_deck.getArtifacts().toArray()));

		System.out.println("\nPlayer I's turn");
		
		System.out.println("\nBuy Artifact processing...");
		
		p1.getArtFromDeck(artf_deck);
		
		System.out.println("\nPlayer I artifact storage:");
		System.out.println(Arrays.toString(p1.getArtifacts().toArray()));
		System.out.println("Player I gold:" + p1.getGold());
		
		System.out.println("\nPlayer II artifact storage:");
		System.out.println(Arrays.toString(p2.getArtifacts().toArray()));
		System.out.println("Player II gold:" + p2.getGold());
		
		System.out.println("\nArtifact Deck artifact storage:");
		System.out.println(Arrays.toString(artf_deck.getArtifacts().toArray()));
		
		System.out.println("\nPlayer II's turn");
		
		System.out.println("\nBuy Artifact processing...");
		
		p2.getArtFromDeck(artf_deck);
		
		System.out.println("\nPlayer I artifact storage:");
		System.out.println(Arrays.toString(p1.getArtifacts().toArray()));
		System.out.println("Player I gold:" + p1.getGold());
		
		System.out.println("\nPlayer II artifact storage:");
		System.out.println(Arrays.toString(p2.getArtifacts().toArray()));
		System.out.println("Player II gold:" + p2.getGold());
		
		System.out.println("\nArtifact Deck artifact storage:");
		System.out.println(Arrays.toString(artf_deck.getArtifacts().toArray()));
		 

	}

}
