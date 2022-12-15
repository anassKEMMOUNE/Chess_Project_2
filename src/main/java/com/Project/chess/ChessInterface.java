package com.Project.chess;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;


public class ChessInterface extends Application {
    private static final int TILE_SIZE = 64;
    private static final int WIDTH = 8;
    private static final int HEIGHT = 8;

    public static int selected;
    public static Piece selectedPiece;
    public static Board board;

    public static ArrayList<Piece> oldSelectedPieces = new ArrayList<>();

    public void start(Stage primaryStage) {


        board = new Board();
        GridPane grid = board.grid;

        //board.player1.moveAnass(0);
        for (int i=0;i<8;i++){
            int a = i;
            board.player1.PawnsArray.get(i).getImage().setOnMouseClicked(mouseEvent -> board.player1.PawnsArray.get(a).clickEvent(a));
            board.player2.PawnsArray.get(i).getImage().setOnMouseClicked(mouseEvent -> board.player2.PawnsArray.get(a).clickEvent(a));

        }
        for (int i=0;i<2;i++){
            int a = i;
            board.player1.RooksArray.get(i).getImage().setOnMouseClicked(mouseEvent -> board.player1.RooksArray.get(a).clickEvent(a));
            board.player2.RooksArray.get(i).getImage().setOnMouseClicked(mouseEvent -> board.player2.RooksArray.get(a).clickEvent(a));
            board.player1.KnightsArray.get(i).getImage().setOnMouseClicked(mouseEvent -> board.player1.KnightsArray.get(a).clickEvent(a));
            board.player2.KnightsArray.get(i).getImage().setOnMouseClicked(mouseEvent -> board.player2.KnightsArray.get(a).clickEvent(a));
            board.player1.BishopsArray.get(i).getImage().setOnMouseClicked(mouseEvent -> board.player1.BishopsArray.get(a).clickEvent(a));
            board.player2.BishopsArray.get(i).getImage().setOnMouseClicked(mouseEvent -> board.player2.BishopsArray.get(a).clickEvent(a));
            board.player1.king.getImage().setOnMouseClicked(mouseEvent -> board.player1.king.clickEvent(a));
            board.player2.king.getImage().setOnMouseClicked(mouseEvent -> board.player2.king.clickEvent(a));
            board.player1.queen.getImage().setOnMouseClicked(mouseEvent -> board.player1.queen.clickEvent(a));
            board.player2.queen.getImage().setOnMouseClicked(mouseEvent -> board.player2.queen.clickEvent(a));
        }


        for (int i=0;i<8;i++){
             int c =  i;
            for (int j =0;j<8;j++){
                 int b = j;

                board.cells[i][j].getTile().setOnMouseClicked(mouseEvent -> {
                        board.cells[c][b].clickEvent(c,b);

                });
            }
        }



        //board.getChildren().remove(a);
        grid.setAlignment(Pos.CENTER);
        Scene scene = new Scene(grid, WIDTH * TILE_SIZE, HEIGHT * TILE_SIZE);
        primaryStage.setScene(scene);
        primaryStage.show();


    }


    public static int getSelected() {
        return selected;
    }

    public static void setSelected(int selected) {
        ChessInterface.selected = selected;
    }
    public static Piece getSelectedPiece() {
        return selectedPiece;
    }

    public static void setSelectedPiece(Piece selected) {
        ChessInterface.selectedPiece = selected;
    }

    public static void main(String[] args) {
        launch(args);


    }
}