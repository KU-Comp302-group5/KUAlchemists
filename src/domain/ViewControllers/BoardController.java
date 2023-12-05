package domain.ViewControllers;
import javax.swing.JFrame;
import domain.Views.BoardPage;

public class BoardController {
	BoardPage boardPage = new BoardPage();
	
	public BoardController() {
		boardPage.add(BoardPage.getPanelBoard());
		boardPage.setSize(600,600);
		boardPage.setVisible(true);
		boardPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}