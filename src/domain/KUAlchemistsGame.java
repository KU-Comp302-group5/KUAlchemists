package domain;

import javax.swing.JFrame;

import ui.LoginPage;

/**
 * KUAlchemistsGame is a class with main method to run the game.
 */
public class KUAlchemistsGame {
	private static KUAlchemistsGame game;
	private static LoginPage loginPage;
	private static Player playerI;
	private static Player playerII;
	private static Player playerIII;
	private static Player playerIV;


	/**
	 * Private constructor for the game.
	 */
	private KUAlchemistsGame() {
	}
	
	public static void main(String[] args) {
		getInstance().init();
		getInstance().startLoginView();
	}
	
	/**
     * Singleton pattern for the KUAlchemists object.
     *
     * @return Only instance of KUAlchemists
     */
	public static KUAlchemistsGame getInstance() {
		if (game == null) game = new KUAlchemistsGame();
        return game;
	}
	
	/**
     * init method to do assignments and checks.
     */
    private void init() {
    	PublicationTrack.getInstance().populateTrack();
    }
    
    /**
     * A method to start the LoginView.
     */
    public void startLoginView() {
		loginPage = new LoginPage(); 	
		loginPage.add(loginPage.getPanelLogin());
		loginPage.setExtendedState(JFrame.MAXIMIZED_BOTH);
		loginPage.setVisible(true);
		loginPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void createPlayerI(String username, int avatar) {
    	KUAlchemistsGame.playerI = new Player(username, avatar);
    }
    
    public void createPlayerII(String username, int avatar) {
    	KUAlchemistsGame.playerII = new Player(username, avatar);
    }
    
    public void createPlayerIII(String username, int avatar) {
    	KUAlchemistsGame.playerIII = new Player(username, avatar);
    }
    
    public void createPlayerIV(String username, int avatar) {
    	KUAlchemistsGame.playerIV = new Player(username, avatar);
    }
    
    public Player getPlayer(int no) {
    	if (no == 1) {
    		return playerI;
    	}
    	else if (no == 2) {
    		return playerII;
    	}else if (no == 3) {
    		return playerIII;
    	} else {
    		return playerIV;
    	}
    }

	public Player getPlayerI() {
		return playerI;
	}

	public void setPlayerI(Player playerI) {
		KUAlchemistsGame.playerI = playerI;
	}

	public Player getPlayerII() {
		return playerII;
	}

	public void setPlayerII(Player playerII) {
		KUAlchemistsGame.playerII = playerII;
	}
	
	public Player getPlayerIII() {
		return playerIII;
	}

	public void setPlayerIII(Player playerIII) {
		KUAlchemistsGame.playerIII = playerIII;
	}

	public Player getPlayerIV() {
		return playerIV;
	}

	public void setPlayerIV(Player playerIV) {
		KUAlchemistsGame.playerIV = playerIV;
	}
}
