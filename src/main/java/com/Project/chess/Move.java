package com.Project.chess;

public class Move {
	public Vector vector;
	public Piece piece;
	
	public Move(Vector vect, Piece p) {
		vector = vect;
		piece = p;
	}

	public Vector getVector() {
		return vector;
	}

	public void setVector(Vector vector) {
		this.vector = vector;
	}

	public Piece getPiece() {
		return piece;
	}

	public void setPiece(Piece piece) {
		this.piece = piece;
	}
	
}
