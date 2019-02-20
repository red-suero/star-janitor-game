import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends GridActor
{
    protected int health = 10;
    
    @Override
    public void damage(int damage)
    {
        setHealth(getHealth() - damage);
    }
    
    public void act()
    {
        if(health <= 0)
        {
            getWorld().removeObject(this);
        }
    }
    
    public int getHealth()
    {
        return health;
    }
    
    public void setHealth(int health)
    {
        this.health = health;
    }
}
