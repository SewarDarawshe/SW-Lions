package view;

import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

import Controllers.Sysdata;
import Model.Answer;
import Model.Question;
import utils.E_Difficulty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class SettingsController  implements Initializable {
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
	private TableColumn<Answer, String> answerColumn;

	@FXML
	private TableColumn<Answer, Boolean> isCorrectColumn;


	protected ArrayList<Question> questions;

	public Question question;
	@FXML
	private Button showAnswers;

	
	@FXML
	private Label erorLabel;
	
	
	
	
	// Methods
	// to start the window
	public void start(Stage primaryStage) {
		try {

			Parent root = FXMLLoader.load(getClass().getResource("/view/SettingsScreen.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setTitle("Home Page");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		MainBoardController.SettingsController=this;
		questionIDColumn.setCellValueFactory(new PropertyValueFactory<>("number")); // According to variable name
		questionColumn.setCellValueFactory(new PropertyValueFactory<>("text")); // Same here
		questionDifficultyColumn.setCellValueFactory(new PropertyValueFactory<>("difficulty")); // Same here

		answerColumn.setCellValueFactory(new PropertyValueFactory<>("text")); // Same here


		// initialize the Question list to appear in the table
		setQuestionTable();		
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
	void exit(ActionEvent event) {
		((Stage) Pane.getScene().getWindow()).close();

	}
	@FXML
	void deleteQuestion(ActionEvent event) {
		Question q = questionsTable.getSelectionModel().getSelectedItem();
		// a question wasn't selected
		if (q == null)
			erorLabel.setText("Please select a question to delete.");

		else {
			// set the alert's properties
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Information Dialog");
			alert.setHeaderText("Are you sure you want to delete this question?");
			alert.setContentText("\""+q.getText()+"\"");
			ButtonType buttonTypeYes = new ButtonType("Yes", ButtonData.YES);
			ButtonType buttonTypeNo = new ButtonType("No", ButtonData.NO);
			alert.getButtonTypes().setAll(buttonTypeYes, buttonTypeNo);
			Optional<ButtonType> answer = alert.showAndWait();

			// yes was pressed, so we delete the question
			if (answer.get().getButtonData() == ButtonData.YES) {
				try {
					Sysdata.getInstance().removeQuestion(q);
					setQuestionTable();
					erorLabel.setText("Question deleted successfully.");
				} catch (Exception e) {
					erorLabel.setText("Question cannot be deleted.");
				}
			}
		}
	}
	@FXML
	void addQuestion(ActionEvent event) {
		question = null;
		Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
		AddUpdate_QueController temp=new AddUpdate_QueController();
		try {
			temp.start(stage,question);	
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
	
	@FXML
	void updateQuestion(ActionEvent event) {
		question = questionsTable.getSelectionModel().getSelectedItem();

		if (question == null)
			erorLabel.setText("Please select a question to update.");
		else
		{
			Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
			stage.close();
			AddUpdate_QueController temp=new AddUpdate_QueController();
			try {



				temp.setq(question);
				temp.start(stage,question);	
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

	}
	@FXML
	void showAnswers(ActionEvent event) {
		question = questionsTable.getSelectionModel().getSelectedItem();
		if (question != null) {

			ArrayList<Answer> answers = question.getAnswers();
			ObservableList<Answer> ans = FXCollections.observableArrayList(answers);
			answersTable.setItems(ans);
		}
		else {
			erorLabel.setText("please select a question first!");

			answersTable.getItems().clear();
		}

		answersTable.refresh();
	}
	

	public void setQuestionTable() {
		questions = Controllers.Sysdata.getInstance().getQuestionsarr();
		ObservableList<Question> qs = FXCollections.observableArrayList(questions);
		questionsTable.setItems(qs);
		questionsTable.refresh();

	}
	

	public Question getQue()
	{
		return this.question;
	}


}
