import java.util.List;
import java.util.Random;
import java.util.ArrayList;

public class Deck {
	private List<Card> cards;
	private int size;
	public static int next;
	public Deck(String[] names, boolean[] jewelery, boolean[] hair, boolean[] glass, boolean[] hat) {
		this.size = 12;
		String[] picture = {"/imgs/Candy Cat.png", "/imgs/Danny Dog.png", "/imgs/Emily Elephant.png"};
		
		for(int i = 0; i<size; i++) {
			
		//card[i] = 
			
			
		}
		
		
		next++;
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
