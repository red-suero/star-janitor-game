import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends GridActor
{
    private int cooldown = 0;
    private Direction d;
    private boolean interactKey = false;
    
    public void act() 
    {
        keyCommands();
    }    
    
    public void keyCommands()
    {
        cooldown++;
        if(upKey())
        {
            d = Direction.UP;
        }
        else if(downKey())
        {
            d = Direction.DOWN;
        }
        else if(leftKey())
        {
            d = Direction.LEFT;
        }
        else if(rightKey())
        {
            d = Direction.RIGHT;
        }
        
        if(upKey() && cooldown >= 20 && getGridY() > 0 && !GridManager.blocked(getGridX(), getGridY(), d))
        {
            GridManager.setGridY(this, getGridY() - 1);
            TeamManager.moveMembersUp(this);
            cooldown = 0;
        }
        else if(leftKey() && cooldown >= 20 && getGridX() > 0 && !GridManager.blocked(getGridX(), getGridY(), d))
        {
            GridManager.setGridX(this, getGridX() - 1);
            TeamManager.moveMembersLeft(this);
            cooldown = 0;
        }
        else if(downKey() && cooldown >= 20 && getGridY() < GridManager.getLowerBound(getWorld()) && !GridManager.blocked(getGridX(), getGridY(), d))
        {
            GridManager.setGridY(this, getGridY() + 1);
            TeamManager.moveMembersDown(this);
            cooldown = 0;
        }
        else if(rightKey() && cooldown >= 20 && getGridX() < GridManager.getRightBound(getWorld()) && !GridManager.blocked(getGridX(), getGridY(), d))
        {
            GridManager.setGridX(this, getGridX() + 1);
            TeamManager.moveMembersRight(this);
            cooldown = 0;
        }
        
        if(Greenfoot.isKeyDown("r") && interactKey == false)
        {
            GridActor a = (GridActor) GridManager.getInFront(getGridX(), getGridY(), d);
            if(a != null)
            {
                a.interact();
            }
            interactKey = true;
        }
        
        if(!Greenfoot.isKeyDown("r") && interactKey == true)
        {
            interactKey = false;
        }
    }
    
    public boolean upKey()
    {
        if(Greenfoot.isKeyDown("up") || Greenfoot.isKeyDown("w"))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public boolean downKey()
    {
        if(Greenfoot.isKeyDown("down") || Greenfoot.isKeyDown("s"))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public boolean leftKey()
    {
        if(Greenfoot.isKeyDown("left") || Greenfoot.isKeyDown("a"))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public boolean rightKey()
    {
        if(Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("d"))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
