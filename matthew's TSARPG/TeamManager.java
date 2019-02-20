import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Write a description of class TeamManager here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TeamManager
{
    private static ArrayList<Member> members = new ArrayList<Member>();
    
    static
    {
        reset();
    }
    
    public static void reset()
    {
        members = new ArrayList<Member>();
        members.add(new Member(0));
        members.add(new Member(1));
    }
    
    public static void addMembers(Player p, World w, Side s)
    {
        if(s == Side.UP)
        {
            GridManager.addObject(w, members.get(0), GridManager.getGridX(p.getX()), GridManager.getGridY(p.getY()) - 1);
            GridManager.addObject(w, members.get(1), GridManager.getGridX(p.getX()), GridManager.getGridY(p.getY()) - 2);
        }
        else if(s == Side.DOWN)
        {
            GridManager.addObject(w, members.get(0), GridManager.getGridX(p.getX()), GridManager.getGridY(p.getY()) + 1);
            GridManager.addObject(w, members.get(1), GridManager.getGridX(p.getX()), GridManager.getGridY(p.getY()) + 2);
        }
    }
    
    public static void addMembers(Player p, World w)
    {
        GridManager.addObject(w, members.get(0), GridManager.getGridX(p.getX()), GridManager.getGridY(p.getY()) + 1);
        GridManager.addObject(w, members.get(1), GridManager.getGridX(p.getX()), GridManager.getGridY(p.getY()) + 2);
    }
    
    public static void moveMembersUp(Player p)
    {
        GridManager.setGridY(members.get(1), GridManager.getGridY(members.get(0).getY()));
        GridManager.setGridX(members.get(1), GridManager.getGridX(members.get(0).getX()));
        GridManager.setGridY(members.get(0), GridManager.getGridY(p.getY()) + 1);
        GridManager.setGridX(members.get(0), GridManager.getGridX(p.getX()));
    }
    
    public static void moveMembersDown(Player p)
    {
        GridManager.setGridY(members.get(1), GridManager.getGridY(members.get(0).getY()));
        GridManager.setGridX(members.get(1), GridManager.getGridX(members.get(0).getX()));
        GridManager.setGridY(members.get(0), GridManager.getGridY(p.getY()) - 1);
        GridManager.setGridX(members.get(0), GridManager.getGridX(p.getX()));
    }
    
    public static void moveMembersLeft(Player p)
    {
        GridManager.setGridY(members.get(1), GridManager.getGridY(members.get(0).getY()));
        GridManager.setGridX(members.get(1), GridManager.getGridX(members.get(0).getX()));
        GridManager.setGridX(members.get(0), GridManager.getGridX(p.getX()) + 1);
        GridManager.setGridY(members.get(0), GridManager.getGridY(p.getY()));
    }
    
    public static void moveMembersRight(Player p)
    {
        GridManager.setGridY(members.get(1), GridManager.getGridY(members.get(0).getY()));
        GridManager.setGridX(members.get(1), GridManager.getGridX(members.get(0).getX()));
        GridManager.setGridX(members.get(0), GridManager.getGridX(p.getX()) - 1);
        GridManager.setGridY(members.get(0), GridManager.getGridY(p.getY()));
    }
}
