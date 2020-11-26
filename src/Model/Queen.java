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
	
	//חסר
	public int QueenMove(int x,int y,Square[][] Board,char dir) {
		
		
		if(dir=='r' & x==7)
		{
			
			Board[x][y].setNumber(0);
			Board[0][y].setNumber(3);
		}
		
		if(dir=='l' & x==0)
		{
			Board[x][y].setNumber(0);
			Board[7][y].setNumber(3);
		}
		
		return 0;
		
	}
	

}
