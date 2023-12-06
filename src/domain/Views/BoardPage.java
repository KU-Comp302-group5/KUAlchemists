package domain.Views;

import javax.swing.*;

import domain.Player;
import domain.TransmuteIngredientHandler;
import domain.UseArtifactHandler;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BoardPage extends JFrame implements ActionListener {
	
	private static JPanel panelBoard, player_ingr, player_arts;
	private static JButton help, pause, potionBrewing, publicationTrack, deductionBoard, turnButton, ingrDeckButton, player_ing, artifactDeckButton, player_art;
	private JLabel gold, sickness, name;
	private Player currentPlayer;
    private Player player1, player2;
	
	public BoardPage(Player player1, Player player2) {
		super("KUAlchemists");
		setPanelBoard(new JPanel());
		getPanelBoard().setLayout(null);
		
		this.player1 = player1;
        this.player2 = player2;
      
        currentPlayer = player1;
		
		player_arts = new JPanel();
		player_arts.setBounds(0, 280, 600, 120);
		player_arts.setBackground(Color.ORANGE);
		JLabel pa_text = new JLabel("Player's Artifacts");
		pa_text.setBounds(10, 290, 200, 20); // should change
		player_arts.add(pa_text);
		panelBoard.add(player_arts);
		updateArtifactsPanel(player_arts);
		
		player_ingr = new JPanel();
		player_ingr.setBounds(0, 400, 600, 120);
		player_ingr.setBackground(Color.MAGENTA);
		JLabel pi_text = new JLabel("Player's Ingredients");
		player_ingr.add(pi_text);
		panelBoard.add(player_ingr);
		updateIngredientsPanel(player_ingr);
		
		help = new JButton("Help");
		pause = new JButton("Pause");
		turnButton = new JButton("Turn");
		ingrDeckButton = new JButton("Ingredient Deck");
		//player_ing = new JButton("Ingredients: ");
		artifactDeckButton = new JButton("Artifacts Deck");
		//player_art = new JButton("Artifacts: ");	
		
		ingrDeckButton.setBounds(140, 120, 150, 50);
		ingrDeckButton.setForeground(Color.BLUE);
		ingrDeckButton.addActionListener(e -> {
        	System.out.println("ingrDeckButton clicked");
        	currentPlayer.forageIngredient();
            updateIngredientsPanel(player_ingr);
        	System.out.println(currentPlayer.getIngredients());
        });
        getPanelBoard().add(ingrDeckButton);
        

        
        
        
        
		artifactDeckButton.setBounds(310, 120, 150, 50);
		artifactDeckButton.setForeground(Color.BLUE);
		artifactDeckButton.addActionListener(e -> {
        	System.out.println("artifactDeckButton clicked");
        	currentPlayer.getArtFromDeck();
            updateArtifactsPanel(player_arts);
            gold.setText("Gold: " + currentPlayer.getGold());
        	System.out.println(currentPlayer.getArtifacts());
        });
        getPanelBoard().add(artifactDeckButton);
		
		help.setBounds(0, 0, 40, 20);
		help.setForeground(Color.BLACK);
		help.setBackground(Color.WHITE);
		help.addActionListener(e -> showHelpDialog());
		
		getPanelBoard().add(help);
		
		pause.setBounds(560, 0, 40, 20);
		pause.setForeground(Color.BLACK);
		pause.setBackground(Color.WHITE);
		pause.addActionListener(e -> showPauseDialog());
		
		getPanelBoard().add(pause);
		
        potionBrewing = new JButton("Potion Brewing");
        publicationTrack = new JButton("Publication Track");
        deductionBoard = new JButton("Deduction Board");

        int buttonWidth = 200;
        int buttonHeight = 40;
        
        potionBrewing.setBounds(0, 520, buttonWidth, buttonHeight);
        potionBrewing.setForeground(Color.BLUE);
        potionBrewing.addActionListener(e -> {
        	System.out.println("Potion Brewing button clicked");
        });
        getPanelBoard().add(potionBrewing);

        publicationTrack.setBounds(200, 520, buttonWidth, buttonHeight);
        publicationTrack.setForeground(Color.RED);
        publicationTrack.addActionListener(e -> {
        	System.out.println("Publication Track button clicked");
        });
        getPanelBoard().add(publicationTrack);

        deductionBoard.setBounds(400, 520, buttonWidth, buttonHeight);
        deductionBoard.setForeground(Color.GREEN);
        deductionBoard.addActionListener(e -> {
        	System.out.println("Deduction Board button clicked");
        });
        getPanelBoard().add(deductionBoard);
        
        
        name = new JLabel("Player: " + currentPlayer.getUsername());
        name.setBounds(250, 5, 200, 15);
        getPanelBoard().add(name);
        
        gold = new JLabel("Gold: " + currentPlayer.getGold());
        gold.setBounds(250, 20, 100, 30);
        getPanelBoard().add(gold);

        sickness = new JLabel("Sickness: " + currentPlayer.getSickness());
        sickness.setBounds(250, 50, 100, 30);
        getPanelBoard().add(sickness);
        
        //Just added to show turn of players able to change. Just for demonstration.
		turnButton.setBounds(400, 0, 50, 20);
		turnButton.addActionListener(e -> {
			switchTurns();
		});
		getPanelBoard().add(turnButton);
	}
	
    private void updateArtifactsPanel(JPanel player_arts) {
    	player_arts.removeAll();
        JLabel pa_text = new JLabel("Player's Artifacts: ");
        player_arts.add(pa_text);
        UseArtifactHandler handler = new UseArtifactHandler();

		for (int i=0; i<currentPlayer.getArtifacts().size(); i++) {
			
			JButton player_art = new JButton(currentPlayer.getArtifacts().get(i).toString());
			player_art.setBounds(10, 10, 60, 60); // should change
			player_arts.add(player_art);
			int temp = i;
            player_art.addActionListener(e -> {
            	System.out.println("Artifact is used");
            	handler.useArtifact(currentPlayer, currentPlayer.getArtifacts().get(temp));
                updateArtifactsPanel(player_arts);
                // gold.setText("Gold: " + currentPlayer.getGold());  like observer
            	System.out.println(currentPlayer.getArtifacts());
            });
		}

		player_arts.revalidate();  //need to revise
		player_arts.repaint();  //need to revise
    }
	
    private void updateIngredientsPanel(JPanel player_ingr) {
        player_ingr.removeAll();
        JLabel pi_text = new JLabel("Player's Ingredients");
        player_ingr.add(pi_text);
        TransmuteIngredientHandler handler = new TransmuteIngredientHandler();

        for (int i = 0; i < currentPlayer.getIngredients().size(); i++) {
            JButton player_ing = new JButton(currentPlayer.getIngredients().get(i).toString());
            player_ing.setBounds(10, 10, 80, 30);
            player_ingr.add(player_ing);
            int temp = i;
            player_ing.addActionListener(e -> {
            	System.out.println("Ingredient is transmuted.");
            	// does not use controller
            	//currentPlayer.transmuteIngredient(currentPlayer.getIngredients().get(temp), 1);
                handler.transmuteIngredient(currentPlayer, currentPlayer.getIngredients().get(temp));
            	updateIngredientsPanel(player_ingr);
                gold.setText("Gold: " + currentPlayer.getGold());
            	System.out.println(currentPlayer.getIngredients());
            });
        }

        player_ingr.revalidate();  //need to revise
        player_ingr.repaint();  //need to revise
    }
	
	private void switchTurns() {
		if (currentPlayer == player1) {
			currentPlayer = player2;
		} else {
			currentPlayer = player1;
		}
		name.setText("Player: " + currentPlayer.getUsername());
		gold.setText("Gold: " + currentPlayer.getGold());
		sickness.setText("Sickness: " + currentPlayer.getSickness());
		updateIngredientsPanel(player_ingr);
		updateArtifactsPanel(player_arts);
	}
	
	private void showHelpDialog() {
	    JDialog help = new JDialog(
	    		this,
	    		"Help",
	    		true);
	    help.setSize(300, 100);
	    
	    JLabel helpText = new JLabel("This is help center.");
	    help.add(helpText, BorderLayout.CENTER);
	    JButton ok = new JButton("OK");
	    ok.addActionListener(e -> help.dispose());
	    help.add(ok, BorderLayout.SOUTH);
	    
	    help.setLocationRelativeTo(helpText);
	    help.setVisible(true);
	}

	private void showPauseDialog() {
	    JDialog pause = new JDialog(
	    		this, 
	    		"Pause", 
	    		true);
	    pause.setSize(300, 100);
	    
	    JLabel pauseText = new JLabel("Game is paused. Press OK to continue.");
	    pause.add(pauseText, BorderLayout.CENTER);
	    JButton ok = new JButton("OK");
	    ok.addActionListener(e -> pause.dispose());
	    pause.add(ok, BorderLayout.SOUTH);
	    
	    pause.setLocationRelativeTo(pauseText);
	    pause.setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	public static JPanel getPanelBoard() {
		return panelBoard;
	}

	public static void setPanelBoard(JPanel panelBoard) {
		BoardPage.panelBoard = panelBoard;
	}
	
	
}
