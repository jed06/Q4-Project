import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;

public class Deck extends JPanel {

	public GuessWhoFrame Container;
	public PictureCard UserSelectedCard;

	private boolean isJewlerySelected;
	private boolean isGlassesSelected;
	private boolean isHairSelected;
	
	private List<PictureCard> cards = new ArrayList();

	public Deck(GuessWhoFrame container) {
		Container = container;
		this.setLayout(null);
		this.setPreferredSize(new Dimension(800, 600));
		int x = 0, y = 0;

		for (int i = 0; i < GameBoard.BOARD_SIZE; i++) {

			if (i % 4 == 0) {
				x = 50;
			} else {
				x = x + 140 + 10;
			}

			if (i / 4 == 0) {
				y = 20;
			} else {
				y = (i / 4 * 140) + 20;
			}

			PictureCard c = new PictureCard(GameBoard.NAMES[i], GameBoard.NAMES[i], GameBoard.JEW[i], GameBoard.HAIR[i],
					GameBoard.GLASS[i], GameBoard.HAT[i], i);
			c.setBounds(x, y, 120, 120);
			cards.add(c);

			c.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (UserSelectedCard == null) {
							String name = ((Card)e.getSource()).getName();
							for (PictureCard pc : cards) {
						        if (pc.getName().equals(name)) {
						            UserSelectedCard = pc;
						            Container.CardSelected(UserSelectedCard);
						            break;
						        }
						    }
					}
				}
			});

			this.add(c);
		}
	}

	public void SetHairSelected() {
		isHairSelected = true;
		for (PictureCard pc : cards) {
			if (pc.getFacialHair()) {
				pc.SetXImage();
			}
		}
	}
	
	public void SetGlassesSelected() {
		isGlassesSelected = true;
		for (PictureCard pc : cards) {
			if (pc.getGlasses()) {
				pc.SetXImage();
			}
		}
	}

	public void SetJewlerySelected() {
		isJewlerySelected = true;
		for (PictureCard pc : cards) {
			if (pc.getJewlery()) {
				pc.SetXImage();
			}
		}
	}

}
