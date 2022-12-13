package com.Project.chess;

import javafx.scene.image.ImageView;

public abstract class Piece {
	public Cell cell;
	public Player player;
	public boolean isInGame;

	public ImageView imageWhite;
	public ImageView imageBlack;
	public String name;
	public String initialPath;
	public boolean clicked;
	
	public Piece( Player player){
		this.cell = null;
		this.player = player;
		this.name = "";
		this.initialPath = "C:\\Users\\anass\\OneDrive\\Bureau\\Studies - UM6P\\2nd year - CPI\\S3\\LBD3\\CHess test interface\\Chess_Project_2\\src\\main\\java\\com\\Project\\chess\\";
		this.isInGame = true;
		this.imageWhite = null;
		this.imageBlack = null;
		this.clicked = false;
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

	public void setClicked(boolean clicked) {
		this.clicked = clicked;
	}
	public boolean getClicked(){
		return this.clicked;
	}
	public void attackPiece(Cell finalCell) {
	}
	public boolean makeMove(Cell finalCell) {
		return false;
	}
	public void calcMoves() {
	}

}




	

