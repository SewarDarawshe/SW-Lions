package Model;

import utils.Soldier_COLOR;

public class Soldier {
	
	// -------------------------------Class Members------------------------------

	private boolean IsAlive;
	private boolean IsQueen;
	private Square Location;
	private Soldier_COLOR Color;
	
	// -------------------------------Constructors-------------------------------

	public Soldier(boolean isAlive, Square location, Soldier_COLOR color) {
		super();
		this.IsAlive = isAlive;
		this.IsQueen = false;
		this.Location = location;
		this.Color=color;
	}
	
	// -------------------------------Getters And Setters-------------------------

	public Soldier_COLOR getColor() {
		return Color;
	}

	public void setColor(Soldier_COLOR color) {
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
	public boolean legalMove(int x, int y, char direction)
    {
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
	public int moveBlack(int x, int y, char direction, Square[][] Board)
	{
            //check if its possible    

            // x,y,left

            boolean checkMove = legalMove(x,y,direction);


            if (checkMove==true)
            {
                if (direction=='l')
                {
                    int xDirection=x;
                    Board[x][y].setNumber(0);
                    xDirection--;
                    Board[xDirection][y-1].setNumber(1);
                }


                if (direction=='r')
                {
                    int xDirection=x;
                    Board[x][y].setNumber(0);
                    xDirection++;
                    Board[xDirection][y-1].setNumber(1);   //issue on line
                }
            } else 
            {
                System.out.println("Error: You have tried to move in an incorrect position.");
            }


	  	

	  	return 0;

	}

	
	//function that Moves a white piece in a specified direction
	public int moveWhite(int x, int y, char direction,Square[][] Board)
	{

            boolean checkMove = legalMove(x,y,direction);


            if (checkMove==true)
            {
                if (direction=='l')
                {
                    int xDirection=x;
                    Board[x][y].setNumber(0);
                    xDirection--;
                    Board[xDirection][y+1].setNumber(2);
                    return 0;

                }


                if (direction=='r')
                {
                    int xDirection=x;
                    Board[x][y].setNumber(0);
                    xDirection++;
                    Board[xDirection][y+1].setNumber(2); //issue on line
                    return 0;
                }
            } else 
            {
                System.out.println("Error: You have tried to move in an incorrect position.");
                return -1;
            }

	  	

	  	return -1;

	}
	
	// returns -1 if the solder is not a queen 
public int QueenMove(int x,int y,Square[][] Board,char dir) {
		if(isIsQueen()==true)
		{
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
		else return -1;
	
		
}
	

	

}
