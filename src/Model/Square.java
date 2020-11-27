package Model;

public class Square {
	
	// -------------------------------Class Members------------------------------

	private static int Number=0;
	private int X;
	private int Y;
	private boolean isIsOccupied;
	
	
	// -------------------------------Constructors-------------------------------

	public Square(int x, int y) {
		super();
		this.Number++;
		this.X = x;
		this.Y = y;
		this.isIsOccupied=false;
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
	
	

	public boolean isIsOccupied() {
		return isIsOccupied;
	}

	public void setIsOccupied(boolean isIsOccupied) {
		this.isIsOccupied = isIsOccupied;
	}

	@Override
	public String toString() {
		return "Square [Number=" + Number + ", X=" + X + ", Y=" + Y + "]";
	}


}
