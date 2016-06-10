import java.util.ArrayList;

public class LSD
{
  protected int money = 2000;
  protected int score = 0;
  ArrayList<Tower> towers = new ArrayList(0);
  ArrayList<Position> path = new ArrayList(0);
  protected static ArrayList<Enemy> wave = new ArrayList(0);
  
  public static void main(String args[])
  {
  
  }
  
  public static boolean canBuild(Position place)
  {
    for(int a = 0;a<path.size();a++)
    {
      if(path.get(0).distance(place)==0)//if place is on the path
      {
        return false; //no building allowed
      }
    }
    
    for(int a = 0;a<towers.size();a++)
    {
      if(towers.get(a).getPos().distance(place)==0)//tower is at that position
      {
        return false; //no building allowed
      }
    }
    
    return true;
  }
  
  public static void addTower(Position place)//a flimsy addTower class, makes a default Tower()
  {
    if(canBuild(place))
    {
      if(money>200)//change this to a proper requirement
      {
        towers.add(new Tower());
        //then update graphics as necessary
      }
    }
  }
  
  public static void removeTower(Position place)
  {
    for(int a = 0;a<towers.size();a++)
    {
      if(towers.get(a).getPos().distance(place)==0)
      {
        towers.remove(a);
        //then update graphics as necessary
      }
    }
  }
}
