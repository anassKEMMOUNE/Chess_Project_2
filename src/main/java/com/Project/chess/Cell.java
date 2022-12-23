package com.Project.chess;

import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Cell {
	public Piece piece;
	public static final String whiteColor = "#ffe9c5";
	public static final String blackColor = "#8d816d";
	public int[] emplacement = new int[2];
	public Clr color;
	public Board board;
	public Label tile = new Label();
	public boolean clicked;
	HashMap<String, Label> tiles = new HashMap<>();


	public Cell(int coordX, int coordY) {
		piece = null;
		emplacement[0] = coordX;
		emplacement[1] = coordY;
		this.color = null;
		this.board = null;
		this.clicked = false;
	}

	public Piece getPiece() {
		return piece;
	}

	public void setPiece(Piece piece) {
		this.piece = piece;
	}

	public int[] getEmplacement() {
		return emplacement;
	}

	public void setEmplacement(int[] emplacement) {
		this.emplacement = emplacement;
	}

	public Clr getColor() {
		return color;
	}

	public void setColor(Clr color) {
		this.color = color;
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public Label getTile() {
		return this.tile;
	}

	public void setTile(Label value) {
		this.tile = value;
		tiles.put(String.valueOf(emplacement[0]).concat(String.valueOf(emplacement[1])), this.tile);

	}

	public void setClicked(boolean clicked) {
		this.clicked = clicked;
	}

	public boolean getClicked() {
		return this.clicked;
	}

	public boolean isEmpty() {
		if (this.getPiece() == null) {
			return true;
		} else
			return false;

	}

	public Cell add(Vector vector) {
		int x = this.getEmplacement()[0];
		int y = this.getEmplacement()[1];
		return board.getCell(x + vector.getDirectionX(), y + vector.getDirectionY());
	}

	public Piece replacePiece(Piece other) {
		Piece old = this.getPiece();
		this.setPiece(other);
		other.setCell(this);
		old.setInGame(false);
		old.setCell(null);
		return old;
	}

	public ArrayList<Vector> getDiagonal() {
		ArrayList<Vector> diagonalVectors = new ArrayList<Vector>();
		int currentX = this.getEmplacement()[0];
		int currentY = this.getEmplacement()[1];
		while (currentX < 7 && currentY < 7) {
			diagonalVectors.add(new Vector(currentX + 1 - this.getEmplacement()[0], currentY + 1-this.getEmplacement()[1]));
			if (!board.getCell(currentX + 1, currentY + 1).isEmpty()) {
				break;
			}
			currentX++;
			currentY++;

		}
		currentX = this.getEmplacement()[0];
		currentY = this.getEmplacement()[1];
		while (currentX > 0 && currentY > 0) {
			diagonalVectors.add(new Vector(currentX - 1 - this.getEmplacement()[0], currentY - 1- this.getEmplacement()[1]));
			if (!board.getCell(currentX - 1, currentY - 1).isEmpty()) {
				break;
			}
			currentX--;
			currentY--;
		}
		currentX = this.getEmplacement()[0];
		currentY = this.getEmplacement()[1];
		while (currentX < 7 && currentY > 0) {
			diagonalVectors.add(new Vector(currentX + 1 -  this.getEmplacement()[0], currentY - 1- this.getEmplacement()[1]));
			if (!board.getCell(currentX + 1, currentY - 1).isEmpty()) {
				break;
			}
			currentX++;
			currentY--;
		}
		currentX = this.getEmplacement()[0];
		currentY = this.getEmplacement()[1];
		while (currentX > 0 && currentY < 7) {
			diagonalVectors.add(new Vector(currentX - 1- this.getEmplacement()[0], currentY + 1- this.getEmplacement()[1]));
			if (!board.getCell(currentX - 1, currentY + 1).isEmpty()) {
				break;
			}
			currentX--;
			currentY++;
		}
		return diagonalVectors;

	}

	public ArrayList<Vector> getVertical() {
		ArrayList<Vector> verticalVectors = new ArrayList<Vector>();
		int currentX = this.getEmplacement()[0];
		int currentY = this.getEmplacement()[1];
		while (currentX < 7) {
			verticalVectors.add(new Vector(currentX + 1 - this.getEmplacement()[0], 0));
			if (!board.getCell(currentX + 1, currentY).isEmpty()) {
				break;
			}
			else{
				currentX++;
			}
		}
		currentX = this.getEmplacement()[0];
		currentY = this.getEmplacement()[1];
		while (currentX > 0) {
			verticalVectors.add(new Vector(currentX - 1 - this.getEmplacement()[0], 0));
			if (!board.getCell(currentX - 1, currentY).isEmpty()) {
				break;
			}
			else{
				currentX--;
			}

		}
		currentX = this.getEmplacement()[0];
		currentY = this.getEmplacement()[1];
		while (currentY > 0) {
			verticalVectors.add(new Vector(0, currentY - 1-this.getEmplacement()[1]));
			if (!board.getCell(currentX, currentY - 1 ).isEmpty()) {
				break;
			}
			else{
				currentY--;
			}

		}
		currentX = this.getEmplacement()[0];
		currentY = this.getEmplacement()[1];
		while (currentY < 7) {
			verticalVectors.add(new Vector(0, currentY + 1 - this.getEmplacement()[1]));
			if (!board.getCell(currentX, currentY + 1 ).isEmpty()) {
				break;
			}
			currentY++;
		}
		return verticalVectors;
	}
	public int[] reachable(Piece piece){
		int counter = 0;
		int[] lis = new int[2];
		ArrayList<Vector> possibleVectors = this.getDiagonal();
		possibleVectors.addAll(this.getVertical());
		ArrayList<Vector> knightMoves =  new ArrayList<Vector>(Arrays.asList(new Vector(1,2), new Vector(2,1), new Vector(1,-2), new Vector(2,-1), new Vector(-2, 1), new Vector(-1,2), new Vector(-2,-1), new Vector(-1,-2)));
		for(Vector vect_ : knightMoves){
			try{
				this.add(vect_);
				possibleVectors.add(vect_);

			}catch(Exception e){

			}
		}
		for(Vector vect__ : possibleVectors){
			if(!this.add(vect__).isEmpty() && piece.getColor() != this.add(vect__).getPiece().getColor()){
				if(this.add(vect__).getPiece().ValidMove(this)){
					counter ++;
				}
			}
		}
		if(counter == 0){
			lis[0] = 0;
		}
		else{
			lis[0] = 1;
		}
		lis[1] = counter;

		return lis;

	}
	public void clickEvent(int c, int b) {

		if (ChessInterface.getSelectedPiece().getClicked() && ChessInterface.getSelectedPiece().ValidMove(board.cells[c][b])) {


			if (ChessInterface.getSelectedPiece().validCasting(board.cells[c][b])) {
				Cell[] positions = ChessInterface.getSelectedPiece().calcCastling(board.cells[c][b]);
				ImageView rookImage = board.cells[c][b].getPiece().getImage();
				ChessInterface.board.grid.getChildren().remove(board.cells[c][b].getPiece().getImage());
				ChessInterface.board.grid.getChildren().remove(ChessInterface.getSelectedPiece().getImage());
				board.grid.add(ChessInterface.getSelectedPiece().getImage(), positions[0].getEmplacement()[0], positions[0].getEmplacement()[1]);
				board.grid.add(rookImage, positions[1].getEmplacement()[0], positions[1].getEmplacement()[1]);
			}

			if (ChessInterface.getSelectedPiece().getCell().getColor() == Clr.WHITE) {
				ChessInterface.getSelectedPiece().getCell().getTile().setStyle("-fx-background-color: ".concat(Cell.whiteColor));
			} else {
				ChessInterface.getSelectedPiece().getCell().getTile().setStyle("-fx-background-color: ".concat(Cell.blackColor));
			}

			ChessInterface.getSelectedPiece().makeMove(board.cells[c][b]);
			ChessInterface.getSelectedPiece().getPlayer().isTurn = false;
			if(ChessInterface.getSelectedPiece().getPlayer().getColor() == Clr.WHITE){
				ChessInterface.board.player2.isTurn = true;
			}
			else{
				ChessInterface.board.player1.isTurn = true;
			}

			ChessInterface.getSelectedPiece().setClicked(false);
			System.out.println("Reachable : "+ this.reachable(ChessInterface.getSelectedPiece())[0]);
			ChessInterface.oldSelectedPieces.removeAll(ChessInterface.oldSelectedPieces);

				for (Cell j : ChessInterface.oldSelectedPaths.get(ChessInterface.oldSelectedPaths.size()-1)){
					if (!ChessInterface.getSelectedPiece().ValidMove(j)){
						if (j.getColor() == Clr.WHITE){
							j.getTile().setStyle("-fx-background-color: ".concat(Cell.whiteColor));
						}
						else {
							j.getTile().setStyle("-fx-background-color: ".concat(Cell.blackColor));
						}
					}
			}
			for (int i = 0; i < 8; i++) {
				for (int j= 0; j<8;j++){

					if (ChessInterface.board.cells[i][j].getColor() == Clr.WHITE){
						ChessInterface.board.cells[i][j].getTile().setStyle("-fx-background-color: ".concat(Cell.whiteColor));
					}
					else {
						ChessInterface.board.cells[i][j].getTile().setStyle("-fx-background-color: ".concat(Cell.blackColor));
					}


				}

			}

			//ChessInterface.oldSelectedPaths.removeAll(ChessInterface.oldSelectedPaths);


		}
		if (ChessInterface.board.player1.king.checkmate()){
			ChessInterface.board.player1.king.checkedTest = true;
		}
		if (ChessInterface.board.player2.king.checkmate()){
			ChessInterface.board.player2.king.checkedTest = true;
		}
	}
}
