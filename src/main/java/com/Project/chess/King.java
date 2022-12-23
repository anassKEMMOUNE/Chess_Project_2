package com.Project.chess;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.Arrays;
public class King extends Piece {
	
	
	
	final ArrayList<Vector> authorizedMoves = new ArrayList<Vector>(Arrays.asList(new Vector(1,0),new Vector(1,1), new Vector(0,1), new Vector(-1,1), new Vector(-1,0), new Vector(-1,-1), new Vector(0, -1), new Vector(1,-1)));
	public boolean firstMove = true;
	public King (Player player) {
		super( player);
		this.name = "king";
		this.imageWhite = new ImageView(this.initialPath.concat(this.name).concat("White.png"));
		this.imageBlack = new ImageView(this.initialPath.concat(this.name).concat("Black.png"));
		this.type = Type.KING;
	}
	@Override
	public boolean ValidMove(Cell finalCell){
		return((this.ValidNormalMove(finalCell)||validCasting(finalCell)) && finalCell.reachable(this)[0] == 0);
	}
	public boolean ValidNormalMove(Cell finalCell){
		Cell initialCell = this.getCell();
		int directionX = finalCell.getEmplacement()[0]-initialCell.getEmplacement()[0];
		int directionY = -finalCell.getEmplacement()[1]+initialCell.getEmplacement()[1];
		Vector moveVector = new Vector(directionX, directionY);
		if(finalCell.getEmplacement()[0]> 7 || finalCell.getEmplacement()[1]> 7 || finalCell.getEmplacement()[0] < 0){
			return false;
		}
		if(!finalCell.isEmpty() && finalCell.getPiece().getColor() == this.getColor()){
			return false;
		}

		else{
			//return authorizedMoves.contains(moveVector);
			return moveVector.isIn(authorizedMoves);
		}
	}
	@Override
	public void attackPiece(Cell finalCell){
		if(finalCell.isEmpty()){
			return;
		}
		if(ValidMove(finalCell)){
			ChessInterface.board.grid.getChildren().remove(finalCell.getPiece().getImage());
			this.getCell().setPiece(null);
			Piece takenPiece = finalCell.replacePiece(this);
			takenPiece.setInGame(false);
			this.getPlayer().getTakenPiece().add(takenPiece);
			ChessInterface.board.grid.getChildren().remove(finalCell.getPiece().getImage());
			ChessInterface.board.grid.add(this.getImage(),finalCell.getEmplacement()[0],finalCell.getEmplacement()[1]);

		}
	}

	@Override
	public boolean makeMove(Cell finalCell){
		if (ValidMove(finalCell)){
			if(finalCell.isEmpty()){
				finalCell.setPiece(this);
				this.getCell().setPiece(null);
				this.setCell(finalCell);
				ChessInterface.board.grid.getChildren().remove(this.getImage());
				ChessInterface.board.grid.add(this.getImage(),finalCell.getEmplacement()[0],finalCell.getEmplacement()[1]);

			}
			else{
				if(validCasting(finalCell)){
					//System.out.println();// add type rook to condition
					int direction = (this.getCell().getEmplacement()[0]-finalCell.getEmplacement()[0])/Math.abs(finalCell.getEmplacement()[0]-this.getCell().getEmplacement()[0]);
					Vector vectKing;
					Vector vectRook;
					if(direction>0){
						vectKing = new Vector(-2*direction, 0);
						vectRook = new Vector(3*(direction), 0);
					}
					else{
						vectKing = new Vector(-2*direction, 0);
						vectRook = new Vector(2*(direction), 0);
					}

					Cell finalCellKing = this.getCell().add(vectKing);
					Cell finalCellRook = finalCell.add(vectRook);
					finalCellKing.setPiece(this);
					this.getCell().setPiece(null);
					this.setCell(finalCellKing);
					finalCellRook.setPiece(finalCell.getPiece());
					finalCell.setPiece(null);
					finalCellRook.getPiece().setCell(finalCellRook);
					//System.out.println(" final Rook X Emplacement : " + finalCellRook.getEmplacement()[0]);
				}
				else{
					attackPiece(finalCell);

				}

			}
			this.firstMove = false;
			return true;
		}
		return false;
	}
	@Override
	public Cell[] calcCastling(Cell finalCell){
		Cell[] listCastle = new Cell[2];
		int direction = (this.getCell().getEmplacement()[0]-finalCell.getEmplacement()[0])/Math.abs(finalCell.getEmplacement()[0]-this.getCell().getEmplacement()[0]);
		Vector vectKing;
		Vector vectRook;
		if(direction>0){
			vectKing = new Vector(-2*direction, 0);
			vectRook = new Vector(3*(direction), 0);
		}
		else{
			vectKing = new Vector(-2*direction, 0);
			vectRook = new Vector(2*(direction), 0);
		}

		Cell finalCellKing = this.getCell().add(vectKing);
		Cell finalCellRook = finalCell.add(vectRook);
		listCastle[0] = finalCellKing;
		listCastle[1] = finalCellRook;
		return listCastle;
	}
	@Override
	public boolean validCasting(Cell finalCell) {
		if(!finalCell.isEmpty() && finalCell.getPiece().getType()==Type.ROOK && this.firstMove && finalCell.getPiece().isFirstMove()){
			int direction = (finalCell.getEmplacement()[0]-this.getCell().getEmplacement()[0] )/Math.abs(this.getCell().getEmplacement()[0] - finalCell.getEmplacement()[0]);
			int norm = Math.abs(this.getCell().getEmplacement()[0] - finalCell.getEmplacement()[0]);
			Vector vect_ = new Vector(direction, 0);
			Cell actualCell = this.getCell();
			for(int i = 0; i<norm-1;i++){
				Cell intermediate = actualCell.add(vect_);
				if(!intermediate.isEmpty()){

					return false;
				}

				actualCell = intermediate;
			}
			return (finalCell.getPiece().getColor() == this.getColor());

		}
		else{
			return false;
		}
	}

	public int nonAccessible(){
		int counter = 0;
		ArrayList<Cell> possibleCells = new ArrayList<>();
		for(Vector vect__ : authorizedMoves){
			try{
				possibleCells.add(this.getCell().add(vect__));
			}catch (Exception e){

			}
		}
		for(Cell cell : possibleCells){
			if(this.ValidMove(cell) && cell.reachable(this)[0] ==1){
				System.out.println(cell.getEmplacement());
				counter++;
			}
		}

		return counter;

	}
	public boolean checkmate(){
		ArrayList<Cell> validCells = new ArrayList<Cell>();
		for(Vector vect_ : authorizedMoves){
			try{
				if(this.ValidMove(this.getCell().add(vect_))){
					validCells.add(this.getCell().add(vect_));

				}
}catch (Exception e){

			}
		}
		if(validCells.size() == 0 && this.getCell().reachable(this)[1] >= 2 ){
			System.out.println("checkmate !!");
			return true;
		}
		return false;

	}
	
	

}
