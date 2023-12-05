package domain.Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BoardPage extends JFrame implements ActionListener {
	
	private static JPanel panelBoard;
	private static JButton help, pause;
	
	public BoardPage() {
		super("KUAlchemists");
		setPanelBoard(new JPanel());
		getPanelBoard().setLayout(null);
		
		help = new JButton("Help");
		pause = new JButton("Pause");
		
		help.setBounds(0, 0, 40, 20);
		help.setForeground(Color.BLACK);
		help.setBackground(Color.WHITE);
		help.addActionListener(e -> showHelpDialog());
		
		getPanelBoard().add(help);
		
		pause.setBounds(560, 0, 40, 20);
		pause.setForeground(Color.BLACK);
		pause.setBackground(Color.WHITE);
		pause.addActionListener(e -> showPauseDialog());
		
		getPanelBoard().add(pause);
		
	}
	
	private void showHelpDialog() {
	    JDialog help = new JDialog(
	    		this,
	    		"Help",
	    		true);
	    help.setSize(200, 100);
	    
	    JLabel helpText = new JLabel("Help Information dummy");
	    help.add(helpText, BorderLayout.CENTER);
	    JButton ok = new JButton("OK");
	    ok.addActionListener(e -> help.dispose());
	    help.add(ok, BorderLayout.SOUTH);
	    
	    help.setLocationRelativeTo(helpText);
	    help.setVisible(true);
	}

	private void showPauseDialog() {
	    JDialog pause = new JDialog(
	    		this, 
	    		"Pause", 
	    		true);
	    pause.setSize(300, 100);
	    
	    JLabel pauseText = new JLabel("Game is paused. Press OK to continue.");
	    pause.add(pauseText, BorderLayout.CENTER);
	    JButton ok = new JButton("OK");
	    ok.addActionListener(e -> pause.dispose());
	    pause.add(ok, BorderLayout.SOUTH);
	    
	    pause.setLocationRelativeTo(pauseText);
	    pause.setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	public static JPanel getPanelBoard() {
		return panelBoard;
	}

	public static void setPanelBoard(JPanel panelBoard) {
		BoardPage.panelBoard = panelBoard;
	}
	
	
}
