package com.Project.chess;

import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

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
			ChessInterface.board.grid.getChildren().remove(finalCell.getPiece().getImage());
			this.getCell().setPiece(null);
			Piece takenPiece = finalCell.replacePiece(this);
			takenPiece.setInGame(false);
			this.getPlayer().getTakenPiece().add(takenPiece);
			ChessInterface.board.grid.getChildren().remove(finalCell.getPiece().getImage());
			ChessInterface.board.grid.add(this.getImage(),finalCell.getEmplacement()[0],finalCell.getEmplacement()[1]);
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
			ChessInterface.board.grid.getChildren().remove(this.getImage());
			ChessInterface.board.grid.add(this.getImage(),finalCell.getEmplacement()[0],finalCell.getEmplacement()[1]);




		} else {
			if (validAttack(finalCell)) {
				attackPiece(finalCell);
			}
		}
		this.promotion();
		return true;

	}
	public boolean promotion(){

		if(this.getCell().getEmplacement()[1] == 0 ){
			System.out.println("Choose your piece :  ");
			System.out.println("Tap '1' for Queen ");
			System.out.println("Tap '2' for Rook ");
			System.out.println("Tap '3' for BISHOP ");
			System.out.println("Tap '4' for KNIGHT ");
			Scanner sc = new Scanner(System.in);
			int n = sc.nextInt();
			switch(n){
				case 1:
					ChessInterface.board.grid.getChildren().remove(ChessInterface.board.cells[this.getCell().getEmplacement()[0]][0].getPiece().getImage());
					ImageView newimage = new ImageView(Piece.initialPath.concat("queenWhite.png"));
					ChessInterface.board.grid.add(newimage, this.getCell().getEmplacement()[0], 0);
					Queen newQueen = new Queen(this.getPlayer());
					newQueen.setCell(this.getCell());
					newQueen.setImageWhite(newimage);
					this.getCell().setPiece(newQueen);
					newQueen.getImage().setOnMouseClicked(mouseEvent -> newQueen.clickEvent(0));
					break;
				case 2:
					ChessInterface.board.grid.getChildren().remove(ChessInterface.board.cells[this.getCell().getEmplacement()[0]][0].getPiece().getImage());
					ImageView newimagee = new ImageView(Piece.initialPath.concat("rookWhite.png"));
					ChessInterface.board.grid.add(newimagee, this.getCell().getEmplacement()[0], 0);
					Rook newRook = new Rook(this.getPlayer());
					newRook.setCell(this.getCell());
					newRook.setImageWhite(newimagee);
					this.getCell().setPiece(newRook);
					newRook.getImage().setOnMouseClicked(mouseEvent -> newRook.clickEvent(0));
					break;
				case 3:
					ChessInterface.board.grid.getChildren().remove(ChessInterface.board.cells[this.getCell().getEmplacement()[0]][0].getPiece().getImage());
					ImageView newimageee = new ImageView(Piece.initialPath.concat("bishopWhite.png"));
					ChessInterface.board.grid.add(newimageee, this.getCell().getEmplacement()[0], 0);
					Bishop newBishop = new Bishop(this.getPlayer());
					newBishop.setCell(this.getCell());
					newBishop.setImageWhite(newimageee);
					this.getCell().setPiece(newBishop);
					newBishop.getImage().setOnMouseClicked(mouseEvent -> newBishop.clickEvent(0));
					break;
				case 4:
					ChessInterface.board.grid.getChildren().remove(ChessInterface.board.cells[this.getCell().getEmplacement()[0]][0].getPiece().getImage());
					ImageView newimag = new ImageView(Piece.initialPath.concat("knightWhite.png"));
					ChessInterface.board.grid.add(newimag, this.getCell().getEmplacement()[0], 0);
					Knight newKnight = new Knight(this.getPlayer());
					newKnight.setCell(this.getCell());
					newKnight.setImageWhite(newimag);
					this.getCell().setPiece(newKnight);
					newKnight.getImage().setOnMouseClicked(mouseEvent -> newKnight.clickEvent(0));

					break;
				default:
					System.out.println("chose a valid a move :");
			}
			return true;


		}else if(this.getCell().getEmplacement()[1] == 7){
			System.out.println("Choose your piece : ");
			System.out.println("Tap '1' for Queen ");
			System.out.println("Tap '2' for Rook ");
			System.out.println("Tap '3' for BISHOP ");
			System.out.println("Tap '4' for KNIGHT ");
			Scanner sc = new Scanner(System.in);
			int n = sc.nextInt();
			switch(n){
				case 1:
					ChessInterface.board.grid.getChildren().remove(ChessInterface.board.cells[this.getCell().getEmplacement()[0]][7].getPiece().getImage());
					ImageView newimage = new ImageView(Piece.initialPath.concat("queenBlack.png"));
					ChessInterface.board.grid.add(newimage, this.getCell().getEmplacement()[0], 7);
					Queen newQueen = new Queen(this.getPlayer());
					newQueen.setCell(this.getCell());
					newQueen.setImageBlack(newimage);
					this.getCell().setPiece(newQueen);
					newQueen.getImage().setOnMouseClicked(mouseEvent -> newQueen.clickEvent(0));
					break;
				case 2:
					ChessInterface.board.grid.getChildren().remove(ChessInterface.board.cells[this.getCell().getEmplacement()[0]][7].getPiece().getImage());
					ImageView newimagee = new ImageView(Piece.initialPath.concat("rookBlack.png"));
					ChessInterface.board.grid.add(newimagee, this.getCell().getEmplacement()[0], 7);
					Rook newRook = new Rook(this.getPlayer());
					newRook.setCell(this.getCell());
					newRook.setImageBlack(newimagee);
					this.getCell().setPiece(newRook);
					newRook.getImage().setOnMouseClicked(mouseEvent -> newRook.clickEvent(0));
					break;
				case 3:
					ChessInterface.board.grid.getChildren().remove(ChessInterface.board.cells[this.getCell().getEmplacement()[0]][7].getPiece().getImage());
					ImageView newimageee = new ImageView(Piece.initialPath.concat("bishopBlack.png"));
					ChessInterface.board.grid.add(newimageee, this.getCell().getEmplacement()[0], 7);
					Bishop newBishop = new Bishop(this.getPlayer());
					newBishop.setCell(this.getCell());
					newBishop.setImageBlack(newimageee);
					this.getCell().setPiece(newBishop);
					newBishop.getImage().setOnMouseClicked(mouseEvent -> newBishop.clickEvent(0));
					break;
				case 4:
					ChessInterface.board.grid.getChildren().remove(ChessInterface.board.cells[this.getCell().getEmplacement()[0]][7].getPiece().getImage());
					ImageView newimag = new ImageView(Piece.initialPath.concat("knightBlack.png"));
					ChessInterface.board.grid.add(newimag, this.getCell().getEmplacement()[0], 7);
					Knight newKnight = new Knight(this.getPlayer());
					newKnight.setCell(this.getCell());
					newKnight.setImageBlack(newimag);
					this.getCell().setPiece(newKnight);
					newKnight.getImage().setOnMouseClicked(mouseEvent -> newKnight.clickEvent(0));

					break;
				default:
					System.out.println("chose a valid a move :");
			}
			return true;
		}
		return false;
	}
public static void main(String[] args){


	}

}
