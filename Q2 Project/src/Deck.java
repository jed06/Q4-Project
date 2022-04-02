import java.util.List;
import java.util.ArrayList;

public class Deck {
	private List<Card> cards;
	private int size;
	
	
	public Deck(boolean[] jew, boolean[] hair, boolean[] glass, boolean[] hat  ) {
		for (int j = 0; j < jew.length; j++) {
			   for (int k = 0; k<jew.length; k++) {
			    cards.add(new Card(jew[k], hair[k], glass[k], hat[k]));
			   }
			  }
			  size = cards.size();
			  shuffle();
			 
	}
	public int size() {
		  return size;
		 }
	public void shuffle() {
		  for (int k = cards.size() - 1; k > 0; k--) {
		   int howMany = k + 1;
		   int start = 0;
		   int randPos = (int) (Math.random() * howMany) + start;
		   Card temp = cards.get(k);
		   cards.set(k, cards.get(randPos));
		   cards.set(randPos, temp);
		  }
		  size = cards.size();
		 }

}
