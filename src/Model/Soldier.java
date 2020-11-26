package Model;

public class Soldier {
	
	// -------------------------------Class Members------------------------------

	private boolean IsAlive;
	private boolean IsQueen;
	private Square Location;
	
	// -------------------------------Constructors-------------------------------

	public Soldier(boolean isAlive, boolean isQueen, Square location) {
		super();
		this.IsAlive = isAlive;
		this.IsQueen = isQueen;
		this.Location = location;
	}
	
	// -------------------------------Getters And Setters-------------------------

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

	@Override
	public String toString() {
		return "Soldier [IsAlive=" + IsAlive + ", IsQueen=" + IsQueen + ", Location=" + Location + "]";
	}
	
	// -------------------------------Methods------------------------------------

	//function that check if the player can move his soldier or not.
	public boolean legalMove(int x, int y, char direction, char colour)
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

            boolean checkMove = legalMove(x,y,direction,'b');


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

            boolean checkMove = legalMove(x,y,direction,'w');


            if (checkMove==true)
            {
                if (direction=='l')
                {
                    int xDirection=x;
                    Board[x][y].setNumber(0);
                    xDirection--;
                    Board[xDirection][y+1].setNumber(2);

                }


                if (direction=='r')
                {
                    int xDirection=x;
                    Board[x][y].setNumber(0);
                    xDirection++;
                    Board[xDirection][y+1].setNumber(2); //issue on line
                }
            } else 
            {
                System.out.println("Error: You have tried to move in an incorrect position.");
            }

	  	

	  	return 0;

	}

	

}
