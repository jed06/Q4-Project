import java.util.Random;

public class Card {

	 String name;
	 boolean hasJewlery;
	 boolean hasFacialHair;
	 boolean hasGlasses;
	 boolean hasHat;
	 Card HJ;
	
	
	
	public Card(String s, boolean j,boolean f,boolean g,boolean h) {
		Random r = new Random();
		name = s;
		hasJewlery = j;
		hasFacialHair = f;
		hasGlasses  = g;
		hasHat = h;
		int rnd = r.nextInt();
		//HJ = cards[rnd];
		//wanted to create a random card 
		
	}
	public String getName() {
		return name;
	}
	
	public boolean getJewlery() {
		return hasJewlery;
	}
	public boolean getFacialHair() {
		return hasFacialHair;
	}
	public boolean getGlasses() {
		return hasGlasses;
	}
	public boolean getHat() {
		return hasHat;
	}
	public boolean jewMatch(Card selectedCard) {
		if(this.getJewlery() == selectedCard.getJewlery()) {
			return true;
		}
		return false;
	}
	public boolean hairMatch(Card selectedCard) {
		if(this.getFacialHair() == selectedCard.getFacialHair()) {
			return true;
		}
		return false;
	}
	public boolean glassMatch(Card selectedCard) {
		if(this.getGlasses() == selectedCard.getGlasses()) {
			return true;
		}
		return false;
	}
	public boolean hatMatch(Card selectedCard) {
		if(this.getHat() == selectedCard.getHat()) {
			return true;
		}
		return false;
	}
	public boolean absoluteMatch() {
		if(jewMatch(HJ)&& hairMatch(HJ)&&glassMatch(HJ)&&hatMatch(HJ) ) {
			return true;
		}
		return false;
	}
}
