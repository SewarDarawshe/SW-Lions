package Model;

import utils.Soldier_COLOR;

public class Square {
	
	// -------------------------------Class Members------------------------------

	private static int Number=0;
	private int X;
	private int Y;
	private Soldier_COLOR Color;// this color is the color of the soldier that stand at this square
	
	
	// -------------------------------Constructors-------------------------------

	public Square(int x, int y, Soldier_COLOR Color) {
		super();
		this.Number++;
		this.X = x;
		this.Y = y;
		this.Color=Color;
	}

	// -------------------------------Getters And Setters-------------------------

	public int getNumber() {
		return Number;
	}

	public void setNumber(int number) {
		this.Number = number;
	}


	public int getX() {
		return X;
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

	public Soldier_COLOR getColor() {
		return Color;
	}

	public void setColor(Soldier_COLOR color) {
		Color = color;
	}

	
	@Override
	public String toString() {
		return "Square [X=" + X + ", Y=" + Y + ", Color=" + Color + "]";
	}

	


}
