package sample;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Map {
    Scanner scan;
    public int size;
    public char[][] list;
    public Position first_position;
    public ArrayList<Brick> bricks = new ArrayList<>();
    public GridPane pane = new GridPane();
    public BorderPane borderPane = new BorderPane(pane);
    private Scene scene = new Scene(borderPane, size * 64, size * 64);

    Map() throws InvalidMapException, FileNotFoundException {
        scan = new Scanner(new FileReader(new File("src/sample/test.txt")));
        size = scan.nextInt();
        if(size == 0)
            throw new InvalidMapException("Map size can not be zero");
        else {
            list = new char[size][size];
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    list[i][j] = scan.next().charAt(0);
                }
            }
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if(list[i][j] != 'P' && list[i][j] != 'S' && list[i][j] != 'B' && list[i][j] != 'W' && list[i][j] != 'T' && list[i][j] != '0')
                        throw new InvalidMapException("Not enough map elements");
                }
            }
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    char temp = list[i][j];
                    Rectangle rectangle = new Rectangle(64,64);
                    rectangle.setFill(Color.BLACK);
                    switch (temp) {
                        case 'P':
                            first_position = new Position(j,i);
                            break;
                        case 'S':
                            rectangle.setFill(new ImagePattern(new Image("sample/images/steel.png")));
                            break;
                        case 'B':
                            rectangle.setFill(new ImagePattern(new Image("sample/images/bricks.png")));
                            break;
                        case 'W':
                            rectangle.setFill(new ImagePattern(new Image("sample/images/water.png")));
                            break;
                        case 'T':
                            rectangle.setFill(new ImagePattern(new Image("sample/images/trees.png")));
                            break;
                    }
                    pane.add(rectangle,j,i);
                }
            }
            setBricks();
        }
    }

    public void setBricks() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if(list[i][j] == 'B')
                    bricks.add(new Brick(i, j, 4));
            }
        }
    }

    public char getValueAt(int row, int column) {
        return list[column][row];
    }

    public void print() {
        for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    System.out.print(list[i][j] + " "); 
                }
                System.out.println("");
            }
    }

    public int getSize() {
        return size;
    }

    public ArrayList<Brick> getBricks() {
        return bricks;
    }

    public GridPane getPane() {
        return pane;
    }

    public Position getFirst_position() {
        return first_position;
    }

    public char[][] getList() {
        return list;
    }

    public Scene getScene() {
        return scene;
    }
}
