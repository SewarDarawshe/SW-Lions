package Controllers;

import java.io.File;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

import Model.Answer;
import Model.Game;
import Model.Player;
import Model.Question;
import Model.Soldier;
import Model.SquareObject;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import utils.E_Difficulty;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root=FXMLLoader.load(getClass().getResource("/view/MainBoardScreen.fxml"));
			Scene scene = new Scene(root);
			
			 //Initialising path of the media file, replace this with your file path   
	       SoundController.playMusic();
	        primaryStage.setTitle("Home Page");
			primaryStage.setScene(scene);
			primaryStage.show();
	     
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		launch(args);
		
		
	}
}