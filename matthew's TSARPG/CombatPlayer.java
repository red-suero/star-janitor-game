
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Write a description of class CombatPlayer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class CombatPlayer extends GridActor
{
    protected int hp;
    protected int lDamage;
    protected int hDamage;
    protected int sDamage;
    protected int uDamage;
    protected int mCooldown = 0;
    protected int lCooldown = 0;
    protected int hCooldown = 0;
    protected int sCooldown = 0;
    protected int uCooldown = 0;
    protected Direction d;
    protected boolean interactKey = false;
    
    public void act()
    {
        keyCommands();
        attackKeys();
    }
    
    public void keyCommands()
    {
        mCooldown++;
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
        
        if(upKey() && mCooldown >= 20 && getGridY() > 0 && !GridManager.blocked(getGridX(), getGridY(), d))
        {
            GridManager.setGridY(this, getGridY() - 1);
            mCooldown = 0;
        }
        else if(leftKey() && mCooldown >= 20 && getGridX() > 0 && !GridManager.blocked(getGridX(), getGridY(), d))
        {
            GridManager.setGridX(this, getGridX() - 1);
            mCooldown = 0;
        }
        else if(downKey() && mCooldown >= 20 && getGridY() < GridManager.getLowerBound(getWorld()) && !GridManager.blocked(getGridX(), getGridY(), d))
        {
            GridManager.setGridY(this, getGridY() + 1);
            mCooldown = 0;
        }
        else if(rightKey() && mCooldown >= 20 && getGridX() < GridManager.getRightBound(getWorld()) && !GridManager.blocked(getGridX(), getGridY(), d))
        {
            GridManager.setGridX(this, getGridX() + 1);
            mCooldown = 0;
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
    
    public void attackKeys()
    {
        lCooldown++;
        hCooldown++;
        sCooldown++;
        uCooldown++;
        if(Greenfoot.isKeyDown("j") && lCooldown >= 10)
        {
            lightAttack();
            lCooldown = 0;
        }
        else if(Greenfoot.isKeyDown("k") && hCooldown >= 20)
        {
            heavyAttack();
            hCooldown = 0;
        }
        else if(Greenfoot.isKeyDown("u") && sCooldown >= 50)
        {
            superAttack();
            sCooldown = 0;
        }
        else if(Greenfoot.isKeyDown("i") && uCooldown >= 100)
        {
            ultimateAttack();
            uCooldown = 0;
        }
    }
    
    public void fullRow()
    {
        if(d == Direction.UP)
        {
            for(int i = 0; i <= getGridY() - GridManager.getUpperBound(getWorld()); i++)
            {
                GridActor a = (GridActor) GridManager.getInFront(getGridX(), getGridY() - i, d);
                if(a != null)
                {
                    a.damage(1);
                    break;
                }
            }
        }
        else if(d == Direction.DOWN)
        {
                for(int i = 0; i <= GridManager.getLowerBound(getWorld()) - getGridY(); i++)
            {
                GridActor a = (GridActor) GridManager.getInFront(getGridX(), getGridY() + i, d);
                if(a != null)
                {
                    a.damage(1);
                    break;
                }
            }
        }
        else if(d == Direction.LEFT)
        {
            for(int i = 0; i <= getGridX() - GridManager.getLeftBound(getWorld()); i++)
            {
                GridActor a = (GridActor) GridManager.getInFront(getGridX() - i, getGridY(), d);
                if(a != null)
                {
                    a.damage(1);
                    break;
                }
            }
        }
        else if(d == Direction.RIGHT)
        {
            for(int i = 0; i <= GridManager.getRightBound(getWorld()) - getGridX(); i++)
            {
                GridActor a = (GridActor) GridManager.getInFront(getGridX() + i, getGridY(), d);
                if(a != null)
                {
                    a.damage(1);
                    break;
                }
            }
        }
    }
    
    public void fullCircle()
    {
        ArrayList<GridActor> a = (ArrayList<GridActor>) new ArrayList<GridActor>();
        GridActor a1 = (GridActor) GridManager.getGridActor(getGridX(), getGridY() - 1);
        GridActor a2 = (GridActor) GridManager.getGridActor(getGridX() + 1, getGridY() - 1);
        GridActor a3 = (GridActor) GridManager.getGridActor(getGridX() + 1, getGridY());
        GridActor a4 = (GridActor) GridManager.getGridActor(getGridX()+ 1, getGridY() + 1);
        GridActor a5 = (GridActor) GridManager.getGridActor(getGridX(), getGridY() + 1);
        GridActor a6 = (GridActor) GridManager.getGridActor(getGridX() - 1, getGridY() - 1);
        GridActor a7 = (GridActor) GridManager.getGridActor(getGridX() - 1, getGridY());
        GridActor a8 = (GridActor) GridManager.getGridActor(getGridX() - 1, getGridY() + 1);
        a.add(a1);
        a.add(a2);
        a.add(a3);
        a.add(a4);
        a.add(a5);
        a.add(a6);
        a.add(a7);
        a.add(a8);
        for(int i = 0; i < a.size(); i++)
        {
            if(a.get(i) != null)
            {
                a.get(i).damage(1);
            }
        }
    }
    
    public abstract void lightAttack();
    public abstract void heavyAttack();
    public abstract void superAttack();
    public abstract void ultimateAttack();
    
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
