 import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
	Timer t = new Timer(1000, this);		

	public GuessWhoFrame() {
		Color bgColor = new Color(202, 166, 221);
		GuessWhoFrame.setUndecorated(true);
		GuessWhoFrame.setBackground(bgColor);
		
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		rightPanel = new RightPanel();
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
		

		ShowGuessDialog();
		updateScreen();
	
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
		System.out.println(card.getName());
		//Add method on Right Panel to Set Computer Selected card
	}
	
	public void SetUserSelectedCard(PictureCard card) {
		rightPanel.SetUserSelectedPicture(card);
		System.out.println(card.getName());

	}

	private void ShowGuessDialog() {
		JDialog d = new JDialog(this, "");
		d.setResizable(false);
		d.setModal(true);
		d.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		d.setUndecorated(true);
		JPanel p = new JPanel();
		
		p.setBackground(new Color(243, 118, 150));

		p.setLayout(new BorderLayout());
		// create a button

		JLabel l = new JLabel(" Please choose a character for the computer to guess");
		
		
		JButton b = new JButton("OK");
		b.setCursor(new Cursor(Cursor.HAND_CURSOR));
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				d.setVisible(false);
				t.start();
				System.out.println("Timer on");
				}
			}
		);

		p.add(l, BorderLayout.CENTER);
		
		p.add(b, BorderLayout.SOUTH);

		// add panel to dialog
		
		d.add(p);
		
		// set size of dialog
		d.setSize(310, 150);
		d.setLocation(300,300);
		// set visibility of dialog
		d.setVisible(true);

	}


/*	public void showComputerQuestionDialog() {
		
		JDialog d = new JDialog(this);
		d.setResizable(false);
		d.setModal(true);
		d.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		d.setUndecorated(true);
		JPanel p = new JPanel();
			
		p.setBackground(Color.PINK);

		p.setLayout(new BorderLayout());
			
		String questionText = getNextQuestion();
		JLabel l = new JLabel(questionText);

		JButton yesb = new JButton("YES");
		JButton nob = new JButton("NO");

			yesb.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					d.setVisible(false);
					}
				}
			);
			
			nob.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					d.setVisible(false);
					}
				}
			);
			
			p.add(l, BorderLayout.CENTER);
			Panel buttonpanel = new Panel();
			buttonpanel.add(yesb);
			buttonpanel.add(nob);
			p.add(buttonpanel, BorderLayout.SOUTH);
			
			// add panel to dialog
			
			d.add(p);
			
			// set size of dialog
			d.setSize(300, 150);
			d.setLocation(300,300);
			// set visibility of dialog
			d.setVisible(true);

		
	}*/
	
	/*private String getNextQuestion() {
		int nextIndex = CCHintQuestion.Index;
		
		for(int i= 0; i < 4; i++) {
			nextIndex += 1;
			nextIndex = nextIndex % GameBoard.COMPUTER_HINT_QUESTIONS.length;
			
			if(GameBoard.COMPUTER_HINT_QUESTIONS[nextIndex].IsAnswered == false) {
				CCHintQuestion = GameBoard.COMPUTER_HINT_QUESTIONS[nextIndex];
				CCHintQuestion.IsAnswered = true;
				break;
			}
		}
		
		return CCHintQuestion.Text;
	}*/

	public void updateScreen() {
		if(deck.getnumXout() == 15) {
			LosingFrame gui = new LosingFrame();
		}
		
	}
	int time = 0;
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		time++;
		System.out.println(time);
	}
}
