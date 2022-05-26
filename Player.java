package sample;

import javafx.scene.image.ImageView;

public interface Player {
    void moveRight(ImageView imageView);
    void moveLeft(ImageView imageView);
    void moveUp(ImageView imageView);
    void moveDown(ImageView imageView);
    public void setMap(Map map);
    public Position getPosition();

}
