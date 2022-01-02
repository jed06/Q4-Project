import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.net.URL;
import java.util.Random;

public class Star{
	
	//add location attributes
	public int x; //position of the bird
	int y;
	private Image img; 	
	private AffineTransform tx;
	private double vy = 0;
	private double ay = 6.5;
	int w = 100, h = 100;
	Random rn = new Random();
	public Star(int x, int y) {
		this.x = x;
		this.y = y;
		img = getImage("/imgs/MerryUnlawfulIsopod-size_restricted.gif"); //load the image for Tree
		

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
		
		y += vy; // velocity in y affects y location
		vy = ay;
				
		// prevent bird from leaving top of frame
		
		if (y > 850) {
			y = -315;
			x = rn.nextInt(700 - 10 + 1) + 10;
		}
		
		tx.setToTranslation(x, y);
		tx.scale(0.4, 0.4);
	}
	
	
	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(.5, .5);
	}

	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = Star.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}
}
