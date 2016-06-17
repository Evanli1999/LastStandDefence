import java.lang.Math;
public class Tower
{
    int id; 
    int period; 
    int damage;
    int range;
    int upperiod = 0,updamage = 0,uprange = 0;
    final Position pos; 
    public Tower (int initializeid, Position p)
    {
        this.pos = p; 
        this.id = initializeid;

        //hardcode shit
        //if (id == 0)
        //{
        // damage = ...; ...    
        //}

        Thread atkseq = new Thread(new Runnable()
                {
                    public void run()
                    {
                        int atkindex = 0; 
                        int maxPathID; 
                        while (true)
                        {
                            atkindex = 0; 
                            maxPathID = 0;
                            for (int i = 0; i < LSD.wave.size(); i++)
                            {
                                if (LSD.wave.get(i).inRange(Tower.this))
                                {
                                    if (LSD.wave.get(i).getPathId() > maxPathID)
                                    {
                                        maxPathID = LSD.wave.get(i).getPathId(); 
                                        atkindex = i; 
                                    }
                                }
                            }
                            LSD.wave.get(atkindex).hit(damage); 
                            try
                            {
                                Thread.sleep (period); //period is specified in milliseconds
                            }
                            catch(Exception e)
                            {}
                        }
                    }
                }); 
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

    public int getValue()
    {
        int moneyz = 100+id*100,price = 100;

        for(int a = 0;a<5;a++)
        {
            price*=2;

            if(uprange>a)
                moneyz += price;

            if(updamage>a)
                moneyz += price;

            if(upperiod>a)
                moneyz += price;
        }

        return moneyz;
    }

    public boolean upgrade (String statToUpgrade)
    {
        if(statToUpgrade.toLowerCase().equals("period")||statToUpgrade.toLowerCase().equals("rate"))
        {
            if(LSD.money<(int)Math.pow(2,upperiod+1))
                return false;
            LSD.money-=(int)Math.pow(2,upperiod+1);
            upperiod++;
            period=(period*3)/4;
            return true;
        }
        else if (statToUpgrade.toLowerCase().equals("range"))
        {
            if(LSD.money<(int)Math.pow(2,uprange+1))
                return false;
            LSD.money-=(int)Math.pow(2,uprange+1);
            uprange++;
            range++;
            return true;
        }
        else if(statToUpgrade.toLowerCase().equals("damage"))
        {
            if(LSD.money<(int)Math.pow(2,updamage+1))
                return false;
            LSD.money-=(int)Math.pow(2,updamage+1);
            updamage++;
            damage++;
            return true;
        }
        else
        return false;
    }
}