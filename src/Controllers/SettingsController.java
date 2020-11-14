package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class SettingsController {
	 @FXML
	    private Pane pane;

	 @FXML
	    private Button exitbutton;

	    @FXML
	    private Button homepageButton;

	    @FXML
	    void exit(ActionEvent event) {
			((Stage) pane.getScene().getWindow()).close();

	    }

	@FXML
	void openHomePage(ActionEvent event) {
		Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
		MainBoardController temp=new MainBoardController();
		try {
		temp.start(stage);	
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/view/SettingsScreen.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setTitle("Home Page");
			// scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
