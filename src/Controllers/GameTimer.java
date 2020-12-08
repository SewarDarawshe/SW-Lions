package Controllers;

import java.util.Timer;
import java.util.TimerTask;

import utils.E_TimerStatus;
import utils.player_turn;

public class GameTimer {
	
	private E_TimerStatus Status;
	private Timer timer;
	private int startTime; // the time the timer started
	private int time=60;
	private int timeLeft; // case paused, holds the left for completion
	private int timePast=0;
	
	
	
   
	
	
//take the time that the game started	
	public void start() {
		

		startTime = (int) System.currentTimeMillis() / 1000;
		Status = E_TimerStatus.RUNNING;
		
	}
	
	/**
	 * pauses the timer. keeps the time left in timeLeft
	 */
	//take the time that the time paused
	//calculate the time that based from the start until now(paused) in second
	// and put the time left for the turn into time left
	public void pause() {
		int cancelTime = (int) System.currentTimeMillis() / 1000;
		int timePast = cancelTime - startTime;
	    timeLeft = time - timePast;

		Status = E_TimerStatus.PAUSED;
		
		if (timer != null)
			timer.cancel();
		

	}
	
	public void resume() {
		timer = new Timer();

		Status = E_TimerStatus.RUNNING;
		

	}
	
	public void pointsSum()
	{
		int timePast = time - startTime;
	    timeLeft = time - timePast;
	    
	    
	     
	}
	
	/**
	 * @return gets status of the timer
	 */
	public E_TimerStatus getStatus() {
		return Status;
	}

	/**
	 * cancels the timer tasks
	 */
	public void cancel() {
		Status = utils.E_TimerStatus.STOPPED;
		if (timer != null)
			timer.cancel();
	}
	

}
