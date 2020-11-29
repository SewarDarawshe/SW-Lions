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
			System.out.println("Here we go-printing every possible thing :)");
			System.out.println("Sysdata Methods:");
			// creating Question
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
			//Adding the Q1 to the Json
			if(Sysdata.getInstance().addQuestion(Q1))System.out.println("Successfully added !");
			else System.out.println("Faild to add !");


			// Editing the Q1
			Question Q2 =new Question(1, "What isn't a Review Objective? ?", E_Difficulty.MEDIUM, answers, 1);

			if(Sysdata.getInstance().editQuestion(Q1, Q2))System.out.println("Successfully Edited !");
			else System.out.println("Faild to Edit !");

			// Delete the Q2 
			if(Sysdata.getInstance().removeQuestion(Q2))System.out.println("Successfully removed !");
			else System.out.println("Faild to remove !");

			//now we will create add a game to the history game Json

			Player wp=new Player("White", 255);
			Player bp=new Player("Black", 299);
			Date d=new Date();

			System.out.println("we will add Game :");

			//adding the game to the history
			if(Sysdata.getInstance().addGameHistory(wp, bp, d))System.out.println("Successfully added to history !");
			else System.out.println("Faild to add to history !");
			// removing 
			System.out.println("Now We will clear the history:");
			if(Sysdata.getInstance().deleteGameHistory())System.out.println("Successfully  deleted history !");
			else System.out.println("Faild to delete history !");
			System.out.println("Let's try and print the history? should be empty:");
			System.out.println(Sysdata.getInstance().getHistory());
			System.out.println("of Course it's working ! I've spent two days trying to solve the Json Bugs :) ");
			System.out.println("Now Let's go check the rest of the project !");


			Square[][] Board=new Square[8][8];		
			Time QueueTime=new Time(0);
			Soldier[] WhitePieces=new Soldier[12];
			Soldier[] BlackPieces=new Soldier[12];
			Game g=new Game(Board, wp, bp, d, QueueTime, WhitePieces, BlackPieces);
			g.initiateGame();
			Soldier s=g.getBlackPieces()[2];
			System.out.println("Now we will try to return an alive soldier, it should fail :");
			if(g.returnSoldier(s))System.out.println("Soldier returned Successfully !");
			else System.out.println("Faild to return soldier!");
			System.out.println("Now we will try to return a dead soldier, it should Work :");
			s.setIsAlive(false);
			
			if(g.returnSoldier(s))System.out.println("Soldier returned Successfully !");
			else System.out.println("Faild to return soldier!");
			

			System.out.println("Let's try and remove the soldier :");
			if(g.removeSoldier(s))System.out.println("Soldier removed Successfully !");
			else System.out.println("Faild to remove soldier!");

			System.out.println("check if the soldier is able to eat (should return no becauce its the first turn):");
			if(g.IsEatable(bp))System.out.println("Player can eat  !");
			else System.out.println("Player can't eat!");
			
			
			
			System.out.println("printing the soldiers locations on the board:");
			
			for(int i=0;i<12;i++)
			{
				System.out.println(g.getBlackPieces()[i]);
			}
			
			for(int i=0;i<12;i++)
			{
				System.out.println(g.getWhitePieces()[i]);
			}
			
			System.out.println( "Now lets try and move soldier "+g.getBlackPieces()[9]+" to x=3 y=4 ");
			if(g.getBlackPieces()[9].moveBlack('r', g.getBoard())==0)System.out.println("The new location is :" +g.getBlackPieces()[9]);
			else System.out.println("Failed to move!");
			
			
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}