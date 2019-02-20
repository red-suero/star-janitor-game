import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CombatRoom here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class CombatRoom extends World
{
    protected CombatPlayer player;
    protected Room prev;
    public CombatRoom()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1280, 720, 1); 
        setPaintOrder(CombatPlayer.class);
        GridManager.drawGrid(this);
        GridManager.setInterval(80);
    }
    
    public Room prevRoom(int gridX, int gridY, Side s)
    {
        return prev;
    }
    
    public void addPlayer(CombatPlayer player, int gridX, int gridY)
    {
       GridManager.addObject(this, player, gridX, gridY);
    }
    
    public void addEnemy(Enemy e, int gridX, int gridY)
    {
        GridManager.addObject(this, e, gridX, gridY);
    }
    
    public abstract void addDoors();
}
