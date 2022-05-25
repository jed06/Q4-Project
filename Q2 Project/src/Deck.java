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
	public PictureCard ComputerSelectedCard;

	private boolean isJewelrySelected;
	private boolean isGlassesSelected;
	private boolean isHairSelected;
	private boolean isHatSelected;
	
	private List<PictureCard> cards = new ArrayList();
	
	public int numXout = 0;
	
	public Deck(GuessWhoFrame container) {
		Container = container;
		this.setLayout(null);
		this.setLocation(0, 0);
		this.setPreferredSize(new Dimension(800, 600));
		int x = 0, y = 0;

		int randomCardNumber = (int)(Math.random()*17);
		Card cc = GameBoard.cards[randomCardNumber];
		
		PictureCard pc1 = new PictureCard(cc.getName(), 
				cc.getName(), 
				cc.getJewelry(), 
				cc.getFacialHair(),
				cc.getGlasses(),
				cc.getHat(),
				cc.getIndex());
		
		if (ComputerSelectedCard == null) {
			ComputerSelectedCard = pc1;
			Container.SetComputerSelectedCard(ComputerSelectedCard);
		}
		
		
		for (int i = 0; i < GameBoard.BOARD_SIZE; i++) {

			
			
			int result = i%4;
			switch(result) {
				case 0 :
					x = 0;
					break;
			default :
				x = x + 140 + 10;
			}

			int result2 = i/4;
			switch(result2) {
				case 0 :
					y = 20;
					break;
			default :
				y = (i / 4 * 140) + 20;
			}
			
			
			Card cardData = GameBoard.cards[i];
			
			PictureCard pc = new PictureCard(cardData.getName(), 
					cardData.getName(), 
					cardData.getJewelry(), 
					cardData.getFacialHair(),
					cardData.getGlasses(),
					cardData.getHat(),
					cardData.getIndex()
					);
			
			
			pc.setBounds(x, y, 120, 120);
			cards.add(pc);

			pc.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (UserSelectedCard == null) {
							String name = ((Card)e.getSource()).getName();
							for (PictureCard pc : cards) {
						        if (pc.getName().equals(name)) {
						            UserSelectedCard = pc;
						            Container.SetUserSelectedCard(UserSelectedCard);
						            break;
						        }
						    }
					}
				}
			});
			
			
			this.add(pc);
			
		}
		
	}
 
	
	public void SetJewelrySelected() {
		//isJewelrySelected = true;
		if (ComputerSelectedCard.getJewelry()) {
			for (PictureCard pc : cards) {
				if(!pc.getJewelry()) {
					pc.SetXImage();
					numXout += 1;
					getnumXout();
				}
			}
		}
		else {
			for (PictureCard pc : cards) {
				if(pc.getJewelry()) {
					pc.SetXImage();
					numXout += 1;
					getnumXout();
				}
			}
		}
	}
	public void SetHairSelected() {
		//isHairSelected = true;
		if (ComputerSelectedCard.getFacialHair()) {
			for (PictureCard pc : cards) {
				if(!pc.getFacialHair()) {
					pc.SetXImage();
					numXout += 1;
					getnumXout();
				}
			}
		}
		else {
			for (PictureCard pc : cards) {
				if(pc.getFacialHair()) {
					pc.SetXImage();
					numXout += 1;
					getnumXout();
				}
			}
		}
	}
	
	
	public void SetGlassesSelected() {
		//isGlassesSelected = true;
		if (ComputerSelectedCard.getGlasses()) {
			for (PictureCard pc : cards) {
				if(!pc.getGlasses()) {
					pc.SetXImage();
					numXout += 1;
					getnumXout();
				}
			}
		}
		else {
			for (PictureCard pc : cards) {
				if(pc.getGlasses()) {
					pc.SetXImage();
					numXout += 1;
					getnumXout();
				}
			}
		}

	}

	public void SetHatSelected() {
		//isHatSelected = true;
		if (ComputerSelectedCard.getHat()) {
			for (PictureCard pc : cards) {
				if(!pc.getHat()) {
					pc.SetXImage();
					numXout += 1;
					getnumXout();
				}
			}
		}	

	
	else {
		for (PictureCard pc : cards) {
			if(pc.getHat()) {
				pc.SetXImage();
				numXout += 1;
				getnumXout();
			}
		}
	}
	}
	public int getnumXout() {
		System.out.println(numXout);
		return numXout;
	}
	

}
