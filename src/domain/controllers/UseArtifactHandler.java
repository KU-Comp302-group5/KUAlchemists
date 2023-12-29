package domain.controllers;

import java.util.List;

import domain.ArtifactBehavior;
import domain.ArtifactCard;
import domain.ElixirOfInsightArtifact;
import domain.KUAlchemistsGame;
import domain.MagicMortarArtifact;
import domain.Player;

public class UseArtifactHandler {
	ArtifactBehavior artifactBehavior;
	
	public UseArtifactHandler() {
	}
	
	// sets the artifact behavior and removes the artifact from player's artifacts
	public void useArtifact(ArtifactCard artifactCard) {
		// if clauses for different artifact cards
		if (artifactCard.getID() == 0) {
			artifactBehavior = new ElixirOfInsightArtifact();
		}
		if (artifactCard.getID() == 2) {
			artifactBehavior = new MagicMortarArtifact();
		}
		
		//int curP = KUAlchemistsGame.getInstance().getCurrentPlayer();
		//Player player = KUAlchemistsGame.getInstance().getPlayer(curP);
		
		KUAlchemistsGame.getInstance().getCurrentPlayer().removeArtifactCard(artifactCard);
		
		//player.removeArtifactCard(artifactCard);
	}
	
	
	public <T> void performArtifact(T element) {
		artifactBehavior.useCard(element);
	}

}
