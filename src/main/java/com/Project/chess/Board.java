package com.Project.chess;

public class Board {
    private Cell[][] cells=new Cell[8][8];


    /**
     * The board with its original position.
     */
    public Board()
    {
        setCells();
        setWhitePieces();
        setBlackPieces();

    }

    /**
     * Resets the board to its original position.
     */
    public void resetBoard(){
        setCells();
        setWhitePieces();
        setBlackPieces();
    }

    /**
     * Initializes all the cells
     */
    private void setCells(){
        for (int i=0;i<8;i++)
        {
            for (int j=0;j<8;j++)
            {
                cells[i][j]=new Cell(i , j, this);
            }
        }

    }

    /**
     * Initializes and assigns all white Pieces.
     */
    private void setWhitePieces(){
        cells[0][2].setPiece(new Bishop(null, null));
        cells[0][5].setPiece(new Bishop(null, null));
        cells[0][1].setPiece(new Knight(null, null));
        cells[0][6].setPiece(new Knight(null, null));
        cells[0][0].setPiece(new Rook(null, null));
        cells[0][7].setPiece(new Rook(null, null));
        cells[0][3].setPiece(new Queen(null, null));
        cells[0][4].setPiece(new King(null, null));
        cells[0][0].setPiece(new Pawn(null, null));
        cells[1][1].setPiece(new Pawn(null, null));
        cells[1][2].setPiece(new Pawn(null, null));
        cells[1][3].setPiece(new Pawn(null, null));
        cells[1][4].setPiece(new Pawn(null, null));
        cells[1][5].setPiece(new Pawn(null, null));
        cells[1][6].setPiece(new Pawn(null, null));
        cells[1][7].setPiece(new Pawn(null, null));

    }

    private void setBlackPieces(){
        cells[7][2].setPiece(new Bishop(null, null));
        cells[7][5].setPiece(new Bishop(null, null));
        cells[7][1].setPiece(new Knight(null, null));
        cells[7][6].setPiece(new Knight(null, null));
        cells[7][0].setPiece(new Rook(null, null));
        cells[7][7].setPiece(new Rook(null, null));
        cells[7][3].setPiece(new Queen(null, null));
        cells[7][4].setPiece(new King(null, null));
        cells[6][0].setPiece(new Pawn(null, null));
        cells[6][1].setPiece(new Pawn(null, null));
        cells[6][2].setPiece(new Pawn(null, null));
        cells[6][3].setPiece(new Pawn(null, null));
        cells[6][4].setPiece(new Pawn(null, null));
        cells[6][5].setPiece(new Pawn(null, null));
        cells[6][6].setPiece(new Pawn(null, null));
        cells[6][7].setPiece(new Pawn(null, null));

    }


    /**
     * Returns all the squares on the board.
     * @return Square[][] A dimensional array of all the Squares
     */
    public Cell[][] getCells(){
        return cells;
    }
    public Cell getCell(int x, int y){
        return cells[x][y];
    }
}
