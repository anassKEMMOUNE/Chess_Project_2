package com.Project.chess;

import javafx.scene.image.ImageView;

import java.util.ArrayList;


public class Queen extends Piece {

	public ArrayList<Vector> authorizedMoves;
	static Type type = Type.QUEEN;
	
	public Queen( Player player) {
		super( player);
		this.name = "queen";
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
		ArrayList<Vector> vert = this.getCell().getVertical();
		for(Vector vect_ : vert){
			Cell targetCell = this.getCell().add(vect_);
			if(targetCell.isEmpty()){
				authorizedMoves.add(vect_);
			}
			else{
				if(targetCell.getPiece().getColor() != this.getColor()){
					authorizedMoves.add(vect_);
				}
			}
		}
		System.out.println(authorizedMoves);

		
	}
	@Override
	public boolean ValidMove(Cell finalCell){
		this.calcMoves();
		Cell initialCell = this.getCell();
		int directionX = finalCell.getEmplacement()[0]-initialCell.getEmplacement()[0];
		int directionY = finalCell.getEmplacement()[1]-initialCell.getEmplacement()[1];
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
			this.getCell().setPiece(null);
			Piece takenPiece = finalCell.replacePiece(this);
			takenPiece.setInGame(false);
			this.getPlayer().getTakenPiece().add(takenPiece);
		}

	}

	@Override
	public boolean makeMove(Cell finalCell){
		if (ValidMove(finalCell)){
			if(finalCell.isEmpty()){
				finalCell.setPiece(this);
				this.getCell().setPiece(null);
				this.setCell(finalCell);
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
