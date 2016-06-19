/**
 * Various methods for LSD
 * Allen Mitro
 * June 09 2016
 */

public class Position
{
    private int x;
    private int y;

    public Position()
    {
        x = 0;
        y = 0;
    }

    public Position(int nx,int ny)
    {
        x = nx;
        y = ny;
    }

    public Position (Position npos)
    {
        x = npos.getX();
        y = npos.getY();
    }

    public Position (String npos)//string in form (x,y)
    {
        x = 0;
        y = 0;

        for(int a = 0;a<npos.length();a++)
        {
            if(npos.charAt(a)==',')
            {
                try
                {x = Integer.parseInt(npos.substring(0,a));}
                catch(Exception e)
                {System.out.println("Could not parse "+npos.substring(0,a));}

                try 
                {y = Integer.parseInt(npos.substring(a+1));}
                catch(Exception e)
                {System.out.println("Could not parse "+npos.substring(a+1));}
            }
        }
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public void setX(int nx)
    {
        x = nx;
    }

    public void setY(int ny)
    {
        y = ny;
    }

    public int distance(Position checkplace)
    {
        return Math.abs(x-checkplace.getX())+Math.abs(y-checkplace.getY());
    }

    public int distance(int nx, int ny)
    {
        return Math.abs(x-nx)+Math.abs(y-ny);
    }

    public String toString()
    {
        return "("+x+","+y+")";
    }
}
