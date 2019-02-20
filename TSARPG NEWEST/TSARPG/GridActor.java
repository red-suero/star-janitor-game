import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GridActors here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GridActor extends Actor
{
    public int getGridX()
    {
        return GridManager.getGridX(getX());
    }
    
    public int getGridY()
    {
        return GridManager.getGridY(getY());
    }
    
    public void interact()
    {
        
    }
}
