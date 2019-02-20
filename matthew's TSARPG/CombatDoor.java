import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class Door here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CombatDoor extends GridActor
{
    private Type type;
    private Side side;
    private Side invSide;
    
    public CombatDoor(Type type, Side side)
    {
        this.type = type;
        this.side = side;
        setInvSide();
    }
    
    public void setInvSide()
    {
        if(side == Side.UP)
        {
            invSide = Side.DOWN;
        }
        else if(side == Side.DOWN)
        {
            invSide = Side.UP;
        }
        else if(side == Side.LEFT)
        {
            invSide = Side.RIGHT;
        }
        else if(side == Side.RIGHT)
        {
            invSide = Side.LEFT;
        }
    }
    
    public int exitGridX()
    {
        if(side == Side.LEFT)
        {
            return GridManager.getLeftBound(getWorld()) - 2;
        }
        else if(side == Side.RIGHT)
        {
            return 2;
        }
        else
        {
            return getGridX();
        }
    }
    
    public int exitGridY()
    {
        if(side == Side.UP)
        {
            return GridManager.getLowerBound(getWorld()) - 2;
        }
        else if(side == Side.DOWN)
        {
            return 2;
        }
        else
        {
            return getGridY();
        }
    }
    
    public void interact()
    {
        if(type == Type.NEXT)
        {
            Room r = (Room) getWorld();
            Greenfoot.setWorld(r.entrance(exitGridX(), exitGridY()));
        }
        else if(type == Type.PREV)
        {
            CombatRoom c = (CombatRoom) getWorld();
            Greenfoot.setWorld(c.prevRoom(exitGridX(), exitGridY(), invSide));
        }
    }
    
    public Player getPlayer()
    {
        List<Player> players = (List<Player>) getWorld().getObjects(Player.class);
        return players.get(0);
    }
}
