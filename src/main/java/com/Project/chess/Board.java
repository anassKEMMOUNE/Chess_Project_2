package com.Project.chess;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class Board {
    private static final int TILE_SIZE = 64;
    public Cell[][] cells=new Cell[8][8];
    public GridPane grid = new GridPane();
    Player player1 = new Player( true,this);
    Player player2 = new Player( false,this);

    public Board(){
        for(int row =0;row<8;row++){
            for (int col = 0;col<8;col++){
                cells[row][col]= new Cell(8-row,8-col);
                cells[row][col].setTile(new Label());
                cells[row][col].getTile().setPrefSize(TILE_SIZE,TILE_SIZE);
                if ((row + col) % 2 == 0) {
                    cells[row][col].getTile().setStyle("-fx-background-color: #ffe9c5");
                } else {
                    cells[row][col].getTile().setStyle("-fx-background-color: #8d816d");
                }
                grid.add(cells[row][col].getTile(), col, row);

            }
        }

        player1.setColor(Clr.WHITE);
        player2.setColor(Clr.BLACK);
        for ( int i =0;i<8;i++){
            grid.add(player1.PawnsArray.get(i).getImage(),i,6);

        }

    }

    public Cell[][] getCells(){
        return cells;
    }
    public Cell getCell(int x, int y){
        return cells[x][y];
    }
}
