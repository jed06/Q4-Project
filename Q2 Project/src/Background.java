import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Background{
	
	//image related variables
	private int x, y;
	private Image img; 	
	private AffineTransform tx;

	public Background(int x, int y) {
		img = getImage("/imgs/images.png"); //load the image for Tree
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
		tx.scale(5, 5);
	}

	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = Background.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}

}
