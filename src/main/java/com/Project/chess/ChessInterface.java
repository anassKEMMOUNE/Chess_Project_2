package com.Project.chess;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;



public class ChessInterface extends Application {
    private static final int TILE_SIZE = 64;
    private static final int WIDTH = 8;
    private static final int HEIGHT = 8;
     public static int counter = 0;
    public static int selected;
    public static Board board;

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
                    System.out.println(board.cells[0][5].getEmplacement()[1]);
                    System.out.println(board.player1.PawnsArray.get(0).ValidMove(board.cells[0][5]));
                    if (board.player1.PawnsArray.get(getSelected()).getClicked() && getCounter()==1 ){
                        board.grid.getChildren().remove(board.player1.PawnsArray.get(getSelected()).getImage());
                        board.grid.add(board.player1.PawnsArray.get(getSelected()).getImage(),c,b);
                        board.player1.PawnsArray.get(getSelected()).setCell(board.cells[c][b]);
                        board.player1.PawnsArray.get(getSelected()).setClicked(false);
                        setCounter(0);
                        if (board.player1.PawnsArray.get(getSelected()).getCell().getColor() == Clr.WHITE){
                            board.player1.PawnsArray.get(getSelected()).getCell().getTile().setStyle("-fx-background-color: ".concat(Cell.whiteColor));
                        }
                        else{
                            board.player1.PawnsArray.get(getSelected()).getCell().getTile().setStyle("-fx-background-color: ".concat(Cell.blackColor));
                        }


                    }

/*
                    else if (board.player2.PawnsArray.get(getSelected()).getClicked() && getCounter()==1 ){
                        board.grid.getChildren().remove(board.player2.PawnsArray.get(getSelected()).getImage());
                        board.grid.add(board.player2.PawnsArray.get(getSelected()).getImage(),c,b);
                        board.player2.PawnsArray.get(getSelected()).setClicked(false);
                        setCounter(0);



                    }
                    else if (board.player1.RooksArray.get(getSelected()).getClicked() && getCounter()==1 ){
                        board.grid.getChildren().remove(board.player1.RooksArray.get(getSelected()).getImage());
                        board.grid.add(board.player1.RooksArray.get(getSelected()).getImage(),c,b);
                        board.player1.RooksArray.get(getSelected()).setClicked(false);
                        setCounter(0);
                    }
                    else if (board.player2.RooksArray.get(getSelected()).getClicked() && getCounter()==1 ){
                        board.grid.getChildren().remove(board.player2.RooksArray.get(getSelected()).getImage());
                        board.grid.add(board.player2.RooksArray.get(getSelected()).getImage(),c,b);
                        board.player2.RooksArray.get(getSelected()).setClicked(false);
                        setCounter(0);
                    }
                    else if (board.player1.KnightsArray.get(getSelected()).getClicked() && getCounter()==1 ){
                        board.grid.getChildren().remove(board.player1.KnightsArray.get(getSelected()).getImage());
                        board.grid.add(board.player1.KnightsArray.get(getSelected()).getImage(),c,b);
                        board.player1.KnightsArray.get(getSelected()).setClicked(false);
                        setCounter(0);
                    }
                    else if (board.player2.KnightsArray.get(getSelected()).getClicked() && getCounter()==1 ){
                        board.grid.getChildren().remove(board.player2.KnightsArray.get(getSelected()).getImage());
                        board.grid.add(board.player2.KnightsArray.get(getSelected()).getImage(),c,b);
                        board.player2.KnightsArray.get(getSelected()).setClicked(false);
                        setCounter(0);
                    }

                    else if (board.player1.BishopsArray.get(getSelected()).getClicked() && getCounter()==1 ){
                        board.grid.getChildren().remove(board.player1.BishopsArray.get(getSelected()).getImage());
                        board.grid.add(board.player1.BishopsArray.get(getSelected()).getImage(),c,b);
                        board.player1.BishopsArray.get(getSelected()).setClicked(false);
                        setCounter(0);
                    }
                    else if (board.player2.BishopsArray.get(getSelected()).getClicked() && getCounter()==1 ){
                        board.grid.getChildren().remove(board.player2.BishopsArray.get(getSelected()).getImage());
                        board.grid.add(board.player2.BishopsArray.get(getSelected()).getImage(),c,b);
                        board.player2.BishopsArray.get(getSelected()).setClicked(false);
                        setCounter(0);
                    }
                    else if (board.player1.king.getClicked() && getCounter()==1 ){
                        board.grid.getChildren().remove(board.player1.king.getImage());
                        board.grid.add(board.player1.king.getImage(),c,b);
                        board.player1.king.setClicked(false);
                        setCounter(0);
                    }
                    else if (board.player2.king.getClicked() && getCounter()==1 ){
                        board.grid.getChildren().remove(board.player2.king.getImage());
                        board.grid.add(board.player2.king.getImage(),c,b);
                        board.player2.king.setClicked(false);
                        setCounter(0);
                    }
                    else if (board.player1.queen.getClicked() && getCounter()==1 ){
                        board.grid.getChildren().remove(board.player1.queen.getImage());
                        board.grid.add(board.player1.queen.getImage(),c,b);
                        board.player1.queen.setClicked(false);
                        setCounter(0);
                    }
                    else if (board.player2.queen.getClicked() && getCounter()==1 ){
                        board.grid.getChildren().remove(board.player2.queen.getImage());
                        board.grid.add(board.player2.queen.getImage(),c,b);
                        board.player2.queen.setClicked(false);
                        setCounter(0);
                    }
*/
                });
            }
        }



        //board.getChildren().remove(a);
        grid.setAlignment(Pos.CENTER);
        Scene scene = new Scene(grid, WIDTH * TILE_SIZE, HEIGHT * TILE_SIZE);
        primaryStage.setScene(scene);
        primaryStage.show();


    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        ChessInterface.counter = counter;
    }

    public static int getSelected() {
        return selected;
    }

    public static void setSelected(int selected) {
        ChessInterface.selected = selected;
    }

    public static void main(String[] args) {
        launch(args);


    }
}