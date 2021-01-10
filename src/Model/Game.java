package Model;

import java.io.File;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Time;


import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import Controllers.SquareFactory;
import Model.Player;
import javafx.scene.shape.Circle;
import utils.Soldier_COLOR_AtSquare;
import view.BoardGameController;
import view.NicknamesSetUpController;

import utils.E_Difficulty;
import utils.SQUARE_COLOR;

/**
 *  * Game class -not responsible of game controllers

 * 
 * @author Maisa Mansour
 * @author Ethar Bakir
 * @author Alaa Khawaled
 * 
 * 
 */
public class Game {

	// -------------------------------Class Members------------------------------

	private SquareObject[][] Board;
	private Date GameDate;
	private Player whitePlayer;
	private Player blackPlayer;
	private Time QueueTime;	
	private Soldier[] WhitePieces;
	private Soldier[] BlackPieces;
	// in the use for the results board only
		private String whiteNic;
		private String blackNic;
		private int whitePoint;
		private int blackPoints;

	//---------------------------Constructor----------------------

	//only to the results board
		public Game(Date gameDate, String whiteNic, String blackNic, int whitePoint, int blackPoints) {
			super();
			GameDate = gameDate;
			this.whiteNic = whiteNic;
			this.blackNic = blackNic;
			this.whitePoint = whitePoint;
			this.blackPoints = blackPoints;
		}
	public Game(Player white,Player black, Date gamedate, Time queueTime) {
		super();
		Board =new SquareObject[8][8];
		GameDate = gamedate;
		QueueTime = queueTime;
		WhitePieces =new Soldier[12];
		BlackPieces =new Soldier[12];
		whitePlayer=white;
		blackPlayer=black;
	}

	public Game(Date gameDate, Player whitePlayer, Player blackPlayer) {
		super();
		Board =new SquareObject[8][8];
		GameDate = gameDate;
		this.whitePlayer = whitePlayer;
		this.blackPlayer = blackPlayer;
		this.whiteNic=whitePlayer.getNickName();
		this.blackNic=blackPlayer.getNickName();
		this.whitePoint=whitePlayer.getPoints();
		this.blackPoints=blackPlayer.getPoints();

		WhitePieces =new Soldier[12];
		BlackPieces =new Soldier[12];
	}
	//---------------Getters and Setters--------------------------
	public String getWhiteNic() {
		return whiteNic;
	}

	public void setWhiteNic(String whiteNic) {
		this.whiteNic = whiteNic;
	}

	public String getBlackNic() {
		return blackNic;
	}

	public void setBlackNic(String blackNic) {
		this.blackNic = blackNic;
	}

	public int getWhitePoint() {
		return whitePoint;
	}

	public void setWhitePoint(int whitePoint) {
		this.whitePoint = whitePoint;
	}

	public int getBlackPoints() {
		return blackPoints;
	}

	public void setBlackPoints(int blackPoints) {
		this.blackPoints = blackPoints;
	}

	public Date getGameDate() {
		return GameDate;
	}
	public SquareObject[][] getBoard() {
		return Board;
	}
	public void setBoard(SquareObject[][] board) {
		Board = board;
	}


	public Date getGameTime() {
		return GameDate;
	}
	public void setGameTime(Time gameTime) {
		GameDate = gameTime;
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
					for(int col=0;col<8;col+=2)
					{
						Board[row][col]= SquareFactory.getSquareObject(SQUARE_COLOR.BLACK,row, col,Soldier_COLOR_AtSquare.EMPTY,null);
					
					}
				else
				{
					for(int col=1;col<8;col+=2)
					{
						Board[row][col]=SquareFactory.getSquareObject(SQUARE_COLOR.BLACK,row, col,Soldier_COLOR_AtSquare.EMPTY,null);
						
						
					}
				}
			}
		}




		// we arrange the basic soldiers to there places 12 black 12 white

		Board[0][1].setSoldierColor(Soldier_COLOR_AtSquare.BLACK);
		Board[0][3].setSoldierColor(Soldier_COLOR_AtSquare.BLACK);
		Board[0][5].setSoldierColor(Soldier_COLOR_AtSquare.BLACK);
		Board[0][7].setSoldierColor(Soldier_COLOR_AtSquare.BLACK);
		Board[1][0].setSoldierColor(Soldier_COLOR_AtSquare.BLACK);
		Board[1][2].setSoldierColor(Soldier_COLOR_AtSquare.BLACK);
		Board[1][4].setSoldierColor(Soldier_COLOR_AtSquare.BLACK);
		Board[1][6].setSoldierColor(Soldier_COLOR_AtSquare.BLACK);
		Board[2][1].setSoldierColor(Soldier_COLOR_AtSquare.BLACK);
		Board[2][3].setSoldierColor(Soldier_COLOR_AtSquare.BLACK);
		Board[2][5].setSoldierColor(Soldier_COLOR_AtSquare.BLACK);
		Board[2][7].setSoldierColor(Soldier_COLOR_AtSquare.BLACK);
		Board[7][0].setSoldierColor(Soldier_COLOR_AtSquare.WHITE);
		Board[7][2].setSoldierColor(Soldier_COLOR_AtSquare.WHITE);
		Board[7][4].setSoldierColor(Soldier_COLOR_AtSquare.WHITE);
		Board[7][6].setSoldierColor(Soldier_COLOR_AtSquare.WHITE);
		Board[6][1].setSoldierColor(Soldier_COLOR_AtSquare.WHITE);
		Board[6][3].setSoldierColor(Soldier_COLOR_AtSquare.WHITE);
		Board[6][5].setSoldierColor(Soldier_COLOR_AtSquare.WHITE);
		Board[6][7].setSoldierColor(Soldier_COLOR_AtSquare.WHITE);
		Board[5][0].setSoldierColor(Soldier_COLOR_AtSquare.WHITE);
		Board[5][2].setSoldierColor(Soldier_COLOR_AtSquare.WHITE);
		Board[5][4].setSoldierColor(Soldier_COLOR_AtSquare.WHITE);
		Board[5][6].setSoldierColor(Soldier_COLOR_AtSquare.WHITE);
		Board[3][0].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);
		Board[3][2].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);
		Board[3][4].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);
		Board[3][6].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);
		Board[4][1].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);
		Board[4][3].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);
		Board[4][5].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);
		Board[4][7].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);



		int whitei=0;
		if(whitei<WhitePieces.length)
		{
			for(int row=5;row<8;row++)
			{
				if(row%2!=0) {
					for(int j=0;j<8;j+=2)
					{
						Soldier s=new Soldier(true,Board[row][j], Soldier_COLOR_AtSquare.WHITE);
						Board[row][j].setS(s);
						
						WhitePieces[whitei]=s;
						//System.out.printf("the white soldier is at: %d %d", row,j);
						whitei++;

					}
				}
				else {
					for(int j=1;j<8;j+=2)
					{
						Soldier s=new Soldier(true,Board[row][j], Soldier_COLOR_AtSquare.WHITE);
						//System.out.printf("the white soldier is at: %d %d", row,j);
						Board[row][j].setS(s);
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
						Soldier s=new Soldier(true,Board[row][j], Soldier_COLOR_AtSquare.BLACK);
						//System.out.printf("the black soldier is at: %d %d", row,j);
						Board[row][j].setS(s);
					
						BlackPieces[Blacki]=s;	
						Blacki++;
					}
				}
				else {
					for(int j=1;j<8;j+=2)
					{
						Soldier s=new Soldier(true,Board[row][j], Soldier_COLOR_AtSquare.BLACK);
						//System.out.printf("the black soldier is at: %d %d", row,j);
						Board[row][j].setS(s);
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

	public void initiateLOADGame(String[] arrOfStr)
	{   int place=0;

	this.initiateGame();

	for(int i=0;i<8;i++)
		for(int j=0;j<8;j++)
		{
			if(Board[i][j]!=null ) 
			{
				System.out.println(i+","+j+","+Board[i][j].getSquareColor());
				

			}

			
		}
		
		for(int row=0;row<8&&place<arrOfStr.length;row++)
		{
			if(row%2!=0) {
				for(int j=0;j<8 &&place<arrOfStr.length;j+=2)
				{
					
					 if(arrOfStr[place].equals("0"))
						{
							Board[row][j].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);
							
							place++;
							
						}
					 else
						if(arrOfStr[place].equals("1"))
						{
							Board[row][j].setSoldierColor(Soldier_COLOR_AtSquare.WHITE);
							place++;
						

						}
						else
						if(arrOfStr[place].equals("2"))
						{
							Board[row][j].setSoldierColor(Soldier_COLOR_AtSquare.BLACK);
							place++;

						}
						else
						if(arrOfStr[place].equals("11"))
						{
							Board[row][j].setSoldierColor(Soldier_COLOR_AtSquare.WHITE);
							

							Board[row][j].getS().setIsQueen(true);
							place++;
						}
						else
						if(arrOfStr[place].equals("22"))
						{
							Board[row][j].setSoldierColor(Soldier_COLOR_AtSquare.BLACK);
							Board[row][j].getS().setIsQueen(true);
							place++;

						}
						else
						if(arrOfStr[place].equals("B"))
						{
							Board[row][j].setSoldierColor(Soldier_COLOR_AtSquare.BLACK);
							place++;

						}
						else
						if(arrOfStr[place].equals("W"))
						{
							Board[row][j].setSoldierColor(Soldier_COLOR_AtSquare.BLACK);
							place++;
						}

				}
			}
			else {
				for(int j=1;j<8 && place<arrOfStr.length;j+=2)
				{
					
					 if(arrOfStr[place].equals("0"))
						{
						
							Board[row][j].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);
							place++;
						}
					 else
						if(arrOfStr[place].equals("1"))
						{
							Board[row][j].setSoldierColor(Soldier_COLOR_AtSquare.WHITE);
							
							place++;

						}
						else
						if(arrOfStr[place].equals("2"))
						{
							Board[row][j].setSoldierColor(Soldier_COLOR_AtSquare.BLACK);
							place++;

						}
						else
						if(arrOfStr[place].equals("11"))
						{
							Board[row][j].setSoldierColor(Soldier_COLOR_AtSquare.WHITE);
							

							Board[row][j].getS().setIsQueen(true);
							place++;
						}
						else
						if(arrOfStr[place].equals("22"))
						{
							Board[row][j].setSoldierColor(Soldier_COLOR_AtSquare.BLACK);
							Board[row][j].getS().setIsQueen(true);
							place++;

						}
						
				}
				
			}
				
	}
	}

	public boolean AddPlayer(String wp,String bp)
	{
		this.whitePlayer = new Player(wp,0);
		this.blackPlayer = new Player(bp,0);
		return true;


	}


	public boolean returnSoldier(Soldier s, int x, int y)
	{
		

		if(!s.isIsAlive() && x!=0 )
		{System.out.println(s.getColor());
		System.out.println(x);
		System.out.println(y);
			//If soldier is White soldier
			if(s.getColor()==Soldier_COLOR_AtSquare.WHITE) {
				
				if(x==1 && y==0) {
					if( Board[x-1][y+1].getSoldierColor()==Soldier_COLOR_AtSquare.BLACK||Board[x+1][y+1].getSoldierColor()==Soldier_COLOR_AtSquare.BLACK||Board[x+2][y+2].getSoldierColor()==Soldier_COLOR_AtSquare.BLACK)
						return false;
				}
				else if (x==1 && y==6)
				{
					if( Board[x-1][y+1].getSoldierColor()==Soldier_COLOR_AtSquare.BLACK||Board[x+1][y+1].getSoldierColor()==Soldier_COLOR_AtSquare.BLACK||Board[x+2][y-2].getSoldierColor()==Soldier_COLOR_AtSquare.BLACK)
						return false;
				}
				
				else if(x==3 && y==0) {
					if( Board[x-1][y+1].getSoldierColor()==Soldier_COLOR_AtSquare.BLACK|| Board[x-2][y+2].getSoldierColor()==Soldier_COLOR_AtSquare.BLACK||Board[x+1][y+1].getSoldierColor()==Soldier_COLOR_AtSquare.BLACK||Board[x+2][y+2].getSoldierColor()==Soldier_COLOR_AtSquare.BLACK)
						return false;
				}
				else if(x==7 && y==0) {
					if(Board[x-1][y+1].getSoldierColor()==Soldier_COLOR_AtSquare.BLACK|| Board[x-2][y+2].getSoldierColor()==Soldier_COLOR_AtSquare.BLACK)
						return false;
				}

				else if((x==3 || x==5) && y==6) {
					if(Board[x-1][y+1].getSoldierColor()==Soldier_COLOR_AtSquare.BLACK|| Board[x+1][y+1].getSoldierColor()==Soldier_COLOR_AtSquare.BLACK||Board[x+1][y-1].getSoldierColor()==Soldier_COLOR_AtSquare.BLACK
							||Board[x+2][y-2].getSoldierColor()==Soldier_COLOR_AtSquare.BLACK|| Board[x-1][y-1].getSoldierColor()==Soldier_COLOR_AtSquare.BLACK||Board[x-2][y-2].getSoldierColor()==Soldier_COLOR_AtSquare.BLACK)
						return false;
				}
				else if(x==7 && (y==4|| y==2)) {
					if( Board[x-1][y-1].getSoldierColor()==Soldier_COLOR_AtSquare.BLACK|| Board[x-2][y-2].getSoldierColor()==Soldier_COLOR_AtSquare.BLACK|| Board[x-1][y+1].getSoldierColor()==Soldier_COLOR_AtSquare.BLACK||Board[x-2][y+2].getSoldierColor()==Soldier_COLOR_AtSquare.BLACK)
						return false;
				}
				else if(x==7 && y==6) {
					if( Board[x-1][y-1].getSoldierColor()==Soldier_COLOR_AtSquare.BLACK|| Board[x-2][y-2].getSoldierColor()==Soldier_COLOR_AtSquare.BLACK||Board[x-1][y+1].getSoldierColor()==Soldier_COLOR_AtSquare.BLACK)
						return false;
				}
				else if(x==6 && y==7) {
					if(Board[x+1][y-1].getSoldierColor()==Soldier_COLOR_AtSquare.BLACK || Board[x-1][y-1].getSoldierColor()==Soldier_COLOR_AtSquare.BLACK|| Board[x-2][y-2].getSoldierColor()==Soldier_COLOR_AtSquare.BLACK)
						return false;
				}
				else if((x==4|| x==2) && y==7) {
					if(Board[x+1][y-1].getSoldierColor()==Soldier_COLOR_AtSquare.BLACK|| Board[x+2][y-2].getSoldierColor()==Soldier_COLOR_AtSquare.BLACK|| Board[x-1][y-1].getSoldierColor()==Soldier_COLOR_AtSquare.BLACK||Board[x-2][y-2].getSoldierColor()==Soldier_COLOR_AtSquare.BLACK)
						return false;
				}
				
				else if(x==6 && (y==5||y==3)) {
					if(Board[x-1][y+1].getSoldierColor()==Soldier_COLOR_AtSquare.BLACK|| Board[x-2][y+2].getSoldierColor()==Soldier_COLOR_AtSquare.BLACK||Board[x+1][y+1].getSoldierColor()==Soldier_COLOR_AtSquare.BLACK||Board[x+1][y-1].getSoldierColor()==Soldier_COLOR_AtSquare.BLACK||Board[x-1][y-1].getSoldierColor()==Soldier_COLOR_AtSquare.BLACK||Board[x-2][y-2].getSoldierColor()==Soldier_COLOR_AtSquare.BLACK)
						return false;
				}
				else if((x==4|| x==2||x==6 )&& y==1) {//10 
					if(Board[x-1][y+1].getSoldierColor()==Soldier_COLOR_AtSquare.BLACK|| Board[x-2][y+2].getSoldierColor()==Soldier_COLOR_AtSquare.BLACK||Board[x+1][y+1].getSoldierColor()==Soldier_COLOR_AtSquare.BLACK||Board[x+1][y-1].getSoldierColor()==Soldier_COLOR_AtSquare.BLACK||Board[x-1][y-1].getSoldierColor()==Soldier_COLOR_AtSquare.BLACK)
						return false;
				}
				else if(x==1 && y==6) {//11 
					if(Board[x-1][y+1].getSoldierColor()==Soldier_COLOR_AtSquare.BLACK || Board[x+1][y+1].getSoldierColor()==Soldier_COLOR_AtSquare.BLACK|| Board[x+1][y-1].getSoldierColor()==Soldier_COLOR_AtSquare.BLACK||Board[x+2][y-2].getSoldierColor()==Soldier_COLOR_AtSquare.BLACK||Board[x-1][y-1].getSoldierColor()==Soldier_COLOR_AtSquare.BLACK)
						return false;
				}

				else if(x==1 && (y==2 || y==4)) {//12 
					if(Board[x-1][y+1].getSoldierColor()==Soldier_COLOR_AtSquare.BLACK ||Board[x+1][y+1].getSoldierColor()==Soldier_COLOR_AtSquare.BLACK|| Board[x+2][y+2].getSoldierColor()==Soldier_COLOR_AtSquare.BLACK||Board[x+1][y-1].getSoldierColor()==Soldier_COLOR_AtSquare.BLACK||Board[x+2][y-2].getSoldierColor()==Soldier_COLOR_AtSquare.BLACK||Board[x-1][y-1].getSoldierColor()==Soldier_COLOR_AtSquare.BLACK)
						return false;
				}

				else{
					if( Board[x-1][y+1].getSoldierColor()==Soldier_COLOR_AtSquare.BLACK|| Board[x-2][y+2].getSoldierColor()==Soldier_COLOR_AtSquare.BLACK||Board[x+1][y+1].getSoldierColor()==Soldier_COLOR_AtSquare.BLACK||Board[x+2][y+2].getSoldierColor()==Soldier_COLOR_AtSquare.BLACK||Board[x+1][y-1].getSoldierColor()==Soldier_COLOR_AtSquare.BLACK||Board[x+2][y-2].getSoldierColor()==Soldier_COLOR_AtSquare.BLACK||Board[x-1][y-1].getSoldierColor()==Soldier_COLOR_AtSquare.BLACK||Board[x-2][y-2].getSoldierColor()==Soldier_COLOR_AtSquare.BLACK)
						return false;
				}
				//set the soldier in the location given
				Board[x][y].setSoldierColor(Soldier_COLOR_AtSquare.WHITE);
				return true;
			}
			//If soldier is Black 
			if(s.getColor()==Soldier_COLOR_AtSquare.BLACK) {
				if(x==7)
					return false;
				else if(x==1 && y==0) {
					if(Board[x-1][y+1].getSoldierColor()==Soldier_COLOR_AtSquare.WHITE || Board[x+1][y+1].getSoldierColor()==Soldier_COLOR_AtSquare.WHITE || Board[x+2][y+2].getSoldierColor()==Soldier_COLOR_AtSquare.WHITE)
						return false;

				}
				
				else if((x==3||x==5) && y==0) {
					if(Board[x-1][y+1].getSoldierColor()==Soldier_COLOR_AtSquare.WHITE|| Board[x-2][y+2].getSoldierColor()==Soldier_COLOR_AtSquare.WHITE||Board[x+1][y+1].getSoldierColor()==Soldier_COLOR_AtSquare.WHITE||Board[x+2][y+2].getSoldierColor()==Soldier_COLOR_AtSquare.WHITE)
						return false;
				}

				else if(x==6 && y==7) {
					if(Board[x+1][y-1].getSoldierColor()==Soldier_COLOR_AtSquare.WHITE || Board[x-1][y-1].getSoldierColor()==Soldier_COLOR_AtSquare.WHITE|| Board[x-2][y-2].getSoldierColor()==Soldier_COLOR_AtSquare.WHITE)
						return false;
				}
				else if((x==4||x==2) && y==7) {
					if(Board[x+1][y-1].getSoldierColor()==Soldier_COLOR_AtSquare.WHITE|| Board[x+2][y-2].getSoldierColor()==Soldier_COLOR_AtSquare.WHITE|| Board[x-1][y-1].getSoldierColor()==Soldier_COLOR_AtSquare.WHITE||Board[x-2][y-2].getSoldierColor()==Soldier_COLOR_AtSquare.WHITE)
						return false;
				}
				else if(x==6 && (y==3||y==5)) {
					if( Board[x-1][y+1].getSoldierColor()==Soldier_COLOR_AtSquare.WHITE|| Board[x-2][y+2].getSoldierColor()==Soldier_COLOR_AtSquare.WHITE||Board[x+1][y+1].getSoldierColor()==Soldier_COLOR_AtSquare.WHITE||Board[x+1][y-1].getSoldierColor()==Soldier_COLOR_AtSquare.WHITE||Board[x-1][y-1].getSoldierColor()==Soldier_COLOR_AtSquare.WHITE||Board[x-2][y-2].getSoldierColor()==Soldier_COLOR_AtSquare.WHITE)
						return false;
				}
				else if(x==6 && y==1) { 
					if(Board[x-1][y+1].getSoldierColor()==Soldier_COLOR_AtSquare.WHITE|| Board[x-2][y+2].getSoldierColor()==Soldier_COLOR_AtSquare.WHITE||Board[x+1][y+1].getSoldierColor()==Soldier_COLOR_AtSquare.WHITE||Board[x+1][y-1].getSoldierColor()==Soldier_COLOR_AtSquare.WHITE||Board[x-1][y-1].getSoldierColor()==Soldier_COLOR_AtSquare.WHITE)
						return false;
				}
				else if((x==1||x==5||x==3) && y==6) { 
					if(Board[x-1][y+1].getSoldierColor()==Soldier_COLOR_AtSquare.WHITE || Board[x+1][y+1].getSoldierColor()==Soldier_COLOR_AtSquare.WHITE|| Board[x+1][y-1].getSoldierColor()==Soldier_COLOR_AtSquare.WHITE||Board[x+2][y-2].getSoldierColor()==Soldier_COLOR_AtSquare.WHITE||Board[x-1][y-1].getSoldierColor()==Soldier_COLOR_AtSquare.WHITE)
						return false;
				}

				else if(x==1 && (y==2||y==4)) {
					if(Board[x-1][y+1].getSoldierColor()==Soldier_COLOR_AtSquare.WHITE || Board[x+1][y+1].getSoldierColor()==Soldier_COLOR_AtSquare.WHITE|| Board[x+2][y+2].getSoldierColor()==Soldier_COLOR_AtSquare.WHITE||Board[x+1][y-1].getSoldierColor()==Soldier_COLOR_AtSquare.WHITE||Board[x+2][y-2].getSoldierColor()==Soldier_COLOR_AtSquare.WHITE||Board[x-1][y-1].getSoldierColor()==Soldier_COLOR_AtSquare.WHITE)
						return false;
				}
				else if(x==0 && y==1) {
					if(Board[x+1][y-1].getSoldierColor()==Soldier_COLOR_AtSquare.WHITE || Board[x+1][y+1].getSoldierColor()==Soldier_COLOR_AtSquare.WHITE|| Board[x+2][y+2].getSoldierColor()==Soldier_COLOR_AtSquare.WHITE)
						return false;
				}
				else if(x==0 && y==3) { 
					if(Board[x+1][y-1].getSoldierColor()==Soldier_COLOR_AtSquare.WHITE|| Board[x+2][y-2].getSoldierColor()==Soldier_COLOR_AtSquare.WHITE||Board[x+1][y+1].getSoldierColor()==Soldier_COLOR_AtSquare.WHITE||Board[x+2][y+2].getSoldierColor()==Soldier_COLOR_AtSquare.WHITE)
						return false;
				}
				else if(x==0 && y==7) {
					if(Board[x+1][y-1].getSoldierColor()==Soldier_COLOR_AtSquare.WHITE|| Board[x+2][y-2].getSoldierColor()==Soldier_COLOR_AtSquare.WHITE)
						return false;
				}
				else if((x==2||x==4) && y==1) {
					if(Board[x-1][y-1].getSoldierColor()==Soldier_COLOR_AtSquare.WHITE|| 
							Board[x-1][y+1].getSoldierColor()==Soldier_COLOR_AtSquare.WHITE||
									Board[x-2][y+2].getSoldierColor()==Soldier_COLOR_AtSquare.WHITE||
											Board[x+1][y+1].getSoldierColor()==Soldier_COLOR_AtSquare.WHITE||
													Board[x+2][y+2].getSoldierColor()==Soldier_COLOR_AtSquare.WHITE||
													Board[x+1][y-1].getSoldierColor()==Soldier_COLOR_AtSquare.WHITE)
						return false;
				}
				else{
					if(Board[x-1][y+1].getSoldierColor()==Soldier_COLOR_AtSquare.WHITE|| Board[x-2][y+2].getSoldierColor()==Soldier_COLOR_AtSquare.WHITE||Board[x+1][y+1].getSoldierColor()==Soldier_COLOR_AtSquare.WHITE||Board[x+2][y+2].getSoldierColor()==Soldier_COLOR_AtSquare.WHITE||Board[x+1][y-1].getSoldierColor()==Soldier_COLOR_AtSquare.WHITE||Board[x+2][y-2].getSoldierColor()==Soldier_COLOR_AtSquare.WHITE||Board[x-1][y-1].getSoldierColor()==Soldier_COLOR_AtSquare.WHITE||Board[x-2][y-2].getSoldierColor()==Soldier_COLOR_AtSquare.WHITE)
						return false;
				}
				//set the soldier in the location given
				Board[x][y].setSoldierColor(Soldier_COLOR_AtSquare.BLACK);
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
			if(s.getColor().equals(Soldier_COLOR_AtSquare.BLACK))
			{
				//Delete the solder from the relevant array using setIsAlive as false
				for(int i=0;i<BlackPieces.length;i++)
				{
					if(BlackPieces[i]==s)
						BlackPieces[i].setIsAlive(false);
				}
			}
			//If soldier is White
			if(s.getColor().equals(Soldier_COLOR_AtSquare.WHITE))
			{
				//Delete the solder from the relevant array using setIsAlive as false
				for(int i=0;i<WhitePieces.length;i++)
				{
					if(WhitePieces[i]==s)
						WhitePieces[i].setIsAlive(false);
				}
			}
			//set the location as empty
			Board[s.getLocation().getX()][s.getLocation().getY()].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);
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

	public Soldier IsEatable(Player p, Soldier[] Pieces)
	{		
		Soldier canEat=null;
		//case player is White

		if(p.getColor()==Soldier_COLOR_AtSquare.WHITE) {
			
			for(int i=0;i<Pieces.length; i++)
			{
				//get the location of the player
				int x=Pieces[i].getLocation().getX();
				int y=Pieces[i].getLocation().getY();
				if(Pieces[i].isIsQueen()==false)
				{
					if(y==0 && (x==7|| x==5||x==3)) {
						if((Board[x-1][y+1].getSoldierColor())==(Soldier_COLOR_AtSquare.BLACK) && Board[x-2][y+2].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY) {
							canEat=Pieces[i];
						}
					}
					
					if(y==1 && (x==6|| x==4|| x==2)) {
						if((Board[x-1][y+1].getSoldierColor())==(Soldier_COLOR_AtSquare.BLACK) && Board[x-2][y+2].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY) {
							canEat=Pieces[i];						}
					}
					
					if(y==7 && (x==6|| x==4|| x==2)) {
						if((Board[x-1][y-1].getSoldierColor())==(Soldier_COLOR_AtSquare.BLACK) && Board[x-2][y-2].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY) {
							canEat=Pieces[i];						}
					}
					
					if(y==6 && (x==7|| x==5|| x==3)) {
						if((Board[x-1][y-1].getSoldierColor())==(Soldier_COLOR_AtSquare.BLACK) && Board[x-2][y-2].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY) {
							canEat=Pieces[i];						}
					}
					
					if(y>1 && y<6 && x>1 && x<8){
						if((Board[x-1][y-1].getSoldierColor())==(Soldier_COLOR_AtSquare.BLACK) && Board[x-2][y-2].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY) {
							canEat=Pieces[i];						}
						if((Board[x-1][y+1].getSoldierColor())==(Soldier_COLOR_AtSquare.BLACK) && Board[x-2][y+2].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY) {
							canEat=Pieces[i];						}
					}

				
				}
				//case the soldier is white Queen
//				else if(Pieces[i].isIsQueen()==true) {
//					//case the queen is moving up right
//					   if(x>0) {
//					while( Board[x-1][y+1].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY) {
//						x--;
//						y++;
//						// case the queen arrived the edge of the board
//						if(y==7 && x==0) {
//							y=0;
//							x=7;
//						}
//						else if(y==7 && x!=0) {
//							y=0;
//							x--;
//						}
//						else if(x==0) {
//							x=7;
//							y++;
//						}
//					}
//					   }
//					//check if the soldier near is a rival soldier and there is an empty square after him.
//					if(Board[x][y].getSoldierColor()==Soldier_COLOR_AtSquare.BLACK && Board[x-1][y+1].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY)
//						whiteCountEatable++;
//					//case the queen is moving up left
//					if(x>0 & y>0) {
//					while(Board[x-1][y-1].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY) {
//						x--;
//						y--;
//						// case the queen arrived the edge of the board
//						if(y==0) {
//							y=7;
//							x--;
//						}else if(x==0) {
//							y--;
//							x=7;
//						}
//                  
//					}
//					}
//					//check if the soldier near is a rival soldier and there is an empty square after him.
//					if(Board[x][y].getSoldierColor()==Soldier_COLOR_AtSquare.BLACK && Board[x-1][y-1].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY)
//						whiteCountEatable++;
//					//case the queen is moving right down
//					if(x<7 && y<7) {
//					while(Board[x+1][y+1].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY) {
//						x++;
//						y++;
//
//						// case the queen arrived the edge of the board
//						if(x==7) {
//							y++;
//							x=0;
//						}else if(y==7) {
//							y=0;
//							x++;
//						}
//					}
//				}
//					//check if the soldier near is a rival soldier and there is an empty square after him.
//					if(Board[x][y].getSoldierColor()==Soldier_COLOR_AtSquare.BLACK && Board[x+1][y+1].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY)
//						whiteCountEatable++;
//					//case the queen is moving left down
//					if(y>0) {
//					while(Board[x+1][y-1].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY) {
//						x++;
//						y--;
//
//						// case the queen arrived the edge of the board
//						if(x==7 && y==0) {
//							y=7;
//							x=0;
//						}else if(x==7 && y!=0) {
//							y--;
//							x=0;
//						}else if(y==0) {
//							y=7;
//							x++;
//						}
//					}
//					}
//					//check if the soldier near is a rival soldier and there is an empty square after him.
//					if(Board[x][y].getSoldierColor()==Soldier_COLOR_AtSquare.BLACK && Board[x+1][y-1].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY)
//						whiteCountEatable++;
//				}

			}

		}
		//case player is Black
		else if(p.getColor()==Soldier_COLOR_AtSquare.BLACK) {

			for(int i=0;i<Pieces.length; i++) {
				//get the location of the soldier
				int x=Pieces[i].getLocation().getX();
				int y=Pieces[i].getLocation().getY();
				if(Pieces[i].isIsQueen()==false)
				{

					if(y==0 && (x==1|| x==3||x==5)) {
						if((Board[x+1][y+1].getSoldierColor())==(Soldier_COLOR_AtSquare.WHITE) && Board[x+2][y+2].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY) {
							canEat=Pieces[i];						}
					}
					
					if(y==1 && (x==0|| x==4|| x==2)) {
						if((Board[x+1][y+1].getSoldierColor())==(Soldier_COLOR_AtSquare.WHITE) && Board[x+2][y+2].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY) {
							canEat=Pieces[i];						}
					}
					
					if(y==7 && (x==0|| x==4|| x==2)) {
						if((Board[x+1][y-1].getSoldierColor())==(Soldier_COLOR_AtSquare.WHITE) && Board[x+2][y-2].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY) {
							canEat=Pieces[i];						}
					}
					
					if(y==6 && (x==1|| x==5|| x==3)) {
						if((Board[x+1][y-1].getSoldierColor())==(Soldier_COLOR_AtSquare.WHITE) && Board[x+2][y-2].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY) {
							canEat=Pieces[i];						}
					}
					if(y>1 && y<6 && x>=0 && x<6){
						if((Board[x+1][y-1].getSoldierColor())==(Soldier_COLOR_AtSquare.WHITE) && Board[x+2][y-2].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY) {
							canEat=Pieces[i];						}
						if((Board[x+1][y+1].getSoldierColor())==(Soldier_COLOR_AtSquare.WHITE) && Board[x+2][y+2].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY) {
							canEat=Pieces[i];						}
					}
				}

//				else if(Pieces[i].isIsQueen()==true) {
//					//case the queen is moving up right
//					if(x>0) {
//					while(Board[x-1][y+1].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY) {
//						x--;
//						y++;
//						// case the queen arrived the edge of the board
//						if(y==7 && x==0) {
//							y=0;
//							x=7;
//						}
//						else if(y==7 && x!=0) {
//							y=0;
//							x--;
//						}
//						else if(x==0) {
//							x=7;
//							y++;
//						}
//					}
//				}
//					//check if the soldier near is a rival soldier and there is an empty square after him.
//					if(Board[x][y].getSoldierColor()==Soldier_COLOR_AtSquare.WHITE && Board[x-1][y+1].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY)
//						blackCountEatable++;
//					//case the queen is moving up left
//					if(x>0 && y>0) {
//					while(Board[x-1][y-1].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY) {
//						x--;
//						y--;
//						// case the queen arrived the edge of the board
//						if(y==0) {
//							y=7;
//							x--;
//						}else if(x==0) {
//							y--;
//							x=7;
//						}
//
//					}
//				}
//					//check if the soldier near is a rival soldier and there is an empty square after him.
//					if(Board[x][y].getSoldierColor()==Soldier_COLOR_AtSquare.WHITE && Board[x-1][y-1].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY)
//						blackCountEatable++;
//					//case the queen is moving right down
//					if(x<7 && y<7) {
//					while(Board[x+1][y+1].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY) {
//						x++;
//						y++;
//
//						// case the queen arrived the edge of the board
//						if(x==7) {
//							y++;
//							x=0;
//						}else if(y==7) {
//							y=0;
//							x++;
//						}
//					}
//					}
//					//check if the soldier near is a rival soldier and there is an empty square after him.
//					if(Board[x][y].getSoldierColor()==Soldier_COLOR_AtSquare.WHITE && Board[x+1][y+1].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY)
//						blackCountEatable++;
//					//case the queen is moving left down
//					if(y>0) 
//					{
//					while(Board[x+1][y-1].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY) {
//						x++;
//						y--;
//						// case the queen arrived the edge of the board
//						if(x==7 && y==0) {
//							y=7;
//							x=0;
//						}else if(x==7 && y!=0) {
//							y--;
//							x=0;
//						}else if(y==0) {
//							y=7;
//							x++;
//						}
//						
//					}
//					}
//					if(Board[x][y].getSoldierColor()==Soldier_COLOR_AtSquare.WHITE && Board[x+1][y-1].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY)
//						blackCountEatable++;
//				}

			}

		}

		return null;
	}
	
	/*
	 * this method checks if the player can eat any soldier in his current turn
	 */

	public boolean eatingMore(Soldier s)
	{
		System.out.println("Fatt 3la eatingMore");

		//case player is White
		if(s.getColor()==Soldier_COLOR_AtSquare.WHITE) {

				//get the location of the player
				int x=s.getLocation().getX();
				int y=s.getLocation().getY();
				System.out.printf("XXXXX:%d",x);
				System.out.printf("YYYYYY:%d",y);
				if(s.isIsQueen()==false)
				{
					if((y==0 && x==1) || (y==1 && x==0)) {
						if( ((Board[x+1][y+1].getSoldierColor())==(Soldier_COLOR_AtSquare.BLACK) && Board[x+2][y+2].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY)) {
							return true;
						}
						
					}
					if((y==0 && x==7) || (y==1&& x==6)) {
						if( ((Board[x-1][y+1].getSoldierColor())==(Soldier_COLOR_AtSquare.BLACK) && Board[x-2][y+2].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY)) {
								return true;
						}
						
					}
					if((y==0 && (x==3|| x==5)) || (y==1 && (x==2 ||x==4))) {
						if(((Board[x-1][y+1].getSoldierColor())==(Soldier_COLOR_AtSquare.BLACK) && Board[x-2][y+2].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY)) {
								return true;
							
						}
						
						
						if( ((Board[x+1][y+1].getSoldierColor())==(Soldier_COLOR_AtSquare.BLACK) && Board[x+2][y+2].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY)) {
							return true;
						}
						
					}
					
					
					if(y==0 && x==1) {
						if(((Board[x+1][y+1].getSoldierColor())==(Soldier_COLOR_AtSquare.BLACK) && Board[x+2][y+2].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY)) {
							return true;
							
						}
					
					}
					if((y==7 && x==0) || (y==6 && x==1)){
						if( ((Board[x+1][y-1].getSoldierColor())==(Soldier_COLOR_AtSquare.BLACK) && Board[x+2][y-2].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY)) {
							return true;
							
						}
					
					}
					if((y==7 && (x==2|| x==4)) || (y==6&& (x==3||x==5))) {
						if(((Board[x-1][y-1].getSoldierColor())==(Soldier_COLOR_AtSquare.BLACK) && Board[x-2][y-2].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY)) {
							return true;
						}
						
						
						else if( ((Board[x+1][y-1].getSoldierColor())==(Soldier_COLOR_AtSquare.BLACK) && Board[x+2][y-2].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY)) {
						return true;
						}
						
					}
					if((y==7 && x==6) || (y==6 && x==7)) {
						if( ((Board[x-1][y-1].getSoldierColor())==(Soldier_COLOR_AtSquare.BLACK) && Board[x-2][y-2].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY)) {
								return true;
						}
						
					}
				
							if(x==0 || x==1)  {
								if(((Board[x+1][y-1].getSoldierColor())==(Soldier_COLOR_AtSquare.BLACK) && Board[x+2][y-2].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY)) {
									return true;
								}
								if(((Board[x+1][y+1].getSoldierColor())==(Soldier_COLOR_AtSquare.BLACK) && Board[x+2][y+2].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY)) {
										return true;
								}
								
							}
							
							if(x==6 || x==7)  {
								if(((Board[x-1][y-1].getSoldierColor())==(Soldier_COLOR_AtSquare.BLACK) && Board[x-2][y-2].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY)) {
										return true;
								}
								if(((Board[x-1][y+1].getSoldierColor())==(Soldier_COLOR_AtSquare.BLACK) && Board[x-2][y+2].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY)) {
									return true;
								}
								
							}
							if((x>1&& x<6) && (y>1&& y<6)) {
								//left up
								if( ((Board[x-1][y-1].getSoldierColor())==(Soldier_COLOR_AtSquare.BLACK) && Board[x-2][y-2].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY)) {
									return true;
								}
								//righ up
								if( ((Board[x-1][y+1].getSoldierColor())==(Soldier_COLOR_AtSquare.BLACK) && Board[x-2][y+2].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY)) {
									return true;
								}
								//left down
								if( ((Board[x+1][y-1].getSoldierColor())==(Soldier_COLOR_AtSquare.BLACK) && Board[x+2][y-2].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY)) {
									return true;
								}
								// right down
								if( ((Board[x+1][y+1].getSoldierColor())==(Soldier_COLOR_AtSquare.BLACK) && Board[x+2][y+2].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY)) {
									return true;
									
								}
								
							}
				
				}
				//case the soldier is white Queen
				/*else if(s.isIsQueen()==true) {
					for(int i=0;i<g.getWhitePieces().length;i++) {
						if(g.getWhitePieces()[i].getLocation().getX()==x && g.getWhitePieces()[i].getLocation().getY()==y) {
								MoveWhiteQueen(sourcex,sourcey,targetx ,targety,i);
						}
					}
					
					/*
					//case the queen is moving up right
					   if(x>0) {
					while( Board[x-1][y+1].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY) {
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
					   }
					//check if the soldier near is a rival soldier and there is an empty square after him.
					if(Board[x][y].getSoldierColor()==Soldier_COLOR_AtSquare.BLACK && Board[x-1][y+1].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY)
						return true;
					//case the queen is moving up left
					if(x>0 & y>0) {
					while(Board[x-1][y-1].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY) {
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
					}
					//check if the soldier near is a rival soldier and there is an empty square after him.
					if(Board[x][y].getSoldierColor()==Soldier_COLOR_AtSquare.BLACK && Board[x-1][y-1].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY)
						return true;
					//case the queen is moving right down
					if(x<7 && y<7) {
					while(Board[x+1][y+1].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY) {
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
				}
					//check if the soldier near is a rival soldier and there is an empty square after him.
					if(Board[x][y].getSoldierColor()==Soldier_COLOR_AtSquare.BLACK && Board[x+1][y+1].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY)
						return true;
					//case the queen is moving left down
					if(y>0) {
					while(Board[x+1][y-1].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY) {
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
					}
					//check if the soldier near is a rival soldier and there is an empty square after him.
					if(Board[x][y].getSoldierColor()==Soldier_COLOR_AtSquare.BLACK && Board[x+1][y-1].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY)
						return true;
				
				}*/
				
		}
		//case player is Black
		else if(s.getColor()==Soldier_COLOR_AtSquare.BLACK) {
			

			//get the location of the player
			int x=s.getLocation().getX();
			int y=s.getLocation().getY();
			if(s.isIsQueen()==false)
			{
				if((y==0 && x==1) || (y==1 && x==0)) {
					if( ((Board[x+1][y+1].getSoldierColor())==(Soldier_COLOR_AtSquare.WHITE) && Board[x+2][y+2].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY)) {
						//remove the soldier
			                 return true;
					}
					
				}
				if((y==0 && x==7) || (y==1&& x==6)) {
					if(((Board[x-1][y+1].getSoldierColor())==(Soldier_COLOR_AtSquare.WHITE) && Board[x-2][y+2].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY)) {
	                    return true;
					}
					
				}
				if((y==0 && (x==3|| x==5)) || (y==1 && (x==2 ||x==4))) {
					if( ((Board[x-1][y+1].getSoldierColor())==(Soldier_COLOR_AtSquare.WHITE) && Board[x-2][y+2].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY)) {
						return true;
						
					}
					
					
					if(((Board[x+1][y+1].getSoldierColor())==(Soldier_COLOR_AtSquare.WHITE) && Board[x+2][y+2].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY)) {
						//remove the soldier
					
						return true;
					}
					
				}
				
				
				if(y==0 && x==1) {
					if(((Board[x+1][y+1].getSoldierColor())==(Soldier_COLOR_AtSquare.WHITE) && Board[x+2][y+2].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY)) {
						//remove the soldier
						return true;
						
					}
				
				}
				if((y==7 && x==0) || (y==6 && x==1)){
					if(((Board[x+1][y-1].getSoldierColor())==(Soldier_COLOR_AtSquare.WHITE) && Board[x+2][y-2].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY)) {
						return true;

						
					}
				
				}
				if((y==7 && (x==2|| x==4)) || (y==6&& (x==3||x==5))) {
					if( ((Board[x-1][y-1].getSoldierColor())==(Soldier_COLOR_AtSquare.WHITE) && Board[x-2][y-2].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY)) {
						return true;

					}
					
					
					if(((Board[x+1][y-1].getSoldierColor())==(Soldier_COLOR_AtSquare.WHITE) && Board[x+2][y-2].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY)) {
						//remove the soldier
						return true;

					}
					
				}
				if((y==7 && x==6) || (y==6 && x==7)) {
					if( ((Board[x-1][y-1].getSoldierColor())==(Soldier_COLOR_AtSquare.WHITE) && Board[x-2][y-2].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY)) {
						//remove the soldier
						return true;

					}
					
				}
			
						if(x==0 || x==1)  {
							if( ((Board[x+1][y-1].getSoldierColor())==(Soldier_COLOR_AtSquare.WHITE) && Board[x+2][y-2].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY)) {
								//remove the soldier
								return true;

							}
							if( ((Board[x+1][y+1].getSoldierColor())==(Soldier_COLOR_AtSquare.WHITE) && Board[x+2][y+2].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY)) {
								//remove the soldier
								return true;

							}
							
						}
						
						if(x==6 || x==7)  {
							if(((Board[x-1][y-1].getSoldierColor())==(Soldier_COLOR_AtSquare.WHITE) && Board[x-2][y-2].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY)) {
								//remove the soldier
								return true;

							}
							if(((Board[x-1][y+1].getSoldierColor())==(Soldier_COLOR_AtSquare.WHITE) && Board[x-2][y+2].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY)) {
								//remove the soldier
								return true;
	
							}
							
						}
						if((x>1&& x<6) && (y>1&& y<6)) {
							//left up
							if( ((Board[x-1][y-1].getSoldierColor())==(Soldier_COLOR_AtSquare.WHITE) && Board[x-2][y-2].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY)) {
								//remove the soldier
								return true;

							}
							//righ up
							if( ((Board[x-1][y+1].getSoldierColor())==(Soldier_COLOR_AtSquare.WHITE) && Board[x-2][y+2].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY)) {
								//remove the soldier
								return true;

							}
							//left down
							if( ((Board[x+1][y-1].getSoldierColor())==(Soldier_COLOR_AtSquare.WHITE) && Board[x+2][y-2].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY)) {
								//remove the soldier
								return true;

							}
							// right down
							if( ((Board[x+1][y+1].getSoldierColor())==(Soldier_COLOR_AtSquare.WHITE) && Board[x+2][y+2].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY)) {
								//remove the soldier
								return true;

								
							}
							
						}
			
			}
			//case the soldier is white Queen
			/*else if(s.isIsQueen()==true) {
				for(int i=0;i<g.getWhitePieces().length;i++) {
					if(g.getWhitePieces()[i].getLocation().getX()==x && g.getWhitePieces()[i].getLocation().getY()==y) {
							MoveBlackQueen(sourcex,sourcey,targetx ,targety,i);
					}
				}
				
				/*
				//case the queen is moving up right
				   if(x>0) {
				while( Board[x-1][y+1].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY) {
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
				   }
				//check if the soldier near is a rival soldier and there is an empty square after him.
				if(Board[x][y].getSoldierColor()==Soldier_COLOR_AtSquare.BLACK && Board[x-1][y+1].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY)
					return true;
				//case the queen is moving up left
				if(x>0 & y>0) {
				while(Board[x-1][y-1].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY) {
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
				}
				//check if the soldier near is a rival soldier and there is an empty square after him.
				if(Board[x][y].getSoldierColor()==Soldier_COLOR_AtSquare.BLACK && Board[x-1][y-1].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY)
					return true;
				//case the queen is moving right down
				if(x<7 && y<7) {
				while(Board[x+1][y+1].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY) {
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
			}
				//check if the soldier near is a rival soldier and there is an empty square after him.
				if(Board[x][y].getSoldierColor()==Soldier_COLOR_AtSquare.BLACK && Board[x+1][y+1].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY)
					return true;
				//case the queen is moving left down
				if(y>0) {
				while(Board[x+1][y-1].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY) {
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
				}
				//check if the soldier near is a rival soldier and there is an empty square after him.
				if(Board[x][y].getSoldierColor()==Soldier_COLOR_AtSquare.BLACK && Board[x+1][y-1].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY)
					return true;
			
			}*/
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
							if(x+1<8 && y+1<8 && Board[x+1][y-1].getSoldierColor()!=Soldier_COLOR_AtSquare.EMPTY)
								countBlockedSoldier++;
						}
						else if(x==7 && y==0) {
							if(x+1<8 && y+1<8 && Board[x-1][y+1].getSoldierColor()!=Soldier_COLOR_AtSquare.EMPTY)
								countBlockedSoldier++;
						}
						else if(y==0) {
							//Checking if the soldiers of the first column is blocked  from two directions UP and DOWN
							if(x+1<8 && y+1<8 && Board[x-1][y+1].getSoldierColor()!=Soldier_COLOR_AtSquare.EMPTY && Board[x+1][y+1].getSoldierColor()!=Soldier_COLOR_AtSquare.EMPTY)
								countBlockedSoldier++;
						}
						else if(y==7) {
							//Checking if the soldiers of the last column is blocked  from two directions UP and DOWN
							if(x+1<8 && y+1<8 && Board[x-1][y-1].getSoldierColor()!=Soldier_COLOR_AtSquare.EMPTY && Board[x+1][y-1].getSoldierColor()!=Soldier_COLOR_AtSquare.EMPTY)
								countBlockedSoldier++;
						}
						else{
							
							if(x==0  && Board[x+1][y-1].getSoldierColor()!=Soldier_COLOR_AtSquare.EMPTY 
									 &&Board[x+1][y+1].getSoldierColor()!=Soldier_COLOR_AtSquare.EMPTY)
								countBlockedSoldier++;
							else
							{

								if(x+1<8 && y+1<8 && x<8 && y<8 && x>0 && y>0 &&  Board[x-1][y-1].getSoldierColor()!=Soldier_COLOR_AtSquare.EMPTY && Board[x+1][y-1].getSoldierColor()!=Soldier_COLOR_AtSquare.EMPTY 
									&& Board[x-1][y+1].getSoldierColor()!=Soldier_COLOR_AtSquare.EMPTY &&Board[x+1][y+1].getSoldierColor()!=Soldier_COLOR_AtSquare.EMPTY)
								countBlockedSoldier++;
						}
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
							if(x+1<8 && y+1<8 && Board[x+1][y-1].getSoldierColor()!=Soldier_COLOR_AtSquare.EMPTY)
								countBlockedSoldier++;
						}
						else if(x==7 && y==0) {
							if(x+1<8 && y+1<8 && Board[x-1][y+1].getSoldierColor()!=Soldier_COLOR_AtSquare.EMPTY)
								countBlockedSoldier++;
						}
						else if(y==0) {
							//Checking if the soldiers of the first column is blocked  from two directions UP and DOWN
							if(x+1<8 && y+1<8 && Board[x-1][y+1].getSoldierColor()!=Soldier_COLOR_AtSquare.EMPTY && Board[x+1][y+1].getSoldierColor()!=Soldier_COLOR_AtSquare.EMPTY)
								countBlockedSoldier++;
						}
						else if(y==7) {
							//Checking if the soldiers of the last column is blocked  from two directions UP and DOWN
							if(x+1<8 && y+1<8 && Board[x-1][y-1].getSoldierColor()!=Soldier_COLOR_AtSquare.EMPTY && Board[x+1][y-1].getSoldierColor()!=Soldier_COLOR_AtSquare.EMPTY)
								countBlockedSoldier++;
						}
						else {  
							if(y+1<8 && x+1<8 && x>0 && y>0 && Board[x-1][y-1].getSoldierColor()!=Soldier_COLOR_AtSquare.EMPTY && Board[x+1][y-1].getSoldierColor()!=Soldier_COLOR_AtSquare.EMPTY 
									&& Board[x-1][y+1].getSoldierColor()!=Soldier_COLOR_AtSquare.EMPTY &&Board[x+1][y+1].getSoldierColor()!=Soldier_COLOR_AtSquare.EMPTY)
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
	public String resultstoString() {
		return "Game [GameDate=" + GameDate + ",time=" + QueueTime + ", blackPlayer=" + blackNic + "whitep="+whiteNic+" Bpoint:"+blackPoints+"wpoint"+whitePoint+"}";
	}


}