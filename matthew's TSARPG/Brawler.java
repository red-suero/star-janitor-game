import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Brawler here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Brawler extends CombatPlayer
{
    public void lightAttack()
    {
        GridActor a = (GridActor) GridManager.getInFront(getGridX(), getGridY(), d);
        if(a != null)
        {
           a.damage(1);
        }
    }
    
    public void heavyAttack()
    {
        fullCircle();
    }
    
    public void superAttack()
    {
        
    }
    
    public void ultimateAttack()
    {
        
    }   
}
