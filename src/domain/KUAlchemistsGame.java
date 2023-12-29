package domain;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import ui.LoginPage;

/**
 * KUAlchemistsGame is a class with main method to run the game.
 */
public class KUAlchemistsGame {
	private static KUAlchemistsGame game;
	private static LoginPage loginPage;
	
	private static List<Player> players = new ArrayList<Player>();

	private static int numPlayers;
	private static int currentPlayerNo = 1;


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
		loginPage.add(loginPage.getPanelLogin());
		loginPage.setExtendedState(JFrame.MAXIMIZED_BOTH);
		loginPage.setVisible(true);
		loginPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void createPlayer(String username, int avatar) {
    	players.add(new Player(username, avatar));
    	numPlayers++;
    }
    
    
    public Player getPlayer(int playerNo) {
    	return players.get(playerNo-1);
    }
    

	public static Player getCurrentPlayer() {
		//Player player = ;
		return KUAlchemistsGame.getInstance().getPlayer(currentPlayerNo);
	}


	public static int getCurrentPlayerNo() {
		return currentPlayerNo;
	}

	public static void setCurrentPlayerNo(int currentPlayerNo) {
		KUAlchemistsGame.currentPlayerNo = currentPlayerNo;
	}
	
	public static List<Player> getPlayers() {
		return players;
	}

	public static int getNumPlayers() {
		return numPlayers;
	}

	public static void setNumPlayers(int numPlayers) {
		KUAlchemistsGame.numPlayers = numPlayers;
	}
}
