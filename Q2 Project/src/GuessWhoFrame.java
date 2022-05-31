 import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.print.attribute.standard.DateTimeAtCompleted;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.WindowConstants;
public class GuessWhoFrame extends JFrame implements ActionListener {
	RightPanel rightPanel;
	BottomPanel bottomPanel;
	Deck deck;
	HintQuestion CCHintQuestion = GameBoard.HINT_QUESTIONS[0];
	JLabel QuestionLabel;
	JButton GuessButton;
	JFrame GuessWhoFrame = new JFrame();
	int time = 0;
	Timer t = new Timer(1000, this);		
	private PictureCard UserSelectedCard = new PictureCard();
	int numofAttempts = 0;	
	public void setguessAttempted() {
		numofAttempts+= 1;
		if(numofAttempts == 3) {
		}
		rightPanel.setAttemps(numofAttempts);
	}	
	public int getguessAttempted() {
		return numofAttempts;
	}	
	public GuessWhoFrame() {
		Color bgColor = new Color(202, 166, 221);
		GuessWhoFrame.setUndecorated(true);
		GuessWhoFrame.setBackground(bgColor);		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		rightPanel = new RightPanel(this);
 		rightPanel.setBackground(bgColor);
		add(rightPanel);		
		bottomPanel = new BottomPanel(this);
		add(bottomPanel);
		bottomPanel.setBackground(bgColor);
		JPanel p = new JPanel();
		p.setBackground(bgColor);
		p.setBounds(0, 0, 750, 600);		
		deck = new Deck(this);	
		deck.setBackground(bgColor);	
		p.add(deck);
		add(p);
		JPanel p3 = new JPanel();
		p3.setBounds(750, 600, 250, 100);
		p3.setBackground(bgColor);		
		pack();
		setSize(new Dimension(1000, 750));
		setVisible(true);
		updateScreen();		
		t.start();		
	}
	public void SetJewelrySelected() {
		deck.SetJewelrySelected();
	}
	public void SetHairSelected() {
		deck.SetHairSelected();
	}
	public void SetGlassesSelected() {
		deck.SetGlassesSelected();
	}
	public void SetHatSelected() {
		deck.SetHatSelected();
	}
	public void SetComputerSelectedCard(PictureCard card)
	{
		rightPanel.SetComputerSelectedPicture(card);
		//System.out.println("Mystery Character: "+ card.getName());
		//Add method on Right Panel to Set Computer Selected card
	}
	public PictureCard getComputerSelectedCard() {
		return rightPanel.ComputerselectedCard;	
	}
	public void SetUserSelectedCard(PictureCard card) {
		UserSelectedCard = card;
		System.out.println(card.getName());

	}
	public PictureCard GetUserSelectedCard() {
		return UserSelectedCard;		
	}
	public void updateScreen() {		 
	}	
	public void gameOver() {
		t.stop();
		ScoresIO.addScore(time);
		for (HintQuestion i : GameBoard.HINT_QUESTIONS) {
			i.IsAnswered = false;
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		time++;
		//System.out.println(time);
		//if (time%100 == 0) {
			setTime();
		//}
	}
	public int getTime() {
		return time;
	}
	public void setTime() {
		rightPanel.setTimer(time);
	}	
}
