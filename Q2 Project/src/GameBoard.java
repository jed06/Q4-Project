
import java.util.List;
import java.util.ArrayList;
public class GameBoard {
	
	//private Card[] cards;
	 private Deck deck;

	 
	 
	 
	public static final int BOARD_SIZE = 16;
	public static final Card [] cards = {
		//	public Card(String name, String imgURL, boolean hasJewelery, boolean hasHair, boolean hasGlasses, boolean hasHat, int index

		new Card("Suzie Sheep", "Suzie Sheep", true, false, true, true,0),
		new Card("Candy Cat", "Candy Cat", false, false, true, true,1),	
		new Card("Zoe Zebra", "Zoe Zebra", true, false, false, true,2),	
		new Card("Rebecca Rabbit", "Rebecca Rabbit", false, false, false, true,3),	
		new Card("Emily Elephant", "Emily Elephant", true, false, false, false,4),	
		new Card("George Pig", "George Pig", false, true, true, false,5),	
		new Card("Danny Dog", "Danny Dog", false, true, false, false,6),	
		new Card("Molly Mole", "Molly Mole", true, false, true, false,7),	
		new Card("Freddy Fox", "Freddy Fox", true, true, true, false,8),
		new Card("Mandy Mouse", "Mandy Mouse", false, false, true, false,9),
		new Card("Gerald Giraffe", "Gerald Giraffe", true, true, false, false,10),
		new Card("Pedro Pony", "Pedro Pony", false, true, true, true,11),
		new Card("Peppa Pig", "Peppa Pig", true, true, true, true,12),
		new Card("Mummy Pig", "Mummy Pig", false, false, false, false,13),
		new Card("Granny Pig", "Granny Pig", false, true, false, true,14),
		new Card("Grandpa Pig", "Grandpa Pig", true, true, false, true,15)	
		
	};
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
			
			new HintQuestion("Is the character wearing jewelery?", true, false, false, false, 0),
			new HintQuestion("Does the character have facial hair?", false, true, false, false, 1),
			new HintQuestion("Is the character wearing Glasses?", false, false, true,  false, 2 ),
			new HintQuestion("Is the character wearing a hat/headband?", false, false, false, true, 3),
			
	};
	
	
public static final HintQuestion[] COMPUTER_HINT_QUESTIONS = {
			
			new HintQuestion("Is the character wearing jewelery?", true, false, false, false, 0),
			new HintQuestion("Does the character have facial hair?", false, true, false, false, 1),
			new HintQuestion("Is the character wearing Glasses?", false, false, true,  false, 2 ),
			new HintQuestion("Is the character wearing a hat/headband?", false, false, false, true, 3),
			
	};
	
}
