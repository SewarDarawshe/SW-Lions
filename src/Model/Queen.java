package Model;

public class Queen extends Soldier {
	
	private Soldier queen;
	
	// -------------------------------Constructors-------------------------------

	public Queen(boolean isAlive, boolean isQueen, Square location) {
		super(isAlive, isQueen, location);
		// TODO Auto-generated constructor stub
	}
	
	
	
	// -------------------------------Getters And Setters-------------------------

	public Soldier getQueen() {
		return queen;
	}

	public void setQueen(Soldier queen) {
		this.queen = queen;
	}

	@Override
	public String toString() {
		return "Queen []";
	}
	
	// -------------------------------Methods------------------------------------
	
	//To Do
	public void main() {
		
	}
	

}
