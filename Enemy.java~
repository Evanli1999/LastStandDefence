/**
 * A class for enemy spawns.
 */
public class Enemy
{
    private Position place;
    private int totalHp;
    private int currentHp;
    private int pathId;
    private int type; //not used yet?

    public Enemy (int hp)
    {
        totalHp = hp;
        currentHp = hp;
        pathId = 0;
        place = LSD.path.get(0);
    }

    public Position getPos()
    {
        return place;
    }

    public int getPathId()
    {
        return pathId;
    }

    public int getTotalHp()
    {
        return totalHp;
    }

    public int getCurrentHp()
    {
        return currentHp;
    }

    /**
     * run it when an enemy is attacked
     * also adds moniez here for simplicity's sake
     * @param power the damage that will be done
     * @returns whether the enemy is dead or not
     */
    public boolean hit(int power)
    {
        currentHp -= power;
        
        if(currentHp<1)
        {
            LSD.money += totalHp/2;
            return true;
        }

        return false;
    }

    public boolean inRange(Tower check)
    {
        if(place.distance(check.getPos())<=check.getRange())
            return true;

        return false;
    }
}
