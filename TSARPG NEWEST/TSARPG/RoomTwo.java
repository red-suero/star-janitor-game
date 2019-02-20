import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RoomTwo extends Room
{
    public RoomTwo(Player p, int gridX, int gridY, Side s)
    {
        super();
        this.p = p;
        addPlayer(gridX, gridY);
        TeamManager.addMembers(p, this, s);
        addDoors();
    }
    
    public Room nextRoom(int gridX, int gridY, Side s)
    {
        return new RoomOne(p, gridX, gridY, s);
    }
    
    public Room prevRoom(int gridX, int gridY, Side s)
    {
        return new RoomOne(p, gridX, gridY, s);
    }
    
    public void addPlayer(int gridX, int gridY)
    {
        GridManager.addObject(this, p, gridX, gridY);
    }
    
    public void addEnemy(int gX, int gY)
    {
        
    }
    
    public void addPuzzleObjects()
    {
        
    }
    
    public void addDoors()
    {
        Door d = new Door(Type.NEXT, Side.DOWN);
        GridManager.addObject(this, d, 9, 8);
    }
}
