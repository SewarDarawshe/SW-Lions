package Model;

import utils.SQUARE_COLOR;
import utils.Soldier_COLOR_AtSquare;


/*
 * @author Maisa Mansour
 */
public class Square {

	// -------------------------------Class Members------------------------------


	private int X;
	private int Y;
	private Soldier_COLOR_AtSquare SoldierColor;
	private Soldier s;
	private SQUARE_COLOR squareColor;




	// -------------------------------Constructors-------------------------------

	public Square(int x, int y, Soldier_COLOR_AtSquare soldierColor, Soldier s) {
		super();
		X = x;
		Y = y;
		SoldierColor = soldierColor;
		this.s = s;
		this.squareColor= SQUARE_COLOR.BLACK;
	}



	// -------------------------------Getters And Setters-------------------------




	public int getX() {
		return X;
	}


	public Soldier getS() {
		return s;
	}

	public void setS(Soldier s) {
		this.s = s;
	}

	public void setX(int x) {
		this.X = x;
	}


	public int getY() {
		return Y;
	}


	public void setY(int y) {
		this.Y = y;
	}




	public Square(int x, int y) {
		super();
		X = x;
		Y = y;
	}

	public Soldier_COLOR_AtSquare getSoldierColor() {
		return SoldierColor;
	}

	public void setSoldierColor(Soldier_COLOR_AtSquare color) {
		SoldierColor = color;
	}

	
	
	public SQUARE_COLOR getSquareColor() {
		return squareColor;
	}

	public void setSquareColor(SQUARE_COLOR squareColor) {
		this.squareColor = squareColor;
	}

	@Override
	public String toString() {
		return "Square [X=" + X + ", Y=" + Y + ", SoldierColor=" + SoldierColor + "]";
	}

}

