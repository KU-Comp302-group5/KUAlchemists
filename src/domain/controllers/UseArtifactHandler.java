package domain.controllers;

import java.util.List;

import javax.swing.JFrame;

import domain.ArtifactCard;
import domain.Ingredient;
import domain.IngredientDeck;
import domain.Player;
import ui.ElixirOfInsightPanel;
import ui.LoginPage;

public class UseArtifactHandler {
	// to be used if needed with artifacts requiring UI
	// can be replaced by a general "interface" such as ArtifactPanel
	private static ElixirOfInsightPanel panel;  	
	public void useArtifact(Player player, ArtifactCard artifactCard) {
		player.removeArtifactCard(artifactCard);
		obtainAbility(artifactCard);
	}
	
	public void obtainAbility(ArtifactCard artifactCard) {
		if(artifactCard.getID() == 0) {
			List<Ingredient> topIngredients = IngredientDeck.getInstance().getTopThreeCards();
			// UI : IngredientDeckUI.showTopThreeCards()
			// and IngredientDeckUI.rearrange() --> IngredientDeck.rearrange()
			panel = new ElixirOfInsightPanel(topIngredients);
			panel.add(panel.getPanelArtifact());
			panel.setSize(600,600);
			panel.setVisible(true);
			panel.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			
		}
		if (artifactCard.getID() == 1) {
			// UI : DeductionBoardUI.swap() --> DeductionBoard.swap(alchemyMarker1, alchemyMarker2)
			// buradan emin olamad�m, bu sadece UI funvtionality de olabilir.
		}
	}

}
