package ui;

import javax.swing.*;

import domain.Avatar;
import domain.Player;
import domain.controllers.HandlerFactory;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class LoginPage extends JFrame implements ActionListener{
	
	private JPanel panelLogin;
	public static int playerNum = 2;
	private static int availableAvatarNum = 3;
	
	private static JButton addPlayerBtn, addPlayerBtn2, openBoard;
	
	private static List<Integer> avatarsChosen = new ArrayList<Integer>(); // stores avatars chosen for n players
	private static List<String> usernamesChosen = new ArrayList<String>();
	
	private static List<List<JButton>> avatarButtons = new ArrayList<List<JButton>>(); // stores 3 avatar buttons for n (numPlayers) players
	private static List<JTextField> textfields = new ArrayList<JTextField>(); // stores n (numPlayers) JTextField instances
	

	public  LoginPage() {
		super("Log-in Page");		
		panelLogin = new JPanel();
		panelLogin.setLayout(null);
		
		// initialize
		displayPlayer(1);
		displayPlayer(2);
		
		avatarsChosen.add(1);
		avatarsChosen.add(1);

		
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
					avatarsChosen.add(1);
					displayPlayer(4);
					playerNum++;
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
					avatarsChosen.add(1);
					displayPlayer(3);
					playerNum++;
					panelLogin.add(addPlayerBtn2);
			}
		});
		panelLogin.add(addPlayerBtn);
		
		
		openBoard = new JButton("Open Game!");
		
		openBoard.setBounds(572, 470, 120, 60);
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
		
	@Override
	public void actionPerformed(ActionEvent e) {		
	}

	
	public void displayPlayer(Integer playerNo) {
		
		int i;
		
		//Information of first user
		
		//label11 = new JLabel("Player 1 Username");
		JLabel usernameLabel = new JLabel("Player Username");
		
		
		//avatar11 = new JButton("avatar1");
		//avatar11 = new JButton(Avatar.getAvatarImage(1));
		//avatar12 = new JButton(Avatar.getAvatarImage(2));
		//avatar13 = new JButton(Avatar.getAvatarImage(3));
		
		// a list & more avatars are needed
		List<JButton> innerlistAvatarButtons = new ArrayList<>();
		for (i = 1; i < availableAvatarNum+1; i++) {
			JButton avatarButton = new JButton(Avatar.getAvatarImage(i));
			innerlistAvatarButtons.add(avatarButton);
		}
		avatarButtons.add(innerlistAvatarButtons);
		
		
		//label11.setBounds(160, 300, 150, 20);
		//panelLogin.add(label11);	
		
		usernameLabel.setBounds(160 + 275*(playerNo -1), 300, 150, 20);
		panelLogin.add(usernameLabel);
		
		
		//userName1 = new JTextField();
		//userName1.setBounds(150, 325, 150, 20);
		//panelLogin.add(userName1);
		
		JTextField username = new JTextField();
		username.setBounds(160 + 275*(playerNo -1), 325, 150, 20);
		textfields.add(username);
		panelLogin.add(username);
		
		
		
		//label12 = new JLabel("Choose your avatar");
		//label12.setBounds(160, 360, 150, 20);
		//panelLogin.add(label12);
		
		JLabel avatarLabel = new JLabel("Choose your avatar");
		avatarLabel.setBounds( 160 + 275*(playerNo -1), 360, 150, 20);
		panelLogin.add(avatarLabel);
		
		
		for (i = 0; i < availableAvatarNum; i++) {
			int temp = i+1;
			innerlistAvatarButtons.get(i).setBounds(140 + 275*(playerNo - 1) + 70*i , 380, 60, 60);
			//innerlistAvatarButtons.get(i).setForeground(Color.BLACK);
			//innerlistAvatarButtons.get(i).setBackground(Color.YELLOW);
			innerlistAvatarButtons.get(i).addActionListener( e -> {
				// Reset border of all buttons
		        for (JButton button : innerlistAvatarButtons) {
		            button.setBorder(null); // Reset border for all buttons
		        }
		        // Set border for the selected button
		        JButton selectedButton = (JButton) e.getSource();
		        selectedButton.setBorder(BorderFactory.createLineBorder(Color.GREEN, 6)); // Highlight the selected button
				
				setAvatarChosen(playerNo, temp);
			});	
			panelLogin.add(innerlistAvatarButtons.get(i));
		}
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