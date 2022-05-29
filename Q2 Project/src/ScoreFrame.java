import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.*;   
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
import java.util.ArrayList; // import the ArrayList class
import java.util.Collections;
public class ScoreFrame extends JPanel implements ActionListener, KeyListener{
    Picture bg = new Picture("images.png", 0, 0, 4.5, 4.5);
    JFrame f = new JFrame("Guess Peppa");  
    public ScoreFrame() {
        f.setSize(new Dimension(1000, 760));
        f.setBackground(Color.blue);
        f.add(this);
        f.setResizable(false);
        f.setLayout(new GridLayout(1,2));
        f.addKeyListener(this);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);     
    }
    public void paint(Graphics g) {
        super.paintComponent(g);
        bg.paint(g);
        g.setColor(Color.black);
        g.setFont(new Font ("Monospaced", Font.PLAIN, 40));
        g.drawString("Fastest times: ", 50, 50);
        int x = 50, y = 100, count = 0;
        ArrayList<Integer> b = ScoresIO.readScores();
        Collections.sort(b);
        for(double marks: b)  
        {  
        System.out.println("Time: " + marks + " seconds"); 
        g.drawString("Time: " + marks + " seconds", x, y);
        y+=60;
        count++;
        if (count >= 6) {
        	break;
        }
        }    
        g.drawString("Press Shift to play again!", 300, 600);
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
        if(arg0.getKeyCode()==32) {
            f.setVisible(true);              
        }
        if(arg0.getKeyCode()==16) {
			SplashFrame gui = new SplashFrame();
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