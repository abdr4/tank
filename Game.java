package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Game extends Application {
    private Scene scene;
    private Stage stage;
    private Tank tank;

    private Map map;
    private MyPlayer player;

    public Game(Map map) throws InvalidMapException {
        this.map = map;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.stage = primaryStage;
        stage.setScene(scene);
        stage.show();
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public void addPlayer(Player player) {
        this.player = (MyPlayer) player;
        this.player.setMap(map);
        for (int i = 0; i < map.getSize(); i++) {
            for (int j = 0; j < map.getSize(); j++) {
                if (map.list[i][j] == 'P')
                    this.player.position = new Position(i, j);
            }
        }
    }
}