
class TimerClass
{
    static Thread timerthread;
    static int thetime = 0;

    public TimerClass()
    {
        timerthread = new Thread(new Runnable()
            {
                public void run()
                {
                    //actions here when run
                    while(true) //r until the game ends and stuff
                    {
                        thetime = 1; // i'm cool with that (keep in mind all towers might fire since 0%n == 0 always)
                        while (!LSD.waveDone)
                        {
                            for(int a = 0;a<LSD.towers.size();a++)// or use the ratelist
                            {

                                if(thetime%LSD.towers.get(a).getPeriod()==0)//modded is zero
                                {
                                    LSD.towers.get(a).fire(); 
                                } 
                            }
                            if(thetime==Integer.MAX_VALUE)
                                thetime=1;

                            thetime++;
                            try   {Thread.sleep(1);}   catch(Exception e) {} //0.01 second
                        }
                        try   {Thread.sleep(10);}   catch(Exception e) {} //0.01 second
                    }
                }
            });
        timerthread.start();
    }

}