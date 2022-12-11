package com.Project.chess;

import java.util.ArrayList;
import java.util.Arrays;
public class Knight extends Piece {
	final ArrayList<Vector> authorizedMoves = new ArrayList<Vector>(Arrays.asList(new Vector(1,2), new Vector(2,1), new Vector(1,-2), new Vector(2,-1)));
	
	public Knight(Cell cell, Player player) {
		super(cell, player);
	}
	
	public boolean isValidPath(int finalX, int finalY) {
		return false;
	}
	
	@Override
	public void calcMoves() {
	}
}
