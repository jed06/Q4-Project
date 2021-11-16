import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Obstacle1{
	
	//add location attributes
	public int x; //position of the bird
	int y;
	private Image img; 	
	private AffineTransform tx;
	private double vy = 0;
	private double ay = 4.5;
	int w = 100, h = 300;
	public Obstacle1(int x, int y) {
		this.x = x;
		this.y = y;
		img = getImage("/imgs/covid.png"); //load the image for Tree
		

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
			y = -310;
			
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
			URL imageURL = Obstacle1.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}

}