
import java.util.List;
import java.util.ArrayList;
public class GameBoard {
	
	private Card[] cards;
	 private Deck deck;

	 
	 public GameBoard(int size,String[] name, boolean[] jew, boolean[] hair, boolean[] glass, boolean[] hat ) {
		 cards = new Card[size];
		 
	 }
	 public int size() {
		  return cards.length;
	}
	 public Card cardAt(int k) {
		  return cards[k];
	}
	 
	public static final int BOARD_SIZE = 16;
	public static final String[] NAMES = {"Suzie Sheep", "Candy Cat", "Zoe Zebra",
			"Rebecca Rabbit", "Emily Elephant",
			"George Pig","Danny Dog",
			"Molly Mole", "Freddy Fox" ,
			"Mandy Mouse", "Gerald Giraffe","Pedro Pony",
			"Peppa Pig", "Mummy Pig", "Granny Pig", "Grandpa Pig"};
	
	public static final boolean[] JEW =
			{true,false,true,false,true,false,false,true,true,false,true, false, true, false, true, true};
	public static final boolean[] HAIR =
			{false,false,false,false,false,true,true,false,true,false, true ,true, false, false, false, false};
	public static final boolean[] GLASS =
			{true,true,false,false,false,true,false,true,true, true,false, true, false, true, false, true};
	public static final boolean[] HAT =
			{true,true,true,true,false,false,false,false, false, false, false, true, true, true, false, true};
	
	/*
	 * public GameBoard() { super(BOARD_SIZE,NAMES,JEW,HAIR,GLASS,HAT); }
	 */

	public static final HintQuestion[] HINT_QUESTIONS = {
			new HintQuestion("Hair ?", false, true, false, false, 0),
			new HintQuestion("Jewelery ?", true, false, false, false, 1),
			new HintQuestion("Glasses ?", false, false, true,  false, 2 ),
			new HintQuestion("Hat ?", false, false, false, true, 3),
			
	};
}
