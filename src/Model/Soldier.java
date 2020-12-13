package Model;

import utils.Soldier_COLOR_AtSquare;


/*
 * @author Ethar Bakir
 */
public class Soldier {

	// -------------------------------Class Members------------------------------

	private boolean IsAlive;
	private boolean IsQueen;
	private Square Location;
	private Soldier_COLOR_AtSquare Color;

	// -------------------------------Constructors-------------------------------

	public Soldier(boolean isAlive, Square location, Soldier_COLOR_AtSquare color) {
		super();
		this.IsAlive = isAlive;
		this.IsQueen = false;
		this.Location = location;
		this.Color=color;
	}
	
	public Soldier( Square location, Soldier_COLOR_AtSquare color) {
		super();
		this.IsAlive = true;
		this.IsQueen = false;
		this.Location = location;
		this.Color=color;
	}

	// -------------------------------Getters And Setters-------------------------

	public Soldier_COLOR_AtSquare getColor() {
		return Color;
	}

	public void setColor(Soldier_COLOR_AtSquare color) {
		Color = color;
	}

	public boolean isIsAlive() {
		return IsAlive;
	}

	public void setIsAlive(boolean isAlive) {
		this.IsAlive = isAlive;
	}

	public boolean isIsQueen() {
		return IsQueen;
	}

	public void setIsQueen(boolean isQueen) {
		this.IsQueen = isQueen;
	}

	public Square getLocation() {
		return Location;
	}

	public void setLocation(Square location) {
		this.Location = location;
	}



	// -------------------------------Methods------------------------------------

	@Override
	public String toString() {
		return "Soldier [IsAlive=" + IsAlive + ", IsQueen=" + IsQueen + ", Location=" + Location + ", Color=" + Color
				+ "]";
	}

	
	//function that moves the black soldier
	public int moveBlack( int sourceX,int sourceY,int targetX,int targetY, Square[][] Board)
	{
		//check if its possible    

		if(sourceY==0 && targetY==1 && targetX==(sourceX+1) && Board[targetX][targetY].getSoldierColor() == Soldier_COLOR_AtSquare.EMPTY )
		{
			Board[sourceX][sourceY].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);
            Board[targetX][targetY].setSoldierColor(Soldier_COLOR_AtSquare.BLACK);
            this.getLocation().setX(targetX);
			this.getLocation().setY(targetY);
			return 0;
		}

		if(sourceY==7 && targetY==6 && targetX==(sourceX+1) && Board[targetX][targetY].getSoldierColor() == Soldier_COLOR_AtSquare.EMPTY )
		{
			Board[sourceX][sourceY].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);
            Board[targetX][targetY].setSoldierColor(Soldier_COLOR_AtSquare.BLACK);
            this.getLocation().setX(targetX);
			this.getLocation().setY(targetY);
			return 0;
		}
		if (sourceY+1==targetY && sourceX+1==targetX && Board[targetX][targetY].getSoldierColor() == Soldier_COLOR_AtSquare.EMPTY)
		{

			Board[sourceX][sourceY].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);
            Board[targetX][targetY].setSoldierColor(Soldier_COLOR_AtSquare.BLACK);
            this.getLocation().setX(targetX);
			this.getLocation().setY(targetY);
			return 0;
		}
		if (sourceY-1==targetY && sourceX+1==targetX && Board[targetX][targetY].getSoldierColor() == Soldier_COLOR_AtSquare.EMPTY)
		{

			Board[sourceX][sourceY].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);
            Board[targetX][targetY].setSoldierColor(Soldier_COLOR_AtSquare.BLACK);
            this.getLocation().setX(targetX);
			this.getLocation().setY(targetY);
			return 0;
		}
			
			
		 else 
		{
			System.out.println("Error: You have tried to move in an incorrect position.");
		}




		return -1;

	}


	//function that Moves a white piece in a specified direction
	public int moveWhite( int sourceX,int sourceY,int targetX,int targetY, Square[][] Board)
	{
		//check if its possible    

		if(sourceY==0 && targetY==1 && targetX==(sourceX-1) && Board[targetX][targetY].getSoldierColor() == Soldier_COLOR_AtSquare.EMPTY)
		{
			Board[sourceX][sourceY].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);
            Board[targetX][targetY].setSoldierColor(Soldier_COLOR_AtSquare.BLACK);
            this.getLocation().setX(targetX);
			this.getLocation().setY(targetY);
			return 0;
		}

		if(sourceY==7 && targetY==6 && targetX==(sourceX-1) && Board[targetX][targetY].getSoldierColor() == Soldier_COLOR_AtSquare.EMPTY)
		{
			Board[sourceX][sourceY].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);
            Board[targetX][targetY].setSoldierColor(Soldier_COLOR_AtSquare.BLACK);
            this.getLocation().setX(targetX);
			this.getLocation().setY(targetY);
			return 0;
		}
		if (sourceY+1==targetY && sourceX-1==targetX && Board[targetX][targetY].getSoldierColor() == Soldier_COLOR_AtSquare.EMPTY)
		{

			Board[sourceX][sourceY].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);
            Board[targetX][targetY].setSoldierColor(Soldier_COLOR_AtSquare.BLACK);
            this.getLocation().setX(targetX);
			this.getLocation().setY(targetY);
			return 0;
		}
		if (sourceY-1==targetY && sourceX-1==targetX && Board[targetX][targetY].getSoldierColor() == Soldier_COLOR_AtSquare.EMPTY)
		{

			Board[sourceX][sourceY].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);
            Board[targetX][targetY].setSoldierColor(Soldier_COLOR_AtSquare.BLACK);
            this.getLocation().setX(targetX);
			this.getLocation().setY(targetY);
			return 0;
		}
			
			
		 else 
		{
			System.out.println("Error: You have tried to move in an incorrect position.");
		}




		return -1;

	}

	// returns -1 if the queen is not dead an 0 if the queen dead
	//i and j the location that has choosen
	//color is the color of the queen .
	public int checkQueenDead(int i,int j,Square[][] Board, Soldier_COLOR_AtSquare color)
	{

		int x=this.Location.getX();
		int y=this.Location.getY();

		if((Board[x-1][y-1].getSoldierColor() != color) && i!= x-1 && j!=y-1)
		{
			Board[x-1][y-1].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);
			setIsAlive(false);
			System.out.println("Queen is dead!");
			return 0;

		}
		if((Board[x-1][y+1].getSoldierColor() != color) && i!= x-1 && j!=y+1)
		{
			Board[x-1][y+1].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);
			setIsAlive(false);
			System.out.println("Queen is dead!");
			return 0;

		}
		if((Board[x+1][y+1].getSoldierColor() != color) && i!= x+1 && j!=y+1)
		{
			Board[x+1][y+1].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);
			setIsAlive(false);
			System.out.println("Queen is dead!");
			return 0;

		}
		if((Board[x+1][y-1].getSoldierColor()!= color) && i!= x+1 && j!=y-1)
		{
			Board[x+1][y-1].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);
			setIsAlive(false);
			System.out.println("Queen is dead!");
			return 0;
		}
		else
			return -1;
	}
	//i and j the location that has chosen
	//color is the color of the queen its 1 if black and 2 if white.
	//this method  return -1 if not queen and move the queen and return 0 if queen and moved;

	public int QueenMove(Square[][] Board,String dir, Soldier_COLOR_AtSquare color) {

		int x= Location.getX();
		int y=Location.getY();
		int x2=x;
		int y2=y;
		//if the soldier is queen and the queen is not going to die
		if(isIsQueen()==true && checkQueenDead(x, y, Board, color)==-1 && color== Soldier_COLOR_AtSquare.WHITE)
		{

			if(dir == "rup"  )
			{
				// case the queen arrived the edge of the board 
				if(y==7 && x==0) {
					y=0;
					x=7;
				}
				else if(y==7 && x!=0) {
					y=0;
					x--;
				}
				else if(x==0) {
					x=7;
					y++;}

				else
					//in case its did not arrived the edge of the board
					x++;
				y--;



				Board[x2][y2].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);
				Board[x][y].setSoldierColor(Soldier_COLOR_AtSquare.WHITE);


				return 0;
			}



			// case the queen arrived the edge of the board
			if(dir=="lup" )
			{

				if(y==0) {
					y=7;
					x--;
				}else if(x==0) {
					y--;
					x=7;
				}
				else
					//in case its did not arrived the edge of the board
					x--;
				y--;
				Board[x2][y2].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);
				Board[x][y].setSoldierColor(Soldier_COLOR_AtSquare.WHITE);
				return 0;

			}
			// case the queen arrived the edge of the board
			if(dir=="rdown" )
			{

				if(x==7) {
					y++;
					x=0;
				}else if(y==7) {
					y=0;
					x++;
				}
				else
					//in case its did not arrived the edge of the board
					x++;
				y++;
				Board[x2][y2].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);
				Board[x][y].setSoldierColor(Soldier_COLOR_AtSquare.WHITE);
				return 0;


			}
			// case the queen arrived the edge of the board
			if(dir=="ldown")
			{

				if(x==7 && y==0) {
					y=7;
					x=0;
				}else if(x==7 && y!=0) {
					y--;
					x=0;
				}else if(y==0) {
					y=7;
					x++;
				}
				else //in case its did not arrived the edge of the board
					x++;
				y--;


				Board[x2][y2].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);
				Board[x][y].setSoldierColor(Soldier_COLOR_AtSquare.WHITE);
				return 0;

			}



		}

		if(isIsQueen()==true && checkQueenDead(x, y, Board, color)==-1 && color== Soldier_COLOR_AtSquare.BLACK)
		{

			// case the queen arrived the edge of the board 
			if(dir == "rup"  )
			{

				if(y==7 && x==0) {
					y=0;
					x=7;
				}
				else if(y==7 && x!=0) {
					y=0;
					x--;
				}
				else if(x==0) {
					x=7;
					y++;}
				else
					//in case its did not arrived the edge of the board
					x++;
				y--;


				Board[x2][y2].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);
				Board[x][y].setSoldierColor(Soldier_COLOR_AtSquare.BLACK);


				return 0;
			}



			// case the queen arrived the edge of the board
			if(dir=="lup" )
			{
				x2=x;
				y2=y;
				if(y==0) {
					y=7;
					x--;
				}else if(x==0) {
					y--;
					x=7;
				}
				else
					//in case its did not arrived the edge of the board
					x--;
				y--;
				Board[x2][y2].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);
				Board[x][y].setSoldierColor(Soldier_COLOR_AtSquare.BLACK);
				return 0;

			}
			// case the queen arrived the edge of the board
			if(dir=="rdown" )
			{

				if(x==7) {
					y++;
					x=0;
				}else if(y==7) {
					y=0;
					x++;
				}
				else
					//in case its did not arrived the edge of the board
					x++;
				y++;
				Board[x2][y2].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);
				Board[x][y].setSoldierColor(Soldier_COLOR_AtSquare.BLACK);
				return 0;


			}
			// case the queen arrived the edge of the board
			if(dir=="ldown")
			{

				if(x==7 && y==0) {
					y=7;
					x=0;
				}else if(x==7 && y!=0) {
					y--;
					x=0;
				}else if(y==0) {
					y=7;
					x++;
				}
				else //in case its did not arrived the edge of the board
					x++;
				y--;

				Board[x2][y2].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);
				Board[x][y].setSoldierColor(Soldier_COLOR_AtSquare.BLACK);
				return 0;

			}




		}
		return -1;



	}




}