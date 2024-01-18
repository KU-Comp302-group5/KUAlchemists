package domain.controllers;

import domain.ArtifactBehavior;
import domain.ArtifactCard;
import domain.ElixirOfInsightArtifact;
import domain.KUAlchemistsGame;
import domain.MagicMortarArtifact;
import domain.PrintingPressArtifact;
import domain.WisdomIdolArtifact;

public class UseArtifactHandler {
	ArtifactBehavior artifactBehavior;
	
	public UseArtifactHandler() {
	}
	
	public void useArtifact(ArtifactCard artifactCard) {
		
		if (artifactCard.getID() == 0) {
			artifactBehavior = new ElixirOfInsightArtifact();
		}
		if (artifactCard.getID() == 1) {
			artifactBehavior = new PrintingPressArtifact();
		}
		if (artifactCard.getID() == 2) {
			artifactBehavior = new MagicMortarArtifact();
		}
		if (artifactCard.getID() == 3) {
			artifactBehavior = new WisdomIdolArtifact();
		}
		
		KUAlchemistsGame.getInstance().getCurrentPlayer().removeArtifactCard(artifactCard);
	}
	
	public <T> void performArtifact(T element) {
		artifactBehavior.useCard(element);
	}
}