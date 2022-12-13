package com.Project.chess;

import java.util.ArrayList;
import java.util.Arrays;
public class Knight extends Piece {

	final ArrayList<Vector> authorizedMoves = new ArrayList<Vector>(Arrays.asList(new Vector(1,2), new Vector(2,1), new Vector(1,-2), new Vector(2,-1), new Vector(-2, 1), new Vector(-1,2), new Vector(-2,-1), new Vector(-1,-2)));
	static Type type = Type.KNIGHT;

	public Knight( Player player) {
		super( player);
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
