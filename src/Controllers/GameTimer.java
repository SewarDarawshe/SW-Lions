

package Controllers;

import java.util.Timer;
import java.util.TimerTask;

import java.util.concurrent.Future;


import utils.E_TimerStatus;
import utils.GameState;

/**
 * 
 * A abstract timer utility class, that supports pause and resume.
 * 
 * Can be used either as a normal timer or a countdown timer.
 * 
 * @author ethar bakir
 * 
 */
public abstract class GameTimer {
	
	
	public static final int DURATION_INFINITY = -1;
	private volatile boolean isRunning = false;
	private long interval;
	private long elapsedTime;
	private long duration;
	//private ScheduledExecutorService execService = Executors
	//		.newSingleThreadScheduledExecutor();
	private Future<?> future = null;
	private E_TimerStatus Status;
	

	/**
	 * Default constructor which sets the interval to 1000 ms (1s) and the
	 * duration to {@link TimerGame#DURATION_INFINITY}
	 */
	public GameTimer() {
		this(1000, -1);
	}

	/**
	 * @param interval
	 *            The time gap between each tick in millis.
	 * @param duration
	 *            The period in millis for which the timer should run. Set it to {@code Timer#DURATION_INFINITY} if the timer has to run indefinitely.
	 */
	public GameTimer(long interval, long duration) {
		this.interval = interval;
		this.duration = duration;
		this.elapsedTime = 0;
	}

	/**
	 * Starts the timer. If the timer was already running, this call is ignored.
	 */
	
	Timer timer=new Timer();
    TimerTask timerTask=new TimerTask() {
		
		@Override
		public void run() {
         elapsedTime++;		
         System.out.println(elapsedTime);
		}
	}; 
	
	public void start() {
		if (isRunning)
			return;

		isRunning = true;
		Status= E_TimerStatus.RUNNING;
		
	
		timer.scheduleAtFixedRate(timerTask, 1000, 1000);
		
	}

	
	/**
	 * Paused the timer. If the timer is not running, this call is ignored.
	 */
	public void pause() {
		if(!isRunning) return;
		future.cancel(false);
		isRunning = false;
		Status= E_TimerStatus.PAUSED;

	}

	
	/**
	 * Resumes the timer if it was paused, else starts the timer.
	 */
	public void resume() {
		this.start();

	}

	
	
	/**
	 * Stops the timer. If the timer is not running, then this call does nothing.
	 */
	public void cancel() {
		pause();
		this.elapsedTime = 0;
	}

	
	/**
	 * @return the elapsed time (in millis) since the start of the timer.
	 */
	public long getElapsedTime() {
		return this.elapsedTime;
	}
	
	/**
	 * @return the time remaining (in millis) for the timer to stop. If the duration was set to {@code Timer#DURATION_INFINITY}, then -1 is returned.
	 */
	public long getRemainingTime(){
		if(this.duration <0){
			return GameTimer.DURATION_INFINITY;
		}
		else{
			return duration-elapsedTime;
		}
	}
	
	/**
	 * @return true if the timer is currently running, and false otherwise.
	 */
	public boolean isRunning() {
		return isRunning;}

}