import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.*;

public class BGPanel extends JPanel {

	Picture bg = new Picture("images.png");
	
	
	public BGPanel() {
		
		setLayout(null);
		setBounds(0, 600, 750, 150);
		setBackground(Color.red);
		

	}	
}
