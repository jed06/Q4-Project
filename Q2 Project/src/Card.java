
public class Card {

	private String name;
	private boolean hasJewlery;
	private boolean hasFacialHair;
	private boolean hasGlasses;
	private boolean hasHat;
	
	
	
	public Card(String s, boolean j,boolean f,boolean g,boolean h) {
		name = s;
		hasJewlery = j;
		hasFacialHair = f;
		hasGlasses  = g;
		hasHat = h;
		
		
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
}
