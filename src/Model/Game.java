package Model;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

import Model.Player;
import utils.E_Difficulty;

public class Game {
	
	public static final char BLACK='1';	//represents a black piece
	public static final char WHITE='2';	//represents a white piece
	public static final char QUEEN='3';	//represents a queen piece

	public static final char EMPTY='0';	//board position is empty

	public static final char LEFT='l';	//a left move
	public static final char RIGHT='r';	//a right move

	private Square[][] Board=new Square[8][8];
	private ArrayList<Player> Players=new ArrayList<>();
	private Question[] Questions=new Question[32];
	private Time GameTime;
	private int PPoint1;
	private int PPoint2;
	private Time QueueTime;
	private Soldier[] WhitePieces=new Soldier[12];
	private Soldier[] BlackPieces=new Soldier[12];
	private Square[] BlackSquares=new Square[32];

//---------------------------Constructor----------------------
	
	
	public Game(Square[][] board, ArrayList<Player> players, Model.Question[] questions, Time gameTime, int pPoint1,
			int pPoint2, Time queueTime, Soldier[] soldier1, Soldier[] soldier2, Square[] blackSquares) {
		super();
		Board = board;
		Players = players;
		Questions = questions;
		GameTime = gameTime;
		PPoint1 = pPoint1;
		PPoint2 = pPoint2;
		QueueTime = queueTime;
		WhitePieces = soldier1;
		BlackPieces = soldier2;
		BlackSquares = blackSquares;
	}
	//---------------Getters and Setters--------------------------
	
	

	public Square[][] getBoard() {
		return Board;
	}
	public void setBoard(Square[][] board) {
		Board = board;
	}
	public ArrayList<Player> getPlayers() {
		return Players;
	}
	public void setPlayers(ArrayList<Player> players) {
		Players = players;
	}
	public Question[] getQuestions() {
		return Questions;
	}
	public void setQuestions(Question[] questions) {
		Questions = questions;
	}
	public Time getGameTime() {
		return GameTime;
	}
	public void setGameTime(Time gameTime) {
		GameTime = gameTime;
	}
	public int getPPoint1() {
		return PPoint1;
	}
	public void setPPoint1(int pPoint1) {
		PPoint1 = pPoint1;
	}
	public int getPPoint2() {
		return PPoint2;
	}
	public void setPPoint2(int pPoint2) {
		PPoint2 = pPoint2;
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
		for(int i=0;i<WhitePieces.length;i++)
		{
			WhitePieces[i].setIsAlive(true);			
			
		}
		
		for(int i=0;i<BlackPieces.length;i++)
		{
			BlackPieces[i].setIsAlive(true);			
			
		}
        Player player1=new Player(null, 0);
        Player player2=new Player(null, 0);
        Players.add(player1);
        Players.add(player2);

        
     
        for (int x=0; x<8; x++)
         
        	for (int z=0; z<8; z++)
          
            Board[x][z].setNumber(EMPTY);
          
        	

	  	Board[0][0].setNumber(WHITE);Board[2][0].setNumber(WHITE);Board[4][0].setNumber(WHITE);Board[6][0].setNumber(WHITE);
	  	Board[1][1].setNumber(WHITE);Board[3][1].setNumber(WHITE);Board[5][1].setNumber(WHITE);Board[7][1].setNumber(WHITE);
	  	Board[0][2].setNumber(WHITE);Board[2][2].setNumber(WHITE);Board[4][2].setNumber(WHITE);Board[6][2].setNumber(WHITE);

	  	Board[1][7].setNumber(BLACK);Board[3][7].setNumber(BLACK);Board[5][7].setNumber(BLACK);Board[7][7].setNumber(BLACK);
	  	Board[0][6].setNumber(BLACK);Board[2][6].setNumber(BLACK);Board[4][6].setNumber(BLACK);Board[6][6].setNumber(BLACK);
	  	Board[1][5].setNumber(BLACK);Board[3][5].setNumber(BLACK);Board[5][5].setNumber(BLACK);Board[7][5].setNumber(BLACK);
	}
	
	public void AddPlayer(String wp,String bp)
	{
		new Player(wp,0);
		new Player(bp,0);

        
	}
	
	public void StartGame()
	{
		//To do
	}
	
	public void FinishGame()
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
	
	public void returnSoldier()
	{
		//To do
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
		new Queen(s.isIsAlive(),true,s.getLocation());
	}
	
	public void chooseQuestion(E_Difficulty diff)
	{
	//To do
	
	}
	
	public void removeQuestion()
	{
		//To do
	}
	
	public boolean IsEatable()
	{
		//To do
		return false;
	}
	
	public boolean IsBlocked()
	{
		//To do
		return false;
	}
	

}
