package domain.controllers;

import domain.KUAlchemistsGame;

public class LoginHandler {
	
    public void login1(String username, int avatar) {
    	KUAlchemistsGame.getInstance().createPlayerI(username, avatar);
    }
    
    public void login2(String username, int avatar) {
    	KUAlchemistsGame.getInstance().createPlayerII(username, avatar);
    }
}