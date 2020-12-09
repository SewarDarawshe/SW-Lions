package Model;

import java.sql.Time;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import Model.Player;
import utils.E_COLOR;
import utils.E_Difficulty;

/**
 *  * Game class -not responsible of game conrollers

 * 
 * @author Maisa Mansour
 * @author Ethar Bakir
 * @author Alaa Khawaled
 * 
 * 
 */
public class Game {

	// -------------------------------Class Members------------------------------

	private Square[][] Board=new Square[8][8];
	private Date GameDate;
	private Player whitePlayer;
	private Player blackPlayer;
	private Time QueueTime;	
	private Soldier[] WhitePieces=new Soldier[12];
	private Soldier[] BlackPieces=new Soldier[12];



	//---------------------------Constructor----------------------


	public Game(Square[][] board,Player white,Player black, Date gamedate, Time queueTime, Soldier[] soldier1, Soldier[] soldier2) {
		super();
		Board = board;
		GameDate = gamedate;
		QueueTime = queueTime;
		WhitePieces = soldier1;
		BlackPieces = soldier2;
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


	//---------------------Methods------------------------------

	/*
	 * in this method we build the game board with the squares
	 *  and arrange the black\white soldiers .
	 *  -loading the game board
	 */
	public void initiateGame()
	{

		for(int count=32;count>0;count --) //build the 32 black squares that we're going to use
		{
			for(int row=0;row<8;row++)
			{
				if(row%2!=0) 
					for(int col=0;col<8;col++)
					{
						Board[row][col]=new Square(row, col,E_COLOR.EMPTY);
					}
				else
				{
					for(int col=1;col<8;col++)
					{
						Board[row][col]=new Square(row, col,E_COLOR.EMPTY);
					}
				}
			}
		}
		{
			// we arrange the basic soldiers to there places 12 black 12 white

			Board[0][1].setColor(E_COLOR.BLACK);;Board[0][3].setColor(E_COLOR.BLACK);Board[0][5].setColor(E_COLOR.BLACK);Board[0][7].setColor(E_COLOR.BLACK);
			Board[1][0].setColor(E_COLOR.BLACK);Board[1][2].setColor(E_COLOR.BLACK);Board[1][4].setColor(E_COLOR.BLACK);Board[1][6].setColor(E_COLOR.BLACK);
			Board[2][1].setColor(E_COLOR.BLACK);Board[2][3].setColor(E_COLOR.BLACK);Board[2][5].setColor(E_COLOR.BLACK);Board[2][7].setColor(E_COLOR.BLACK);

			Board[7][0].setColor(E_COLOR.WHITE);Board[7][2].setColor(E_COLOR.WHITE);Board[7][4].setColor(E_COLOR.WHITE);Board[7][6].setColor(E_COLOR.WHITE);
			Board[6][1].setColor(E_COLOR.WHITE);Board[6][3].setColor(E_COLOR.WHITE);Board[6][5].setColor(E_COLOR.WHITE);Board[6][7].setColor(E_COLOR.WHITE);
			Board[5][0].setColor(E_COLOR.WHITE);Board[5][2].setColor(E_COLOR.WHITE);Board[5][4].setColor(E_COLOR.WHITE);Board[5][5].setColor(E_COLOR.WHITE);
			int whitei=0;
			if(whitei<WhitePieces.length)
			{
				for(int row=5;row<8;row++)
				{
					if(row%2!=0) {
						for(int j=0;j<8;j+=2)
						{
							Soldier s=new Soldier(true,Board[row][j], E_COLOR.WHITE);
							WhitePieces[whitei]=s;
							whitei++;

						}
					}
					else {
						for(int j=1;j<8;j+=2)
						{
							Soldier s=new Soldier(true,Board[row][j], E_COLOR.WHITE);

							WhitePieces[whitei]=s;	
							whitei++;
						}

					}
				}
			}
			int Blacki=0;
			if(Blacki<BlackPieces.length)
			{

				for(int row=0;row<3;row++)
				{
					if(row%2!=0) {
						for(int j=0;j<8;j+=2)
						{
							Soldier s=new Soldier(true,Board[row][j], E_COLOR.BLACK);

							BlackPieces[Blacki]=s;	
							Blacki++;
						}
					}
					else {
						for(int j=1;j<8;j+=2)
						{
							Soldier s=new Soldier(true,Board[row][j], E_COLOR.BLACK);

							BlackPieces[Blacki]=s;	
							Blacki++;
						}

					}
				}			

			}
			// setting the points to 0 
			whitePlayer.setPoints(0);
			blackPlayer.setPoints(0);
			
		}


	}


	public boolean AddPlayer(String wp,String bp)
	{
		this.whitePlayer = new Player(wp,0);
		this. blackPlayer = new Player(bp,0);
		return true;


	}


	public boolean returnSoldier(Soldier s)
	{
		if(!s.isIsAlive())
		{
			int x;//row number
			int y;//col number

			Scanner sc = new Scanner(System.in);
			System.out.println("Enter your row number that you want to return the soldier in: "); 
			x = sc.nextInt();
			System.out.println("Enter your column number that you want to return the soldier in: "); 
			y = sc.nextInt();
			//If soldier is White soldier
			if(s.getColor()==E_COLOR.WHITE) {
				if(x==0)
					return false;
				else if(x==1 && y==0) {
					if(Board[x-1][y+1].getColor()==E_COLOR.BLACK || Board[x][y+2].getColor()==E_COLOR.BLACK || Board[x+1][y+1].getColor()==E_COLOR.BLACK || Board[x+2][y+2].getColor()==E_COLOR.BLACK || Board[x+2][y].getColor()==E_COLOR.BLACK )
						return false;

				}
				else if(x==3 && y==0) {
					if(Board[x-2][y].getColor()==E_COLOR.BLACK || Board[x-1][y+1].getColor()==E_COLOR.BLACK|| Board[x-2][y+2].getColor()==E_COLOR.BLACK|| Board[x][y+2].getColor()==E_COLOR.BLACK||Board[x+1][y+1].getColor()==E_COLOR.BLACK||Board[x+2][y+2].getColor()==E_COLOR.BLACK|| Board[x+2][y].getColor()==E_COLOR.BLACK)
						return false;
				}
				else if(x==7 && y==0) {
					if(Board[x-2][y].getColor()==E_COLOR.BLACK || Board[x-1][y+1].getColor()==E_COLOR.BLACK|| Board[x-2][y+2].getColor()==E_COLOR.BLACK|| Board[x][y+2].getColor()==E_COLOR.BLACK)
						return false;
				}

				else if(x==3 && y==0) {
					if(Board[x-2][y].getColor()==E_COLOR.BLACK || Board[x-1][y+1].getColor()==E_COLOR.BLACK|| Board[x-2][y+2].getColor()==E_COLOR.BLACK|| Board[x][y+2].getColor()==E_COLOR.BLACK||Board[x+1][y+1].getColor()==E_COLOR.BLACK||Board[x+2][y+2].getColor()==E_COLOR.BLACK|| Board[x+2][y].getColor()==E_COLOR.BLACK)
						return false;
				}
				else if(x==7 && y==4) {
					if(Board[x][y-2].getColor()==E_COLOR.BLACK || Board[x-1][y-1].getColor()==E_COLOR.BLACK|| Board[x-2][y-2].getColor()==E_COLOR.BLACK|| Board[x-2][y].getColor()==E_COLOR.BLACK||Board[x-1][y+1].getColor()==E_COLOR.BLACK||Board[x-2][y+2].getColor()==E_COLOR.BLACK|| Board[x][y+2].getColor()==E_COLOR.BLACK)
						return false;
				}
				else if(x==7 && y==6) {
					if(Board[x][y-2].getColor()==E_COLOR.BLACK || Board[x-1][y-1].getColor()==E_COLOR.BLACK|| Board[x-2][y-2].getColor()==E_COLOR.BLACK|| Board[x-2][y].getColor()==E_COLOR.BLACK||Board[x-1][y+1].getColor()==E_COLOR.BLACK)
						return false;
				}
				else if(x==6 && y==7) {
					if(Board[x+1][y-1].getColor()==E_COLOR.BLACK || Board[x][y-2].getColor()==E_COLOR.BLACK|| Board[x-1][y-1].getColor()==E_COLOR.BLACK|| Board[x-2][y-2].getColor()==E_COLOR.BLACK||Board[x-2][y].getColor()==E_COLOR.BLACK)
						return false;
				}
				else if(x==4 && y==7) {
					if(Board[x+2][y].getColor()==E_COLOR.BLACK || Board[x+1][y-1].getColor()==E_COLOR.BLACK|| Board[x+2][y-2].getColor()==E_COLOR.BLACK|| Board[x-1][y-1].getColor()==E_COLOR.BLACK||Board[x-2][y-2].getColor()==E_COLOR.BLACK||Board[x-2][y].getColor()==E_COLOR.BLACK)
						return false;
				}
				else if(x==6 && y==5) {
					if(Board[x-2][y].getColor()==E_COLOR.BLACK || Board[x-1][y+1].getColor()==E_COLOR.BLACK|| Board[x-2][y+2].getColor()==E_COLOR.BLACK|| Board[x][y+2].getColor()==E_COLOR.BLACK||Board[x+1][y+1].getColor()==E_COLOR.BLACK||Board[x+1][y-1].getColor()==E_COLOR.BLACK||Board[x][y-2].getColor()==E_COLOR.BLACK||Board[x-1][y-1].getColor()==E_COLOR.BLACK||Board[x-2][y-2].getColor()==E_COLOR.BLACK)
						return false;
				}
				else if(x==6 && y==1) {//10 
					if(Board[x-2][y].getColor()==E_COLOR.BLACK || Board[x-1][y+1].getColor()==E_COLOR.BLACK|| Board[x-2][y+2].getColor()==E_COLOR.BLACK|| Board[x][y+2].getColor()==E_COLOR.BLACK||Board[x+1][y+1].getColor()==E_COLOR.BLACK||Board[x+1][y-1].getColor()==E_COLOR.BLACK||Board[x-1][y-1].getColor()==E_COLOR.BLACK)
						return false;
				}
				else if(x==1 && y==6) {//11 
					if(Board[x-1][y+1].getColor()==E_COLOR.BLACK || Board[x+1][y+1].getColor()==E_COLOR.BLACK|| Board[x+2][y].getColor()==E_COLOR.BLACK|| Board[x+1][y-1].getColor()==E_COLOR.BLACK||Board[x+2][y-2].getColor()==E_COLOR.BLACK||Board[x][y-2].getColor()==E_COLOR.BLACK||Board[x-1][y-1].getColor()==E_COLOR.BLACK)
						return false;
				}

				else if(x==1 && y==2) {//12 
					if(Board[x-1][y+1].getColor()==E_COLOR.BLACK || Board[x][y+2].getColor()==E_COLOR.BLACK|| Board[x+1][y+1].getColor()==E_COLOR.BLACK|| Board[x+2][y+2].getColor()==E_COLOR.BLACK||Board[x+2][y].getColor()==E_COLOR.BLACK||Board[x+1][y-1].getColor()==E_COLOR.BLACK||Board[x+2][y-2].getColor()==E_COLOR.BLACK||Board[x][y-2].getColor()==E_COLOR.BLACK||Board[x-1][y-1].getColor()==E_COLOR.BLACK)
						return false;
				}

				else{
					if(Board[x-2][y].getColor()==E_COLOR.BLACK || Board[x-1][y+1].getColor()==E_COLOR.BLACK|| Board[x-2][y+2].getColor()==E_COLOR.BLACK|| Board[x][y+2].getColor()==E_COLOR.BLACK||Board[x+1][y+1].getColor()==E_COLOR.BLACK||Board[x+2][y+2].getColor()==E_COLOR.BLACK|| Board[x+2][y].getColor()==E_COLOR.BLACK||Board[x+1][y-1].getColor()==E_COLOR.BLACK||Board[x+2][y-2].getColor()==E_COLOR.BLACK||Board[x][y-2].getColor()==E_COLOR.BLACK||Board[x-1][y-1].getColor()==E_COLOR.BLACK||Board[x-2][y-2].getColor()==E_COLOR.BLACK)
						return false;
				}
				//set the soldier in the location given
				Board[x][y].setColor(E_COLOR.WHITE);
				return true;
			}
			//If soldier is Black 
			if(s.getColor()==E_COLOR.BLACK) {
				if(x==7)
					return false;
				else if(x==1 && y==0) {
					if(Board[x-1][y+1].getColor()==E_COLOR.WHITE || Board[x][y+2].getColor()==E_COLOR.WHITE || Board[x+1][y+1].getColor()==E_COLOR.WHITE || Board[x+2][y+2].getColor()==E_COLOR.WHITE || Board[x+2][y].getColor()==E_COLOR.WHITE )
						return false;

				}
				else if(x==3 && y==0) {
					if(Board[x-2][y].getColor()==E_COLOR.WHITE || Board[x-1][y+1].getColor()==E_COLOR.WHITE|| Board[x-2][y+2].getColor()==E_COLOR.WHITE|| Board[x][y+2].getColor()==E_COLOR.WHITE||Board[x+1][y+1].getColor()==E_COLOR.WHITE||Board[x+2][y+2].getColor()==E_COLOR.WHITE|| Board[x+2][y].getColor()==E_COLOR.WHITE)
						return false;
				}

				else if(x==3 && y==0) {
					if(Board[x-2][y].getColor()==E_COLOR.WHITE || Board[x-1][y+1].getColor()==E_COLOR.WHITE|| Board[x-2][y+2].getColor()==E_COLOR.WHITE|| Board[x][y+2].getColor()==E_COLOR.WHITE||Board[x+1][y+1].getColor()==E_COLOR.WHITE||Board[x+2][y+2].getColor()==E_COLOR.WHITE|| Board[x+2][y].getColor()==E_COLOR.WHITE)
						return false;
				}

				else if(x==6 && y==7) {
					if(Board[x+1][y-1].getColor()==E_COLOR.WHITE || Board[x][y-2].getColor()==E_COLOR.WHITE|| Board[x-1][y-1].getColor()==E_COLOR.WHITE|| Board[x-2][y-2].getColor()==E_COLOR.WHITE||Board[x-2][y].getColor()==E_COLOR.WHITE)
						return false;
				}
				else if(x==4 && y==7) {
					if(Board[x+2][y].getColor()==E_COLOR.WHITE || Board[x+1][y-1].getColor()==E_COLOR.WHITE|| Board[x+2][y-2].getColor()==E_COLOR.WHITE|| Board[x-1][y-1].getColor()==E_COLOR.WHITE||Board[x-2][y-2].getColor()==E_COLOR.WHITE||Board[x-2][y].getColor()==E_COLOR.WHITE)
						return false;
				}
				else if(x==6 && y==5) {
					if(Board[x-2][y].getColor()==E_COLOR.WHITE || Board[x-1][y+1].getColor()==E_COLOR.WHITE|| Board[x-2][y+2].getColor()==E_COLOR.WHITE|| Board[x][y+2].getColor()==E_COLOR.WHITE||Board[x+1][y+1].getColor()==E_COLOR.WHITE||Board[x+1][y-1].getColor()==E_COLOR.WHITE||Board[x][y-2].getColor()==E_COLOR.WHITE||Board[x-1][y-1].getColor()==E_COLOR.WHITE||Board[x-2][y-2].getColor()==E_COLOR.WHITE)
						return false;
				}
				else if(x==6 && y==1) { 
					if(Board[x-2][y].getColor()==E_COLOR.WHITE || Board[x-1][y+1].getColor()==E_COLOR.WHITE|| Board[x-2][y+2].getColor()==E_COLOR.WHITE|| Board[x][y+2].getColor()==E_COLOR.WHITE||Board[x+1][y+1].getColor()==E_COLOR.WHITE||Board[x+1][y-1].getColor()==E_COLOR.WHITE||Board[x-1][y-1].getColor()==E_COLOR.WHITE)
						return false;
				}
				else if(x==1 && y==6) { 
					if(Board[x-1][y+1].getColor()==E_COLOR.WHITE || Board[x+1][y+1].getColor()==E_COLOR.WHITE|| Board[x+2][y].getColor()==E_COLOR.WHITE|| Board[x+1][y-1].getColor()==E_COLOR.WHITE||Board[x+2][y-2].getColor()==E_COLOR.WHITE||Board[x][y-2].getColor()==E_COLOR.WHITE||Board[x-1][y-1].getColor()==E_COLOR.WHITE)
						return false;
				}

				else if(x==1 && y==2) {
					if(Board[x-1][y+1].getColor()==E_COLOR.WHITE || Board[x][y+2].getColor()==E_COLOR.WHITE|| Board[x+1][y+1].getColor()==E_COLOR.WHITE|| Board[x+2][y+2].getColor()==E_COLOR.WHITE||Board[x+2][y].getColor()==E_COLOR.WHITE||Board[x+1][y-1].getColor()==E_COLOR.WHITE||Board[x+2][y-2].getColor()==E_COLOR.WHITE||Board[x][y-2].getColor()==E_COLOR.WHITE||Board[x-1][y-1].getColor()==E_COLOR.WHITE)
						return false;
				}
				else if(x==0 && y==1) {
					if(Board[x+1][y-1].getColor()==E_COLOR.WHITE || Board[x+2][y].getColor()==E_COLOR.WHITE|| Board[x+1][y+1].getColor()==E_COLOR.WHITE|| Board[x+2][y+2].getColor()==E_COLOR.WHITE||Board[x][y+2].getColor()==E_COLOR.WHITE)
						return false;
				}
				else if(x==0 && y==3) { 
					if(Board[x][y-2].getColor()==E_COLOR.WHITE || Board[x+1][y-1].getColor()==E_COLOR.WHITE|| Board[x+2][y-2].getColor()==E_COLOR.WHITE|| Board[x+2][y].getColor()==E_COLOR.WHITE||Board[x+1][y+1].getColor()==E_COLOR.WHITE||Board[x+2][y+2].getColor()==E_COLOR.WHITE ||Board[x][y+2].getColor()==E_COLOR.WHITE)
						return false;
				}
				else if(x==0 && y==7) {
					if(Board[x][y-2].getColor()==E_COLOR.WHITE || Board[x+1][y-1].getColor()==E_COLOR.WHITE|| Board[x+2][y-2].getColor()==E_COLOR.WHITE|| Board[x+2][y].getColor()==E_COLOR.WHITE)
						return false;
				}
				else{
					if(Board[x-2][y].getColor()==E_COLOR.WHITE || Board[x-1][y+1].getColor()==E_COLOR.WHITE|| Board[x-2][y+2].getColor()==E_COLOR.WHITE|| Board[x][y+2].getColor()==E_COLOR.WHITE||Board[x+1][y+1].getColor()==E_COLOR.WHITE||Board[x+2][y+2].getColor()==E_COLOR.WHITE|| Board[x+2][y].getColor()==E_COLOR.WHITE||Board[x+1][y-1].getColor()==E_COLOR.WHITE||Board[x+2][y-2].getColor()==E_COLOR.WHITE||Board[x][y-2].getColor()==E_COLOR.WHITE||Board[x-1][y-1].getColor()==E_COLOR.WHITE||Board[x-2][y-2].getColor()==E_COLOR.WHITE)
						return false;
				}
				//set the soldier in the location given
				Board[x][y].setColor(E_COLOR.BLACK);
				return true;

			}
		}

		return false;

	}


	/* we get a soldier that's dead , we remove it 
	from the game board and the correct pieces list to its color
	and we set its alive status to false

	 */
	public boolean removeSoldier(Soldier s)
	{
		if(s!=null && s.getLocation()!=null)
		{  
			//If soldier is Black
			if(s.getColor().equals(E_COLOR.BLACK))
			{
				//Delete the solder from the relevant array using setIsAlive as false
				for(int i=0;i<BlackPieces.length;i++)
				{
					if(BlackPieces[i]==s)
						BlackPieces[i].setIsAlive(false);
				}
			}
			//If soldier is White
			if(s.getColor().equals(E_COLOR.WHITE))
			{
				//Delete the solder from the relevant array using setIsAlive as false
				for(int i=0;i<WhitePieces.length;i++)
				{
					if(WhitePieces[i]==s)
						WhitePieces[i].setIsAlive(false);
				}
			}
			//set the location as empty
			Board[s.getLocation().getX()][s.getLocation().getY()].setColor(E_COLOR.EMPTY);
			s.setIsAlive(false);
		}

		return true;
	}

	public void soldierTurnToQueen(Soldier s)
	{


		s.setIsQueen(true);
	}

	/*
	 * this method checks if the player can eat any soldier in his current turn
	 */

	public boolean IsEatable(Player p)
	{
		//case player is White
		if(p.getColor()==E_COLOR.WHITE) {

			for(int i=0;i<WhitePieces.length; i++)
			{
				//get the location of the player
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
						if(((Board[x-1][y+1].getColor())==(E_COLOR.BLACK) && Board[x-2][y+2].getColor()==null)|| ((Board[x-1][y-1].getColor())==(E_COLOR.BLACK) && Board[x-2][y-2].getColor()==null)) 
							return true;	
					}
				}
				//case the soldier is Queen
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
					//check if the soldier near is a rival soldier and there is an empty square after him.
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
					//check if the soldier near is a rival soldier and there is an empty square after him.
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
					//check if the soldier near is a rival soldier and there is an empty square after him.
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
					//check if the soldier near is a rival soldier and there is an empty square after him.
					if(Board[x][y].getColor()==E_COLOR.BLACK && Board[x+1][y-1].getColor()==null)
						return true;
				}

			}

		}
		//case player is Black
		if(p.getColor()==E_COLOR.BLACK) {

			for(int i=0;i<BlackPieces.length; i++) {
				//get the location of the soldier
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
					//check if the soldier near is a rival soldier and there is an empty square after him.
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
					//check if the soldier near is a rival soldier and there is an empty square after him.
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
					//check if the soldier near is a rival soldier and there is an empty square after him.
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

	// this function return true if all the rival soldier is blocked
	// Player p is the rival player
	// Queen not checked
	public boolean IsBlocked(Player p)
	{
		int countBlockedSoldier=0;//counter for blocked soldiers
		int countSolidersinGame=0;//counter for soldiers in the game
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
					//get the location of the soldier
					x=BlackPieces[i].getLocation().getX();
					y=BlackPieces[i].getLocation().getY();
					if(x==0 && y==7) {
						if(Board[x+1][y-1].getColor()!=E_COLOR.EMPTY)
							countBlockedSoldier++;
					}
					else if(x==7 && y==0) {
						if(Board[x-1][y+1].getColor()!=E_COLOR.EMPTY)
							countBlockedSoldier++;
					}
					else if(y==0) {
						//Checking if the soldiers of the first column is blocked  from two directions UP and DOWN
						if(Board[x-1][y+1].getColor()!=E_COLOR.EMPTY && Board[x+1][y+1].getColor()!=E_COLOR.EMPTY)
							countBlockedSoldier++;
					}
					else if(y==7) {
						//Checking if the soldiers of the last column is blocked  from two directions UP and DOWN
						if(Board[x-1][y-1].getColor()!=E_COLOR.EMPTY && Board[x+1][y-1].getColor()!=E_COLOR.EMPTY)
							countBlockedSoldier++;
					}
					else {
						if(Board[x-1][y-1].getColor()!=E_COLOR.EMPTY && Board[x+1][y-1].getColor()!=E_COLOR.EMPTY 
								&& Board[x-1][y+1].getColor()!=E_COLOR.EMPTY &&Board[x+1][y+1].getColor()!=E_COLOR.EMPTY)
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
						if(Board[x+1][y-1].getColor()!=E_COLOR.EMPTY)
							countBlockedSoldier++;
					}
					else if(x==7 && y==0) {
						if(Board[x-1][y+1].getColor()!=E_COLOR.EMPTY)
							countBlockedSoldier++;
					}
					else if(y==0) {
						//Checking if the soldiers of the first column is blocked  from two directions UP and DOWN
						if(Board[x-1][y+1].getColor()!=E_COLOR.EMPTY && Board[x+1][y+1].getColor()!=E_COLOR.EMPTY)
							countBlockedSoldier++;
					}
					else if(y==7) {
						//Checking if the soldiers of the last column is blocked  from two directions UP and DOWN
						if(Board[x-1][y-1].getColor()!=E_COLOR.EMPTY && Board[x+1][y-1].getColor()!=E_COLOR.EMPTY)
							countBlockedSoldier++;
					}
					else {  
						if(y+1<8 &&Board[x-1][y-1].getColor()!=E_COLOR.EMPTY && Board[x+1][y-1].getColor()!=E_COLOR.EMPTY 
								&& Board[x-1][y+1].getColor()!=E_COLOR.EMPTY &&Board[x+1][y+1].getColor()!=E_COLOR.EMPTY)
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



}