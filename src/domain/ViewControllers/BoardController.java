package domain.ViewControllers;
import javax.swing.JFrame;

import domain.Player;
import domain.Views.BoardPage;

public class BoardController {
	private BoardPage boardPage;
	
	public BoardController(Player player1, Player player2) {
		//Board page is initialized and information of players are injected to board page
		boardPage = new BoardPage(player1, player2);
		boardPage.add(BoardPage.getPanelBoard());
		boardPage.setSize(600,600);
		boardPage.setVisible(true);
		boardPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}