package com.Project.chess;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ChessBoard extends Application {
    private static final int TILE_SIZE = 75;
    private static final int WIDTH = 8;
    private static final int HEIGHT = 8;

    public void start(Stage primaryStage) {
        GridPane board = new GridPane();
        for (int row = 0; row < HEIGHT; row++) {
            for (int col = 0; col < WIDTH; col++) {
                Label tile = new Label();
                tile.setPrefSize(TILE_SIZE, TILE_SIZE);
                // Set the background color of the tile based on its position
                if ((row + col) % 2 == 0) {
                    tile.setStyle("-fx-background-color: #ffe9c5");
                } else {
                    tile.setStyle("-fx-background-color: #8d816d");
                }
                board.add(tile, col, row);

            }
        }

        board.setAlignment(Pos.CENTER);
        Scene scene = new Scene(board, WIDTH * TILE_SIZE, HEIGHT * TILE_SIZE);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
