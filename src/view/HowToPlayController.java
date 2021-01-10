package view;

import java.net.URL;

import java.util.ResourceBundle;

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
import javafx.stage.Stage;

public class HowToPlayController implements Initializable{

	@FXML
	private Button HomePageButton;

	@FXML
	private Button ExitButton;
	@FXML
	private AnchorPane Pane;
	 @FXML
	    private ToggleButton MusicBTN;
	 private boolean music = true;
	
	   
		public boolean isMusic() {
			return music;
		}

		public void setMusic(boolean music) {
			this.music = music;
			if(music)MusicBTN.setGraphic(new ImageView("/resources/goOff.png"));
			else MusicBTN.setGraphic(new ImageView("/resources/goOn.png"));
				
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


	private static MainBoardController MainBoardController;
	public static MainBoardController getMainBoardController() {
		return MainBoardController;
	}

	public static void setMainBoardController(MainBoardController mainBoardController) {
		MainBoardController = mainBoardController;
	}
	


	@FXML
	void Exit(ActionEvent event) {
		((Stage) Pane.getScene().getWindow()).close();

	}


	@FXML
	void OpenHomePage(ActionEvent event) {
		Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
		MainBoardController temp=new MainBoardController();
		try {
			temp.start(stage);	
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		if(MainBoardController.isMusic())
		{
			setMusic(true);
		}else 			
			setMusic(false);
		MusicBTN.setText("");
	}
	
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/view/HowtoPlayScreen.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setTitle("How To Play");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
