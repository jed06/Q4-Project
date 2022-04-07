import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.net.URL;


public class Card {

	private String name;
	private boolean hasJewlery;
	private boolean hasHair;
	private boolean hasGlasses;
	private boolean hasHat;
	private int x, y;
	private CardPicture pic; 	
	private AffineTransform tx;
	

	public Card(String name, String imgURL, boolean hasJewelery, boolean hasHair, boolean hasGlasses, boolean hasHat, int index, int x , int y) {
		this.name = name;
		this.hasJewlery = hasJewlery;
		this.hasHair = hasHair;
		this.hasGlasses  = hasGlasses;
		this.hasHat = hasHat;
		
		
		pic = new CardPicture(imgURL,  x,  y);
	}
	   
	public void printInfo() {
		System.out.println("name" + "," + "imgURL" + "," + "hasJewelery" + "," + "hasHair" + "," + "hasGlasses" + "," + "hasHat" + "," + "index");
	}
	
	
	public boolean getJewlery() {
		return hasJewlery;
	}
	public boolean getFacialHair() {
		return hasHair;
	}
	public boolean getGlasses() {
		return hasGlasses;
	}
	public boolean getHat() {
		return hasHat;
	}




	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		pic.paint(g);
		
	}
}
