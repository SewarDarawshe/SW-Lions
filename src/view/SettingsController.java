package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class SettingsController {

    @FXML
    private AnchorPane Pane;

    @FXML
    private Pane pane;

    @FXML
    private Button DeletegamehistoryBTN;

    @FXML
    private Button HomeBTN;

    @FXML
    private Button soundBTN;

    @FXML
    private Button manageQueBTN;
    

    public void start(Stage primaryStage) {
		try {

			Parent root = FXMLLoader.load(getClass().getResource("/view/Settings.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setTitle("Settings");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}



    @FXML
    void Exit(ActionEvent event) {
		((Stage) Pane.getScene().getWindow()).close();

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

    @FXML
    void openManageQue(ActionEvent event) {
    	Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
		ManageQuestionsController temp=new ManageQuestionsController();
		try {
			temp.start(stage);
		} catch (Exception e) {
			// TODO: handle exception
		}
    }

}
