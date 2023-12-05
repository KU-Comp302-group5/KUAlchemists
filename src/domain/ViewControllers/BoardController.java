package domain.ViewControllers;
import javax.swing.JFrame;

import domain.Player;
import domain.Views.BoardPage;

public class BoardController {
	private BoardPage boardPage;
	
	public BoardController(Player player) {
		boardPage = new BoardPage(player);
		boardPage.add(BoardPage.getPanelBoard());
		boardPage.setSize(600,600);
		boardPage.setVisible(true);
		boardPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}