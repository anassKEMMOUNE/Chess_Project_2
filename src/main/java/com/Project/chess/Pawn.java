package com.Project.chess;

import java.util.ArrayList;
import java.util.Arrays;

public class Pawn extends Piece{


	static Type type = Type.PAWN;
	final ArrayList<Vector> whiteAuthorizedMoves = new ArrayList<Vector>(Arrays.asList(new Vector(0,1), new Vector(0,2)));
	final ArrayList<Vector> blackAuthorizedMoves = new ArrayList<Vector>(Arrays.asList(new Vector(0,-1), new Vector(0,-2) ));
	final ArrayList<Vector> whiteAttackMoves = new ArrayList<Vector>(Arrays.asList(new Vector(1,1), new Vector(-1,1)));
	final ArrayList<Vector> blackAttackMoves = new ArrayList<Vector>(Arrays.asList(new Vector(-1,-1), new Vector(1,-1)));



	public Pawn (Cell cell, Player player) {
		super(cell, player);
	}
	public boolean validAttack(Cell finalCell){
		if(finalCell.getEmplacment()[0]> 8 || finalCell.getEmplacment()[1]> 8 || finalCell.isEmpty() || this.getColor() == finalCell.getPiece().getColor() ){
			return false;
		}
		else{
			Clr color = this.getColor();
			Cell initialCell = this.getCell();
			int directionX = finalCell.getEmplacment()[0]-initialCell.getEmplacment()[0];
			int directionY = finalCell.getEmplacment()[1]-initialCell.getEmplacment()[1];
			Vector moveVector = new Vector(directionX, directionY);

			if (color == Clr.WHITE) {
				return whiteAttackMoves.contains(moveVector);
			}
			else {
				return blackAttackMoves.contains(moveVector);
			}
		}
	}
	public boolean validNormalMove(Cell finalCell){
		Cell initialCell = this.getCell();
		int directionX = finalCell.getEmplacment()[0]-initialCell.getEmplacment()[0];
		int directionY = finalCell.getEmplacment()[1]-initialCell.getEmplacment()[1];
		Vector moveVector = new Vector(directionX, directionY);
		if(finalCell.getEmplacment()[0]> 8 || finalCell.getEmplacment()[1]> 8 || finalCell.getEmplacment()[0] < 0 || !finalCell.isEmpty()){
			return false;
		}
		else{
			if (color == Clr.WHITE) {
				return whiteAuthorizedMoves.contains(moveVector);
			}
			else {

				return blackAuthorizedMoves.contains(moveVector);
			}

		}
	}
	@Override
	public void attackPiece(Cell finalCell) {
		if(validAttack(finalCell)){
			Piece takenPiece = finalCell.replacePiece(this);
			takenPiece.setInGame(false);
			this.getPlayer().getTakenPiece().add(takenPiece);
		}
	}

	public boolean transformToQueen(){
		if(this.getCell().getEmplacment()[1] == 8 ||  this.getCell().getEmplacment()[1] == -8 ) {
			Queen queen = new Queen(this.getCell(), this.getPlayer());
			this.getCell().setPiece(null);
			this.getCell().setPiece(queen);
			return true;
		}
		return false;
	}

	public boolean makeMove(Cell finalCell){
		if(validNormalMove(finalCell))
		{
			finalCell.setPiece(this);
			this.getCell().setPiece(null);
		}
		else{
			if(validAttack(finalCell)){
				attackPiece(finalCell);
			}
		}
		return this.transformToQueen();

	}
}



