package sample;

import java.util.ArrayList;

public class Brick {

    private int X, Y;
    private int live;
    public Brick(int x, int y, int live)
    {
        this.X = x;
        this.Y = y;
        this.live = live;
    }

    public void setLive(int live)
    {
        this.live = live;
    }

    public int getY()
    {
        return Y;
    }

    public int getX()
    {
        return X;
    }

    public int getLive()
    {
        return live;
    }

}
