package Model;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

import Model.Player;
import utils.E_COLOR;
import utils.E_Difficulty;


public class Game {
	

	
	private Square[][] Board=new Square[8][8];
	private Date GameDate;
	private Player whitePlayer;
	private Player blackPlayer;
	private Time QueueTime;	
	private Soldier[] WhitePieces=new Soldier[12];
	private Soldier[] BlackPieces=new Soldier[12];
	private Square[] BlackSquares=new Square[32];
	
	

//---------------------------Constructor----------------------
	
	
	public Game(Square[][] board,Player white,Player black, Date gamedate, Time queueTime, Soldier[] soldier1, Soldier[] soldier2, Square[] blackSquares) {
		super();
		Board = board;
		GameDate = gamedate;
		QueueTime = queueTime;
		WhitePieces = soldier1;
		BlackPieces = soldier2;
		BlackSquares = blackSquares;
		whitePlayer=white;
		blackPlayer=black;
	}
	//---------------Getters and Setters--------------------------
	
	public Square[][] getBoard() {
		return Board;
	}
	public void setBoard(Square[][] board) {
		Board = board;
	}
	
	
	public Date getGameTime() {
		return GameDate;
	}
	public void setGameTime(Time gameTime) {
		GameDate = gameTime;
	}
	
	public Game(Date gameDate, Player whitePlayer, Player blackPlayer) {
		super();
		GameDate = gameDate;
		this.whitePlayer = whitePlayer;
		this.blackPlayer = blackPlayer;
	}
	public Player getWhitePlayer() {
		return whitePlayer;
	}

	public void setWhitePlayer(Player whitePlayer) {
		this.whitePlayer = whitePlayer;
	}

	public Player getBlackPlayer() {
		return blackPlayer;
	}

	public void setBlackPlayer(Player blackPlayer) {
		this.blackPlayer = blackPlayer;
	}

	public Soldier[] getWhitePieces() {
		return WhitePieces;
	}

	public void setWhitePieces(Soldier[] whitePieces) {
		WhitePieces = whitePieces;
	}

	public Soldier[] getBlackPieces() {
		return BlackPieces;
	}

	public void setBlackPieces(Soldier[] blackPieces) {
		BlackPieces = blackPieces;
	}

	public Time getQueueTime() {
		return QueueTime;
	}
	public void setQueueTime(Time queueTime) {
		QueueTime = queueTime;
	}
	public Soldier[] getSoldier1() {
		return WhitePieces;
	}
	
	public void setSoldier1(Soldier[] soldier1) {
		WhitePieces = soldier1;
	}
	public Soldier[] getSoldier2() {
		return BlackPieces;
	}
	public void setSoldier2(Soldier[] soldier2) {
		BlackPieces = soldier2;
	}
	public Square[] getBlackSquares() {
		return BlackSquares;
	}
	public void setBlackSquares(Square[] blackSquares) {
		BlackSquares = blackSquares;
	}
	
//---------------------Methods------------------------------
	
	public void initiateGame()
	{
		//To do
		for(int count=32;count>0;count --)
		{
			for(int row=0;row<8;row++)
			{
				if(row%2!=0) 
				for(int col=0;col<8;col++)
				{
					Board[row][col]=new Square(row, col);
				}
				else
				{
					for(int col=1;col<8;col++)
					{
						Board[row][col]=new Square(row, col);
					}
				}
			}
		}
		{
		Board[0][1].setColor(E_COLOR.BLACK);;Board[0][3].setColor(E_COLOR.BLACK);Board[0][5].setColor(E_COLOR.BLACK);Board[0][7].setColor(E_COLOR.BLACK);
		Board[1][0].setColor(E_COLOR.BLACK);Board[1][2].setColor(E_COLOR.BLACK);Board[1][4].setColor(E_COLOR.BLACK);Board[1][6].setColor(E_COLOR.BLACK);
		Board[2][1].setColor(E_COLOR.BLACK);Board[2][3].setColor(E_COLOR.BLACK);Board[2][5].setColor(E_COLOR.BLACK);Board[2][7].setColor(E_COLOR.BLACK);

		Board[7][0].setColor(E_COLOR.WHITE);Board[7][2].setColor(E_COLOR.WHITE);Board[7][4].setColor(E_COLOR.WHITE);Board[7][6].setColor(E_COLOR.WHITE);
		Board[6][1].setColor(E_COLOR.WHITE);Board[6][3].setColor(E_COLOR.WHITE);Board[6][5].setColor(E_COLOR.WHITE);Board[6][7].setColor(E_COLOR.WHITE);
		Board[5][0].setColor(E_COLOR.WHITE);Board[5][2].setColor(E_COLOR.WHITE);Board[5][4].setColor(E_COLOR.WHITE);Board[5][5].setColor(E_COLOR.WHITE);
		for(int i=0;i<WhitePieces.length;i++)
		{
			for(int row=5;row<8;row++)
			{
				if(row%2!=0) {
				for(int j=0;j<8;j+=2)
				{
					Soldier s=new Soldier(true,Board[row][j], E_COLOR.WHITE);

					WhitePieces[i]=s;		
				}
				}
				else {
					for(int j=1;j<8;j+=2)
					{
						Soldier s=new Soldier(true,Board[row][j], E_COLOR.WHITE);

						WhitePieces[i]=s;		
					}
					
				}
			}
		}

		for(int i=0;i<BlackPieces.length;i++)
		{
			for(int row=0;row<3;row++)
			{
				if(row%2!=0) {
				for(int j=0;j<8;j+=2)
				{
					Soldier s=new Soldier(true,Board[row][j], E_COLOR.BLACK);

					BlackPieces[i]=s;		
				}
				}
				else {
					for(int j=1;j<8;j+=2)
					{
						Soldier s=new Soldier(true,Board[row][j], E_COLOR.BLACK);

						BlackPieces[i]=s;		
					}
					
				}
			}			

		}

		whitePlayer.setPoints(0);
		blackPlayer.setPoints(0);
		}


	}

	
	public void AddPlayer(String wp,String bp)
	{
		 this.whitePlayer = new Player(wp,0);
		 this. blackPlayer = new Player(bp,0);


	}
	
	public void StartGame()
	{
		//To do
		
	}
	
	public void FinishGame(Player p1,Player p2)
	{
		//To do
		
	}
	
	public void PauseGame()
	{
		//To do
		
		
	}
	
	public void resumeGame()
	{
		//To do
		
		

	}
	
	public void returnSoldier(Player p)
	{
	}
	
	public void removeSoldier(Soldier[] s, int index)
	{
	if(s==null)
		return;
	s[index]=null;
	return;
	}
	
	public void soldierTurnToQueen(Soldier s)
	{
		s.setIsQueen(true);
	}
	
	
	public boolean IsEatable(Player p)
	{
		if(p.getColor()==E_COLOR.WHITE) {
			
			for(int i=0;i<WhitePieces.length; i++) {
				int x=WhitePieces[i].getLocation().getX();
				int y=WhitePieces[i].getLocation().getY();
				if(WhitePieces[i].isIsQueen()==false)
				{
					
					if(y==0||y==1) {
						if((Board[x-1][y+1].getColor())==(E_COLOR.BLACK) && Board[x-2][y+2].getColor()==null) {
							
							return true;
						}
							
					}
					if(y==6||y==7) {
						if((Board[x-1][y-1].getColor())==(E_COLOR.BLACK) && Board[x-2][y-2].getColor()==null) {
							
							return true;
						}
							
					}
					else {
						if(((Board[x-1][y+1].getColor())==(E_COLOR.BLACK) && Board[x-2][y+2].getColor()==null)|| ((Board[x-1][y-1].getColor())==(E_COLOR.BLACK) && Board[x-2][y-2].getColor()==null)) {
							return true;
						}
					}
				}
				else if(WhitePieces[i].isIsQueen()==true) {
					//case the queen is moving up right
					while(Board[x-1][y+1].getColor()==null) {
						x--;
						y++;
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
							y++;
						}
					}
					if(Board[x][y].getColor()==E_COLOR.BLACK && Board[x-1][y+1].getColor()==null)
						return true;
					//case the queen is moving up left
					while(Board[x-1][y-1].getColor()==null) {
						x--;
						y--;
						// case the queen arrived the edge of the board
						if(y==0) {
							y=7;
							x--;
						}else if(x==0) {
							y--;
							x=7;
						}
			
					}
					if(Board[x][y].getColor()==E_COLOR.BLACK && Board[x-1][y-1].getColor()==null)
						return true;
					//case the queen is moving right down
					while(Board[x+1][y+1].getColor()==null) {
						x++;
						y++;
						
						// case the queen arrived the edge of the board
						if(x==7) {
							y++;
							x=0;
						}else if(y==7) {
							y=0;
							x++;
						}
					}
					if(Board[x][y].getColor()==E_COLOR.BLACK && Board[x+1][y+1].getColor()==null)
						return true;
					//case the queen is moving left down
					while(Board[x+1][y-1].getColor()==null) {
						x++;
						y--;
						
						// case the queen arrived the edge of the board
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
					}
					if(Board[x][y].getColor()==E_COLOR.BLACK && Board[x+1][y-1].getColor()==null)
						return true;
				}
				
			}
			
		}
		if(p.getColor()==E_COLOR.BLACK) {
			
			for(int i=0;i<BlackPieces.length; i++) {
				int x=BlackPieces[i].getLocation().getX();
				int y=BlackPieces[i].getLocation().getY();
				if(BlackPieces[i].isIsQueen()==false)
				{
					
					if(y==0||y==1) {
						if((Board[x+1][y+1].getColor())==(E_COLOR.WHITE) && Board[x+2][y+2].getColor()==null) {
							
							return true;
						}
							
					}
					if(y==6||y==7) {
						if((Board[x+1][y-1].getColor())==(E_COLOR.WHITE) && Board[x+2][y-2].getColor()==null) {
							
							return true;
						}
							
					}
					else {
						if(((Board[x+1][y-1].getColor())==(E_COLOR.WHITE) && Board[x+2][y-2].getColor()==null)|| ((Board[x+1][y+1].getColor())==(E_COLOR.WHITE) && Board[x+2][y+2].getColor()==null)) {
							return true;
						}
					}
				}
				
				else if(BlackPieces[i].isIsQueen()==true) {
					//case the queen is moving up right
					while(Board[x-1][y+1].getColor()==null) {
						x--;
						y++;
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
							y++;
						}
					}
					if(Board[x][y].getColor()==E_COLOR.WHITE && Board[x-1][y+1].getColor()==null)
						return true;
					//case the queen is moving up left
					while(Board[x-1][y-1].getColor()==null) {
						x--;
						y--;
						// case the queen arrived the edge of the board
						if(y==0) {
							y=7;
							x--;
						}else if(x==0) {
							y--;
							x=7;
						}
			
					}
					if(Board[x][y].getColor()==E_COLOR.WHITE && Board[x-1][y-1].getColor()==null)
						return true;
					//case the queen is moving right down
					while(Board[x+1][y+1].getColor()==null) {
						x++;
						y++;
						
						// case the queen arrived the edge of the board
						if(x==7) {
							y++;
							x=0;
						}else if(y==7) {
							y=0;
							x++;
						}
					}
					if(Board[x][y].getColor()==E_COLOR.WHITE && Board[x+1][y+1].getColor()==null)
						return true;
					//case the queen is moving left down
					while(Board[x+1][y-1].getColor()==null) {
						x++;
						y--;
						
						// case the queen arrived the edge of the board
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
					}
					if(Board[x][y].getColor()==E_COLOR.WHITE && Board[x+1][y-1].getColor()==null)
						return true;
					
				}
				
			}
			
		}
		return false;
	}
	
	// this function return true if all the reval solider is blocked
	// Player p is the rival player
	// Queen not chekied
		public boolean IsBlocked(Player p)
		{
			int countBlockedSoldier=0;
			int countSolidersinGame=0;
			int x=0;
			int y=0;
			
			if(p.equals(blackPlayer)) {
				for(int i=0;i<BlackPieces.length;i++) {
					if(BlackPieces[i]!=null)
						countSolidersinGame++;
						}
			
					for(int i=0;i<BlackPieces.length;i++) {
						if(BlackPieces[i]!=null)
						{
						x=BlackPieces[i].getLocation().getX();
						y=BlackPieces[i].getLocation().getY();
						
						if(x==0 && y==7) {
							if(Board[x+1][y-1].isIsOccupied()==true)
								countBlockedSoldier++;
							}
						else if(x==7 && y==0) {
							if(Board[x-1][y+1].isIsOccupied()==true)
								countBlockedSoldier++;
							}
						else if(y==0) {
							//Checking if the soldiers of the first column is blocked  from two directions UP and DOWN
							if(Board[x-1][y+1].isIsOccupied()==true && Board[x+1][y+1].isIsOccupied()==true)
								countBlockedSoldier++;
							}
						else if(y==7) {
							//Checking if the soldiers of the last column is blocked  from two directions UP and DOWN
							if(Board[x-1][y-1].isIsOccupied()==true && Board[x+1][y-1].isIsOccupied()==true)
								countBlockedSoldier++;
							}
						else {
							if(Board[x-1][y-1].isIsOccupied()==true && Board[x+1][y-1].isIsOccupied()==true 
							&& Board[x-1][y+1].isIsOccupied()==true &&Board[x+1][y+1].isIsOccupied()==true)
								countBlockedSoldier++;
							}
						
					}
				}
				
			}
			if(p.equals(whitePlayer)) {
				for(int i=0;i<WhitePieces.length;i++) {
					if(WhitePieces[i]!=null)
						countSolidersinGame++;
						}
			
					for(int i=0;i<WhitePieces.length;i++) {
						if(WhitePieces[i]!=null)
						{
						x=WhitePieces[i].getLocation().getX();
						y=WhitePieces[i].getLocation().getY();
						
						if(x==0 && y==7) {
							if(Board[x+1][y-1].isIsOccupied()==true)
								countBlockedSoldier++;
							}
						else if(x==7 && y==0) {
							if(Board[x-1][y+1].isIsOccupied()==true)
								countBlockedSoldier++;
							}
						else if(y==0) {
							//Checking if the soldiers of the first column is blocked  from two directions UP and DOWN
							if(Board[x-1][y+1].isIsOccupied()==true && Board[x+1][y+1].isIsOccupied()==true)
								countBlockedSoldier++;
							}
						else if(y==7) {
							//Checking if the soldiers of the last column is blocked  from two directions UP and DOWN
							if(Board[x-1][y-1].isIsOccupied()==true && Board[x+1][y-1].isIsOccupied()==true)
								countBlockedSoldier++;
							}
						else {
							if(Board[x-1][y-1].isIsOccupied()==true && Board[x+1][y-1].isIsOccupied()==true 
							&& Board[x-1][y+1].isIsOccupied()==true &&Board[x+1][y+1].isIsOccupied()==true)
								countBlockedSoldier++;
							}
						
					}
				}
				
			}
	    if(countBlockedSoldier==countSolidersinGame)
	    	return true;
	    return false;
		}
			
	@Override
	public String toString() {
		return "Game [GameDate=" + GameDate + ", whitePlayer=" + whitePlayer + ", blackPlayer=" + blackPlayer + "]";
	}
	
	/**
	 * @return gets status of the timer
	 */
	
	/**
	 * cancels the timer tasks
	 */
	

}