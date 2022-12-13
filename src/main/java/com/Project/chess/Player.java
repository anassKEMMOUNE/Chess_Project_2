package com.Project.chess;

import javafx.scene.image.ImageView;

import java.util.ArrayList;


public class Player {
	public Clr color;
	public Board board;
	public String name;
	public int level;
	public boolean goesFirst;
	public boolean isTurn;
	public ArrayList<Piece> TakenPiece;
	public ArrayList<Pawn> PawnsArray = new ArrayList<>();
	public int click;
	
	public Player(boolean first,Board board) {
		this.click =0;
		this.name = null;
		this.board = board;
		goesFirst = first;
		if (goesFirst) {
			this.color = Clr.WHITE;
			this.isTurn = true;
		}
		else {
			this.color = Clr.BLACK;
			this.isTurn = false;
		}
		for (int i =0 ; i<8;i++){
			Pawn a = new Pawn(this);
			if (first){
				a.setCell(this.board.cells[i][6]);
			}
			else{
				a.setCell(this.board.cells[i][1]);
			}
			if (this.color == Clr.BLACK	){
				a.setImageBlack(new ImageView("C:\\Users\\anass\\OneDrive\\Bureau\\Studies - UM6P\\2nd year - CPI\\S3\\LBD3\\CHess test interface\\Chess_Project_2\\src\\main\\java\\com\\Project\\chess\\pawnWhite.png"));

			}
			else {
				a.setImageWhite(new ImageView("C:\\Users\\anass\\OneDrive\\Bureau\\Studies - UM6P\\2nd year - CPI\\S3\\LBD3\\CHess test interface\\Chess_Project_2\\src\\main\\java\\com\\Project\\chess\\pawnWhite.png"));

			}
			this.PawnsArray.add(a);
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
	public void moveAnass(int i){




		}


	}


