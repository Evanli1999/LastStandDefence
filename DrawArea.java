import java.util.*;
import java.awt.*;
import javax.swing.*;

public class DrawArea extends JPanel
{
  
  protected ArrayList<MiscImage> images = new ArrayList<MiscImage>();
  
  public DrawArea(int width, int height)
  { 
    this.setPreferredSize(new Dimension(width, height)); 
  }
  
  public void add(MiscImage img)
  { 
    images.add(img); 
  }
  
  public void add(ArrayList<MiscImage> imgList)
  {
    
    for(int i = 0; i < imgList.size(); i++) 
    {
      images.add(imgList.get(i)); 
    } 
    
  }
  
  public void paintComponent(Graphics g)
  {
    
    for(int i = 0; i < images.size(); i++)
    { 
      images.get(i).draw(g);
    } 
    
  }
  
  public void revert()
  { 
    images = new ArrayList<MiscImage>();
  }
  
}