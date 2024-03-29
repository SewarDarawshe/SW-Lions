package view;



import java.time.Duration;
import java.time.LocalTime;

import javafx.application.Platform;

public class TimerThread extends Thread {
	private boolean isPaused;
	private Duration tmpDuration = Duration.ofNanos(0);
	private LocalTime startCountTime;
	private TimerInterface timer;

	public TimerThread(TimerInterface timer) {
		this.timer=timer;
		timer.start();
		isPaused = false;
	}

	public void pause() {
		isPaused = true;
	}

	public void resumeTimer() {
		isPaused = false;
		startCountTime = LocalTime.now();
		synchronized (this) {
			this.notify();
		}

	}

	@Override
	public void run() {
		startCountTime = LocalTime.now();
		while (true) {
			synchronized (this) {
				if (isPaused) {
					try {
						tmpDuration = Duration.between(startCountTime, LocalTime.now()).plus(tmpDuration);
						wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
						return;
					}

				}
			}

	
			Platform.runLater(new Runnable() {

				@Override
				public void run() {
					try {
						timer.SetDuration(Duration.between(startCountTime, LocalTime.now()).plus(tmpDuration));
					} catch (Exception e) {
						return;
					}
				}
			});
			try {
				Thread.sleep(100L);
			} catch (InterruptedException e) {
				return;
			}

		}

	}

	public boolean isPaused() {
		return isPaused;
	}

}