package ui;

import javax.swing.*;

import domain.ArtListener;
import domain.Avatar;
import domain.IngListener;
import domain.KUAlchemistsGame;
import domain.controllers.HandlerFactory;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BoardPage extends JFrame implements ActionListener {
	
	private static JPanel panelBoard, player_ingr, player_arts;
	private static JButton help, pause, potionBrewing, publicationTrack, deductionBoard, turnButton, ingrDeckButton, player_ing, artifactDeckButton, player_art;
	private JLabel gold, gold2, gold3, gold4,
				   sickness, sickness2, sickness3, sickness4,
				   reputation,reputation2, reputation3, reputation4,
				   name, avatar, name2, avatar2, name3, avatar3, name4, avatar4;
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
		KUAlchemistsGame.getInstance().getPlayerIII().addArtListener((PlayerArts) player_arts);
		KUAlchemistsGame.getInstance().getPlayerIV().addArtListener((PlayerArts) player_arts);
		
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
		KUAlchemistsGame.getInstance().getPlayerIII().addIngListener((PlayerIngs) player_ingr);
		KUAlchemistsGame.getInstance().getPlayerIV().addIngListener((PlayerIngs) player_ingr);
		
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
        	switchTurns(KUAlchemistsGame.getInstance().getPlayer(currentPlayer).getUsername() + " foraged an ingredient.");
        });
        //getPanelBoard().add(ingrDeckButton);
        
		artifactDeckButton.setBounds(310, 120, 150, 50);
		artifactDeckButton.setForeground(Color.BLUE);
		artifactDeckButton.addActionListener(e -> {
        	System.out.println("artifactDeckButton clicked");
        	HandlerFactory.getInstance().getBuyArtifactHandler().buyArtifact(KUAlchemistsGame.getInstance().getPlayer(currentPlayer));
            gold.setText("Gold: " + KUAlchemistsGame.getInstance().getPlayer(currentPlayer).getGold());
        	System.out.println(KUAlchemistsGame.getInstance().getPlayer(currentPlayer).getArtifacts());
        	switchTurns(KUAlchemistsGame.getInstance().getPlayer(currentPlayer).getUsername() + " bought an artifact.");
        });
        //getPanelBoard().add(artifactDeckButton);
		
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
        
        
        name = new JLabel("Player I: " + KUAlchemistsGame.getInstance().getPlayerI().getUsername());
        name.setBounds(125, 20, 200, 15);
        getPanelBoard().add(name);
        
        avatar = new JLabel();
        avatar.setIcon(Avatar.getAvatarImage(KUAlchemistsGame.getInstance().getPlayerI().getAvatar()));
        avatar.setBounds(135, 40, 60, 60);
        getPanelBoard().add(avatar);
        
        /**
         * Observer pattern should be implemented for updating gold.
         *
         */
        gold = new JLabel("Gold: " + KUAlchemistsGame.getInstance().getPlayerI().getGold());
        gold.setBounds(58, 95, 60, 30);
        getPanelBoard().add(gold);

        /**
         * Observer pattern should be implemented for updating sickness.
         *
         */
        sickness = new JLabel("Sickness: " + KUAlchemistsGame.getInstance().getPlayerI().getSickness());
        sickness.setBounds(121, 95, 80, 30);
        getPanelBoard().add(sickness);
        
        reputation = new JLabel("Reputation: " + KUAlchemistsGame.getInstance().getPlayerI().getReputation());
        reputation.setBounds(203, 95, 80, 30);
        getPanelBoard().add(reputation);
        
        name2 = new JLabel("Player II: " + KUAlchemistsGame.getInstance().getPlayerII().getUsername());
        name2.setBounds(425, 20, 200, 15);
        getPanelBoard().add(name2);
        
        avatar2 = new JLabel();
        avatar2.setIcon(Avatar.getAvatarImage(KUAlchemistsGame.getInstance().getPlayerII().getAvatar()));
        avatar2.setBounds(435, 40, 60, 60);
        getPanelBoard().add(avatar2);
        
        gold2 = new JLabel("Gold: " + KUAlchemistsGame.getInstance().getPlayerII().getGold());
        gold2.setBounds(358, 95, 60, 30);
        getPanelBoard().add(gold2);
        
        sickness2 = new JLabel("Sickness: " + KUAlchemistsGame.getInstance().getPlayerII().getSickness());
        sickness2.setBounds(421, 95, 80, 30);
        getPanelBoard().add(sickness2);
        
        reputation2 = new JLabel("Reputation: " + KUAlchemistsGame.getInstance().getPlayerII().getReputation());
        reputation2.setBounds(503, 95, 80, 30);
        getPanelBoard().add(reputation2);
        
        if(LoginPage.playerNum==3) {
        	showPlayer3();
        }
        
        if(LoginPage.playerNum==4) {
        	showPlayer3();
        	showPlayer4();
        }
        


        
  
        //Just added to show turn of players able to change. Just for demonstration.
        turnButton.setMargin(new Insets(0, 0, 0, 0));
        turnButton.setFocusPainted(false);
		turnButton.setBounds(400, 0, 50, 20);
		turnButton.addActionListener(e -> {
			switchTurns(KUAlchemistsGame.getInstance().getPlayer(currentPlayer).getUsername() + " did nothing.");
		});
		//getPanelBoard().add(turnButton);
	}
	
	public void showPlayer3() {
        name3 = new JLabel("Player III: " + KUAlchemistsGame.getInstance().getPlayerIII().getUsername());
        name3.setBounds(725, 20, 200, 15);
        getPanelBoard().add(name3);
        
        avatar3 = new JLabel();
        avatar3.setIcon(Avatar.getAvatarImage(KUAlchemistsGame.getInstance().getPlayerIII().getAvatar()));
        avatar3.setBounds(735, 40, 60, 60);
        getPanelBoard().add(avatar3);
        
        gold3 = new JLabel("Gold: " + KUAlchemistsGame.getInstance().getPlayerIII().getGold());
        gold3.setBounds(658, 95, 60, 30);
        getPanelBoard().add(gold3);
        
        sickness3 = new JLabel("Sickness: " + KUAlchemistsGame.getInstance().getPlayerIII().getSickness());
        sickness3.setBounds(721, 95, 80, 30);
        getPanelBoard().add(sickness3);
        
        reputation3 = new JLabel("Reputation: " + KUAlchemistsGame.getInstance().getPlayerIII().getReputation());
        reputation3.setBounds(803, 95, 80, 30);
        getPanelBoard().add(reputation3);
	}
	
	public void showPlayer4() {
        name4 = new JLabel("Player III: " + KUAlchemistsGame.getInstance().getPlayerIV().getUsername());
        name4.setBounds(1025, 20, 200, 15);
        getPanelBoard().add(name4);
        
        avatar4 = new JLabel();
        avatar4.setIcon(Avatar.getAvatarImage(KUAlchemistsGame.getInstance().getPlayerIV().getAvatar()));
        avatar4.setBounds(1035, 40, 60, 60);
        getPanelBoard().add(avatar4);
        
        gold4 = new JLabel("Gold: " + KUAlchemistsGame.getInstance().getPlayerIV().getGold());
        gold4.setBounds(958, 95, 60, 30);
        getPanelBoard().add(gold4);
        
        sickness4 = new JLabel("Sickness: " + KUAlchemistsGame.getInstance().getPlayerIV().getSickness());
        sickness4.setBounds(1021, 95, 80, 30);
        getPanelBoard().add(sickness4);
        
        reputation4 = new JLabel("Reputation: " + KUAlchemistsGame.getInstance().getPlayerIV().getReputation());
        reputation4.setBounds(1103, 95, 80, 30);
        getPanelBoard().add(reputation4);
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
                	switchTurns(KUAlchemistsGame.getInstance().getPlayer(currentPlayer).getUsername() + " used an artifact.");
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
                    switchTurns(KUAlchemistsGame.getInstance().getPlayer(currentPlayer).getUsername() + " transmuted an ingredient.");
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
    
    private class ElixirOfInsight extends JPanel{
    	
    	
    }
	
	private void switchTurns(String message) {
	    JDialog turn = new JDialog(
	    		this,
	    		"Turn",
	    		true);
	    turn.setSize(300, 100);
	    turn.setModal(false);
	    JLabel turnText = new JLabel(message + " Next player's turn!");
	    turn.add(turnText, BorderLayout.CENTER);
	    JButton ok = new JButton("OK");
	    ok.addActionListener(e -> turn.dispose());
	    turn.add(ok, BorderLayout.SOUTH);
	    
	    turn.setLocationRelativeTo(turnText);
	    turn.setVisible(true);
	    
		if (currentPlayer == 1) {
			currentPlayer = 2;
		} else if (currentPlayer == 2) {
			currentPlayer = 3;
		} else if (currentPlayer == 3) {
			currentPlayer = 4;
		} else {
			currentPlayer = 1;
		}
		name.setText("Player: " + KUAlchemistsGame.getInstance().getPlayer(currentPlayer).getUsername());
        avatar.setIcon(Avatar.getAvatarImage(KUAlchemistsGame.getInstance().getPlayer(currentPlayer).getAvatar()));
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
