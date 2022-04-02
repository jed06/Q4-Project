
import java.awt.Point;
import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.net.URL;
import java.util.List;
import java.util.ArrayList;

	public class CardGameGUI extends JFrame implements ActionListener {

		 /** Height of the game frame. */
		 private static final int DEFAULT_HEIGHT = 700;
		 /** Width of the game frame. */
		 private static final int DEFAULT_WIDTH = 1000;
		 /** Width of a card. */
		 private static final int CARD_WIDTH = 70;
		 /** Height of a card. */
		 private static final int CARD_HEIGHT = 70;
		 /** Row (y coord) of the upper left corner of the first card. */
		 private static final int LAYOUT_TOP = 30;
		 /** Column (x coord) of the upper left corner of the first card. */
		 private static final int LAYOUT_LEFT = 30;
		 /** Distance between the upper left x coords of
		  *  two horizonally adjacent cards. */
		 private static final int LAYOUT_WIDTH_INC = 100;
		 /** Distance between the upper left y coords of
		  *  two vertically adjacent cards. */
		 private static final int LAYOUT_HEIGHT_INC = 125;
		
		 private static final int LABEL_TOP = 160;
		 private static final int LABEL_LEFT = 540;
		 private static final int LABEL_HEIGHT_INC = 35;
		 private boolean[] selections;

		 /** The board (Board subclass). */
		 private Board board;

		 /** The main panel containing the game components. */
		 private JPanel panel;
	
	
		 /** The card displays. */
		 private JLabel[] displayCards;
		 /** The win message. */
		 private JLabel winMsg;
		 /** The loss message. */
		 private JLabel lossMsg;
		 /** The coordinates of the card displays. */
		 private Point[] cardCoords;

	


		 /**
		  * Initialize the GUI.
		  * @param gameBoard is a <code>Board</code> subclass.
		  */
		 public CardGameGUI(Board gameBoard) {
		  board = gameBoard;
		 

		  // Initialize cardCoords using 5 cards per row
		  cardCoords = new Point[board.size()];
		  int x = LAYOUT_LEFT;
		  int y = LAYOUT_TOP;
		  for (int i = 0; i < cardCoords.length; i++) {
		   cardCoords[i] = new Point(x, y);
		   if (i % 5 == 4) {
		    x = LAYOUT_LEFT;
		    y += LAYOUT_HEIGHT_INC;
		   } else {
		    x += LAYOUT_WIDTH_INC;
		   }
		  }

		  initDisplay();
		  setDefaultCloseOperation(EXIT_ON_CLOSE);
		  repaint();
		 }

		 /**
		  * Run the game.
		  */
		 public void displayGame() {
		  java.awt.EventQueue.invokeLater(new Runnable() {
		   public void run() {
		    setVisible(true);
		   }
		  });
		 }

		 /**
		  * Draw the display (cards and messages).
		  */
		 public void repaint() {
		  for (int k = 0; k < board.size(); k++) {
		   String cardImageFileName =
		    imageFileName(board.cardAt(k), selections[k]);
		   URL imageURL = getClass().getResource(cardImageFileName);
		   if (imageURL != null) {
		    ImageIcon icon = new ImageIcon(imageURL);
		    displayCards[k].setIcon(icon);
		    displayCards[k].setVisible(true);
		   } else {
		    throw new RuntimeException(
		     "Card image not found: \"" + cardImageFileName + "\"");
		   }
		  }

		  pack();
		  panel.repaint();
		 }

		 /**
		  * Initialize the display.
		  */
		 private void initDisplay() {
		  panel = new JPanel() {
		   public void paintComponent(Graphics g) {
		    super.paintComponent(g);
		   }
		  };

		  // If board object's class name follows the standard format
		  // of ...Board or ...board, use the prefix for the JFrame title
		  String className = board.getClass().getSimpleName();
		  int classNameLen = className.length();
		  int boardLen = "Board".length();
		  String boardStr = className.substring(classNameLen - boardLen);
		  if (boardStr.equals("Board") || boardStr.equals("board")) {
		   int titleLength = classNameLen - boardLen;
		   setTitle(className.substring(0, titleLength));
		  }

		  // Calculate number of rows of cards (5 cards per row)
		  // and adjust JFrame height if necessary
		  int numCardRows = (board.size() + 4) / 5;
		  int height = DEFAULT_HEIGHT;
		  if (numCardRows > 2) {
		   height += (numCardRows - 2) * LAYOUT_HEIGHT_INC;
		  }

		  this.setSize(new Dimension(DEFAULT_WIDTH, height));
		  panel.setLayout(null);
		  panel.setPreferredSize(
		   new Dimension(DEFAULT_WIDTH - 20, height - 20));
		  displayCards = new JLabel[board.size()];
		  for (int k = 0; k < board.size(); k++) {
		   displayCards[k] = new JLabel();
		   panel.add(displayCards[k]);
		   displayCards[k].setBounds(cardCoords[k].x, cardCoords[k].y,
		          CARD_WIDTH, CARD_HEIGHT);
		   displayCards[k].addMouseListener(new MyMouseListener());
		   
		  }
		 
		  winMsg = new JLabel();
		  winMsg.setBounds(LABEL_LEFT, LABEL_TOP + LABEL_HEIGHT_INC, 200, 30);
		  winMsg.setFont(new Font("SansSerif", Font.BOLD, 25));
		  winMsg.setForeground(Color.GREEN);
		  winMsg.setText("You win!");
		  panel.add(winMsg);
		  winMsg.setVisible(false);

		  lossMsg = new JLabel();
		  lossMsg.setBounds(LABEL_LEFT, LABEL_TOP + LABEL_HEIGHT_INC, 200, 30);
		  lossMsg.setFont(new Font("SanSerif", Font.BOLD, 25));
		  lossMsg.setForeground(Color.RED);
		  lossMsg.setText("Sorry, you lose.");
		  panel.add(lossMsg);
		  lossMsg.setVisible(false);

		
		  pack();
		  getContentPane().add(panel);
		  panel.setVisible(true);
		 }

		 /**
		  * Deal with the user clicking on something other than a button or a card.
		  */
		 private void signalError() {
		  Toolkit t = panel.getToolkit();
		  t.beep();
		 }

		 /**
		  * Returns the image that corresponds to the input card.
		  * Image names have the format "[Rank][Suit].GIF" or "[Rank][Suit]S.GIF",
		  * for example "aceclubs.GIF" or "8heartsS.GIF". The "S" indicates that
		  * the card is selected.
		  *
		  * @param c Card to get the image for
		  * @param isSelected flag that indicates if the card is selected
		  * @return String representation of the image
		  */
		 private String imageFileName(Card c, boolean isSelected) {
		  String str = "cards/";
		  if (c == null) {
		   return "cards/back1.GIF";
		  }
		  //str += c.rank() + c.suit();
		  if (isSelected) {
		   str += "S";
		  }
		  str += ".GIF";
		  return str;
		 }

		 /**
		  * Respond to a button click 
		  * @param e the button click action event
		  */
		 public void actionPerformed(ActionEvent e) {
		
		 }

		 /**
		  * Display a win.
		  */
		 private void signalWin() {
		  winMsg.setVisible(true);
		
		 }

		 /**
		  * Display a loss.
		  */
		 private void signalLoss() {
		  lossMsg.setVisible(true);
		 }

		 /**
		  * Receives and handles mouse clicks.  Other mouse events are ignored.
		  */
		 private class MyMouseListener implements MouseListener {

		  /**
		   * Handle a mouse click on a card by toggling its "selected" property.
		   * Each card is represented as a label.
		   * @param e the mouse event.
		   */
		  public void mouseClicked(MouseEvent e) {
		  
		  }

		  /**
		   * Ignore a mouse exited event.
		   * @param e the mouse event.
		   */
		  public void mouseExited(MouseEvent e) {
		  }

		  /**
		   * Ignore a mouse released event.
		   * @param e the mouse event.
		   */
		  public void mouseReleased(MouseEvent e) {
		  }

		  /**
		   * Ignore a mouse entered event.
		   * @param e the mouse event.
		   */
		  public void mouseEntered(MouseEvent e) {
		  }

		  /**
		   * Ignore a mouse pressed event.
		   * @param e the mouse event.
		   */
		  public void mousePressed(MouseEvent e) {
		  }
		 }
		}

