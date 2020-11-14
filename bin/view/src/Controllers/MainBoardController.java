package Controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MainBoardController implements Initializable {

	@FXML
	private Button letsPlayButton;

	@FXML
	void Exit(ActionEvent event) {

	}

	@FXML
	void OpenHowToPlay(ActionEvent event) {

	}

	@FXML
	void OpenNicknamesScreen(ActionEvent event) {
		Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
		NicknamesController temp=new  NicknamesController();
		try {
			temp.start(stage);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@FXML
	void OpenResultsBoard(ActionEvent event) {

	}

	@FXML
	void OpenSettings(ActionEvent event) {

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

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
		}

	}
}
