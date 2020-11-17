package Model;

public class Square {
	
	private int Number;
	private int X;
	private int Y;
	
	

	public Square(int number, int x, int y) {
		super();
		Number = number;
		X = x;
		Y = y;
	}

	public int getNumber() {
		return Number;
	}

	public void setNumber(int number) {
		Number = number;
	}


	public int getX() {
		return X;
	}


	public void setX(int x) {
		X = x;
	}


	public int getY() {
		return Y;
	}
	

	public void setY(int y) {
		Y = y;
	}
	

	@Override
	public String toString() {
		return "Square [Number=" + Number + ", X=" + X + ", Y=" + Y + "]";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
