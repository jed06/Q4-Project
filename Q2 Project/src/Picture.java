import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.net.URL;

import javax.swing.*;


//Base Picture class for all images


public class Picture extends JPanel  implements ActionListener {
	
	//image related variables
	private int X, Y;
	private Image img; 	
	private AffineTransform tx;
	private double SX = 0.5;// scale x
	private double SY  = 0.5;// scale y
	public double bvy = 0;
	String imageName = "";
	
	public Picture(String imageName, int x, int y, double sx, double sy, double bvy) {		
		img = getImage("/imgs/" + imageName); //
		X = x;
		Y = y;
		
		SX = sx;
		SY = sy;
		this.bvy = bvy;
		tx = AffineTransform.getTranslateInstance(X, Y );
		tx.setToTranslation(x, y);
		tx.scale(sx, sy);	
		this.setBounds(x, y, 100, 100);
		setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		this.setBackground(Color.cyan);
		
	}

	public Picture(String imageName, int x, int y, double sx, double sy) {
		this(imageName, x, y , sx, sy, 0);
	}
	
	public Picture(String imageName, int x, int y) {
		this(imageName, x, y , 0.5, 0.5); 		
	}

	public Picture(String imageName) {
		this(imageName, 0, 0);
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
	}
		
	/* Drawing commands */
	public void paint(Graphics g) {
		//these are the 2 lines of code needed draw an image on the screen
		Graphics2D g2 = (Graphics2D) g;		
		update();
		g2.drawImage(img, tx, null);
		
		setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		setBackground(Color.cyan);
	
	}
 
	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(SX, SY);
	}

	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = Picture.class.getResource(path);
			
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.print(e.getID());
		
	}
}
