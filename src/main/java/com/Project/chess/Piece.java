package com.Project.chess;

import javafx.scene.image.ImageView;

public abstract class Piece {
	public Cell cell;
	public Player player;
	public boolean isInGame;

	public ImageView imageWhite;
	public ImageView imageBlack;

	
	
	public Piece( Player player){
		this.cell = null;
		this.player = player;
		this.isInGame = true;
		this.imageWhite = null;
		this.imageBlack = null;
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
		return this.player.getColor();
	}

	public void setColor(Clr color) {
		this.player.setColor(color);
	}
	public ImageView getImageBlack(){
		return this.imageBlack;
	}
	public ImageView getImageWhite(){
		return this.imageWhite;
	}
	public ImageView getImage() {
		if (getColor() == Clr.BLACK){
			 return getImageBlack();}
		else {
			 return getImageWhite();

		}
	}

	public void setImageWhite(ImageView value) {
		this.imageWhite = value;
	}
	public void setImageBlack(ImageView value) {
		this.imageBlack = value;
	}
	public void getClickStatus(){
		System.out.println(this.getImage().getOnMouseClicked());
	}
	public void attackPiece(Cell finalCell) {
	}
	public boolean makeMove(Cell finalCell) {
		return false;
	}
	public void calcMoves() {
	}

}




	

