import java.util.List;
import java.util.Random;
import java.util.ArrayList;

public class Deck {
	private List<Card> cards;
	private int size;
	
	public Deck(String[] names, boolean[] jewelery, boolean[] hair, boolean[] glass, boolean[] hat) {
		cards = new ArrayList<Card>();
		
		for (int i = 0; i <= names.length; i++) {
			Card c = new Card(names[i], jewelery[i], hair[i], glass[i], hat[i]);
			cards.add(c);
		}
	}
	public void Deck2( String[] n, boolean[] jew, boolean[] hair, boolean[] glass, boolean[] hat  ) {
		for (int j = 0; j < jew.length; j++) {
			   for (int k = 0; k<jew.length; k++) {
			    cards.add(new Card(n[k], jew[k], hair[k], glass[k], hat[k]));
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
