package com.Project.chess;

import javafx.scene.image.ImageView;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public abstract class Piece {
	public Cell cell;
	public Player player;
	public boolean isInGame;

	public ImageView imageWhite;
	public ImageView imageBlack;
	public String name;
	public boolean clicked;
	public Type type;
	public static int counter = 0;
	public boolean isTurn;
	public static String initialPath= Paths.get("").toAbsolutePath().toString().concat("\\src\\main\\java\\com\\Project\\chess\\images\\");
	public Piece( Player player){
		this.cell = null;
		this.player = player;
		this.name = "";
		//this.initialPath = "C:\\Users\\anass\\OneDrive\\Bureau\\Studies - UM6P\\2nd year - CPI\\S3\\LBD3\\CHess test interface\\Chess_Project_2\\src\\main\\java\\com\\Project\\chess\\images\\";
		this.isInGame = true;
		this.imageWhite = null;
		this.imageBlack = null;
		this.clicked = false;
		if(player.getColor()==Clr.WHITE){
			this.isTurn = true;
		}
		else{
			this.isTurn = false;
		}
	}
	public Cell[] calcCastling(Cell finalCell){
		Cell[] lis = new Cell[2];
		return lis;
	}
	public boolean ValidMove(Cell finalCell){
		return true;
	}
	
	public Cell getCell() {
		return cell;
	}

	public boolean getTurn(){
		return this.isTurn;
	}
	public void setTurn(boolean value){
		this.isTurn = value;
	}
	public void setCell(Cell cell) {
		this.cell = cell;

	}
	public boolean isFirstMove(){
		return false;
	}
	public Type getType(){
		return this.type;
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
	public boolean validCasting(Cell finalCell){
		return false;
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
	public void clickEvent(int a) {
		if(this.player.isTurn){
			colorAllValidMoves();
			this.calcMoves();
			if (!this.getClicked() ) {
				this.setClicked(true);
				ChessInterface.setSelected(a);
				ChessInterface.setSelectedPiece(this);
				ChessInterface.oldSelectedPieces.add(this);
				this.getCell().getTile().setStyle("-fx-background-color: rgba(63,128,63,0.18)");
			}
			for ( int i = 0 ; i< ChessInterface.oldSelectedPieces.size()-1;i++){
				ChessInterface.oldSelectedPieces.get(i).setClicked(false);
				if (ChessInterface.oldSelectedPieces.get(i).getCell().getColor() == Clr.WHITE){
					ChessInterface.oldSelectedPieces.get(i).getCell().getTile().setStyle("-fx-background-color: ".concat(Cell.whiteColor));
				}
				else {
					ChessInterface.oldSelectedPieces.get(i).getCell().getTile().setStyle("-fx-background-color: ".concat(Cell.blackColor));
				}
			}

			for ( int i = 0 ; i< ChessInterface.oldSelectedPaths.size()-1;i++){
				for (Cell j : ChessInterface.oldSelectedPaths.get(i)){
					if (!this.ValidMove(j)){
						if (j.getColor() == Clr.WHITE){
							j.getTile().setStyle("-fx-background-color: ".concat(Cell.whiteColor));
						}
						else {
							j.getTile().setStyle("-fx-background-color: ".concat(Cell.blackColor));
						}
					}
					}
			}



		}



	}
	public void attackPiece(Cell finalCell) {
	}
	public boolean makeMove(Cell finalCell) {
		return false;
	}
	public void calcMoves() {
	}
public void colorAllValidMoves(){
	ArrayList<Cell> path = new ArrayList<>();
	for (int i = 0; i < 8; i++) {
		for (int j= 0; j<8;j++){
			if (this.ValidMove(ChessInterface.board.getCell(i,j)) && this.type != Type.ROOK){
				ChessInterface.board.cells[i][j].getTile().setStyle("-fx-background-color: rgba(59,166,60,0.3)");
				path.add(ChessInterface.board.cells[i][j]);
			}

		}

	}
	System.out.println(this.name + " "+ path);
	ChessInterface.oldSelectedPaths.add(path);
}
}




	

