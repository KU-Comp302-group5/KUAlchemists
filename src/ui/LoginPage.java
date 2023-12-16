package ui;

import javax.swing.*;

import domain.Avatar;
import domain.Player;
import domain.controllers.HandlerFactory;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPage extends JFrame implements ActionListener{
	
	static private JButton avatar11, avatar12, avatar13, avatar21, avatar22, avatar23, avatar31,
					avatar32, avatar33, avatar41, avatar42, avatar43, openBoard, addPlayerBtn, addPlayerBtn2;
	static private JLabel label11, label12, label21, label22, label31, label32, label41, label42;
	private JPanel panelLogin;
	public static JTextField userName1, userName2, userName3, userName4;
	public static int avatarChosen1, avatarChosen2, avatarChosen3, avatarChosen4;


	public  LoginPage() {
		super("Log-in Page");		
		panelLogin = new JPanel();
		panelLogin.setLayout(null);

		
		
		//Information of first user
		label11 = new JLabel("Player 1 Username");
	
		//avatar11 = new JButton("avatar1");
		avatar11 = new JButton(Avatar.getAvatarImage(1));
		avatar12 = new JButton(Avatar.getAvatarImage(2));
		avatar13 = new JButton(Avatar.getAvatarImage(3));
		//another avatar is needed here

		
		label11.setBounds(160, 300, 150, 20);
		panelLogin.add(label11);	
		
		userName1 = new JTextField();
		userName1.setBounds(150, 325, 150, 20);
		panelLogin.add(userName1);
		
		label12 = new JLabel("Choose your avatar");
		label12.setBounds(160, 360, 150, 20);
		panelLogin.add(label12);
		
		avatar11.setBounds(120, 380, 60, 60);
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
		
		panelLogin.add(avatar11);
		
		avatar12.setBounds(190, 380, 60, 60);
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
		
		panelLogin.add(avatar12);
		
		avatar13.setBounds(260, 380, 60, 60);
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
		
		panelLogin.add(avatar13);
		
		
		//Information of second user
		label21 = new JLabel("Player 2 Username");
		avatar21 = new JButton(Avatar.getAvatarImage(1));
		avatar22 = new JButton(Avatar.getAvatarImage(2));
		avatar23 = new JButton(Avatar.getAvatarImage(3));

		
		label21.setBounds(435, 300, 150, 20);
		panelLogin.add(label21);	
		
		userName2 = new JTextField();
		userName2.setBounds(425, 325, 150, 20);
		panelLogin.add(userName2);
		
		label22 = new JLabel("Choose your avatar");
		label22.setBounds(435, 360, 150, 20);
		panelLogin.add(label22);
		
		avatar21.setBounds(395, 380, 60, 60);
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
		
		panelLogin.add(avatar21);
		
		avatar22.setBounds(465, 380, 60, 60);
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
		
		panelLogin.add(avatar22);
		
		avatar23.setBounds(535, 380, 60, 60);
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
		
		panelLogin.add(avatar23);

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
					addPlayer3();
			}
		});
		panelLogin.add(addPlayerBtn);
		
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
					addPlayer4();
			}
		});
		panelLogin.add(addPlayerBtn2);
		
		openBoard = new JButton("Open Game!");
		
		openBoard.setBounds(572, 470, 120, 60);
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
				
				//Information of Players is derived from login page and injected to BoardController
				HandlerFactory.getInstance().getLoginHandler().login1(getUserName(), getAvatarChosen());
				HandlerFactory.getInstance().getLoginHandler().login2(getUserName2(), getAvatarChosen2());
				if(userName3!=null) {
					HandlerFactory.getInstance().getLoginHandler().login3(getUserName3(), getAvatarChosen3());}
				if(userName4!=null) {
					HandlerFactory.getInstance().getLoginHandler().login4(getUserName4(), getAvatarChosen4());}
				
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

	public void addPlayer3() {
		//Information of third user
				label31 = new JLabel("Player 3 Username");
				avatar31 = new JButton(Avatar.getAvatarImage(1));
				avatar32 = new JButton(Avatar.getAvatarImage(2));
				avatar33 = new JButton(Avatar.getAvatarImage(3));

				
				label31.setBounds(710, 300, 150, 20);
				panelLogin.add(label31);	
				
				userName3 = new JTextField();
				userName3.setBounds(700, 325, 150, 20);
				panelLogin.add(userName3);
				
				label32 = new JLabel("Choose your avatar");
				label32.setBounds(710, 360, 150, 20);
				panelLogin.add(label32);
				
				avatar31.setBounds(670, 380, 60, 60);
				avatar31.setForeground(Color.BLACK);
				avatar31.setBackground(Color.WHITE);
				avatar31.addActionListener(
						new ActionListener() 
						{ 
					@Override
						public void actionPerformed(ActionEvent arg0) {
						setAvatarChosen3(1);
						
					}
				});
				
				panelLogin.add(avatar31);
				
				avatar32.setBounds(740, 380, 60, 60);
				avatar32.setForeground(Color.BLACK);
				avatar32.setBackground(Color.WHITE);
				avatar32.addActionListener(
						new ActionListener() 
						{ 
					@Override
						public void actionPerformed(ActionEvent arg0) {
						setAvatarChosen3(2);
						
					}
				});
				
				panelLogin.add(avatar32);
				
				avatar33.setBounds(810, 380, 60, 60);
				avatar33.setForeground(Color.BLACK);
				avatar33.setBackground(Color.WHITE);
				avatar33.addActionListener(
						new ActionListener() 
						{ 
					@Override
						public void actionPerformed(ActionEvent arg0) {
						setAvatarChosen3(3);
						
					}
				});
				
				panelLogin.add(avatar33);
	}
	public void addPlayer4() {
		//Information of fourth user
		label41 = new JLabel("Player 4 Username");
		avatar41 = new JButton(Avatar.getAvatarImage(1));
		avatar42 = new JButton(Avatar.getAvatarImage(2));
		avatar43 = new JButton(Avatar.getAvatarImage(3));

		
		label41.setBounds(985, 300, 150, 20);
		panelLogin.add(label41);	
		
		userName4 = new JTextField();
		userName4.setBounds(975, 325, 150, 20);
		panelLogin.add(userName4);
		
		label42 = new JLabel("Choose your avatar");
		label42.setBounds(985, 360, 150, 20);
		panelLogin.add(label42);
		
		avatar41.setBounds(945, 380, 60, 60);
		avatar41.setForeground(Color.BLACK);
		avatar41.setBackground(Color.WHITE);
		avatar41.addActionListener(
				new ActionListener() 
				{ 
			@Override
				public void actionPerformed(ActionEvent arg0) {
				setAvatarChosen4(1);
				
			}
		});
		
		panelLogin.add(avatar41);
		
		avatar42.setBounds(1015, 380, 60, 60);
		avatar42.setForeground(Color.BLACK);
		avatar42.setBackground(Color.WHITE);
		avatar42.addActionListener(
				new ActionListener() 
				{ 
			@Override
				public void actionPerformed(ActionEvent arg0) {
				setAvatarChosen4(2);
				
			}
		});
		
		panelLogin.add(avatar42);
		
		avatar43.setBounds(1085, 380, 60, 60);
		avatar43.setForeground(Color.BLACK);
		avatar43.setBackground(Color.WHITE);
		avatar43.addActionListener(
				new ActionListener() 
				{ 
			@Override
				public void actionPerformed(ActionEvent arg0) {
				setAvatarChosen4(3);
				
			}
		});
		
		panelLogin.add(avatar43);
	}
	
	public JPanel getPanelLogin() {
		return panelLogin;
	}

	public void setPanelLogin(JPanel panelLogin) {
		this.panelLogin = panelLogin;
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
	
	public String getUserName3() {
		return userName3.getText();
	}


	public int getAvatarChosen3() {
		return avatarChosen3;
	}
	
	public void setUserName3(JTextField userName) {
		LoginPage.userName3 = userName;
	}


	public void setAvatarChosen3(int avatarChosen) {
		LoginPage.avatarChosen3 = avatarChosen;
	}
	
	public String getUserName4() {
		return userName4.getText();
	}


	public int getAvatarChosen4() {
		return avatarChosen4;
	}
	
	public void setUserName4(JTextField userName) {
		LoginPage.userName4 = userName;
	}


	public void setAvatarChosen4(int avatarChosen) {
		LoginPage.avatarChosen4 = avatarChosen;
	}
}