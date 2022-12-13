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
	public void clickEvent(int a) {
		if (!this.getClicked() && ChessInterface.getCounter() == 0) {
			this.setClicked(true);
			ChessInterface.setCounter(1);
			ChessInterface.setSelected(a);
			System.out.println(a);
		}
	}


}
