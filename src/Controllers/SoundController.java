package Controllers;

import java.io.IOException;

import java.io.InputStream;
import java.net.URL;
import java.util.Random;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;


import Controllers.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import utils.Sound;
import view.MainBoardController;
import view.ManageQuestionsController;
/**
 * Class public class SoundController - controlling the sound's
 * 
 * @author Sewar Drawshe
 * 
 * 
 */
public class SoundController {
	private static boolean soundFX = true;
	public static Clip clip;
	private static MainBoardController MainBoardController;
	/**
	 * this method returns the boolean value of soundfx which means weather the
	 * soundfx is turned on or off
	 * 
	 * @return boolean
	 */
	public static boolean isSoundFX() {
		return soundFX;
	}

	/**
	 * @param soundFX
	 */
	public static void setSoundFX(boolean soundFX) {
		SoundController.soundFX = soundFX;
	}

	/**
	 * This method gets the path of the sound in the system, and controls its volume
	 * 
	 * @param soundFilePath
	 * @param volume
	 */
	public static void playSound(URL soundFilePath, double volume) {
		new Thread(new Runnable() {

			@Override
			public void run() {
				try {
				
					String soundFile = soundFilePath.toString();
					Media media = new Media(soundFile);
					MediaPlayer mp = new MediaPlayer(media);
					mp.setVolume(volume);
					mp.play();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();
	}

	/**
	 * This method plays the background music
	 */
	public static void playMusic() {
		try {
			String musicFile = "";
			musicFile = Sound.Background_MUSIC;

			getMainBoardController().setMusic(true);
			InputStream audioFile = Sound.class.getResourceAsStream(musicFile);
			AudioInputStream sound = AudioSystem.getAudioInputStream(audioFile);

			clip = AudioSystem.getClip();
			clip.open(sound);
			clip.loop(Clip.LOOP_CONTINUOUSLY);
		
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method stops the background music
	 */
	public static void stopMusic() {
		if (clip != null)
			clip.stop();
	}

	/**
	 * This method plays the eating sound
	 */
	public static void playEatingSound() {
		//if (soundFX)
		//	playSound(Sound.class.getResource(Sound.EATING_SOUND), 80);
	}

	/**
	 * This method plays the hitting sound
	 */
	public static void playHitingSound() {
	//	if (soundFX)
		//	playSound(Sound.class.getResource(Sound.HIT_SOUND), 80);
	}

	/**
	 * this method starts or stops the background music by the boolean it takes
	 * 
	 * @param bool
	 */
	public static void toggleMusic(boolean bool) {
		if (bool)
			playMusic();
	}

	/**
	 * this method starts or stops the eating sound by the boolean it takes
	 * 
	 * @param bool
	 */
	public static void toggleSoundFX(boolean bool) {
		setSoundFX(bool);

	}

	public static MainBoardController getMainBoardController() {
		return MainBoardController;
	}

	public static void setMainBoardController(MainBoardController mainBoardController) {
		MainBoardController = mainBoardController;
	}
	
	
	
	

}
