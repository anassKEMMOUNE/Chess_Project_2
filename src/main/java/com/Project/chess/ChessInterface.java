package com.Project.chess;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.HashMap;


public class ChessInterface extends Application {
    private static final int TILE_SIZE = 64;
    private static final int WIDTH = 8;
    private static final int HEIGHT = 8;
     public int counter = 0;
    public int selected;

    public void start(Stage primaryStage) {


        Board board = new Board();
        GridPane grid = board.grid;

        //board.player1.moveAnass(0);
        for (int i=0;i<8;i++){
            int a = i;
            board.player1.PawnsArray.get(i).getImage().setOnMouseClicked(mouseEvent -> {

                if (!board.player1.PawnsArray.get(a).getClicked() && this.getCounter()==0){
                    board.player1.PawnsArray.get(a).setClicked(true);
                    this.setCounter(1);
                    this.setSelected(a);
                    System.out.println(a);
                }
            });

        }

        for (int i=0;i<8;i++){
             int c =  i;
            for (int j =0;j<8;j++){
                 int b = j;
                board.cells[i][j].getTile().setOnMouseClicked(mouseEvent -> {
                    if (board.player1.PawnsArray.get(this.getSelected()).getClicked() && this.getCounter()==1 ){
                        board.grid.getChildren().remove(board.player1.PawnsArray.get(this.getSelected()).getImage());
                        board.grid.add(board.player1.PawnsArray.get(this.getSelected()).getImage(),b,c);
                        board.player1.PawnsArray.get(this.getSelected()).setClicked(false);
                        this.setCounter(0);
                        System.out.println(c);
                        System.out.println(b);


                    }
                });
            }
        }



        //board.getChildren().remove(a);
        grid.setAlignment(Pos.CENTER);
        Scene scene = new Scene(grid, WIDTH * TILE_SIZE, HEIGHT * TILE_SIZE);
        primaryStage.setScene(scene);
        primaryStage.show();


    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public int getSelected() {
        return selected;
    }

    public void setSelected(int selected) {
        this.selected = selected;
    }

    public static void main(String[] args) {
        launch(args);

    }
}