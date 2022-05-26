package sample;

public class Position
{
    private int X,Y;
    Position position;
    Position(int X, int Y)
    {
        this.X = X;
        this.Y = Y;
    }
    public void setX(int x)
    {
        X = x;
    }
    public void setY(int y)
    {
        Y = y;
    }
    public int getX()
    {
        return X;
    }
    public int getY()
    {
        return Y;
    }
    public boolean equals(Position position)
    {
       return (position.getX() == X && position.getY() == Y);
    }
    @Override
    public String toString()
    {
        return "(" + position.getX() + "," + position.getY() + ")";
    }
}
