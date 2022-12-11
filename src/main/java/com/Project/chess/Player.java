package com.Project.chess;

import java.util.ArrayList;

public class Player {
	public Clr color;
	public String name;
	public int level;
	public boolean goesFirst;
	public boolean isTurn;
	public ArrayList<Piece> TakenPiece;
	
	public Player(String name, boolean first) {
		this.name = name;
		goesFirst = first;
		if (goesFirst) {
			this.color = Clr.WHITE;
			this.isTurn = true;
		}
		else {
			this.color = Clr.BLACK;
			this.isTurn = false;
		}
	}

	public Clr getColor() {
		return color;
	}

	public void setColor(Clr color) {
		this.color = color;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public boolean isGoesFirst() {
		return goesFirst;
	}

	public void setGoesFirst(boolean goesFirst) {
		this.goesFirst = goesFirst;
	}

	public boolean isTurn() {
		return isTurn;
	}

	public void setTurn(boolean isTurn) {
		this.isTurn = isTurn;
	}

	public ArrayList<Piece> getTakenPiece() {
		return TakenPiece;
	}

	public void setTakenPiece(ArrayList<Piece> takenPiece) {
		TakenPiece = takenPiece;
	}

}
