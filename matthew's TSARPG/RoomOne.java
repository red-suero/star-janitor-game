import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RoomOne extends Room
{
    public RoomOne(Player player, int gridX, int gridY)
    {
        super();
        this.player = player;
        addPlayer(player,gridX, gridY);
        TeamManager.addMembers(player, this);
        addDoors();
    }
    
    public RoomOne(Player player, int gridX, int gridY, Side s)
    {
        super();
        this.player = player;
        addPlayer(player, gridX, gridY);
        TeamManager.addMembers(player, this, s);
        addDoors();
    }
    
    public Room nextRoom(int gridX, int gridY, Side s)
    {
        return new RoomTwo(player, gridX, gridY, s);
    }
    
    public Room prevRoom(int gridX, int gridY, Side s)
    {
        return new RoomOne(player, gridX, gridY);
    }
    
    public CombatRoom entrance(int gridX, int gridY)
    {
        return new CRoomOne(new Brawler(), this, gridX, gridY);
    }
    
    public void addDoors()
    {
        Door d = new Door(Type.NEXT, Side.UP);
        GridManager.addObject(this, d, 9, 0);
        CombatDoor cd = new CombatDoor(Type.NEXT, Side.UP);
        GridManager.addObject(this, cd, 7, 0);
    }
    }
