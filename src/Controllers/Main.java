package Controllers;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

import Model.Answer;
import Model.Game;
import Model.Player;
import Model.Question;
import Model.Soldier;
import Model.Square;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import utils.E_Difficulty;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root=FXMLLoader.load(getClass().getResource("/view/MainBoardScreen.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setTitle("Home Page");
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			
			Answer a1=new Answer("Model - View - Controller", true);
			Answer a2=new Answer("Modem - Vertices - Contains", false);
			Answer a3=new Answer("Model - Vehicle - Cars", false);
			Answer a4=new Answer("None of the above", false);

			ArrayList<Answer> answers=new ArrayList<>();
			answers.add(a1);
			answers.add(a2);
			answers.add(a3);
			answers.add(a4);
			Question Q1 =new Question(1, "What does MVC model contain ?", E_Difficulty.EASY, answers, 1);
			System.out.println("we will add a question,then edit it and remove it :");
			if(Sysdata.getInstance().addQuestion(Q1))System.out.println("Successfully added !");
			else System.out.println("Faild to add !");
		
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		launch(args);
		
		
	}
}