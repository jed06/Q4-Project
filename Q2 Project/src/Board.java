import java.util.List;
import java.util.ArrayList;
public abstract class Board {

	 private Card[] cards;
	 private Deck deck;

	 
	 
	 public Board(int size,String[] name, boolean[] jew, boolean[] hair, boolean[] glass, boolean[] hat ) {
		 cards = new Card[size];
		 deck = new Deck(name, jew,hair,glass,hat);
	 }
	 public int size() {
		  return cards.length;
	}
	 public Card cardAt(int k) {
		  return cards[k];
	}
}
