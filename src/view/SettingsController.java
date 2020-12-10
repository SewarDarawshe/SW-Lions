package view;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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
	private TableView<Question> questionsTable=new TableView<>();

	@FXML
	private TableColumn<Question, Integer> questionIDColumn=new TableColumn<>();

	@FXML
	private TableColumn<Question, String> questionColumn=new TableColumn<>();

	@FXML
	private TableColumn<Question, E_Difficulty> questionDifficultyColumn=new TableColumn<>();

	@FXML
	private TableView<Answer> answersTable=new TableView<>();

	@FXML
	private TableColumn<Answer, Integer> answerIDColumn=new TableColumn<>();

	@FXML
	private TableColumn<Answer, String> answerColumn=new TableColumn<>();

	@FXML
	private TableColumn<Answer, Boolean> isCorrectColumn=new TableColumn<>();


	protected ArrayList<Question> questions=null;

	protected Question question;


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
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}



	protected void setQuestionTable() {
		questions = Controllers.Sysdata.getInstance().getQuestionsarr();
		for(Question q:questions)
			System.out.println(q);

		ObservableList<Question> qs = FXCollections.observableArrayList(questions);
		questionsTable.setItems(qs);

		questionsTable.refresh();
		setAnswerTable();		
	}

	private void setAnswerTable() {
		question = questionsTable.getSelectionModel().getSelectedItem();
		if (question != null) {

			ArrayList<Answer> answers = question.getAnswers();
			ObservableList<Answer> ans = FXCollections.observableArrayList(answers);
			answersTable.setItems(ans);
		}
		else {
			answersTable.getItems().clear();
		}
		answersTable.refresh();
	}	


	@FXML
	void addQuestion(ActionEvent event) {

	}

	@FXML
	void deleteQuestion(ActionEvent event) {

	}



	@FXML
	void updateQuestion(ActionEvent event) {

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		questionIDColumn.setCellValueFactory(new PropertyValueFactory<>("number")); // According to variable name
		questionColumn.setCellValueFactory(new PropertyValueFactory<>("text")); // Same here
		questionDifficultyColumn.setCellValueFactory(new PropertyValueFactory<>("difficulty")); // Same here

		answerIDColumn.setCellValueFactory(new PropertyValueFactory<>("answerID")); // According to variable name
		answerColumn.setCellValueFactory(new PropertyValueFactory<>("content")); // Same here
		isCorrectColumn.setCellValueFactory(new PropertyValueFactory<>("isCorrect")); // Same here

		// initialize the Question list to appear in the table
		setQuestionTable();		
	}
}
