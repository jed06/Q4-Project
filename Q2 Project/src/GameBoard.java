
import java.util.List;
import java.util.ArrayList;
public class GameBoard extends Board{
	public static final int BOARD_SIZE = 12;
	public static final String[] NAMES = {"Suzie Sheep", "Candy Cat", "Zoe Zebra",
			"Rebecca Rabbit", "Emily Elephant",
			"George Pig","Danny Dog",
			"Molly Mole", "Freddy Fox" ,
			"Mandy Mouse", "Gerald Giraffe","Pedro Pony"};
	public static final boolean[] JEW =
			{true,false,true,false,true,false,false,true,true,false,true, false};
	public static final boolean[] HAIR =
			{false,false,false,false,false,true,true,false,true,false, true ,true};
	public static final boolean[] GLASS =
			{true,true,false,false,false,true,false,true,true, true,false, true};
	public static final boolean[] HAT =
			{true,true,true,true,false,false,false,false, false, false, false, true};
	public GameBoard() {
		super(BOARD_SIZE,NAMES,JEW,HAIR,GLASS,HAT);
	}

}
