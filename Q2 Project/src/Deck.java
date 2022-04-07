import java.util.List;
import java.util.Random;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.net.URL;
import java.util.ArrayList;

public class Deck {
	private int x, y;
	private Image img; 	
	private AffineTransform tx;
	public int bvy = 1;

	private List<Card> cards = new ArrayList();
	private int size;
	public static int next;
	public Deck(String[] names, boolean[] jewelery, boolean[] hair, boolean[] glass, boolean[] hat) {
		this.size = 12;
		//Card SuzySheep = new Card ("Suzy Sheep", "Suzy Sheep", true , false , true , true ,  1 );
		//Card SuzySheep = new Card ("Suzy Sheep", "Suzy Sheep", true , false , true , true ,  1 );
		for (int i = 0 ; i < GameBoard.BOARD_SIZE; i++) {
			Card c = new Card(GameBoard.NAMES[i], GameBoard.NAMES[i], GameBoard.JEW[i], GameBoard.HAIR[i], GameBoard.GLASS[i], GameBoard.HAT[i], i, x, y);
			cards.add(c);
		}
		  
			 
	}
	
	public Deck() {
		this.size = 12;
		int x, y = 0;
		//Card SuzySheep = new Card ("Suzy Sheep", "Suzy Sheep", true , false , true , true ,  1 );
		//Card SuzySheep = new Card ("Suzy Sheep", "Suzy Sheep", true , false , true , true ,  1 );
		for (int i = 0 ; i < GameBoard.BOARD_SIZE; i++) {
			x = i%4 * 200;

			if (i < 4) {
				y = 0;
			}
			
			else if ( i < 8 ) {
				y = 150;
			}
			
			else {
				y = 300;
			}
			
			Card c = new Card(GameBoard.NAMES[i], GameBoard.NAMES[i], GameBoard.JEW[i], GameBoard.HAIR[i], GameBoard.GLASS[i], GameBoard.HAT[i], i, x, y);
			cards.add(c);
		}
		  
			 
	}
	

	public void paint(Graphics g) {
		//these are the 2 lines of code needed draw an image on the screen
		for (Card card : cards) {
			card.paint(g);
		}
		
		
	}


}
