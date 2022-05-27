import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;

public class RightPanel extends JPanel {

	//PictureCard UserselectedCard = new PictureCard();
	PictureCard ComputerselectedCard = new PictureCard();
	JLabel labelattemps = new JLabel("Attemps Left: 3");
	JLabel finalGuess = new JLabel(" ");
	
	public RightPanel() {
		setLayout(new GridLayout(3, 1));
		setBounds(750, 0, 250, 600);
		setOpaque(true);
		//add(UserselectedCard);
		add(ComputerselectedCard);
		
		labelattemps.setFont(new Font("Verdana", Font.PLAIN, 18));
		add(labelattemps);
		finalGuess.setFont(new Font("Verdana", Font.PLAIN, 11));
		finalGuess.setBounds(750, 0, 250, 200);
		add(finalGuess);
		
		
		
	}
	public void setAttemps(int attempts) {
		int num = 3- attempts;
		labelattemps.setText("Attemps Left: " + num);
		if (num == 0) {
			finalGuess.setText("Click on a character and press \n the guess button to make your final guess!");
		}
	}
	/*
	 * public void SetUserSelectedPicture(PictureCard card) {
	 * 
	 * UserselectedCard.setName(card.getName());
	 * UserselectedCard.setJewelry(card.getJewelry());
	 * UserselectedCard.setFacialHair(card.getFacialHair());
	 * UserselectedCard.setGlasses(card.getGlasses());
	 * UserselectedCard.setHat(card.getHat());
	 * UserselectedCard.setIndex(card.getIndex());
	 * 
	 * UserselectedCard.SetImage(card.getImgURL());
	 * 
	 * }
	 */
 
	public void SetComputerSelectedPicture(PictureCard card) {

		ComputerselectedCard.setName(card.getName());
		ComputerselectedCard.setJewelry(card.getJewelry());
		ComputerselectedCard.setFacialHair(card.getFacialHair());
		ComputerselectedCard.setGlasses(card.getGlasses());
		ComputerselectedCard.setHat(card.getHat());
		ComputerselectedCard.setIndex(card.getIndex());
		
		ComputerselectedCard.SetImage("MysteryBox");
		
		
	}
	
	public PictureCard getComputerSelectedCard() {
		return ComputerselectedCard;
		
	}
	
}
