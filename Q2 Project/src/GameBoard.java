import java.util.List;
import java.util.ArrayList;
public class GameBoard extends Board{
	private static final int BOARD_SIZE = 9;
	private static final String[] NAMES = {"a", "b", "c", "d", "e", "f", "g","h","i"};
	private static final boolean[] JEW =
		  {false,false,true,false,true,false,false,true,false};
	private static final boolean[] HAIR =
		  {false,false,true,false,true,false,false,true,false};
	private static final boolean[] GLASS =
		  {false,false,true,false,true,false,false,true,false};
	private static final boolean[] HAT =
		  {false,false,true,false,true,false,false,true,false};
	public GameBoard() {
		super(BOARD_SIZE,NAMES,JEW,HAIR,GLASS,HAT);
	}

}
