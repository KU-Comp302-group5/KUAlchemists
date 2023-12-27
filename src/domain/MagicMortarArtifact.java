package domain;

import java.util.List;

public class MagicMortarArtifact implements ArtifactBehavior<Ingredient> {

	@Override
	public void useCard(Ingredient ingr) {
		
		int currentPIndex = KUAlchemistsGame.getInstance().getCurrentPlayer();
		int numPlayers = KUAlchemistsGame.getInstance().getNumPlayers();

		// card is already discarded by the MakeExperimentHandler
		// we need to add it back to the artifacts list of the player
		// BUG: card is added to another player, not the player that used the magic mortar card
		// this happens because switchTurn is called in UI,
		// turn should be stored in the domain layer, UI layer should be notified when turn switches using OBSERVER pattern
		// (currentPIndex + (numPlayers-1)) % numPlayers is an attempt to reach the previous player
		KUAlchemistsGame.getInstance().getPlayer((currentPIndex + (numPlayers-1)) % numPlayers).addIngredient(ingr);
	}


}
