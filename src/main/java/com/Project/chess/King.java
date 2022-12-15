package com.Project.chess;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.Arrays;
public class King extends Piece {
	
	
	
	final ArrayList<Vector> authorizedMoves = new ArrayList<Vector>(Arrays.asList(new Vector(1,0),new Vector(1,1), new Vector(0,1), new Vector(-1,1), new Vector(-1,0), new Vector(-1,-1), new Vector(0, -1), new Vector(1,-1)));
	static Type type = Type.KING;

	public King (Player player) {
		super( player);
		this.name = "king";
		this.imageWhite = new ImageView(this.initialPath.concat(this.name).concat("White.png"));
		this.imageBlack = new ImageView(this.initialPath.concat(this.name).concat("Black.png"));
	}

	public boolean validMove(Cell finalCell){
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

	public boolean doCasting() {
		return false;
	}
	
	

}
