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
        if(getWorld() != null)
        {
            return GridManager.getGridX(getX());
        }
        else
        {
            return -1;
        }
    }
    
    public int getGridY()
    {
        if(getWorld() != null)
        {
            return GridManager.getGridY(getY());
        }
        else
        {
            return -1;
        }
    }
    
    public void interact()
    {
        
    }
    
    public void damage(int damage)
    {
        
    }
    
    public boolean block()
    {
        return true;
    }
}
