package com.Project.chess;

import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;

public class Pawn extends Piece {


	static Type type = Type.PAWN;
	final ArrayList<Vector> whiteAuthorizedMoves = new ArrayList<Vector>(Arrays.asList(new Vector(0, -1)));
	final ArrayList<Vector> blackAuthorizedMoves = new ArrayList<Vector>(Arrays.asList(new Vector(0, 1)));
	final ArrayList<Vector> whiteAttackMoves = new ArrayList<Vector>(Arrays.asList(new Vector(1, -1), new Vector(-1, -1)));
	final ArrayList<Vector> blackAttackMoves   = new ArrayList<Vector>(Arrays.asList(new Vector(-1, 1), new Vector(1, 1)));


	public Pawn(Player player) {
		super(player);

		this.name = "pawn";
		this.imageWhite = new ImageView(this.initialPath.concat(this.name).concat("White.png"));
		this.imageBlack = new ImageView(this.initialPath.concat(this.name).concat("Black.png"));

	}
	@Override
	public boolean ValidMove(Cell finalCell){
		return ((validAttack(finalCell)||validNormalMove(finalCell)));
	}
	public boolean validAttack(Cell finalCell) {
		if (finalCell.isEmpty() || this.getColor() == finalCell.getPiece().getColor()) {
			return false;
		} else {
			Clr color = this.getColor();
			Cell initialCell = this.getCell();
			int directionX = finalCell.getEmplacement()[0] - initialCell.getEmplacement()[0];
			int directionY = finalCell.getEmplacement()[1] - initialCell.getEmplacement()[1];
			Vector moveVector = new Vector(directionX, directionY);

			if (color == Clr.WHITE) {
				//return whiteAttackMoves.contains(moveVector);
				return moveVector.isIn(whiteAttackMoves);
			} else {
				//return blackAttackMoves.contains(moveVector);
				return moveVector.isIn(blackAttackMoves);
			}
		}
	}

	public boolean validNormalMove(Cell finalCell) {
		Cell initialCell = this.getCell();
		int directionX = finalCell.getEmplacement()[0] - this.getCell().getEmplacement()[0];
		int directionY = finalCell.getEmplacement()[1] - this.getCell().getEmplacement()[1];
		Vector moveVector = new Vector(directionX, directionY);

			if (!finalCell.isEmpty()){
				return false;
			}

			if (this.player.color == Clr.WHITE) {
				if(moveVector.getDirectionY() == -2 && moveVector.getDirectionX() == 0){

					if(this.getCell().getEmplacement()[1] == 6 ){
						System.out.println("hhh");
						return finalCell.getBoard().getCell(finalCell.getEmplacement()[0], finalCell.getEmplacement()[1]+1).isEmpty();//finalCell.getBoard().getCell(finalCell.getEmplacement()[0], finalCell.getEmplacement()[1]-1).isEmpty()
					}
					else{
						return false;
					}

				}
				else{
					return moveVector.isIn(whiteAuthorizedMoves);
				}


				}
			else {
				if(moveVector.getDirectionY() == 2 && moveVector.getDirectionX() == 0){
					if(this.getCell().getEmplacement()[1] == 1 ){
 ;
						return finalCell.getBoard().getCell(finalCell.getEmplacement()[0], finalCell.getEmplacement()[1]-1).isEmpty();

					}
					else{
						return false;
					}

				}
				else{
					return moveVector.isIn(blackAuthorizedMoves);
				}

				//return blackAuthorizedMoves.contains(moveVector);

			}
	}


	@Override
	public void attackPiece(Cell finalCell) {
		if (validAttack(finalCell)) {
			this.getCell().setPiece(null);
			Piece takenPiece = finalCell.replacePiece(this);
			takenPiece.setInGame(false);
			this.getPlayer().getTakenPiece().add(takenPiece);
		}

	}

	public boolean transformToQueen() {
		if(this.getColor()==Clr.BLACK && this.getCell().getEmplacement()[1] == 7){
				Queen queen = new Queen(this.getPlayer());
				this.getCell().setPiece(null);
				this.getCell().setPiece(queen);
				return true;

		}
		if(this.getColor()==Clr.WHITE && this.getCell().getEmplacement()[1] == -7){
			Queen queen = new Queen(this.getPlayer());
			this.getCell().setPiece(null);
			this.getCell().setPiece(queen);
			return true;

		}
		return false;
	}

	public boolean makeMove(Cell finalCell) {
		if (validNormalMove(finalCell)) {
			finalCell.setPiece(this);
			this.getCell().setPiece(null);
			this.setCell(finalCell);


		} else {
			if (validAttack(finalCell)) {
				attackPiece(finalCell);
			}
		}
		return this.transformToQueen();

	}
public static void main(String[] args){


	}

}
