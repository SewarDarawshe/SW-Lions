package view;

import java.awt.Label;
import java.net.URL;

import java.util.ResourceBundle;

import Model.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class NicknamesSetUpController implements Initializable{

	private static String whitename;
	private static String blackname;

	@FXML
	private Button exitbutton;


	@FXML
	private Button StartGameButton; 

	@FXML
	private Button homePageButton;
	@FXML
	private AnchorPane Pane;
	@FXML
	private TextField WhiteNickName;

	@FXML
	private TextField BlackNickName;
	
	private Label ErrorLbl;




	public static String getWhitename() {
		return whitename;
	}

	public void setWhitename(String whitename) {
		this.whitename = whitename;
	}

	public static String getBlackname() {
		return blackname;
	}

	public void setBlackname(String blackname) {
		this.blackname = blackname;
	}

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

	@FXML
	void StartGame(ActionEvent event)
	{
		whitename =WhiteNickName.getText();
		blackname =BlackNickName.getText();
		if(!whitename.isEmpty() && !blackname.isEmpty()) {
			Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
			BoardGameController temp=new BoardGameController();
			
			try {
				temp.start(stage);	

			} catch (Exception e) {
				// TODO: handle exception
				ErrorLbl.setText("Please Enter Valid Players' Nicknames!"); //Not Working
			}
		}
		

	}

	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/view/NicknamesSetupScreen.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();



		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}


}