
public class GUIRunner {

	 public static void main(String[] args) {
	  Board board = new GameBoard();
	  CardGameGUI gui = new CardGameGUI(board);
	  gui.displayGame();
	 }
	}