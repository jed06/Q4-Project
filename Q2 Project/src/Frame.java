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
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Frame extends JPanel implements ActionListener, MouseListener, KeyListener {
	// TOKEN THING : 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
	// create the objects
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
	ArrayList <Integer> scores = new ArrayList <Integer>();
	Color scoreColors[] = {Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.BLUE, Color.MAGENTA, Color.LIGHT_GRAY, Color.PINK};
	Color scoreColor = Color.CYAN;
	
	// paint the objects
	public void paint(Graphics g) {
		super.paintComponent(g);
		bg.paint(g);
		
		g.setFont(f1);

		// if the player looses, display the message
		if(gameLost){
			
			g.setFont(new Font("Comic Sans", Font.PLAIN, 50));
			g.setColor(Color.PINK);
			g.drawString("you lost" , 100, 100);
			g.drawString("Press enter to restart" , 100, 200);
			g.drawString("Your Score: " + Score, 100, 300);
			if(scores.size() >= 1) {
				//g.drawString("Last 3 high scores: " + scores.get(scores.size()-1) +scores.get(scores.size()-2) + scores.get(scores.size()-3), 50, 400);
				Collections.sort(scores);
				g.drawString("highest score: " + scores.get(scores.size()-1), 50, 400);
			}
			
			return;
		}
		
		// if the game is not started, display the start instructions
		if(!isGameStarted){
			gameLost = false;
			// setting font type
			g.setFont(new Font("Monospaced", Font.PLAIN, 45));
			// set font color
			g.setColor(Color.MAGENTA);
			// string to display
			g.drawString("welcome to my peppa game!", 50, 100);
			
			g.setFont(new Font("Monospaced", Font.PLAIN, 37));
			
			g.drawString("Collect Star -> + 1 point" , 100, 200);
			g.drawString("Miss Star -> - 1 point" , 100, 250);
			g.drawString("Touch asteroids -> death" , 100, 300);
			
			
			g.drawString("use the arrow keys to move" , 90, 400);
			g.drawString("Press Enter to start the game" , 70, 500);
			

			
			return;
		}
		 
		// paint the objects
		pep.paint(g);
		covid1.paint(g);
		asteroid1.paint(g);
		iceasteroid.paint(g);
		star1.paint(g);
		
		
		//Collision between star and peppa
		if((star1.x >= pep.x && star1.x <= pep.x  + 110) || star1.x + star1.w >= pep.x && star1.x + star1.w <= pep.x  + 110){
			if(star1.y >= pep.y && star1.y < pep.y + 200){
				
				Score += 1;
					
				star1.y = -315;
				star1.x = rn.nextInt(700 - 10 + 1) + 10;
				scoreColor = scoreColors[rn.nextInt(scoreColors.length)];
					
			}
		}
		
		// collision between covid asteroid and peppa
		if((covid1.x + 15 >= pep.x && covid1.x - 15 <= pep.x  + 110) ){ //checking if covid x intersects with peppa x
			if(covid1.y + 15 >= pep.y && covid1.y - 15 < pep.y + 200){  //checking if covid y intersects with peppa y
				covid1.y = -100;										//reset y location if collision occurs
				covid1.x = rn.nextInt(700 - 10 + 1) + 10;				//reset x location to random
				scores.add(Score);
				gameLost = true;										//if collision occurs, the player lost game
			}
		}
		
		// collision between asteroid and peppa
		if((asteroid1.x >= pep.x && asteroid1.x <= pep.x  + 110)) { // checking if the 2 objects x locations intersect
			if(asteroid1.y >= pep.y && asteroid1.y < pep.y + 200){  // checking if the 2 objects y locations intersect
				asteroid1.y = -500;									//reset y location if collision occurs
				asteroid1.x = rn.nextInt(700 - 10 + 1) + 10;		//reset x location to random
				scores.add(Score);
				gameLost = true;									//if collision occurs, the player lost game
				
			}
		}
		
		// collision between ice asteroid and peppa
		if((iceasteroid.x >= pep.x && iceasteroid.x <= pep.x  + 110)) { // checking if the 2 objects x locations intersect
			if(iceasteroid.y >= pep.y && iceasteroid.y < pep.y + 200){  // checking if the 2 objects x locations intersect
				iceasteroid.y = -900;
				iceasteroid.x = rn.nextInt(700 - 10 + 1) + 10;			//reseting x and y
				scores.add(Score);
				gameLost = true;										// player lost game
			}
		}
		
		// subtract a point if they miss the star
		if(star1.y > 600) {
			star1.y = -900;
			Score -= 1;
			
		}
		g.setColor(scoreColor);
		g.drawString(""+ Score , 650, 100);// displaying score string
		
	}
	
	// creating a frame
	public static void main(String[] arg) {
		Frame f = new Frame();
	}
	
	JFrame f = new JFrame("Space Peppa");
	
	public Frame() {
		// consturctor for frame
		f.setSize(new Dimension(800, 600));
		f.setBackground(Color.blue);
		f.add(this);
		
		//create the objects
		int randomx = rn.nextInt(700 - 10 + 1) + 10;
		covid1 = new Obstacle1 (randomx,-100);
		
		//generate new random x locations for obstacles
		randomx = rn.nextInt(700 - 10 + 1) + 10;
		asteroid1 = new Obstacle2 (randomx,-500);
		
		randomx = rn.nextInt(700 - 10 + 1) + 10;
		iceasteroid = new Obstacle3 (randomx,-900);
		
		randomx = rn.nextInt(700 - 10 + 1) + 10;
		star1 = new Star (randomx, -1000);				
		
		//
		f.setResizable(false);
		f.setLayout(new GridLayout(1,2));
		f.addMouseListener(this);
		f.addKeyListener(this);
		Timer t = new Timer(16, this);
		t.start();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		
	}
	
	// get image to add images into game
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
			// if the person lost the game and they press enter, restart the game
			if ((gameLost == true || isGameStarted == false) && arg0.getKeyCode()==10) {
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
