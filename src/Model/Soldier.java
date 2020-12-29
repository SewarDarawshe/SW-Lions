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
            Board[targetX][targetY].setSoldierColor(Soldier_COLOR_AtSquare.WHITE);
            this.getLocation().setX(targetX);
			this.getLocation().setY(targetY);
			return 0;
		}

		if(sourceY==7 && targetY==6 && targetX==(sourceX-1) && Board[targetX][targetY].getSoldierColor() == Soldier_COLOR_AtSquare.EMPTY)
		{
			Board[sourceX][sourceY].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);
            Board[targetX][targetY].setSoldierColor(Soldier_COLOR_AtSquare.WHITE);
            this.getLocation().setX(targetX);
			this.getLocation().setY(targetY);
			return 0;
		}
		if (sourceY+1==targetY && sourceX-1==targetX && Board[targetX][targetY].getSoldierColor() == Soldier_COLOR_AtSquare.EMPTY)
		{

			Board[sourceX][sourceY].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);
            Board[targetX][targetY].setSoldierColor(Soldier_COLOR_AtSquare.WHITE);
            this.getLocation().setX(targetX);
			this.getLocation().setY(targetY);
			return 0;
		}
		if (sourceY-1==targetY && sourceX-1==targetX && Board[targetX][targetY].getSoldierColor() == Soldier_COLOR_AtSquare.EMPTY)
		{

			Board[sourceX][sourceY].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);
            Board[targetX][targetY].setSoldierColor(Soldier_COLOR_AtSquare.WHITE);
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
		//i and j the location that has chosen
		//color is the color of the queen .
		public int checkQueenDead(int sourcex,int sourcey,int targetx,int targety,Square[][] Board, Soldier_COLOR_AtSquare color)
		{

          if(sourcex !=0 && sourcey !=0) {
			if((Board[sourcex-1][sourcey-1].getSoldierColor() != color) && targetx!= sourcex-1 && targety!=sourcey-1 && 
					Board[sourcex-1][sourcey-1].getSoldierColor() != Soldier_COLOR_AtSquare.EMPTY && sourcex !=0 && sourcey !=0 )
			{
				Board[sourcex][sourcey].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);
				setIsAlive(false);
				System.out.println("Queen is dead!");
				return 0;

			}
          }
			if(sourcex !=0 && sourcey !=0) 
			{
			if((Board[sourcex-1][sourcey+1].getSoldierColor() != color) && targetx!= sourcex-1 && targety!=sourcey-1&&
					Board[sourcex-1][sourcey+1].getSoldierColor() != Soldier_COLOR_AtSquare.EMPTY && sourcex !=0 && sourcey !=0)
			{
				Board[sourcex][sourcey].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);
				setIsAlive(false);
				System.out.println("Queen is dead!");
				return 0;

			}
			}
			if(sourcex !=7 && sourcey !=7) {
			if((Board[sourcex+1][sourcey+1].getSoldierColor() != color) && targetx!= sourcex+1 && targety!=sourcey+1&&
					Board[sourcex+1][sourcey+1].getSoldierColor() != Soldier_COLOR_AtSquare.EMPTY )
			{
				Board[sourcex][sourcey].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);
				setIsAlive(false);
				System.out.println("Queen is dead!");
				return 0;

			}
			}
			if(sourcex !=7 && sourcey !=7) 
			{
			if((Board[sourcex+1][sourcey-1].getSoldierColor()!= color) && sourcex!= sourcey+1 && sourcex!=sourcey-1
					&& Board[sourcex+1][sourcey-1].getSoldierColor() != Soldier_COLOR_AtSquare.EMPTY )
			  {
				Board[sourcex][sourcey].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);
				setIsAlive(false);
				System.out.println("Queen is dead!");
				return 0;
			  }
			}
			
			
				return -1;
		}
		//i and j the location that has chosen
		//color is the color of the queen its 1 if black and 2 if white.
		//this method  return -1 if not queen and move the queen and return 0 if queen and moved;

		public int QueenMove(Square[][] Board,int sourcex,int sourcey,int targetx,int targety, Soldier_COLOR_AtSquare color) {

			int tempx=sourcex,tempy=sourcey;
			
			//if the soldier is queen and the queen is not going to die
			if(isIsQueen()==true && checkQueenDead(sourcex,sourcey,targetx,targety, Board, color)==-1 )
			{
	               // the queen is going right up
				
					// case the queen arrived the edge of the board 
				   // up right
				    int i=0;
				    while((tempx != targetx && tempy != targety) || i<8 )
				    {
				    	i++;
				    	tempx--;
				    	tempy++;
				   
				   // System.out.println(tempx);
				   // System.out.println(tempy);
				    	if(tempx==targetx && tempy==targety)
				    	{
				    		Board[sourcex][sourcey].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);
							if(color==Soldier_COLOR_AtSquare.WHITE)
							{
				            Board[targetx][targety].setSoldierColor(Soldier_COLOR_AtSquare.WHITE);
							}
							if(color==Soldier_COLOR_AtSquare.BLACK)
							{
				            Board[targetx][targety].setSoldierColor(Soldier_COLOR_AtSquare.BLACK);
							}
				            this.getLocation().setX(targetx);
							this.getLocation().setY(targety);
							return 0;
				    	}
				    	if(tempy==7 && tempx==0) {
				    		tempy=0;
							tempx=7;
						}
				    	else
				    		if(tempy==7 && tempx!=0) {
				    			tempy=0;
				    			tempx--;
				    		}
				       else if(tempx==0) {
				    	   tempx=7;
				    	   tempy++;
							}
				    }
				    tempx=sourcex;
				    tempy=sourcey;
				    i=0;
				    //left up
				    while((tempx != targetx && tempy != targety)  || i<8) {
				    	tempx--;
				    	tempy--;
				    	i++;
				    	System.out.println(tempx);
					    System.out.println(tempy);
				    	if(tempx==targetx && tempy==targety)
				    	{
				    		System.out.println("heloooooooooo");
				    		Board[sourcex][sourcey].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);
							if(color==Soldier_COLOR_AtSquare.WHITE)
							{
				            Board[targetx][targety].setSoldierColor(Soldier_COLOR_AtSquare.WHITE);
							}
							if(color==Soldier_COLOR_AtSquare.BLACK)
							{
				            Board[targetx][targety].setSoldierColor(Soldier_COLOR_AtSquare.BLACK);
							}
				            this.getLocation().setX(targetx);
							this.getLocation().setY(targety);
							return 0;
				    	}
				    	
						// case the queen arrived the edge of the board
						if(tempy==0) {
							tempy=7;
							tempx--;
						}else if(tempx==0) {
							tempy--;
							tempx=7;
						}

					}
				    tempx=sourcex;
				    tempy=sourcey;
				    i=0;
				  //right down
				    while((tempx != targetx && tempy!= targety)  || i<8) {
				    	tempx++;
				    	tempy++;
				    	i++;
				    	if(tempx==targetx && tempy==targety)
				    	{
				    		Board[sourcex][sourcey].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);
							if(color==Soldier_COLOR_AtSquare.WHITE)
							{
				            Board[targetx][targety].setSoldierColor(Soldier_COLOR_AtSquare.WHITE);
							}
							if(color==Soldier_COLOR_AtSquare.BLACK)
							{
				            Board[targetx][targety].setSoldierColor(Soldier_COLOR_AtSquare.BLACK);
							}
				            this.getLocation().setX(targetx);
							this.getLocation().setY(targety);
							return 0;
				    	}
				    	
						// case the queen arrived the edge of the board
						if(tempx==7) {
							tempy++;;
							tempx=0;
						}else if(tempy==7) {
							tempy=0;
							tempx++;
						}

					}
				    tempx=sourcex;
				    tempy=sourcey;
				    i=0;
					  //right down
				    while((tempx <= targetx && tempy>= targety) || i<8) {
				    	tempx++;
				    	tempy--;
				    	i++;
				    	if(tempx==targetx && tempy==targety)
				    	{
				    		Board[sourcex][sourcey].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);
							if(color==Soldier_COLOR_AtSquare.WHITE)
							{
				            Board[targetx][targety].setSoldierColor(Soldier_COLOR_AtSquare.WHITE);
							}
							if(color==Soldier_COLOR_AtSquare.BLACK)
							{
				            Board[targetx][targety].setSoldierColor(Soldier_COLOR_AtSquare.BLACK);
							}
				            this.getLocation().setX(targetx);
							this.getLocation().setY(targety);
							return 0;
				    	}
				    	
						// case the queen arrived the edge of the board
						if(tempx==7 && tempy==0) {
							tempy=7;;
							tempx=0;
						}else if(tempx==7 && tempy!=0) {
							tempy--;
							tempx=0;
						}
						else if(tempy==0) {
							tempy=7;
							tempx++;
						}

					}
				   
				

		}
			
			return -1;




	}
		


}