package Model;

import java.sql.Time;
import java.util.ArrayList;

public class Game {

	//------------------------------class member------------------
	
    private Square [][] Board= new Square[8][8];
    private ArrayList<Player> Players=new ArrayList<>();
    private Questions [] Questions=new Questions[];
    private Time GameTime;
    private int PPoint1;
    private int PPoint2;
    private Time QueueTime;
    private Soldier[] Soldiers1 = new Soldier[12];
    private Soldier[] Soldiers2 = new Soldier[12];
    private Square[] BlackSquare= new Square[32];
    
    
    //----------------------------Construcutors --------------------
    
    public Game(Square[][] Board,ArrayList<Player> Players,Questions[] Questions,
    		Time GameTime, int PPoint1,int PPoint2,Time QueueTime,Soldier[] Soldiers1,
    		Soldier[] Soldiers2,Square[] BlackSquare) {
    	
    	
    super();
    this.Board=Board;
    this.Players=Players;
    this.Questions=Questions;
    this.GameTime=GameTime;
    this.PPoint1=PPoint1;
    this.PPoint2=PPoint2;
    this.Soldiers1=Soldiers1;
    this.Soldiers2=Soldiers2;
    this.BlackSquare=BlackSquare;
    }
    //--------------------------Geters and Seters-----------------------
    
    public Square[] getBoard()
    {
    	return Board;
    }
    
    public void setBoard(Square[][] Board)
    {
    	this.Board=Board;
    }
    
    public ArrayList<Player> getPlayers()
    {
    	return Players;
    }
    
    public void setPlayers(ArrayList<Player> Players)
    {
    	this.Players=Players;
    }
    
    public Questions[] getQusetions()
    {
    	return Questions;
    }
    
    public void setQuestions(Questions[] Questions)
    {
    	this.Questions=Questions;
    }
    
    public Time getGameTime()
    {
	return GameTime;
    }
    
    public void setGameTime(Time GameTime)
    {
    	this.GameTime=GameTime;
    }
    
    public int getPPoint1()
    {
        return PPoint1;
    }
    
    public void setPPoint1(int PPoint1)
    {
    	this.PPoint1=PPoint1;
    }
    
    public int getPPoint2()
    {
        return PPoint2;
    }
    
    public void setPPoint2(int PPoint2)
    {
    	this.PPoint2=PPoint2;
    }
    
    public Time getQueueTime()
    {
	return QueueTime;
    }
    
    public void setQueueTime(Time QueueTime)
    {
    	thisQueueTime=QueueTime;
    }
    
    public Soldier[] getSoldiers1()
    {
    	return Soldiers1;
    }
    
    public void setSoldiers1(Soldier[] Soldiers1)
    {
    	this.Soldiers1=Soldiers1;
    }
    
    public Soldier[] getSoldiers2()
    {
    	return Soldiers2;
    }
    
    public void setSoldiers2(Soldier[] Soldiers2)
    {
    	this.Soldiers2=Soldiers2;
    }
    
    public Square[] getBlackSquare()
    {
    	return BlackSquare;
    }
    
    public void setBlackSquare(Square[] BlackSquare)
    {
    	this.BlackSquare=BlackSquare;
    }
//------------------------------------Methods---------------------
    public void initiateGame()
    {
    	//To Do
    }
    
    public void AddPlayer()
    {
    	//To Do
    }
    
    public void StartGame()
    {
    	//To Do
    }
    
    public void StopGame()
    {
    	//To Do
    }
    
    public void FinishGame()
    {
    	//To Do
    }
    
    public void PauseGame()
    {
    	//To Do
    }
    
    public void resumeGame()
    {
    	//To Do
    }
    
    public void returnSoldier()
    {
    	//To Do
    }
    
    public void removeSoldier()
    {
    	//To Do
    }
    
    public void SolderTurnToQueen()
    {
    	//To Do
    }
    
    public void chooseQuestion()
    {
    	//To Do
    }
    
    public void removeQuestion()
    {
    	//To Do
    }
    
    public Boolean IsEatable()
    {
    	return false;
    }
    
    public Boolean IsBlocked()
    {
    	return false;
    }
    



}
