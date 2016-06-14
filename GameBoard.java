import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class GameBoard extends JFrame
{
  
  protected MiscImage wavesImage =           new MiscImage(40 , 160, 500, 70, "resources/backings/waves.png");
  protected MiscImage killsImage =           new MiscImage(240, 160, 500, 70, "resources/backings/kills.png");
  protected MiscImage nextWaveImage =        new MiscImage(680, 160, 500, 70, "resources/backings/nextWave.png");
  protected MiscImage pauseImage =           new MiscImage(880, 160, 500, 70, "resources/backings/pause.png");
  protected MiscImage backgroundImage =      new MiscImage(0 , 1080, 0 , 600, "resources/overall/background.png");
  protected MiscImage boardBackgroundImage = new MiscImage(40, 1000, 40, 440, "resources/overall/boardBackground.png"); // This is actually not useless, it's used for a bit of checking, will clean up soon(tm)
  
  protected MiscImage baseImage =            new MiscImage(840, 160, 265, 70, "resources/entities/base.png"); // These coordinates can be changed depending on how we want to set up the map
  
  protected MiscImage currentTurretImage =   new MiscImage(524, 40, 518, 40, "resources/turrets/blue.png"); // I'll deal with this one later
  protected MiscImage buttonsImage =         new MiscImage(478, 125, 520, 30, "resources/controls/arrows.png"); // I'll deal with this one later
  
  // protected MiscImage path =                 new MiscImage(40, 880, 80, 360, "resources/entities/path.png"); Time to remove this and legitimatelly generate a path
  
  protected ArrayList<MiscImage> path = new ArrayList<MiscImage>(); // Path will be an arrayList of position objects, I'd presume..?
  protected ArrayList<MiscImage> turrets = new ArrayList<MiscImage>();
  
  protected DrawArea main; // This is the main area where all of our components will be drawn onto.
  
  protected Position select = new Position (0,0); //if you want to access this in a static method, use Gameboard.aboard.select
  
  // Okay, for now, I'm defining each square to be 40px by 40px
  
  public GameBoard(ArrayList<Position> aPath)
  {
    
    msListen mouse = new msListen();
    
    main = new DrawArea(1080, 630);
    
    main.setLayout(null);
    main.addMouseListener(mouse);
    main.addMouseMotionListener(mouse);
    
    for(int i = 0; i < aPath.size(); i++)
    {
      int squareX = (aPath.get(i).getX() * 40) + 40;
      int squareY = (aPath.get(i).getY() * 40) + 40;
      path.add(new MiscImage(squareX, 40, squareY, 40, "resources\\entities\\path.png"));
    }
    
    main.add(backgroundImage);
    main.add(wavesImage);
    main.add(killsImage);
    main.add(nextWaveImage);
    main.add(pauseImage);
    main.add(baseImage);
    main.add(buttonsImage);
    main.add(currentTurretImage);
    
    main.add(turrets);
    main.add(path);
    
    setContentPane(main);                                // set the content pane to be whatever content pane contains all the others
    pack ();                                             // this is apparently required
    setTitle ("GUI Testing");                            // set the title of the window
    setSize (1080, 630);                                 // set the size of the window (in pixels)
    setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);     // set the close operation (just use EXIT_ON_CLOSE, we're not one of those dicks who minimizes windows when the user hits close)
    setLocationRelativeTo (null);                        // Center window.
    
  }
  
  public void revert()
  {
    main.revert();
    
    main.add(backgroundImage);
    main.add(wavesImage);
    main.add(killsImage);
    main.add(nextWaveImage);
    main.add(pauseImage);
    main.add(baseImage);
    main.add(buttonsImage);
    main.add(currentTurretImage);
    
    main.add(turrets);
    main.add(path);
    
  }
  
  public void addTower(Tower toAdd)
  {
    int towerX = toAdd.getPos().getX();
    int towerY = toAdd.getPos().getY();
    System.out.println("Tower is located at: (" + towerX + ", " + towerY + ")");
    
    int towerDrawX = (towerX * 40) + 40;
    int towerDrawY = (towerY * 40) + 40;
    
    turrets.add(new MiscImage(towerDrawX, 40, towerDrawY, 40, "resources\\turrets\\blue.png"));
    
    revert();
    main.add(turrets);
    repaint();
    
  }
  
  public void removeTower(Tower toRemove)
  {
    int towerX = toRemove.getPos().getX();
    int towerY = toRemove.getPos().getY();
    System.out.println("Removing tower at: (" + towerX + ", " + towerY + ")");
    int towerDrawX = (towerX * 40) + 40;
    int towerDrawY = (towerY * 40) + 40;
    
    for(int i = 0; i < turrets.size(); i++)
    {
      if(turrets.get(i).getX() == towerDrawX && turrets.get(i).getY() == towerDrawY)
      {
        turrets.remove(i);
      }
    }
   
    revert();
    repaint();
    
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
        
        select.setX(calcX / 40);
        select.setY(calcY / 40);
        System.out.println("Selected coordinates: "+select);
        
      }
      
      System.out.println("(MouseClick at" + e.getX() + ", " + e.getY() + ")");
    }
    
    public void mouseMoved(MouseEvent e)
    {
    }
    
  }
  
}
