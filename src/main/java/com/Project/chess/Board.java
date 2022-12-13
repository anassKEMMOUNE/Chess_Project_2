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
            grid.add(player2.PawnsArray.get(i).getImage(),i,1);

        }
        grid.add(player1.BishopsArray.get(0).getImage(),2,7);
        grid.add(player1.BishopsArray.get(1).getImage(),5,7);
        grid.add(player2.BishopsArray.get(0).getImage(),2,0);
        grid.add(player2.BishopsArray.get(1).getImage(),5,0);
        grid.add(player1.RooksArray.get(0).getImage(),0,7);
        grid.add(player1.RooksArray.get(1).getImage(),7,7);
        grid.add(player2.RooksArray.get(0).getImage(),0,0);
        grid.add(player2.RooksArray.get(1).getImage(),7,0);
        grid.add(player1.KnightsArray.get(0).getImage(),1,7);
        grid.add(player1.KnightsArray.get(1).getImage(),6,7);
        grid.add(player2.KnightsArray.get(0).getImage(),1,0);
        grid.add(player2.KnightsArray.get(1).getImage(),6,0);
        grid.add(player1.king.getImage(),4,7);
        grid.add(player1.queen.getImage(),3,7);
        grid.add(player2.king.getImage(),4,0);
        grid.add(player2.queen.getImage(),3,0);





    }

    public Cell[][] getCells(){
        return cells;
    }
    public Cell getCell(int x, int y){
        return cells[x][y];
    }
}
