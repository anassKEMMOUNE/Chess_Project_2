package com.Project.chess;

import java.util.ArrayList;

public class Rook extends Piece {
	public ArrayList<Vector> authorizedMoves = new ArrayList<Vector>();
	
	public Rook(Cell cell, Player player) {
		super(cell, player);
	}
	
	public boolean isValidPath(int finalX, int finalY) {
		return false;
	}
	
	@Override
	public void calcMoves() {
		
	}

}
