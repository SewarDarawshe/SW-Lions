package view;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
//import java.awt.Label;
import java.net.URL;

import java.util.ResourceBundle;

import javax.imageio.ImageIO;

import Controllers.SoundController;
import Model.Player;
import javafx.embed.swing.SwingFXUtils;
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
import javafx.scene.control.ToggleButton;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


public class NicknamesSetUpController implements Initializable{

	private static String whitename;
	private static String blackname;
	private static boolean isLoad=false;

    Image defult=new Image("/resources/defultUser.png");
	@FXML
	private Button WhitePic;


	public  Image importWhite ;


	public  Image importBlack ;

	@FXML
	private Button BlackPic;
	@FXML
	private Button exitbutton;
	@FXML
	private Button loadgameBTN;

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

	   @FXML
	    public Rectangle whiteRec;

	    @FXML
	    public Rectangle blackRec;
	@FXML
	private Label ErrorLbl;
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
	public static boolean isLoad() {
		return isLoad;
	}

	public static void setLoad(boolean isLoad) {
		NicknamesSetUpController.isLoad = isLoad;
	}
	@FXML
	void StartGame(ActionEvent event)
	{

		whitename =WhiteNickName.getText();
		blackname =BlackNickName.getText();
		if(!whitename.isEmpty() && !blackname.isEmpty())
		{
   
			Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
			BoardGameController temp=new BoardGameController();
			temp.setMainBoardController(this.getMainBoardController());
			temp.setNicknamesSetUpController(this);


		
			temp.start(stage);	



		}
		else {
			ErrorLbl.setText("Please Enter Valid Player's Nicknames!");
		}
	}

	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/view/NicknamesSetupScreen.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setTitle("Nicknames SetUp");
			primaryStage.setScene(scene);
			primaryStage.show();



		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	@FXML
	void LoadGame(ActionEvent event) {
		isLoad=true;

		whitename =WhiteNickName.getText();
		blackname =BlackNickName.getText();
		if(!whitename.isEmpty() && !blackname.isEmpty())
		{
			Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
			BoardGameController temp=new BoardGameController();
			temp.setMainBoardController(this.getMainBoardController());
			temp.setNicknamesSetUpController(this);

			temp.start(stage);	



		}
		else {
			ErrorLbl.setText("Please Enter Valid Player's Nicknames!");
		}

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		WhitePic.setVisible(true);
		BlackPic.setVisible(true);
		blackRec.setVisible(true);
		whiteRec.setVisible(true);
		if(MainBoardController.isMusic())
		{
			setMusic(true);
		}else 			
			setMusic(false);
		MusicBTN.setText("");
		 
		    	
		    	this.blackRec.setFill(new ImagePattern(defult));
		    
		   
		    	this.whiteRec.setFill(new ImagePattern(defult));
		    
	}





	@FXML
	void choosewhite(ActionEvent event) {
		 FileChooser fileChooser = new FileChooser ();
	        File file = fileChooser.showOpenDialog(null);
	        ImageView myImageView = new ImageView();    
		try {
			  BufferedImage bufferedImage = ImageIO.read(file);
			 
	            Image importImage = SwingFXUtils.toFXImage(bufferedImage,null);           
	            myImageView.setImage(importImage);           
	            whiteRec.setFill(new ImagePattern(importImage));
        
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
                  

	}


	@FXML
	void chooseBlack(ActionEvent event) {

		FileChooser fileChooser = new FileChooser ();
        File file = fileChooser.showOpenDialog(null);
        ImageView myImageView = new ImageView();    
	try {
		  BufferedImage bufferedImage = ImageIO.read(file);
		 
            Image importImage = SwingFXUtils.toFXImage(bufferedImage,null);           
            myImageView.setImage(importImage);           
            blackRec.setFill(new ImagePattern(importImage));
    
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
           

	}

}