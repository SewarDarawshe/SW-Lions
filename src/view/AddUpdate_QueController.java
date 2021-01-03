package view;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.swing.ButtonGroup;

import Controllers.Sysdata;
import Model.Answer;
import Model.Question;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import utils.E_Difficulty;

public class AddUpdate_QueController implements Initializable {

	@FXML
	private AnchorPane pane;

	@FXML
	private TextField QueText;

	@FXML
	private TextField Ans1TEXT;

	@FXML
	private RadioButton Ans1RD;

	@FXML
	private TextField Ans4TEXT;

	@FXML
	private TextField Ans3TEXT;

	@FXML
	private TextField Ans2TEXT;

	@FXML
	private RadioButton Ans2RD;

	@FXML
	private RadioButton Ans3RD;

	@FXML
	private RadioButton Ans4RD;

	@FXML
	private Label erorLabel;

	@FXML
	private Button addBtn;

	@FXML
	private ComboBox<E_Difficulty> difficultyCombo;

	private Question old;
	@FXML
	private Button ReturntoSettingsBTN;

    private ButtonGroup group;

    
	public void start(Stage primaryStage,Question q) {
		try {

			Parent root = FXMLLoader.load(getClass().getResource("/view/Add-Update_Que.fxml"));

			Scene scene = new Scene(root);		
			primaryStage.setTitle("Add-Update Page");
			primaryStage.setScene(scene);
			primaryStage.show();


		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		//	old = SettingsController.
		
	
		difficultyCombo.getItems().setAll(E_Difficulty.values());
		this.old=MainBoardController.ManageQuestions.getQue();
		// initiate to empty values
		resetFields();

		// update question
		if (old != null) {
			QueText.setText(old.getText());

			Ans1RD.setSelected(old.getAnswers().get(0).getisCorrect());
			Ans1TEXT.setText(old.getAnswers().get(0).getText());

			Ans2RD.setSelected(old.getAnswers().get(1).getisCorrect());
			Ans2TEXT.setText(old.getAnswers().get(1).getText());

			Ans3RD.setSelected(old.getAnswers().get(2).getisCorrect());
			Ans3TEXT.setText(old.getAnswers().get(2).getText());

			Ans4RD.setSelected(old.getAnswers().get(3).getisCorrect());
			Ans4TEXT.setText(old.getAnswers().get(3).getText());

			difficultyCombo.getSelectionModel().select(old.getDifficulty());
		}


	}
	@FXML
	void returnSettings(ActionEvent event) {

		Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
		ManageQuestionsController temp=new ManageQuestionsController();
		try {
			temp.start(stage);	
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	@FXML
	void addQuestion(ActionEvent event) {


		String q = QueText.getText().trim();
		String ans1 = Ans1TEXT.getText().trim();
		String ans2 = Ans2TEXT.getText().trim();
		String ans3 = Ans3TEXT.getText().trim();
		String ans4 = Ans4TEXT.getText().trim();

		boolean ans1Correct = Ans1RD.isSelected();
		boolean ans2Correct = Ans2RD.isSelected();
		boolean ans3Correct = Ans3RD.isSelected();
		boolean ans4Correct = Ans4RD.isSelected();
int count=0;
if(ans1Correct)count++;
if(ans2Correct)count++;
if(ans3Correct)count++;
if(ans4Correct)count++;

		E_Difficulty diff = difficultyCombo.getSelectionModel().getSelectedItem();

		if (!q.isEmpty()) {
			if (!ans1.isEmpty()) {
				if (!ans2.isEmpty()) {
					if (!ans3.isEmpty()) {
						if (!ans4.isEmpty()) {
							if(count==1)
							{
							if (ans1Correct || ans2Correct || ans3Correct || ans4Correct) {
								if (diff != null) {

									ArrayList<Answer> answers = new ArrayList<>(4);
									answers.add(new Answer( ans1, ans1Correct));
									answers.add(new Answer( ans2, ans2Correct));
									answers.add(new Answer( ans3, ans3Correct));
									answers.add(new Answer( ans4, ans4Correct));

									Question question = new Question(q, diff, answers);

									// update question
									if (old != null) {
										Sysdata.getInstance().editQuestion(old, question);
										erorLabel.setText("Question updated successfully. Add a new question?");
										old = null;
									}
									// new question
									else {
										if(	Sysdata.getInstance().addQuestion(question))
											erorLabel.setText("Question added successfully. Add another?");
										else System.out.println("a5");
									}

									
									resetFields();

								} else
									erorLabel.setText("Please select a difficulty level");
							} else
								erorLabel.setText("Please select the correct answer");
							}else
								erorLabel.setText("Please select just one answer ");
						} else
							erorLabel.setText("Please enter answer 4");
					} else
						erorLabel.setText("Please enter answer 3");							
				} else
					erorLabel.setText("Please enter answer 2");
			} else
				erorLabel.setText("Please enter answer 1");
		} else
			erorLabel.setText("Please enter a question");
	}



	public void setq(Question q)
	{
		this.old=q;

	}
	public Question getq()
	{
		return old;
	}
	

	
	private void resetFields() {
		QueText.setText("");

		Ans1TEXT.setText("");
		Ans2TEXT.setText("");
		Ans3TEXT.setText("");
		Ans4TEXT.setText("");

		Ans1RD.setSelected(false);
		Ans2RD.setSelected(false);
		Ans3RD.setSelected(false);
		Ans4RD.setSelected(false);

		difficultyCombo.getSelectionModel().clearSelection();
	}

}


