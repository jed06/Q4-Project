import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class PictureCard extends Card {

	public PictureCard() {

	}

	public PictureCard(String name, String imgURL, boolean hasJewelry, boolean hasHair, boolean hasGlasses,
			boolean hasHat, int index) {
		super(name, imgURL, hasJewelry, hasHair, hasGlasses,hasHat, index);
		 //Image img = getXImage();
		Image img = getImage(imgURL);

		Image newimg = img.getScaledInstance(117, 117, java.awt.Image.SCALE_SMOOTH);
		ImageIcon icon = new ImageIcon(newimg);

		setIcon(icon);
		setContentAreaFilled(true);
		setMargin(new Insets(0, 0, 0, 0));
		setFocusPainted(true);
		setCursor(new Cursor(Cursor.HAND_CURSOR));

		setHorizontalAlignment(SwingConstants.CENTER);
		setVerticalAlignment(SwingConstants.CENTER);

	}

	private Image getXImage() {
		// Image tempImage = null;

		BufferedImage combinedImage = null;

		try {

			String overlayPath = getClass().getResource("/imgs/overlay.png").getPath();
			overlayPath = overlayPath.replace("%20", " ");
			BufferedImage overlay = ImageIO.read(new File(overlayPath));
			
			String imgPath = getClass().getResource("/imgs/" + getImgURL() + ".png").getPath();

			imgPath = imgPath.replace("%20", " ");

			BufferedImage image = ImageIO.read(new File(imgPath));
			Image image2 = image.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);

			combinedImage = new BufferedImage(100, 100, BufferedImage.TRANSLUCENT);

			// paint both images, preserving the alpha channels
			Graphics g = combinedImage.getGraphics();

			g.drawImage(image2, 0, 0, null);
			g.drawImage(overlay, 0, 0, null);
			

			g.dispose();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return combinedImage;
	}
	
	public Image getImage(String name) {
		
		Image tempImage = null;
		try {
			URL imageURL = Picture.class.getResource("/imgs/" + name + ".png");

			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return tempImage;
	}

	public void SetXImage() {
		Image img = getXImage();
		ImageIcon icon = new ImageIcon(img);
		setIcon(icon);
	}

	public void SetImage(String name) {
		if(name != null && name.length() > 0) {
			Image img = getImage(name);
			Image newimg = img.getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH);
			ImageIcon icon = new ImageIcon(newimg);
			setIcon(icon);
		}
	}
}
