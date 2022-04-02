
public class Card {

	private String name;
	private boolean jewlery;
	private boolean facialHair;
	private boolean glasses;
	private boolean hat;
	
	
	
	public Card(String s, boolean j,boolean f,boolean g,boolean h) {
		name = s;
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
