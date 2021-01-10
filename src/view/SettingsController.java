package view;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import Controllers.SoundController;
import Controllers.Sysdata;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Pair;

public class SettingsController implements Initializable{

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

	 @FXML
	    private ToggleButton MusicBTN;
	 private boolean music = true;
	
	   
		public boolean isMusic() {
			return music;
		}

		public void setMusic(boolean music) {
			this.music = music;
			if(music)MusicBTN.setGraphic(new ImageView("/resources/goOff.png"));
			else MusicBTN.setGraphic(new ImageView("/resources/goOn.png"));
				
		}

		@FXML
		void soundControl(ActionEvent event) {
			
		if(isMusic())
		{
			SoundController.stopMusic();
			setMusic(false);
		
		}else {
			setMusic(true);
			SoundController.playMusic();
			
			

		}

		}


	private static MainBoardController MainBoardController;
	public static MainBoardController getMainBoardController() {
		return MainBoardController;
	}

	public static void setMainBoardController(MainBoardController mainBoardController) {
		MainBoardController = mainBoardController;
	}
	

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

		//Asking for a username and password to make sure only admins see-edit-delete questions 
		Dialog<Pair<String, String>> dialog = new Dialog<>();
		dialog.setTitle("Enter you'r Admin username and password: ");

		ButtonType loginButtonType = new ButtonType("OK", ButtonData.OK_DONE);
		dialog.getDialogPane().getButtonTypes().addAll(loginButtonType, ButtonType.CANCEL);

		GridPane gridPane = new GridPane();
		gridPane.setHgap(10);
		gridPane.setVgap(10);
		gridPane.setPadding(new Insets(20, 150, 10, 10));

		TextField Username = new TextField();
		Username.setPromptText("Username:");
		TextField Password = new TextField();
		Password.setPromptText("Password:");

		gridPane.add(Username, 0, 0);
		gridPane.add(new Label(","), 1, 0);
		gridPane.add(Password, 2, 0);


		dialog.getDialogPane().setContent(gridPane);

		Platform.runLater(() -> Username.requestFocus());
		dialog.setResultConverter(dialogButton -> {
			if (dialogButton == loginButtonType) {
				return new Pair<>(Username.getText(), Password.getText());

			}else 
				if (dialogButton == ButtonType.CANCEL) {
					dialog.close();
				}
			return null;
		});


		Optional<Pair<String, String>> result = dialog.showAndWait();
		if(result!=null) {
			boolean  isReturned =false;
			String user=result.get().getKey();
			String pass = result.get().getValue();
			while(!isReturned) {

				//making sure the pass and username are "Admin"
				dialog.showAndWait();
				if(user.equals("Admin") && pass.equals("Admin"))isReturned=true;



			}
			if(isReturned)
			{
				//Only after making sure this is an admin we open the ManageQue page
				Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
				ManageQuestionsController temp=new ManageQuestionsController();
				try {
				ManageQuestionsController.setMainBoardController(this.getMainBoardController());
					temp.start(stage);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		}
	}


	


	@FXML
	void DeleteGameHis(ActionEvent event) {
		//Asking for a username and password to make sure only admins can delete the history
		Dialog<Pair<String, String>> dialog = new Dialog<>();
		dialog.setTitle("Enter you'r Admin username and password: ");

		ButtonType loginButtonType = new ButtonType("OK", ButtonData.OK_DONE);
		dialog.getDialogPane().getButtonTypes().addAll(loginButtonType, ButtonType.CANCEL);

		GridPane gridPane = new GridPane();
		gridPane.setHgap(10);
		gridPane.setVgap(10);
		gridPane.setPadding(new Insets(20, 150, 10, 10));

		TextField Username = new TextField();
		Username.setPromptText("Username:");
		TextField Password = new TextField();
		Password.setPromptText("Password:");

		gridPane.add(Username, 0, 0);
		gridPane.add(new Label(","), 1, 0);
		gridPane.add(Password, 2, 0);


		dialog.getDialogPane().setContent(gridPane);

		Platform.runLater(() -> Username.requestFocus());
		dialog.setResultConverter(dialogButton -> {
			if (dialogButton == loginButtonType) {
				return new Pair<>(Username.getText(), Password.getText());

			}else {
				if(dialogButton== ButtonType.CANCEL) dialog.close();
			}
			return null;
		});
		

		Optional<Pair<String, String>> result = dialog.showAndWait();
		if(result!=null && result.get().getKey()!=null&&result.get().getValue()!=null) {
			boolean  isReturned =false;
			String user=result.get().getKey();
			String pass = result.get().getValue();
			while(!isReturned) {

				//making sure the pass and username are "Admin"
				dialog.showAndWait();
				if(user.equals("Admin") && pass.equals("Admin"))isReturned=true;

			}
			if(isReturned)
			{
				//Only after making sure this is an admin we warn them the're deleting game history
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Information Dialog");
				alert.setHeaderText("Are you sure you want to delete ALL the games' history?");
				alert.setContentText("By pressing YES the games' history won't be able to be restored");

				ButtonType buttonTypeYes = new ButtonType("Yes", ButtonData.YES);
				ButtonType buttonTypeNo = new ButtonType("No", ButtonData.NO);
				alert.getButtonTypes().setAll(buttonTypeYes, buttonTypeNo);
				Optional<ButtonType> answer = alert.showAndWait();

				if (answer.get().getButtonData() == ButtonData.YES) {
					Controllers.Sysdata.getInstance().deleteGameHistory();
				}
				if (answer.get().getButtonData() == ButtonData.NO) {
					alert.close();
				}

			}
		}


	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		if(MainBoardController.isMusic())
		{
			setMusic(true);
		}else 			
			setMusic(false);
		MusicBTN.setText("");
	}

}
