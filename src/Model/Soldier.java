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
if(checkSoldierDead(sourceX, sourceY, targetX, targetY, Board, Soldier_COLOR_AtSquare.BLACK) == 0) {
	return -1;
	
}
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
			System.out.println("error move black");
			return 1;
		}
			
	

	}


	//function that Moves a white piece in a specified direction
	public int moveWhite( int sourceX,int sourceY,int targetX,int targetY, Square[][] Board)
	{
		//check if its possible 
		if (checkSoldierDead(sourceX, sourceY, targetX, targetY, Board,Soldier_COLOR_AtSquare.WHITE) ==0) 
		{
			return -1;
		}
		
		if(sourceY==0 && targetY==1 && targetX==(sourceX-1) && Board[targetX][targetY].getSoldierColor() == Soldier_COLOR_AtSquare.EMPTY)
		{
			System.out.println("11");
			Board[sourceX][sourceY].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);
            Board[targetX][targetY].setSoldierColor(Soldier_COLOR_AtSquare.WHITE);
            this.getLocation().setX(targetX);
			this.getLocation().setY(targetY);
			return 0;
		}

	    if(sourceY==7 && targetY==6 && targetX==(sourceX-1) && Board[targetX][targetY].getSoldierColor() == Soldier_COLOR_AtSquare.EMPTY)
		{
			System.out.println("22");

			Board[sourceX][sourceY].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);
            Board[targetX][targetY].setSoldierColor(Soldier_COLOR_AtSquare.WHITE);
            this.getLocation().setX(targetX);
			this.getLocation().setY(targetY);
			return 0;
		}
		 if (sourceY+1==targetY && sourceX-1==targetX && Board[targetX][targetY].getSoldierColor() == Soldier_COLOR_AtSquare.EMPTY)
		{
				System.out.println("33");

			Board[sourceX][sourceY].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);
            Board[targetX][targetY].setSoldierColor(Soldier_COLOR_AtSquare.WHITE);
            this.getLocation().setX(targetX);
			this.getLocation().setY(targetY);
			return 0;
		}
		 if (sourceY-1==targetY && sourceX-1==targetX && Board[targetX][targetY].getSoldierColor() == Soldier_COLOR_AtSquare.EMPTY)
		{
				System.out.println("44");

			Board[sourceX][sourceY].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);
            Board[targetX][targetY].setSoldierColor(Soldier_COLOR_AtSquare.WHITE);
            this.getLocation().setX(targetX);
			this.getLocation().setY(targetY);
			return 0;
		}
		 else
		 {
			 System.out.println("error move white");
			 return 1;
		 }
			
			
		

		
		 
		
			
		
		

	}
	
	public int checkSoldierDead(int sourcex,int sourcey,int targetx,int targety,Square[][] Board, Soldier_COLOR_AtSquare color)
	{
		

          if(sourcex <6 && sourcey <6) {
			if(Board[sourcex+1][sourcey+1].getSoldierColor() == Soldier_COLOR_AtSquare.WHITE && targetx== sourcex+1 && targety==sourcey-1 && 
					Board[sourcex+2][sourcey+2].getSoldierColor() == Soldier_COLOR_AtSquare.EMPTY && color ==Soldier_COLOR_AtSquare.BLACK)
			{
				Board[sourcex][sourcey].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);
				this.setIsAlive(false);
				System.out.println("Black Soldier is dead!");
				this.getLocation().setX(-1);
				this.getLocation().setY(-1);
				return 0;

			}
          }
          
          if(sourcex <6 && sourcey >1) 
			{
			if(Board[sourcex+1][sourcey-1].getSoldierColor()== Soldier_COLOR_AtSquare.WHITE && targety== sourcey+1 && targetx==sourcey+1
					&& Board[sourcex+2][sourcey-2].getSoldierColor() == Soldier_COLOR_AtSquare.EMPTY && color ==Soldier_COLOR_AtSquare.BLACK )
			  {
				Board[sourcex][sourcey].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);
				this.setIsAlive(false);
				System.out.println("Black Soldier is dead!");
				this.Location.setX(-1);
				this.Location.setY(-1);
				return 0;
			  }
			}
          if(sourcex >1 && sourcey >1) {
  			if(Board[sourcex-1][sourcey-1].getSoldierColor()==Soldier_COLOR_AtSquare.BLACK && targetx== sourcex-1 && targety==sourcey+1 && 
  					Board[sourcex-2][sourcey-2].getSoldierColor() == Soldier_COLOR_AtSquare.EMPTY && color ==Soldier_COLOR_AtSquare.WHITE )
  			{
  				Board[sourcex][sourcey].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);
  				this.setIsAlive(false);
  				System.out.println("White Soldier1 is dead!");
  				this.getLocation().setX(-1);
  				this.getLocation().setY(-1);
  				return 0;

  			}
            }
          
      	if(sourcex >1 && sourcey <6) 
		{
		if((Board[sourcex-1][sourcey+1].getSoldierColor() == Soldier_COLOR_AtSquare.BLACK) && targetx== sourcex-1&& targety==sourcey-1&&
				Board[sourcex-2][sourcey+2].getSoldierColor() == Soldier_COLOR_AtSquare.EMPTY && color ==Soldier_COLOR_AtSquare.WHITE)
		{
			Board[sourcex][sourcey].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);
			this.setIsAlive(false);
			System.out.println("White Soldier2 is dead!");
			this.getLocation().setX(-1);
			this.getLocation().setY(-1);
			return 0;

		}
		}
          
		return -1;
	}

	// returns -1 if the queen is not dead an 0 if the queen dead
		//i and j the location that has chosen
		//color is the color of the queen .
		public int checkQueenDead(int sourcex,int sourcey,int targetx,int targety,Square[][] Board, Soldier_COLOR_AtSquare color)
		{

          if(sourcex >1 && sourcey >1) {
			if((Board[sourcex-1][sourcey-1].getSoldierColor() != color) && targetx!= sourcex-2 && targety!=sourcey-2 && 
					Board[sourcex-1][sourcey-1].getSoldierColor() != Soldier_COLOR_AtSquare.EMPTY && 
					Board[sourcex-2][sourcey-2].getSoldierColor() == Soldier_COLOR_AtSquare.EMPTY)
			{
				Board[sourcex][sourcey].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);
				this.setIsAlive(false);
				System.out.println("Queen is dead!");
				this.getLocation().setX(-1);
				this.getLocation().setY(-1);
				return 0;

			}
          }
			if(sourcex >1 && sourcey <6) 
			{
			if((Board[sourcex-1][sourcey+1].getSoldierColor() != color) && targetx!= sourcex-2 && targety!=sourcey+2&&
					Board[sourcex-1][sourcey+1].getSoldierColor() != Soldier_COLOR_AtSquare.EMPTY && 
					Board[sourcex-2][sourcey+2].getSoldierColor() == Soldier_COLOR_AtSquare.EMPTY)
			{
				Board[sourcex][sourcey].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);
				this.setIsAlive(false);
				System.out.println("Queen is dead!");
				this.getLocation().setX(-1);
				this.getLocation().setY(-1);
				return 0;

			}
			}
			if(sourcex <6 && sourcey <6) {
			if((Board[sourcex+1][sourcey+1].getSoldierColor() != color) && targetx!= sourcex+2 && targety!=sourcey+2&&
					Board[sourcex+1][sourcey+1].getSoldierColor() != Soldier_COLOR_AtSquare.EMPTY &&
					Board[sourcex+2][sourcey+2].getSoldierColor() == Soldier_COLOR_AtSquare.EMPTY)
			{
				Board[sourcex][sourcey].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);
				this.setIsAlive(false);
				System.out.println("Queen is dead!");
				this.getLocation().setX(-1);
				this.getLocation().setY(-1);
				return 0;

			}
			}
			if(sourcex <6 && sourcey >1) 
			{
			if((Board[sourcex+1][sourcey-1].getSoldierColor()!= color) && targety!= sourcey+2 && targetx!=sourcey-2
					&& Board[sourcex+1][sourcey-1].getSoldierColor() != Soldier_COLOR_AtSquare.EMPTY
					&& Board[sourcex+2][sourcey-2].getSoldierColor() == Soldier_COLOR_AtSquare.EMPTY)
			  {
				Board[sourcex][sourcey].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);
				this.setIsAlive(false);
				System.out.println("Queen is dead!");
				this.getLocation().setX(-1);
				this.getLocation().setY(-1);
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
				       else
				       {
				    	   tempx--;
					       tempy++; 
				       }
				    	i++;
				    	
				   System.out.println("up rigt");
				    System.out.println(tempx);
				    System.out.println(tempy);
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
				    	
				    }
				    tempx=sourcex;
				    tempy=sourcey;
				    i=0;
				    //left up
				    while((tempx != targetx && tempy != targety)  || i<8) {
				    	
				    	if(tempy==0) {
							tempy=7;
							tempx--;
						}else if(tempx==0) {
							tempy--;
							tempx=7;
						}
						else
						{
				    	tempx--;
				    	tempy--;
						}
				    	i++;
				    	System.out.println("up left");
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
						

					}
				    tempx=sourcex;
				    tempy=sourcey;
				    i=0;
				  //right down
				    while((tempx != targetx && tempy!= targety)  || i<8) {
				    	if(tempx==7) {
							tempy++;;
							tempx=0;
						}else if(tempy==7) {
							tempy=0;
							tempx++;
						}
						else
						{
				    	tempx++;
				    	tempy++;
						}
				    	i++;
				    	System.out.println("right down");
				    	System.out.println(tempx);
					    System.out.println(tempy);
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
						

					}
				    tempx=sourcex;
				    tempy=sourcey;
				    i=0;
					  //left down
				    while((tempx != targetx && tempy != targety) || i<8) {
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
						else
						{
				    	tempx++;
				    	tempy--;
						}
				    	i++;
				    	System.out.println("left down");
				    	System.out.println(tempx);
					    System.out.println(tempy);
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
						

					}
				    return 1;
				   
				

		}
			
			return -1;




	}
		
		public int QueenEat(Square[][] Board,int sourcex,int sourcey,int targetx,int targety, Soldier_COLOR_AtSquare color) {

			int tempx=sourcex,tempy=sourcey;
			
			//if the soldier is queen and the queen is not going to die
			if(isIsQueen()==true && checkQueenDead(sourcex,sourcey,targetx,targety, Board, color)==-1 )
			{
	               // the queen is going right up
				
					// case the queen arrived the edge of the board 
				   // up right
				    int i=0;
				    int flag=0;
				    while((tempx != targetx && tempy != targety) || i<8 )
				    {
				    	i++;
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
				       else {
				    	tempx--;
				    	tempy++;
				       }
				   // System.out.println(tempx);
				   // System.out.println(tempy);
				    	if((Board[tempx][tempy].getSoldierColor()== Soldier_COLOR_AtSquare.BLACK || Board[tempx][tempy].getSoldierColor()== Soldier_COLOR_AtSquare.WHITE)
				    		&& (tempx != targetx && tempy != targety) && (tempx != targetx+1 && tempy != targety-1)	)
				    	{
				    		flag=1;
				    	}
				    	if(tempx==targetx && tempy==targety && flag==0)
				    	{
				    		
							return 1;
				    	}
				    	
				    }
				    
				    
				    tempx=sourcex;
				    tempy=sourcey;
				    i=0;
				    flag=0;
				    //left up
				    while((tempx != targetx && tempy != targety)  || i<8) {
				    	if(tempy==0) {
							tempy=7;
							tempx--;
						}else if(tempx==0) {
							tempy--;
							tempx=7;
						} else
						{
				    	tempx--;
				    	tempy--;
						}
				    	i++;
				    	if((Board[tempx][tempy].getSoldierColor()== Soldier_COLOR_AtSquare.BLACK || Board[tempx][tempy].getSoldierColor()== Soldier_COLOR_AtSquare.WHITE)
					    		&& (tempx != targetx && tempy != targety) && (tempx != targetx+1 && tempy != targety+1)	)
					    	{
					    		flag=1;
					    	}
				    	System.out.println(tempx);
					    System.out.println(tempy);
				    	if(tempx==targetx && tempy==targety && flag==0)
				    	{
				    		
							return 2;
				    	}
				    	
						// case the queen arrived the edge of the board
						

					}
				    
				    tempx=sourcex;
				    tempy=sourcey;
				    i=0;
				    flag=0;
				  //right down
				    while((tempx != targetx && tempy!= targety)  || i<8) {
				    	if(tempx==7) {
							tempy++;;
							tempx=0;
						}else if(tempy==7) {
							tempy=0;
							tempx++;
						}
						else
							{tempx++;
				    	tempy++;
							}
				    	i++;
				    	if((Board[tempx][tempy].getSoldierColor()== Soldier_COLOR_AtSquare.BLACK || Board[tempx][tempy].getSoldierColor()== Soldier_COLOR_AtSquare.WHITE)
					    		&& (tempx != targetx && tempy != targety) && (tempx != targetx-1 && tempy != targety-1)	)
					    	{
					    		flag=1;
					    	}
				    	if(tempx==targetx && tempy==targety && flag==0)
				    	{
				    		
							return 3;
				    	}
				    	
						// case the queen arrived the edge of the board
						

					}
				    tempx=sourcex;
				    tempy=sourcey;
				    flag=0;
				    i=0;
					  //left down
				    while((tempx != targetx && tempy != targety) || i<8) {
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
						else
							{tempx++;
				           	tempy--;
							}
				    	i++;
				    	if((Board[tempx][tempy].getSoldierColor()== Soldier_COLOR_AtSquare.BLACK || Board[tempx][tempy].getSoldierColor()== Soldier_COLOR_AtSquare.WHITE)
					    		&& (tempx != targetx && tempy != targety)  && (tempx != targetx-1 && tempy != targety+1)	)
					    	{
					    		flag=1;
					    	}
				    	if(tempx==targetx && tempy==targety &&flag==0)
				    	{
				    		
							return 4;
				    	}
				    	
						// case the queen arrived the edge of the board
						

					}
				   
				

		}
			
			return -1;


	}
		

}