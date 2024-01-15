package ui;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import domain.controllers.HandlerFactory;

public class HostWaitPage extends JFrame {
	
	private JPanel panel;

	public HostWaitPage() {
		super("Hosting Page");
		panel = new JPanel();
		panel.setLayout(null);
		
		JLabel label1 = new JLabel("IP Address: " +  HandlerFactory.getInstance().getHostHandler().getIPAddress());
		label1.setBounds(200, 200, 500, 30);
		
		JLabel label2 = new JLabel("Port: " +  Integer.toString(HandlerFactory.getInstance().getHostHandler().getPort()));
		label2.setBounds(200, 300, 200, 30);
		
		JLabel label3 = new JLabel("Current Number of Players: ");
		label3.setBounds(200, 400, 200, 30);
		
		JButton goBtn = new JButton("Go");
		goBtn.setBounds(282, 500, 80, 30);
		
		panel.add(label1);
		panel.add(label2);
		panel.add(label3);
		panel.add(goBtn);
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

}
