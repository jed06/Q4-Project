
public class Card {

	
	private boolean jewlery;
	private boolean facialHair;
	private boolean glasses;
	private boolean hat;
	
	
	
	public Card(boolean j,boolean f,boolean g,boolean h) {
		jewlery = j;
		facialHair = f;
		glasses  = g;
		hat = h;
		
	}
	
	
	public boolean getJewlery() {
		return jewlery;
	}
	public boolean getFacialHair() {
		return facialHair;
	}
	public boolean getGlasses() {
		return glasses;
	}
	public boolean getHat() {
		return hat;
	}
}
