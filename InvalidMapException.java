package sample;

public class InvalidMapException extends Exception
{
    InvalidMapException()
    {
        super("Not enough map elements");
    }
    InvalidMapException(String mistake)
    {
        super(mistake);
    }
}
