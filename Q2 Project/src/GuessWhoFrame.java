import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

public class GuessWhoFrame extends JFrame {
	RightPanel rightPanel;
	BottomPanel bottomPanel;
	Deck deck;
	HintQuestion CCHintQuestion = GameBoard.HINT_QUESTIONS[0];
	JLabel QuestionLabel;
	public GuessWhoFrame() {

		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		rightPanel = new RightPanel();
		add(rightPanel);
		bottomPanel = new BottomPanel(this);
		add(bottomPanel);
		
		JPanel p = new JPanel();
		p.setBackground(Color.YELLOW);
		p.setBounds(0, 0, 750, 600);
		// p.setPreferredSize(new Dimension(800, 600));
		// p.setSize(new Dimension(800, 600));
		deck = new Deck(this);
		// d.SetGlassesSelected();
		p.add(deck);

		add(p);

		
		
		JPanel p3 = new JPanel();
		p3.setBounds(750, 600, 250, 100);
		p3.setBackground(Color.RED);
		// p3.setSize(new Dimension(100, 100));
		add(p3);

		pack();

		// this.setContentPane(p);
		setSize(new Dimension(1000, 750));
		setVisible(true);

		ShowGuessDialog();
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
		
		p.setBackground(Color.PINK);

		p.setLayout(new BorderLayout());
		// create a button

		JLabel l = new JLabel("      PLEASE CHOOSE A CHARACTER TO GUESS!!!");
		
		JButton b = new JButton("OK");

		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				d.setVisible(false);
				}
			}
		);

		p.add(l, BorderLayout.CENTER);
		p.add(b, BorderLayout.SOUTH);

		// add panel to dialog
		
		d.add(p);
		
		// setsize of dialog
		d.setSize(300, 150);
		d.setLocation(300,300);
		// set visibility of dialog
		d.setVisible(true);

	}


	public void showComputerQuestionDialog() {
		
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
			
			// setsize of dialog
			d.setSize(300, 150);
			d.setLocation(300,300);
			// set visibility of dialog
			d.setVisible(true);

		
	}
	
	private String getNextQuestion() {
		int nextIndex = CCHintQuestion.Index;
		
		for(int i= 0; i < 4; i++) {
			nextIndex += 1;
			nextIndex = nextIndex % GameBoard.HINT_QUESTIONS.length;
			
			if(GameBoard.HINT_QUESTIONS[nextIndex].IsAnswered == false) {
				CCHintQuestion = GameBoard.HINT_QUESTIONS[nextIndex];
				CCHintQuestion.IsAnswered = true;
				break;
			}
		}
		
		return CCHintQuestion.Text;
	}

	
}
