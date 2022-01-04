import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Peppa{
	
	//add location attributes
	public int x, y; //position of the bird
	private Image img; 	
	private AffineTransform tx;
	private int vy = 0;
	private int xy = 6;
	
	public Peppa(int x, int y) {
		this.x = x;
		this.y = y;
		img = getImage("/imgs/pepaweyes.png"); //load the image for Tree

		tx = AffineTransform.getTranslateInstance(x, y );
		init(x, y); 				//initialize the location of the image
									//use your variables
			
	}
	
	
	public void changePicture(String newFileName) {
		img = getImage(newFileName);
		init(x, y);
	}
	
	public void paint(Graphics g) {
		//these are the 2 lines of code needed draw an image on the screen
		Graphics2D g2 = (Graphics2D) g;

		//call update to update the picture location
		update();
		g2.drawImage(img, tx, null);		

	}
	
	/* update the picture variable location */
	private void update() {
		// update y location based on velocity in y
	
		
		
		// prevent peppa from leaving frame boundaries
		
		if (y < 10) {
			y = 10;
			vy = 0;
		}
		
		if (y > 390) {
			y = 390;
			vy = 0;
		}
		
		if (x < 0) {
			x = 0;
			xy = 0;
		}
		if (x > 690) {
			x = 690;
			xy = 0;
		}
		tx.setToTranslation(x, y);
		tx.scale(0.25, 0.25);
	}
	
	
	public void flap () {		
		// what's the intent if we command the peppa to flap		
		y -= 40;		
		
	}
	
	public void moveRight () {// move right
		x+= 15;
	}
	public void moveLeft () {// move left
		x-= 15;
	}
	public void moveDown () {// move down
		y+= 15;
	}
	public void moveUp () {// move up
		y-= 15;
	}
	
	
	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(.5, .5);
	}

	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = Peppa.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}

}
