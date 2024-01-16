package ui;

import javax.imageio.ImageIO;
import javax.swing.*;

import domain.Avatar;
import domain.KUAlchemistsGame;
import domain.Player;
import domain.controllers.HandlerFactory;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LoginPage extends JFrame implements ActionListener{
	
	private JPanel panelLogin;
	public static int playerNum = 2;
	private static int availableAvatarNum = 6;
	
	private static JButton addPlayerBtn, addPlayerBtn2, openBoard;
	
	private static List<Integer> avatarsChosen = new ArrayList<Integer>(); // stores avatars chosen for n players
	private static List<String> usernamesChosen = new ArrayList<String>();
	
	private static JButton[][] avatarButtons = new JButton[4][6]; // stores 3 avatar buttons for n (numPlayers) players
	private static List<JTextField> textfields = new ArrayList<JTextField>(); // stores n (numPlayers) JTextField instances
	
	private static Boolean[] isAvatarChosen;
	

	public  LoginPage() {
		super("Log-in Page");		
		panelLogin = new BackgroundPanel("pixil-frame-0.png");
		panelLogin.setLayout(null);
//		
//		this.isAvatarChosen = new Boolean[6];
//		for (int i = 0; i < 6; i++) {
//			isAvatarChosen[i] = false;
//		}
		
		initializeButtons();
		// initialize
		displayPlayer(1);
		displayPlayer(2);
		
		avatarsChosen.add(1);
		avatarsChosen.add(2);

		
		addPlayerBtn2 = new JButton("Add player.");
		addPlayerBtn2.setBounds(1045, 350, 120, 40);
		addPlayerBtn2.setForeground(Color.BLACK);
		addPlayerBtn2.setBackground(Color.WHITE);
		addPlayerBtn2.addActionListener(
				new ActionListener() 
				{ 
			@Override
				public void actionPerformed(ActionEvent arg0) {
				
					
					panelLogin.remove(addPlayerBtn2);
					panelLogin.revalidate();
					panelLogin.repaint();
					avatarsChosen.add(4);
					displayPlayer(4);
					playerNum++;
					displayButtons();
					//avatarsChosen.add(1);
			}
		});
		
		addPlayerBtn = new JButton("Add player.");
		addPlayerBtn.setBounds(770, 350, 120, 40);
		addPlayerBtn.setForeground(Color.BLACK);
		addPlayerBtn.setBackground(Color.WHITE);
		addPlayerBtn.addActionListener(
				new ActionListener() 
				{ 
			@Override
				public void actionPerformed(ActionEvent arg0) {
					panelLogin.remove(addPlayerBtn);
					panelLogin.revalidate();
					panelLogin.repaint();
					avatarsChosen.add(3);
					displayPlayer(3);
					playerNum++;
					panelLogin.add(addPlayerBtn2);
					displayButtons();
					//avatarsChosen.add(1);
			}
		});
		panelLogin.add(addPlayerBtn);
		
		displayButtons();
		
		
		openBoard = new JButton("Open Game!");
		
		openBoard.setBounds(572, 550, 120, 60);
		openBoard.setForeground(Color.BLACK);
		openBoard.setBackground(Color.WHITE);
		openBoard.addActionListener(
				new ActionListener() 
				{ 
			@Override
				public void actionPerformed(ActionEvent arg0) {
				
				
				//Information of Players is derived from login page and injected to BoardController
				for (int i = 0; i < playerNum; i++) {
					usernamesChosen.add(textfields.get(i).getText());
				}
				HandlerFactory.getInstance().getLoginHandler().login(usernamesChosen, avatarsChosen, playerNum);
				

				BoardPage boardPage = new BoardPage();
				KUAlchemistsGame.getInstance().addEndListener(boardPage);
				boardPage.setVisible(true);
				boardPage.add(BoardPage.getPanelBoard());
				//boardPage.setSize(Toolkit.getDefaultToolkit().getScreenSize());
				boardPage.setExtendedState(JFrame.MAXIMIZED_BOTH);
				boardPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
				dispose();
			}
		});
		panelLogin.add(openBoard);
	}
	
	public void initializeButtons() {
		for (int i = 0; i < 4; i++) {
			JButton[] innerlistAvatarButtons = new JButton[6];
			for (int j = 0; j < availableAvatarNum; j++) {
				JButton avatarButton = new JButton(Avatar.getAvatarImage(j+1));
				innerlistAvatarButtons[j] = avatarButton;
			}
			avatarButtons[i] = innerlistAvatarButtons;
		}
		
	}
		
	@Override
	public void actionPerformed(ActionEvent e) {		
	}

	public void displayButtons() {
		//this.avatarButtons = new ArrayList<List<JButton>>(); //empty the avatarbuttons list
		for (int i =1; i < playerNum+1; i++) {
			
			displayPlayerButtons(i);
			
			
		}
	}
	
	public void displayPlayerButtons(Integer playerNo) {
		int i;
		
		//System.out.println("------in player #" +playerNo + "------");
		//System.out.println(Arrays.toString(avatarsChosen.toArray()));
		
		JButton[] innerlistAvatarButtons = avatarButtons[playerNo-1];
		
		for (i = 0; i < availableAvatarNum; i++) {
			int temp = i+1;
			innerlistAvatarButtons[i].setBounds(140 + 275*(playerNo - 1) + 70*(i % 3) , 380 + (70 * (i / 3)), 60, 60);
			//innerlistAvatarButtons.get(i).setForeground(Color.BLACK);
			//innerlistAvatarButtons.get(i).setBackground(Color.YELLOW);
			int index = avatarsChosen.indexOf(i+1);
			if ((avatarsChosen.indexOf(i+1)+1 == playerNo)) { // chosen by this player
				//System.out.println("this avatar is chosen by this player: " + (i+1));
				//System.out.println("return value of indexof: " + avatarsChosen.indexOf(i+1) +" player no is: "+ playerNo);
				innerlistAvatarButtons[i].setBorder(BorderFactory.createLineBorder(Color.GREEN, 6)); // Highlight the selected button]
					
			}
			else if (index == -1) { // avatar is not chosen by anyone
				innerlistAvatarButtons[i].setEnabled(true);
				//System.out.println("this avatar is not chosen by anoyone");
				innerlistAvatarButtons[i].setBorder(null);
				innerlistAvatarButtons[i].addActionListener( e -> {
					setAvatarChosen(playerNo, temp);
					displayButtons();
				});
			}
			else { // avatar chosen by others
				//System.out.println("-----THIS AVATAR IS CHOSEN BY OTHERS: " + (i+1));
				
				innerlistAvatarButtons[i].setBorder(BorderFactory.createLineBorder(Color.RED, 6)); // Highlight red
				innerlistAvatarButtons[i].setEnabled(false);
			}
			
			panelLogin.add(innerlistAvatarButtons[i]);
		}
	}
	
	
	
	public void displayPlayer(Integer playerNo) {
		
		int i;
		
		//Information of first user
		
		//label11 = new JLabel("Player 1 Username");
		JLabel usernameLabel = new JLabel("Player Username");
		
		usernameLabel.setBounds(160 + 275*(playerNo -1), 300, 150, 20);
		panelLogin.add(usernameLabel);
		
		
		JTextField username = new JTextField();
		username.setBounds(160 + 275*(playerNo -1), 325, 150, 20);
		textfields.add(username);
		panelLogin.add(username);
		
		
		JLabel avatarLabel = new JLabel("Choose your avatar");
		avatarLabel.setBounds( 160 + 275*(playerNo -1), 360, 150, 20);
		panelLogin.add(avatarLabel);
		
		
		
	}
	
	public void setAvatarChosen(Integer playerNo, int avatarChosen) {
		LoginPage.avatarsChosen.set(playerNo-1, avatarChosen); // avatarsChosen needs to have playerNo elements
	}
	
	public JPanel getPanelLogin() {
		return panelLogin;
	}

	public void setPanelLogin(JPanel panelLogin) {
		this.panelLogin = panelLogin;
	}
}