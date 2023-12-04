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
		
		System.out.println("\nPlayer I artifact storage:");
		System.out.println(Arrays.toString(p1.getArtifacts().toArray()));
		System.out.println("Player I gold:" + p1.getGold());
		
		System.out.println("\nPlayer II artifact storage:");
		System.out.println(Arrays.toString(p2.getArtifacts().toArray()));
		System.out.println("Player II gold:" + p2.getGold());
		
		System.out.println("\nArtifact Deck artifact storage:");
		System.out.println(Arrays.toString(ArtifactDeck.getInstance().getArtifacts().toArray()));

		System.out.println("\nPlayer I's turn");
		
		System.out.println("\nBuy Artifact processing...");
		
		HandlerFactory.getInstance().getBuyArtifactHandler().buyArtifact(p1);
		
		System.out.println("\nPlayer I artifact storage:");
		System.out.println(Arrays.toString(p1.getArtifacts().toArray()));
		System.out.println("Player I gold:" + p1.getGold());
		
		System.out.println("\nPlayer II artifact storage:");
		System.out.println(Arrays.toString(p2.getArtifacts().toArray()));
		System.out.println("Player II gold:" + p2.getGold());
		
		System.out.println("\nArtifact Deck artifact storage:");
		System.out.println(Arrays.toString(ArtifactDeck.getInstance().getArtifacts().toArray()));
		
		System.out.println("\nPlayer II's turn");
		
		System.out.println("\nBuy Artifact processing...");
		
		HandlerFactory.getInstance().getBuyArtifactHandler().buyArtifact(p2);
		
		System.out.println("\nPlayer I artifact storage:");
		System.out.println(Arrays.toString(p1.getArtifacts().toArray()));
		System.out.println("Player I gold:" + p1.getGold());
		
		System.out.println("\nPlayer II artifact storage:");
		System.out.println(Arrays.toString(p2.getArtifacts().toArray()));
		System.out.println("Player II gold:" + p2.getGold());
		
		System.out.println("\nArtifact Deck artifact storage:");
		System.out.println(Arrays.toString(ArtifactDeck.getInstance().getArtifacts().toArray()));
		 

	}

}
