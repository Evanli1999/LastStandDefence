public class Tower
{
    int id; 
    int period; 
    int damage;
    int range; 

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
}
