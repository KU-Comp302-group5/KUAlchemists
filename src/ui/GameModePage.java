package ui;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class GameModePage extends JFrame{
	private JPanel panel;
	private JRadioButton onlineBtn; 
	private JRadioButton offlineBtn; 
	private JButton goBtn;
	
	
	public GameModePage() {
		
		super("KUAlchemists");
		panel = new JPanel();
		panel.setLayout(null);
		
		onlineBtn = new JRadioButton("ONLINE");
		onlineBtn.setBounds(200, 200, 200, 200);
		panel.add(onlineBtn);
		
		offlineBtn = new JRadioButton("OFFLINE");
		offlineBtn.setBounds(400, 200, 200, 200);
		panel.add(offlineBtn);
    	
    	ButtonGroup btngroup = new ButtonGroup();
    	
    	btngroup.add(onlineBtn);
    	btngroup.add(offlineBtn);
    	
    	goBtn = new JButton("GO!");
    	goBtn.setBounds(300, 400, 200, 200);
		panel.add(goBtn);
		
	}


	public JPanel getPanel() {
		return panel;
	}


	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

}
