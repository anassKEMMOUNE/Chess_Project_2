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
        GridPane board = new GridPane();
        HashMap<String,Label> tiles = new HashMap<>();
        for (int row = 0; row < HEIGHT; row++) {
            for (int col = 0; col < WIDTH; col++) {
                Label tile = new Label();
                tile.setPrefSize(TILE_SIZE, TILE_SIZE);
                // Stocking a tile in a hashmap
                tiles.put(String.valueOf(row).concat(String.valueOf(col)),tile);
                // Set the background color of the tile based on its position
                if ((row + col) % 2 == 0) {
                    tile.setStyle("-fx-background-color: #ffe9c5");
                } else {
                    tile.setStyle("-fx-background-color: #8d816d");
                }
                board.add(tile, col, row);

            }
        }


       /* for (int i = 0; i<HEIGHT; i++){
            for (int j =0 ; j < WIDTH;j++){
                String a = String.valueOf(i).concat(String.valueOf(j));
                tiles.get(a).setOnMouseClicked(mouseEvent -> tiles.get(a).setStyle(tiles.get(a).getStyle().concat(" ;-fx-border-color: #000000")));

            }
        }*/

        ArrayList<ImageView> playerOnePawnsImg = new ArrayList<>();
        ArrayList<ImageView> playerTwoPawnsImg = new ArrayList<>();
        for (int x =0 ; x<HEIGHT;x++){
            playerOnePawnsImg.add(new ImageView("C:\\Users\\anass\\OneDrive\\Bureau\\Studies - UM6P\\2nd year - CPI\\S3\\LBD3\\CHess test interface\\Chess_Project_2\\src\\main\\java\\com\\Project\\chess\\pawn.png"));
            playerTwoPawnsImg.add(new ImageView("C:\\Users\\anass\\OneDrive\\Bureau\\Studies - UM6P\\2nd year - CPI\\S3\\LBD3\\CHess test interface\\Chess_Project_2\\src\\main\\java\\com\\Project\\chess\\pawn.png"));
        }
        for (int r = 0; r < HEIGHT; r++) {
            board.add(playerOnePawnsImg.get(r),r,1);
            board.add(playerTwoPawnsImg.get(r),r,6);
        }

        for (int i =0;i<8;i++){

                ImageView a = playerOnePawnsImg.get(i);

                playerOnePawnsImg.get(i).setOnMouseClicked(mouseEvent -> {

                    board.getChildren().remove(a);
                    board.add(a,5,5);

                });

        }




       /* board.add(new ImageView("king.png"),4,0);
        board.add(new ImageView("king.png"),4,7);
        board.add(new ImageView("Rook.png"),0,0);
        board.add(new ImageView("Rook.png"),7,7);
        board.add(new ImageView("Rook.png"),7,0);
        board.add(new ImageView("Rook.png"),0,7);
        board.add(new ImageView("Knight.png"),1,0);
        board.add(new ImageView("Knight.png"),6,0);
        board.add(new ImageView("Knight.png"),1,7);
        board.add(new ImageView("Knight.png"),6,7);
        board.add(new ImageView("Queen.png"),3,0);
        board.add(new ImageView("Queen.png"),3,7);
        board.add(new ImageView("Bishop.png"),2,0);
        board.add(new ImageView("Bishop.png"),5,0);
        board.add(new ImageView("Bishop.png"),2,7);
        board.add(new ImageView("Bishop.png"),5,7);*/
        board.setAlignment(Pos.CENTER);
        Scene scene = new Scene(board, WIDTH * TILE_SIZE, HEIGHT * TILE_SIZE);
        primaryStage.setScene(scene);
        primaryStage.show();

    }



    public static void main(String[] args) {
        launch(args);
    }
}