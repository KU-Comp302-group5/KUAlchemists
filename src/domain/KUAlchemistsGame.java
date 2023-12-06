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
    }
    
    /**
     * A method to start the LoginView.
     */
    public void startLoginView() {
		loginPage = new LoginPage(); 	
		loginPage.add(LoginPage.getPanelLogin());
		loginPage.setSize(600,600);
		loginPage.setVisible(true);
		loginPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void createPlayerI(String username, int avatar) {
    	KUAlchemistsGame.playerI = new Player(username, avatar);
    }
    
    public void createPlayerII(String username, int avatar) {
    	KUAlchemistsGame.playerII = new Player(username, avatar);
    }
    
    public Player getPlayer(int no) {
    	if (no == 1) {
    		return playerI;
    	}
    	else {
    		return playerII;
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
}
