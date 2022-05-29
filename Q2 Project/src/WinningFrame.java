import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.*;   
public class WinningFrame extends JPanel implements ActionListener, KeyListener{	 
	Picture bg 	= new Picture("winningScreen.png", 0, 0, 1.0, 1.0);	
	JFrame f = new JFrame("Guess Peppa");	
	JButton backHome;
	public WinningFrame() {		
		backHome = new JButton("OK");
		backHome.setBounds(10, 64, 10, 10);		
		f.setSize(new Dimension(1000, 760));
		f.setBackground(Color.blue);
		f.add(this);
		f.setResizable(false);
		f.setLayout(new GridLayout(1,2));
		f.addKeyListener(this);
		Timer t = new Timer(16, this);
		t.start();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    f.setVisible(true);   
	}		
	private ImageIcon getIcon(String string) {
		// TODO Auto-generated method stub
		return null;
	}
	public void paint(Graphics g) {
		//background before games begins
		//ask the objects to paint themselves
		super.paintComponent(g);
		bg.paint(g);
		g.setColor(Color.black);
		g.setFont(new Font ("Serif", Font.PLAIN, 28));
		g.drawString("press shift to play again!", 630, 680);	
		g.drawString("press space to see scores!", 630, 710);

	}	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		repaint();		
	}
	@Override
	public void keyPressed(KeyEvent arg0) {
		System.out.println(arg0.getKeyCode());
		// TODO Auto-generated method stub
		if(arg0.getKeyCode()==16) {
			SplashFrame gui = new SplashFrame();
			f.setVisible(false);
		}
		if(arg0.getKeyCode()==32) {
            ScoreFrame gui = new ScoreFrame();
			f.setVisible(false);      
        }
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub		
	}
}
