package view;

import java.time.Duration;

public abstract interface TimerInterface {
	
	public void SetDuration(Duration duration);
	public void nexLap();
	public void start();
	public void reset();
	

}