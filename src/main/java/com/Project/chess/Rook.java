package com.Project.chess;

import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class Rook extends Piece {
	public ArrayList<Vector> authorizedMoves = new ArrayList<Vector>();
	static Type type = Type.ROOK;
	public boolean firstMove = true;
	
	public Rook( Player player) {
		super( player);
		this.name = "rook";
		this.imageWhite = new ImageView(this.initialPath.concat(this.name).concat("White.png"));
		this.imageBlack = new ImageView(this.initialPath.concat(this.name).concat("Black.png"));
	}
	@Override
	public boolean isFirstMove(){
		return this.firstMove;
	}

	public Type getType(){
		return this.type;
	}
	
	@Override
	public void calcMoves() {
		authorizedMoves = new ArrayList<>();
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
		Cell initialCell = this.getCell();
		int directionX = finalCell.getEmplacement()[0]-initialCell.getEmplacement()[0];
		int directionY = finalCell.getEmplacement()[1]-initialCell.getEmplacement()[1];
		Vector moveVector = new Vector(directionX, directionY);
		if(finalCell.getEmplacement()[0]> 7 || finalCell.getEmplacement()[1]> 7 || finalCell.getEmplacement()[0] < 0){
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
			this.firstMove = false;
			return true;
		}
		return false;
	}



}
