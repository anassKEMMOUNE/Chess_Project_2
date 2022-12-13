package com.Project.chess;

import java.util.ArrayList;

public class Bishop extends Piece {
	
	public ArrayList<Vector> authorizedMoves ;
	static Type type = Type.BISHOP;
	
	public Bishop( Player player) {
		super( player);
	}


	
	@Override
	public void calcMoves() {
		authorizedMoves = new ArrayList<Vector>();
		ArrayList<Vector> diag = this.getCell().getDiagonal();
		for(Vector vect : diag){
			Cell targetCell = this.getCell().add(vect);
			if(targetCell.isEmpty()){
				authorizedMoves.add(vect);
			}
			else{
				if(targetCell.getPiece().getColor() != this.getColor()){
					authorizedMoves.add(vect);
				}
			}
		}
		
	}

	public boolean validMove(Cell finalCell){
		Cell initialCell = this.getCell();
		int directionX = finalCell.getEmplacment()[0]-initialCell.getEmplacment()[0];
		int directionY = finalCell.getEmplacment()[1]-initialCell.getEmplacment()[1];
		Vector moveVector = new Vector(directionX, directionY);
		if(finalCell.getEmplacment()[0]> 8 || finalCell.getEmplacment()[1]> 8 || finalCell.getEmplacment()[0] < 0){
			return false;
		}
		else{
			return authorizedMoves.contains(moveVector);
		}
	}
	@Override
	public void attackPiece(Cell finalCell){
		if(finalCell.isEmpty()){
			return;
		}
		if(validMove(finalCell)){
			Piece takenPiece = finalCell.replacePiece(this);
			takenPiece.setInGame(false);
			this.getPlayer().getTakenPiece().add(takenPiece);
		}
	}

	@Override
	public boolean makeMove(Cell finalCell){
		this.calcMoves();
		if (validMove(finalCell)){
			if(finalCell.isEmpty()){
				finalCell.setPiece(this);
				this.getCell().setPiece(null);
			}
			else{
				if(finalCell.getPiece().getColor() == this.getColor()){ // add type rook to condition
					return false;
				}
				attackPiece(finalCell);
			}
			return true;
		}
		return false;

	}

}
