package domain.Views;

import javax.swing.*;

import domain.ViewControllers.BoardController;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPage extends JFrame implements ActionListener{
	
	
	static private JButton avatar11, avatar12, avatar13, avatar21, avatar22, avatar23, openBoard;
	static private JLabel label11, label12, label21, label22;
	private static JPanel panelLogin;
	public static JTextField userName1, userName2;
	public static int avatarChosen1, avatarChosen2;
	


	public  LoginPage() {
		super("Log-in Page");		
		setPanelLogin(new JPanel());
		getPanelLogin().setLayout(null);
		
		
		//Information of first user
		label11 = new JLabel("Player 1 Username");
		avatar11 = new JButton("avatar1");
		avatar12 = new JButton("avatar2");
		avatar13 = new JButton("avatar3");
		openBoard = new JButton("Open Game!");

		
		label11.setBounds(100, 100, 150, 20);
		getPanelLogin().add(label11);	
		
		userName1 = new JTextField();
		userName1.setBounds(100, 125, 150, 20);
		getPanelLogin().add(userName1);
		
		label12 = new JLabel("Choose your avatar");
		label12.setBounds(100, 150, 150, 20);
		getPanelLogin().add(label12);
		
		avatar11.setBounds(70, 170, 60, 60);
		avatar11.setForeground(Color.BLACK);
		avatar11.setBackground(Color.WHITE);
		avatar11.addActionListener(
				new ActionListener() 
				{ 
			@Override
				public void actionPerformed(ActionEvent arg0) {
				setAvatarChosen(1);
				
			}
		});
		
		getPanelLogin().add(avatar11);
		
		avatar12.setBounds(140, 170, 60, 60);
		avatar12.setForeground(Color.BLACK);
		avatar12.setBackground(Color.WHITE);
		avatar12.addActionListener(
				new ActionListener() 
				{ 
			@Override
				public void actionPerformed(ActionEvent arg0) {
				setAvatarChosen(2);
				
			}
		});
		
		getPanelLogin().add(avatar12);
		
		avatar13.setBounds(210, 170, 60, 60);
		avatar13.setForeground(Color.BLACK);
		avatar13.setBackground(Color.WHITE);
		avatar13.addActionListener(
				new ActionListener() 
				{ 
			@Override
				public void actionPerformed(ActionEvent arg0) {
				setAvatarChosen(3);
				
			}
		});
		
		getPanelLogin().add(avatar13);
		
		//Information of second user
		label21 = new JLabel("Player 2 Username");
		avatar21 = new JButton("avatar1");
		avatar22 = new JButton("avatar2");
		avatar23 = new JButton("avatar3");

		
		label21.setBounds(300, 100, 150, 20);
		getPanelLogin().add(label21);	
		
		userName2 = new JTextField();
		userName2.setBounds(300, 125, 150, 20);
		getPanelLogin().add(userName2);
		
		label22 = new JLabel("Choose your avatar");
		label22.setBounds(300, 150, 150, 20);
		getPanelLogin().add(label22);
		
		avatar21.setBounds(270, 170, 60, 60);
		avatar21.setForeground(Color.BLACK);
		avatar21.setBackground(Color.WHITE);
		avatar21.addActionListener(
				new ActionListener() 
				{ 
			@Override
				public void actionPerformed(ActionEvent arg0) {
				setAvatarChosen2(1);
				
			}
		});
		
		getPanelLogin().add(avatar21);
		
		avatar22.setBounds(340, 170, 60, 60);
		avatar22.setForeground(Color.BLACK);
		avatar22.setBackground(Color.WHITE);
		avatar22.addActionListener(
				new ActionListener() 
				{ 
			@Override
				public void actionPerformed(ActionEvent arg0) {
				setAvatarChosen2(2);
				
			}
		});
		
		getPanelLogin().add(avatar22);
		
		avatar23.setBounds(410, 170, 60, 60);
		avatar23.setForeground(Color.BLACK);
		avatar23.setBackground(Color.WHITE);
		avatar23.addActionListener(
				new ActionListener() 
				{ 
			@Override
				public void actionPerformed(ActionEvent arg0) {
				setAvatarChosen2(3);
				
			}
		});
		
		getPanelLogin().add(avatar23);
		
		openBoard.setBounds(210, 320, 120, 60);
		openBoard.setForeground(Color.BLACK);
		openBoard.setBackground(Color.WHITE);
		openBoard.addActionListener(
				new ActionListener() 
				{ 
			@Override
				public void actionPerformed(ActionEvent arg0) {
				System.out.println(getUserName2());
				System.out.println(getAvatarChosen2());
				System.out.println(getUserName());
				System.out.println(getAvatarChosen());
				BoardController board = new BoardController();
			}
		});
		getPanelLogin().add(openBoard);
	}
		

	@Override
	public void actionPerformed(ActionEvent e) {		
	}


	public static JPanel getPanelLogin() {
		return panelLogin;
	}


	public static void setPanelLogin(JPanel panelLogin) {
		LoginPage.panelLogin = panelLogin;
	}
	
	public String getUserName() {
		return userName1.getText();
	}


	public int getAvatarChosen() {
		return avatarChosen1;
	}
	
	public void setUserName(JTextField userName) {
		LoginPage.userName1 = userName;
	}


	public void setAvatarChosen(int avatarChosen) {
		LoginPage.avatarChosen1 = avatarChosen;
	}
	
	public String getUserName2() {
		return userName2.getText();
	}


	public int getAvatarChosen2() {
		return avatarChosen2;
	}
	
	public void setUserName2(JTextField userName) {
		LoginPage.userName2 = userName;
	}


	public void setAvatarChosen2(int avatarChosen) {
		LoginPage.avatarChosen2 = avatarChosen;
	}
}