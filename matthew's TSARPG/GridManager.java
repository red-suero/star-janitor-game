import greenfoot.*;
import java.util.ArrayList;
public class GridManager  
{
    private static int interval = 80;
    private static ArrayList<GridActor> gridActors = new ArrayList<GridActor>();
    public static void addObject(World w, GridActor o, int gridX, int gridY)
    {
        w.addObject(o, interval/2 + gridX * interval, interval/2 + gridY* interval);
        gridActors.add(o);
    }
    
    public static void drawGrid(World w)
    {
        int a = w.getHeight()/interval - 1;
        int c = 0;
        for(int i = 0; i <= a; i++)
        {
            addDots(w, c, i);
            c++;
        }
    }
    
    public static void addDots(World w, int c, int d)
    {
        int b = w.getWidth()/interval - 1;
        int t;
        if(d % 2 == 0)
        {
            t = 0;
        }
        else
        {
            t = 1;
        }
        for(int i = 0; i <= b; i++)
        {
            w.addObject(new Dot(i, c, t), interval/2 + interval * i,  interval/2 + c * interval);
            t++;
            if(t > 1)
            {
                t = 0;
            }
        }
    }
    
    public static int getLeftBound(World w)
    {
        return 0;
    }
    
    public static int getUpperBound(World w)
    {
        return 0;
    }
    
    public static int getRightBound(World w)
    {
        return w.getWidth()/interval - 1;
    }
    
    public static int getLowerBound(World w)
    {
        return w.getHeight()/interval - 1;
    }
    
    public static int getGridX(int x)
    {
        return (interval/2 + x)/interval - 1;
    }
    
    public static int getGridY(int y)
    {
        return (interval/2 + y)/interval - 1;
    }
    
    public static void setGridX(Actor a, int gridX)
    {
        int x = interval * (gridX + 1) - interval/2;
        a.setLocation(x, a.getY());
    }
    
    public static void setGridY(Actor a, int gridY)
    {
        int y = interval * (gridY + 1) - interval/2;
        a.setLocation(a.getX(), y);
    }
    
    public static void setInterval(int newInterval)
    {
        interval = newInterval;
    }
    
    public static int interval()
    {
        return interval;
    }
    
    public static boolean sameCoordinates(int aX, int aY, int bX, int bY)
    {
        if(aX == bX && aY == bY)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public static GridActor getInFront(int gridX, int gridY, Direction d)
    {
        if(d == Direction.UP)
        {
            return getGridActor(gridX, gridY - 1);
        }
        else if(d == Direction.DOWN)
        {
            return getGridActor(gridX, gridY + 1);
        }
        else if(d == Direction.LEFT)
        {
            return getGridActor(gridX - 1, gridY);
        }
        else if(d == Direction.RIGHT)
        {
            return getGridActor(gridX + 1, gridY);
        }
        else
        {
            return null;
        }
    }
    
    public static GridActor getGridActor(int gridX, int gridY)
    {
        GridActor a = null;
        for(int i = 0; i < gridActors.size(); i++)
        {
            if(gridActors.get(i).getGridX() == gridX && gridActors.get(i).getGridY() == gridY)
            {
                a = gridActors.get(i);
            }
        }
        return a;
    }
    
    public static boolean blocked(int gridX, int gridY, Direction d)
    {
        GridActor a = (GridActor) getInFront(gridX, gridY, d);
        if(a != null && a.block())
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
        public static class Dot extends Actor
        {
            private int gridX;
            private int gridY;
            public Dot(int x, int y, int type)
            {
                // if(type == 0)
                // {
                    // setImage("black.png");
                // }
                // else if(type == 1)
                // {
                    // setImage("gray.png");
                // }
                setImage("floor.png");
                getImage().scale(interval, interval);
                this.gridX = x;
                this.gridY = y;
            }
    
            public int getGridX()
            {
                return gridX;
            }
            
            public int getGridY()
            {
                return gridY;
            }
        }
}
