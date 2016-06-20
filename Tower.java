import java.lang.Math;
import java.util.Random; 
public class Tower
{
    int id; 
    int period; 
    int damage;
    int range;
    int upPeriod = 0,upDamage = 0,upRange = 0;

    int killcount = 0; //used for laser special ability
    boolean overheat = false; //taser special ability
    boolean gameover = false; //quick fix
    
    double rotation;
    final Position pos; 

    static int atkindex = 0;

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
            period = 1250;
            damage = 15;
            range = 5;
        }

        else if(id == 2) // The laser; this piece of shit doesn't really have any redeeming qualities
        {
            period = 900;
            damage = 7;
            range = 7;
        }

        else if(id == 3) // The rocket; this thing is OP as fuck because of its long range
        {
            period = 1750;
            damage = 25;
            range = 10;
        }

        else if(id == 4) // The taser; basically just RoF
        {
            period = 250;
            damage = 2;
            range = 1;
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

    public Double getRotation()
    {
        return rotation;
    }

    public void setRotation(Double radians)
    {
        rotation = radians;
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
            if (id != 4)
            {
            period=(period*3)/4;
        }
        if (id == 4)
        {
            period = (period*5)/6; 
        }
            
            if (id == 4 && upDamage == 8 && upPeriod == 8 && upRange == 8) //taser special ability
            {
                overheat = true; 
                damage*= 3; 
                range += 5;  
            }
            return true;
        }
        else if (statToUpgrade.toLowerCase().equals("range"))
        {

            System.out.println("Upgrading Range");
            if(LSD.money<(int)Math.pow(2,upRange+1))
                return false;
            LSD.money-=(int)Math.pow(2,upRange+1);
            upRange++;
            if (id != 4&&(upRange/2)*2 == upRange)
            {
                System.out.println ("Upgraded Range"); 
                range = range++;
            }
            
            if (id == 4 && upDamage == 8 && upPeriod == 8 && upRange == 8) //taser special ability
            {
                overheat = true; 
                damage*= 3; 
                range += 5;  
            }
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

            if (id == 4 && upDamage == 8 && upPeriod == 8 && upRange == 8) //taser special ability
            {
                overheat = true; 
                damage*= 3; 
                range += 5;  
            }
            return true;
        }
        else
        {
            return false;
        }
    }

    protected void fire()
    {
        atkindex = -1; 
        System.out.println("atkindex: " + atkindex);
        int maxPathID = -1;

        for (int i = 0; i < LSD.wave.size(); i++)
        {
            if (LSD.wave.get(i).inRange(Tower.this))
            {
                if (LSD.wave.get(i).getPathId() > maxPathID)
                {
                    maxPathID = LSD.wave.get(i).getPathId(); 
                    atkindex = i; 
                    //System.out.println ("Checking"); 
                }
            }
        }

        if(atkindex!=-1)
        {
            //System.out.println ("Attacking"); 
            if (id == 3 && upDamage == 8 && upPeriod == 8 && upRange == 8) //taser special ability
            {
                overheat = true; 
                LSD.money += 5;   
            }
            try
            {
                if(LSD.wave.get(atkindex).inRange(Tower.this)&&LSD.wave.get(atkindex).hit(damage))
                {
                    if (overheat)
                    {
                        LSD.money-=100; 
                        if (LSD.money < 0)
                        { 
                            LSD.lives = 0; 
                            if (!gameover)
                            {
                                LSD.gg(); 
                                gameover = true; 
                            }
                        }
                    }
                    killcount++; 
                    if (id == 2 && upDamage == 8 && upPeriod == 8 && upRange == 8) //laser special ability
                    {
                        if(killcount >= 75)
                        {
                            killcount = 0; 
                            if (LSD.lives < 10)
                            {
                                LSD.lives++;
                            }
                        }
                    }
                    if (id == 3 && upDamage == 8 && upPeriod == 8 && upRange == 8) //rocket special ability
                    {
                        LSD.money+= LSD.waves; 
                    }

                    //System.out.println("Removed: " + atkindex);
                    LSD.wave.remove(atkindex); 
                    LSD.kills++; 
                    if(LSD.wave.size()==0)
                        LSD.waveDone = true;

                }
                else
                {
                    if (id == 2 && upDamage == 8 && upPeriod == 8 && upRange == 8) //cannon special ability
                    {
                        Random ran = new Random(); 
                        int i = ran.nextInt(5); 
                        if (i == 3)
                        {
                            LSD.wave.get(atkindex).hit(999999999); 
                        }
                    }
                }
            }
            catch(Exception e) 
            {}
        }       
    }
    


}