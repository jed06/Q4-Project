import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class rpic{
	
	//image related variables
	private int x, y;
	private Image img; 	
	private AffineTransform tx;
	public int bvy = 1;

	public rpic(int x, int y) {
		img = getImage("/imgs/r.png"); //load the image for Tree
		this.x = x;
		this.y = y;
		tx = AffineTransform.getTranslateInstance(x, y );
		init(x, y); 		
	}

	public void changePicture(String newFileName) {
		img = getImage(newFileName);
		init(x, y);
	}
	/* update variables here */
	private void update() {
		if(y>500) {
			bvy *= -1;
		}
		if(y < 385) {
			bvy *= -1;
		}
		y = y + bvy;
		
		tx.setToTranslation(x, y);
		tx.scale(.07	, .07);
	}
	
	/* Drawing commands */
	public void paint(Graphics g) {
		//these are the 2 lines of code needed draw an image on the screen
		Graphics2D g2 = (Graphics2D) g;
		
		
		//call update to update the actually picture location
		update();
		
		
		
		
		g2.drawImage(img, tx, null);
		
		

	}

	   
	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(0.3, 0.3);
	}

	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = rpic.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}

}