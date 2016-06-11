import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class GameBoard extends JFrame
{
  
  // ArrayList<Square> squares;
  
  protected MiscImage wavesImage =           new MiscImage(40 , 160, 500, 70, "resources//backings//waves.png");
  protected MiscImage killsImage =           new MiscImage(240, 160, 500, 70, "resources//backings//kills.png");
  protected MiscImage centerImage =          new MiscImage(460, 160, 500, 70, "resources//backings//center.png");
  protected MiscImage nextWaveImage =        new MiscImage(680, 160, 500, 70, "resources//backings//nextWave.png");
  protected MiscImage pauseImage =           new MiscImage(660, 160, 500, 70, "resources//backings//pause.png");
  
  protected MiscImage backgroundImage =      new MiscImage(0 , 1080, 0 , 600, "resources//overall//background.png");
  protected MiscImage boardBackgroundImage = new MiscImage(40, 1000, 40, 440, "resources//overall//boardBackground.png");
  
  protected MiscImage baseImage =            new MiscImage(840, 160, 500, 70, "resources//entities//base.png"); // These coordinates can be changed depending on how we want to set up the map
  
  protected MiscImage currentTurretImage =   new MiscImage(); // I'll deal with this one later
  protected MiscImage buttonsImage =         new MiscImage(); // I'll deal with this one later
  
  protected ArrayList<MiscImage> path;    
  protected ArrayList<MiscImage> turrets;
  // protected ArrayList<Square> squares; Currently commented off because I don't have the squares class yet
  
  protected DrawArea main; // This is the main area where all of our components will be drawn onto.
  
  protected int squareX;
  protected int squareY;
  
  // Okay, for now, I'm defining each square to be 40px by 40px
  
  public GameBoard()
  {
    
    msListen mouse = new msListen();
    
    // squares = new ArrayList<Square>();
    
    main = new DrawArea(1080, 630);
    
    main.setLayout(null);
    main.addMouseListener(mouse);
    main.addMouseMotionListener(mouse);
    
    main.add(backgroundImage);
    
    setContentPane(main);                                // set the content pane to be whatever content pane contains all the others
    pack ();                                             // this is apparently required
    setTitle ("GUI Testing");                            // set the title of the window
    setSize (1080, 630);                                 // set the size of the window (in pixels)
    setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);     // set the close operation (just use EXIT_ON_CLOSE, we're not one of those dicks who minimizes windows when the user hits close)
    setLocationRelativeTo (null);                        // Center window.
     
  }
  
  public static void main (String [] args)
  {
    GameBoard aBoard = new GameBoard();
    aBoard.setVisible(true);
  }
  
  class msListen implements MouseListener, MouseMotionListener
  {
    
    public void mouseEntered  (MouseEvent e){}
    public void mouseExited   (MouseEvent e){}
    public void mousePressed  (MouseEvent e){}
    public void mouseReleased (MouseEvent e){}
    public void mouseDragged  (MouseEvent e){}
    
    public void mouseClicked(MouseEvent e)
    {
      if(boardBackgroundImage.checkBounds(e.getX(), e.getY()))
      {
        
        int calcX = e.getX() - 40;
        int calcY = e.getY() - 40;
        
        squareX = calcX / 40;
        squareY = calcY / 40;
        
        System.out.println("Square coordinates: (" + squareX + ", " + squareY + ")");
        
      }
      
      
      System.out.println("(" + e.getX() + ", " + e.getY() + ")");
    }
    
    public void mouseMoved(MouseEvent e)
    {
      //System.out.println("(" + e.getX() + ", " + e.getY() + ")");
    }
    
  }
  
}