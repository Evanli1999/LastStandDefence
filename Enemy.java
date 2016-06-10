
public class Enemy
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
