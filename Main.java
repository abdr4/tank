package sample;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main extends Application {
    private Map map;
    public MyPlayer player;
    private GridPane gridPane;
    public Pane borderPane;
    public Scene scene;
    private ArrayList<Brick> bricks;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws InvalidMapException, FileNotFoundException {
            borderPane = new Pane();
            map = new Map();
            player = new MyPlayer();
            bricks = map.getBricks();
            this.player.setMap(map);
            gridPane = map.getPane();

            Tank tank = new Tank();Move move = new Move(map,player,tank);
            borderPane.getChildren().addAll(gridPane, tank.getImageView());
            scene = new Scene(borderPane, map.getSize() * 64, map.getSize() * 64);
            scene.setOnKeyPressed(e ->
            { move.mve();
               switch (e.getCode())
               {
                   case SPACE:
                       ImageView imageView1 = new ImageView(new Image("sample/images/explosion.gif"));
                       int rotate = (int)imageView.getRotate();

                       switch (rotate){
                           case 0:
                               int bullet1 = 0;
                               for (int i = player.getPosition().getY() - 1; i >= 0; i--)
                               {
                                   if(map.getValueAt(player.getPosition().getX(), i) == 'S')
                                       break;
                                   else if(map.getList()[i][player.getPosition().getX()] == 'B')
                                   {
                                       for (int j = 0; j < bricks.size(); j++)
                                       {
                                           if (bricks.get(j).getX() == i && bricks.get(j).getY() == player.getPosition().getX())
                                               bricks.get(j).setLive(bricks.get(j).getLive() - 1);
                                           if (bricks.get(j).getLive() == 0)
                                               removeBrickX(i, j, gridPane);
                                       }
                                       break;
                                   }

                                   else
                                       bullet1++;
                               }
                               imageView1.setX(player.getPosition().getX() * 64 + 26);
                               imageView1.setY(player.getPosition().getY() * 64 - 15);
                               borderPane.getChildren().add(imageView1);
                               TranslateTransition translateTransition1 = new TranslateTransition(Duration.millis(600),imageView1);
                               translateTransition1.setByY(-bullet1 * 64);
                               translateTransition1.play();
                               FadeTransition fade1 = new FadeTransition(Duration.millis(900),imageView1);
                               fade1.setFromValue(1);
                               fade1.setToValue(0);
                               fade1.play();
                               break;
                           case 90:
                               int bullet2 = 0;
                               for (int i = player.getPosition().getX() + 1; i <= map.getList().length - 1; i++)
                               {
                                   if (map.getList()[player.getPosition().getY()][i] == 'S')
                                       break;
                                   else if (map.getList()[player.getPosition().getY()][i] == 'B')
                                   {
                                       for (int j = 0; j < bricks.size(); j++)
                                       {
                                           if (bricks.get(j).getX() == player.getPosition().getY() && bricks.get(j).getY() == i)
                                               bricks.get(j).setLive(bricks.get(j).getLive() - 1);
                                           if (bricks.get(j).getLive() == 0)
                                               removeBrickY(i, j, gridPane);
                                       }
                                       break;
                                   }
                                   else
                                       bullet2++;
                               }
                               imageView1.setX(player.getPosition().getX() * 64 + 64);
                               imageView1.setY(player.getPosition().getY() * 64 + 25);
                               borderPane.getChildren().add(imageView1);
                               TranslateTransition translateTransition2 = new TranslateTransition(Duration.millis(600),imageView1);
                               translateTransition2.setByX(64 * bullet2);
                               translateTransition2.play();
                               FadeTransition fade2 = new FadeTransition(Duration.millis(900),imageView1);
                               fade2.setFromValue(10);
                               fade2.setToValue(0);
                               fade2.play();
                               break;
                           case 180:
                               int bullet3 = 0;
                               for (int i = player.getPosition().getY() + 1; i <= map.getList().length - 1; i++)
                               {
                                   if (map.getList()[i][player.getPosition().getX()] == 'S')
                                       break;
                                   else if (map.getList()[i][player.getPosition().getX()] == 'B')
                                   {
                                       for (int j = 0; j < bricks.size(); j++) {
                                           if (bricks.get(j).getX() == i && bricks.get(j).getY() == player.getPosition().getX())
                                               bricks.get(j).setLive(bricks.get(j).getLive() - 1);
                                           if (bricks.get(j).getLive() == 0)
                                               removeBrickX(i, j, gridPane);
                                       }
                                       break;
                                   }
                                   else
                                       bullet3++;
                               }
                               imageView1.setX(player.getPosition().getX() * 64 + 25);
                               imageView1.setY(player.getPosition().getY() * 64 + 64);
                               borderPane.getChildren().add(imageView1);
                               TranslateTransition translateTransition3 = new TranslateTransition(Duration.millis(600),imageView1);
                               translateTransition3.setByY(64 * bullet3);
                               translateTransition3.play();
                               FadeTransition fade3 = new FadeTransition(Duration.millis(900),imageView1);
                               fade3.setFromValue(100);
                               fade3.setToValue(0);
                               fade3.play();
                               break;
                           case 270:
                               int bullet4 = 0;
                               for (int i = player.getPosition().getX() - 1; i >= 0; i--)
                               {
                                   if (map.getList()[player.getPosition().getY()][i] == 'S')
                                       break;
                                   else if (map.getList()[player.getPosition().getY()][i] == 'B')
                                   {
                                       for (int j = 0; j < bricks.size(); j++) {
                                           if (bricks.get(j).getX() == player.getPosition().getY() && bricks.get(j).getY() == i)
                                               bricks.get(j).setLive(bricks.get(j).getLive() - 1);
                                           if (bricks.get(j).getLive() == 0)
                                               removeBrickY(i, j, gridPane);
                                       }
                                       break;
                                   }
                                   else
                                       bullet4++;
                               }
                               imageView1.setX(player.getPosition().getX() * 64 - 15);
                               imageView1.setY(player.getPosition().getY() * 64 + 27);
                               borderPane.getChildren().add(imageView1);
                               TranslateTransition translateTransition4 = new TranslateTransition(Duration.millis(600),imageView1);
                               translateTransition4.setByX(-64 * bullet4);
                               translateTransition4.play();
                               FadeTransition fade4 = new FadeTransition(Duration.millis(900),imageView1);
                               fade4.setFromValue(1);
                               fade4.setToValue(0);
                               fade4.play();
                               break;
                       }
               }
         });
            primaryStage.setScene(scene);
            primaryStage.show();
    }

    void removeBrickX(int i, int j, GridPane gridPane)
    {
        Rectangle rectangle = new Rectangle(64,64);
        rectangle.setFill(Color.BLACK);
        gridPane.add(rectangle, player.getPosition().getX(), i);
        map.getList()[i][player.getPosition().getX()] = '0';
        bricks.remove(j);
    }

    void removeBrickY(int i, int j, GridPane gridPane)
    {
        Rectangle rectangle = new Rectangle(64,64);
        rectangle.setFill(Color.BLACK);
        gridPane.add(rectangle, i, player.getPosition().getY());
        map.getList()[player.getPosition().getY()][i] = '0';
        bricks.remove(j);
    }

}
