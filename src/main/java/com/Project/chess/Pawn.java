package com.Project.chess;

import java.util.ArrayList;
import java.util.Arrays;

public class Pawn extends Piece{
	
	
	final ArrayList<Vector> whiteAuthorizedMoves = new ArrayList<Vector>(Arrays.asList(new Vector(0,1), new Vector(0,2)));
	final ArrayList<Vector> blackAuthorizedMoves = new ArrayList<Vector>(Arrays.asList(new Vector(0,-1), new Vector(0,-2) ));
	final ArrayList<Vector> whiteAttackdMoves = new ArrayList<Vector>(Arrays.asList(new Vector(1,1), new Vector(-1,1)));
	final ArrayList<Vector> blackAttackdMoves = new ArrayList<Vector>(Arrays.asList(new Vector(-1,-1), new Vector(1,-1)));
	
	
	public Pawn (Cell cell, Player player) {
		super(cell, player);
	}
	
	public boolean isValidPath(Cell finalCell) {
		Clr color = this.getColor();
		Cell initialCell = this.getCell();
		int directionX = finalCell.getEmplacment()[0]-initialCell.getEmplacment()[0];
		int directionY = finalCell.getEmplacment()[1]-initialCell.getEmplacment()[1];
		Vector moveVector = new Vector(directionX, directionY);
		if(finalCell.isEmpty()) {
			if (color == Clr.WHITE) {
				if(whiteAuthorizedMoves.contains(moveVector)) {
					return true;
				}
			}
			else {
				if(blackAuthorizedMoves.contains(moveVector)) {
					return true;
				}
			}
		}
		else {
			if (color == Clr.WHITE) {
				if(whiteAttackdMoves.contains(moveVector)) {
					return true;
				}
			}
			else {
				if(blackAuthorizedMoves.contains(moveVector)) {
					return true;
				}
			}
			
		}
		return false;
	}
	
	public boolean attackPiece(Cell finalCell) {
		if(!(finalCell.isEmpty()) && finalCell.getColor()!= this.getColor()) {
			if(this.isValidPath(finalCell)) {
				Piece takenPiece = finalCell.replacePiece(this);
				takenPiece.setInGame(false);
				Player player = this.getPlayer();
				player.getTakenPiece().add(takenPiece);
			}
		}
		return false;
		
	}
	
	public void transformToQueen(){
		if(this.getCell().getEmplacment()[1] == 8 ||  this.getCell().getEmplacment()[1] == -8 ) {
			Queen queen = new Queen(this.getCell(), this.getPlayer());
			this.getCell().setPiece(null);
			this.getCell().setPiece(queen);
		}
		
	}
}


