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
	
	private List<Card> cards;
	private int size;
	public static int next;
	public Deck(String[] names, boolean[] jewelery, boolean[] hair, boolean[] glass, boolean[] hat) {
		this.size = 12;
		String [] picture = {"/imgs/Candy Cat.png","/imgs/Danny Dog.png","/imgs/Emily Elephant.png"};
		
		for (int i = 0; i < size; i++) {
			//cards.add(new Card(names[i], jewelery[i], hair[i], glass[i], hat[i]));
			//Card.img = getImage(picture[next]);
		}
			  
			  
		next +=1;	 
				  
			 
	}
	public int size() {
		  return size;
		 }
	
	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = Deck.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
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
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
Graphics2D g2 = (Graphics2D) g;
		
		
		//call update to update the actually picture location
		
		
		g2.drawImage(img, tx, null);
	}

}
