import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;

public class MiscImage
{
  
  protected BufferedImage img;
  protected int x;
  protected int xSize;
  protected int y;
  protected int ySize;
  protected String imgPath; // This variable is really only used to be returned; constructor and setImg() all use the parameters passed in anyway
  
  public MiscImage()
  {
    
  }
  
  public MiscImage(int xIn, int xSizeIn, int yIn, int ySizeIn, String path)
  {
    
    try
    {
      
      img = ImageIO.read(new File(path));
      
    }
    
    catch(IOException ex)
    {
      
      //System.out.println("Image not found");
      System.out.println(path);
      //ex.printStackTrace();
      
    }
    
    x = xIn;
    xSize = xSizeIn;
    y = yIn;
    ySize = ySizeIn;
    imgPath = path;
    
  }
  
  public int getX(){ return x; }
  public int getY(){ return y; }
  
  public int getXSize(){ return xSize; }
  public int getYSize(){ return ySize; }
  
  public String getImg(){ return imgPath; }
  
  public void setX(int newX){ x = newX; }
  public void setY(int newY){ y = newY; }
  
  public void draw(Graphics g){ g.drawImage(img, x, y, null); }
  
  public boolean checkBounds(int xChk, int yChk)
  {
    boolean res = false;
    
    if(xChk <= (x + xSize) && xChk >= x && yChk <= (y + ySize) && yChk >= y)
    {
      res = true;
    }
    
    return res;
  }
  
  public void setImg(String path)
  {
    
    try
    {
      
      //System.out.println("We did it reddit");
      //System.out.println(path);
      img = ImageIO.read(new File(path));
      
      imgPath = path;
      
    }
    
    catch(IOException ex)
    {
      
      //System.out.println("Image not found");
      //System.out.println(path);
      //ex.printStackTrace();
      
    }
    
  }
  
}