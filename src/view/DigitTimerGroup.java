package view;

import java.time.Duration;



import javafx.scene.text.Text;
import view.TimerInterface;

public class DigitTimerGroup implements TimerInterface {
	private Duration duration;
	private Text text;
	
	
	public DigitTimerGroup(Text GameTimer) {
		this.text=GameTimer;
		start();
	}

	@Override
	public void SetDuration(Duration duration) {
		// TODO Auto-generated method stub
		text.setText(formatDuration(duration));
		
	}
	@Override
	public void nexLap() {
		// TODO Auto-generated method stub
		
		text.setDisable(false);
		
		
	}
	
	public static String formatDuration(Duration duration) {
		long seconds = duration.getSeconds();
		long absSeconds = Math.abs(seconds);
		int nanos = duration.getNano();
		String positive = String.format("%d:%02d:%02d", absSeconds / 3600, (absSeconds % 3600) / 60,
				absSeconds % 60, nanos / 1000000);
		return positive;
	}
	@Override
	public void start() {
		// TODO Auto-generated method stub
		duration = Duration.ofNanos(0);
		text.setText(formatDuration(duration));
	text.getParent().layout();
		
	}
}
