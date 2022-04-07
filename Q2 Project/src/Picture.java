import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.net.URL;

//Base Picture class for all images


public class Picture{
	
	//image related variables
	private int X, Y;
	private Image img; 	
	private AffineTransform tx;
	private double SX = 0.5;// scale x
	private double SY  = 0.5;// scale y
	public double bvy = 0;
	String imageName = "";
	
	public Picture(String imageName, int x, int y, double sx, double sy) {
		this.imageName = imageName;
		
		img = getImage("/imgs/" + imageName); //
		X = x;
		Y = y;
		
		SX = sx;
		SY = sy;
		
		tx = AffineTransform.getTranslateInstance(X, Y );
		init(X, Y); 		
	}
	

	public Picture(String imageName, int x, int y, double sx, double sy, double bvy) {
		img = getImage("/imgs/" + imageName); //
		X = x;
		Y = y;
		
		SX = sx;
		SY = sy;
		this.bvy = bvy;
		tx = AffineTransform.getTranslateInstance(X, Y );
		init(X, Y); 		
	}

	
	public Picture(String imageName, int x, int y) {
		img = getImage("/imgs/" + imageName); //
		X = x;
		Y = y;
		tx = AffineTransform.getTranslateInstance(X, Y);
		init(X, Y); 		
	}

	public Picture(String imageName) {
		img = getImage("/imgs/" + imageName); //
		tx = AffineTransform.getTranslateInstance(X, Y);
		init(X, Y); 		
	}

	public void changePicture(String newFileName) {
		img = getImage(newFileName);
		init(X, Y);
	}
	
	
	private void update() {
		if (bvy != 0) {
			if(Y > 500) {
				bvy *= -1;
			}
			if(Y < 400) {
				bvy *= -1;
			}
			Y = (int) (Y + bvy);
		}
		
		tx.setToTranslation(X, Y);
		tx.scale(SX	, SY);
		
		//System.out.println("SX SY"  + SX + ", " + SY + "X Y " + "X" + X  + ", Y" + Y );
		
		//System.out.println("SX SY"  + SX + ", " + SY + "X Y " + "X" + X  + ", Y" + Y );
		
	}
	
	
	
	/* Drawing commands */
	public void paint(Graphics g) {
		//these are the 2 lines of code needed draw an image on the screen
		Graphics2D g2 = (Graphics2D) g;		
		
		update();
		
		
		g2.drawImage(img, tx, null);
		
		
	}

	   
	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(SX, SY);
	}

	private Image getImage(String path) {
		//System.out.println(path);
		Image tempImage = null;
		try {
			URL imageURL = Picture.class.getResource(path);
			//System.out.println(imageURL);
			
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}
}
