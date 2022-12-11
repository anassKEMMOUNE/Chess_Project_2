package com.Project.chess;

public class Cell {
	public Piece piece;
	public int[] emplacment;
	public Clr color;
	
	public Cell(int coordX, int coordY, Clr color) {
		piece = null;
		emplacment[0] = coordX;
		emplacment[1] = coordY;
		this.color = color;
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
	
	
	public boolean isEmpty(){
		if(this.getPiece() == null) {
			return true;
		}
		else
			return false;
		
	}
	
	public Piece replacePiece(Piece other) {
		Piece old = this.getPiece();
		this.setPiece(other);
		old.setInGame(false);
		return old;
	}
	
	

}
