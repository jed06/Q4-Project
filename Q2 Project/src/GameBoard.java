
import java.util.List;
import java.util.ArrayList;
public class GameBoard extends Board{
	private static final int BOARD_SIZE = 9;
	private static final String[] NAMES = {"Suzy Sheep", "Candy Cat", "Zoe Zebra",
			"Rebecca Rabbit", "Emily Elephant",
			"George Pig","Danny Dog",
			"Molly Mole", "Freddy Fox" ,
			"Mandy Mouse", " Gerald Giraffe","Pedro Pony"};
	private static final boolean[] JEW =
		  {true,false,true,false,true,false,false,true,true,false,true, false};
	private static final boolean[] HAIR =
		  {false,false,false,false,false,true,true,false,true,false, true ,true};
	private static final boolean[] GLASS =
		  {true,true,false,false,false,true,false,true,true, true,false, true};
	private static final boolean[] HAT =
		  {true,true,true,true,false,false,false,false, false, false, false, true};
	public GameBoard() {
		super(BOARD_SIZE,NAMES,JEW,HAIR,GLASS,HAT);
	}
	
	
//	
//	public boolean isGameWon() {
////		if(absoluteMatch()) {
////			return true;
////		}
//	}

}
