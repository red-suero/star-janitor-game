import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Room here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Room extends World
{
    protected Player player;
    public Room()
    {
        super(1280, 720, 1);
        setPaintOrder(Player.class);
        GridManager.drawGrid(this);
        GridManager.setInterval(80);
    }
    
    public abstract Room nextRoom(int gridX, int gridY, Side s);
    public abstract Room prevRoom(int gridX, int gridY, Side s);
    
    public abstract CombatRoom entrance(int gridX, int gridY);
    
    public void addPlayer(Player player, int gridX, int gridY)
    {
        GridManager.addObject(this, player, gridX, gridY);
    }
    
    public abstract void addDoors();
}
