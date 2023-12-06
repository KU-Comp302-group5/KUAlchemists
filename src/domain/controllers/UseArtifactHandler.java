package domain.controllers;

import domain.ArtifactCard;
import domain.Player;

public class UseArtifactHandler {
	
	public void useArtifact(Player player, ArtifactCard artifactCard) {
		player.removeArtifactCard(artifactCard);
		artifactCard.obtainAbility();
	}

}
