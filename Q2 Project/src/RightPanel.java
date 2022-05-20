import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.*;

public class RightPanel extends JPanel {

	PictureCard UserselectedCard = new PictureCard();
	PictureCard ComputerselectedCard = new PictureCard();
	
	public RightPanel() {
		setLayout(new GridLayout(3, 1));
		setBounds(750, 0, 250, 600);
		setOpaque(true);

		add(UserselectedCard);
		add(ComputerselectedCard);
		//add(new JLabel("Middle"));
		//add(new JLabel("Bottom"));

	}

	public void SetUserSelectedPicture(PictureCard card) {
		
		UserselectedCard.setName(card.getName());
		UserselectedCard.setJewelry(card.getJewelry());
		UserselectedCard.setFacialHair(card.getFacialHair());
		UserselectedCard.setGlasses(card.getGlasses());
		UserselectedCard.setHat(card.getHat());
		UserselectedCard.setIndex(card.getIndex());
		
		UserselectedCard.SetImage(card.getImgURL());		
	
	}
 
	public void SetComputerSelectedPicture(PictureCard card) {

		ComputerselectedCard.setName(card.getName());
		ComputerselectedCard.setJewelry(card.getJewelry());
		ComputerselectedCard.setFacialHair(card.getFacialHair());
		ComputerselectedCard.setGlasses(card.getGlasses());
		ComputerselectedCard.setHat(card.getHat());
		ComputerselectedCard.setIndex(card.getIndex());
		
		ComputerselectedCard.SetImage(card.getImgURL());
		
		
	}
}
