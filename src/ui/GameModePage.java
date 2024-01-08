package ui;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import domain.controllers.HandlerFactory;

public class GameModePage extends JFrame{
	private JPanel panel;
	private JRadioButton onlineBtn; 
	private JRadioButton offlineBtn; 
	private JButton goBtn;
	
	
	public GameModePage() {
		
		super("KUAlchemists");
		panel = new JPanel();
		panel.setLayout(null);
		
		//two radiobuttons shown in the game mode page for online and offline options		
		onlineBtn = new JRadioButton("ONLINE");
		onlineBtn.setBounds(200, 200, 200, 200);
		panel.add(onlineBtn);
		
		offlineBtn = new JRadioButton("OFFLINE");
		offlineBtn.setBounds(400, 200, 200, 200);
		panel.add(offlineBtn);
    	
    	ButtonGroup btngroup = new ButtonGroup();
    	
    	btngroup.add(onlineBtn);
    	btngroup.add(offlineBtn);
    	
    	
    	//the button that will lead to the login page according to the game mode chosen
    	goBtn = new JButton("GO!");
    	goBtn.setBounds(300, 400, 200, 200);
    	goBtn.addActionListener(e -> {
    		if (onlineBtn.isSelected()) {
    			HandlerFactory.getInstance().getGameModeHandler().setGameMode("online");
    		}
    		if (offlineBtn.isSelected()) {
    			
    			HandlerFactory.getInstance().getGameModeHandler().setGameMode("offline");
    			
    		}
    	});
		panel.add(goBtn);
		
	}


	public JPanel getPanel() {
		return panel;
	}


	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

}
