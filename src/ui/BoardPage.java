package ui;

import javax.swing.*;

import domain.ArtListener;
import domain.IngListener;
import domain.KUAlchemistsGame;
import domain.controllers.HandlerFactory;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BoardPage extends JFrame implements ActionListener {
	
	private static JPanel panelBoard, player_ingr, player_arts;
	private static JButton help, pause, potionBrewing, publicationTrack, deductionBoard, turnButton, ingrDeckButton, player_ing, artifactDeckButton, player_art;
	private JLabel gold, sickness, name;
	private int currentPlayer;
	
	public BoardPage() {
		super("KUAlchemists");
		setPanelBoard(new JPanel());
		getPanelBoard().setLayout(null);
		currentPlayer = 1;
		
		player_arts = new PlayerArts();
		player_arts.setBounds(0, 280, 600, 120);
		player_arts.setBackground(Color.ORANGE);
		JLabel pa_text = new JLabel("Player's Artifacts");
		pa_text.setBounds(10, 290, 200, 20); // should change
		player_arts.add(pa_text);
		panelBoard.add(player_arts);
		((PlayerArts) player_arts).updateArts();
		
		//might change later
		KUAlchemistsGame.getInstance().getPlayerI().addArtListener((PlayerArts) player_arts);
		KUAlchemistsGame.getInstance().getPlayerII().addArtListener((PlayerArts) player_arts);
		
		player_ingr = new PlayerIngs();
		player_ingr.setBounds(0, 400, 600, 120);
		player_ingr.setBackground(Color.MAGENTA);
		JLabel pi_text = new JLabel("Player's Ingredients");
		player_ingr.add(pi_text);
		panelBoard.add(player_ingr);
		((PlayerIngs) player_ingr).updateIngs();
		
		//might change later
		KUAlchemistsGame.getInstance().getPlayerI().addIngListener((PlayerIngs) player_ingr);
		KUAlchemistsGame.getInstance().getPlayerII().addIngListener((PlayerIngs) player_ingr);
		
		help = new JButton("Help");
		pause = new JButton("Pause");
		turnButton = new JButton("Turn");
		ingrDeckButton = new JButton("Ingredient Deck");
		artifactDeckButton = new JButton("Artifacts Deck");
		
		ingrDeckButton.setBounds(140, 120, 150, 50);
		ingrDeckButton.setForeground(Color.BLUE);
		ingrDeckButton.addActionListener(e -> {
        	System.out.println("ingrDeckButton clicked");
        	HandlerFactory.getInstance().getForageIngHandler().forageIngredient(KUAlchemistsGame.getInstance().getPlayer(currentPlayer));
        });
        getPanelBoard().add(ingrDeckButton);
        
		artifactDeckButton.setBounds(310, 120, 150, 50);
		artifactDeckButton.setForeground(Color.BLUE);
		artifactDeckButton.addActionListener(e -> {
        	System.out.println("artifactDeckButton clicked");
        	HandlerFactory.getInstance().getBuyArtifactHandler().buyArtifact(KUAlchemistsGame.getInstance().getPlayer(currentPlayer));
            gold.setText("Gold: " + KUAlchemistsGame.getInstance().getPlayer(currentPlayer).getGold());
        	System.out.println(KUAlchemistsGame.getInstance().getPlayer(currentPlayer).getArtifacts());
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
        
        
        name = new JLabel("Player: " + KUAlchemistsGame.getInstance().getPlayer(currentPlayer).getUsername());
        name.setBounds(250, 5, 200, 15);
        getPanelBoard().add(name);
        
        
        /**
         * Observer pattern should be implemented for updating gold.
         *
         */
        gold = new JLabel("Gold: " + KUAlchemistsGame.getInstance().getPlayer(currentPlayer).getGold());
        gold.setBounds(250, 20, 100, 30);
        getPanelBoard().add(gold);

        /**
         * Observer pattern should be implemented for updating sickness.
         *
         */
        sickness = new JLabel("Sickness: " + KUAlchemistsGame.getInstance().getPlayer(currentPlayer).getSickness());
        sickness.setBounds(250, 50, 100, 30);
        getPanelBoard().add(sickness);
        
        //Just added to show turn of players able to change. Just for demonstration.
		turnButton.setBounds(400, 0, 50, 20);
		turnButton.addActionListener(e -> {
			switchTurns();
		});
		getPanelBoard().add(turnButton);
	}
	
	
	/**
     * Observer pattern.
     *
     * Inner class implementing ArtListener for PlayerArts
     */
    private class PlayerArts extends JPanel implements ArtListener {
        
    	public void updateArts() {
    		this.removeAll();
    		JLabel pa_text = new JLabel("Player's Artifacts: ");
            this.add(pa_text);
            
            for (int i=0; i<KUAlchemistsGame.getInstance().getPlayer(currentPlayer).getArtifacts().size(); i++) {
    			
    			JButton player_art = new JButton(KUAlchemistsGame.getInstance().getPlayer(currentPlayer).getArtifacts().get(i).toString());
    			player_art.setBounds(10, 10, 60, 60); // should change
    			this.add(player_art);
    			int temp = i;
                player_art.addActionListener(e -> {
                	System.out.println("Artifact is used");
                	HandlerFactory.getInstance().getUseArtifactHandler().useArtifact(KUAlchemistsGame.getInstance().getPlayer(currentPlayer), 
                			KUAlchemistsGame.getInstance().getPlayer(currentPlayer).getArtifacts().get(temp));
                });
    		}
    		this.revalidate();  //need to revise
    		this.repaint();  //need to revise
    	}
        
        @Override
    	public void onArtChange() {
    		updateArts();
    	}
    }
    
    
    /**
     * Observer pattern.
     *
     * Inner class implementing IngListener for PlayerIngs.
     */
    private class PlayerIngs extends JPanel implements IngListener {

    	public void updateIngs() {
    		this.removeAll();
            JLabel pi_text = new JLabel("Player's Ingredients");
            this.add(pi_text);
            
            for (int i = 0; i < KUAlchemistsGame.getInstance().getPlayer(currentPlayer).getIngredients().size(); i++) {
                JButton player_ing = new JButton(KUAlchemistsGame.getInstance().getPlayer(currentPlayer).getIngredients().get(i).toString());
                player_ing.setBounds(10, 10, 80, 30);
                this.add(player_ing);
                player_ing.addActionListener(e -> {
                	System.out.println("Ingredient is transmuted.");
                	HandlerFactory.getInstance().getTransmuteIngHandler().transmuteIngredient(KUAlchemistsGame.getInstance().getPlayer(currentPlayer));
                    gold.setText("Gold: " + KUAlchemistsGame.getInstance().getPlayer(currentPlayer).getGold());
                });
            }
            this.revalidate();  //need to revise
            this.repaint();  //need to revise
    	}
    	
		@Override
		public void onIngChange() {
			updateIngs();
		}
    }
	
	private void switchTurns() {
		if (currentPlayer == 1) {
			currentPlayer = 2;
		} else {
			currentPlayer = 1;
		}
		name.setText("Player: " + KUAlchemistsGame.getInstance().getPlayer(currentPlayer).getUsername());
		gold.setText("Gold: " + KUAlchemistsGame.getInstance().getPlayer(currentPlayer).getGold());
		sickness.setText("Sickness: " + KUAlchemistsGame.getInstance().getPlayer(currentPlayer).getSickness());
		((PlayerIngs) player_ingr).updateIngs();
		((PlayerArts) player_arts).updateArts();
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
