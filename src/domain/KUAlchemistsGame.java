package domain;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

import domain.controllers.HandlerFactory;
import ui.GameModePage;
import ui.LoginPage;

/**
 * KUAlchemistsGame is a class with main method to run the game.
 */
public class KUAlchemistsGame {
	private static KUAlchemistsGame game;
	private static GameModePage gameModePage; //the initial window of the game
	private static LoginPage loginPage;
	private static IGameAdapter gameMode; //adapter pattern here
	private static List<Player> players = new ArrayList<Player>();
	private static List<Integer> scores = new ArrayList<Integer>();
	public static List<Integer> getScores() {
		return scores;
	}
	private static int numPlayers;
	private static int currentPlayerNo;
	private static int thisPlayerNo; //for online only
	private static String devicePlayer; //for online only
	private static int turnCounter;
	private static int round;
	private static List<TurnListener> turnListeners;
	private static List<EndListener> endListeners;
	private static List<Ingredient> ingredients; //to deliver 2 ingrs at the beginning 
	private static List<playerNumListener> playerNumListeners;
	private static List<GameStateListener> stateListeners;
	
	// moved here from Player class
	private List<IngListener> ingListeners;
	private List<ArtListener> artListeners;
	private List<PotListener> potListeners;
	
	//Players that was recently debunked
	private static List<String> recentlyDebunkedPlayers = new ArrayList<String>();

	/**
	 * Private constructor for the game.
	 */
	private KUAlchemistsGame() {
		this.numPlayers = 0;
		this.currentPlayerNo = 1;
		this.turnCounter = 1;
		this.round=1;
		this.turnListeners = new ArrayList<TurnListener>(); 
		this.endListeners = new ArrayList<EndListener>();
		
		IngredientDeck.getInstance().initializeIngredientDeck();
		this.ingredients = IngredientDeck.getInstance().getIngredients();

		this.playerNumListeners = new ArrayList<playerNumListener>();
		this.stateListeners = new ArrayList<GameStateListener>();
		this.ingListeners = new ArrayList<IngListener>();
		this.artListeners = new ArrayList<ArtListener>();
		this.potListeners = new ArrayList<PotListener>();
	}
	
	public static void main(String[] args) {
		getInstance().init();
		getInstance().startGameModeView(); //initial page is now the gamemodepage instead of the loginpage
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
    	IngredientDeck.getInstance().initializeIngredientDeck();
    }
    
    /**
     * A method to start the GameModeView.
     */
    public void startGameModeView() {
		gameModePage = new GameModePage(); 	
		gameModePage.add(gameModePage.getPanel());
		gameModePage.setExtendedState(JFrame.MAXIMIZED_BOTH);
		gameModePage.setVisible(true);
		gameModePage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    /**
     * A method to start the LoginView.
     * This method now uses adapters to start the appropriate page. 
     */
    public void startLoginView() {
    	gameMode.startLoginView();
    }
    
    public void addRecentlyDebunkedPlayer(String p) {
    	if (! recentlyDebunkedPlayers.contains(p)) {
    		recentlyDebunkedPlayers.add(p);
    	}
    }
    
    public void removeRecentlyDebunkedPlayer(String p) {
    	if (recentlyDebunkedPlayers.contains(p)) {
    		recentlyDebunkedPlayers.remove(p);
    	}
    }
    
    public static List<String> getRecentlyDebunkedPlayers() {
		return recentlyDebunkedPlayers;
	}

	public static void setRecentlyDebunkedPlayers(List<String> recentlyDebunkedPlayers) {
		KUAlchemistsGame.recentlyDebunkedPlayers = recentlyDebunkedPlayers;
	}

	public void addIngListener(IngListener lis) {
		ingListeners.add(lis);
	}
	
	public void addArtListener(ArtListener lis) {
		artListeners.add(lis);
	}
	
	public void addPotListener(PotListener lis) {
		potListeners.add(lis);
	}
	
	public void publishPotEvent() {
		for(PotListener l: potListeners)
			l.onPotChange();
	}
	
	public void publishIngEvent() {
		for(IngListener l: ingListeners)
			l.onIngChange();
	}
	
	public void publishArtEvent() {
		for(ArtListener l: artListeners)
			l.onArtChange();
	}
    
    public void addPlayerNumListener(playerNumListener lis) {
    	playerNumListeners.add(lis);
    }
    
    public void publishPlayerNumEvent() {
    	for (playerNumListener l: playerNumListeners) {
    		l.onPlayerNumChange();
    	}
    }
    
    public void addStateListener(GameStateListener lis) {
    	stateListeners.add(lis);
    }
    
    public void publishStateEvent() {
    	for (GameStateListener l: stateListeners) {
    		l.onStateChange();
    	}
    	
		publishArtEvent();
		publishIngEvent();
		publishPotEvent();
		PublicationTrack.getInstance().publishPublicationEvent();
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
    	players.get(numPlayers).addIngredient(this.ingredients.get(numPlayers*2));
    	players.get(numPlayers).addIngredient(this.ingredients.get(numPlayers*2 + 1));
    	numPlayers++;
    	publishPlayerNumEvent();
    }
    
    public void addPlayer(Player player) {
    	System.out.println("Player added.");
    	players.add(player);
    	numPlayers++;
    	publishPlayerNumEvent();
    }
    
    public Player getPlayer(int playerNo) {
    	return players.get(playerNo-1);
    }
    

	public static Player getCurrentPlayer() {
		return KUAlchemistsGame.getInstance().getPlayer(currentPlayerNo);
	}

	public static void switchTurns() {
	    currentPlayerNo = (currentPlayerNo % numPlayers) + 1;
	    
	    if (currentPlayerNo == 1) { // if all players took turns, game finishes when everyone has taken 9 turns
	    	turnCounter++;
	    	round = (turnCounter - 1) / 3 + 1;
	    	System.out.println("TURN COUNTER IS: " + turnCounter);
	    }
	    
	    if (turnCounter == 10) {
	    	//calculate results
	    	for (Player p : players) {
	    		calculateResults(p);
	    	}
	    	gameMode.sendEndGame();
	    	publishEndEvent();
	    }
	    publishTurnEvent();
	    
	    gameMode.switchTurn();
	}
	
	public static void endGame() {
		for (Player p : players) {
    		calculateResults(p);
    	}
    	publishEndEvent();
	}
	
	public static int getRound() {
		return round;
	}

	public static void setRound(int round) {
		KUAlchemistsGame.round = round;
	}

	public static void calculateResults(Player p) {
		int score = 0;
		score += (p.getReputation() 
				//+ p.getArtifacts().size() * 2 
				+ (p.getGold() / 3));
		
		if (p.getArtifacts().contains(new ArtifactCard("Wisdom Idol", 3, false))) {
			score++;
		}
		
		scores.add(score);
	}

	public static int getCurrentPlayerNo() {
		return currentPlayerNo;
	}
	
	public static int getNextPlayerNo() {
		return currentPlayerNo % numPlayers + 1;
	}

	public static void setCurrentPlayerNo(int currentPlayerNo) {
		KUAlchemistsGame.currentPlayerNo = currentPlayerNo;
	}
	
	public static List<Player> getPlayers() {
		return players;
	}
	
	public static void setPlayers(List<Player> players) {
		KUAlchemistsGame.players = players;
	}

	public static int getNumPlayers() {
		return numPlayers;
	}

	public static void setNumPlayers(int numPlayers) {
		KUAlchemistsGame.numPlayers = numPlayers;
	}
	
	//determines the adapter -the mode of the game- according to the input from the UI transmitted through GameModeHandler 
	public void setGameMode(String gamemode) {
		if (gamemode.equals("online")) {
			gameMode = new OnlineAdapter();
		}
		if (gamemode.equals("offline")) {
			gameMode = new OfflineAdapter();
		}
	}
	
	public String[] getPlayerNames() {
		String[] names = new String[numPlayers];
		for (int i = 0; i <numPlayers; i++) {
			names[i] = players.get(i).getUsername();
		}
		return names;
	}


	public static int getTurnCounter() {
		return turnCounter;
	}

	public static void setTurnCounter(int turnCounter) {
		KUAlchemistsGame.turnCounter = turnCounter;
	}

	public static int getThisPlayerNo() {
		return thisPlayerNo;
	}

	public static void setThisPlayerNo(int thisPlayerNo) {
		KUAlchemistsGame.thisPlayerNo = thisPlayerNo;
	}

	public static String getDevicePlayer() {
		return devicePlayer;
	}

	public static void setDevicePlayer(String devicePlayer) {
		KUAlchemistsGame.devicePlayer = devicePlayer;
	}
}
