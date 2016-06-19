import java.lang.Math;
public class Tower
{
  int id; 
  int period; 
  int damage;
  int range;
  int upPeriod = 0,upDamage = 0,upRange = 0;
  final Position pos; 
  
  int atkindex = 0;
  
  public Tower (int initializeid, Position p)
  {
    this.pos = p; 
    this.id = initializeid;
    
    System.out.println("This tower has ID: " + id);
    
    //hardcode shit
    //if (id == 0)
    //{
    // damage = ...; ...    
    //}
    
    if(id == 1) // The cannon; slow-firing with low range, but relatively nice damage
    {
      period = 1000;
      damage = 20;
      range = 5;
    }
    
    else if(id == 2) // The laser; this piece of shit doesn't really have any redeeming qualities
    {
      period = 750;
      damage = 10;
      range = 7;
    }
    
    else if(id == 3) // The rocket; this thing is OP as fuck because of its long range
    {
      period = 1000;
      damage = 15;
      range = 15;
    }
    
    else if(id == 4) // The taser; basically just RoF
    {
      period = 200;
      damage = 10;
      range = 3;
    }
  }
  
  public Position getPos()
  {
    return pos;
  }
  
  public int getRange()
  {
    return range;
  }
  
  public int getPower()
  {
    return damage;
  }
  
  public int getPeriod()
  {
    return period;
  }
  
  public int getType()
  {
    return id;
  }
  
  public int getUpPeriod()
  {
    return upPeriod;
  }
  
  public int getUpDamage()
  {
    return upDamage;
  }
  
  public int getUpRange()
  {
    return upRange;
  }
  
  public int getValue()
  {
    int moneyz = 100+id*100,price = 100;
    
    for(int a = 0;a<5;a++)
    {
      price*=2;
      
      if(upRange>a)
        moneyz += price;
      
      if(upDamage>a)
        moneyz += price;
      
      if(upPeriod>a)
        moneyz += price;
    }
    
    return moneyz;
  }
  
  public boolean upgrade (String statToUpgrade)
  {
    if(statToUpgrade.toLowerCase().equals("period")||statToUpgrade.toLowerCase().equals("rate"))
    {
      System.out.println("Upgrading rate");
      if(LSD.money<(int)Math.pow(2,upPeriod+1))
        return false;
      LSD.money-=(int)Math.pow(2,upPeriod+1);
      upPeriod++;
      period=(period*3)/4;
      return true;
    }
    else if (statToUpgrade.toLowerCase().equals("range"))
    {
      System.out.println("Upgrading Range");
      if(LSD.money<(int)Math.pow(2,upRange+1))
        return false;
      LSD.money-=(int)Math.pow(2,upRange+1);
      upRange++;
      range++;
      return true;
    }
    else if(statToUpgrade.toLowerCase().equals("damage"))
    {
      System.out.println("Upgrading Damage");
      if(LSD.money<(int)Math.pow(2,upDamage+1))
        System.out.println("NO MONEY");
      LSD.money-=(int)Math.pow(2,upDamage+1);
      upDamage++;
      System.out.println("upDamage: " + upDamage);
      damage++;
      return true;
    }
    else
      return false;
  }
  
  protected void fire()
  {
    atkindex = -1; 
    int maxPathID = -1;
    
    for (int i = 0; i < LSD.wave.size(); i++)
    {
      if (LSD.wave.get(i).inRange(Tower.this))
      {
        if (LSD.wave.get(i).getPathId() > maxPathID)
        {
          maxPathID = LSD.wave.get(i).getPathId(); 
          atkindex = i; 
          System.out.println ("Checking"); 
        }
      }
    }
    
    if(atkindex!=-1)
    {
      System.out.println ("Attacking"); 
      try
      {
        if(LSD.wave.get(atkindex).inRange(Tower.this)&&LSD.wave.get(atkindex).hit(damage))
        {
          System.out.println("Removed: " + atkindex);
          LSD.wave.remove(atkindex); 
          LSD.kills++; 
          if(LSD.wave.size()==0)
            LSD.waveDone = true;
          
        }
      }
      catch(Exception hotfix) // lmao this is the laziest piece of code I have ever seen
      {}
    }       
  }
  
  protected Double getRotation()
  {
    
    if(atkindex != -1)
    {
      
      System.out.println(atkindex);
      
      int turretX = 40 + pos.getX() * 40;
      int turretY = 40 + pos.getY() * 40;
      
      int enemX = 40 + LSD.wave.get(atkindex).getPos().getX() * 40;
      int enemY = 40 + LSD.wave.get(atkindex).getPos().getY() * 40;
      
      int deltaX = Math.abs(turretX - enemX);
      int deltaY = Math.abs(turretY - enemY);
      
      Double ratio = (double)deltaY / (double)deltaX;
      
      Double radians = Math.atan(ratio);
      
      return radians;
      
    }
    
    else
    {
      
      return 0.0;
      
    }
    
  }
  
}