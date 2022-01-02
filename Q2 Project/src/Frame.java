import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
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

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Frame extends JPanel implements ActionListener, MouseListener, KeyListener {
	
	//CREATE THE OBJECT (STEP 1)
	private Image img;
	Random rn = new Random();
	Background 	bg 	= new Background(0, 0);
	Peppa pep = new Peppa(400, 390);
	Obstacle1 covid1;
	Obstacle2 asteroid1;
	Obstacle3 iceasteroid;
	Star star1;
	Font f1 = new Font(Font.SERIF, Font.PLAIN, 100);
	int Score = 0;
	boolean isGameStarted = false;
	boolean gameLost = false;
	
	
	
	public void paint(Graphics g) {
		super.paintComponent(g);
		bg.paint(g);
		
		g.setFont(f1);

		g.drawString(""+Score , 650, 100);
		
		if(gameLost)
		{
			g.setFont(new Font("Comic Sans", Font.PLAIN, 50));
			
			g.setColor(Color.PINK);
			g.drawString("you lost" , 100, 100);
			g.drawString("Press enter to restart" , 100, 200);
			g.drawString("Your Score: " + Score, 100, 300);
			return;
		}
		
		if(!isGameStarted){
			gameLost = false;
			g.setFont(new Font("Comic Sans", Font.PLAIN, 45));
			g.setColor(Color.MAGENTA);
			g.drawString("Dont touch the asteroids" , 110, 100);
			g.drawString("Collect the Stars" , 190, 200);
			g.drawString("Press Enter to start the game" , 70, 300);
			g.drawString("use the arrow keys to move" , 100, 400);
			

			
			return;
		}
		 
		
		pep.paint(g);
		covid1.paint(g);
		asteroid1.paint(g);
		iceasteroid.paint(g);
		star1.paint(g);
		
		//Collision
		//System.out.println("star1.x " + star1.x + ", star1.y " + star1.y);
		//System.out.println("pep.x " + pep.x + ", pep.y " + pep.y);
		
	
		
		if((star1.x >= pep.x && star1.x <= pep.x  + 110) || star1.x + star1.w >= pep.x && star1.x + star1.w <= pep.x  + 110){
			if(star1.y >= pep.y && star1.y < pep.y + 200){
				
				Score += 1;
					
				star1.y = -315;
				star1.x = rn.nextInt(700 - 10 + 1) + 10;
					
			}
		}
		
		if((covid1.x + 15 >= pep.x && covid1.x - 15 <= pep.x  + 110) ){//|| covid1.x + covid1.w >= pep.x && covid1.x + covid1.w <= pep.x  + 110){
			if(covid1.y + 15 >= pep.y && covid1.y - 15 < pep.y + 200){
				covid1.y = -100;
				covid1.x = rn.nextInt(700 - 10 + 1) + 10;
				
				gameLost = true;	
			}
		}
		
		if((asteroid1.x >= pep.x && asteroid1.x <= pep.x  + 110)) {// || asteroid1.x + asteroid1.w >= pep.x && asteroid1.x + asteroid1.w <= pep.x  + 110){
			if(asteroid1.y >= pep.y && asteroid1.y < pep.y + 200){
				asteroid1.y = -500;
				asteroid1.x = rn.nextInt(700 - 10 + 1) + 10;
				
				gameLost = true;
				
			}
		}
		
		if((iceasteroid.x >= pep.x && iceasteroid.x <= pep.x  + 110)) {// || iceasteroid.x + iceasteroid.w >= pep.x && covid1.x + covid1.w <= pep.x  + 110){
			if(iceasteroid.y >= pep.y && iceasteroid.y < pep.y + 200){
				iceasteroid.y = -900;
				iceasteroid.x = rn.nextInt(700 - 10 + 1) + 10;
				
				gameLost = true;	
			}
		}
		
		
		g.setColor(Color.CYAN);
		g.drawString(""+ Score , 650, 100);
		
		
	}
	
	public static void main(String[] arg) {
		Frame f = new Frame();
	}
	
	JFrame f = new JFrame("Space Peppa");
	
	public Frame() {
		
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
	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = Obstacle1.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
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
			//System.out.println(arg0.getKeyCode());
		

			if (arg0.getKeyCode()==10) {
				Score = 0;
				isGameStarted = true;
				gameLost = false;
				
			}
			
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
				//pep.moveUp();
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
