package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import domain.KUAlchemistsGame;
import domain.controllers.HandlerFactory;

public class OnlineLoginPage extends JFrame{
	
	private JPanel panel;
	
	public OnlineLoginPage() {
		super("Login Page");
		panel = new JPanel();
		panel.setLayout(null);
		
		JLabel label = new JLabel("Player Username");
		label.setBounds(200, 200, 200, 30);
		
		JTextField username = new JTextField();
		username.setBounds(200, 235, 200, 30);
		
		JLabel label2 = new JLabel("Choose your avatar");
		label2.setBounds(200, 300, 200, 30);
		
		JRadioButton av1 = new JRadioButton(new ImageIcon("avatar1.png"));
		av1.setBounds(197, 335, 70, 70);
		
		JRadioButton av2 = new JRadioButton(new ImageIcon("avatar2.png"));
		av2.setBounds(272, 335, 70, 70);
		
		JRadioButton av3 = new JRadioButton(new ImageIcon("avatar3.png"));
		av3.setBounds(347, 335, 70, 70);
		
		ButtonGroup btngroup = new ButtonGroup();
		
		btngroup.add(av1);
		btngroup.add(av2);
		btngroup.add(av3);
		
		JButton hostBtn = new JButton("Host");
		hostBtn.setBounds(200, 460, 80, 30);
		hostBtn.addActionListener( 
				new ActionListener() { 
					@Override
					public void actionPerformed(ActionEvent arg0) {
						HandlerFactory.getInstance().getHostHandler().startServer();
						HandlerFactory.getInstance().getHostHandler().login(username.getText(), 1);
						
						HostWaitPage hostPage = new HostWaitPage();
						hostPage.setVisible(true);
						hostPage.add(hostPage.getPanel());
						hostPage.setExtendedState(JFrame.MAXIMIZED_BOTH);
						hostPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
						dispose();
					}
				}
				);
		
		JButton joinBtn = new JButton("Join");
		joinBtn.setBounds(300, 460, 80, 30);
		
		panel.add(label);
		panel.add(username);
		panel.add(label2);
		panel.add(av1);
		panel.add(av2);
		panel.add(av3);
		panel.add(hostBtn);
		panel.add(joinBtn);
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}
}
