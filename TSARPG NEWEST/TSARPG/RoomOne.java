import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RoomOne extends Room
{
    public RoomOne(Player p, Sniper s, int gridX, int gridY, int gX, int gY)
    {
        super();
        this.p = p;
        addPlayer(gridX, gridY);
        TeamManager.addMembers(p, this);
        addDoors();
        addPuzzleObjects();
        this.s = s;
        addEnemy(gX, gY);
    }
    
    public RoomOne(Player p, int gridX, int gridY, Side s)
    {
        super();
        this.p = p;
        addPlayer(gridX, gridY);
        TeamManager.addMembers(p, this, s);
        addDoors();
        addPuzzleObjects();
    }
    
    public Room nextRoom(int gridX, int gridY, Side s)
    {
        return new RoomTwo(p, gridX, gridY, s);
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
        GridManager.addObject(this, s, gX, gY);
    }
    
    public void addPuzzleObjects()
    {
        PuzzleObject p = new PuzzleObject();
        GridManager.addObject(this, p, 2, 3);
    }
    
    public void addDoors()
    {
        Door d = new Door(Type.NEXT, Side.UP);
        GridManager.addObject(this, d, 9, 0);
    }
    }
