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


public class SplashFrame extends JPanel implements ActionListener, KeyListener{
	
	
	Music song = new Music("PeppaSound.wav", true);
	Picture bg 	= new Picture("images.png", 0, 0, 4.5, 4.5);
	
	Picture guess = new Picture("GameTitle.png",120, 0, 1.0, 1.0);
	Picture who = new Picture("who.png", 170, 30, 0.3, 0.3);
	Picture logo = new Picture("logo.png", 300, 440, 0.3, 0.3);
	Picture george = new Picture("pwdino.png", 50, 420, 0.3, 0.3, 1.05);
	Picture cat = new Picture("c.png", 850, 450, 0.3, 0.3, 1.2);
	Picture racoon = new Picture ("r.png", 250, 430, 0.07, 0.07, 1);
	Picture giraffe = new Picture("gir.png", 650, 440, 0.3, 0.3, 1.03);
	JFrame f = new JFrame("Guess Peppa");
	
	public SplashFrame() {
		
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
	
	
	public void paint(Graphics g) {
		//background before games begins
		//ask the objects to paint themselves
		
		super.paintComponent(g);
		bg.paint(g);
		guess.paint(g);
		who.paint(g);
		
		george.paint(g);
		cat.paint(g);
		racoon.paint(g);
		giraffe.paint(g);
		
		g.setColor(Color.black);
		g.setFont(new Font ("Serif", Font.PLAIN, 25));
		g.drawString("[**press enter**]", 420, 590);			
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
		if(arg0.getKeyCode()==10) {
			f.setVisible(false);
						
			InstructionFrame gui = new InstructionFrame();		
			song.play();
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
