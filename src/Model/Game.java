package Model;

import java.sql.Time;
import java.util.ArrayList;

public class Game {
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
	}
	
	public void AddPlayer()
	{
		//To do
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
	
	public void removeSoldier()
	{
		//To do
	}
	
	public void soldierTurnToQueen()
	{
		//To do
	}
	
	public void chooseQuestion()
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
