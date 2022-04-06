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
	
	Background 	bg 	= new Background(0, 0);
	Title t = new Title(120,0);
	Who w = new Who(170,30);
	Logo l = new Logo(300,440);
	hpic d = new hpic(50,450);
	Epic e = new Epic(850, 450);
	rpic r = new rpic (250,450);
	gif f = new gif(650, 450);
	
	testpic fox = new testpic(0,0);
	
	boolean gameStart = false;
	public void paint(Graphics g) {
		//background before games begins
		//ask the objects to paint themselves
		if(!gameStart) {
			super.paintComponent(g);
			bg.paint(g);
			t.paint(g);
			w.paint(g);
			//l.paint(g);
			d.paint(g);
			e.paint(g);
			r.paint(g);
			f.paint(g);
			//fox.paint(g);
			
			g.setColor(Color.black);
			g.setFont(new Font ("Serif", Font.PLAIN, 25));
			g.drawString("[**press enter**]", 420, 590);
			return;
		}
		
		if(gameStart) {
			super.paintComponent(g);
			bg.paint(g);

			
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
