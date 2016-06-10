/**
 * Various methods for LSD
 * Allen Mitro
 * June 09 2016
 */

class Position
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
        return Math.abs(x-checkplace.getX()+(y-checkplace.getY()));
    }

    public int distance(int nx, int ny)
    {
        return Math.abs(x-nx+(y-ny));
    }
}

class Enemy
{
    private Position place;
    private int totalhp;
    private int currenthp;

    public int getPos()
    {
        return place;
    }

    public int getTotalHp()
    {
        return totalhp;
    }

    public int getCurrentHp()
    {
        return currenthp;
    }

    /**
     * run it when an enemy is attacked
     * 
     * @param power the damage that will be done
     * @returns whether the enemy is dead or not
     */
    public boolean hit(int power)
    {
        currenthp -= power;
        if(currenthp<1)
            return true;
        return false;
    }

    public boolean inRange(Tower check)
    {
        if(place.distance(check.getPos())<=check.getRange())
            return true;
        return false;
    }
}
