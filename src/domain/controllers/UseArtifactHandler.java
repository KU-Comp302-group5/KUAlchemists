package domain.controllers;

import java.util.List;

import domain.ArtifactBehavior;
import domain.ArtifactCard;
import domain.ElixirOfInsightArtifact;
import domain.Player;

public class UseArtifactHandler {
	ArtifactBehavior artifactBehavior;
	
	public UseArtifactHandler() {
	}
	
	// sets the artifact behavior and removes the artifact from player's artifacts
	public void useArtifact(Player player, ArtifactCard artifactCard) {
		// will be done with if clauses for different artifact cards
		artifactBehavior = new ElixirOfInsightArtifact();
		player.removeArtifactCard(artifactCard);
	}
	
	
	public void performArtifact(List<?> list) {
		artifactBehavior.useCard(list);
	}

}
