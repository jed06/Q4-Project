import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Frame extends JPanel implements ActionListener, MouseListener, KeyListener {
	
	Picture bg 	= new Picture("images.png", 0, 0, 4.5, 4.5);
	
	Picture guess = new Picture("GameTitle.png",120, 0, 1.0, 1.0);
	Picture who = new Picture("who.png", 170, 30, 0.3, 0.3);
	Picture logo = new Picture("logo.png", 300, 440, 0.3, 0.3);
	Picture george = new Picture("pwdino.png", 50, 420, 0.3, 0.3, 1.05);
	Picture cat = new Picture("c.png", 850, 450, 0.3, 0.3, 1.2);
	Picture racoon = new Picture ("r.png", 250, 430, 0.07, 0.07, 1);
	Picture giraffe = new Picture("gir.png", 650, 440, 0.3, 0.3, 1.03);
	
	String [] pictures = 
		{"/imgs/Suzie Sheep.png","/imgs/Candy Cat.png","/imgs/Zoe Zebra.png","/imgs/Rebecca Rabbit.png", 
				"/imgs/Emily Elephant.png", "/imgs/George Pig.png", "/imgs/Danny Dog.png", "/imgs/Molly Mole.png", 
				"/imgs/Freddy Fox.png", "/imgs/Mandy Mouse.png", "/imgs/Gerald Giraffe.png", "/imgs/Pedro Pony.png"};
	
	
	
	boolean gameStart = false;
	public void paint(Graphics g) {
		//background before games begins
		//ask the objects to paint themselves
		if(!gameStart) {
			super.paintComponent(g);
			bg.paint(g);
			guess.paint(g);
			who.paint(g);
			//logo.paint(g);
			george.paint(g);
			cat.paint(g);
			racoon.paint(g);
			giraffe.paint(g);
			
			g.setColor(Color.black);
			g.setFont(new Font ("Serif", Font.PLAIN, 25));
			g.drawString("[**press enter**]", 420, 590);
			return;
		}
		
		if(gameStart) {
			super.paintComponent(g);
			bg.paint(g);
			Deck deck = new Deck ();
			deck.paint(g);
		}		
	}

	
	public static void main(String[] arg) {
		Frame f = new Frame();
		
	}
	
	JButton button;
	
	public Frame() {		
		
		JFrame f = new JFrame("Guess Peppa");
		f.setSize(new Dimension(1000, 700));
		f.setBackground(Color.blue);
		f.add(this);
		f.setResizable(false);
		f.setLayout(new GridLayout(1,2));
		f.addMouseListener(this);
		f.addKeyListener(this);
		Timer t = new Timer(16, this);
		t.start();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);		
		
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		 
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
	
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		repaint();
		
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getKeyCode()==10) {
			gameStart=true;
		}
			
			
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		 
		 
		 
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
