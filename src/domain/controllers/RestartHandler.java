package domain.controllers;

import domain.KUAlchemistsGame;

public class RestartHandler {
	
	public void restart() {
		KUAlchemistsGame.getInstance().init();
		KUAlchemistsGame.getInstance().startGameModeView();
	}

}
