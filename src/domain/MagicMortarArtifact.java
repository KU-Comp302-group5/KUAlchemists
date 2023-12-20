package domain;

import java.util.List;

public class MagicMortarArtifact implements ArtifactBehavior {

	@Override
	public void useCard(List<?> list) {
		// list containing the ingredient to protect (not discard)
		// TO DO implement not discarding the ingredient
		// card is already discarded by the MakeExperimentHandler
		// we need to add it back to the artifacts list of the player
		// but the current player is stored in UI and not domain
	}


}
