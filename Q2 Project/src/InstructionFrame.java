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

public class InstructionFrame extends JPanel implements ActionListener, KeyListener{

    Picture bg     = new Picture("images.png", 0, 0, 4.5, 4.5);

    JFrame f = new JFrame("Guess Peppa");
    Picture peppa = new Picture("peppaInstruction.png", 350, 420, 0.3, 0.3, 1.05);

    JButton backHome;
    public InstructionFrame() {

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
        //f.add(backHome);
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
        peppa.paint(g);
// guess.paint(g);
// who.paint(g);
//
// george.paint(g);
// cat.paint(g);
// racoon.paint(g);
// giraffe.paint(g);

        g.setColor(Color.black);
        g.setFont(new Font ("Monospaced", Font.PLAIN, 40));
        g.drawString("WAIT....i'm here to help <3", 150, 50);    

        g.setFont(new Font ("Monospaced", Font.PLAIN, 30));

        g.drawString("press enter to play!", 620, 720);    



        g.setFont(new Font ("Monospaced", Font.PLAIN, 40));
        g.drawString("\"",2, 130);
        g.setFont(new Font ("Monospaced", Font.PLAIN, 20));

        g.drawString(" Peppa said she wanted to help, so here is some advice from her.",10, 120);
        g.drawString("The goal of the game is to guess what card the Computer asks.", 10, 150);
        g.drawString("Use the question box to eliminate characters in the deck.", 10, 180);
        g.drawString("You can only ask 4 questions so choose them wisely. ", 10, 210);
        g.drawString("Peppa will allow you to start making 'Guesses' when you've asked a few questions ", 10, 240);
        g.drawString("Be sure to know which card you think it is, before you make a guess", 10, 270);
        g.drawString("A Wrong Guess is an automatic win for the computer  ", 10, 300);
        g.drawString("May the Peppa Force be with you!", 10, 330);

        g.setFont(new Font ("Monospaced", Font.PLAIN, 40));
        g.drawString("\"",390, 340);






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
            GuessWhoFrame gui = new GuessWhoFrame();

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