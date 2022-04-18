import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.*;

public class RightPanel extends JPanel {

	PictureCard selectedCard = new PictureCard();

	public RightPanel() {
		setLayout(new GridLayout(3, 1));
		setBounds(750, 0, 250, 600);
		setBackground(Color.GREEN);

		add(selectedCard);
		add(new JLabel("Middle"));
		add(new JLabel("Bottom"));

	}

	public void SetSelectedPicture(PictureCard pc) {
		selectedCard.SetImage(pc.getImgURL());
	}
}
