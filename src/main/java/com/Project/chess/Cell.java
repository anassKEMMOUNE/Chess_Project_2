package com.Project.chess;

import javafx.scene.control.Label;

import java.util.ArrayList;
import java.util.HashMap;

public class Cell {
	public Piece piece;
	public int[] emplacment = new int[2];
	public Clr color;
	public Board board ;
	public Label tile = new Label();
	public boolean clicked;
	HashMap<String,Label> tiles = new HashMap<>();



	public Cell(int coordX, int coordY) {
		piece = null;
		emplacment[0] = coordX;
		emplacment[1] = coordY;
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

	public int[] getEmplacment() {
		return emplacment;
	}

	public void setEmplacment(int[] emplacment) {
		this.emplacment = emplacment;
	}

	public Clr getColor() {
		return color;
	}

	public void setColor(Clr color) {
		this.color = color;
	}
	public Label getTile() {
		return this.tile;
	}

	public void setTile(Label value) {
		this.tile = value;
		tiles.put(String.valueOf(emplacment[0]).concat(String.valueOf(emplacment[1])),this.tile);

	}

	public void setClicked(boolean clicked) {
		this.clicked = clicked;
	}
	public boolean getClicked(){
		return this.clicked;
	}

	public boolean isEmpty(){
		if(this.getPiece() == null) {
			return true;
		}
		else
			return false;

	}
	public Cell add(Vector vector){
		int x = this.getEmplacment()[0];
		int y = this.getEmplacment()[1];
		if(x+vector.getDirectionX()>8 || x+vector.getDirectionX()<0 || y+vector.getDirectionY()>8 || y+vector.getDirectionY()<0){
			return this;
		}
		return board.getCell(x+vector.getDirectionX(), y+vector.getDirectionY() );

	}

	public Piece replacePiece(Piece other) {
		Piece old = this.getPiece();
		this.setPiece(other);
		old.setInGame(false);
		return old;
	}

	public ArrayList<Vector> getDiagonal(){
		ArrayList<Vector> diagonalVectors = new ArrayList<Vector>();
		int currentX = this.getEmplacment()[0];
		int currentY = this.getEmplacment()[1];
		while(currentX < 8 && currentY < 8 ){
			diagonalVectors.add(new Vector(currentX +1, currentY+1));
			if(!board.getCell(currentX +1,currentY+1 ).isEmpty()){
				break;
			}
			currentX++;
			currentY++;

		}
		currentX = this.getEmplacment()[0];
		currentY = this.getEmplacment()[1];
		while(currentX>0 && currentY>0){
			diagonalVectors.add(new Vector(currentX -1, currentY-1));
			if(!board.getCell(currentX - 1,currentY - 1 ).isEmpty()){
				break;
			}
			currentX--;
			currentY--;
		}
		currentX = this.getEmplacment()[0];
		currentY = this.getEmplacment()[1];
		while(currentX < 8 && currentY>0){
			diagonalVectors.add(new Vector(currentX +1, currentY-1));
			if(!board.getCell(currentX +1,currentY-1 ).isEmpty()){
				break;
			}
			currentX++;
			currentY--;
		}
		currentX = this.getEmplacment()[0];
		currentY = this.getEmplacment()[1];
		while(currentX>0 && currentY<8){
			diagonalVectors.add(new Vector(currentX -1, currentY+1));
			if(!board.getCell(currentX -1,currentY+1 ).isEmpty()){
				break;
			}
			currentX--;
			currentY++;
		}
		return diagonalVectors;

	}

	public ArrayList<Vector> getVertical(){
		ArrayList<Vector> verticalVectors = new ArrayList<Vector>();
		int currentX = this.getEmplacment()[0];
		int currentY = this.getEmplacment()[1];
		while(currentX<8){
			verticalVectors.add(new Vector(currentX +1, currentY));
			if(!board.getCell(currentX+1,currentY).isEmpty()){
				break;
			}
			currentX++;
		}
		currentX = this.getEmplacment()[0];
		currentY = this.getEmplacment()[1];
		while(currentX > 0){
			verticalVectors.add(new Vector(currentX -1, currentY));
			if(!board.getCell(currentX-1,currentY).isEmpty()){
				break;
			}
			currentX--;
		}
		currentX = this.getEmplacment()[0];
		currentY = this.getEmplacment()[1];
		while(currentY>0){
			verticalVectors.add(new Vector(currentX, currentY-1));
			if(!board.getCell(currentX,currentY-1).isEmpty()){
				break;
			}
			currentY--;
		}
		currentX = this.getEmplacment()[0];
		currentY = this.getEmplacment()[1];
		while(currentY<8){
			verticalVectors.add(new Vector(currentX, currentY+1));
			if(!board.getCell(currentX,currentY+1).isEmpty()){
				break;
			}
			currentY++;
		}
		return verticalVectors;
	}
}
