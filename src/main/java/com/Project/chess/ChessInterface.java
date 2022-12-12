package com.Project.chess;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.HashMap;


public class ChessInterface extends Application {
    private static final int TILE_SIZE = 64;
    private static final int WIDTH = 8;
    private static final int HEIGHT = 8;


    public void start(Stage primaryStage) {


        Board board = new Board();
        GridPane grid = board.grid;

        board.player1.moveAnass(0);

        //board.getChildren().remove(a);
        grid.setAlignment(Pos.CENTER);
        Scene scene = new Scene(grid, WIDTH * TILE_SIZE, HEIGHT * TILE_SIZE);
        primaryStage.setScene(scene);
        primaryStage.show();


    }



    public static void main(String[] args) {
        launch(args);

    }
}