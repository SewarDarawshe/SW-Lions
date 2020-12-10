package view;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

import Controllers.GameTimer;
import Model.Game;
import Model.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class BoardGameController implements Initializable{


	@FXML
    private Text BlackPlayerNic= new Text();

    @FXML
    private Text WhitePlayerNick =new Text();
    
    @FXML
    private Label BlackPoints= new Label();

    @FXML
    private Label WhitePoints= new Label();

    @FXML
    private TextField BlackNickText = new TextField();

    @FXML
    private TextField WhiteNickText = new TextField();

    @FXML
    private TextField bPointsValue = new TextField();

    @FXML
    private TextField wPointsValue= new TextField();

    @FXML
    private AnchorPane Pane = new AnchorPane();

    @FXML
    private Button exitbutton = new Button();

    @FXML
    private Button Homepagebutton= new Button();
    
    @FXML
    private VBox boardSquares= new VBox();
   
    @FXML
    void exit(ActionEvent event) {
    	((Stage) Pane.getScene().getWindow()).close();
    }

    @FXML
    void openHomepage(ActionEvent event) {
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
			Parent root = FXMLLoader.load(getClass().getResource("/view/BoardGame.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setTitle("Game Board");
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
  

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		if (!NicknamesSetUpController.getWhitename().isEmpty() && !NicknamesSetUpController.getBlackname().isEmpty()) {
			// setting the current player in the board game
			Player white = new Player(NicknamesSetUpController.getWhitename() , 0);
			Player black = new Player(NicknamesSetUpController.getBlackname() , 0);
			WhiteNickText.setEditable(false);
			BlackNickText.setEditable(false);

			WhiteNickText.setText(NicknamesSetUpController.getWhitename());
			BlackNickText.setText(NicknamesSetUpController.getBlackname());

			
			
			wPointsValue.setText(Integer.toString(white.getPoints()));
			bPointsValue.setText(Integer.toString(black.getPoints()));
			Date d = new Date();
			GameTimer t = new GameTimer();
			// wselet : et7ol lm3ra5em ll7yalem w kmalet et7ol lgame
			//Game g = new Game(boardSquares, white, black,d,t, null, null);

			//Timer?
		}
		
	}



			

	

}
