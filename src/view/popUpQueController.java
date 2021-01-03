package view;

import java.net.URL;
import java.util.ResourceBundle;

import Controllers.Sysdata;
import Model.Question;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import utils.E_Difficulty;
import utils.Soldier_COLOR_AtSquare;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class popUpQueController implements Initializable{

    @FXML
    private TextField QueText;

    @FXML
    private RadioButton Ans1RD;

    @FXML
    private TextField Ans1TEXT;

    @FXML
    private RadioButton Ans2RD;

    @FXML
    private TextField Ans2TEXT;

    @FXML
    private RadioButton Ans3RD;

    @FXML
    private TextField Ans3TEXT;

    @FXML
    private RadioButton Ans4RD;

    @FXML
    private TextField Ans4TEXT;

    @FXML
    private Label erorLabel;
    @FXML
    private AnchorPane pane;

    @FXML
    private TextField difficultyTEXT;

    @FXML
    private Button submitBTN;
    private Question question;
    public void start(Stage primaryStage) {
		try {

			Parent root = FXMLLoader.load(getClass().getResource("/view/popUpQue.fxml"));

			Scene scene = new Scene(root);		
			primaryStage.setTitle("pop up question");
			primaryStage.setScene(scene);
			primaryStage.show();


		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    @FXML
    void submitQUE(ActionEvent event) {
    	int count=0;
    	int correctAnsID = 0;
 
		try {
			
			if(Ans1RD.isSelected())
			{
				correctAnsID = 1;
				count++;
			}
			if(Ans2RD.isSelected())
			{
				correctAnsID = 2;
				count++;
			}
			if(Ans3RD.isSelected())
			{
				correctAnsID = 3;
				count++;
			}
			if(Ans4RD.isSelected())
			{
				correctAnsID = 4;
				count++;
			}
			
		
			
		} catch (Exception e) {
			erorLabel.setVisible(true);
		}

		// nothing is selected
		if (correctAnsID == 0) { 
			erorLabel.setVisible(true);
			erorLabel.setText("you have to select an answer !");
			// correct answer
		} else if (count>1) {
			erorLabel.setVisible(true);
			erorLabel.setText("you have to select One answer !");
			// wrong answer
			
		} else if (question.getCorrect_ans() == correctAnsID) {
			
			int points =E_Difficulty.Addedpoints(question.getDifficulty());
			if(MainBoardController.BoardGame.turn.equals(Soldier_COLOR_AtSquare.BLACK))
			{
				
				MainBoardController.BoardGame.g.getBlackPlayer().
				setPoints(MainBoardController.BoardGame.g.getBlackPlayer().getPoints()+points);
				
				MainBoardController.BoardGame.bPointsValue.
				setText((Integer.toString(MainBoardController.BoardGame.g.getBlackPlayer().getPoints())));
				handleAlertAndWindow(AlertType.INFORMATION, "Congrats! :D",
						"You received " + points + " points");
				MainBoardController.BoardGame.changeturntowhite();
			}
		
			else if(MainBoardController.BoardGame.turn.equals(Soldier_COLOR_AtSquare.WHITE))
			{
				MainBoardController.BoardGame.g.getWhitePlayer().
				setPoints(MainBoardController.BoardGame.g.getWhitePlayer().getPoints()+points);
				MainBoardController.BoardGame.wPointsValue.
				setText((Integer.toString(MainBoardController.BoardGame.g.getWhitePlayer().getPoints())));
				handleAlertAndWindow(AlertType.INFORMATION, "Congrats! :D",
						"You received " + points + " points");

				MainBoardController.BoardGame.changeturntoBlack();
			}
		
			
			
		}
			
			else {
				int points =E_Difficulty.Removedpoints(question.getDifficulty());
				if(MainBoardController.BoardGame.turn.equals(Soldier_COLOR_AtSquare.BLACK))
				{
					MainBoardController.BoardGame.g.getBlackPlayer().
					setPoints(MainBoardController.BoardGame.g.getBlackPlayer().getPoints()-points);
					MainBoardController.BoardGame.bPointsValue.
					setText((Integer.toString(MainBoardController.BoardGame.g.getBlackPlayer().getPoints())));
					handleAlertAndWindow(AlertType.ERROR, "Oh no! :(",
							"You lost " + question.getPenalty() + " points");

					MainBoardController.BoardGame.changeturntowhite();
				}
			
				else if(MainBoardController.BoardGame.turn.equals(Soldier_COLOR_AtSquare.WHITE))
				{			

					MainBoardController.BoardGame.g.getWhitePlayer().
					setPoints(MainBoardController.BoardGame.g.getWhitePlayer().getPoints()-points);
					MainBoardController.BoardGame.wPointsValue.
					setText((Integer.toString(MainBoardController.BoardGame.g.getWhitePlayer().getPoints())));
					handleAlertAndWindow(AlertType.ERROR, "Oh no! :(",
							"You lost " + question.getPenalty() + " points");
					

					MainBoardController.BoardGame.changeturntoBlack();
				}
				
				

			
				
			}
		

		}
		
		

		
		
    

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		question=Sysdata.getInstance().fetchQuestion();
		erorLabel.setVisible(false);
		
		QueText.setText(question.getText());
		QueText.setEditable(false);
		
		Ans1RD.setSelected(false);
		Ans1TEXT.setText(question.getAnswers().get(0).getText());
		Ans1TEXT.setEditable(false);

		Ans2RD.setSelected(false);
		Ans2TEXT.setText(question.getAnswers().get(1).getText());
		Ans2TEXT.setEditable(false);

		Ans3RD.setSelected(false);
		Ans3TEXT.setText(question.getAnswers().get(2).getText());
		Ans3TEXT.setEditable(false);

		Ans4RD.setSelected(false);
		Ans4TEXT.setText(question.getAnswers().get(3).getText());
		Ans4TEXT.setEditable(false);
		
		difficultyTEXT.setText(question.getDifficulty().toString());
		difficultyTEXT.setEditable(false);
		
	}
	
	private void handleAlertAndWindow(AlertType at, String header, String context) {
		Alert alert = new Alert(at);
		alert.setTitle("Question Result");
		alert.setHeaderText(header);
		alert.setContentText(context);
		alert.showAndWait();

		((Stage) pane.getScene().getWindow()).close();
	}


}
