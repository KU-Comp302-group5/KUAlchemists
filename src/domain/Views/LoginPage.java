package domain.Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPage extends JFrame implements ActionListener{
	
	
	static private JButton avatar1, avatar2, avatar3, openGame;
	static private JLabel label,label2;
	private static JPanel panelLogin;
	public static JTextField userName;
	public static int avatarChosen;
	


	public  LoginPage() {
		super("Log-in Page");		
		setPanelLogin(new JPanel());
		getPanelLogin().setLayout(null);
		
		label = new JLabel("Username");
		avatar1 = new JButton("avatar1");
		avatar2 = new JButton("avatar2");
		avatar3 = new JButton("avatar3");
		openGame = new JButton("Open Game");

		
		label.setBounds(100, 100, 150, 20);
		getPanelLogin().add(label);	
		
		userName = new JTextField();
		userName.setBounds(100, 125, 150, 20);
		getPanelLogin().add(userName);
		
		label2 = new JLabel("Choose your avatar");
		label2.setBounds(100, 150, 150, 20);
		getPanelLogin().add(label2);
		
		avatar1.setBounds(70, 170, 60, 60);
		avatar1.setForeground(Color.BLACK);
		avatar1.setBackground(Color.WHITE);
		avatar1.addActionListener(
				new ActionListener() 
				{ 
			@Override
				public void actionPerformed(ActionEvent arg0) {
				System.out.println("avatar1 pressed");
				setAvatarChosen(1);
				
			}
		});
		
		getPanelLogin().add(avatar1);
		
		avatar2.setBounds(140, 170, 60, 60);
		avatar2.setForeground(Color.BLACK);
		avatar2.setBackground(Color.WHITE);
		avatar2.addActionListener(
				new ActionListener() 
				{ 
			@Override
				public void actionPerformed(ActionEvent arg0) {
				System.out.println("avatar2 pressed");
				setAvatarChosen(2);
				
			}
		});
		
		getPanelLogin().add(avatar2);
		
		avatar3.setBounds(210, 170, 60, 60);
		avatar3.setForeground(Color.BLACK);
		avatar3.setBackground(Color.WHITE);
		avatar3.addActionListener(
				new ActionListener() 
				{ 
			@Override
				public void actionPerformed(ActionEvent arg0) {
				System.out.println("avatar3 pressed");
				setAvatarChosen(3);
				
			}
		});
		
		getPanelLogin().add(avatar3);
		
		openGame.setBounds(110, 240, 120, 60);
		openGame.setForeground(Color.BLACK);
		openGame.setBackground(Color.WHITE);
		openGame.addActionListener(
				new ActionListener() 
				{ 
			@Override
				public void actionPerformed(ActionEvent arg0) {
				setUserName(userName);
				System.out.println(getUserName());
				System.out.println(getAvatarChosen());
			}
		});
		
		getPanelLogin().add(openGame);
		
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
		return userName.getText();
	}


	public int getAvatarChosen() {
		return avatarChosen;
	}
	
	public void setUserName(JTextField userName) {
		LoginPage.userName = userName;
	}


	public void setAvatarChosen(int avatarChosen) {
		LoginPage.avatarChosen = avatarChosen;
	}
	
}
