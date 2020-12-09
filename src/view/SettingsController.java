package view;

import java.util.ArrayList;

import Model.Answer;
import Model.Question;
import utils.E_Difficulty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class SettingsController {
	@FXML
    private AnchorPane Pane;

    @FXML
    private Pane pane;

    @FXML
    private Button deleteBtn;

    @FXML
    private Button updateBtn;

    @FXML
    private Button addBtn;

    @FXML
    private Button exitbutton;

    @FXML
    private Button homepageButton;

    @FXML
    private TableView<Question> questionsTable;

    @FXML
    private TableColumn<Question, Integer> questionIDColumn;

    @FXML
    private TableColumn<Question, String> questionColumn;

    @FXML
    private TableColumn<Question, E_Difficulty> questionDifficultyColumn;

    @FXML
    private TableView<Answer> answersTable;

    @FXML
    private TableColumn<Answer, Integer> answerIDColumn;

    @FXML
    private TableColumn<Answer, String> answerColumn;

    @FXML
    private TableColumn<Answer, Boolean> isCorrectColumn;
    
    
	protected ArrayList<Question> questions;
	
    @FXML
    private Label erorLabel;

	    @FXML
	    void exit(ActionEvent event) {
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
