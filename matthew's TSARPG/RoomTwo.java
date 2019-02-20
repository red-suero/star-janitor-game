import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RoomTwo extends Room
{
    public RoomTwo(Player player, int gridX, int gridY, Side s)
    {
        super();
        this.player = player;
        addPlayer(player, gridX, gridY);
        TeamManager.addMembers(player, this, s);
        addDoors();
    }
    
    public Room nextRoom(int gridX, int gridY, Side s)
    {
        return new RoomOne(player, gridX, gridY, s);
    }
    
    public Room prevRoom(int gridX, int gridY, Side s)
    {
        return new RoomOne(player, gridX, gridY, s);
    }
    
    public CombatRoom entrance(int gridX, int gridY)
    {
        return new CRoomOne(new Brawler(), this, gridX, gridY);
    }
    
    public void addPlayer(int gridX, int gridY)
    {
        GridManager.addObject(this, player, gridX, gridY);
    }
    
    public void addDoors()
    {
        Door d = new Door(Type.NEXT, Side.DOWN);
        GridManager.addObject(this, d, 9, 8);
    }
}
