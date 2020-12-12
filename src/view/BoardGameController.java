package view;

import java.net.URL;
import java.sql.Time;
import java.util.Date;
import java.util.Random;
import java.util.ResourceBundle;
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
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import utils.SQUARE_COLOR;
import utils.Soldier_COLOR_AtSquare;

public class BoardGameController implements Initializable{

    private static final String Yellow = null;
	private int numofYellowSquares=0;
    public Game g;
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
    // the circle soldiers
    @FXML
    private Circle b0 = new Circle();

    @FXML
    private Circle b1= new Circle();

    @FXML
    private Circle b3= new Circle();

    @FXML
    private Circle b2= new Circle();

    @FXML
    private Circle b4= new Circle();

    @FXML
    private Circle b5= new Circle();

    @FXML
    private Circle b6= new Circle();

    @FXML
    private Circle b7= new Circle();

    @FXML
    private Circle b8= new Circle();

    @FXML
    private Circle b9= new Circle();

    @FXML
    private Circle b10= new Circle();

    @FXML
    private Circle b11= new Circle();

    @FXML
    private Circle w8= new Circle();

    @FXML
    private Circle w9= new Circle();

    @FXML
    private Circle w11= new Circle();

    @FXML
    private Circle w10= new Circle();

    @FXML
    private Circle w4= new Circle();

    @FXML
    private Circle w5= new Circle();

    @FXML
    private Circle w6= new Circle();

    @FXML
    private Circle w7= new Circle();

    @FXML
    private Circle w0= new Circle();

    @FXML
    private Circle w3= new Circle();

    @FXML
    private Circle w2= new Circle();

    @FXML
    private Circle w1= new Circle();
    
    @FXML
    private Rectangle s0 = new Rectangle();
   
    @FXML
    private Rectangle s1= new Rectangle();

    @FXML
    private Rectangle s2= new Rectangle();

    @FXML
    private Rectangle s3= new Rectangle();

    @FXML
    private Rectangle s4= new Rectangle();

    @FXML
    private Rectangle s5= new Rectangle();

    @FXML
    private Rectangle s6= new Rectangle();

    @FXML
    private Rectangle s7= new Rectangle();
    
    @FXML
    private Rectangle s8= new Rectangle();

    @FXML
    private Rectangle s9= new Rectangle();

    @FXML
    private Rectangle s10= new Rectangle();

    @FXML
    private Rectangle s11= new Rectangle();

    @FXML
    private Rectangle s12= new Rectangle();

    @FXML
    private Rectangle s13= new Rectangle();

    @FXML
    private Rectangle s14= new Rectangle();

    @FXML
    private Rectangle s15= new Rectangle();

    @FXML
    private Rectangle s16= new Rectangle();

    @FXML
    private Rectangle s17= new Rectangle();

    @FXML
    private Rectangle s18= new Rectangle();

    @FXML
    private Rectangle s19= new Rectangle();

    @FXML
    private Rectangle s20= new Rectangle();

    @FXML
    private Rectangle s21= new Rectangle();

    @FXML
    private Rectangle s22= new Rectangle();

    @FXML
    private Rectangle s23= new Rectangle();
    
    @FXML
    private Rectangle s24= new Rectangle();

    @FXML
    private Rectangle s25= new Rectangle();

    @FXML
    private Rectangle s26= new Rectangle();

    @FXML
    private Rectangle s27= new Rectangle();
    @FXML
    private Rectangle s28= new Rectangle();

    @FXML
    private Rectangle s29= new Rectangle();

    @FXML
    private Rectangle s30= new Rectangle();

    @FXML
    private Rectangle s31= new Rectangle();

    
    
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
			Time t = new Time(0, 0, 0);
			
			g = new Game(white, black,d,t);
			g.initiateGame();
			
			CheckAndDoYellowSquares();

		}
		
	}
	
	// this function checks if the number of the yellow squares is less than 3, if it is so it add one yellow squares
	public void CheckAndDoYellowSquares() {
		while(numofYellowSquares<3) {
			Random rand = new Random();
			int x = rand.nextInt(8); 
	        int y = rand.nextInt(8);
	        
	        if(g.getBoard()[x][y].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY && g.getBoard()[x][y].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY ) {
	         g.getBoard()[x][y].setSquareColor(SQUARE_COLOR.YELLOW);
	        int xviewscene=x*49;	
	        int yviewscene=	y*57;
	        //boardSquares.getPane().getLayout(xviewscene).getLayout(yviewscene);
	        s0.setFill(Color.rgb(255,255,0));
	        numofYellowSquares++;
	        
	        }
			
		}
		
	}
	
	
	



			

	

}
