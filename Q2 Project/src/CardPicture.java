import java.awt.Cursor;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class CardPicture extends Picture {
	
	
	public CardPicture(String imgURL, int x, int y) {
		super(imgURL + ".png", x, y, 0.25, 0.25);
		
	}
}
