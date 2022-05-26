package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Tank {
    private ImageView imageView = new ImageView(new Image("sample/images/tank.gif"));
    Map map;



    public void setImageView() {
        imageView.setFitWidth(64);
        imageView.setFitHeight(64);
        imageView.setX(map.getFirst_position().getX() * 64);
        imageView.setY(map.getFirst_position().getY() *  64);
        //borderPane.getChildren().add(imageView);
        setImageView();
    }
    public void setMap(Map map) {
        this.map = map;
    }
    public ImageView getImageView() {
        return imageView;
    }
}
