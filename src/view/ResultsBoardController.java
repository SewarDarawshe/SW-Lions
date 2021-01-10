package view;

import java.net.URL;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

import Controllers.SoundController;
import Controllers.Sysdata;
import Model.Game;
import Model.Player;
import Model.Question;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ResultsBoardController implements Initializable{


	@FXML
	private AnchorPane Pane;

	@FXML
	private Button HomePageButton;

	@FXML
	private Button ExitButton;

	
	@FXML
	private TableView<Game> resultsTable=new TableView<>();

	@FXML
	private TableColumn<Game, Date> dateCol=new TableColumn<>();

	@FXML
	private TableColumn<Game, String> nickname1Col=new TableColumn<>();

	@FXML
	private TableColumn<Game, Integer> points1Col=new TableColumn<>();

	@FXML
	private TableColumn<Game, String> nickname2Col=new TableColumn<>();

	@FXML
	private TableColumn<Game, Integer> points2Col=new TableColumn<>();

	ArrayList<Game> Games = new ArrayList<Game>();
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
	


	@FXML
	void Exit(ActionEvent event) {
		((Stage) Pane.getScene().getWindow()).close();

	}

	@FXML
	void OpneHomePage(ActionEvent event) {
		Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
		MainBoardController temp=new MainBoardController();
		try {
			temp.start(stage);	
		} catch (Exception e) {
			// TODO: handle exception
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
		
		dateCol.setCellValueFactory(new PropertyValueFactory<>("GameDate")); // According to variable name
		nickname1Col.setCellValueFactory(new PropertyValueFactory<>("whiteNic")); // Same here
		points1Col.setCellValueFactory(new PropertyValueFactory<>("whitePoint")); // Same here
		nickname2Col.setCellValueFactory(new PropertyValueFactory<>("blackNic")); // Same here
		points2Col.setCellValueFactory(new PropertyValueFactory<>("blackPoints")); // Same here
		

		// initialize the player list to appear in the table
		//ArrayList<Game> games = Sysdata.getHistory();
		
		//newGames.add(new Game(new Date(), "ana", "noo", 11, 222));
		/*for(Game g:games)
		{
			Game newg=new Game(g.getGameTime(), g.getQueueTime(), g.getWhitePlayer().getNickName(), g.getBlackPlayer().getNickName(), g.getWhitePlayer().getPoints(), g.getBlackPlayer().getPoints());
			newGames.add(newg);
		}*/
		setgamesTable();
		
		
	}
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/view/ResultsBoardScreen.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setTitle("Results Board");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void setgamesTable() {
		
		Games=Sysdata.getHistory();
		
		ObservableList<Game> qs = FXCollections.observableArrayList(Games);
		
		resultsTable.setItems(qs);
		resultsTable.refresh();
		for(Game g1:Games)
		{
			System.out.println(g1.resultstoString());
		}
		

	}

}
