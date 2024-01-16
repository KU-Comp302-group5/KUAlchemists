package domain;

import javax.swing.JFrame;

import ui.LoginPage;
import ui.OnlineLoginPage;

public class OnlineAdapter implements IGameAdapter{

	//will create a new login page with 1 player + host or join button
	//'LoginPage2' class needed in the UI specific to online version 
	
	@Override
	public void startLoginView() {
		
		OnlineLoginPage onlineLoginPage = new OnlineLoginPage(); 	
		onlineLoginPage.add(onlineLoginPage.getPanel());
		onlineLoginPage.setExtendedState(JFrame.MAXIMIZED_BOTH);
		onlineLoginPage.setVisible(true);
		onlineLoginPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}
