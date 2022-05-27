import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class BottomPanel  extends JPanel{
	
	JButton PreviousButton, NextButton, YesButton, GuessButton;
	JLabel QuestionLabel;	
	HintQuestion CurrentHintQuestion = GameBoard.HINT_QUESTIONS[0];
	
	GuessWhoFrame Container;
	
	public BottomPanel(GuessWhoFrame container) {
		Container = container;
		int x = 20;
		
		setLayout(null);
		
		setBounds(0, 600, 950, 150);
		setOpaque(true);		
		PreviousButton = new JButton();
		PreviousButton.setBounds(20, 10, 50, 50);
		
		ImageIcon prevIcon = getIcon("previous_button");
		PreviousButton.setIcon(prevIcon);
		PreviousButton.setContentAreaFilled(false);
		PreviousButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		PreviousButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			SetPreviousQuestion();	
			}
		});
		
		QuestionLabel = new JLabel("");
		QuestionLabel.setBounds(100, 10, 400, 50);
		QuestionLabel.setFont(new Font("Verdana", Font.PLAIN, 18));
		Border blackline = BorderFactory.createLineBorder(Color.black);
		QuestionLabel.setBorder(blackline);
		QuestionLabel.setVerticalAlignment(SwingConstants.CENTER);
		QuestionLabel.setHorizontalAlignment(SwingConstants.CENTER);
		UpdateLabelText() ;
		
	
		NextButton = new JButton(">");
		NextButton.setBounds(520, 10, 50, 50);
		NextButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		ImageIcon nextIcon = getIcon("next_button");
		NextButton.setIcon(nextIcon);
		NextButton.setContentAreaFilled(false);
		
		NextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SetNextQuestion();
			}
		});
		
		YesButton = new JButton("Ask");
		YesButton.setBounds(600, 10, 80, 50);
		YesButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		YesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			System.out.println("num of attemps : " + container.getguessAttempted());
				if (container.getguessAttempted() < 3) {
					container.setguessAttempted();
				}
				if(container.getguessAttempted() == 3) {
					
					YesButton.setEnabled(false);
				}
				
				CurrentHintQuestion.IsAnswered = true;
				if(CurrentHintQuestion.HasJewelry) {
					UpdateLabelText();
					container.SetJewelrySelected();
				}
				else if(CurrentHintQuestion.HasHair) {
					UpdateLabelText();
					container.SetHairSelected();
				}
				else if(CurrentHintQuestion.HasGlasses) {
					UpdateLabelText();
					container.SetGlassesSelected();
				}
				else if(CurrentHintQuestion.HasHat) {
					UpdateLabelText();
					container.SetHatSelected();
				}
				
				//container.showComputerQuestionDialog();
			}
		});
		GuessButton = new JButton("GUESS");
		GuessButton.setBounds(830,10,80,50);
		GuessButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		GuessButton.setBackground(new Color(243, 118, 150));
		GuessButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(GuessButton.isEnabled()){
					System.out.println("GuessButton is pressed");
					PictureCard csc = container.getComputerSelectedCard();
					PictureCard usc = container.GetUserSelectedCard();
					if (csc.getName() == usc.getName()) {
						container.setVisible(false);   
			            WinningFrame gui = new WinningFrame();
					}
					else {
						container.setVisible(false);   
			            LosingFrame gui = new LosingFrame();
					}
					}
				}
			});
		
		
		
		this.add(PreviousButton);
		this.add(QuestionLabel);
		this.add(NextButton);
		this.add(YesButton);	
		this.add(GuessButton);
	}
	private void SetNextQuestion() {
	int nextIndex = CurrentHintQuestion.Index;
		
	for(int i= 0; i < 9; i++) {
		nextIndex += 1;
		nextIndex = nextIndex % GameBoard.HINT_QUESTIONS.length;
			
		if(GameBoard.HINT_QUESTIONS[nextIndex].IsAnswered == false) {
			CurrentHintQuestion = GameBoard.HINT_QUESTIONS[nextIndex];
			break;
		}
	}
		
	UpdateLabelText() ;
	}
	
	private void SetPreviousQuestion() {
		int previousIndex = CurrentHintQuestion.Index;
		
		for(int i= 0; i < 9; i++) {
			
			previousIndex -= 1;
			
			if(previousIndex < 0) {
				previousIndex = 8;
			}
			
			if(GameBoard.HINT_QUESTIONS[previousIndex].IsAnswered == false) {
				CurrentHintQuestion = GameBoard.HINT_QUESTIONS[previousIndex];
				break;
			}
		}
		
		UpdateLabelText() ;
	}
	
	
	private ImageIcon getIcon(String name) {
		ImageIcon icon = new ImageIcon(getImage(name));
		
		return icon;
	}
	private void UpdateLabelText() {
		QuestionLabel.setText(CurrentHintQuestion.Text /*+ " " + CurrentHintQuestion.IsAnswered*/);
	}
	
	private Image getImage(String name) {
		Image tempImage = null;
		try {
			URL imageURL = Picture.class.getResource("/imgs/" + name + ".png");

			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);

			tempImage = tempImage.getScaledInstance(60, 60, java.awt.Image.SCALE_SMOOTH);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return tempImage;
	}
}
