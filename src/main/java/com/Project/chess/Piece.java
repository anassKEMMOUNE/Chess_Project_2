package com.Project.chess;

public abstract class Piece {
	public Cell cell;
	public Player player;
	public boolean isInGame;
	public Clr color;
	
	
	public Piece(Cell cell, Player player){
		this.cell = cell;
		this.player = player;
		this.isInGame = true;
		this.color = player.getColor();
	}
	
	public Cell getCell() {
		return cell;
	}


	public void setCell(Cell cell) {
		this.cell = cell;
	}


	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public boolean getInGame() {
		return isInGame;
	}

	public void setInGame(boolean isInGame) {
		this.isInGame = isInGame;
	}

	public Clr getColor() {
		return color;
	}

	public void setColor(Clr color) {
		this.color = color;
	}
	
	public void attackPiece(Cell finalCell) {
	}
	public boolean makeMove(Cell finalCell) {
		return false;
	}
	public void calcMoves() {
	}

}




	

