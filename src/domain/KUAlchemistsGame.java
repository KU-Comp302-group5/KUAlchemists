package domain;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

import ui.LoginPage;

/**
 * KUAlchemistsGame is a class with main method to run the game.
 */
public class KUAlchemistsGame {
	private static KUAlchemistsGame game;
	private static LoginPage loginPage;
	
	private static List<Player> players = new ArrayList<Player>();

	private static int numPlayers;
	private static int currentPlayerNo;
	private static int turnCounter;
	
	private static List<TurnListener> turnListeners;
	private static List<EndListener> endListeners;


	/**
	 * Private constructor for the game.
	 */
	private KUAlchemistsGame() {
		this.currentPlayerNo = 1;
		this.turnCounter = 1;
		this.turnListeners = new ArrayList<TurnListener>(); 
		this.endListeners = new ArrayList<EndListener>();
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
    	IngredientDeck.getInstance().populateIngredientDeck();
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
    
    public void addEndListener(EndListener lis) {
		endListeners.add(lis);
	}
    
    public static void publishEndEvent() {
		for(EndListener l: endListeners)
			l.onEndChange();
	}
    
    public void addTurnListener(TurnListener lis) {
		turnListeners.add(lis);
	}
    
    public static void publishTurnEvent() {
		for(TurnListener l: turnListeners)
			l.onTurnChange();
	}
    
    
    public void createPlayer(String username, int avatar) {
    	players.add(new Player(username, avatar));
    	numPlayers++;
    }
    
    
    public Player getPlayer(int playerNo) {
    	return players.get(playerNo-1);
    }
    

	public static Player getCurrentPlayer() {
		System.out.println("current player no: " + currentPlayerNo);
		return KUAlchemistsGame.getInstance().getPlayer(currentPlayerNo);
	}

	public static void switchTurns() {
	    currentPlayerNo = (currentPlayerNo % numPlayers) + 1;
	    if (currentPlayerNo == 1) { // if all players took turns, game finishes when everyone has taken 9 turns
	    	turnCounter++;
	    	System.out.println("TURN COUNTER IS: " + turnCounter);
	    }
	    
	    if (turnCounter == 10) {
	    	// TO DO: calculate results
	    	publishEndEvent();
	    }
	    
	    publishTurnEvent();
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
