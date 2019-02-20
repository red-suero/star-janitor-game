import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Member here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Member extends GridActor
{
    private int type;
    public Member(int type)
    {
        this.type = type;
        if(type == 0)
        {
            setImage("blue-draught.png");
        }
    }
    
    @Override
    public boolean block()
    {
        return false;
    }
}
