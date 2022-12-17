package com.Project.chess;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class Board {
    private static final int TILE_SIZE = 64;
    public Cell[][] cells=new Cell[8][8];
    public GridPane grid = new GridPane();
    public Pane container = new Pane();
    public Player player1  ;
    Player player2 ;

    public Board(){
        for(int row =0;row<8;row++){
            for (int col = 0;col<8;col++){
                cells[col][row]= new Cell(col,row);
                cells[col][row].setTile(new Label());
                cells[col][row].setBoard(this);
                cells[col][row].getTile().setPrefSize(TILE_SIZE,TILE_SIZE);

                if ((col + row) % 2 == 0) {
                    cells[col][row].getTile().setStyle("-fx-background-color: #ffe9c5");
                    cells[col][row].setColor(Clr.WHITE);
                } else {
                    cells[col][row].getTile().setStyle("-fx-background-color: #8d816d");
                    cells[col][row].setColor(Clr.BLACK);
                }
                grid.add(cells[col][row].getTile(), col, row);

            }
        }
        player1 = new Player(true,this);
        player2 = new Player(false,this);
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
        container.getChildren().add(grid);




    }

    public Cell[][] getCells(){
        return cells;
    }
    public Cell getCell(int x, int y){
        return cells[x][y];
    }
}
