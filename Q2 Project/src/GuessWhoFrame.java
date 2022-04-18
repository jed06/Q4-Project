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
import javax.swing.border.EmptyBorder;

public class GuessWhoFrame extends JFrame {
	RightPanel rightPanel;
	BottomPanel bottomPanel;
	Deck deck;

	public GuessWhoFrame() {

		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel p = new JPanel();
		p.setBackground(Color.YELLOW);
		p.setBounds(0, 0, 750, 600);
		// p.setPreferredSize(new Dimension(800, 600));
		// p.setSize(new Dimension(800, 600));
		deck = new Deck(this);
		// d.SetGlassesSelected();
		p.add(deck);

		add(p);

		rightPanel = new RightPanel();
		add(rightPanel);

		bottomPanel = new BottomPanel(this);
		add(bottomPanel);
		
		
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

	public void SetHairSelected() {
		deck.SetHairSelected();
	}
	public void SetGlassesSelected() {
		deck.SetGlassesSelected();
	}
	
	public void SetJewlerySelected() {
		deck.SetJewlerySelected();
	}
	
	
	public void CardSelected(PictureCard card) {
		rightPanel.SetSelectedPicture(card);
		System.out.println(card.getName());

	}

	private void ShowGuessDialog() {
		JDialog d = new JDialog(this, "");

		JPanel p = new JPanel();
		
		p.setBackground(Color.PINK);

		p.setLayout(new BorderLayout());
		// create a button

		JLabel l = new JLabel("PLEASE CHOOSE A CHARACTER TO GUESS !!!");

		JButton b = new JButton("OK");

		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				d.setVisible(false);
			}
		});

		p.add(l, BorderLayout.CENTER);
		p.add(b, BorderLayout.PAGE_END);

		// add panel to dialog
		d.add(p);

		// setsize of dialog
		d.setSize(300, 150);

		// set visibility of dialog
		d.setVisible(true);

	}
}
