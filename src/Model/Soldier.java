package Model;

import utils.E_COLOR;


/*
 * @author Ethar Bakir
 */
public class Soldier {

	// -------------------------------Class Members------------------------------

	private boolean IsAlive;
	private boolean IsQueen;
	private Square Location;
	private E_COLOR Color;

	// -------------------------------Constructors-------------------------------

	public Soldier(boolean isAlive, Square location, E_COLOR color) {
		super();
		this.IsAlive = isAlive;
		this.IsQueen = false;
		this.Location = location;
		this.Color=color;
	}

	// -------------------------------Getters And Setters-------------------------

	public E_COLOR getColor() {
		return Color;
	}

	public void setColor(E_COLOR color) {
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

	//function that check if the player can move his soldier or not.
	public boolean legalMove(char direction)
	{
		int x=Location.getX();

		if (direction == 'l') {
			if(x==0) {
				return false;
			}


		}

		if (direction == 'r') {
			if(x==7) {
				return false;
			}          
		}

		return true;
	}
	//function that moves the black soldier
	public int moveBlack( char direction, Square[][] Board)
	{
		//check if its possible    

		// x,y,left
		int x=Location.getX();
		int y=Location.getY();
		boolean checkMove = legalMove(direction);


		if (checkMove==true)
		{
			if (direction=='l')
			{
				int xDirection=x;
				Board[x][y].setColor(E_COLOR.EMPTY);
				xDirection++;
				this.getLocation().setX(xDirection);
				this.getLocation().setY(this.getLocation().getY()-1);
				Board[xDirection][y-1].setColor(E_COLOR.BLACK);

			}


			if (direction=='r')
			{
				int xDirection=x;
				Board[x][y].setColor(E_COLOR.EMPTY);
				xDirection++;
				
			this.getLocation().setX(xDirection);
			this.getLocation().setY(this.getLocation().getY()+1);

				Board[this.getLocation().getX()][this.getLocation().getY()].setColor(E_COLOR.BLACK); 
				
			}
		} else 
		{
			System.out.println("Error: You have tried to move in an incorrect position.");
		}




		return 0;

	}


	//function that Moves a white piece in a specified direction
	public int moveWhite( char direction,Square[][] Board)
	{
		int x=Location.getX();
		int y=Location.getY();
		boolean checkMove = legalMove(direction);


		if (checkMove==true)
		{
			if (direction=='l')
			{
				int xDirection=x;
				Board[x][y].setColor(E_COLOR.EMPTY);
				xDirection--;
				this.getLocation().setX(xDirection);
				this.getLocation().setY(this.getLocation().getY()-1);
				Board[xDirection][y-1].setColor(E_COLOR.WHITE);
				return 0;

			}


			if (direction=='r')
			{
				int xDirection=x;
				Board[x][y].setColor(E_COLOR.EMPTY);
				xDirection--;
				this.getLocation().setX(xDirection);
				this.getLocation().setY(this.getLocation().getY()+1);
				Board[xDirection][y+1].setColor(E_COLOR.WHITE); //issue on line
				return 0;
			}
		} else 
		{
			System.out.println("Error: You have tried to move in an incorrect position.");
			return -1;
		}



		return -1;

	}

	// returns -1 if the queen is not dead an 0 if the queen dead
	//i and j the location that has choosen
	//color is the color of the queen .
	public int checkQueenDead(int i,int j,Square[][] Board, E_COLOR color)
	{

		int x=this.Location.getX();
		int y=this.Location.getY();

		if((Board[x-1][y-1].getColor() != color) && i!= x-1 && j!=y-1)
		{
			Board[x-1][y-1].setColor(E_COLOR.EMPTY);
			setIsAlive(false);
			System.out.println("Queen is dead!");
			return 0;

		}
		if((Board[x-1][y+1].getColor() != color) && i!= x-1 && j!=y+1)
		{
			Board[x-1][y+1].setColor(E_COLOR.EMPTY);
			setIsAlive(false);
			System.out.println("Queen is dead!");
			return 0;

		}
		if((Board[x+1][y+1].getColor() != color) && i!= x+1 && j!=y+1)
		{
			Board[x+1][y+1].setColor(E_COLOR.EMPTY);
			setIsAlive(false);
			System.out.println("Queen is dead!");
			return 0;

		}
		if((Board[x+1][y-1].getColor()!= color) && i!= x+1 && j!=y-1)
		{
			Board[x+1][y-1].setColor(E_COLOR.EMPTY);
			setIsAlive(false);
			System.out.println("Queen is dead!");
			return 0;
		}
		else
			return -1;
	}
	//i and j the location that has choosen
	//color is the color of the queen its 1 if black and 2 if white.
	//this method  return -1 if not queen and move the queen and return 0 if queen and moved;

	public int QueenMove(Square[][] Board,String dir, E_COLOR color) {

		int x= Location.getX();
		int y=Location.getY();
		int x2=x;
		int y2=y;
		//if the soldier is queen and the queen is not going to die
		if(isIsQueen()==true && checkQueenDead(x, y, Board, color)==-1 && color== E_COLOR.WHITE)
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



				Board[x2][y2].setColor(E_COLOR.EMPTY);
				Board[x][y].setColor(E_COLOR.WHITE);


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
				Board[x2][y2].setColor(E_COLOR.EMPTY);
				Board[x][y].setColor(E_COLOR.WHITE);
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
				Board[x2][y2].setColor(E_COLOR.EMPTY);
				Board[x][y].setColor(E_COLOR.WHITE);
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


				Board[x2][y2].setColor(E_COLOR.EMPTY);
				Board[x][y].setColor(E_COLOR.WHITE);
				return 0;

			}



		}

		if(isIsQueen()==true && checkQueenDead(x, y, Board, color)==-1 && color== E_COLOR.BLACK)
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


				Board[x2][y2].setColor(E_COLOR.EMPTY);
				Board[x][y].setColor(E_COLOR.BLACK);


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
				Board[x2][y2].setColor(E_COLOR.EMPTY);
				Board[x][y].setColor(E_COLOR.BLACK);
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
				Board[x2][y2].setColor(E_COLOR.EMPTY);
				Board[x][y].setColor(E_COLOR.BLACK);
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

				Board[x2][y2].setColor(E_COLOR.EMPTY);
				Board[x][y].setColor(E_COLOR.BLACK);
				return 0;

			}




		}
		return -1;



	}




}