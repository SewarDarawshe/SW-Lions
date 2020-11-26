package Model;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

import Model.Player;
import utils.E_Difficulty;

public class Game {
	private Square[][] Board=new Square[8][8];
	private Question[] Questions=new Question[32];
	private Date GameDate;
	private Player whitePlayer;
	private Player blackPlayer;
	private Time QueueTime;
	private Soldier[] WhitePieces=new Soldier[12];
	private Soldier[] BlackPieces=new Soldier[12];
	private Square[] BlackSquares=new Square[32];

//---------------------------Constructor----------------------
	
	
	public Game(Square[][] board,Player white,Player black, Model.Question[] questions, Date gamedate, Time queueTime, Soldier[] soldier1, Soldier[] soldier2, Square[] blackSquares) {
		super();
		Board = board;
		Questions = questions;
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
	
	public Question[] getQuestions() {
		return Questions;
	}
	public void setQuestions(Question[] questions) {
		Questions = questions;
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
	}
	
	public void AddPlayer(String wp,String bp)
	{
		Player whitePlayer = new Player(wp,0);
		Player blackPlayer = new Player(bp,0);


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
		Queen q= new Queen(s.isIsAlive(),true,s.getLocation());
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

	@Override
	public String toString() {
		return "Game [GameDate=" + GameDate + ", whitePlayer=" + whitePlayer + ", blackPlayer=" + blackPlayer + "]";
	}
	

}
