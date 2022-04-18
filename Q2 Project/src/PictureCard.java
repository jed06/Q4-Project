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

	public PictureCard(String name, String imgURL, boolean hasJewelery, boolean hasHair, boolean hasGlasses,
			boolean hasHat, int index) {
		super(name, imgURL, hasJewelery, hasHair, hasGlasses, hasHat, index);

		 //Image img = getXImage();
		Image img = getImage(imgURL);

		Image newimg = img.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
		ImageIcon icon = new ImageIcon(newimg);

		setIcon(icon);
		setContentAreaFilled(true);
		setMargin(new Insets(5, 5, 5, 5));
		setFocusPainted(true);
		setCursor(new Cursor(Cursor.HAND_CURSOR));

		setHorizontalAlignment(SwingConstants.RIGHT);
		setVerticalAlignment(SwingConstants.CENTER);

	}

	private Image getXImage() {
		// Image tempImage = null;

		BufferedImage combinedImage = null;

		try {


			BufferedImage overlay = ImageIO.read(new File(getClass().getResource("/imgs/overlay.png").getPath()));
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
	
	private Image getImage(String name) {
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
		Image img = getImage(name);
		Image newimg = img.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
		ImageIcon icon = new ImageIcon(newimg);
		setIcon(icon);
	}
}
