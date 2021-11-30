import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Frame extends JPanel implements ActionListener, MouseListener, KeyListener {
	
	//CREATE THE OBJECT (STEP 1)
	Random rn = new Random();
	Background 	bg 	= new Background(0, 0);
	Peppa pep = new Peppa(400,600);
	Obstacle1 covid1;
	Obstacle2 asteroid1;
	Obstacle3 iceasteroid;
	Star star1;
	public void paint(Graphics g) {
		super.paintComponent(g);
		bg.paint(g);
		pep.paint(g);
		covid1.paint(g);
		asteroid1.paint(g);
		iceasteroid.paint(g);
		star1.paint(g);
		
	}
	
	public static void main(String[] arg) {
		Frame f = new Frame();
	}
	
	public Frame() {
		JFrame f = new JFrame("Space Peppa");
		f.setSize(new Dimension(800, 600));
		f.setBackground(Color.blue);
		f.add(this);
		
		//create the objects
		int randomx = rn.nextInt(700 - 10 + 1) + 10;
		covid1 = new Obstacle1 (randomx,-100);
		
		//generate new random x
		randomx = rn.nextInt(700 - 10 + 1) + 10;
		asteroid1 = new Obstacle2 (randomx,-500);
		
		randomx = rn.nextInt(700 - 10 + 1) + 10;
		iceasteroid = new Obstacle3 (randomx,-900);
		
		randomx = rn.nextInt(700 - 10 + 1) + 10;
		star1 = new Star (randomx, -1000);
		
		
		
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
			System.out.println(arg0.getKeyCode());
			if (arg0.getKeyCode()==32) {
				pep.flap();
			}
			
			if (arg0.getKeyCode()==39) {
				pep.moveRight();
			}
			
			if (arg0.getKeyCode()==37) {
				pep.moveLeft();
			}
			if (arg0.getKeyCode()==38) {
				pep.moveUp();
			}
			
			if (arg0.getKeyCode()==40) {
				pep.moveDown();
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
