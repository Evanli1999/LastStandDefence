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

    public void setPos(Position pos)
    {
        place = pos;
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

    public void advance()
    {

        //System.out.println("Advance invoked");

        int posIndex = 0;

        for(int i = 0; i < LSD.path.size(); i++)
        {
            if(LSD.path.get(i).equals(place))
            {
                //System.out.println("Enemy is located at: " + LSD.path.get(i));
                //System.out.println("Moving enemy to: " + LSD.path.get(i+1));
                place = new Position(LSD.path.get(i + 1));
                break;
            }
        }

    }

    /**
     * run it when an enemy is attacked
     * also adds moniez here for simplicity's sake
     * @param power the damage that will be done
     * @returns whether the enemy is dead or not
     */
    public boolean hit(int power)
    {
        //     System.out.println("Ouch.");
        //     System.out.println("My current HP is: " + currentHp);
        //     currentHp -= power;
        //     System.out.println("My HP Went down to: " +  currentHp);

        currentHp -= power; 
        //System.out.println ("Damaged for: " + power); 
        //LSD.aBoard.drawHp();

        if(currentHp<1)
        {
            //System.out.println ("Am dead"); 
            if (totalHp < 60)
            {
                LSD.money += (totalHp);
            }
            else
            if (totalHp < 250)
            {
                LSD.money += (30+totalHp/4); 
            }
            else
            if (totalHp < 500)
            {
                LSD.money += (100+totalHp/8); 
            }
            else
            {
                LSD.money += (100+LSD.waves/2); 
            }
            return true;
        }

        return false;
    }

    public boolean inRange(Tower check)
    {

        if(place.distance(check.getPos())<=check.getRange())
        {
            //System.out.println("OH SHIT I'M IN RANGE");
            return true;
        }

        //System.out.println("HAHA FUCKERS I'M NOT IN RANGE");
        return false;
    }
}
