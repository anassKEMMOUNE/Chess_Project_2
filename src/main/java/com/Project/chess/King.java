package com.Project.chess;
import java.util.ArrayList;
import java.util.Arrays;
public class King extends Piece {
	
	
	
	final ArrayList<Vector> authorizedMoves = new ArrayList<Vector>(Arrays.asList(new Vector(1,0),new Vector(1,1), new Vector(0,1)));
	
	public King (Cell cell, Player player) {
		super(cell, player);
	}
	
	public boolean isValidPath(int finalX, int finalY) {
		return false;
	}
	
	@Override
	public void calcMoves() {
		
	}
	
	public boolean doCasting() {
		return false;
	}
	
	

}
