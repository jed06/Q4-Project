import java.awt.*;
import java.awt.Insets;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Card extends JButton {

	private String name;
	private boolean hasJewlery;
	private boolean hasHair;
	private boolean hasGlasses;
	private boolean hasHat;
	private int x, y;
	private String imgURL;

	public Card() {
		this.setBackground(Color.CYAN);
	}

	public Card(String name, String imgURL, boolean hasJewelery, boolean hasHair, boolean hasGlasses, boolean hasHat,
			int index) {
		// this.setText(name);
		this.setBackground(Color.PINK);
		this.name = name;
		this.hasJewlery = hasJewelery;
		this.hasHair = hasHair;
		this.hasGlasses = hasGlasses;
		this.hasHat = hasHat;
		this.imgURL = imgURL;
	}

	public void printInfo() {
		System.out.println("name" + "," + "imgURL" + "," + "hasJewelery" + "," + "hasHair" + "," + "hasGlasses" + ","
				+ "hasHat" + "," + "index");
	}

	public String getImgURL() {
		String url = imgURL.replace("%20", " ");
		return url;
	}

	public String getName() {
		return name;
	}

	public boolean getJewlery() {
		return hasJewlery;
	}

	public boolean getFacialHair() {
		return hasHair;
	}

	public boolean getGlasses() {
		return hasGlasses;
	}

	public boolean getHat() {
		return hasHat;
	}

}
