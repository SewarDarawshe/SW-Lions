package Model;

public class Square {
	
	// -------------------------------Class Members------------------------------

	private int Number;
	private int X;
	private int Y;
	
	
	// -------------------------------Constructors-------------------------------

	public Square(int number, int x, int y) {
		super();
		this.Number = number;
		this.X = x;
		this.Y = y;
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
	

	@Override
	public String toString() {
		return "Square [Number=" + Number + ", X=" + X + ", Y=" + Y + "]";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
