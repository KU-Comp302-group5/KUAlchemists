package domain;


import javax.swing.JFrame;

import ui.LoginPage;

public class GameStartup {
	private static LoginPage loginPage;
	
	public static void main(String[] args) {
		loginPage = new LoginPage(); 	
		loginPage.add(LoginPage.getPanelLogin());
		loginPage.setSize(600,600);
		loginPage.setVisible(true);
		loginPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}	
}
