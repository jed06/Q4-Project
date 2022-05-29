import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
public class RightPanel extends JPanel {
	//PictureCard UserselectedCard = new PictureCard();
	Font f =new Font("Verdana", Font.PLAIN, 16);
	PictureCard ComputerselectedCard = new PictureCard();
	JLabel labelattemps = new JLabel("Attemps Left: 3");
	JTextArea finalGuess = new JTextArea(" ");
	JLabel timer = new JLabel(" ");
	GuessWhoFrame Container;
	JLabel bestScore = new JLabel();
	public RightPanel(GuessWhoFrame container) {
		Container = container;
		setLayout(null);
		setBounds(750, 0, 250, 600);
		setOpaque(true);
		//add(UserselectedCard);
		add(ComputerselectedCard);
		ComputerselectedCard.setBorderPainted(false);
		ComputerselectedCard.setBounds(0, 20, 210, 210);
		
		labelattemps.setFont(f);
		labelattemps.setBounds(20, 250, 200, 100);
		add(labelattemps);
		
		ArrayList<Integer> b = ScoresIO.readScores();
		double fastTime = 0.0;
        if (b.size() > 0) {
        	Collections.sort(b);
            fastTime = b.get(0);
        }		
        bestScore.setText("Time to beat:" + fastTime + "seconds");
        bestScore.setFont(f);
        bestScore.setForeground(new Color(102,255,179));
        bestScore.setBounds(20, 330, 200, 100);
		add(bestScore);
		
		setTimer(0);
		timer.setFont(f);
		timer.setForeground(Color.CYAN);
		timer.setBounds(20, 300, 200, 100);
		add(timer);
		setTimer(0);
		
		finalGuess.setFont(f);
		finalGuess.setBounds(20, 400, 200, 100);
		finalGuess.setEditable(false);
		finalGuess.setBackground(new Color(202, 166, 221));
		finalGuess.setLineWrap(true);
		finalGuess.setWrapStyleWord(true);					
		add(finalGuess);
	}
	public void setAttemps(int attempts) {
		int num = 3- attempts;
		labelattemps.setText("Attemps Left: " + num);
		if (num == 0) {
			finalGuess.setText("Click on a character and press the guess button to make your final guess!");
		}
	}
	public void setTimer(int currentTime) {	
		if (currentTime == 0) {
			timer.setText("Timer: 0 seconds");
		}
		else {					
		timer.setText("Timer: " + currentTime + " seconds");
		}
	}
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
