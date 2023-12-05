package domain.ViewControllers;
import javax.swing.JFrame;

import domain.Views.LoginPage;

public class LoginController {
	LoginPage loginPage = new LoginPage();

	public LoginController() {
		loginPage.add(LoginPage.getPanelLogin());
		loginPage.setSize(600,600);
		loginPage.setVisible(true);
		loginPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}