package domain;

public class UseArtifactHandler {
	
	public void useArtifact(Player player, ArtifactCard artifactCard) {
		player.removeArtifactCard(artifactCard);
		artifactCard.obtainAbility();
	}

}
