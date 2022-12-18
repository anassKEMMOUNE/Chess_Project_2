package com.Project.chess;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Vector {
	public int directionX;
	public int directionY;
	
	public Vector(int directionX, int directionY) {
		this.directionX = directionX;
		this.directionY = directionY;
	}

	public int getDirectionX() {
		return directionX;
	}

	public void setDirectionX(int directionX) {
		this.directionX = directionX;
	}

	public int getDirectionY() {
		return directionY;
	}

	public void setDirectionY(int directionY) {
		this.directionY = directionY;
	}

	public boolean isIn(ArrayList<Vector> list){
		for (Vector vector : list){
			if(vector.getDirectionY() == this.getDirectionY() && vector.getDirectionX()==this.getDirectionX()){
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString(){
		return "x : " + this.getDirectionX() + " y : " + this.getDirectionY();
	}
	
	
}
