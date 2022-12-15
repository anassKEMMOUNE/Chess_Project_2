package com.Project.chess;

import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class Bishop extends Piece {
	
	public ArrayList<Vector> authorizedMoves ;
	static Type type = Type.BISHOP;
	
	public Bishop( Player player) {
		super( player);
		this.name=  "bishop";
		this.imageWhite = new ImageView(this.initialPath.concat(this.name).concat("White.png"));
		this.imageBlack = new ImageView(this.initialPath.concat(this.name).concat("Black.png"));
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
	@Override
	public boolean ValidMove(Cell finalCell){
		this.calcMoves();
		Cell initialCell = this.getCell();
		int directionX = finalCell.getEmplacement()[0]-initialCell.getEmplacement()[0];
		int directionY = finalCell.getEmplacement()[1]-initialCell.getEmplacement()[1];
		Vector moveVector = new Vector(directionX, directionY);
		if(finalCell.getEmplacement()[0]> 8 || finalCell.getEmplacement()[1]> 8 || finalCell.getEmplacement()[0] < 0){
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
			Piece takenPiece = finalCell.replacePiece(this);
			takenPiece.setInGame(false);
			this.getPlayer().getTakenPiece().add(takenPiece);
		}
	}

	@Override
	public boolean makeMove(Cell finalCell){
		this.calcMoves();
		if (ValidMove(finalCell)){
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
