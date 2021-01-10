package view;

import java.net.URL;

import java.util.ResourceBundle;

import Controllers.*;
import Controllers.SoundController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MainBoardController implements Initializable {

    @FXML
    private ToggleButton MusicBTN;
	protected static ManageQuestionsController ManageQuestions;
	protected static BoardGameController BoardGame;
	private boolean music = true;
	private boolean soundfx = true;

	public boolean isMusic() {
		return music;
	}

	public void setMusic(boolean music) {
		this.music = music;
		if(music)MusicBTN.setGraphic(new ImageView("/resources/goOff.png"));
		else MusicBTN.setGraphic(new ImageView("/resources/goOn.png"));
			
	}
	public boolean isSoundfx() {
		return soundfx;
	}

	public void setSoundfx(boolean soundfx) {
		this.soundfx = soundfx;
		SoundController.setSoundFX(soundfx);
	}
	@FXML
	private Button letsPlayButton;
	@FXML
	private AnchorPane Pane;
	  

	@FXML
	void Exit(ActionEvent event) {
		((Stage) Pane.getScene().getWindow()).close();


	}

	@FXML
	void OpenHowToPlay(ActionEvent event) {
		Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
		HowToPlayController temp=new HowToPlayController();
		try {
			HowToPlayController.setMainBoardController(this);
			temp.start(stage);	
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	@FXML
	void OpenNicknamesScreen(ActionEvent event) {
		Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
		NicknamesSetUpController temp=new NicknamesSetUpController();
		try {
			NicknamesSetUpController.setMainBoardController(this);
			temp.start(stage);	
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	@FXML
	void OpenResultsBoard(ActionEvent event) {
		Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
		ResultsBoardController temp=new ResultsBoardController();
		try {
			ResultsBoardController.setMainBoardController(this);
			temp.start(stage);	
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	@FXML
	void OpenSettings(ActionEvent event) {
		Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
		SettingsController temp=new SettingsController();
		try {
			SettingsController.setMainBoardController(this);
			temp.start(stage);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		SoundController.setMainBoardController(this);
		
		setMusic(true);

	}
	@FXML
	void soundControl(ActionEvent event) {
		
	if(isMusic())
	{
		SoundController.stopMusic();
		setMusic(false);
		
	}else {
		setMusic(true);
		SoundController.playMusic();
		
		

	}

	}

	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/view/MainBoardScreen.fxml"));
			Scene scene = new Scene(root);
			// scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}//test

	}
}
