import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CRoomOne here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CRoomOne extends CombatRoom
{
    public CRoomOne(CombatPlayer player, Room prev, int gridX, int gridY)
    {
       this.player = player; 
       this.prev = prev;
       addPlayer(player, gridX, gridY);
       addEnemy(new Enemy(), 3, 4);
       addDoors();
    }
    
    public void addDoors()
    {
       CombatDoor d = new CombatDoor(Type.PREV, Side.UP);
       GridManager.addObject(this, d, 9, 0);
    }
}
