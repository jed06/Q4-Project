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
	private boolean hasFacialHair;
	private boolean hasGlasses;
	private boolean hasHat;
	private int x, y;
	protected static Image img; 	
	private AffineTransform tx;
	
	
	public Card(String s, boolean j,boolean f,boolean g,boolean h) {
		name = s;
		hasJewlery = j;
		hasFacialHair = f;
		hasGlasses  = g;
		hasHat = h;
		
		
	}
	   
	
	public void paint(Graphics g) {
		//these are the 2 lines of code needed draw an image on the screen
		Graphics2D g2 = (Graphics2D) g;
		
		
		//call update to update the actually picture location
		
		
		
		
		
		g2.drawImage(img, tx, null);
		
		

	}
		private void init(double a, double b) {
			tx.setToTranslation(a, b);
			tx.scale(0.3, 0.3);
		}

	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = gif.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
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
