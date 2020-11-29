package Model;

import utils.E_COLOR;


/*
 * @author Maisa Mansour
 */
public class Square {

	// -------------------------------Class Members------------------------------


	private int X;
	private int Y;
	private E_COLOR Color;




	// -------------------------------Constructors-------------------------------

	public Square(int x, int y, E_COLOR color) {
		super();
		X = x;
		Y = y;
		Color = color;
	}

	// -------------------------------Getters And Setters-------------------------




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




	public Square(int x, int y) {
		super();
		X = x;
		Y = y;
	}

	public E_COLOR getColor() {
		return Color;
	}

	public void setColor(E_COLOR color) {
		Color = color;
	}

	@Override
	public String toString() {
		return "Square [X=" + X + ", Y=" + Y + ", Color=" + Color + "]";
	}

}