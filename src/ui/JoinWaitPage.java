package ui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JoinWaitPage extends JFrame {

	private JPanel panel;

	public JoinWaitPage() {
		super("Join Page");
		panel = new JPanel();
		panel.setLayout(null);
		
		JLabel label = new JLabel("Waiting for host to start game.");
		label.setBounds(200, 200, 200, 30);
	}
	
	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

}
