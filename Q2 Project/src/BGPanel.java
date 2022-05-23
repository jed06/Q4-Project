import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.*;

public class BGPanel extends JPanel {

	Picture bg = new Picture("images.png");
	
	
	public BGPanel() {
		
		setBounds(0, 0, 750, 600);
		

		add(bg);
		

	}	
}
