package ui;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class HostWaitPage extends JFrame {
	
	private JPanel panel;

	public HostWaitPage() {
		super("Hosting Page");
		panel = new JPanel();
		panel.setLayout(null);
		
		JLabel label1 = new JLabel("IP Address");
		label1.setBounds(200, 200, 200, 30);
		
		JLabel label2 = new JLabel("Port");
		label2.setBounds(200, 300, 200, 30);
		
		JButton goBtn = new JButton("Go");
		goBtn.setBounds(282, 460, 80, 30);
		
		panel.add(label1);
		panel.add(label2);
		panel.add(goBtn);
	}

}
