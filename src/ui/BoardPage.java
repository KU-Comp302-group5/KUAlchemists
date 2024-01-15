package ui;

import javax.imageio.ImageIO;
import javax.swing.*;

import domain.AlchemyMarker;
import domain.ArtListener;
import domain.ArtifactCard;
import domain.Avatar;
import domain.EndListener;
import domain.IngListener;
import domain.Ingredient;
import domain.KUAlchemistsGame;
import domain.PotListener;
import domain.PubListener;
import domain.PublicationTrack;
import domain.Theory;
import domain.TurnListener;
import domain.controllers.HandlerFactory;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class BoardPage extends JFrame implements ActionListener, EndListener {
	
	private static JPanel panelBoard, player1_ingr, player2_ingr, player3_ingr, player4_ingr,
				   player1_arts, player2_arts, player3_arts, player4_arts,
				   player1_pot, player2_pot, player3_pot, player4_pot;
	private static PotionBrew potionBrewing;
	private static PublicationArea publicationArea;
	private static SellPotionPanel sellPotionPanel;
	private static JButton help, pause, deductionBoard, turnButton, ingrDeckButton, player_ing,
	artifactDeckButton, player_art;
	private JLabel gold, gold2, gold3, gold4,
				   sickness, sickness2, sickness3, sickness4,
				   reputation,reputation2, reputation3, reputation4,
				   name, avatar, name2, avatar2, name3, avatar3, name4, avatar4;
				   //p1a_text, p2a_text, p3a_text, p4a_text,
				   //p1i_text, p2i_text, p3i_text, p4i_text
	//private int currentPlayer;
	
	public BoardPage() {
		super("KUAlchemists");
		
		setPanelBoard(new BackgroundPanel("pixil-frame-0.png"));
		getPanelBoard().setLayout(null);
		
		
		help = new JButton("Help");
		pause = new JButton("Pause");
		turnButton = new JButton("Turn");
		ingrDeckButton = new JButton("Ingredient Deck");
		artifactDeckButton = new JButton("Artifacts Deck");
		
		ingrDeckButton.setBounds(140, 320, 150, 50);
		ingrDeckButton.setForeground(Color.BLUE);
		ingrDeckButton.addActionListener(e -> {
        	System.out.println("ingrDeckButton clicked");
        	//System.out.println("curr player before switch turn:" + KUAlchemistsGame.getInstance().getCurrentPlayerNo());
        	HandlerFactory.getInstance().getForageIngHandler().forageIngredient();
        	updateGoldUI();
        	showTurnMessage(KUAlchemistsGame.getInstance().getCurrentPlayer().getUsername() + " foraged an ingredient.");
        	KUAlchemistsGame.getInstance().switchTurns();
        	//System.out.println("curr player after switch turn:" + KUAlchemistsGame.getInstance().getCurrentPlayerNo());
        	revalidate();
        	repaint();
        	
        });
        getPanelBoard().add(ingrDeckButton);
        
		artifactDeckButton.setBounds(310, 320, 150, 50);
		artifactDeckButton.setForeground(Color.BLUE);
		artifactDeckButton.addActionListener(e -> {
        	System.out.println("artifactDeckButton clicked");
        	//again gold UI update without observer
        	HandlerFactory.getInstance().getBuyArtifactHandler().buyArtifact();
        	updateGoldUI();
        	System.out.println(KUAlchemistsGame.getInstance().getCurrentPlayer().getArtifacts());
        	showTurnMessage(KUAlchemistsGame.getInstance().getCurrentPlayer().getUsername() + " bought an artifact.");
        	KUAlchemistsGame.getInstance().switchTurns();
        });
        getPanelBoard().add(artifactDeckButton);
		
        //help.setFont(new Font("Arial", Font.PLAIN, 9));
        help.setMargin(new Insets(0, 0, 0, 0));
        help.setFocusPainted(false);
		help.setBounds(1300, 0, 60, 23);
		help.setForeground(Color.BLACK);
		help.setBackground(Color.WHITE);
		help.addActionListener(e -> showHelpDialog());
		
		getPanelBoard().add(help);
		
		pause.setMargin(new Insets(0, 0, 0, 0));
        pause.setFocusPainted(false);
		pause.setBounds(1370, 0, 60, 23);
		pause.setForeground(Color.BLACK);
		pause.setBackground(Color.WHITE);
		pause.addActionListener(e -> showPauseDialog());
		
		getPanelBoard().add(pause);
		
        potionBrewing = new PotionBrew();
        sellPotionPanel = new SellPotionPanel();
        KUAlchemistsGame.getInstance().addTurnListener(potionBrewing);
        KUAlchemistsGame.getInstance().addTurnListener(sellPotionPanel);
        publicationArea = new PublicationArea();
        //publicationTrack = new JButton("Publication Track");
        deductionBoard = new JButton("Deduction Board");

        int buttonWidth = 200;
        int buttonHeight = 40;
        
        potionBrewing.setBounds(100, 400, 500, 230);
        potionBrewing.setLayout(null);
        potionBrewing.setBackground(Color.BLUE);
        potionBrewing.updatePotionBrew();
        getPanelBoard().add(potionBrewing);
        
        //KUAlchemistsGame.getInstance().getPlayer(1).addIngListener((PotionBrew) potionBrewing);
        //KUAlchemistsGame.getInstance().getPlayer(2).addIngListener((PotionBrew) potionBrewing);
        
        sellPotionPanel.setBounds(100, 630, 500, 230);
        sellPotionPanel.setLayout(null);
        sellPotionPanel.setBackground(Color.GREEN);
        sellPotionPanel.updatePanel();
        getPanelBoard().add(sellPotionPanel);
        
        //KUAlchemistsGame.getInstance().getPlayer(1).addIngListener((SellPotionPanel) sellPotionPanel);
        //KUAlchemistsGame.getInstance().getPlayer(2).addIngListener((SellPotionPanel) sellPotionPanel);

        publicationArea.setBounds(700, 300, 550, 600);
        publicationArea.setLayout(null);
        publicationArea.setBackground(Color.RED);
        publicationArea.updatePublicationArea();
        getPanelBoard().add(publicationArea);
        
        PublicationTrack.getInstance().addPubListener((PublicationArea) publicationArea);
        

        deductionBoard.setBounds(400, 520, buttonWidth, buttonHeight);
        deductionBoard.setForeground(Color.GREEN);
        deductionBoard.addActionListener(e -> {
        	System.out.println("Deduction Board button clicked");
        });
        //getPanelBoard().add(deductionBoard);
        
        
        name = new JLabel("Player I: " + KUAlchemistsGame.getInstance().getPlayer(1).getUsername());
        name.setBounds(125, 20, 200, 15);
        getPanelBoard().add(name);
        
        avatar = new JLabel();
        avatar.setIcon(Avatar.getAvatarImage(KUAlchemistsGame.getInstance().getPlayer(1).getAvatar()));
        avatar.setBounds(135, 40, 60, 60);
        getPanelBoard().add(avatar);
        
        /**
         * Observer pattern should be implemented for updating gold.
         *
         */
        gold = new JLabel("Gold: " + KUAlchemistsGame.getInstance().getPlayer(1).getGold());
        gold.setBounds(58, 95, 60, 30);
        getPanelBoard().add(gold);

        /**
         * Observer pattern should be implemented for updating sickness.
         *
         */
        sickness = new JLabel("Sickness: " + KUAlchemistsGame.getInstance().getPlayer(1).getSickness());
        sickness.setBounds(121, 95, 80, 30);
        getPanelBoard().add(sickness);
        
        reputation = new JLabel("Reputation: " + KUAlchemistsGame.getInstance().getPlayer(1).getReputation());
        reputation.setBounds(203, 95, 80, 30);
        getPanelBoard().add(reputation);
        
        player1_arts = new PlayerArts(1);
		player1_arts.setLayout(null);
		player1_arts.setBounds(55, 120, 250, 60);
		player1_arts.setBackground(Color.ORANGE);
		panelBoard.add(player1_arts);
		((PlayerArts) player1_arts).updateArts();
		
		//KUAlchemistsGame.getInstance().getPlayer(1).addArtListener((PlayerArts) player1_arts);
		KUAlchemistsGame.getInstance().addTurnListener((PlayerArts) player1_arts);
		
		player1_ingr = new PlayerIngs(1);
		player1_ingr.setLayout(null);
		player1_ingr.setBounds(55, 180, 250, 60);
		player1_ingr.setBackground(Color.MAGENTA);
		panelBoard.add(player1_ingr);
		((PlayerIngs) player1_ingr).updateIngs();
		
		//KUAlchemistsGame.getInstance().getPlayer(1).addIngListener((PlayerIngs) player1_ingr);
		KUAlchemistsGame.getInstance().addTurnListener((PlayerIngs) player1_ingr);
		
		player1_pot = new PlayerPot(1);
		player1_pot.setLayout(null);
		player1_pot.setBounds(55, 240, 250, 60);
		player1_pot.setBackground(Color.MAGENTA);
		panelBoard.add(player1_pot);
		((PlayerPot) player1_pot).updatePot();
		
		KUAlchemistsGame.getInstance().getPlayer(1).addPotListener((PlayerPot) player1_pot);
		
        name2 = new JLabel("Player II: " + KUAlchemistsGame.getInstance().getPlayer(2).getUsername());
        name2.setBounds(425, 20, 200, 15);
        getPanelBoard().add(name2);
        
        avatar2 = new JLabel();
        avatar2.setIcon(Avatar.getAvatarImage(KUAlchemistsGame.getInstance().getPlayer(2).getAvatar()));
        avatar2.setBounds(435, 40, 60, 60);
        getPanelBoard().add(avatar2);
        
        gold2 = new JLabel("Gold: " + KUAlchemistsGame.getInstance().getPlayer(2).getGold());
        gold2.setBounds(358, 95, 60, 30);
        getPanelBoard().add(gold2);
        
        sickness2 = new JLabel("Sickness: " + KUAlchemistsGame.getInstance().getPlayer(2).getSickness());
        sickness2.setBounds(421, 95, 80, 30);
        getPanelBoard().add(sickness2);
        
        reputation2 = new JLabel("Reputation: " + KUAlchemistsGame.getInstance().getPlayer(2).getReputation());
        reputation2.setBounds(503, 95, 80, 30);
        getPanelBoard().add(reputation2);
        
		player2_arts = new PlayerArts(2);
		player2_arts.setLayout(null);
		player2_arts.setBounds(355, 120, 250, 60);
		player2_arts.setBackground(Color.ORANGE);
		panelBoard.add(player2_arts);
		((PlayerArts) player2_arts).updateArts();

		//KUAlchemistsGame.getInstance().getPlayer(2).addArtListener((PlayerArts) player2_arts);
		KUAlchemistsGame.getInstance().addTurnListener((PlayerArts) player2_arts);
		
		player2_ingr = new PlayerIngs(2);
		player2_ingr.setLayout(null);
		player2_ingr.setBounds(355, 180, 250, 60);
		player2_ingr.setBackground(Color.MAGENTA);
		panelBoard.add(player2_ingr);
		((PlayerIngs) player2_ingr).updateIngs();

		//KUAlchemistsGame.getInstance().getPlayer(2).addIngListener((PlayerIngs) player2_ingr);
		KUAlchemistsGame.getInstance().addTurnListener((PlayerIngs) player2_ingr);
		
		player2_pot = new PlayerPot(2);
		player2_pot.setLayout(null);
		player2_pot.setBounds(355, 240, 250, 60);
		player2_pot.setBackground(Color.MAGENTA);
		panelBoard.add(player2_pot);
		((PlayerPot) player2_pot).updatePot();
		
		KUAlchemistsGame.getInstance().getPlayer(2).addPotListener((PlayerPot) player2_pot);
        
        if(LoginPage.playerNum==3) {
        	showPlayer3();
        	//KUAlchemistsGame.getInstance().getPlayer(3).addIngListener((PotionBrew) potionBrewing);
        	//KUAlchemistsGame.getInstance().getPlayer(3).addIngListener((SellPotionPanel) sellPotionPanel);
        }
        
        if(LoginPage.playerNum==4) {
        	showPlayer3();
        	showPlayer4();
        	//KUAlchemistsGame.getInstance().getPlayer(4).addIngListener((PotionBrew) potionBrewing);
        	//KUAlchemistsGame.getInstance().getPlayer(4).addIngListener((SellPotionPanel) sellPotionPanel);
        }
        


        
  
        //Just added to show turn of players able to change. Just for demonstration.
//        turnButton.setMargin(new Insets(0, 0, 0, 0));
//        turnButton.setFocusPainted(false);
//		turnButton.setBounds(400, 0, 50, 20);
//		turnButton.addActionListener(e -> {
//			KUAlchemistsGame.getInstance().switchTurns();
//		});
//		//getPanelBoard().add(turnButton);
		
		JButton dBoardButton = new JButton("Deduction Board");
		dBoardButton.setBounds(500, 750, 150, 50);
		dBoardButton.addActionListener(e -> {
			DeductionBoardDialog dialog = new DeductionBoardDialog(this);
			dialog.setLayout(null);
			HandlerFactory.getInstance().getDeductionBoardHandler().addListener(dialog);
			dialog.setSize(500,800);
			dialog.setVisible(true);
        });
        getPanelBoard().add(dBoardButton);
		
		
	}
	
	
	@Override
	public void onEndChange() {
		// Create the dialog
	    JDialog endGameDialog = new JDialog();
	    endGameDialog.setTitle("End Game");
	    endGameDialog.setSize(300, 150);
	    endGameDialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
	    endGameDialog.setLayout(new BorderLayout());
	    endGameDialog.setLocationRelativeTo(null);
	    endGameDialog.setModal(true);

	    // Create a label for the message
	    JLabel messageLabel = new JLabel("End of the game.");
	    endGameDialog.add(messageLabel, BorderLayout.CENTER);

	    // Create a button to exit the program
	    JButton exitButton = new JButton("Exit");
	    exitButton.addActionListener(e -> {
	        System.exit(0); // Terminate program execution
	    });

	    // Add the exit button to the dialog
	    JPanel buttonPanel = new JPanel();
	    buttonPanel.add(exitButton);
	    endGameDialog.add(buttonPanel, BorderLayout.SOUTH);

	    // Make the dialog visible
	    endGameDialog.setVisible(true);
		
	}
	
	
	private void updateGoldUI() {
		int currentPlayer = KUAlchemistsGame.getInstance().getCurrentPlayerNo();
		if (currentPlayer==1) {
			gold.setText("Gold: " + KUAlchemistsGame.getInstance().getPlayer(1).getGold());
		}
		if (currentPlayer==2) {
			gold2.setText("Gold: " + KUAlchemistsGame.getInstance().getPlayer(2).getGold());
		}
		if (currentPlayer==3) {
			gold3.setText("Gold: " + KUAlchemistsGame.getInstance().getPlayer(3).getGold());
		}
		if (currentPlayer==4) {
			gold4.setText("Gold: " + KUAlchemistsGame.getInstance().getPlayer(4).getGold());
		}
	}
	
	private void updateReputationUI() {
		int currentPlayer = KUAlchemistsGame.getInstance().getCurrentPlayerNo();
		if (currentPlayer==1) {
			reputation.setText("Reputation: " + KUAlchemistsGame.getInstance().getPlayer(1).getReputation());
		}
		if (currentPlayer==2) {
			reputation2.setText("Reputation: " + KUAlchemistsGame.getInstance().getPlayer(2).getReputation());
		}
		if (currentPlayer==3) {
			reputation3.setText("Reputation: " + KUAlchemistsGame.getInstance().getPlayer(3).getReputation());
		}
		if (currentPlayer==4) {
			reputation4.setText("Reputation: " + KUAlchemistsGame.getInstance().getPlayer(4).getReputation());
		}
	}
	
	private void updateSicknessUI() {
		int currentPlayer = KUAlchemistsGame.getInstance().getCurrentPlayerNo();
		if (currentPlayer==1) {
			sickness.setText("Sickness: " + KUAlchemistsGame.getInstance().getPlayer(1).getSickness());
		}
		if (currentPlayer==2) {
			sickness2.setText("Sickness: " + KUAlchemistsGame.getInstance().getPlayer(2).getSickness());
		}
		if (currentPlayer==3) {
			sickness3.setText("Sickness: " + KUAlchemistsGame.getInstance().getPlayer(3).getSickness());
		}
		if (currentPlayer==4) {
			sickness4.setText("Sickness: " + KUAlchemistsGame.getInstance().getPlayer(4).getSickness());
		}
	}

	public void showPlayer3() {
        name3 = new JLabel("Player III: " + KUAlchemistsGame.getInstance().getPlayer(3).getUsername());
        name3.setBounds(725, 20, 200, 15);
        getPanelBoard().add(name3);
        
        avatar3 = new JLabel();
        avatar3.setIcon(Avatar.getAvatarImage(KUAlchemistsGame.getInstance().getPlayer(3).getAvatar()));
        avatar3.setBounds(735, 40, 60, 60);
        getPanelBoard().add(avatar3);
        
        gold3 = new JLabel("Gold: " + KUAlchemistsGame.getInstance().getPlayer(3).getGold());
        gold3.setBounds(658, 95, 60, 30);
        getPanelBoard().add(gold3);
        
        sickness3 = new JLabel("Sickness: " + KUAlchemistsGame.getInstance().getPlayer(3).getSickness());
        sickness3.setBounds(721, 95, 80, 30);
        getPanelBoard().add(sickness3);
        
        reputation3 = new JLabel("Reputation: " + KUAlchemistsGame.getInstance().getPlayer(3).getReputation());
        reputation3.setBounds(803, 95, 80, 30);
        getPanelBoard().add(reputation3);
        
		player3_arts = new PlayerArts(3);
		player3_arts.setLayout(null);
		player3_arts.setBounds(655, 120, 240, 60);
		player3_arts.setBackground(Color.ORANGE);
		panelBoard.add(player3_arts);
		((PlayerArts) player3_arts).updateArts();
		
		//KUAlchemistsGame.getInstance().getPlayer(3).addArtListener((PlayerArts) player3_arts);
		KUAlchemistsGame.getInstance().addTurnListener((PlayerArts) player3_arts);
		
		player3_ingr = new PlayerIngs(3);
		player3_ingr.setLayout(null);
		player3_ingr.setBounds(655, 180, 240, 60);
		player3_ingr.setBackground(Color.MAGENTA);
		panelBoard.add(player3_ingr);
		((PlayerIngs) player3_ingr).updateIngs();
		
		//KUAlchemistsGame.getInstance().getPlayer(3).addIngListener((PlayerIngs) player3_ingr);
		KUAlchemistsGame.getInstance().addTurnListener((PlayerIngs) player3_ingr);
		
		player3_pot = new PlayerPot(3);
		player3_pot.setLayout(null);
		player3_pot.setBounds(655, 240, 250, 60);
		player3_pot.setBackground(Color.MAGENTA);
		panelBoard.add(player3_pot);
		((PlayerPot) player3_pot).updatePot();
		
		KUAlchemistsGame.getInstance().getPlayer(3).addPotListener((PlayerPot) player3_pot);
		
	}
	
	public void showPlayer4() {
        name4 = new JLabel("Player IV: " + KUAlchemistsGame.getInstance().getPlayer(4).getUsername());
        name4.setBounds(1025, 20, 200, 15);
        getPanelBoard().add(name4);
        
        avatar4 = new JLabel();
        avatar4.setIcon(Avatar.getAvatarImage(KUAlchemistsGame.getInstance().getPlayer(4).getAvatar()));
        avatar4.setBounds(1035, 40, 60, 60);
        getPanelBoard().add(avatar4);
        
        gold4 = new JLabel("Gold: " + KUAlchemistsGame.getInstance().getPlayer(4).getGold());
        gold4.setBounds(958, 95, 60, 30);
        getPanelBoard().add(gold4);
        
        sickness4 = new JLabel("Sickness: " + KUAlchemistsGame.getInstance().getPlayer(4).getSickness());
        sickness4.setBounds(1021, 95, 80, 30);
        getPanelBoard().add(sickness4);
        
        reputation4 = new JLabel("Reputation: " + KUAlchemistsGame.getInstance().getPlayer(4).getReputation());
        reputation4.setBounds(1103, 95, 80, 30);
        getPanelBoard().add(reputation4);
        
        player4_arts = new PlayerArts(4);
        player4_arts.setLayout(null);
		player4_arts.setBounds(955, 120, 240, 60);
		player4_arts.setBackground(Color.ORANGE);
		panelBoard.add(player4_arts);
		((PlayerArts) player4_arts).updateArts();
		
		//KUAlchemistsGame.getInstance().getPlayer(4).addArtListener((PlayerArts) player4_arts);
		KUAlchemistsGame.getInstance().addTurnListener((PlayerArts) player4_arts);
		
		player4_ingr = new PlayerIngs(4);
		player4_ingr.setLayout(null);
		player4_ingr.setBounds(955, 180, 240, 60);
		player4_ingr.setBackground(Color.MAGENTA);
		panelBoard.add(player4_ingr);
		((PlayerIngs) player4_ingr).updateIngs();
		
		//KUAlchemistsGame.getInstance().getPlayer(4).addIngListener((PlayerIngs) player4_ingr);
		KUAlchemistsGame.getInstance().addTurnListener((PlayerIngs) player4_ingr);
		
		player4_pot = new PlayerPot(4);
		player4_pot.setLayout(null);
		player4_pot.setBounds(955, 240, 250, 60);
		player4_pot.setBackground(Color.MAGENTA);
		panelBoard.add(player4_pot);
		((PlayerPot) player4_pot).updatePot();
		
		KUAlchemistsGame.getInstance().getPlayer(4).addPotListener((PlayerPot) player4_pot);
	}
	
	
	/**
     * Observer pattern.
     *
     * Inner class implementing ArtListener for PlayerArts
     */
    private class PlayerArts extends JPanel implements TurnListener {
    	
    	private int playerNum;
    	private Window parentWindow; //  = SwingUtilities.getWindowAncestor(this);
        
    	public PlayerArts(int playerNum) {
			super();
			this.playerNum = playerNum;
			this.parentWindow = SwingUtilities.getWindowAncestor(this);
		}

		public void updateArts() {
    		this.removeAll();
    		
    		JLabel pa_text = new JLabel("Player " + playerNum + "'s Artifacts: ");
    		pa_text.setBounds(10, 5, 200, 20);
            this.add(pa_text);
            
            for (int i=0; i<KUAlchemistsGame.getInstance().getPlayer(playerNum).getArtifacts().size(); i++) {
    			
    			JButton player_art = new JButton(KUAlchemistsGame.getInstance().getPlayer(playerNum).getArtifacts().get(i).toString());
    			player_art.setBounds(10, 20+9*i, 60, 30); // should change
    			this.add(player_art);
    			int temp = i;
    			
    			// if the artifact requires immediate user interaction through panel, such as elixir of insight
    			if (KUAlchemistsGame.getInstance().getPlayer(playerNum).getArtifacts().get(temp).getHasPanel()) {
    				
    				// elixir of insight
    				if (KUAlchemistsGame.getInstance().getPlayer(playerNum).getArtifacts().get(temp).getID() == 0) {
    					player_art.addActionListener(e -> {
    						System.out.println("Elixir of Insight Artifact is used");
    						// to set the behavior (strategy) of UseArtifactHandler and to remove artifact card from player's list
    						HandlerFactory.getInstance().getUseArtifactHandler().useArtifact(KUAlchemistsGame.getInstance().getPlayer(playerNum).getArtifacts().get(temp));
    						
	    					ElixirOfInsightDialog dialog = new ElixirOfInsightDialog((Frame) this.parentWindow);
	    					dialog.add(dialog.getPanelArtifact());
	    					dialog.setSize(600,350);
	    					
	    					dialog.setVisible(true);
	    					
	    					//panel.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	    					showTurnMessage(KUAlchemistsGame.getInstance().getCurrentPlayer().getUsername() + " used an artifact.");
	    					KUAlchemistsGame.getInstance().switchTurns();
    					});
    				}
    			}
    			else {
    				player_art.addActionListener(e -> {
                    	System.out.println("This artifact cannot be used now!");
                    	JOptionPane.showMessageDialog(this.parentWindow,"This artifact cannot be used now!");  
                    });
    			}    			
                
    		}
    		revalidate();  //need to revise
    		repaint();  //need to revise
    	}
        
        @Override
    	public void onTurnChange() {
    		updateArts();
    	}
    }
    
    
    /**
     * Observer pattern.
     *
     * Inner class implementing IngListener for PlayerIngs.
     */
    private class PlayerIngs extends JPanel implements TurnListener {
    	
    	private int playerNum;

    	public PlayerIngs(int playerNum) {
			super();
			this.playerNum = playerNum;
		}

		public void updateIngs() {
			
    		this.removeAll();
    		
            JLabel pi_text = new JLabel("Player " + playerNum + "'s Ingredients:");
            pi_text.setBounds(10, 5, 200, 20);
            this.add(pi_text);
            
            for (int i = 0; i < KUAlchemistsGame.getInstance().getPlayer(playerNum).getIngredients().size(); i++) {
                JButton player_ing = new JButton(KUAlchemistsGame.getInstance().getPlayer(playerNum).getIngredients().get(i).toString());
                player_ing.setBounds(10, 20+9*i, 80, 30);
                this.add(player_ing);
                player_ing.addActionListener(e -> {
                	System.out.println("Ingredient is transmuted.");
                	HandlerFactory.getInstance().getTransmuteIngHandler().transmuteIngredient(KUAlchemistsGame.getInstance().getPlayer(playerNum));
                    gold.setText("Gold: " + KUAlchemistsGame.getInstance().getPlayer(playerNum).getGold());
                    showTurnMessage(KUAlchemistsGame.getInstance().getCurrentPlayer().getUsername() + " transmuted an ingredient.");
                    KUAlchemistsGame.getInstance().switchTurns();
                });
            }
            this.revalidate();  //need to revise
            this.repaint();  //need to revise
    	}
    	
		@Override
		public void onTurnChange() {
			System.out.println("updating playering on ing change");
			updateIngs();
		}
    }
    
    /**
     * Observer pattern.
     *
     * Inner class implementing PotListener for PlayerPot.
     */
    private class PlayerPot extends JPanel implements PotListener {
    	
    	private int playerNum;

    	public PlayerPot(int playerNum) {
			super();
			this.playerNum = playerNum;
		}

		public void updatePot() {
			
    		this.removeAll();
    		
            JLabel pi_text = new JLabel("Player " + playerNum + "'s Potions:");
            pi_text.setBounds(10, 5, 200, 20);
            this.add(pi_text);
            
            for (int i = 0; i < KUAlchemistsGame.getInstance().getPlayer(playerNum).getPotions().size(); i++) {
            	
            	String str = null;
            	switch (KUAlchemistsGame.getInstance().getPlayer(playerNum).getPotions().get(i).getQuality()) {
            	case 1: 
            		str="positive";
            		break;
            	case -1:
            		str="negative";
            		break;
            	case 0:
            		str="neutral";
            		break;
            	}
            	
                JLabel player_ing = new JLabel(str);
                player_ing.setBounds(10, 20+9*i, 200, 30);
                this.add(player_ing);
            }
            this.revalidate();  //need to revise
            this.repaint();  //need to revise
    	}
    	
		@Override
		public void onPotChange() {
			updatePot();
		}
    }
    
//    

private class PotionBrew extends JPanel implements TurnListener, ItemListener {
    	
    	ArrayList<JCheckBox> checkboxes;
    	ArrayList<JCheckBox> clickedcheckboxes;
    	ArrayList<Integer> ingrindex;
    	JButton makeExpBtn;
    	JRadioButton testBtn1;
    	JRadioButton testBtn2;
    	JLabel test;
    	private Window parentWindow; //  = SwingUtilities.getWindowAncestor(this);
        
    	public void updatePotionBrew() {
    		this.parentWindow = SwingUtilities.getWindowAncestor(this);
    		this.removeAll();
    		
    		JLabel pa_text = new JLabel("Available Ingredients: ");
    		pa_text.setBounds(10, 5, 200, 20);
            this.add(pa_text);
            
            test = new JLabel("Test on: ");
    		test.setBounds(230, 15, 200, 20);
            this.add(test);
            test.setVisible(false);
            
        	testBtn1= new JRadioButton("Yourself");
        	testBtn1.setBounds(230, 45, 200, 20);
        	testBtn1.addItemListener(this);
        	this.add(testBtn1);
        	testBtn1.setVisible(false);
        	
        	testBtn2= new JRadioButton("Student");
        	testBtn2.setBounds(230, 75, 200, 20);
        	testBtn2.addItemListener(this);
        	this.add(testBtn2);
        	testBtn2.setVisible(false);
        	
        	ButtonGroup testgroup = new ButtonGroup();
        	
        	testgroup.add(testBtn1);
        	testgroup.add(testBtn2);
        	
            makeExpBtn = new JButton("Make Experiment");
            makeExpBtn.setBounds(140, 160, 150, 30);
            this.add(makeExpBtn);
            makeExpBtn.setVisible(false);
            makeExpBtn.addActionListener(e -> {
            	System.out.println("Experiment button in UI");
            	String str = null;
            	if (testBtn1.isSelected()) {
            		str = "yourself";
            	}
            	if(testBtn2.isSelected()) {
            		str = "student";
            	}
            	HandlerFactory.getInstance().getMakeExperimentHandler().makeExperiment(
            			KUAlchemistsGame.getInstance().getCurrentPlayer().getIngredients().get(ingrindex.get(0)),
            			KUAlchemistsGame.getInstance().getCurrentPlayer().getIngredients().get(ingrindex.get(1)),
            			str, KUAlchemistsGame.getInstance().getCurrentPlayer());
            	
            	
            	// if the player has magic mortar card
            	if (KUAlchemistsGame.getInstance().getCurrentPlayer().getArtifacts().contains(new ArtifactCard("Magic Mortar", 2, false))){
            		// TO DO
            		// show MagicMortarDialog to take input from user
            		// MagicMortarDialog takes which ingredient the user wants to be not discarded
            		System.out.println("magic mortar used");
            		HandlerFactory.getInstance().getUseArtifactHandler().useArtifact(new ArtifactCard("Magic Mortar", 2, false));
            		MagicMortarDialog dialog = new MagicMortarDialog((Frame) this.parentWindow);
					dialog.add(dialog.getPanelArtifact());
					dialog.setSize(600,600);
					dialog.setVisible(true);
            	}
            	
            	updateGoldUI();
            	updateSicknessUI();
            	showTurnMessage(KUAlchemistsGame.getInstance().getCurrentPlayer().getUsername() + " made an experiment.");
                KUAlchemistsGame.getInstance().switchTurns();
            });
            
            checkboxes = new ArrayList<JCheckBox>();
            clickedcheckboxes = new ArrayList<JCheckBox>();
            ingrindex = new ArrayList<Integer>();
            
            for (int i=0; i<KUAlchemistsGame.getInstance().getCurrentPlayer().getIngredients().size(); i++) {
    			
    			JCheckBox player_ing = new JCheckBox(KUAlchemistsGame.getInstance().getCurrentPlayer().getIngredients().get(i).toString());
    			player_ing.setBounds(20, 30 + 30 * i, 200, 20); // should change
    			checkboxes.add(player_ing);
    			this.add(player_ing);
                player_ing.addItemListener(this);
                
    		}
            revalidate();
            repaint();
    	
    	}
    	
		@Override
		public void onTurnChange() {
			updatePotionBrew();
		}


		@Override
		public void itemStateChanged(ItemEvent e) {
			// TODO Auto-generated method stub
			if(checkboxes.contains(e.getSource())) {
				if (e.getStateChange() == 1) {
					System.out.println(ingrindex.toString());
					System.out.println(checkboxes.size());
					
					if (ingrindex.size()==2){
						JCheckBox temp = clickedcheckboxes.get(0);
						clickedcheckboxes.remove(0);
						ingrindex.remove(0);
						temp.setSelected(false);
						
					}
					
					ingrindex.add(checkboxes.indexOf(e.getSource()));
					clickedcheckboxes.add((JCheckBox) e.getSource());
					
					if(ingrindex.size()==2) {
						testBtn1.setVisible(true);
						testBtn2.setVisible(true);
						test.setVisible(true);
					}
				}
				else {
					System.out.println(ingrindex.toString());
					if(clickedcheckboxes.contains(e.getSource())) {
						ingrindex.remove(clickedcheckboxes.indexOf(e.getSource()));
						clickedcheckboxes.remove(e.getSource());
						if(ingrindex.size()!=2) {
							testBtn1.setVisible(false);
							testBtn2.setVisible(false);
							test.setVisible(false);
							makeExpBtn.setVisible(false);
						}
					}
				}
			}
			if (e.getSource()== testBtn1 || e.getSource()==testBtn2) {
				if (ingrindex.size()==2) {
					makeExpBtn.setVisible(true);
				}
			}
			
		}
    
    }
    
    private class SellPotionPanel extends JPanel implements ItemListener, TurnListener {
    	
    	ArrayList<JCheckBox> checkboxes;
    	ArrayList<JCheckBox> clickedcheckboxes;
    	ArrayList<Integer> ingrindex;
    	JButton sellPotBtn;
    	JRadioButton predBtn1;
    	JRadioButton predBtn2;
    	JRadioButton predBtn3;
    	JLabel pred;

		
    	public void updatePanel() {
			
    		this.removeAll();
    		
    		JLabel pa_text = new JLabel("Available Ingredients: ");
    		pa_text.setBounds(10, 5, 200, 20);
            this.add(pa_text);
            
            pred = new JLabel("Make prediction: ");
    		pred.setBounds(230, 15, 200, 20);
            this.add(pred);
            pred.setVisible(false);
            
            //button for positive prediction
            predBtn1= new JRadioButton("Positive");
            predBtn1.setBounds(230, 45, 200, 20);
            predBtn1.addItemListener(this);
        	this.add(predBtn1);
        	predBtn1.setVisible(false);
        	
        	//button for positive/neutral prediction
        	predBtn2= new JRadioButton("Positive/Neutral");
        	predBtn2.setBounds(230, 75, 200, 20);
        	predBtn2.addItemListener(this);
        	this.add(predBtn2);
        	predBtn2.setVisible(false);
        	
        	//button for 'may be negative' prediction
        	predBtn3= new JRadioButton("May be Negative");
        	predBtn3.setBounds(230, 105, 200, 20);
        	predBtn3.addItemListener(this);
        	this.add(predBtn3);
        	predBtn3.setVisible(false);
        	
        	ButtonGroup testgroup = new ButtonGroup();
        	
        	testgroup.add(predBtn1);
        	testgroup.add(predBtn2);
        	testgroup.add(predBtn3);
        	
        	//final button to perform the sale of the potion
        	sellPotBtn = new JButton("Sell Potion");
        	sellPotBtn.setBounds(140, 160, 150, 30);
            this.add(sellPotBtn);
            sellPotBtn.setVisible(false);
            
            //when 'sell potion' button is pressed
            sellPotBtn.addActionListener(e -> {
            	System.out.println("SellPotion button in UI");
            	
            	int prediction = 9999;
            	
            	if (predBtn1.isSelected()) { //positive prediction
            		prediction = 1;
            	}
            	if(predBtn2.isSelected()) { //positive/neutral
            		prediction = 0;
            	}
            	if(predBtn3.isSelected()) { //'may be negative' prediction
            		prediction = -1;
            	}
            	
            	//transmit the massage to the specific controller
            	HandlerFactory.getInstance().getSellPotionHandler().sellPotion(
            			KUAlchemistsGame.getInstance().getCurrentPlayer().getIngredients().get(ingrindex.get(0)),
            			KUAlchemistsGame.getInstance().getCurrentPlayer().getIngredients().get(ingrindex.get(1)),
            			prediction, KUAlchemistsGame.getInstance().getCurrentPlayer());
            	updateGoldUI();
            	updateReputationUI();
            	
            	showTurnMessage(KUAlchemistsGame.getInstance().getCurrentPlayer().getUsername() + " made a potion sale.");
                KUAlchemistsGame.getInstance().switchTurns();
            });
            
            checkboxes = new ArrayList<JCheckBox>(); //keeps all the ingredients
            clickedcheckboxes = new ArrayList<JCheckBox>(); //keeps the chosen ingredients
            ingrindex = new ArrayList<Integer>(); //keeps the indices of the chosen ingredients in the player's ingredient list
            
            for (int i=0; i<KUAlchemistsGame.getInstance().getCurrentPlayer().getIngredients().size(); i++) {
    			
    			JCheckBox player_ing = new JCheckBox(KUAlchemistsGame.getInstance().getCurrentPlayer().getIngredients().get(i).toString());
    			player_ing.setBounds(20, 30 + 30 * i, 200, 20); // should change
    			checkboxes.add(player_ing);
    			this.add(player_ing);
                player_ing.addItemListener(this);
                
    		}
            revalidate();
            repaint();
    	
    	}
    	
    	@Override
    	public void onTurnChange() {
    		updatePanel();
    	};
    	

		@Override
		public void itemStateChanged(ItemEvent e) {
			// TODO Auto-generated method stub
			if(checkboxes.contains(e.getSource())) { //source of change is one of the checkboxes
				if (e.getStateChange() == 1) { //the checkbox is selected
					
					if (ingrindex.size()==2){ //two ingredients were already chosen
						JCheckBox temp = clickedcheckboxes.get(0);
						clickedcheckboxes.remove(0); //discard the first chosen ingredient
						ingrindex.remove(0); //discard the index of the first chosen ingredient
						temp.setSelected(false); //discard the first chosen ingredient
						
					}
					
					ingrindex.add(checkboxes.indexOf(e.getSource())); //add the index of the new chosen ingredient
					clickedcheckboxes.add((JCheckBox) e.getSource()); //add the new chosen ingredient
					
					if(ingrindex.size()==2) { //two ingredients are chosen --> show the prediction buttons
						predBtn1.setVisible(true);
						predBtn2.setVisible(true);
						predBtn3.setVisible(true);
						pred.setVisible(true);
					}
				}
				
				else { //the checkbox is deselected
					if(clickedcheckboxes.contains(e.getSource())) {
						ingrindex.remove(clickedcheckboxes.indexOf(e.getSource())); //discard the deselected ingredient's index
						clickedcheckboxes.remove(e.getSource()); //discard the deselected ingredient
						
						//number of selected ingredients is lower than 2 --> hide the prediction + 'sell potion' buttons
						if(ingrindex.size()!=2) {
							predBtn1.setVisible(false);
							predBtn2.setVisible(false);
							predBtn3.setVisible(false);
							pred.setVisible(false);
							sellPotBtn.setVisible(false);
						}
					}
				}
			}
			
			//source of change is one of the prediction buttons
			if (e.getSource()== predBtn1 || e.getSource()==predBtn2 || e.getSource()==predBtn3) {
				
				if (ingrindex.size()==2) { //two ingredients are chosen --> show the final sell potion button
					sellPotBtn.setVisible(true);
				}
			}
			
		}
    
    }
    
    
    
    
    /**
     * Already published theories needs be made visible for debunking.
     *
     * 
     */
    private class PublicationArea extends JPanel implements PubListener, ItemListener {
    	
    	List<JRadioButton> theoryButtons;
    	JButton debunkBtn;
    	List<JRadioButton> aspectButtons;
    	
    	public void updatePublicationArea() {
    		
    		this.removeAll();
    		
    		JLabel marker_text = new JLabel("Ingredients: ");
    		marker_text.setBounds(10, 5, 100, 20);
            this.add(marker_text);
            
            JLabel ingr_text = new JLabel("Alchemy Marker: ");
    		ingr_text.setBounds(160, 5, 200, 20);
            this.add(ingr_text);
            
            //label of the new area for published theories
            JLabel theory_text = new JLabel("Publications: ");
    		theory_text.setBounds(310, 5, 200, 20);
            this.add(theory_text);
            
            ButtonGroup ingrGroup = new ButtonGroup();
            ButtonGroup markerGroup = new ButtonGroup();
            ButtonGroup theoryGroup = new ButtonGroup();
            ButtonGroup aspectGroup = new ButtonGroup();
            
            List<Ingredient> ingrs = HandlerFactory.getInstance().getPublicationHandler().getAvailableIngredients();
            
            for (int i=0; i<ingrs.size(); i++) {
            	
            	JRadioButton ingrBtn= new JRadioButton(ingrs.get(i).getName());
            	ingrBtn.setBounds(10, 30 + 30*i, 100, 20);
            	ingrBtn.addItemListener(this);
            	ingrGroup.add(ingrBtn);
            	this.add(ingrBtn);
            	ingrBtn.setVisible(true);
            }
            
            List<AlchemyMarker> markers = HandlerFactory.getInstance().getPublicationHandler().getAvailableAlchemies();
            
            for (int i=0; i<markers.size(); i++) {
            	//Integer.toString(markers.get(i).getID())
            	JRadioButton markerBtn= new JRadioButton();
            	markerBtn.setIcon(new ImageIcon(markers.get(i).getImage()));
            	markerBtn.setBounds(160, 30 + 60*i, markerBtn.getIcon().getIconWidth(), markerBtn.getIcon().getIconHeight());
            	markerBtn.setMargin(new Insets(0,0,0,0));
            	markerBtn.addItemListener(this);
            	markerGroup.add(markerBtn);
            	this.add(markerBtn);
            	markerBtn.setVisible(true);
            }
            
            List<Theory> theories = HandlerFactory.getInstance().getPublicationHandler().getPublishedTheories();
            
            theoryButtons = new ArrayList<JRadioButton>();
            		
            for (int i=0; i<theories.size(); i++) {
            	
            	JRadioButton theoryBtn = new JRadioButton(theories.get(i).getIngredient().getName() + " --> " + Integer.toString(theories.get(i).getMarker().getID()));
            	theoryButtons.add(theoryBtn);
            	theoryBtn.setBounds(310, 30 + 30*i, 200, 20);
            	theoryBtn.addItemListener(this);
            	theoryGroup.add(theoryBtn);
            	this.add(theoryBtn);
            	theoryBtn.setVisible(true);
            	
            }

    		aspectButtons = new ArrayList<JRadioButton>();
    		
            JRadioButton as1 = new JRadioButton("Red");
            aspectButtons.add(as1);
            as1.setBounds(290, 240, 50, 20);
            as1.addItemListener(this);
            aspectGroup.add(as1);
            this.add(as1);
            as1.setVisible(false);
            
    		JRadioButton as2 = new JRadioButton("Green");
    		aspectButtons.add(as2);
    		as2.setBounds(345, 240, 65, 20);
    		as2.addItemListener(this);
    		aspectGroup.add(as2);
    		this.add(as2);
    		as2.setVisible(false);
    		
    		JRadioButton as3 = new JRadioButton("Blue");
    		aspectButtons.add(as3);
    		as3.setBounds(415, 240, 60, 20);
    		as3.addItemListener(this);
    		aspectGroup.add(as3);
    		this.add(as3);
    		as3.setVisible(false);
    		
            JButton publishBtn = new JButton("Publish Theory");
            publishBtn.setBounds(100, 270, 150, 20);
            this.add(publishBtn);
            publishBtn.setVisible(true);
            publishBtn.addActionListener(e -> {
            	System.out.println("Publish button in UI");
            	String ingrName = null;
            	String markerName = null;
            	
            	
            	for (Enumeration<AbstractButton> buttons = ingrGroup.getElements(); buttons.hasMoreElements();) {
                    AbstractButton button = buttons.nextElement();

                    if (button.isSelected()) {
                         ingrName = button.getText();
                    }
                }
            	
            	for (Enumeration<AbstractButton> buttons = markerGroup.getElements(); buttons.hasMoreElements();) {
                    AbstractButton button = buttons.nextElement();

                    if (button.isSelected()) {
                         markerName = button.getText();
                    }
                }
            	
            	HandlerFactory.getInstance().getPublicationHandler().makePublication(ingrName, markerName, KUAlchemistsGame.getInstance().getCurrentPlayerNo());
            	updateGoldUI();
            	updateReputationUI();
            	showTurnMessage(KUAlchemistsGame.getInstance().getCurrentPlayer().getUsername() + " made a publication.");
                KUAlchemistsGame.getInstance().switchTurns();
            });
            
            debunkBtn = new JButton("Debunk");
            debunkBtn.setBounds(310, 270, 150, 20);
            this.add(debunkBtn);
            debunkBtn.setVisible(false);
            debunkBtn.addActionListener(e -> {
            	System.out.println("Debunk button in UI");
            	
            	int theoryIndex = -1;
            	int aspectIndex = -1;
            	
            	for (JRadioButton theoryBtn : theoryButtons) {
            		if (theoryBtn.isSelected()) {
            			theoryIndex = theoryButtons.indexOf(theoryBtn); 
            		}
            	}
            	
            	for (JRadioButton as : aspectButtons) {
            		if (as.isSelected()) {
            			aspectIndex = aspectButtons.indexOf(as); 
            		}
            	}
            	
            	String aspect = null;
            	String aspectSign = null;
            	
            	if (aspectIndex==0) {
            		aspect = "Red Aspect:";
            		if (theories.get(theoryIndex).getIngredient().getRedAspect().isSign()) {
            			aspectSign = "+";
            		}
            		else {
            			aspectSign = "-";
            		}
            	}
            	if (aspectIndex==1) {
            		aspect = "Green Aspect:";
            		if (theories.get(theoryIndex).getIngredient().getGreenAspect().isSign()) {
            			aspectSign = "+";
            		}
            		else {
            			aspectSign = "-";
            		}
            	}
            	if (aspectIndex==2) {
            		aspect = "Blue Aspect:";
            		if (theories.get(theoryIndex).getIngredient().getBlueAspect().isSign()) {
            			aspectSign = "+";
            		}
            		else {
            			aspectSign = "-";
            		}
            	}
            	
            	//theoryButtons.get(theoryIndex).setText(theoryButtons.get(theoryIndex).getText() + " " + aspect +
            			//aspectSign);
            	
            	String ingrName = theories.get(theoryIndex).getIngredient().getName();
            	
            	HandlerFactory.getInstance().getPublicationHandler().debunkTheory(theories.get(theoryIndex), aspectIndex + 1,
            			KUAlchemistsGame.getInstance().getCurrentPlayerNo());
            	
            	updateReputationUI();
            	
            	showTurnMessage(KUAlchemistsGame.getInstance().getCurrentPlayer().getUsername() + " made a debunk." + " "
            	+ ingrName + "'s" + " " + aspect + aspectSign);
                KUAlchemistsGame.getInstance().switchTurns();
            });
    		
    		revalidate();
            repaint();
    	}

		@Override
		public void itemStateChanged(ItemEvent e) {
			if (theoryButtons.contains(e.getSource())) {
				for (JRadioButton asBtn : aspectButtons) {
					asBtn.setVisible(true);
				}
			}
			if(aspectButtons.contains(e.getSource())) {
				debunkBtn.setVisible(true);
			}
		}

		@Override
		public void onPubChange() {
			updatePublicationArea();
			
		}
    
    }
    
    private void showTurnMessage(String message) {
	    JDialog turn = new JDialog(
	    		this,
	    		"Turn",
	    		true);
	    turn.setSize(300, 150);
	    turn.setModal(false);
	    JLabel turnText = new JLabel(message + " Next player's turn!");
	    turn.add(turnText, BorderLayout.CENTER);
	    JButton ok = new JButton("OK");
	    ok.addActionListener(e -> turn.dispose());
	    turn.add(ok, BorderLayout.SOUTH);
	    
	    turn.setLocationRelativeTo(turnText);
	    turn.setVisible(true);
	}
	
	
	
	private void showHelpDialog() {
	    JDialog help = new JDialog(
	    		this,
	    		"Help",
	    		true);
	    
	    help.setSize(300, 100);
	    help.setModal(false);
	    
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
