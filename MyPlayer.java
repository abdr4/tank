package sample;

import javafx.scene.image.ImageView;

public class MyPlayer implements Player
{
    public Position position;
    Map map;

    @Override
    public void setMap(Map map)
    {
        this.map = map;
        this.position = map.first_position;
    }

    @Override
    public Position getPosition()
    {
        return position;
    }

    public void moveRight(ImageView imageView)
    {
        if (position.getX() + 1 == map.getSize() || map.getValueAt(position.getX() + 1, position.getY()) == 'S' || map.getValueAt(position.getX() + 1, position.getY()) == 'B' || map.getValueAt(position.getX() + 1, position.getY()) == 'W' )
            imageView.setRotate(90);
        else if (position.getX() < map.getSize() - 1 && map.getValueAt(position.getX() + 1, position.getY()) == 'T')
        {
            imageView.setOpacity(0);
            imageView.setRotate(90);
            imageView.setX(imageView.getX()+64);
            position.setX(position.getX() + 1);
        } else if (position.getX() < map.getSize() - 1 && (map.getValueAt(position.getX() + 1, position.getY()) == '0' || map.getValueAt(position.getX() + 1, position.getY()) == 'P'))
        {
            imageView.setOpacity(1);
            imageView.setRotate(90);
            imageView.setX(imageView.getX()+64);
            position.setX(position.getX() + 1);
        }

    }
    public void moveLeft(ImageView imageView)
    {
        if (position.getX() == 0 || map.getValueAt(position.getX() - 1, position.getY()) == 'S' || map.getValueAt(position.getX() - 1, position.getY()) == 'B' || map.getValueAt(position.getX() - 1, position.getY()) == 'W' )
            imageView.setRotate(270);
        else if (position.getX() - 1 >= 0 && map.getValueAt(position.getX() - 1, position.getY()) == 'T')
        {
            imageView.setOpacity(0);
            imageView.setRotate(270);
            imageView.setX(imageView.getX()-64);
            position.setX(position.getX() - 1);
        }
        else if (position.getX() - 1 >= 0 && (map.getValueAt(position.getX() - 1, position.getY()) == '0' || map.getValueAt(position.getX() - 1, position.getY()) == 'P'))
        {
            imageView.setOpacity(1);
            imageView.setRotate(270);
            imageView.setX(imageView.getX()-64);
            position.setX(position.getX() - 1);
        }
    }
    public void moveUp(ImageView imageView)
    {
        if (position.getY() == 0 || map.getValueAt(position.getX(), position.getY() - 1) == 'S' || map.getValueAt(position.getX(), position.getY() - 1) == 'B' || map.getValueAt(position.getX(), position.getY() - 1) == 'W')
            imageView.setRotate(0);
        else if (position.getY() - 1 >= 0 && map.getValueAt(position.getX(), position.getY() - 1) == 'T')
        {
            imageView.setOpacity(0);
            imageView.setRotate(0);
            imageView.setY(imageView.getY()-64);
            position.setY(position.getY() - 1);
        }else if (position.getY() - 1 >= 0 && (map.getValueAt(position.getX(), position.getY() - 1) == '0' || map.getValueAt(position.getX(), position.getY() - 1) == 'P'))
        {
            imageView.setOpacity(1);
            imageView.setRotate(0);
            imageView.setY(imageView.getY()-64);
            position.setY(position.getY() - 1);
        }
    }

    public void moveDown(ImageView imageView) {
        if (position.getY() + 1 == map.getSize() || map.getValueAt(position.getX(), position.getY() + 1) == 'S' || map.getValueAt(position.getX(), position.getY() + 1) == 'B' || map.getValueAt(position.getX(), position.getY() + 1) == 'W')
            imageView.setRotate(180);
        else if (position.getY() < map.getSize() - 1 && map.getValueAt(position.getX(), position.getY() + 1) == 'T')
        {
            imageView.setOpacity(0);
            imageView.setRotate(180);
            imageView.setY(imageView.getY()+64);
            position.setY(position.getY() + 1);
        }
        else if (position.getY() < map.getSize() - 1 && (map.getValueAt(position.getX(), position.getY() + 1) == '0' || map.getValueAt(position.getX(), position.getY() + 1) == 'P'))
        {
            imageView.setOpacity(1);
            imageView.setRotate(180);
            imageView.setY(imageView.getY()+64);
            position.setY(position.getY() + 1);
        }
    }

}
