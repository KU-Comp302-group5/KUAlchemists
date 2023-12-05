package domain.Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BoardPage extends JFrame implements ActionListener {
	
	private static JPanel panelBoard;
	
	public BoardPage() {
		super("KUAlchemists");
		setPanelBoard(new JPanel());
		getPanelBoard().setLayout(null);
		
	}
	
	public static void main() {
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
