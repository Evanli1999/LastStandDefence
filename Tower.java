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
        
        atkseq = new Thread(new runnable()
        {
            public void run()
            {
                int atkindex = 0; 
                int minPathID; 
                while (true)
                {
                    atkindex = 0; 
                    maxPathID = 0;
                    for (int i = 0; i < LSD.wave.size(); i++)
                    {
                        if (LSD.wave.get(i).inRange(this))
                        {
                            if (LSD.wave.get(i).getPathID() > maxPathID)
                            {
                                maxPathID = LSD.wave.get(i).getPathID(); 
                                atkindex = i; 
                            }
                        }
                    }
                    LSD.wave.get(atkindex).hit(damage); 
                    Thread.sleep (period); //period is specified in milliseconds
                }
            }
        }); 
    }
    
}
