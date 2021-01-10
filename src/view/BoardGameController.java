package view;

import java.net.URL;

import javax.swing.*;
import java.awt.event.*;
import java.io.*;

import Controllers.SoundController;
import Controllers.SquareFactory;
import Controllers.Sysdata; 
import java.sql.Time;
import java.time.Duration;
import java.util.Date;
import java.util.Optional;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.swing.Timer;
import Model.Game;
import Model.Player;
import Model.Soldier;
import Model.SquareObject;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.Pane;
import java.time.Duration;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Pair;
import view.TimerInterface;
import view.TimerThread;
import utils.SQUARE_COLOR;
import utils.Soldier_COLOR_AtSquare;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.paint.Color; 
import javafx.scene.shape.Circle; 
import javafx.scene.shape.Rectangle; 
import javafx.scene.text.Text; 
import javafx.stage.Stage; 
import utils.SQUARE_COLOR; 
import utils.Soldier_COLOR_AtSquare; 

public class BoardGameController implements Initializable{

	// Helping parameters to complete methods
	public Soldier_COLOR_AtSquare turn=Soldier_COLOR_AtSquare.WHITE;
	private SquareObject[][] board;
	private int numofYellowSquares=0;
	public Game g;
	public Soldier eatSoldier=null;
	Timer whitegreentimer;
	Timer blackgreentimer;
	Timer blackorangetimer;
	Timer whiteorangetimer;
	Timer whiteturntimer;
	private String whiteName;//the white player name
	private String blackName;//the black player name
	private String theWinner;// the name of the winner
	private Rectangle r=null;
	//soldier that has chosen to be moved
	private Circle soldier=null;
	//soldier that has moved to red square to be moved
	private Circle redSoldier=null;
	// target square the soldier want to turn to
	private Rectangle target=null;
	private TimerThread gamethread;
	private TimerThread whitethread;
	private TimerThread blackthread;
	public TimerInterface gametime;
	public TimerInterface whitetime;
	public TimerInterface blacktime;
	private Duration duration;
	private Circle[] blackcircles = new Circle[12];// this array include the black circles
	private Circle[] whitecircles = new Circle[12];// this array include the white circles
	public boolean isLoad;
	private long endwhite;
	private long endblack;
	private long startwhite;
	private long startblack;
	public boolean wasinYellow=false;

	//GUI parameters
	@FXML
	private Text gameTimer;

	@FXML
	private Text WhiteTimer;

	@FXML
	private Text BlackTimer;
	@FXML
	private Button pauseResumeBTN;
	@FXML
	private Label TurnLbl;

	@FXML
	private Text BlackPlayerNic= new Text();

	@FXML
	private Text WhitePlayerNick =new Text();

	@FXML
	private Label BlackPoints= new Label();

	@FXML
	private Label WhitePoints= new Label();
	 @FXML
	    private ToggleButton MusicBTN;

	@FXML
	private TextField BlackNickText = new TextField();

	@FXML
	private TextField WhiteNickText = new TextField();

	@FXML
	public TextField bPointsValue = new TextField();

	@FXML
	public TextField wPointsValue= new TextField();

	@FXML
	private AnchorPane Pane = new AnchorPane();

	@FXML
	private Button exitbutton = new Button();

	@FXML
	private Button Homepagebutton= new Button();


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
	private Pane boardPane = new Pane();
	
	

    @FXML
    private Rectangle blackPicRec;

    @FXML
    private Rectangle whitePicRec;
    
    
	private static MainBoardController MainBoardController;
	public static MainBoardController getMainBoardController() {
		return MainBoardController;
	}

	public static void setMainBoardController(MainBoardController mainBoardController) {
		MainBoardController = mainBoardController;
	}
	
	
	private static NicknamesSetUpController NicknamesSetUpController;
	public static NicknamesSetUpController getNicknamesSetUpController() {
		return NicknamesSetUpController;
	}

	public static void setNicknamesSetUpController(NicknamesSetUpController nicknamesSetUpController) {
		System.out.println();
		NicknamesSetUpController = nicknamesSetUpController;
	}
	private boolean music = true;
	private boolean soundfx = true;
   
	public boolean isMusic() {
		return music;
	}

	public void setMusic(boolean music) {
		this.music = music;
		if(music)MusicBTN.setGraphic(new ImageView("/resources/goOff.png"));
		else MusicBTN.setGraphic(new ImageView("/resources/goOn.png"));
			
	}

	public boolean isSoundfx() {
		return soundfx;
	}

	public void setSoundfx(boolean soundfx) {
		this.soundfx = soundfx;
		SoundController.setSoundFX(soundfx);
	}
	//starting the page methods

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

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		if (!NicknamesSetUpController.getWhitename().isEmpty() && !NicknamesSetUpController.getBlackname().isEmpty())
		{
			MainBoardController.BoardGame=this;
			if(this.MainBoardController.isMusic())
			{
				setMusic(true);
			}else 			
				setMusic(false);
			MusicBTN.setText("");
		

			if(this.NicknamesSetUpController.blackRec!=null)
			{
				
				blackPicRec.setFill(this.NicknamesSetUpController.blackRec.getFill());
			}
			if(this.NicknamesSetUpController.whiteRec!=null)
			{
				
				whitePicRec.setFill(this.NicknamesSetUpController.whiteRec.getFill());
			}


			// setting the current player in the board game
			whiteName = NicknamesSetUpController.getWhitename();
			blackName = NicknamesSetUpController.getBlackname();
			Player white = new Player(NicknamesSetUpController.getWhitename() , 0);
			Player black = new Player(NicknamesSetUpController.getBlackname() , 0);
			WhiteNickText.setEditable(false);
			BlackNickText.setEditable(false);
			white.setColor(Soldier_COLOR_AtSquare.WHITE);
			black.setColor(Soldier_COLOR_AtSquare.BLACK);

			WhiteNickText.setText(NicknamesSetUpController.getWhitename());
			BlackNickText.setText(NicknamesSetUpController.getBlackname());



			wPointsValue.setText(Integer.toString(white.getPoints()));
			bPointsValue.setText(Integer.toString(black.getPoints()));

			// uploading the circle Squares to the array of the circles
			blackcircles[0]=b0;
			blackcircles[1]=b1;
			blackcircles[2]=b2;
			blackcircles[3]=b3;
			blackcircles[4]=b4;
			blackcircles[5]=b5;
			blackcircles[6]=b6;
			blackcircles[7]=b7;
			blackcircles[8]=b8;
			blackcircles[9]=b9;
			blackcircles[10]=b10;
			blackcircles[11]=b11;
			whitecircles[0]=w0;
			whitecircles[1]=w1;
			whitecircles[2]=w2;
			whitecircles[3]=w3;
			whitecircles[4]=w4;
			whitecircles[5]=w5;
			whitecircles[6]=w6;
			whitecircles[7]=w7;
			whitecircles[8]=w8;
			whitecircles[9]=w9;
			whitecircles[10]=w10;
			whitecircles[11]=w11;
			gametime=new DigitTimerGroup(gameTimer);
			gamethread = new TimerThread(gametime);
			gamethread.setDaemon(true);
			gamethread.start();




			if(!NicknamesSetUpController.isLoad())
			{

				Date d = new Date();
				Time t = new Time(0, 0, 0);

				g = new Game(white, black,d,t);
				g.initiateGame();
				this.board=g.getBoard();
				startWhiteTimer();


				for( int i=0; i<12;i++) {
					int x=g.getBlackPieces()[i].getLocation().getX();
					int y=g.getBlackPieces()[i].getLocation().getY();
				}
				turn=Soldier_COLOR_AtSquare.WHITE;


				TurnLbl.setText("Its the White turn");
				startwhite=System.nanoTime();
				



			}

			else {

				//we are in a load situation
				Date d = new Date();
				Time t = new Time(0, 0, 0);

				g = new Game(white, black,d,t);


				String contents;
				try {
					contents = new String(Files.readAllBytes(Paths.get("loadGame.txt")));
					String[] arrOfStr=	contents.split(",", -2);
					g.initiateLOADGame(arrOfStr);
					this.board=g.getBoard();
					int whitec=0;
					int blackc=0;
					for(int i=0;i<8;i++)
						for(int j=0;j<8;j++)
						{
							if(board[i][j]!=null ) 
							{
								System.out.println(i+","+j+","+board[i][j].getSquareColor());
								

							}

							
						}
					for(int row=0;row<8;row++)
					{
						if(row%2!=0) 
							for(int col=0;col<8;col+=2)
							{
								if(g.getBoard()[row][col].getSoldierColor()!=null&&whitec<12 && blackc<12)
								{
									if(g.getBoard()[row][col].getSoldierColor().equals(Soldier_COLOR_AtSquare.BLACK))
									{

										blackcircles[blackc]=newlayout(row, col, blackcircles[blackc]);
										g.getBlackPieces()[blackc].getLocation().setX(row);
										g.getBlackPieces()[blackc].getLocation().setY(col);
										blackc++;

									}


									else {
										if(g.getBoard()[row][col].getSoldierColor().equals(Soldier_COLOR_AtSquare.WHITE))
										{
											whitecircles[whitec]=newlayout(row, col, whitecircles[whitec]);
											g.getWhitePieces()[whitec].getLocation().setX(row);
											g.getWhitePieces()[whitec].getLocation().setY(col);
											whitec++;
										}

									}




								}
							}

						else
						{
							for(int col=1;col<8;col+=2)
							{
								if(g.getBoard()[row][col].getSoldierColor()!=null&&whitec<12 && blackc<12)
								{
									if(g.getBoard()[row][col].getSoldierColor().equals(Soldier_COLOR_AtSquare.BLACK))
									{
										blackcircles[blackc]=newlayout(row, col, blackcircles[blackc]);
										g.getBlackPieces()[blackc].getLocation().setX(row);
										g.getBlackPieces()[blackc].getLocation().setY(col);
										blackc++;
									}

									else {
										if(g.getBoard()[row][col].getSoldierColor().equals(Soldier_COLOR_AtSquare.WHITE))
										{
											whitecircles[whitec]=newlayout(row, col, whitecircles[whitec]);
											g.getWhitePieces()[whitec].getLocation().setX(row);
											g.getWhitePieces()[whitec].getLocation().setY(col);
											whitec++;
										}

									}





								}
							}
						}



					}
					while(blackc<12)
					{
						blackcircles[blackc].setVisible(false);
						g.getBlackPieces()[blackc].setIsAlive(false);
						blackc++;
					}
					while(whitec<12)
					{
						whitecircles[whitec].setVisible(false);
						g.getWhitePieces()[whitec].setIsAlive(false);
						whitec++;
					}


					if(arrOfStr[arrOfStr.length-1].equals("B"))
					{
						TurnLbl.setText("Its the Black turn");
						turn=Soldier_COLOR_AtSquare.BLACK;
						startblack=System.nanoTime();
						startBlackTimer();
					}
					if(arrOfStr[arrOfStr.length-1].equals("W"))
					{
						TurnLbl.setText("Its the White turn");
						turn=Soldier_COLOR_AtSquare.WHITE;
						startwhite=System.nanoTime();
						startWhiteTimer();
					}
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}



			}
			
			CheckAndDoRedSquare();
			while(numofYellowSquares<3) {
				CheckAndDoYellowSquares();

			}
			CheckAndDoBlueSquare();

		}
	}

	@FXML
	void MoveToSquare(MouseEvent event) {
		if(redSoldier==null && eatSoldier==null) {
			this.target=(Rectangle) event.getTarget();
			System.out.println("if 111111111111111111111");

			MoveSoldierToTarget();
		}
		else if(redSoldier!=null && redSoldier.equals(this.soldier)) {
			this.target=(Rectangle) event.getTarget();
			System.out.println("if 22222222222222222222222222");

			MoveSoldierToTarget();
			redSoldier=null;
		}
		else if(eatSoldier!=null && g.eatingMore(eatSoldier)==true) {
			this.target=(Rectangle) event.getTarget();
			
			System.out.println("if 333333333333333333");

			System.out.println("Ethaar is a Queennnn");
			
			int targetx=TransForCordinateNum((int)target.getLayoutY());
			System.out.printf("Ethaar move to row:%d\n",targetx);

			int targety=TransForCordinateNum((int) target.getLayoutX());
			System.out.printf("Ethaar move to col num:%d\n",targety);
			
			int sourcex=TransForCordinateNum((int)this.soldier.getLayoutY()-30);
			int sourcey=TransForCordinateNum((int)this.soldier.getLayoutX()-30);
			
			
			eatingAgain(eatSoldier,sourcex,sourcey,targetx, targety);
			
			System.out.println("WLKKKK FOT!!!! 616");

		}

	}




	@FXML
	void MoveSoldier(MouseEvent event) {
		Soldier thisSoldier=null;
		
		this.soldier=(Circle) event.getTarget();
		int sourcex=TransForCordinateNum((int)this.soldier.getLayoutY()-30);
		int sourcey=TransForCordinateNum((int)this.soldier.getLayoutX()-30);
		//Wselna
		// turn=White
		if(turn==Soldier_COLOR_AtSquare.WHITE && board[sourcex][sourcey].getSoldierColor()==Soldier_COLOR_AtSquare.WHITE) {
			for(int i=0;i<g.getWhitePieces().length;i++) {
				if(g.getWhitePieces()[i].getLocation().getX()==sourcex && g.getWhitePieces()[i].getLocation().getY()==sourcey) {
					thisSoldier=g.getWhitePieces()[i];
					//if you choose another soldier to move you will dead
					System.out.println("***********************");
					System.out.println(eatSoldier);
					System.out.println("********************");
					System.out.println(thisSoldier);

					if(eatSoldier!=null && eatSoldier!=thisSoldier) {
						//3:scene
						
						Circle oldSoldier= getSoldierOnScene(eatSoldier.getLocation().getX(), eatSoldier.getLocation().getY());
						oldSoldier.setVisible(false);
						//2
						board[eatSoldier.getLocation().getX()][eatSoldier.getLocation().getY()].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);
						//1
						eatSoldier.getLocation().setX(-1);
						eatSoldier.getLocation().setY(-1);
						eatSoldier.setIsAlive(false);
						//eatSoldier=null;
						break;
					}
				}
				
				
				
			}
			
		
		}
		// turn=BLACK
		if(turn==Soldier_COLOR_AtSquare.BLACK && board[sourcex][sourcey].getSoldierColor()==Soldier_COLOR_AtSquare.BLACK) {
			for(int i=0;i<g.getBlackPieces().length;i++) {
				if(g.getBlackPieces()[i].getLocation().getX()==sourcex && g.getBlackPieces()[i].getLocation().getY()==sourcey) {
					thisSoldier=g.getBlackPieces()[i];
					//if you choose another soldier to move you will dead
					System.out.println("***********EATINGSOLDIER************");
					System.out.println(eatSoldier);
					System.out.println("*********THISSOLDIER***********");
					System.out.println(thisSoldier);

					if(eatSoldier!=null && eatSoldier!=thisSoldier) {
						//3:scene
						
						Circle c= getSoldierOnScene(eatSoldier.getLocation().getX(), eatSoldier.getLocation().getY());
						c.setVisible(false);
						//2
						board[eatSoldier.getLocation().getX()][eatSoldier.getLocation().getY()].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);
						//1
						eatSoldier.getLocation().setX(-1);
						eatSoldier.getLocation().setY(-1);
						eatSoldier.setIsAlive(false);
						//eatSoldier=null;
						break;
					}
				}
				
				
				
			}
			
		
		}
		
		
	

		//turn is WHITE
		if(turn==Soldier_COLOR_AtSquare.WHITE && board[sourcex][sourcey].getSoldierColor()==Soldier_COLOR_AtSquare.BLACK) {
			this.soldier=null;
		}
		// turn=BLACK
		if(turn==Soldier_COLOR_AtSquare.BLACK && board[sourcex][sourcey].getSoldierColor()==Soldier_COLOR_AtSquare.WHITE) {
			this.soldier=null;
		}



	}


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
	//this function trnasfer the layout coordinate to 0<c<7
	private int TransForCordinateNum(int c) {
		int num=0;
		while(c>=30) {
			c=c-60;
			num++;
		}
		return num;
	}



	private int MoveSoldierToTarget() {
		try{
			redSoldier=null;
			if(soldier!=null && target!=null) {
				int firstsourcex=(int) this.soldier.getLayoutX();
				int firstsourcey=(int) this.soldier.getLayoutY();
				int sourcex=TransForCordinateNum((int)this.soldier.getLayoutY()-30);
				System.out.printf("the row is: %d\n",sourcex);


				int sourcey=TransForCordinateNum((int)this.soldier.getLayoutX()-30);
				System.out.printf("the col is: %d\n",sourcey);


				//turns the square target coordinates to: 0<x<7 & 0<y<7
				//System.out.println(target.getLayoutX());
				int targetx=TransForCordinateNum((int)target.getLayoutY());
				System.out.printf("move to row:%d\n",targetx);

				int targety=TransForCordinateNum((int) target.getLayoutX());
				System.out.printf("move to col num:%d\n",targety);
				
				if(turn==Soldier_COLOR_AtSquare.BLACK) {
				DeadBlack(sourcex,sourcey,targetx,targety,firstsourcex,firstsourcey);
				System.out.println("WB#####DEEEEEENNNNNNNNN");
				}
				
				if(turn==Soldier_COLOR_AtSquare.WHITE) {
				DeadWhite(sourcex,sourcey,targetx,targety,firstsourcex,firstsourcey);
				System.out.println("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFf");
				}
				

				if(board[targetx][targety].getSquareColor()==SQUARE_COLOR.BLACK || board[targetx][targety].getSquareColor()==SQUARE_COLOR.ORANGE) {
					//moving the black soldier to target square
					if(turn==Soldier_COLOR_AtSquare.BLACK) {
						moveBlack(sourcex,sourcey,targetx,targety,firstsourcex,firstsourcey);
						if(eatSoldier==null)
						changeturntowhite();
					}


					//moving the white soldier to target square
					else if(turn==Soldier_COLOR_AtSquare.WHITE) {						
						moveWhite(sourcex,sourcey,targetx,targety,firstsourcex,firstsourcey);
						if(eatSoldier==null)
						changeturntoBlack();
					}

					if(board[targetx][targety].getSquareColor()==SQUARE_COLOR.ORANGE) {
						// returning the orange square to black square
						Rectangle r1= getRectangle(targetx,targety);
						board[targetx][targety].setSquareColor(SQUARE_COLOR.BLACK);
						r1.setFill(Color.rgb(94,91,91));
					}
					this.soldier=null;
					this.target=null;


				}

				else if(board[targetx][targety].getSquareColor()==SQUARE_COLOR.BLUE) {
					Soldier s=null;
					int index=0;
					String returnForWhite=null;
					String returnForBlack=null;
					System.out.println("this is blueeeeeeeeeee"+turn);
					//takint the first dead soldier at the black pieces
					if(turn == Soldier_COLOR_AtSquare.BLACK) {
						while(s==null && index<12) {
							if(g.getBlackPieces()[index].isIsAlive()==false&&g.getBlackPieces()[index].getLocation().getX()!=0) {
								s=g.getBlackPieces()[index];
							}
							index++;
						}
						System.out.println("after while");
						for(int i=0;i<8;i++)
							for(int j=0;j<8;j++)
							{
								if(board[i][j]!=null && board[i][j].getSquareColor()==SQUARE_COLOR.BLACK && board[i][j].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY) {
								if(g.returnSoldier(s,i,j)){
									returnForBlack+="row:"+i+"col:"+j+":) \n";
								}


							}

								
							}
						
						
						System.out.println(returnForBlack);
						
						 Dialog<Pair<Integer, Integer>> dialog = new Dialog<>();
						 dialog.setTitle("Choose where to return the solider ");
						
						 ButtonType loginButtonType = new ButtonType("OK", ButtonData.OK_DONE);
						    dialog.getDialogPane().getButtonTypes().addAll(loginButtonType, ButtonType.CANCEL);
						
						    GridPane gridPane = new GridPane();
						    gridPane.setHgap(10);
						    gridPane.setVgap(10);
						    gridPane.setPadding(new Insets(20, 150, 10, 10));
						    TextField returnto = new TextField();
						    returnto.setPromptText(returnForBlack);
						    TextField Row = new TextField();
						    Row.setPromptText("Row");
						    TextField Col = new TextField();
						    Col.setPromptText("Col");

						    gridPane.add(Row, 0, 0);
						    gridPane.add(new Label(","), 1, 0);
						    gridPane.add(Col, 2, 0);

						    
						    dialog.getDialogPane().setContent(gridPane);
						    
						    Platform.runLater(() -> Row.requestFocus());
						    dialog.setResultConverter(dialogButton -> {
						        if (dialogButton == loginButtonType) {
						            return new Pair<>(Integer.parseInt(Row.getText()), Integer.parseInt(Col.getText()));
						            
						            
						            
						            
						        }
						        return null;
						    });
						    
						   
						    Optional<Pair<Integer, Integer>> result = dialog.showAndWait();
						    boolean  isReturned =false;
						    int x=result.get().getKey();
						    int y = result.get().getValue();
						    while(!isReturned) {
					
				               
									 dialog.showAndWait();
									isReturned=g.returnSoldier(s, x, y);
										
						
						    }
						    	moveBlack(sourcex,sourcey,targetx,targety,firstsourcex,firstsourcey);
								//1
								board[x][y].setSoldierColor(Soldier_COLOR_AtSquare.BLACK);


								//2
								for(int i=0; i<g.getBlackPieces().length; i++) {
									if(g.getBlackPieces()[i]==s) {
										g.getBlackPieces()[i].setIsAlive(true);
										//3 : Scene builder
										for(int w=0;w<12;w++)
										{
											if(!blackcircles[w].isVisible())
											{
												blackcircles[w]= newlayout(x,y,blackcircles[w]);
												blackcircles[w].setVisible(true);
												break;
											}
										}


									}

								}
								changeturntowhite();
							
					
					}
					//takint the first dead soldier at the white pieces
					else if(turn == Soldier_COLOR_AtSquare.WHITE) {
						System.out.println("wbbbbb");

						while(s==null && index<12) {
							if(g.getWhitePieces()[index].isIsAlive()==false&&g.getWhitePieces()[index].getLocation().getX()!=0) {
								s=g.getWhitePieces()[index];
							}
							index++;
						}
						System.out.println("after while");
						for(int i=0;i<8;i++)
							for(int j=0;j<8;j++)
							{if(board[i][j]!=null && board[i][j].getSquareColor()==SQUARE_COLOR.BLACK && board[i][j].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY) {
								if(g.returnSoldier(s,i,j)){
									returnForWhite+="row:"+i+"col:"+j+":) \n";
								}


							}

								
							}
						System.out.println("after for");

					
				
					 Dialog<Pair<Integer, Integer>> dialog = new Dialog<>();
					 dialog.setTitle("Choose where to return the solider ");
					
					 ButtonType loginButtonType = new ButtonType("OK", ButtonData.OK_DONE);
					    dialog.getDialogPane().getButtonTypes().addAll(loginButtonType, ButtonType.CANCEL);
					
					    GridPane gridPane = new GridPane();
					    gridPane.setHgap(10);
					    gridPane.setVgap(10);
					    gridPane.setPadding(new Insets(20, 150, 10, 10));
					    TextField returnto = new TextField();
					    returnto.setPromptText(returnForWhite);
					    TextField Row = new TextField();
					    Row.setPromptText("Row");
					    TextField Col = new TextField();
					    Col.setPromptText("Col");

					    gridPane.add(Row, 0, 0);
					    gridPane.add(new Label(","), 1, 0);
					    gridPane.add(Col, 2, 0);

					    
					    dialog.getDialogPane().setContent(gridPane);
					    
					    Platform.runLater(() -> Row.requestFocus());
					    dialog.setResultConverter(dialogButton -> {
					        if (dialogButton == loginButtonType) {
					            return new Pair<>(Integer.parseInt(Row.getText()), Integer.parseInt(Col.getText()));
					            
					            
					            
					            
					        }
					        return null;
					    });
					    
					   
					    Optional<Pair<Integer, Integer>> result = dialog.showAndWait();
					    boolean  isReturned =false;
					    int x=result.get().getKey();
					    int y = result.get().getValue();
					    while(!isReturned) {
				
			               
								 dialog.showAndWait();
								isReturned=g.returnSoldier(s, x, y);
									
					
					    }
					  

							
							if(isReturned) {
									moveWhite(sourcex,sourcey,targetx,targety,firstsourcex,firstsourcey);
									//1
									board[x][y].setSoldierColor(Soldier_COLOR_AtSquare.WHITE);


									//2
									for(int i=0; i<g.getWhitePieces().length; i++) {
										if(g.getWhitePieces()[i]==s) {
											g.getWhitePieces()[i].setIsAlive(true);
										
											g.getWhitePieces()[i].getLocation().setX(x);
											g.getWhitePieces()[i].getLocation().setY(y);
											System.out.println(g.getWhitePieces()[i]);
											//3 : Scene builder
										
											for(int w=0;w<12;w++)
											{
												if(!whitecircles[w].isVisible())
												{
													whitecircles[w]= newlayout(x,y,whitecircles[w]);
													whitecircles[w].setVisible(true);
													break;
												}
											}
											


										}

									}
		
				}
							changeturntoBlack();		
					}
				}
				else if(board[targetx][targety].getSquareColor()==SQUARE_COLOR.GREEN) {
					
					if(turn==Soldier_COLOR_AtSquare.WHITE) {
						g.getWhitePlayer().setPoints(g.getWhitePlayer().getPoints()+50);
						wPointsValue.setText((Integer.toString(g.getWhitePlayer().getPoints())));
						this.soldier= newlayout(targetx,targety,this.soldier);
						//2+3
						for(int j=0; j<g.getWhitePieces().length; j++) {
							if(g.getWhitePieces()[j].getLocation().getX()== sourcex && g.getWhitePieces()[j].getLocation().getY()== sourcey)
							{
								board[sourcex][sourcey].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);
								board[targetx][targety]=SquareFactory.getSquareObject(SQUARE_COLOR.BLACK,
										targetx, targety, Soldier_COLOR_AtSquare.WHITE, g.getWhitePieces()[j]);
								g.getWhitePieces()[j].getLocation().setX(targetx);
								g.getWhitePieces()[j].getLocation().setY(targety);
							}
						}
						// returning the green square to black square
						Rectangle r1= getRectangle(targetx,targety);

						r1.setFill(Color.rgb(94,91,91));
						changeturntoBlack();
						return 0;
					}
					else if(turn==Soldier_COLOR_AtSquare.BLACK) {
						g.getBlackPlayer().setPoints(g.getBlackPlayer().getPoints()+50);
						System.out.println("1151");
						bPointsValue.setText((Integer.toString(g.getBlackPlayer().getPoints())));
						this.soldier= newlayout(targetx,targety,this.soldier);
						//2+3
						for(int j=0; j<g.getBlackPieces().length; j++) {
							if(g.getBlackPieces()[j].getLocation().getX()== sourcex && g.getBlackPieces()[j].getLocation().getY()== sourcey)
							{
								board[sourcex][sourcey].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);
								board[targetx][targety]=SquareFactory.getSquareObject(SQUARE_COLOR.BLACK,
										targetx, targety, Soldier_COLOR_AtSquare.BLACK, g.getBlackPieces()[j]);
								g.getBlackPieces()[j].getLocation().setX(targetx);
								g.getBlackPieces()[j].getLocation().setY(targety);
							}
						}
						// returning the green square to black square
						Rectangle r1= getRectangle(targetx,targety);
						board[targetx][targety].setSquareColor(SQUARE_COLOR.BLACK);
						r1.setFill(Color.rgb(94,91,91));
						changeturntowhite();

						return 0;
					}
				}
				if(board[targetx][targety].getSquareColor()==SQUARE_COLOR.YELLOW) {
					SoldierChooseYellow(sourcex,sourcey,targetx,targety,firstsourcex,firstsourcey);
				}		
				if(board[targetx][targety].getSquareColor()==SQUARE_COLOR.RED) {
					if(turn==Soldier_COLOR_AtSquare.WHITE) {
						redSoldier=this.soldier;
						// returning the red square to black square
						board[targetx][targety]=SquareFactory.getSquareObject(SQUARE_COLOR.BLACK,
								targetx, targety, Soldier_COLOR_AtSquare.WHITE, null);
						Rectangle r1= getRectangle(targetx,targety);

						r1.setFill(Color.rgb(94,91,91));
						//1
						newlayout(targetx,targety,this.soldier);
						//2+3
						for(int j=0; j<g.getWhitePieces().length; j++) {
							if(g.getWhitePieces()[j].getLocation().getX()== sourcex && g.getWhitePieces()[j].getLocation().getY()== sourcey)
							{
								board[sourcex][sourcey].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);
								board[targetx][targety].setSoldierColor(Soldier_COLOR_AtSquare.WHITE);
								g.getWhitePieces()[j].getLocation().setX(targetx);
								g.getWhitePieces()[j].getLocation().setY(targety);
							}
						}
						changeturntowhite();
					}	
					if(turn==Soldier_COLOR_AtSquare.BLACK) {
						redSoldier=this.soldier;
						// returning the red square to black square
						Rectangle r2= getRectangle(targetx,targety);
						board[targetx][targety]=SquareFactory.getSquareObject(SQUARE_COLOR.BLACK,
								targetx, targety, Soldier_COLOR_AtSquare.BLACK, null);
						r2.setFill(Color.rgb(94,91,91));
						//1
						newlayout(targetx,targety,this.soldier);
						//2+3
						for(int j=0; j<g.getBlackPieces().length; j++) {
							if(g.getBlackPieces()[j].getLocation().getX()== sourcex && g.getBlackPieces()[j].getLocation().getY()== sourcey)
							{
								board[sourcex][sourcey].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);
								board[targetx][targety].setSoldierColor(Soldier_COLOR_AtSquare.BLACK);
								g.getBlackPieces()[j].getLocation().setX(targetx);
								g.getBlackPieces()[j].getLocation().setY(targety);
							}
						}

						changeturntoBlack();
					}

				}

				}}

		

		catch (Exception e) {
			//ToDo
		}
		finally {
			finallyFunction();

		}
		return -1;


	}

	private void moveWhite(int sourcex, int sourcey, int targetx, int targety, int firstsourcex, int firstsourcey) {
		if(this.board[sourcex][sourcey].getSoldierColor() == Soldier_COLOR_AtSquare.WHITE) {
			for(int i=0; i<g.getWhitePieces().length; i++) {
				if(g.getWhitePieces()[i].getLocation().getX()== sourcex && g.getWhitePieces()[i].getLocation().getY()== sourcey
						) {
					if(!g.getWhitePieces()[i].isIsQueen()) {
						int isOk =(g.getWhitePieces()[i]).moveWhite( sourcex, sourcey, targetx,targety,board);
						if(isOk==0) {

							System.out.println("is ok");
							if(sourcex==targetx+1 && targety-1==sourcey)
							{

								double soldiersourcex=this.soldier.getLayoutX();
								double soldiersourcey=this.soldier.getLayoutY();
								this.soldier.setLayoutX(soldiersourcex+60);
								this.soldier.setLayoutY(soldiersourcey-60);
								board[sourcex][sourcey].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);
								board[targetx][targety].setSoldierColor(Soldier_COLOR_AtSquare.WHITE);	


							}

							if(sourcex==targetx+1 && sourcey==targety+1)
							{
								double soldiersourcex=this.soldier.getLayoutX();
								double soldiersourcey=this.soldier.getLayoutY();
								this.soldier.setLayoutX(soldiersourcex-60);
								this.soldier.setLayoutY(soldiersourcey-60);
								board[sourcex][sourcey].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);
								board[targetx][targety].setSoldierColor(Soldier_COLOR_AtSquare.WHITE);




							}
							if(targetx==0)
							{
								this.soldier.setFill(Color.BLUE);
								for(int j=0;j<g.getWhitePieces().length;j++)
								{
									if(g.getWhitePieces()[i].getLocation().getX()== targetx && g.getWhitePieces()[i].getLocation().getY()== targety)
									{
										g.getWhitePieces()[i].setIsQueen(true);

									}
								}
							}





						}
						if(isOk==-1)
						{
							this.soldier.setVisible(false);
						}
						

						//  white eat right
						else if(targety==sourcey+2 && targetx+2==sourcex) {
							System.out.println("white eat right");
							movewhitetoRight(sourcex, sourcey, targetx, targety, firstsourcex, firstsourcey, i);
							for(int index=0; index<g.getWhitePieces().length; index++) {
								if(g.getWhitePieces()[index].getLocation().getX()==targetx && g.getWhitePieces()[index].getLocation().getY()==targety) {
									eatSoldier=g.getWhitePieces()[index];
									if(g.eatingMore(eatSoldier)==false) {
										eatSoldier=null;
										changeturntoBlack();
										return;
									}
									return;
								}
							}
						}
						//write left eat
						else if(targety==sourcey-2 && targetx+2==sourcex) {
							System.out.println("write left eat");
							moveWhitetoLeft(sourcex, sourcey, targetx, targety, firstsourcex, firstsourcey, i);
							for(int index=0; index<g.getWhitePieces().length; index++) {
								if(g.getWhitePieces()[index].getLocation().getX()==targetx && g.getWhitePieces()[index].getLocation().getY()==targety) {
									eatSoldier=g.getWhitePieces()[index];
									if(g.eatingMore(eatSoldier)==false) {
										eatSoldier=null;
										changeturntoBlack();
										return;
									}
									return;
								}
							}
						}
					}
					// move white queen	
					else	
					{	
						MoveWhiteQueen(sourcex, sourcey, targetx, targety, i);
					}
				}
			}

			
		}

	}


	private void moveBlack(int sourcex, int sourcey, int targetx, int targety, int firstsourcex, int firstsourcey) {
		//moving the black soldier to target square
		if(this.board[sourcex][sourcey].getSoldierColor() == Soldier_COLOR_AtSquare.BLACK )  {
			Player pb= g.getBlackPlayer();
			System.out.println("in black");
			for(int i=0; i<g.getBlackPieces().length; i++) {
				if(g.getBlackPieces()[i].getLocation().getX()== sourcex && g.getBlackPieces()[i].getLocation().getY()== sourcey)
				{

					if(!g.getBlackPieces()[i].isIsQueen()) {

						int isOk =(g.getBlackPieces()[i]).moveBlack( sourcex, sourcey, targetx,targety,board);
						if(isOk==0) {
							if(sourcex+1==targetx && targety==sourcey-1)
							{

								double soldiersourcex=this.soldier.getLayoutX();
								double soldiersourcey=this.soldier.getLayoutY();
								this.soldier.setLayoutX(soldiersourcex-60);
								this.soldier.setLayoutY(soldiersourcey+60);
								board[sourcex][sourcey].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);
								board[targetx][targety].setSoldierColor(Soldier_COLOR_AtSquare.BLACK);


							}

							if(sourcex==targetx-1 && sourcey==targety-1)
							{
								double soldiersourcex=this.soldier.getLayoutX();
								double soldiersourcey=this.soldier.getLayoutY();
								this.soldier.setLayoutX(soldiersourcex+60);
								this.soldier.setLayoutY(soldiersourcey+60);
								board[sourcex][sourcey].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);
								board[targetx][targety].setSoldierColor(Soldier_COLOR_AtSquare.BLACK);



							}

							if(targetx==7)
							{
								this.soldier.setFill(Color.BROWN);
								for(int j=0;j<g.getBlackPieces().length;j++)
								{
									if(g.getBlackPieces()[i].getLocation().getX()== targetx && g.getBlackPieces()[i].getLocation().getY()== targety)
									{
										g.getBlackPieces()[i].setIsQueen(true);


									}
								}
							}


						}
						if(isOk==-1)
						{
							this.soldier.setVisible(false);
						}

						// right black eat
						else if(targety==sourcey+2 && targetx==sourcex+2) {
							System.out.println("right black eat");
							rightBlackeat(sourcex, sourcey, targetx, targety, firstsourcex, firstsourcey, i);
						for(int index=0; index<g.getBlackPieces().length; index++) {
							if(g.getBlackPieces()[index].getLocation().getX()==targetx && g.getBlackPieces()[index].getLocation().getY()==targety) {
								eatSoldier=g.getBlackPieces()[index];
								System.out.println("WLKKKK 3'yeer llabyaaadddd!!!!!");
								if(g.eatingMore(eatSoldier)==false) {
									eatSoldier=null;
									changeturntowhite();
									return;
								}
								return;
							}
						}
//						if(g.eatingMore(eatSoldier)==true) {
//							eatingAgain(eatSoldier,sourcex,sourcey,targetx,targety);
//							eatSoldier=null;
//							return;
//
//							}

						}
						else
							//Left black eat
							System.out.println("left black eat");
							if(targety==sourcey-2 && targetx==sourcex+2) {
								leftBlackeat(sourcex, sourcey, targetx, targety, firstsourcex, firstsourcey, i);
								
								for(int index=0; index<g.getBlackPieces().length; index++) {
									if(g.getBlackPieces()[index].getLocation().getX()==targetx && g.getBlackPieces()[index].getLocation().getY()==targety) {
										eatSoldier=g.getBlackPieces()[index];
										if(g.eatingMore(eatSoldier)==false) {
											System.out.println("WLKKKK 3'yeer llabyaaadddd!!!!!");
											eatSoldier=null;
											changeturntowhite();
											return;
										}
										return;
									}
								}
							}


					}
					

					// move black queen	
					else	
					{
						MoveBlackQueen(sourcex, sourcey, targetx, targety, i);
					}

				}


			}

			



		}

	}




	private boolean theGameisEnd() {

		int bcountdead=0; // the number of black soldiers that have died 
		int wcountdead=0; // the number of white soldiers that have died 
		//count the dead soldiers for the black player
		for(int i=0; i<g.getBlackPieces().length;i++) {
			if(g.getBlackPieces()[i].isIsAlive()==false) {
				bcountdead++;
			}
		}
		System.out.printf("The black dead is:%d\n", bcountdead);


		//checks if all the soldiers of the black player is dead
		if(bcountdead == 12) {
			//white player have more points than the black player
			if(g.getWhitePlayer().getPoints() > g.getBlackPlayer().getPoints()) {
				theWinner = whiteName;
				Sysdata.getInstance().addGameHistory(g.getWhitePlayer(), g.getBlackPlayer(), g.getGameDate());
				System.out.println(theWinner);
				return true;
				//black player have more points than the white player
			}else if(g.getBlackPlayer().getPoints() > g.getWhitePlayer().getPoints()) {
				theWinner = blackName;
				Sysdata.getInstance().addGameHistory(g.getWhitePlayer(), g.getBlackPlayer(), g.getGameDate());
				System.out.println(theWinner);

				return true;
				//if the players have the same points value			
			}else if(g.getWhitePlayer().getPoints() == g.getBlackPlayer().getPoints()) {
				theWinner = "Draw";
				Sysdata.getInstance().addGameHistory(g.getWhitePlayer(), g.getBlackPlayer(), g.getGameDate());
				System.out.println(theWinner);

				return true;	
			}
		}
		//count the dead soldiers for the white player
		for(int i=0; i<g.getWhitePieces().length;i++) {
			if(g.getWhitePieces()[i].isIsAlive()==false) {
				wcountdead++;
			}
		}
		//checks if all the soldiers of the white player is dead
		if(wcountdead == 12) {
			if(g.getWhitePlayer().getPoints() > g.getBlackPlayer().getPoints()) {
				theWinner = whiteName;
				Sysdata.getInstance().addGameHistory(g.getWhitePlayer(), g.getBlackPlayer(), g.getGameDate());

				return true;
			}else if(g.getBlackPlayer().getPoints() > g.getWhitePlayer().getPoints()) {
				theWinner = blackName;
				Sysdata.getInstance().addGameHistory(g.getWhitePlayer(), g.getBlackPlayer(), g.getGameDate());

				return true;
			}else if(g.getWhitePlayer().getPoints() == g.getBlackPlayer().getPoints()) {
				theWinner = "Draw";
				Sysdata.getInstance().addGameHistory(g.getWhitePlayer(), g.getBlackPlayer(), g.getGameDate());

				return true;
			}
		}
		//checks if all the soldiers of the white player are blocked
		if(g.IsBlocked(g.getWhitePlayer())==true) {
			if(bcountdead == 12) {
				if(g.getWhitePlayer().getPoints() > g.getBlackPlayer().getPoints()) {
					theWinner = whiteName;

					return true;
				}else if(g.getBlackPlayer().getPoints() > g.getWhitePlayer().getPoints()) {
					theWinner = blackName;
					Sysdata.getInstance().addGameHistory(g.getWhitePlayer(), g.getBlackPlayer(), g.getGameDate());

					return true;
				}else if(g.getWhitePlayer().getPoints() == g.getBlackPlayer().getPoints()) {
					theWinner = "Draw";
					Sysdata.getInstance().addGameHistory(g.getWhitePlayer(), g.getBlackPlayer(), g.getGameDate());

					return true;		
				}
			}
		}

		//checks if all the soldiers of the black player are blocked
		if(g.IsBlocked(g.getBlackPlayer())==true) {
			if(bcountdead == 12) {
				if(g.getWhitePlayer().getPoints() > g.getBlackPlayer().getPoints()) {
					theWinner = whiteName;
					Sysdata.getInstance().addGameHistory(g.getWhitePlayer(), g.getBlackPlayer(), g.getGameDate());

					return true;
				}else if(g.getBlackPlayer().getPoints() > g.getWhitePlayer().getPoints()) {
					theWinner = blackName;
					Sysdata.getInstance().addGameHistory(g.getWhitePlayer(), g.getBlackPlayer(), g.getGameDate());

					return true;
				}else if(g.getWhitePlayer().getPoints() == g.getBlackPlayer().getPoints()) {
					theWinner = "Draw";
					Sysdata.getInstance().addGameHistory(g.getWhitePlayer(), g.getBlackPlayer(), g.getGameDate());

					return true;	
				}
			}
		}
		return false;
	}

	private Circle getSoldierOnScene(int sourcex, int sourcey) {
		//getting the soldier circle from the whiteCircles
		for(int i=0;i<12;i++) {
			if(whitecircles[i].getLayoutX()==sourcex && whitecircles[i].getLayoutY()==sourcey)
				return whitecircles[i];
		}

		//getting the soldier circle from the blackCircles
		for(int i=0;i<12;i++) {
			if(blackcircles[i].getLayoutX()==sourcex && blackcircles[i].getLayoutY()==sourcey)
				return blackcircles[i];
		}
		return null;

	}








	public void CheckAndDoYellowSquares() {
		Random rand = new Random();
		int x = rand.nextInt(8); 
		int y = rand.nextInt(8);
		if(board[x][y]!=null) 
		{
			if(board[x][y].getSquareColor()!=null) {
				if(board[x][y].getSquareColor()==SQUARE_COLOR.BLACK && board[x][y].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY ) {

					Rectangle yellowSquare=getRectangle(x,y);

					if(yellowSquare!=null) {
						yellowSquare.setFill(Color.rgb(255,255,0));
						board[x][y]=SquareFactory.getSquareObject(SQUARE_COLOR.YELLOW
								, x, y, Soldier_COLOR_AtSquare.EMPTY, null);
						numofYellowSquares++;
					}
				}
			}
		}


	}

	// this function make red square randomly if there is no option to eat at this turn
	public void CheckAndDoRedSquare() {

		if(turn==Soldier_COLOR_AtSquare.WHITE)
		{
			
			Player pw=g.getWhitePlayer();
			if(g.IsEatable(pw,g.getWhitePieces())==null) {
				System.out.println("1407");
				for(int i=0; i<g.getWhitePieces().length; i++) {
					// righ side
					if(((g.getWhitePieces()[i].getLocation().getX())-1)>0 && ((g.getWhitePieces()[i].getLocation().getY())+1)<8 &&  ((g.getWhitePieces()[i].getLocation().getY())+1)<8 && board[(g.getWhitePieces()[i].getLocation().getX())-1][(g.getWhitePieces()[i].getLocation().getY())+1].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY && board[(g.getWhitePieces()[i].getLocation().getX())-1][(g.getWhitePieces()[i].getLocation().getY())+1].getSquareColor()==SQUARE_COLOR.BLACK) {
						System.out.printf("X:%d Y:%d ddddddddd \n",(g.getWhitePieces()[i].getLocation().getX())-1,(g.getWhitePieces()[i].getLocation().getY())+1);
						Rectangle r= getRectangle((g.getWhitePieces()[i].getLocation().getX())-1,(g.getWhitePieces()[i].getLocation().getY())+1);
						board[(g.getWhitePieces()[i].getLocation().getX())-1][(g.getWhitePieces()[i].getLocation().getY())+1]
								=SquareFactory.getSquareObject(SQUARE_COLOR.RED,
										(g.getWhitePieces()[i].getLocation().getX())-1,
										(g.getWhitePieces()[i].getLocation().getY())+1, Soldier_COLOR_AtSquare.WHITE,
										g.getWhitePieces()[i]);
						System.out.println("ETHArrrr111111");
						r.setFill(Color.rgb(255,0,0));
						return;
					}

					// left side
					if((g.getWhitePieces()[i].getLocation().getX()-1)>0 && ((g.getWhitePieces()[i].getLocation().getY()))-1>0 &&  board[(g.getWhitePieces()[i].getLocation().getX())-1][(g.getWhitePieces()[i].getLocation().getY())-1].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY && board[(g.getWhitePieces()[i].getLocation().getX())-1][(g.getWhitePieces()[i].getLocation().getY())-1].getSquareColor()==SQUARE_COLOR.BLACK) {
						Rectangle r= getRectangle((g.getWhitePieces()[i].getLocation().getX())-1,(g.getWhitePieces()[i].getLocation().getY())-1);
						System.out.println(2);
						board[(g.getWhitePieces()[i].getLocation().getX())-1][(g.getWhitePieces()[i].getLocation().getY())-1]
								=SquareFactory.getSquareObject(SQUARE_COLOR.RED,
										(g.getWhitePieces()[i].getLocation().getX())-1,
										(g.getWhitePieces()[i].getLocation().getY())-1, Soldier_COLOR_AtSquare.WHITE,
										g.getWhitePieces()[i]);
						System.out.println("ETHArrrr222222");
						r.setFill(Color.rgb(255,0,0));
						return;
					}

				}

			}
		}


		if(turn==Soldier_COLOR_AtSquare.BLACK)
		{
			Player pb= g.getBlackPlayer();

			if(g.IsEatable(pb,g.getBlackPieces())==null) {
				for(int i=0; i<g.getBlackPieces().length; i++) {
					// righ side

					if((g.getBlackPieces()[i].getLocation().getX())<7 && (g.getBlackPieces()[i].getLocation().getY())>1 && (g.getBlackPieces()[i].getLocation().getY())>1 &&   board[(g.getBlackPieces()[i].getLocation().getX())+1][(g.getBlackPieces()[i].getLocation().getY())-1].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY && board[(g.getBlackPieces()[i].getLocation().getX())+1][(g.getBlackPieces()[i].getLocation().getY())-1].getSquareColor()==SQUARE_COLOR.BLACK) {
						Rectangle r= getRectangle((g.getBlackPieces()[i].getLocation().getX())+1,(g.getBlackPieces()[i].getLocation().getY())-1);
						board[(g.getBlackPieces()[i].getLocation().getX())+1][(g.getBlackPieces()[i].getLocation().getY())-1]
								=SquareFactory.getSquareObject(SQUARE_COLOR.RED,
										(g.getBlackPieces()[i].getLocation().getX())+1,
										(g.getBlackPieces()[i].getLocation().getY())-1, Soldier_COLOR_AtSquare.BLACK,
										g.getBlackPieces()[i]);
						System.out.println("ETHArrrr3333333");
						r.setFill(Color.rgb(255,0,0));
						return;
					}

					// left side
					System.out.println("Left");
					System.out.println(g.getBlackPieces()[i].getLocation().getX());
					System.out.println(g.getBlackPieces()[i].getLocation().getY());

					if(g.getBlackPieces()[i].getLocation().getX()>0 && g.getBlackPieces()[i].getLocation().getY()>0 &&
							g.getBlackPieces()[i].getLocation().getX()<7 && g.getBlackPieces()[i].getLocation().getY()<7 && board[(g.getBlackPieces()[i].getLocation().getX())+1][(g.getBlackPieces()[i].getLocation().getY())+1].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY && board[(g.getBlackPieces()[i].getLocation().getX())+1][(g.getBlackPieces()[i].getLocation().getY())+1].getSquareColor()==SQUARE_COLOR.BLACK) {
						Rectangle r= getRectangle((g.getBlackPieces()[i].getLocation().getX())+1,(g.getBlackPieces()[i].getLocation().getY())+1);
						board[(g.getBlackPieces()[i].getLocation().getX())+1][(g.getBlackPieces()[i].getLocation().getY())+1]
								=SquareFactory.getSquareObject(SQUARE_COLOR.RED,
										(g.getBlackPieces()[i].getLocation().getX())+1,
										(g.getBlackPieces()[i].getLocation().getY())+1, Soldier_COLOR_AtSquare.BLACK,
										g.getBlackPieces()[i]);
						System.out.println("ETHArrrr4444444444444");

						r.setFill(Color.rgb(255,0,0));
						return;
					}

				}

			}
		}

	}

	//This function checks if there is two alive soldiers and one alive queen for a player.
	//If it's true it's calls the Game.ReturnSoldier function.
	public void CheckAndDoBlueSquare() {

		System.out.println("1848");
		int cntSoldier=0; //counter for the soldiers
		int cntQueen=0; //counter for the queens.
		int x =0;
		int y=0;
		r=getRectangle(3,6);
		/*	while(true)
		{
			Random rand =new Random();
			x = rand.nextInt(8); 
			y = rand.nextInt(8);
			r=getRectangle(x,y);
			if(board[x][y]!=null && board[x][y].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY && r!=null )
				break;

		}*/

		//if it's the white player turn
		System.out.println(turn);
		if(turn==Soldier_COLOR_AtSquare.WHITE) {
		
			for(int i=0; i < g.getWhitePieces().length; i++) {
				//count the alive soldiers
				if(g.getWhitePieces()[i].isIsAlive() && g.getWhitePieces()[i].getColor() == Soldier_COLOR_AtSquare.WHITE &&
						!g.getWhitePieces()[i].isIsQueen()) {
					cntSoldier++;
				}
				//count the alive queens
				if(g.getWhitePieces()[i].isIsAlive() && g.getWhitePieces()[i].isIsQueen()) {
					cntQueen++;
				}
			
			}
			//checks if there is 2 alive soldiers and one alive queen
			if(cntSoldier == 2 && cntQueen == 1) {
					for(int j=0; j<g.getWhitePieces().length; j++) {
					if(!g.getWhitePieces()[j].isIsAlive()) {
						//checks if the random square is empty
						if(board[3][6]!=null) 
						{
							if(board[3][6].getSquareColor()!=null) {
							if(board[3][6].getSquareColor()==SQUARE_COLOR.BLACK && board[3][6].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY ) {
									board[3][6]=SquareFactory.getSquareObject
											(SQUARE_COLOR.BLUE, 3, 6, Soldier_COLOR_AtSquare.EMPTY , g.getWhitePieces()[j]);
									r.setFill(Color.rgb(4,56,218));
								}
							}
						}

					}
				}
			}
		}
		//if it's the black player turn
		else if(turn==Soldier_COLOR_AtSquare.BLACK) {

			for(int i=0; i < g.getBlackPieces().length; i++) {
				//count the alive soldiers
				if(g.getBlackPieces()[i].isIsAlive() && g.getBlackPieces()[i].getColor() == Soldier_COLOR_AtSquare.BLACK &&
						!g.getBlackPieces()[i].isIsQueen()) {
					cntSoldier++;
				}
				//count the alive queens
				if(g.getBlackPieces()[i].isIsAlive() && g.getBlackPieces()[i].isIsQueen()) {
					cntQueen++;
				}
			
			}
			//checks if there is 2 alive soldiers and one alive queen
			if(cntSoldier == 2 && cntQueen == 1) {
					for(int j=0; j<g.getBlackPieces().length; j++) {
					if(!g.getBlackPieces()[j].isIsAlive()) {
						//checks if the random square is empty
						if(board[3][6]!=null) 
						{
							if(board[3][6].getSquareColor()!=null) {
							if(board[3][6].getSquareColor()==SQUARE_COLOR.BLACK && board[3][6].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY ) {
									board[3][6]=SquareFactory.getSquareObject
											(SQUARE_COLOR.BLUE, 3, 6, Soldier_COLOR_AtSquare.EMPTY , g.getBlackPieces()[j]);
									r.setFill(Color.rgb(4,56,218));
								}
							}
						}

					}
				}
			}

		}

	}

	//This function fill all the locations/squares that a soldier can step into in green
	//it's called when 30 seconds have passed since the beginning of the player's turn and he has not yet made a move
	public void CheckAndDoGreenSquare() {
		if(turn == Soldier_COLOR_AtSquare.WHITE) {
			for(int i=0; i<g.getWhitePieces().length; i++) {
				if(g.getWhitePieces()[i].getLocation().getY()==0) {
					if(board[(g.getWhitePieces()[i].getLocation().getX())-1][(g.getWhitePieces()[i].getLocation().getY())+1].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY && board[(g.getWhitePieces()[i].getLocation().getX())-1][(g.getWhitePieces()[i].getLocation().getY())+1].getSquareColor()==SQUARE_COLOR.BLACK) {

						//fill green
						Rectangle r= getRectangle((g.getWhitePieces()[i].getLocation().getX())-1,(g.getWhitePieces()[i].getLocation().getY())+1);
						board[(g.getWhitePieces()[i].getLocation().getX())-1][(g.getWhitePieces()[i].getLocation().getY())+1]
								=SquareFactory.getSquareObject(SQUARE_COLOR.GREEN,(g.getWhitePieces()[i].getLocation().getX())-1
										, (g.getWhitePieces()[i].getLocation().getY())+1,
										Soldier_COLOR_AtSquare.WHITE, null);
						r.setFill(Color.rgb(10,160,25));
						return;
					}
				}

				if(g.getWhitePieces()[i].getLocation().getY()==7) {
					if(board[(g.getWhitePieces()[i].getLocation().getX())-1][(g.getWhitePieces()[i].getLocation().getY())-1].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY && board[(g.getWhitePieces()[i].getLocation().getX())-1][(g.getWhitePieces()[i].getLocation().getY())-1].getSquareColor()==SQUARE_COLOR.BLACK) {

						//fill green
						Rectangle r= getRectangle((g.getWhitePieces()[i].getLocation().getX())-1,(g.getWhitePieces()[i].getLocation().getY())-1);
						board[(g.getWhitePieces()[i].getLocation().getX())-1][(g.getWhitePieces()[i].getLocation().getY())-1]
								=SquareFactory.getSquareObject(SQUARE_COLOR.GREEN,(g.getWhitePieces()[i].getLocation().getX())-1
										, (g.getWhitePieces()[i].getLocation().getY())-1,
										Soldier_COLOR_AtSquare.WHITE, null);
						r.setFill(Color.rgb(10,160,25));
						return;
					}
				}
				else if(g.getWhitePieces()[i].getLocation().getY()>0 && g.getWhitePieces()[i].getLocation().getY()<7
						&& g.getWhitePieces()[i].getLocation().getX()>0 && g.getWhitePieces()[i].getLocation().getX()<7 ) {

					if(board[(g.getWhitePieces()[i].getLocation().getX())-1][(g.getWhitePieces()[i].getLocation().getY())-1].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY && board[(g.getWhitePieces()[i].getLocation().getX())-1][(g.getWhitePieces()[i].getLocation().getY())-1].getSquareColor()==SQUARE_COLOR.BLACK) {
						//fill green
						Rectangle r= getRectangle((g.getWhitePieces()[i].getLocation().getX())-1,(g.getWhitePieces()[i].getLocation().getY())-1);
						board[(g.getWhitePieces()[i].getLocation().getX())-1][(g.getWhitePieces()[i].getLocation().getY())-1]
								=SquareFactory.getSquareObject(SQUARE_COLOR.GREEN,(g.getWhitePieces()[i].getLocation().getX())-1
										,(g.getWhitePieces()[i].getLocation().getY())-1,
										Soldier_COLOR_AtSquare.WHITE, null);
						r.setFill(Color.rgb(10,160,25));
						return;
					}
					if(g.getWhitePieces()[i].getLocation().getX()<6 && g.getWhitePieces()[i].getLocation().getY()<6 && board[(g.getWhitePieces()[i].getLocation().getX())-1][(g.getWhitePieces()[i].getLocation().getY())+1].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY && board[(g.getWhitePieces()[i].getLocation().getX())-1][(g.getWhitePieces()[i].getLocation().getY())+1].getSquareColor()==SQUARE_COLOR.BLACK) {
						//fill green
						Rectangle r= getRectangle((g.getWhitePieces()[i].getLocation().getX())-1,(g.getWhitePieces()[i].getLocation().getY())+1);
						board[(g.getWhitePieces()[i].getLocation().getX())-1][(g.getWhitePieces()[i].getLocation().getY())+1]
								=SquareFactory.getSquareObject(SQUARE_COLOR.GREEN,(g.getWhitePieces()[i].getLocation().getX())-1
										,(g.getWhitePieces()[i].getLocation().getY())+1,
										Soldier_COLOR_AtSquare.WHITE, null);
						r.setFill(Color.rgb(10,160,25));
						return;
					}
				}
			}
		}
		if(turn == Soldier_COLOR_AtSquare.BLACK) {
			for(int i=0; i<g.getBlackPieces().length; i++) {
				if(g.getBlackPieces()[i].getLocation().getY()==0) {
					if(board[(g.getBlackPieces()[i].getLocation().getX())+1][(g.getBlackPieces()[i].getLocation().getY())+1].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY && board[(g.getBlackPieces()[i].getLocation().getX())+1][(g.getBlackPieces()[i].getLocation().getY())+1].getSquareColor()==SQUARE_COLOR.BLACK) {
						//fill green
						Rectangle r= getRectangle((g.getBlackPieces()[i].getLocation().getX())+1,(g.getBlackPieces()[i].getLocation().getY())+1);
						board[(g.getBlackPieces()[i].getLocation().getX())+1][(g.getBlackPieces()[i].getLocation().getY())+1]
								=SquareFactory.getSquareObject(SQUARE_COLOR.GREEN,(g.getBlackPieces()[i].getLocation().getX())+1
										,(g.getBlackPieces()[i].getLocation().getY())+1,
										Soldier_COLOR_AtSquare.BLACK, null);
						r.setFill(Color.rgb(10,160,25));
						return;
					}
				}

				if(g.getBlackPieces()[i].getLocation().getY()==7) {
					if(board[(g.getBlackPieces()[i].getLocation().getX())+1][(g.getBlackPieces()[i].getLocation().getY())-1].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY && board[(g.getBlackPieces()[i].getLocation().getX())+1][(g.getBlackPieces()[i].getLocation().getY())-1].getSquareColor()==SQUARE_COLOR.BLACK) {
						//fill green
						Rectangle r= getRectangle((g.getBlackPieces()[i].getLocation().getX())+1,(g.getBlackPieces()[i].getLocation().getY())-1);
						board[(g.getBlackPieces()[i].getLocation().getX())+1][(g.getBlackPieces()[i].getLocation().getY())-1]
								=SquareFactory.getSquareObject(SQUARE_COLOR.GREEN,(g.getBlackPieces()[i].getLocation().getX())+1
										,(g.getBlackPieces()[i].getLocation().getY())-1,
										Soldier_COLOR_AtSquare.BLACK, null);
						r.setFill(Color.rgb(10,160,25));
						return;
					}
				}
				else if(g.getBlackPieces()[i].getLocation().getY()>0 && g.getBlackPieces()[i].getLocation().getY()<7) {

					if(board[(g.getBlackPieces()[i].getLocation().getX())+1][(g.getBlackPieces()[i].getLocation().getY())-1].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY && board[(g.getBlackPieces()[i].getLocation().getX())+1][(g.getBlackPieces()[i].getLocation().getY())-1].getSquareColor()==SQUARE_COLOR.BLACK) {
						//fill green
						Rectangle r= getRectangle((g.getBlackPieces()[i].getLocation().getX())+1,(g.getBlackPieces()[i].getLocation().getY())-1);
						board[(g.getBlackPieces()[i].getLocation().getX())+1][(g.getBlackPieces()[i].getLocation().getY())-1]
								=SquareFactory.getSquareObject(SQUARE_COLOR.GREEN,(g.getBlackPieces()[i].getLocation().getX())+1
										,(g.getBlackPieces()[i].getLocation().getY())-1,
										Soldier_COLOR_AtSquare.BLACK, null);
						r.setFill(Color.rgb(10,160,25));
						return;
					}

					if(g.getBlackPieces()[i].getLocation().getX()<6 && g.getBlackPieces()[i].getLocation().getY()<6 && board[(g.getBlackPieces()[i].getLocation().getX())+1][(g.getBlackPieces()[i].getLocation().getY())+1].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY && board[(g.getBlackPieces()[i].getLocation().getX())+1][(g.getBlackPieces()[i].getLocation().getY())+1].getSquareColor()==SQUARE_COLOR.BLACK) {
						//fill green
						Rectangle r= getRectangle((g.getBlackPieces()[i].getLocation().getX())+1,(g.getBlackPieces()[i].getLocation().getY())+1);
						board[(g.getBlackPieces()[i].getLocation().getX())+1][(g.getBlackPieces()[i].getLocation().getY())+1]
								=SquareFactory.getSquareObject(SQUARE_COLOR.GREEN,(g.getBlackPieces()[i].getLocation().getX())+1
										,(g.getBlackPieces()[i].getLocation().getY())+1,
										Soldier_COLOR_AtSquare.BLACK, null);
						r.setFill(Color.rgb(10,160,25));
						return;
					}
				}
			}
		}
	}


	public void CheckAndDoOrangeSquare() {
		if(turn == Soldier_COLOR_AtSquare.WHITE) {
			for(int i=0; i<g.getWhitePieces().length; i++) {
				if(g.getWhitePieces()[i].getLocation().getY()==0) {
					if(board[(g.getWhitePieces()[i].getLocation().getX())-1][(g.getWhitePieces()[i].getLocation().getY())+1].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY) {

						//fill orange
						Rectangle r= getRectangle((g.getWhitePieces()[i].getLocation().getX())-1,(g.getWhitePieces()[i].getLocation().getY())+1);
						board[(g.getWhitePieces()[i].getLocation().getX())-1][(g.getWhitePieces()[i].getLocation().getY())+1].setSquareColor(SQUARE_COLOR.ORANGE);
						r.setFill(Color.rgb(220,110,15));
					}
				}

				if(g.getWhitePieces()[i].getLocation().getY()==7) {
					if(board[(g.getWhitePieces()[i].getLocation().getX())-1][(g.getWhitePieces()[i].getLocation().getY())-1].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY) {

						//fill orange
						Rectangle r= getRectangle((g.getWhitePieces()[i].getLocation().getX())-1,(g.getWhitePieces()[i].getLocation().getY())-1);
						board[(g.getWhitePieces()[i].getLocation().getX())-1][(g.getWhitePieces()[i].getLocation().getY())-1].setSquareColor(SQUARE_COLOR.ORANGE);
						r.setFill(Color.rgb(220,110,15));
					}
				}
				else if(g.getWhitePieces()[i].getLocation().getY()>0 && g.getWhitePieces()[i].getLocation().getY()<7) {
					if(board[(g.getWhitePieces()[i].getLocation().getX())-1][(g.getWhitePieces()[i].getLocation().getY())-1].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY) {
						//fill orange
						Rectangle r= getRectangle((g.getWhitePieces()[i].getLocation().getX())-1,(g.getWhitePieces()[i].getLocation().getY())-1);
						board[(g.getWhitePieces()[i].getLocation().getX())-1][(g.getWhitePieces()[i].getLocation().getY())-1].setSquareColor(SQUARE_COLOR.ORANGE);
						r.setFill(Color.rgb(220,110,15));
					}
					if(g.getWhitePieces()[i].getLocation().getX()<6 && g.getWhitePieces()[i].getLocation().getY()<6 && board[(g.getWhitePieces()[i].getLocation().getX())-1][(g.getWhitePieces()[i].getLocation().getY())+1].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY) {
						//fill orange
						Rectangle r= getRectangle((g.getWhitePieces()[i].getLocation().getX())-1,(g.getWhitePieces()[i].getLocation().getY())+1);
						board[(g.getWhitePieces()[i].getLocation().getX())-1][(g.getWhitePieces()[i].getLocation().getY())+1].setSquareColor(SQUARE_COLOR.ORANGE);
						r.setFill(Color.rgb(220,110,15));
					}
				}
			}
		}
		if(turn == Soldier_COLOR_AtSquare.BLACK) {
			for(int i=0; i<g.getBlackPieces().length; i++) {
				if(g.getBlackPieces()[i].getLocation().getY()==0) {
					if(board[(g.getBlackPieces()[i].getLocation().getX())+1][(g.getBlackPieces()[i].getLocation().getY())+1].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY) {
						//fill orange
						Rectangle r= getRectangle((g.getBlackPieces()[i].getLocation().getX())+1,(g.getBlackPieces()[i].getLocation().getY())+1);
						board[(g.getBlackPieces()[i].getLocation().getX())+1][(g.getBlackPieces()[i].getLocation().getY())+1].setSquareColor(SQUARE_COLOR.ORANGE);
						r.setFill(Color.rgb(220,110,15));
					}
				}

				if(g.getBlackPieces()[i].getLocation().getY()==7) {
					if(board[(g.getBlackPieces()[i].getLocation().getX())+1][(g.getBlackPieces()[i].getLocation().getY())-1].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY) {
						//fill orange
						Rectangle r= getRectangle((g.getBlackPieces()[i].getLocation().getX())+1,(g.getBlackPieces()[i].getLocation().getY())-1);
						board[(g.getBlackPieces()[i].getLocation().getX())+1][(g.getBlackPieces()[i].getLocation().getY())-1].setSquareColor(SQUARE_COLOR.ORANGE);
						r.setFill(Color.rgb(220,110,15));
					}
				}
				else if(g.getBlackPieces()[i].getLocation().getY()>0 && g.getBlackPieces()[i].getLocation().getY()<7) {

					if(board[(g.getBlackPieces()[i].getLocation().getX())+1][(g.getBlackPieces()[i].getLocation().getY())-1].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY) {
						//fill orange
						Rectangle r= getRectangle((g.getBlackPieces()[i].getLocation().getX())+1,(g.getBlackPieces()[i].getLocation().getY())-1);
						board[(g.getBlackPieces()[i].getLocation().getX())+1][(g.getBlackPieces()[i].getLocation().getY())-1].setSquareColor(SQUARE_COLOR.ORANGE);
						r.setFill(Color.rgb(220,110,15));
					}

					if(g.getBlackPieces()[i].getLocation().getX()<6 && g.getBlackPieces()[i].getLocation().getY()<6 && board[(g.getBlackPieces()[i].getLocation().getX())+1][(g.getBlackPieces()[i].getLocation().getY())+1].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY) {
						//fill orange
						Rectangle r= getRectangle((g.getBlackPieces()[i].getLocation().getX())+1,(g.getBlackPieces()[i].getLocation().getY())+1);
						board[(g.getBlackPieces()[i].getLocation().getX())+1][(g.getBlackPieces()[i].getLocation().getY())+1].setSquareColor(SQUARE_COLOR.ORANGE);
						r.setFill(Color.rgb(220,110,15));
					}
				}
			}
		}
	}


	// this function take the square coordinates: 0<=x<8 & 0<=x<8
	//this function returns a rectangle r in the scene-builder that appropriate to the coordinates x and y 
	public Rectangle getRectangle(int x, int y) {

		if(x==0 && y==1) {
			return s0;
		}
		if(x==0 && y==3) {
			return s1;
		}
		if(x==0 && y==5) {
			return s2;
		}
		if(x==0 && y==7) {
			return s3;
		}
		if(x==1 && y==0) {
			return s4;
		}
		if(x==1 && y==2) {
			return s5;
		}
		if(x==1 && y==4) {
			return s6;
		}
		if(x==1 && y==6) {
			return s7;
		}
		if(x==2 && y==1) {
			return s8;
		}
		if(x==2 && y==3) {
			return s9;
		}
		if(x==2 && y==5) {
			return s10;
		}
		if(x==2 && y==7) {
			return s11;
		}
		if(x==3 && y==0) {
			return s12;
		}
		if(x==3 && y==2) {
			return s13;
		}
		if(x==3 && y==4) {
			return s14;
		}
		if(x==3 && y==6) {
			return s15;
		}
		if(x==4 && y==1) {
			return s16;
		}
		if(x==4 && y==3) {
			return s17;
		}
		if(x==4 && y==5) {
			return s18;
		}
		if(x==4 && y==7) {
			return s19;
		}
		if(x==5 && y==0) {
			return s20;
		}
		if(x==5 && y==2) {
			return s21;
		}
		if(x==5 && y==4) {
			return s22;
		}
		if(x==5 && y==6) {
			return s23;
		}
		if(x==6 && y==1) {
			return s24;
		}
		if(x==6 && y==3) {
			return s25;
		}
		if(x==6 && y==5) {
			return s26;
		}
		if(x==6 && y==7) {
			return s27;
		}
		if(x==7 && y==0) {
			return s28;
		}
		if(x==7 && y==2) {
			return s29;
		}
		if(x==7 && y==4) {
			return s30;
		}
		if(x==7 && y==6) {
			return s31;
		}


		return null;

	}

	@FXML
	void pauseRes(ActionEvent event) {

		if (!gamethread.isPaused()) {
			gamethread.pause();
			if(turn==Soldier_COLOR_AtSquare.WHITE)
			{
				whitethread.pause();

			}
			if(turn==Soldier_COLOR_AtSquare.BLACK)
			{
				blackthread.pause();

			}		
			pauseResumeBTN.setText("Resume");
		} else {
			gamethread.resumeTimer();
			if(turn==Soldier_COLOR_AtSquare.WHITE)
			{
				whitethread.resumeTimer();

			}
			if(turn==Soldier_COLOR_AtSquare.BLACK)
			{
				blackthread.resumeTimer();

			}		

			pauseResumeBTN.setText("Pause");
		}

	}
	public void moveWhitetoLeft(int sourcex,int sourcey,int targetx ,int targety,int firstsourcex,int firstsourcey,int i)
	{
		if(board[sourcex-1][sourcey-1].getSoldierColor()==Soldier_COLOR_AtSquare.BLACK) {
			for(int j=0; j<g.getBlackPieces().length; j++) {
				if(g.getBlackPieces()[j].getLocation().getX()== sourcex-1 && g.getBlackPieces()[j].getLocation().getY()== sourcey-1) {
					// remove the soldier
					g.getBlackPieces()[j].setIsAlive(false);
					g.getBlackPieces()[j].getLocation().setX(-1);
					g.getBlackPieces()[j].getLocation().setY(-1);
					board[sourcex-1][sourcey-1].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);
					int xcsene= (firstsourcex)-60;//nzed 3l func
					System.out.println(xcsene);

					int yscene=(firstsourcey)-60;//...
					System.out.println(yscene);
					Circle c=getSoldierOnScene(xcsene,yscene);
					//**
					this.soldier.setLayoutX(xcsene-60);
					this.soldier.setLayoutY(yscene-60);
					board[sourcex][sourcey].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);
					board[targetx][targety].setSoldierColor(Soldier_COLOR_AtSquare.WHITE);

					g.getWhitePieces()[i].getLocation().setX(targetx);
					g.getWhitePieces()[i].getLocation().setY(targety);
					g.getWhitePlayer().setPoints(g.getWhitePlayer().getPoints()+100);
					wPointsValue.setText((Integer.toString(g.getWhitePlayer().getPoints())));


					if(c!=null) {
						if(c.getFill()==Color.BLACK);
						c.setVisible(false);
					}

					//turn to queen	
					if(targetx==0)	
					{	
						this.soldier.setFill(Color.BLUE);	
						for(int z=0;z<g.getWhitePieces().length;z++)	
						{	
							if(g.getWhitePieces()[z].getLocation().getX()== targetx && g.getWhitePieces()[z].getLocation().getY()== targety)	
							{	
								g.getWhitePieces()[z].setIsQueen(true);


							}	
						}	
					}	


				}
			}
		}
	}
	public void movewhitetoRight(int sourcex,int sourcey,int targetx ,int targety,int firstsourcex,int firstsourcey,int i)
	{
		if(board[sourcex-1][sourcey+1].getSoldierColor()==Soldier_COLOR_AtSquare.BLACK) {
			for(int j=0; j<g.getBlackPieces().length; j++) {
				if(g.getBlackPieces()[j].getLocation().getX()== sourcex-1 && g.getBlackPieces()[j].getLocation().getY()== sourcey+1) {
					// remove the soldier
					g.getBlackPieces()[j].setIsAlive(false);
					g.getBlackPieces()[j].getLocation().setX(-1);
					g.getBlackPieces()[j].getLocation().setY(-1);
					board[sourcex-1][sourcey+1].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);
					int xcsene= (firstsourcex)+60;//nzed 3l func
					System.out.println(xcsene);

					int yscene=(firstsourcey)-60;//...
					System.out.println(yscene);
					Circle c=getSoldierOnScene(xcsene,yscene);
					//**
					this.soldier.setLayoutX(firstsourcex+120);
					this.soldier.setLayoutY(firstsourcey-120);
					board[sourcex][sourcey].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);
					board[targetx][targety].setSoldierColor(Soldier_COLOR_AtSquare.WHITE);
					g.getWhitePieces()[i].getLocation().setX(targetx);
					g.getWhitePieces()[i].getLocation().setY(targety);
					g.getWhitePlayer().setPoints(g.getWhitePlayer().getPoints()+100);
					wPointsValue.setText((Integer.toString(g.getWhitePlayer().getPoints())));


					if(c!=null)
						if(c.getFill()==Color.BLACK);
					c.setVisible(false);


					//turn to queen	
					if(targetx==0)	
					{	
						this.soldier.setFill(Color.BLUE);	
						for(int z=0;z<g.getWhitePieces().length;z++)	
						{	
							if(g.getWhitePieces()[z].getLocation().getX()== targetx && g.getWhitePieces()[z].getLocation().getY()== targety)	
							{	
								g.getWhitePieces()[z].setIsQueen(true);	


							}	
						}	
					}	


				}
			}
		}
	}

	public void startWhiteTimer() 
	{
		whitetime=new DigitTimerGroup(WhiteTimer);
		whitethread = new TimerThread(whitetime);
		whitethread.setDaemon(true);
		whitethread.start();
		whitegreentimer = new Timer(30000, new ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent arg0) {
				CheckAndDoGreenSquare();

			}
		});
		whitegreentimer.start(); // Go go go!
		whitegreentimer.setRepeats(false); // Only execute once
		//Greentimer.stop();


		whiteorangetimer = new Timer(90000, new ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent arg0) {
				CheckAndDoOrangeSquare();
				numofYellowSquares=0;

				for(int i=0; i<8;i++) {
					for(int j=0; j<8;j++) {
						if(board[i][j]!=null) {
							if(board[i][j].getSquareColor()==SQUARE_COLOR.YELLOW) {
								numofYellowSquares++;
							}
						}
					}
				}

				while(numofYellowSquares<3) {
					CheckAndDoYellowSquares();
				}
			}
		});
		whiteorangetimer.start(); // Go go go!
		whiteorangetimer.setRepeats(false); // Only execute once





	}

	public void startBlackTimer() 
	{
		blacktime=new DigitTimerGroup(BlackTimer);
		blackthread = new TimerThread(blacktime);
		blackthread.setDaemon(true);
		blackthread.start();
		blackgreentimer = new Timer(30000, new ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent arg0) {
				CheckAndDoGreenSquare();
			}
		});

		blackgreentimer.start(); // Go go go!
		blackgreentimer.setRepeats(false); // Only execute once
		//timer.stop();

		blackorangetimer = new Timer(90000, new ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent arg0) {
				CheckAndDoOrangeSquare();
				//BlackOrangetimer.cancel();
			}
		});

		blackorangetimer.start(); // Go go go!
		blackorangetimer.setRepeats(false); // Only execute once
		//timer.stop();

	}

	public Circle newlayout(int row,int col,Circle c)	
	{	
		if(row==0)	
		{	
			c.setLayoutY(30);	
			if(!((col %2)==0))	
			{	
				c.setLayoutX(90+(Math.abs(col-1)*60));	
			}	
		}	
		if(row==1)	
		{	
			c.setLayoutY(90);	
			if(col==0)c.setLayoutX(30);	
			else	
				if(((col %2)==0))	
				{	
					c.setLayoutX(30+(Math.abs(col)*60));	
				}	
		}	
		if(row==2)	
		{	
			c.setLayoutY(150);	
			if(!((col %2)==0))	
			{	
				c.setLayoutX(90+(Math.abs(col-1)*60));	
			}	
		}	
		if(row==3)	
		{	
			c.setLayoutY(210);	
			if(col==0)c.setLayoutX(30);	
			else	
				if(((col %2)==0))	
				{	
					c.setLayoutX(30+(Math.abs(col)*60));	
				}	
		}	
		if(row==4)	
		{	
			c.setLayoutY(270);	
			if(!((col %2)==0))	
			{	
				c.setLayoutX(90+(Math.abs(col-1)*60));	
			}	
		}	
		if(row==5)	
		{	
			c.setLayoutY(330);	
			if(col==0)c.setLayoutX(30);	
			else	
				if(((col %2)==0))	
				{	
					c.setLayoutX(30+(Math.abs(col)*60));	
				}	
		}	
		if(row==6)	
		{	
			c.setLayoutY(390);	
			if(!((col %2)==0))	
			{	
				c.setLayoutX(90+(Math.abs(col-1)*60));	
			}	
		}	
		if(row==7)	
		{	
			c.setLayoutY(450);	
			if(col==0)c.setLayoutX(30);	
			else	
				if(((col %2)==0))	
				{	
					c.setLayoutX(30+(Math.abs(col)*60));	
				}	
		}	
		return c;	
	}
	public void leftBlackeat(int sourcex,int sourcey,int targetx ,int targety,int firstsourcex,int firstsourcey,int i)
	{
		if(board[sourcex+1][sourcey-1].getSoldierColor()==Soldier_COLOR_AtSquare.WHITE) {
			for(int j=0; j<g.getWhitePieces().length; j++) {
				if(g.getWhitePieces()[j].getLocation().getX()== sourcex+1 && g.getWhitePieces()[j].getLocation().getY()== sourcey-1) {
					// remove the soldier
					g.getWhitePieces()[j].setIsAlive(false);
					g.getWhitePieces()[j].getLocation().setX(-1);
					g.getWhitePieces()[j].getLocation().setY(-1);
					board[sourcex+1][sourcey-1].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);
					int xcsene= (firstsourcex)-60;//nzed 3l func
					System.out.println(xcsene);

					int yscene=(firstsourcey)+60;//...
					System.out.println(yscene);
					Circle c=getSoldierOnScene(xcsene,yscene);
					//**
					this.soldier.setLayoutX(firstsourcex-120);
					this.soldier.setLayoutY(firstsourcey+120);
					board[sourcex][sourcey].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);
					board[targetx][targety].setSoldierColor(Soldier_COLOR_AtSquare.BLACK);
					g.getBlackPieces()[i].getLocation().setX(targetx);
					g.getBlackPieces()[i].getLocation().setY(targety);
					g.getBlackPlayer().setPoints(g.getBlackPlayer().getPoints()+100);
					System.out.println("791");
					bPointsValue.setText((Integer.toString(g.getBlackPlayer().getPoints())));


					if(c!=null)
						if(c.getFill()==Color.WHITE)
							c.setVisible(false);

					//turn to queen	
					if(targetx==7)	
					{	
						this.soldier.setFill(Color.BROWN);	
						for(int z=0;z<g.getBlackPieces().length;z++)	
						{	
							if(g.getBlackPieces()[z].getLocation().getX()== targetx && g.getBlackPieces()[z].getLocation().getY()== targety)	
							{	
								g.getBlackPieces()[z].setIsQueen(true);	


							}	
						}	
					}
				}
			}
		}
	}
	public void rightBlackeat(int sourcex,int sourcey,int targetx ,int targety,int firstsourcex,int firstsourcey,int i)
	{
		if(board[sourcex+1][sourcey+1].getSoldierColor()==Soldier_COLOR_AtSquare.WHITE) {
			for(int j=0; j<g.getWhitePieces().length; j++) {
				if(g.getWhitePieces()[j].getLocation().getX()== sourcex+1 && g.getWhitePieces()[j].getLocation().getY()== sourcey+1) {
					// remove the white soldier

					g.getWhitePieces()[j].setIsAlive(false);
					g.getWhitePieces()[j].getLocation().setX(-1);
					g.getWhitePieces()[j].getLocation().setY(-1);
					board[sourcex+1][sourcey+1].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);
					int xcsene= (firstsourcex)+60;//nzed 3l func
					System.out.println(xcsene);

					int yscene=(firstsourcey)+60;//...
					System.out.println(yscene);
					Circle c=getSoldierOnScene(xcsene,yscene);
					//**
					this.soldier.setLayoutX(firstsourcex+120);
					this.soldier.setLayoutY(firstsourcey+120);
					board[sourcex][sourcey].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);
					board[targetx][targety].setSoldierColor(Soldier_COLOR_AtSquare.BLACK);
					g.getBlackPieces()[i].getLocation().setX(targetx);
					g.getBlackPieces()[i].getLocation().setY(targety);
					g.getBlackPlayer().setPoints(g.getBlackPlayer().getPoints()+100);
					System.out.println("736");
					bPointsValue.setText((Integer.toString(g.getBlackPlayer().getPoints())));



					if(c!=null)
						//ethar and maisa
						if(c.getFill()==Color.WHITE)
							c.setVisible(false);


					//turn to queen	
					if(targetx==7)	
					{	
						this.soldier.setFill(Color.BROWN);	
						for(int z=0;z<g.getBlackPieces().length;z++)	
						{	
							if(g.getBlackPieces()[z].getLocation().getX()== targetx && g.getBlackPieces()[z].getLocation().getY()== targety)	
							{	
								g.getBlackPieces()[z].setIsQueen(true);	


							}	
						}	
					}


				}
			}
		}
	}
	public void changeturntowhite()
	{
		turn = Soldier_COLOR_AtSquare.WHITE;

		blackgreentimer.stop();
		blackorangetimer.stop();
		TurnLbl.setText("Its the White turn");
		if(blackthread!=null)
			blackthread.interrupt();
		startWhiteTimer();

		endblack=System.nanoTime();
		startwhite=System.nanoTime();



		this.soldier=null;
		this.target=null;
	}
	public void changeturntoBlack()
	{
		turn = Soldier_COLOR_AtSquare.BLACK;

		whitegreentimer.stop();
		whiteorangetimer.stop();
		TurnLbl.setText("Its the Black turn");
		if(whitethread!=null)
			whitethread.interrupt();
		startBlackTimer();

		endwhite=System.nanoTime();
		startblack=System.nanoTime();



		this.soldier=null;
		this.target=null;
	}
	public void MoveWhiteQueen(int sourcex,int sourcey,int targetx ,int targety,int i)
	{
		int queeneat= g.getWhitePieces()[i].QueenEat(board, sourcex, sourcey, targetx, targety, Soldier_COLOR_AtSquare.WHITE);
		int queenmove= g.getWhitePieces()[i].QueenMove(board, sourcex, sourcey, targetx, targety, Soldier_COLOR_AtSquare.WHITE);	
		if(queenmove == 0)	
		{	

			Circle c=newlayout(targetx, targety, this.soldier);	

			this.soldier.setLayoutX(c.getLayoutX());	
			this.soldier.setLayoutY(c.getLayoutY());	

			if(targetx<7 && targety>0)
			{
				if(board[targetx+1][targety-1].getSoldierColor()== Soldier_COLOR_AtSquare.BLACK &&( queeneat==1 || queeneat==4) )
				{

					Circle cc=getSoldierOnScene((int)c.getLayoutX()-60,(int)c.getLayoutY()+60);
					cc.setVisible(false);
					board[targetx+1][targety-1].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);
					for(int k=0; k<g.getBlackPieces().length; k++) {
						if(g.getBlackPieces()[k].getLocation().getX()== targetx+1 && g.getBlackPieces()[k].getLocation().getY()== targety-1) {

							g.getBlackPieces()[k].setIsAlive(false);
							g.getBlackPieces()[k].getLocation().setX(-1);
							g.getBlackPieces()[k].getLocation().setY(-1);


						}
					}

				}
			}
			if( targety<7 && targetx<7)
			{
				if(board[targetx+1][targety+1].getSoldierColor()== Soldier_COLOR_AtSquare.BLACK && (queeneat==2 || queeneat==3) )
				{


					Circle cc=getSoldierOnScene((int)c.getLayoutX()+60,(int)c.getLayoutY()+60);
					cc.setVisible(false);
					board[targetx+1][targety+1].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);
					for(int k=0; k<g.getBlackPieces().length; k++) {
						if(g.getBlackPieces()[k].getLocation().getX()== targetx+1 && g.getBlackPieces()[k].getLocation().getY()== targety+1) {

							g.getBlackPieces()[k].setIsAlive(false);
							g.getBlackPieces()[k].getLocation().setX(-1);
							g.getBlackPieces()[k].getLocation().setY(-1);


						}
					}

				}
			}
			if(targetx>0 && targety>0) {
				if(board[targetx-1][targety-1].getSoldierColor()== Soldier_COLOR_AtSquare.BLACK && (queeneat==3 || queeneat==2) )
				{


					Circle cc=getSoldierOnScene((int)c.getLayoutX()-60,(int)c.getLayoutY()-60);
					cc.setVisible(false);
					board[targetx-1][targety-1].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);
					for(int k=0; k<g.getBlackPieces().length; k++) {
						if(g.getBlackPieces()[k].getLocation().getX()== targetx-1 && g.getBlackPieces()[k].getLocation().getY()== targety-1) {

							g.getBlackPieces()[k].setIsAlive(false);
							g.getBlackPieces()[k].getLocation().setX(-1);
							g.getBlackPieces()[k].getLocation().setY(-1);


						}
					}

				}
			}
			if(targetx >0 && targety<7)
			{
				if(board[targetx-1][targety+1].getSoldierColor()== Soldier_COLOR_AtSquare.BLACK && (queeneat==4 ||  queeneat==1) )
				{


					Circle cc=getSoldierOnScene((int)c.getLayoutX()+60,(int)c.getLayoutY()-60);
					cc.setVisible(false);
					board[targetx-1][targety+1].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);
					for(int k=0; k<g.getBlackPieces().length; k++) {
						if(g.getBlackPieces()[k].getLocation().getX()== targetx-1 && g.getBlackPieces()[k].getLocation().getY()== targety+1) {

							g.getBlackPieces()[k].setIsAlive(false);
							g.getBlackPieces()[k].getLocation().setX(-1);
							g.getBlackPieces()[k].getLocation().setY(-1);


						}
					}

				}
			}


		}	
		if(queenmove ==-1)
		{
			this.soldier.setVisible(false);
		}

		else
			System.out.println("not legal queen move");
	}
	public void MoveBlackQueen(int sourcex,int sourcey,int targetx ,int targety,int i)
	{

		int queeneat= g.getBlackPieces()[i].QueenEat(board, sourcex, sourcey, targetx, targety, Soldier_COLOR_AtSquare.BLACK);
		int queenmove= g.getBlackPieces()[i].QueenMove(board, sourcex, sourcey, targetx, targety, Soldier_COLOR_AtSquare.BLACK);	
		if(queenmove == 0)	
		{	

			Circle c=newlayout(targetx, targety, this.soldier);	

			this.soldier.setLayoutX(c.getLayoutX());	
			this.soldier.setLayoutY(c.getLayoutY());
			redSoldier=null;
			if(targetx<7 && targety>0)
			{
				if(board[targetx+1][targety-1].getSoldierColor()== Soldier_COLOR_AtSquare.WHITE && queeneat==1 )
				{


					Circle cc=getSoldierOnScene((int)c.getLayoutX()-60,(int)c.getLayoutY()+60);
					cc.setVisible(false);
					board[targetx+1][targety-1].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);
					for(int k=0; k<g.getWhitePieces().length; k++) {
						if(g.getWhitePieces()[k].getLocation().getX()== targetx+1 && g.getWhitePieces()[k].getLocation().getY()== targety-1) {
							g.getWhitePieces()[k].setIsAlive(false);
							g.getWhitePieces()[k].getLocation().setX(-1);
							g.getWhitePieces()[k].getLocation().setY(-1);


						}
					}

				}
			}
			if( targety<7 && targetx<7)
			{
				if(board[targetx+1][targety+1].getSoldierColor()== Soldier_COLOR_AtSquare.WHITE && queeneat==2 )
				{


					Circle cc=getSoldierOnScene((int)c.getLayoutX()+60,(int)c.getLayoutY()+60);
					cc.setVisible(false);
					board[targetx+1][targety+1].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);
					for(int k=0; k<g.getWhitePieces().length; k++) {
						if(g.getWhitePieces()[k].getLocation().getX()== targetx+1 && g.getWhitePieces()[k].getLocation().getY()== targety+1) {

							g.getWhitePieces()[k].setIsAlive(false);
							g.getWhitePieces()[k].getLocation().setX(-1);
							g.getWhitePieces()[k].getLocation().setY(-1);


						}
					}

				}
			}
			if(targetx>0 && targety>0) {
				if(board[targetx-1][targety-1].getSoldierColor()== Soldier_COLOR_AtSquare.WHITE && queeneat==3 )
				{


					Circle cc=getSoldierOnScene((int)c.getLayoutX()-60,(int)c.getLayoutY()-60);
					cc.setVisible(false);
					board[targetx-1][targety-1].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);
					for(int k=0; k<g.getWhitePieces().length; k++) {
						if(g.getWhitePieces()[k].getLocation().getX()== targetx-1 && g.getWhitePieces()[k].getLocation().getY()== targety-1) {

							g.getWhitePieces()[k].setIsAlive(false);
							g.getWhitePieces()[k].getLocation().setX(-1);
							g.getWhitePieces()[k].getLocation().setY(-1);


						}
					}

				}
			}
			if(targetx >0 && targety<7)
			{
				if(board[targetx-1][targety+1].getSoldierColor()== Soldier_COLOR_AtSquare.WHITE && queeneat==4 )
				{


					Circle cc=getSoldierOnScene((int)c.getLayoutX()+60,(int)c.getLayoutY()-60);
					cc.setVisible(false);
					board[targetx-1][targety+1].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);
					for(int k=0; k<g.getWhitePieces().length; k++) {
						if(g.getWhitePieces()[k].getLocation().getX()== targetx-1 && g.getWhitePieces()[k].getLocation().getY()== targety+1) {

							g.getWhitePieces()[k].setIsAlive(false);
							g.getWhitePieces()[k].getLocation().setX(-1);
							g.getWhitePieces()[k].getLocation().setY(-1);


						}
					}

				}
			}

		}	


		if(queenmove ==-1)
		{
			this.soldier.setVisible(false);
		}

		else
			System.out.println("not legal queen move");
	}
	
	


//func to eating again at the same soldier
	private void eatingAgain(Soldier s,int sourcex, int sourcey,int targetx, int targety) {
		System.out.println("Wlk foooooottttt 3l eating again");
		int firstsourcex=(int) this.soldier.getLayoutX();
		int firstsourcey=(int) this.soldier.getLayoutY();
		int xcsene;
		int ycsene;
		
		//case player is White
		if(s.getColor()==Soldier_COLOR_AtSquare.WHITE) {
			

				//get the location of the player
				int x=s.getLocation().getX();
				int y=s.getLocation().getY();
				//Choosing to eat at yellow square
				if(board[targetx][targety].getSquareColor()==SQUARE_COLOR.YELLOW) {
					SoldierChooseYellow(sourcex,sourcey,targetx,targety,firstsourcex,firstsourcey);
					
				}
				if(s.isIsQueen()==false)
				{
					if((y==0 && x==1) || (y==1 && x==0)) {
						if(targetx==x+2 && targety==y+2 && ((g.getBoard()[x+1][y+1].getSoldierColor())==(Soldier_COLOR_AtSquare.BLACK) && g.getBoard()[x+2][y+2].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY)) {
							//remove the soldier
							g.getBoard()[x+1][y+1].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);
							for(int i=0;i<g.getBlackPieces().length;i++) {
								if(g.getBlackPieces()[i].getLocation().getX()==x+1 && g.getBlackPieces()[i].getLocation().getY()==y+1) {
									g.getBlackPieces()[i].setIsAlive(false);
									g.getBlackPieces()[i].getLocation().setX(-1);
									g.getBlackPieces()[i].getLocation().setY(-1);
									//3
									xcsene= (firstsourcex)+60;//nzed 3l func
									System.out.println(xcsene);

									ycsene=(firstsourcey)+60;//...
									System.out.println(ycsene);
									Circle c=getSoldierOnScene(xcsene,ycsene);
									c.setVisible(false);
								}
							}
							
								//move the soldier
							for(int i=0;i<g.getWhitePieces().length;i++) {
								if(g.getWhitePieces()[i].getLocation().getX()==x && g.getWhitePieces()[i].getLocation().getY()==y) {
									//setPoints
									g.getWhitePlayer().setPoints(g.getWhitePlayer().getPoints()+100);
									wPointsValue.setText((Integer.toString(g.getWhitePlayer().getPoints())));
									//1
									g.getBoard()[x][y].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);
									g.getBoard()[x+2][y+2].setSoldierColor(Soldier_COLOR_AtSquare.WHITE);
									//2
									g.getWhitePieces()[i].getLocation().setX(x+2);
									g.getWhitePieces()[i].getLocation().setY(y+2);
									//3
									this.soldier=newlayout(x+2,y+2,this.soldier);
								}
								
								}
							
							
							if(g.eatingMore(eatSoldier)==true) {
							eatingAgain(eatSoldier,sourcex,sourcey,targetx,targety);
							eatSoldier=null;
							return;

							}
							return;
						}
						
					}
					if((y==0 && x==7) || (y==1&& x==6)) {
						if(targetx==x-2 && targety==y+2 && ((g.getBoard()[x-1][y+1].getSoldierColor())==(Soldier_COLOR_AtSquare.BLACK) && g.getBoard()[x-2][y+2].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY)) {
							//remove the soldier
							g.getBoard()[x-1][y+1].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);
							for(int i=0;i<g.getBlackPieces().length;i++) {
								if(g.getBlackPieces()[i].getLocation().getX()==x-1 && g.getBlackPieces()[i].getLocation().getY()==y+1) {
									g.getBlackPieces()[i].setIsAlive(false);
									g.getBlackPieces()[i].getLocation().setX(-1);
									g.getBlackPieces()[i].getLocation().setY(-1);
									//3
									
									xcsene= (firstsourcex)+60;//nzed 3l func
									System.out.println(xcsene);

									ycsene=(firstsourcey)-60;//...
									System.out.println(ycsene);
									Circle c=getSoldierOnScene(xcsene,ycsene);
									c.setVisible(false);
								}
							}
							
								//move the soldier
							for(int i=0;i<g.getWhitePieces().length;i++) {
								if(g.getWhitePieces()[i].getLocation().getX()==x && g.getWhitePieces()[i].getLocation().getY()==y) {
									//setPoints
									g.getWhitePlayer().setPoints(g.getWhitePlayer().getPoints()+100);
									wPointsValue.setText((Integer.toString(g.getWhitePlayer().getPoints())));
									//1
									g.getBoard()[x][y].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);
									g.getBoard()[x-2][y+2].setSoldierColor(Soldier_COLOR_AtSquare.WHITE);
									//2
									g.getWhitePieces()[i].getLocation().setX(x-2);
									g.getWhitePieces()[i].getLocation().setY(y+2);
									//3
									this.soldier=newlayout(x-2,y+2,this.soldier);
								}
								
								}
							
							if(g.eatingMore(eatSoldier)==false) {
								eatSoldier=null;
								changeturntoBlack();
								return;
				
								 }
							return;
						}
						
					}
					if((y==0 && (x==3|| x==5)) || (y==1 && (x==2 ||x==4))) {
						if(targetx==x-2 && targety==y+2 && ((g.getBoard()[x-1][y+1].getSoldierColor())==(Soldier_COLOR_AtSquare.BLACK) && g.getBoard()[x-2][y+2].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY)) {
							//remove the soldier
							g.getBoard()[x-1][y+1].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);
							for(int i=0;i<g.getBlackPieces().length;i++) {
								if(g.getBlackPieces()[i].getLocation().getX()==x-1 && g.getBlackPieces()[i].getLocation().getY()==y+1) {
									g.getBlackPieces()[i].setIsAlive(false);
									g.getBlackPieces()[i].getLocation().setX(-1);
									g.getBlackPieces()[i].getLocation().setY(-1);
									//3
									
									xcsene= (firstsourcex)+60;//nzed 3l func
									System.out.println(xcsene);

									ycsene=(firstsourcey)-60;//...
									System.out.println(ycsene);
									Circle c=getSoldierOnScene(xcsene,ycsene);
									c.setVisible(false);
								}
							}
							
								//move the soldier
							for(int i=0;i<g.getWhitePieces().length;i++) {
								if(g.getWhitePieces()[i].getLocation().getX()==x && g.getWhitePieces()[i].getLocation().getY()==y) {
									//setPoints
									g.getWhitePlayer().setPoints(g.getWhitePlayer().getPoints()+100);
									wPointsValue.setText((Integer.toString(g.getWhitePlayer().getPoints())));
									//1
									g.getBoard()[x][y].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);
									g.getBoard()[x-2][y+2].setSoldierColor(Soldier_COLOR_AtSquare.WHITE);
									//2
									g.getWhitePieces()[i].getLocation().setX(x-2);
									g.getWhitePieces()[i].getLocation().setY(y+2);
									//3
									this.soldier=newlayout(x-2,y+2,this.soldier);
								}
								
								}
							if(g.eatingMore(eatSoldier)==false) {
								eatSoldier=null;
								changeturntoBlack();
								return;
				
							}
							return;	
							
						}
						
						
						if(targetx==x+2 && targety==y+2 && ((g.getBoard()[x+1][y+1].getSoldierColor())==(Soldier_COLOR_AtSquare.BLACK) && g.getBoard()[x+2][y+2].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY)) {
							//remove the soldier
							g.getBoard()[x+1][y+1].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);
							for(int i=0;i<g.getBlackPieces().length;i++) {
								if(g.getBlackPieces()[i].getLocation().getX()==x+1 && g.getBlackPieces()[i].getLocation().getY()==y+1) {
									g.getBlackPieces()[i].setIsAlive(false);
									g.getBlackPieces()[i].getLocation().setX(-1);
									g.getBlackPieces()[i].getLocation().setY(-1);
									//3
									xcsene= (firstsourcex)+60;//nzed 3l func
									System.out.println(xcsene);

									ycsene=(firstsourcey)+60;//...
									System.out.println(ycsene);
									Circle c=getSoldierOnScene(xcsene,ycsene);
									c.setVisible(false);
								}
							}
							
								//move the soldier
							for(int i=0;i<g.getWhitePieces().length;i++) {
								if(g.getWhitePieces()[i].getLocation().getX()==x && g.getWhitePieces()[i].getLocation().getY()==y) {
									//setPoints
									g.getWhitePlayer().setPoints(g.getWhitePlayer().getPoints()+100);
									wPointsValue.setText((Integer.toString(g.getWhitePlayer().getPoints())));
									//1
									g.getBoard()[x][y].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);
									g.getBoard()[x+2][y+2].setSoldierColor(Soldier_COLOR_AtSquare.WHITE);
									//2
									g.getWhitePieces()[i].getLocation().setX(x+2);
									g.getWhitePieces()[i].getLocation().setY(y+2);
									//3
									this.soldier=newlayout(x+2,y+2,this.soldier);
								}
								
								}
							
							if(g.eatingMore(eatSoldier)==false) {
								eatSoldier=null;
								changeturntoBlack();
								return;
				
								}
							return;	
						}
						
					}
					
					
					if(y==0 && x==1) {
						if(targetx==x+2 && targety==y+2 && ((g.getBoard()[x+1][y+1].getSoldierColor())==(Soldier_COLOR_AtSquare.BLACK) && g.getBoard()[x+2][y+2].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY)) {
							//remove the soldier
							g.getBoard()[x+1][y+1].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);
							for(int i=0;i<g.getBlackPieces().length;i++) {
								if(g.getBlackPieces()[i].getLocation().getX()==x+1 && g.getBlackPieces()[i].getLocation().getY()==y+1) {
									g.getBlackPieces()[i].setIsAlive(false);
									g.getBlackPieces()[i].getLocation().setX(-1);
									g.getBlackPieces()[i].getLocation().setY(-1);
									//3
									xcsene= (firstsourcex)+60;//nzed 3l func
									System.out.println(xcsene);

									ycsene=(firstsourcey)+60;//...
									System.out.println(ycsene);
									Circle c=getSoldierOnScene(xcsene,ycsene);
									c.setVisible(false);
								}
							}
							
								//move the soldier
							for(int i=0;i<g.getWhitePieces().length;i++) {
								if(g.getWhitePieces()[i].getLocation().getX()==x && g.getWhitePieces()[i].getLocation().getY()==y) {
									//setPoints
									g.getWhitePlayer().setPoints(g.getWhitePlayer().getPoints()+100);
									wPointsValue.setText((Integer.toString(g.getWhitePlayer().getPoints())));
									//1
									g.getBoard()[x][y].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);

									g.getBoard()[x+2][y+2].setSoldierColor(Soldier_COLOR_AtSquare.WHITE);
									//2
									g.getWhitePieces()[i].getLocation().setX(x+2);
									g.getWhitePieces()[i].getLocation().setY(y+2);
									//3
									this.soldier=newlayout(x+2,y+2,this.soldier);
								}
								
								}
							if(g.eatingMore(eatSoldier)==false) {
								eatSoldier=null;
								changeturntoBlack();
								return;
				
								}
							return;
							
						}
					
					}
					if((y==7 && x==0) || (y==6 && x==1)){
						if(targetx==x+2 && targety==y-2 && ((g.getBoard()[x+1][y-1].getSoldierColor())==(Soldier_COLOR_AtSquare.BLACK) && g.getBoard()[x+2][y-2].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY)) {
							//remove the soldier
							g.getBoard()[x+1][y-1].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);
							for(int i=0;i<g.getBlackPieces().length;i++) {
								if(g.getBlackPieces()[i].getLocation().getX()==x+1 && g.getBlackPieces()[i].getLocation().getY()==y-1) {
									g.getBlackPieces()[i].setIsAlive(false);
									g.getBlackPieces()[i].getLocation().setX(-1);
									g.getBlackPieces()[i].getLocation().setY(-1);
									//3
									xcsene= (firstsourcex)-60;//nzed 3l func
									System.out.println(xcsene);

									ycsene=(firstsourcey)+60;//...
									System.out.println(ycsene);
									Circle c=getSoldierOnScene(xcsene,ycsene);
									c.setVisible(false);
								}
							}
							
								//move the soldier
							for(int i=0;i<g.getWhitePieces().length;i++) {
								if(g.getWhitePieces()[i].getLocation().getX()==x && g.getWhitePieces()[i].getLocation().getY()==y) {
									//setPoints
									g.getWhitePlayer().setPoints(g.getWhitePlayer().getPoints()+100);
									wPointsValue.setText((Integer.toString(g.getWhitePlayer().getPoints())));
									//1
									g.getBoard()[x][y].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);

									g.getBoard()[x+2][y-2].setSoldierColor(Soldier_COLOR_AtSquare.WHITE);
									//2
									g.getWhitePieces()[i].getLocation().setX(x+2);
									g.getWhitePieces()[i].getLocation().setY(y-2);
									//3
									this.soldier=newlayout(x+2,y-2,this.soldier);
								}
								
								}
							if(g.eatingMore(eatSoldier)==false) {
								eatSoldier=null;
								changeturntoBlack();
								return;
				
								}
							return;
							
						}
					
					}
					if((y==7 && (x==2|| x==4)) || (y==6&& (x==3||x==5))) {
						if(targetx==x-2 && targety==y-2 && ((g.getBoard()[x-1][y-1].getSoldierColor())==(Soldier_COLOR_AtSquare.BLACK) && g.getBoard()[x-2][y-2].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY)) {
							//remove the soldier
							g.getBoard()[x-1][y-1].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);
							for(int i=0;i<g.getBlackPieces().length;i++) {
								if(g.getBlackPieces()[i].getLocation().getX()==x-1 && g.getBlackPieces()[i].getLocation().getY()==y-1) {
									g.getBlackPieces()[i].setIsAlive(false);
									g.getBlackPieces()[i].getLocation().setX(-1);
									g.getBlackPieces()[i].getLocation().setY(-1);
									//3
									
									xcsene= (firstsourcex)-60;//nzed 3l func
									System.out.println(xcsene);

									ycsene=(firstsourcey)-60;//...
									System.out.println(ycsene);
									Circle c=getSoldierOnScene(xcsene,ycsene);
									c.setVisible(false);
								}
							}
							
								//move the soldier
							for(int i=0;i<g.getWhitePieces().length;i++) {
								if(g.getWhitePieces()[i].getLocation().getX()== x&& g.getWhitePieces()[i].getLocation().getY()==y) {
									//setPoints
									g.getWhitePlayer().setPoints(g.getWhitePlayer().getPoints()+100);
									wPointsValue.setText((Integer.toString(g.getWhitePlayer().getPoints())));
									//1
									g.getBoard()[x][y].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);

									g.getBoard()[x-2][y-2].setSoldierColor(Soldier_COLOR_AtSquare.WHITE);
									//2
									g.getWhitePieces()[i].getLocation().setX(x-2);
									g.getWhitePieces()[i].getLocation().setY(y-2);
									//3
									this.soldier=newlayout(x-2,y-2,this.soldier);
								}
								
								}
							
							if(g.eatingMore(eatSoldier)==false) {
								eatSoldier=null;
								changeturntoBlack();
								return;
				
								}
							return;
						}
						
						
						if(targetx==x+2 && targety==y-2 && ((g.getBoard()[x+1][y-1].getSoldierColor())==(Soldier_COLOR_AtSquare.BLACK) && g.getBoard()[x+2][y-2].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY)) {
							//remove the soldier
							g.getBoard()[x+1][y-1].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);
							for(int i=0;i<g.getBlackPieces().length;i++) {
								if(g.getBlackPieces()[i].getLocation().getX()==x+1 && g.getBlackPieces()[i].getLocation().getY()==y-1) {
									g.getBlackPieces()[i].setIsAlive(false);
									g.getBlackPieces()[i].getLocation().setX(-1);
									g.getBlackPieces()[i].getLocation().setY(-1);
									//3
									xcsene= (firstsourcex)-60;//nzed 3l func
									System.out.println(xcsene);

									ycsene=(firstsourcey)+60;//...
									System.out.println(ycsene);
									Circle c=getSoldierOnScene(xcsene,ycsene);
									c.setVisible(false);
								}
							}
							
								//move the soldier
							for(int i=0;i<g.getWhitePieces().length;i++) {
								if(g.getWhitePieces()[i].getLocation().getX()==x && g.getWhitePieces()[i].getLocation().getY()==y) {
									//setPoints
									g.getWhitePlayer().setPoints(g.getWhitePlayer().getPoints()+100);
									wPointsValue.setText((Integer.toString(g.getWhitePlayer().getPoints())));
									//1
									g.getBoard()[x][y].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);

									g.getBoard()[x+2][y-2].setSoldierColor(Soldier_COLOR_AtSquare.WHITE);
									//2
									g.getWhitePieces()[i].getLocation().setX(x+2);
									g.getWhitePieces()[i].getLocation().setY(y-2);
									//3
									this.soldier=newlayout(x+2,y-2,this.soldier);
								}
								
								}
							
							if(g.eatingMore(eatSoldier)==false) {
								eatSoldier=null;
								changeturntoBlack();
								return;
				
								}
							return;	
						}
						
					}
					if((y==7 && x==6) || (y==6 && x==7)) {
						if(targetx==x-2 && targety==y-2 && ((g.getBoard()[x-1][y-1].getSoldierColor())==(Soldier_COLOR_AtSquare.BLACK) && g.getBoard()[x-2][y-2].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY)) {
							//remove the soldier
							g.getBoard()[x-1][y-1].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);
							for(int i=0;i<g.getBlackPieces().length;i++) {
								if(g.getBlackPieces()[i].getLocation().getX()==x-1 && g.getBlackPieces()[i].getLocation().getY()==y-1) {
									g.getBlackPieces()[i].setIsAlive(false);
									g.getBlackPieces()[i].getLocation().setX(-1);
									g.getBlackPieces()[i].getLocation().setY(-1);
									//3
									
									xcsene= (firstsourcex)-60;//nzed 3l func
									System.out.println(xcsene);

									ycsene=(firstsourcey)-60;//...
									System.out.println(ycsene);
									Circle c=getSoldierOnScene(xcsene,ycsene);
									c.setVisible(false);
								}
							}
							
								//move the soldier
							for(int i=0;i<g.getWhitePieces().length;i++) {
								if(g.getWhitePieces()[i].getLocation().getX()==x && g.getWhitePieces()[i].getLocation().getY()==y) {
									//setPoints
									g.getWhitePlayer().setPoints(g.getWhitePlayer().getPoints()+100);
									wPointsValue.setText((Integer.toString(g.getWhitePlayer().getPoints())));
									//1
									g.getBoard()[x][y].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);

									g.getBoard()[x-2][y-2].setSoldierColor(Soldier_COLOR_AtSquare.WHITE);
									//2
									g.getWhitePieces()[i].getLocation().setX(x-2);
									g.getWhitePieces()[i].getLocation().setY(y-2);
									//3
									this.soldier=newlayout(x-2,y-2,this.soldier);
								}
								
								}
							
							if(g.eatingMore(eatSoldier)==false) {
								eatSoldier=null;
								changeturntoBlack();
								return;
				
								}
							return;
						}
						
					}
				
							if(x==0 || x==1)  {
								if(targetx==x+2 && targety==y-2 && ((g.getBoard()[x+1][y-1].getSoldierColor())==(Soldier_COLOR_AtSquare.BLACK) && g.getBoard()[x+2][y-2].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY)) {
									//remove the soldier
									g.getBoard()[x+1][y-1].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);
									for(int i=0;i<g.getBlackPieces().length;i++) {
										if(g.getBlackPieces()[i].getLocation().getX()==x+1 && g.getBlackPieces()[i].getLocation().getY()==y-1) {
											g.getBlackPieces()[i].setIsAlive(false);
											g.getBlackPieces()[i].getLocation().setX(-1);
											g.getBlackPieces()[i].getLocation().setY(-1);
											//3
											xcsene= (firstsourcex)-60;//nzed 3l func
											System.out.println(xcsene);

											ycsene=(firstsourcey)+60;//...
											System.out.println(ycsene);
											Circle c=getSoldierOnScene(xcsene,ycsene);
											c.setVisible(false);
										}
									}
									
										//move the soldier
									for(int i=0;i<g.getWhitePieces().length;i++) {
										if(g.getWhitePieces()[i].getLocation().getX()==x && g.getWhitePieces()[i].getLocation().getY()==y) {
											
											//setPoints
											g.getWhitePlayer().setPoints(g.getWhitePlayer().getPoints()+100);
											wPointsValue.setText((Integer.toString(g.getWhitePlayer().getPoints())));
											//1
											g.getBoard()[x][y].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);

											g.getBoard()[x+2][y-2].setSoldierColor(Soldier_COLOR_AtSquare.WHITE);
											//2
											g.getWhitePieces()[i].getLocation().setX(x+2);
											g.getWhitePieces()[i].getLocation().setY(y-2);
											//3
											this.soldier=newlayout(x+2,y-2,this.soldier);
										}
										
										}
									if(g.eatingMore(eatSoldier)==false) {
										eatSoldier=null;
										changeturntoBlack();
										return;
						
										}
									
									return;
								}
								if(targetx==x+2 && targety==y+2 && ((g.getBoard()[x+1][y+1].getSoldierColor())==(Soldier_COLOR_AtSquare.BLACK) && g.getBoard()[x+2][y+2].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY)) {
									//remove the soldier
									g.getBoard()[x+1][y+1].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);
									for(int i=0;i<g.getBlackPieces().length;i++) {
										if(g.getBlackPieces()[i].getLocation().getX()==x+1 && g.getBlackPieces()[i].getLocation().getY()==y+1) {
											g.getBlackPieces()[i].setIsAlive(false);
											g.getBlackPieces()[i].getLocation().setX(-1);
											g.getBlackPieces()[i].getLocation().setY(-1);
											//3
											xcsene= (firstsourcex)+60;//nzed 3l func
											System.out.println(xcsene);

											ycsene=(firstsourcey)+60;//...
											System.out.println(ycsene);
											Circle c=getSoldierOnScene(xcsene,ycsene);
											c.setVisible(false);
										}
									}
									
										//move the soldier
									for(int i=0;i<g.getWhitePieces().length;i++) {
										if(g.getWhitePieces()[i].getLocation().getX()==x && g.getWhitePieces()[i].getLocation().getY()==y) {
											//setPoints
											g.getWhitePlayer().setPoints(g.getWhitePlayer().getPoints()+100);
											wPointsValue.setText((Integer.toString(g.getWhitePlayer().getPoints())));
											
											//1
											g.getBoard()[x][y].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);

											g.getBoard()[x+2][y+2].setSoldierColor(Soldier_COLOR_AtSquare.WHITE);
											//2
											g.getWhitePieces()[i].getLocation().setX(x+2);
											g.getWhitePieces()[i].getLocation().setY(y+2);
											//3
											this.soldier=newlayout(x+2,y+2,this.soldier);
										}
										
										}
									
									if(g.eatingMore(eatSoldier)==false) {
										eatSoldier=null;
										changeturntoBlack();
										return;
						
										}
									return;
								}
								
							}
							
							if(x==6 || x==7)  {
								if(targetx==x-2 && targety==y-2 && ((g.getBoard()[x-1][y-1].getSoldierColor())==(Soldier_COLOR_AtSquare.BLACK) && g.getBoard()[x-2][y-2].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY)) {
									//remove the soldier
									g.getBoard()[x-1][y-1].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);
									for(int i=0;i<g.getBlackPieces().length;i++) {
										if(g.getBlackPieces()[i].getLocation().getX()==x-1 && g.getBlackPieces()[i].getLocation().getY()==y-1) {
											g.getBlackPieces()[i].setIsAlive(false);
											g.getBlackPieces()[i].getLocation().setX(-1);
											g.getBlackPieces()[i].getLocation().setY(-1);
											//3
											xcsene= (firstsourcex)-60;//nzed 3l func
											System.out.println(xcsene);
											ycsene=(firstsourcey)-60;//...
											System.out.println(ycsene);
											Circle c=getSoldierOnScene(xcsene,ycsene);
											c.setVisible(false);
										}
									}
									
										//move the soldier
									for(int i=0;i<g.getWhitePieces().length;i++) {
										if(g.getWhitePieces()[i].getLocation().getX()==x && g.getWhitePieces()[i].getLocation().getY()==y) {
											//setPoints
											g.getWhitePlayer().setPoints(g.getWhitePlayer().getPoints()+100);
											wPointsValue.setText((Integer.toString(g.getWhitePlayer().getPoints())));
											//1
											g.getBoard()[x][y].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);

											g.getBoard()[x-2][y-2].setSoldierColor(Soldier_COLOR_AtSquare.WHITE);
											//2
											g.getWhitePieces()[i].getLocation().setX(x-2);
											g.getWhitePieces()[i].getLocation().setY(y-2);
											//3
											this.soldier=newlayout(x-2,y-2,this.soldier);
										}
										
										}
									
									if(g.eatingMore(eatSoldier)==false) {
										eatSoldier=null;
										changeturntoBlack();
										return;
						
										}
									return;
								}
								if(targetx==x-2 && targety==y+2 && ((g.getBoard()[x-1][y+1].getSoldierColor())==(Soldier_COLOR_AtSquare.BLACK) && g.getBoard()[x-2][y+2].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY)) {
									//remove the soldier
									g.getBoard()[x-1][y+1].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);
									for(int i=0;i<g.getBlackPieces().length;i++) {
										if(g.getBlackPieces()[i].getLocation().getX()==x+1 && g.getBlackPieces()[i].getLocation().getY()==y+1) {
											g.getBlackPieces()[i].setIsAlive(false);
											g.getBlackPieces()[i].getLocation().setX(-1);
											g.getBlackPieces()[i].getLocation().setY(-1);
											//3
											xcsene= (firstsourcex)+60;//nzed 3l func
											System.out.println(xcsene);

											ycsene=(firstsourcey)-60;//...
											System.out.println(ycsene);
											Circle c=getSoldierOnScene(xcsene,ycsene);
											c.setVisible(false);
										}
									}
									
										//move the soldier
									for(int i=0;i<g.getWhitePieces().length;i++) {
										if(g.getWhitePieces()[i].getLocation().getX()==x && g.getWhitePieces()[i].getLocation().getY()==y) {
											//setPoints
											g.getWhitePlayer().setPoints(g.getWhitePlayer().getPoints()+100);
											wPointsValue.setText((Integer.toString(g.getWhitePlayer().getPoints())));
											//1
											g.getBoard()[x][y].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);

											g.getBoard()[x-2][y+2].setSoldierColor(Soldier_COLOR_AtSquare.WHITE);
											//2
											g.getWhitePieces()[i].getLocation().setX(x-2);
											g.getWhitePieces()[i].getLocation().setY(y+2);
											//3
											this.soldier=newlayout(x-2,y+2,this.soldier);
										}
								
										}
									
									if(g.eatingMore(eatSoldier)==false) {
										eatSoldier=null;
										changeturntoBlack();

										return;
						
										}
									return;	
								}
								
							}
							if((x>1&& x<6) && (y>1&& y<6)) {
								//left up
								if(targetx==x-2 && targety==y-2 && ((g.getBoard()[x-1][y-1].getSoldierColor())==(Soldier_COLOR_AtSquare.BLACK) && g.getBoard()[x-2][y-2].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY)) {
									//remove the soldier
									g.getBoard()[x-1][y-1].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);
									for(int i=0;i<g.getBlackPieces().length;i++) {
										if(g.getBlackPieces()[i].getLocation().getX()==x-1 && g.getBlackPieces()[i].getLocation().getY()==y-1) {
											g.getBlackPieces()[i].setIsAlive(false);
											g.getBlackPieces()[i].getLocation().setX(-1);
											g.getBlackPieces()[i].getLocation().setY(-1);
											//3
											xcsene= (firstsourcex)-60;//nzed 3l func
											System.out.println(xcsene);
											ycsene=(firstsourcey)-60;//...
											System.out.println(ycsene);
											Circle c=getSoldierOnScene(xcsene,ycsene);
											c.setVisible(false);
										}
									}
									
										//move the soldier
									for(int i=0;i<g.getWhitePieces().length;i++) {
										if(g.getWhitePieces()[i].getLocation().getX()==x && g.getWhitePieces()[i].getLocation().getY()==y) {
											//setPoints
											g.getWhitePlayer().setPoints(g.getWhitePlayer().getPoints()+100);
											wPointsValue.setText((Integer.toString(g.getWhitePlayer().getPoints())));
											//1
											g.getBoard()[x][y].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);

											g.getBoard()[x-2][y-2].setSoldierColor(Soldier_COLOR_AtSquare.WHITE);
											//2
											g.getWhitePieces()[i].getLocation().setX(x-2);
											g.getWhitePieces()[i].getLocation().setY(y-2);
											//3
											this.soldier=newlayout(x-2,y-2,this.soldier);
										}
										
										}
									
									if(g.eatingMore(eatSoldier)==false) {
										eatSoldier=null;
										changeturntoBlack();

										return;
						
										}
									return;
								}
								//righ up
								if(targetx==x-2 && targety==y+2 && ((g.getBoard()[x-1][y+1].getSoldierColor())==(Soldier_COLOR_AtSquare.BLACK) && g.getBoard()[x-2][y+2].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY)) {
									//remove the soldier
									g.getBoard()[x-1][y+1].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);
									for(int i=0;i<g.getBlackPieces().length;i++) {
										if(g.getBlackPieces()[i].getLocation().getX()==x+1 && g.getBlackPieces()[i].getLocation().getY()==y+1) {
											g.getBlackPieces()[i].setIsAlive(false);
											g.getBlackPieces()[i].getLocation().setX(-1);
											g.getBlackPieces()[i].getLocation().setY(-1);
											//3
											xcsene= (firstsourcex)+60;//nzed 3l func
											System.out.println(xcsene);

											ycsene=(firstsourcey)-60;//...
											System.out.println(ycsene);
											Circle c=getSoldierOnScene(xcsene,ycsene);
											c.setVisible(false);
										}
									}
									
										//move the soldier
									for(int i=0;i<g.getWhitePieces().length;i++) {
										if(g.getWhitePieces()[i].getLocation().getX()==x && g.getWhitePieces()[i].getLocation().getY()==y) {
											//setPoints
											g.getWhitePlayer().setPoints(g.getWhitePlayer().getPoints()+100);
											wPointsValue.setText((Integer.toString(g.getWhitePlayer().getPoints())));
											//1
											g.getBoard()[x][y].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);

											g.getBoard()[x-2][y+2].setSoldierColor(Soldier_COLOR_AtSquare.WHITE);
											//2
											g.getWhitePieces()[i].getLocation().setX(x-2);
											g.getWhitePieces()[i].getLocation().setY(y+2);
											//3
											this.soldier=newlayout(x-2,y+2,this.soldier);
										}
										
										}
									
									if(g.eatingMore(eatSoldier)==false) {
										eatSoldier=null;
										changeturntoBlack();

										return;
						
										}
									return;	
								}
								//left down
								if(targetx==x+2 && targety==y-2 && ((g.getBoard()[x+1][y-1].getSoldierColor())==(Soldier_COLOR_AtSquare.BLACK) && g.getBoard()[x+2][y-2].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY)) {
									//remove the soldier
									g.getBoard()[x+1][y-1].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);
									for(int i=0;i<g.getBlackPieces().length;i++) {
										if(g.getBlackPieces()[i].getLocation().getX()==x+1 && g.getBlackPieces()[i].getLocation().getY()==y-1) {
											g.getBlackPieces()[i].setIsAlive(false);
											g.getBlackPieces()[i].getLocation().setX(-1);
											g.getBlackPieces()[i].getLocation().setY(-1);
											//3
											xcsene= (firstsourcex)-60;//nzed 3l func
											System.out.println(xcsene);

											ycsene=(firstsourcey)+60;//...
											System.out.println(ycsene);
											Circle c=getSoldierOnScene(xcsene,ycsene);
											c.setVisible(false);
										}
									}
									
										//move the soldier
									for(int i=0;i<g.getWhitePieces().length;i++) {
										if(g.getWhitePieces()[i].getLocation().getX()==x && g.getWhitePieces()[i].getLocation().getY()==y) {
											//setPoints
											g.getWhitePlayer().setPoints(g.getWhitePlayer().getPoints()+100);
											wPointsValue.setText((Integer.toString(g.getWhitePlayer().getPoints())));
											//1
											g.getBoard()[x][y].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);

											g.getBoard()[x+2][y-2].setSoldierColor(Soldier_COLOR_AtSquare.WHITE);
											//2
											g.getWhitePieces()[i].getLocation().setX(x+2);
											g.getWhitePieces()[i].getLocation().setY(y-2);
											//3
											this.soldier=newlayout(x+2,y-2,this.soldier);
										}
										
										}
									
									if(g.eatingMore(eatSoldier)==false) {
										eatSoldier=null;
										changeturntoBlack();

										return;
						
										}
									return;
								}
								// right down
								if(targetx==x+2 && targety==y+2 && ((g.getBoard()[x+1][y+1].getSoldierColor())==(Soldier_COLOR_AtSquare.BLACK) && g.getBoard()[x+2][y+2].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY)) {
									//remove the soldier
									g.getBoard()[x+1][y+1].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);
									for(int i=0;i<g.getBlackPieces().length;i++) {
										if(g.getBlackPieces()[i].getLocation().getX()==x+1 && g.getBlackPieces()[i].getLocation().getY()==y+1) {
											g.getBlackPieces()[i].setIsAlive(false);
											g.getBlackPieces()[i].getLocation().setX(-1);
											g.getBlackPieces()[i].getLocation().setY(-1);
											//3
											xcsene= (firstsourcex)+60;//nzed 3l func
											System.out.println(xcsene);

											ycsene=(firstsourcey)+60;//...
											System.out.println(ycsene);
											Circle c=getSoldierOnScene(xcsene,ycsene);
											c.setVisible(false);
										}
									}
									
										//move the soldier
									for(int i=0;i<g.getWhitePieces().length;i++) {
										if(g.getWhitePieces()[i].getLocation().getX()==x && g.getWhitePieces()[i].getLocation().getY()==y) {
											//setPoints
											g.getWhitePlayer().setPoints(g.getWhitePlayer().getPoints()+100);
											wPointsValue.setText((Integer.toString(g.getWhitePlayer().getPoints())));
											//1
											g.getBoard()[x][y].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);

											g.getBoard()[x+2][y+2].setSoldierColor(Soldier_COLOR_AtSquare.WHITE);
											//2
											g.getWhitePieces()[i].getLocation().setX(x+2);
											g.getWhitePieces()[i].getLocation().setY(y+2);
											//3
											this.soldier=newlayout(x+2,y+2,this.soldier);
										}
										
										}
									if(g.eatingMore(eatSoldier)==false) {
										eatSoldier=null;
										changeturntoBlack();

										return;
						
										}
									return;
									
								}
								
							}
				
				}
				//case the soldier is white Queen
				else if(s.isIsQueen()==true) {
					for(int i=0;i<g.getWhitePieces().length;i++) {
						if(g.getWhitePieces()[i].getLocation().getX()==x && g.getWhitePieces()[i].getLocation().getY()==y) {
								MoveWhiteQueen(sourcex,sourcey,targetx ,targety,i);
								//setPoints
								g.getWhitePlayer().setPoints(g.getWhitePlayer().getPoints()+100);
								wPointsValue.setText((Integer.toString(g.getWhitePlayer().getPoints())));
						}
					}
					
					/*
					//case the queen is moving up right
					   if(x>0) {
					while( Board[x-1][y+1].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY) {
						x--;
						y++;
						// case the queen arrived the edge of the board
						if(y==7 && x==0) {
							y=0;
							x=7;
						}
						else if(y==7 && x!=0) {
							y=0;
							x--;
						}
						else if(x==0) {
							x=7;
							y++;
						}
					}
					   }
					//check if the soldier near is a rival soldier and there is an empty square after him.
					if(Board[x][y].getSoldierColor()==Soldier_COLOR_AtSquare.BLACK && Board[x-1][y+1].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY)
						return true;
					//case the queen is moving up left
					if(x>0 & y>0) {
					while(Board[x-1][y-1].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY) {
						x--;
						y--;
						// case the queen arrived the edge of the board
						if(y==0) {
							y=7;
							x--;
						}else if(x==0) {
							y--;
							x=7;
						}
                  
					}
					}
					//check if the soldier near is a rival soldier and there is an empty square after him.
					if(Board[x][y].getSoldierColor()==Soldier_COLOR_AtSquare.BLACK && Board[x-1][y-1].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY)
						return true;
					//case the queen is moving right down
					if(x<7 && y<7) {
					while(Board[x+1][y+1].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY) {
						x++;
						y++;

						// case the queen arrived the edge of the board
						if(x==7) {
							y++;
							x=0;
						}else if(y==7) {
							y=0;
							x++;
						}
					}
				}
					//check if the soldier near is a rival soldier and there is an empty square after him.
					if(Board[x][y].getSoldierColor()==Soldier_COLOR_AtSquare.BLACK && Board[x+1][y+1].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY)
						return true;
					//case the queen is moving left down
					if(y>0) {
					while(Board[x+1][y-1].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY) {
						x++;
						y--;

						// case the queen arrived the edge of the board
						if(x==7 && y==0) {
							y=7;
							x=0;
						}else if(x==7 && y!=0) {
							y--;
							x=0;
						}else if(y==0) {
							y=7;
							x++;
						}
					}
					}
					//check if the soldier near is a rival soldier and there is an empty square after him.
					if(Board[x][y].getSoldierColor()==Soldier_COLOR_AtSquare.BLACK && Board[x+1][y-1].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY)
						return true;
				*/
				}
				
		}
		//case player is Black
		else if(s.getColor()==Soldier_COLOR_AtSquare.BLACK) {
			

			//get the location of the player
			int x=s.getLocation().getX();
			int y=s.getLocation().getY();
			
			//Choosing to eat at yellow square
			if(board[targetx][targety].getSquareColor()==SQUARE_COLOR.YELLOW) {
				SoldierChooseYellow(sourcex,sourcey,targetx,targety,firstsourcex,firstsourcey);
				
			}
			
			if(s.isIsQueen()==false)
			{
				if((y==0 && x==1) || (y==1 && x==0)) {
					if(targetx==x+2 && targety==y+2 && ((g.getBoard()[x+1][y+1].getSoldierColor())==(Soldier_COLOR_AtSquare.WHITE) && g.getBoard()[x+2][y+2].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY)) {
						//remove the soldier
						g.getBoard()[x+1][y+1].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);
						for(int i=0;i<g.getWhitePieces().length;i++) {
							if(g.getWhitePieces()[i].getLocation().getX()==x+1 && g.getWhitePieces()[i].getLocation().getY()==y+1) {
								g.getWhitePieces()[i].setIsAlive(false);
								g.getWhitePieces()[i].getLocation().setX(-1);
								g.getWhitePieces()[i].getLocation().setY(-1);
								//3
								xcsene= (firstsourcex)+60;//nzed 3l func
								System.out.println(xcsene);

								ycsene=(firstsourcey)+60;//...
								System.out.println(ycsene);
								Circle c=getSoldierOnScene(xcsene,ycsene);
								c.setVisible(false);
							}
						}
						
							//move the soldier
						for(int i=0;i<g.getBlackPieces().length;i++) {
							if(g.getBlackPieces()[i].getLocation().getX()==x && g.getBlackPieces()[i].getLocation().getY()==y) {
								//setPoints
								g.getBlackPlayer().setPoints(g.getBlackPlayer().getPoints()+100);
								bPointsValue.setText((Integer.toString(g.getBlackPlayer().getPoints())));
								//1
								g.getBoard()[x][y].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);

								g.getBoard()[x+2][y+2].setSoldierColor(Soldier_COLOR_AtSquare.BLACK);
								//2
								g.getBlackPieces()[i].getLocation().setX(x+2);
								g.getBlackPieces()[i].getLocation().setY(y+2);
								//3
								this.soldier=newlayout(x+2,y+2,this.soldier);
							}
							
							}
						
						if(g.eatingMore(eatSoldier)==false) {
							eatSoldier=null;
							changeturntowhite();

							return;
			
							}
						return;
					}
					
				}
				if((y==0 && x==7) || (y==1&& x==6)) {
					if(targetx==x-2 && targety==y+2 && ((g.getBoard()[x-1][y+1].getSoldierColor())==(Soldier_COLOR_AtSquare.WHITE) && g.getBoard()[x-2][y+2].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY)) {
						//remove the soldier
						g.getBoard()[x-1][y+1].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);
						for(int i=0;i<g.getWhitePieces().length;i++) {
							if(g.getWhitePieces()[i].getLocation().getX()==x-1 && g.getWhitePieces()[i].getLocation().getY()==y+1) {
								g.getWhitePieces()[i].setIsAlive(false);
								g.getWhitePieces()[i].getLocation().setX(-1);
								g.getWhitePieces()[i].getLocation().setY(-1);
								//3
								
								xcsene= (firstsourcex)+60;//nzed 3l func
								System.out.println(xcsene);

								ycsene=(firstsourcey)-60;//...
								System.out.println(ycsene);
								Circle c=getSoldierOnScene(xcsene,ycsene);
								c.setVisible(false);
							}
						}
						
							//move the soldier
						for(int i=0;i<g.getBlackPieces().length;i++) {
							if(g.getBlackPieces()[i].getLocation().getX()==x && g.getBlackPieces()[i].getLocation().getY()==y) {
								//setPoints
								g.getBlackPlayer().setPoints(g.getBlackPlayer().getPoints()+100);
								bPointsValue.setText((Integer.toString(g.getBlackPlayer().getPoints())));
								//1
								g.getBoard()[x][y].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);

								g.getBoard()[x-2][y+2].setSoldierColor(Soldier_COLOR_AtSquare.BLACK);
								//2
								g.getBlackPieces()[i].getLocation().setX(x-2);
								g.getBlackPieces()[i].getLocation().setY(y+2);
								//3
								this.soldier=newlayout(x-2,y+2,this.soldier);
							}
							
							}
						
						if(g.eatingMore(eatSoldier)==false) {
							eatSoldier=null;
							changeturntowhite();
							return;
			
							}
						return;
					}
					
				}
				if((y==0 && (x==3|| x==5)) || (y==1 && (x==2 ||x==4))) {
					if(targetx==x-2 && targety==y+2 && ((g.getBoard()[x-1][y+1].getSoldierColor())==(Soldier_COLOR_AtSquare.WHITE) && g.getBoard()[x-2][y+2].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY)) {
						//remove the soldier
						g.getBoard()[x-1][y+1].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);
						for(int i=0;i<g.getWhitePieces().length;i++) {
							if(g.getWhitePieces()[i].getLocation().getX()==x-1 && g.getBlackPieces()[i].getLocation().getY()==y+1) {
								g.getWhitePieces()[i].setIsAlive(false);
								g.getWhitePieces()[i].getLocation().setX(-1);
								g.getWhitePieces()[i].getLocation().setY(-1);
								//3
								
								xcsene= (firstsourcex)+60;//nzed 3l func
								System.out.println(xcsene);

								ycsene=(firstsourcey)-60;//...
								System.out.println(ycsene);
								Circle c=getSoldierOnScene(xcsene,ycsene);
								c.setVisible(false);
							}
						}
						
							//move the soldier
						for(int i=0;i<g.getBlackPieces().length;i++) {
							if(g.getBlackPieces()[i].getLocation().getX()==x && g.getBlackPieces()[i].getLocation().getY()==y) {
								//setPoints
								g.getBlackPlayer().setPoints(g.getBlackPlayer().getPoints()+100);
								bPointsValue.setText((Integer.toString(g.getBlackPlayer().getPoints())));
								//1
								g.getBoard()[x][y].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);

								g.getBoard()[x-2][y+2].setSoldierColor(Soldier_COLOR_AtSquare.BLACK);
								//2
								g.getBlackPieces()[i].getLocation().setX(x-2);
								g.getBlackPieces()[i].getLocation().setY(y+2);
								//3
								this.soldier=newlayout(x-2,y+2,this.soldier);
							}
							
							}
						if(g.eatingMore(eatSoldier)==false) {
							eatSoldier=null;
							changeturntowhite();
							return;
			
							}
						return;	
						
					}
					
					
					if(targetx==x+2 && targety==y+2 && ((g.getBoard()[x+1][y+1].getSoldierColor())==(Soldier_COLOR_AtSquare.WHITE) && g.getBoard()[x+2][y+2].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY)) {
						//remove the soldier
					
						g.getBoard()[x+1][y+1].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);
						for(int i=0;i<g.getWhitePieces().length;i++) {
							if(g.getWhitePieces()[i].getLocation().getX()==x+1 && g.getWhitePieces()[i].getLocation().getY()==y+1) {
								g.getWhitePieces()[i].setIsAlive(false);
								g.getWhitePieces()[i].getLocation().setX(-1);
								g.getWhitePieces()[i].getLocation().setY(-1);
								//3
								xcsene= (firstsourcex)+60;//nzed 3l func
								System.out.println(xcsene);

								ycsene=(firstsourcey)+60;//...
								System.out.println(ycsene);
								Circle c=getSoldierOnScene(xcsene,ycsene);
								c.setVisible(false);
							}
						}
						
							//move the soldier
						for(int i=0;i<g.getBlackPieces().length;i++) {
							if(g.getBlackPieces()[i].getLocation().getX()==x && g.getBlackPieces()[i].getLocation().getY()==y) {
								//setPoints
								g.getBlackPlayer().setPoints(g.getBlackPlayer().getPoints()+100);
								bPointsValue.setText((Integer.toString(g.getBlackPlayer().getPoints())));
								//1
								g.getBoard()[x][y].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);

								g.getBoard()[x+2][y+2].setSoldierColor(Soldier_COLOR_AtSquare.BLACK);
								//2
								g.getBlackPieces()[i].getLocation().setX(x+2);
								g.getBlackPieces()[i].getLocation().setY(y+2);
								//3
								this.soldier=newlayout(x+2,y+2,this.soldier);
							}
							
							}
						
						if(g.eatingMore(eatSoldier)==false) {
							eatSoldier=null;
							changeturntowhite();
							return;
			
							}
						return;	
					}
					
				}
				
				
				if(y==0 && x==1) {
					if(targetx==x+2 && targety==y+2 && ((g.getBoard()[x+1][y+1].getSoldierColor())==(Soldier_COLOR_AtSquare.WHITE) && g.getBoard()[x+2][y+2].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY)) {
						//remove the soldier
						g.getBoard()[x+1][y+1].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);
						for(int i=0;i<g.getWhitePieces().length;i++) {
							if(g.getWhitePieces()[i].getLocation().getX()==x+1 && g.getWhitePieces()[i].getLocation().getY()==y+1) {
								g.getWhitePieces()[i].setIsAlive(false);
								g.getWhitePieces()[i].getLocation().setX(-1);
								g.getWhitePieces()[i].getLocation().setY(-1);
								//3
								xcsene= (firstsourcex)+60;//nzed 3l func
								System.out.println(xcsene);

								ycsene=(firstsourcey)+60;//...
								System.out.println(ycsene);
								Circle c=getSoldierOnScene(xcsene,ycsene);
								c.setVisible(false);
							}
						}
						
							//move the soldier
						for(int i=0;i<g.getBlackPieces().length;i++) {
							if(g.getBlackPieces()[i].getLocation().getX()==x && g.getBlackPieces()[i].getLocation().getY()==y) {
								//setPoints
								g.getBlackPlayer().setPoints(g.getBlackPlayer().getPoints()+100);
								bPointsValue.setText((Integer.toString(g.getBlackPlayer().getPoints())));
								//1
								g.getBoard()[x][y].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);

								g.getBoard()[x+2][y+2].setSoldierColor(Soldier_COLOR_AtSquare.BLACK);
								//2
								g.getBlackPieces()[i].getLocation().setX(x+2);
								g.getBlackPieces()[i].getLocation().setY(y+2);
								//3
								this.soldier=newlayout(x+2,y+2,this.soldier);
							}
							
							}
						if(g.eatingMore(eatSoldier)==false) {
							eatSoldier=null;
							changeturntowhite();
							return;
			
							}
						return;
						
					}
				
				}
				if((y==7 && x==0) || (y==6 && x==1)){
					if(targetx==x+2 && targety==y-2 && ((g.getBoard()[x+1][y-1].getSoldierColor())==(Soldier_COLOR_AtSquare.WHITE) && g.getBoard()[x+2][y-2].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY)) {
						//remove the soldier
						g.getBoard()[x+1][y-1].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);
						for(int i=0;i<g.getWhitePieces().length;i++) {
							if(g.getWhitePieces()[i].getLocation().getX()==x+1 && g.getWhitePieces()[i].getLocation().getY()==y-1) {
								g.getWhitePieces()[i].setIsAlive(false);
								g.getWhitePieces()[i].getLocation().setX(-1);
								g.getWhitePieces()[i].getLocation().setY(-1);
								//3
								xcsene= (firstsourcex)-60;//nzed 3l func
								System.out.println(xcsene);

								ycsene=(firstsourcey)+60;//...
								System.out.println(ycsene);
								Circle c=getSoldierOnScene(xcsene,ycsene);
								c.setVisible(false);
							}
						}
						
							//move the soldier
						for(int i=0;i<g.getBlackPieces().length;i++) {
							if(g.getBlackPieces()[i].getLocation().getX()==x && g.getBlackPieces()[i].getLocation().getY()==y) {
								//setPoints
								g.getBlackPlayer().setPoints(g.getBlackPlayer().getPoints()+100);
								bPointsValue.setText((Integer.toString(g.getBlackPlayer().getPoints())));
								//1
								g.getBoard()[x][y].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);

								g.getBoard()[x+2][y-2].setSoldierColor(Soldier_COLOR_AtSquare.BLACK);
								//2
								g.getBlackPieces()[i].getLocation().setX(x+2);
								g.getBlackPieces()[i].getLocation().setY(y-2);
								//3
								this.soldier=newlayout(x+2,y-2,this.soldier);
							}
							
							}
						if(g.eatingMore(eatSoldier)==false) {
							eatSoldier=null;
							changeturntowhite();
							return;
			
							}
						return;
						
					}
				
				}
				if((y==7 && (x==2|| x==4)) || (y==6&& (x==3||x==5))) {
					if(targetx==x-2 && targety==y-2 && ((g.getBoard()[x-1][y-1].getSoldierColor())==(Soldier_COLOR_AtSquare.WHITE) && g.getBoard()[x-2][y-2].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY)) {
						//remove the soldier
						g.getBoard()[x-1][y-1].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);
						for(int i=0;i<g.getWhitePieces().length;i++) {
							if(g.getWhitePieces()[i].getLocation().getX()==x-1 && g.getWhitePieces()[i].getLocation().getY()==y-1) {
								g.getWhitePieces()[i].setIsAlive(false);
								g.getWhitePieces()[i].getLocation().setX(-1);
								g.getWhitePieces()[i].getLocation().setY(-1);
								//3
								
								xcsene= (firstsourcex)-60;//nzed 3l func
								System.out.println(xcsene);

								ycsene=(firstsourcey)-60;//...
								System.out.println(ycsene);
								Circle c=getSoldierOnScene(xcsene,ycsene);
								c.setVisible(false);
							}
						}
						
							//move the soldier
						for(int i=0;i<g.getBlackPieces().length;i++) {
							if(g.getBlackPieces()[i].getLocation().getX()==x && g.getBlackPieces()[i].getLocation().getY()==y) {
								//setPoints
								g.getBlackPlayer().setPoints(g.getBlackPlayer().getPoints()+100);
								bPointsValue.setText((Integer.toString(g.getBlackPlayer().getPoints())));
								//1
								g.getBoard()[x][y].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);

								g.getBoard()[x-2][y-2].setSoldierColor(Soldier_COLOR_AtSquare.BLACK);
								//2
								g.getBlackPieces()[i].getLocation().setX(x-2);
								g.getBlackPieces()[i].getLocation().setY(y-2);
								//3
								this.soldier=newlayout(x-2,y-2,this.soldier);
							}
							
							}
						
						if(g.eatingMore(eatSoldier)==false) {
							eatSoldier=null;
							changeturntowhite();
							return;
			
							}
						return;
					}
					
					
					if(targetx==x+2 && targety==y-2 && ((g.getBoard()[x+1][y-1].getSoldierColor())==(Soldier_COLOR_AtSquare.WHITE) && g.getBoard()[x+2][y-2].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY)) {
						//remove the soldier
						g.getBoard()[x+1][y-1].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);
						for(int i=0;i<g.getWhitePieces().length;i++) {
							if(g.getWhitePieces()[i].getLocation().getX()==x+1 && g.getWhitePieces()[i].getLocation().getY()==y-1) {
								g.getWhitePieces()[i].setIsAlive(false);
								g.getWhitePieces()[i].getLocation().setX(-1);
								g.getWhitePieces()[i].getLocation().setY(-1);
								//3
								xcsene= (firstsourcex)-60;//nzed 3l func
								System.out.println(xcsene);

								ycsene=(firstsourcey)+60;//...
								System.out.println(ycsene);
								Circle c=getSoldierOnScene(xcsene,ycsene);
								c.setVisible(false);
							}
						}
						
							//move the soldier
						for(int i=0;i<g.getBlackPieces().length;i++) {
							if(g.getBlackPieces()[i].getLocation().getX()==x && g.getBlackPieces()[i].getLocation().getY()==y) {
								//setPoints
								g.getBlackPlayer().setPoints(g.getBlackPlayer().getPoints()+100);
								bPointsValue.setText((Integer.toString(g.getBlackPlayer().getPoints())));
								//1
								g.getBoard()[x][y].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);

								g.getBoard()[x+2][y-2].setSoldierColor(Soldier_COLOR_AtSquare.BLACK);
								//2
								g.getBlackPieces()[i].getLocation().setX(x+2);
								g.getBlackPieces()[i].getLocation().setY(y-2);
								//3
								this.soldier=newlayout(x+2,y-2,this.soldier);
							}
							
							}
						
						if(g.eatingMore(eatSoldier)==false) {
							eatSoldier=null;
							changeturntowhite();
							return;
			
							}
						return;	
					}
					
				}
				if((y==7 && x==6) || (y==6 && x==7)) {
					if(targetx==x-2 && targety==y-2 && ((g.getBoard()[x-1][y-1].getSoldierColor())==(Soldier_COLOR_AtSquare.WHITE) && g.getBoard()[x-2][y-2].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY)) {
						//remove the soldier
						g.getBoard()[x-1][y-1].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);
						for(int i=0;i<g.getWhitePieces().length;i++) {
							if(g.getWhitePieces()[i].getLocation().getX()==x-1 && g.getWhitePieces()[i].getLocation().getY()==y-1) {
								g.getWhitePieces()[i].setIsAlive(false);
								g.getWhitePieces()[i].getLocation().setX(-1);
								g.getWhitePieces()[i].getLocation().setY(-1);
								//3
								
								xcsene= (firstsourcex)-60;//nzed 3l func
								System.out.println(xcsene);

								ycsene=(firstsourcey)-60;//...
								System.out.println(ycsene);
								Circle c=getSoldierOnScene(xcsene,ycsene);
								c.setVisible(false);
							}
						}
						
							//move the soldier
						for(int i=0;i<g.getBlackPieces().length;i++) {
							if(g.getBlackPieces()[i].getLocation().getX()==x&& g.getBlackPieces()[i].getLocation().getY()==y) {
								//setPoints
								g.getBlackPlayer().setPoints(g.getBlackPlayer().getPoints()+100);
								bPointsValue.setText((Integer.toString(g.getBlackPlayer().getPoints())));
								//1
								g.getBoard()[x][y].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);

								g.getBoard()[x-2][y-2].setSoldierColor(Soldier_COLOR_AtSquare.BLACK);
								//2
								g.getBlackPieces()[i].getLocation().setX(x-2);
								g.getBlackPieces()[i].getLocation().setY(y-2);
								//3
								this.soldier=newlayout(x-2,y-2,this.soldier);
							}
							
							}
						
						if(g.eatingMore(eatSoldier)==false) {
							eatSoldier=null;
							changeturntowhite();
							return;
			
							}
						return;
					}
					
				}
			
						if(x==0 || x==1)  {
							if(targetx==x+2 && targety==y-2 && ((g.getBoard()[x+1][y-1].getSoldierColor())==(Soldier_COLOR_AtSquare.WHITE) && g.getBoard()[x+2][y-2].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY)) {
								//remove the soldier
								g.getBoard()[x+1][y-1].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);
								for(int i=0;i<g.getWhitePieces().length;i++) {
									if(g.getWhitePieces()[i].getLocation().getX()==x+1 && g.getWhitePieces()[i].getLocation().getY()==y-1) {
										g.getWhitePieces()[i].setIsAlive(false);
										g.getWhitePieces()[i].getLocation().setX(-1);
										g.getWhitePieces()[i].getLocation().setY(-1);
										//3
										xcsene= (firstsourcex)-60;//nzed 3l func
										System.out.println(xcsene);

										ycsene=(firstsourcey)+60;//...
										System.out.println(ycsene);
										Circle c=getSoldierOnScene(xcsene,ycsene);
										c.setVisible(false);
									}
								}
								
									//move the soldier
								for(int i=0;i<g.getBlackPieces().length;i++) {
									if(g.getBlackPieces()[i].getLocation().getX()==x && g.getBlackPieces()[i].getLocation().getY()==y) {
										//setPoints
										g.getBlackPlayer().setPoints(g.getBlackPlayer().getPoints()+100);
										bPointsValue.setText((Integer.toString(g.getBlackPlayer().getPoints())));
										//1
										g.getBoard()[x][y].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);

										g.getBoard()[x+2][y-2].setSoldierColor(Soldier_COLOR_AtSquare.BLACK);
										//2
										g.getBlackPieces()[i].getLocation().setX(x+2);
										g.getBlackPieces()[i].getLocation().setY(y-2);
										//3
										this.soldier=newlayout(x+2,y-2,this.soldier);
									}
									
									}
								
								if(g.eatingMore(eatSoldier)==false) {
									eatSoldier=null;
									changeturntowhite();
									return;
					
									}
								return;
							}
							if(targetx==x+2 && targety==y+2 && ((g.getBoard()[x+1][y+1].getSoldierColor())==(Soldier_COLOR_AtSquare.WHITE) && g.getBoard()[x+2][y+2].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY)) {
								//remove the soldier
								g.getBoard()[x+1][y+1].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);
								for(int i=0;i<g.getWhitePieces().length;i++) {
									if(g.getWhitePieces()[i].getLocation().getX()==x+1 && g.getWhitePieces()[i].getLocation().getY()==y+1) {
										g.getWhitePieces()[i].setIsAlive(false);
										g.getWhitePieces()[i].getLocation().setX(-1);
										g.getWhitePieces()[i].getLocation().setY(-1);
										//3
										xcsene= (firstsourcex)+60;//nzed 3l func
										System.out.println(xcsene);

										ycsene=(firstsourcey)+60;//...
										System.out.println(ycsene);
										Circle c=getSoldierOnScene(xcsene,ycsene);
										c.setVisible(false);
									}
								}
								
									//move the soldier
								for(int i=0;i<g.getBlackPieces().length;i++) {
									if(g.getBlackPieces()[i].getLocation().getX()==x && g.getBlackPieces()[i].getLocation().getY()==y) {
										//setPoints
										g.getBlackPlayer().setPoints(g.getBlackPlayer().getPoints()+100);
										bPointsValue.setText((Integer.toString(g.getBlackPlayer().getPoints())));
										//1
										g.getBoard()[x][y].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);

										g.getBoard()[x+2][y+2].setSoldierColor(Soldier_COLOR_AtSquare.BLACK);
										//2
										g.getBlackPieces()[i].getLocation().setX(x+2);
										g.getBlackPieces()[i].getLocation().setY(y+2);
										//3
										this.soldier=newlayout(x+2,y+2,this.soldier);
									}
									
									}
								
								if(g.eatingMore(eatSoldier)==false) {
									eatSoldier=null;
									changeturntowhite();
									return;
					
									}
								return;
							}
							
						}
						
						if(x==6 || x==7)  {
							if(targetx==x-2 && targety==y-2 && ((g.getBoard()[x-1][y-1].getSoldierColor())==(Soldier_COLOR_AtSquare.WHITE) && g.getBoard()[x-2][y-2].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY)) {
								//remove the soldier
								g.getBoard()[x-1][y-1].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);
								for(int i=0;i<g.getWhitePieces().length;i++) {
									if(g.getWhitePieces()[i].getLocation().getX()==x-1 && g.getWhitePieces()[i].getLocation().getY()==y-1) {
										g.getWhitePieces()[i].setIsAlive(false);
										g.getWhitePieces()[i].getLocation().setX(-1);
										g.getWhitePieces()[i].getLocation().setY(-1);
										//3
										xcsene= (firstsourcex)-60;//nzed 3l func
										System.out.println(xcsene);
										ycsene=(firstsourcey)-60;//...
										System.out.println(ycsene);
										Circle c=getSoldierOnScene(xcsene,ycsene);
										c.setVisible(false);
									}
								}
								
									//move the soldier
								for(int i=0;i<g.getBlackPieces().length;i++) {
									if(g.getBlackPieces()[i].getLocation().getX()==x && g.getBlackPieces()[i].getLocation().getY()==y) {
										//setPoints
										g.getBlackPlayer().setPoints(g.getBlackPlayer().getPoints()+100);
										bPointsValue.setText((Integer.toString(g.getBlackPlayer().getPoints())));
										//1
										g.getBoard()[x][y].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);

										g.getBoard()[x-2][y-2].setSoldierColor(Soldier_COLOR_AtSquare.BLACK);
										//2
										g.getBlackPieces()[i].getLocation().setX(x-2);
										g.getBlackPieces()[i].getLocation().setY(y-2);
										//3
										this.soldier=newlayout(x-2,y-2,this.soldier);
									}
									
									}
								
								if(g.eatingMore(eatSoldier)==false) {
									eatSoldier=null;
									changeturntowhite();
									return;
					
									}
								return;
							}
							if(targetx==x-2 && targety==y+2 && ((g.getBoard()[x-1][y+1].getSoldierColor())==(Soldier_COLOR_AtSquare.WHITE) && g.getBoard()[x-2][y+2].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY)) {
								//remove the soldier
								
								
								g.getBoard()[x-1][y+1].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);
								for(int i=0;i<g.getWhitePieces().length;i++) {
									if(g.getWhitePieces()[i].getLocation().getX()==x+1 && g.getWhitePieces()[i].getLocation().getY()==y+1) {
										g.getWhitePieces()[i].setIsAlive(false);
										g.getWhitePieces()[i].getLocation().setX(-1);
										g.getWhitePieces()[i].getLocation().setY(-1);
										//3
										xcsene= (firstsourcex)+60;//nzed 3l func
										System.out.println(xcsene);

										ycsene=(firstsourcey)-60;//...
										System.out.println(ycsene);
										Circle c=getSoldierOnScene(xcsene,ycsene);
										c.setVisible(false);
									}
								}
								
									//move the soldier
								for(int i=0;i<g.getBlackPieces().length;i++) {
									if(g.getBlackPieces()[i].getLocation().getX()==x && g.getBlackPieces()[i].getLocation().getY()==y) {
										//setPoints
										g.getBlackPlayer().setPoints(g.getBlackPlayer().getPoints()+100);
										bPointsValue.setText((Integer.toString(g.getBlackPlayer().getPoints())));
										//1
										g.getBoard()[x][y].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);

										g.getBoard()[x-2][y+2].setSoldierColor(Soldier_COLOR_AtSquare.BLACK);
										//2
										g.getBlackPieces()[i].getLocation().setX(x-2);
										g.getBlackPieces()[i].getLocation().setY(y+2);
										//3
										this.soldier=newlayout(x-2,y+2,this.soldier);
									}
									
									}
								
								if(g.eatingMore(eatSoldier)==false) {
									eatSoldier=null;
									changeturntowhite();
									return;
					
									}
								return;	
							}
							
						}
						if((x>1&& x<6) && (y>1&& y<6)) {
							//left up
							if(targetx==x-2 && targety==y-2 && ((g.getBoard()[x-1][y-1].getSoldierColor())==(Soldier_COLOR_AtSquare.WHITE) && g.getBoard()[x-2][y-2].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY)) {
								//remove the soldier
								g.getBoard()[x-1][y-1].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);
								for(int i=0;i<g.getWhitePieces().length;i++) {
									if(g.getWhitePieces()[i].getLocation().getX()==x-1 && g.getWhitePieces()[i].getLocation().getY()==y-1) {
										g.getWhitePieces()[i].setIsAlive(false);
										g.getWhitePieces()[i].getLocation().setX(-1);
										g.getWhitePieces()[i].getLocation().setY(-1);
										//3
										xcsene= (firstsourcex)-60;//nzed 3l func
										System.out.println(xcsene);
										ycsene=(firstsourcey)-60;//...
										System.out.println(ycsene);
										Circle c=getSoldierOnScene(xcsene,ycsene);
										c.setVisible(false);
									}
								}
								
									//move the soldier
								for(int i=0;i<g.getBlackPieces().length;i++) {
									if(g.getBlackPieces()[i].getLocation().getX()==x && g.getBlackPieces()[i].getLocation().getY()==y) {
										//setPoints
										g.getBlackPlayer().setPoints(g.getBlackPlayer().getPoints()+100);
										bPointsValue.setText((Integer.toString(g.getBlackPlayer().getPoints())));
										//1
										g.getBoard()[x][y].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);

										g.getBoard()[x-2][y-2].setSoldierColor(Soldier_COLOR_AtSquare.BLACK);
										//2
										g.getBlackPieces()[i].getLocation().setX(x-2);
										g.getBlackPieces()[i].getLocation().setY(y-2);
										//3
										this.soldier=newlayout(x-2,y-2,this.soldier);
									}
									
									}
								
								if(g.eatingMore(eatSoldier)==false) {
									eatSoldier=null;
									changeturntowhite();
									return;
					
									}
								return;
							}
							//righ up
							if(targetx==x-2 && targety==y+2 && ((g.getBoard()[x-1][y+1].getSoldierColor())==(Soldier_COLOR_AtSquare.WHITE) && g.getBoard()[x-2][y+2].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY)) {
								//remove the soldier
								g.getBoard()[x-1][y+1].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);
								for(int i=0;i<g.getWhitePieces().length;i++) {
									if(g.getWhitePieces()[i].getLocation().getX()==x+1 && g.getWhitePieces()[i].getLocation().getY()==y+1) {
										g.getWhitePieces()[i].setIsAlive(false);
										g.getWhitePieces()[i].getLocation().setX(-1);
										g.getWhitePieces()[i].getLocation().setY(-1);
										//3
										xcsene= (firstsourcex)+60;//nzed 3l func
										System.out.println(xcsene);

										ycsene=(firstsourcey)-60;//...
										System.out.println(ycsene);
										Circle c=getSoldierOnScene(xcsene,ycsene);
										c.setVisible(false);
									}
								}
								
									//move the soldier
								for(int i=0;i<g.getBlackPieces().length;i++) {
									if(g.getBlackPieces()[i].getLocation().getX()==x && g.getBlackPieces()[i].getLocation().getY()==y) {
										//setPoints
										g.getBlackPlayer().setPoints(g.getBlackPlayer().getPoints()+100);
										bPointsValue.setText((Integer.toString(g.getBlackPlayer().getPoints())));
										//1
										g.getBoard()[x][y].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);

										g.getBoard()[x-2][y+2].setSoldierColor(Soldier_COLOR_AtSquare.BLACK);
										//2
										g.getBlackPieces()[i].getLocation().setX(x-2);
										g.getBlackPieces()[i].getLocation().setY(y+2);
										//3
										this.soldier=newlayout(x-2,y+2,this.soldier);
									}
									
									}
								
								if(g.eatingMore(eatSoldier)==false) {
									eatSoldier=null;
									changeturntowhite();
									return;
					
									}
								return;	
							}
							//left down
							if(targetx==x+2 && targety==y-2 && ((g.getBoard()[x+1][y-1].getSoldierColor())==(Soldier_COLOR_AtSquare.WHITE) && g.getBoard()[x+2][y-2].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY)) {
								//remove the soldier
								g.getBoard()[x+1][y-1].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);
								for(int i=0;i<g.getWhitePieces().length;i++) {
									if(g.getWhitePieces()[i].getLocation().getX()==x+1 && g.getWhitePieces()[i].getLocation().getY()==y-1) {
										g.getWhitePieces()[i].setIsAlive(false);
										g.getWhitePieces()[i].getLocation().setX(-1);
										g.getWhitePieces()[i].getLocation().setY(-1);
										//3
										xcsene= (firstsourcex)-60;//nzed 3l func
										System.out.println(xcsene);

										ycsene=(firstsourcey)+60;//...
										System.out.println(ycsene);
										Circle c=getSoldierOnScene(xcsene,ycsene);
										c.setVisible(false);
									}
								}
								
									//move the soldier
								for(int i=0;i<g.getBlackPieces().length;i++) {
									if(g.getBlackPieces()[i].getLocation().getX()==x && g.getBlackPieces()[i].getLocation().getY()==y) {
										//setPoints
										g.getBlackPlayer().setPoints(g.getBlackPlayer().getPoints()+100);
										bPointsValue.setText((Integer.toString(g.getBlackPlayer().getPoints())));
										//1
										g.getBoard()[x][y].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);

										g.getBoard()[x+2][y-2].setSoldierColor(Soldier_COLOR_AtSquare.BLACK);
										//2
										g.getBlackPieces()[i].getLocation().setX(x+2);
										g.getBlackPieces()[i].getLocation().setY(y-2);
										//3
										this.soldier=newlayout(x+2,y-2,this.soldier);
									}
									
									}
								
								if(g.eatingMore(eatSoldier)==false) {
									eatSoldier=null;
									changeturntowhite();
									return;
					
									}
								return;
							}
							// right down
							if(targetx==x+2 && targety==y+2 && ((g.getBoard()[x+1][y+1].getSoldierColor())==(Soldier_COLOR_AtSquare.WHITE) && g.getBoard()[x+2][y+2].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY)) {
								//remove the soldier
								g.getBoard()[x+1][y+1].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);
								for(int i=0;i<g.getWhitePieces().length;i++) {
									if(g.getWhitePieces()[i].getLocation().getX()==x+1 && g.getWhitePieces()[i].getLocation().getY()==y+1) {
										g.getWhitePieces()[i].setIsAlive(false);
										g.getWhitePieces()[i].getLocation().setX(-1);
										g.getWhitePieces()[i].getLocation().setY(-1);
										//3
										xcsene= (firstsourcex)+60;//nzed 3l func
										System.out.println(xcsene);
										ycsene=(firstsourcey)+60;//...
									
										System.out.println(ycsene);
										Circle c=getSoldierOnScene(xcsene,ycsene);
										c.setVisible(false);
										break;
										
									}
								}
								
									//move the soldier
								for(int i=0;i<g.getBlackPieces().length;i++) {
									if(g.getBlackPieces()[i].getLocation().getX()==x && g.getBlackPieces()[i].getLocation().getY()==y) {
										//setPoints
										g.getBlackPlayer().setPoints(g.getBlackPlayer().getPoints()+100);
										bPointsValue.setText((Integer.toString(g.getBlackPlayer().getPoints())));
										//1
										g.getBoard()[x][y].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);

										g.getBoard()[x+2][y+2].setSoldierColor(Soldier_COLOR_AtSquare.BLACK);
										//2
										g.getBlackPieces()[i].getLocation().setX(x+2);
										g.getBlackPieces()[i].getLocation().setY(y+2);
										//3
										this.soldier=newlayout(x+2,y+2,this.soldier);
									}
									
									}
								if(g.eatingMore(eatSoldier)==false) {
									eatSoldier=null;
									changeturntowhite();
									return;
					
									}
								return;
								
							}
							
						}
			
			}
			//case the soldier is white Queen
			else if(s.isIsQueen()==true) {
				for(int i=0;i<g.getWhitePieces().length;i++) {
					if(g.getWhitePieces()[i].getLocation().getX()==x && g.getWhitePieces()[i].getLocation().getY()==y) {
							MoveBlackQueen(sourcex,sourcey,targetx ,targety,i);
							//setPoints
							g.getBlackPlayer().setPoints(g.getBlackPlayer().getPoints()+100);
							bPointsValue.setText((Integer.toString(g.getBlackPlayer().getPoints())));
					}
				}
				
				/*
				//case the queen is moving up right
				   if(x>0) {
				while( Board[x-1][y+1].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY) {
					x--;
					y++;
					// case the queen arrived the edge of the board
					if(y==7 && x==0) {
						y=0;
						x=7;
					}
					else if(y==7 && x!=0) {
						y=0;
						x--;
					}
					else if(x==0) {
						x=7;
						y++;
					}
				}
				   }
				//check if the soldier near is a rival soldier and there is an empty square after him.
				if(Board[x][y].getSoldierColor()==Soldier_COLOR_AtSquare.BLACK && Board[x-1][y+1].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY)
					return true;
				//case the queen is moving up left
				if(x>0 & y>0) {
				while(Board[x-1][y-1].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY) {
					x--;
					y--;
					// case the queen arrived the edge of the board
					if(y==0) {
						y=7;
						x--;
					}else if(x==0) {
						y--;
						x=7;
					}
              
				}
				}
				//check if the soldier near is a rival soldier and there is an empty square after him.
				if(Board[x][y].getSoldierColor()==Soldier_COLOR_AtSquare.BLACK && Board[x-1][y-1].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY)
					return true;
				//case the queen is moving right down
				if(x<7 && y<7) {
				while(Board[x+1][y+1].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY) {
					x++;
					y++;

					// case the queen arrived the edge of the board
					if(x==7) {
						y++;
						x=0;
					}else if(y==7) {
						y=0;
						x++;
					}
				}
			}
				//check if the soldier near is a rival soldier and there is an empty square after him.
				if(Board[x][y].getSoldierColor()==Soldier_COLOR_AtSquare.BLACK && Board[x+1][y+1].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY)
					return true;
				//case the queen is moving left down
				if(y>0) {
				while(Board[x+1][y-1].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY) {
					x++;
					y--;

					// case the queen arrived the edge of the board
					if(x==7 && y==0) {
						y=7;
						x=0;
					}else if(x==7 && y!=0) {
						y--;
						x=0;
					}else if(y==0) {
						y=7;
						x++;
					}
				}
				}
				//check if the soldier near is a rival soldier and there is an empty square after him.
				if(Board[x][y].getSoldierColor()==Soldier_COLOR_AtSquare.BLACK && Board[x+1][y-1].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY)
					return true;
			*/
			}
		}
		finallyFunction();
		return;
		
		
	}
	
	public void SoldierChooseYellow(int sourcex, int sourcey, int targetx, int targety,int firstsourcex,int firstsourcey){
		numofYellowSquares--;
		popUpQueController popup=new popUpQueController();
		Stage stage= new Stage();
		wasinYellow=true;

		//moving the white soldier to yellow Square
		if(turn==Soldier_COLOR_AtSquare.WHITE) {
			
			moveWhite(sourcex, sourcey, targetx, targety, firstsourcex, firstsourcey);
			for(int j=0; j<g.getWhitePieces().length; j++) {
				if(g.getWhitePieces()[j].getLocation().getX()== targetx && g.getWhitePieces()[j].getLocation().getY()== targety)
				{
					

					board[targetx][targety]=SquareFactory.getSquareObject(SQUARE_COLOR.BLACK
							, targetx, targety, Soldier_COLOR_AtSquare.WHITE, g.getWhitePieces()[j]);
					
				}
			}
		
		

		//moving the black soldier to yellow Square
		}else if(turn==Soldier_COLOR_AtSquare.BLACK) {
			
			moveBlack(sourcex, sourcey, targetx, targety, firstsourcex, firstsourcey);

			for(int j=0; j<g.getBlackPieces().length; j++) {
				if(g.getBlackPieces()[j].getLocation().getX()== targetx && g.getBlackPieces()[j].getLocation().getY()== targety)
				{
					
					board[targetx][targety]=SquareFactory.getSquareObject(SQUARE_COLOR.BLACK
							, targetx, targety, Soldier_COLOR_AtSquare.BLACK, g.getBlackPieces()[j]);								g.getBlackPieces()[j].getLocation().setX(targetx);
							
				}
			}
		

			
		}
System.out.println(board[targetx][targety].getSquareColor());
		// returning the yellow square to black square
		Rectangle r1= getRectangle(targetx,targety);
		r1.setFill(Color.rgb(94,91,91));

		try {
			System.out.println("in the yellow try");
			popup.start(stage);	


		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}


	public void finallyFunction(){
		if(!wasinYellow) {

			int diffPoints=0;// the points that should be decreased or increased to the player
			//checking for the white player that have finished his turn
			if(turn==Soldier_COLOR_AtSquare.BLACK) {
				long elapsedTime = endwhite - startwhite;
				long convert = TimeUnit.SECONDS.convert(elapsedTime, TimeUnit.NANOSECONDS);
				System.out.printf("The timer for the white is:%d",convert);
				if(convert>60) {
					diffPoints=(int)convert-60;
					g.getWhitePlayer().setPoints(g.getWhitePlayer().getPoints()-diffPoints);
					wPointsValue.setText((Integer.toString(g.getWhitePlayer().getPoints())));

				}
				if(convert<60) {
					diffPoints=60-(int)convert;
					g.getWhitePlayer().setPoints(g.getWhitePlayer().getPoints()+diffPoints);
					wPointsValue.setText((Integer.toString(g.getWhitePlayer().getPoints())));

				}
			}
			if(turn==Soldier_COLOR_AtSquare.WHITE) {
				long elapsedTime = endblack - startblack;
				long convert = TimeUnit.SECONDS.convert(elapsedTime, TimeUnit.NANOSECONDS);
				System.out.printf("The timer for the black is:%d",convert);

				if(convert>60) {
					diffPoints=(int)convert-60;
					g.getBlackPlayer().setPoints(g.getBlackPlayer().getPoints()-diffPoints);
					System.out.println("1337");
					bPointsValue.setText((Integer.toString(g.getBlackPlayer().getPoints())));

				}
				if(convert<60) {
					diffPoints=60-(int)convert;
					g.getBlackPlayer().setPoints(g.getBlackPlayer().getPoints()+diffPoints);
					System.out.println("1344");
					bPointsValue.setText((Integer.toString(g.getBlackPlayer().getPoints())));

				}
			}
		}
		// Resert the colored square to black(orange/green/red/blue)
		for(int i=0; i<8; i++) {
			for(int j=0; j<8; j++) {
				if(board[i][j]!=null) {
					if(board[i][j].getSquareColor()==SQUARE_COLOR.GREEN || board[i][j].getSquareColor()==SQUARE_COLOR.ORANGE || board[i][j].getSquareColor()==SQUARE_COLOR.RED || board[i][j].getSquareColor()==SQUARE_COLOR.BLUE) {
						board[i][j]=SquareFactory.getSquareObject(SQUARE_COLOR.BLACK,
								i, j, Soldier_COLOR_AtSquare.EMPTY, null);
						Rectangle colored= getRectangle(i,j);
						if(colored!=null)
							colored.setFill(Color.rgb(94,91,91));

					}
				}
			}
		}

		if(theGameisEnd()==true) {

			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Game Ended");
			alert.setHeaderText("The game ended, The winner is");
			alert.setContentText(theWinner);
			//alert.show();

			// open main menu after ok is pressed
			Optional<ButtonType> result = alert.showAndWait();
			//music();
			if (result.get() == ButtonType.OK) {
				((Stage) Pane.getScene().getWindow()).close();
				Stage stage=new  Stage();
				MainBoardController temp=new MainBoardController();
				try {
					temp.start(stage);	
				} catch (Exception e) {
					// TODO: handle exception
				}
			}



		}
		
		// counting the yellow square at the board
		numofYellowSquares=0;
		for(int i=0; i<8; i++) {
			for(int j=0; j<8; j++) {
				if(board[i][j]!=null) {
					if(board[i][j].getSquareColor()==SQUARE_COLOR.YELLOW) {
						numofYellowSquares++;
System.out.println(numofYellowSquares);
					}
				}
				}
			}
		
		while(numofYellowSquares<3) {
			CheckAndDoYellowSquares();

		}

		CheckAndDoBlueSquare();
		CheckAndDoRedSquare();
		
	}
	
	public void DeadBlack(int sourcex,int sourcey,int targetx,int targety,int firstsourcex,int firstsourcey){
		//**************************
		Player pb= g.getBlackPlayer();
		if(g.IsEatable(pb, g.getBlackPieces())!=null)
		{
		System.out.println("Kan lazm tmoot");

		Soldier c= g.IsEatable(pb,g.getBlackPieces());
		System.out.println(c);
		if( ( sourcex!= (c.getLocation().getX()) &&  ( sourcey!= (c.getLocation().getY()))))
		{
			System.out.println("Kan lazm tmoot!!!!!!!!!!!!!!!");

			for(int j=0; j<g.getBlackPieces().length;j++)
			{
				if( (g.getBlackPieces()[j].getLocation().getX() == c.getLocation().getX()) && g.getBlackPieces()[j].getLocation().getY() == c.getLocation().getY())
				{
					System.out.println("yes you killed");
			int xScene=-1;
			int yScene=-1;
			if(c.getLocation().getX()==0)yScene=30;
			if(c.getLocation().getX()==1)yScene=90;
			if(c.getLocation().getX()==2)yScene=150;
			if(c.getLocation().getX()==3)yScene=210;
			if(c.getLocation().getX()==4)yScene=270;
			if(c.getLocation().getX()==5)yScene=330;
			if(c.getLocation().getX()==6)yScene=390;
			if(c.getLocation().getX()==7)yScene=450;
			
			if(c.getLocation().getY()==0)xScene=30;
			if(c.getLocation().getY()==1)xScene=90;
			if(c.getLocation().getY()==2)xScene=150;
			if(c.getLocation().getY()==3)xScene=210;
			if(c.getLocation().getY()==4)xScene=270;
			if(c.getLocation().getY()==5)xScene=330;
			if(c.getLocation().getY()==6)xScene=390;
			if(c.getLocation().getY()==7)xScene=450;
											

			Circle f= getSoldierOnScene(xScene,yScene);
			f.setVisible(false);
			for(int indexc=0; j<g.getBlackPieces().length;indexc++) {
				if(c.getLocation().getX()==g.getBlackPieces()[indexc].getLocation().getX() && c.getLocation().getY()==g.getBlackPieces()[indexc].getLocation().getY()) {
					board[c.getLocation().getX()][c.getLocation().getY()].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);
					g.getBlackPieces()[indexc].setIsAlive(false);
					System.out.println("1477");
					g.getBlackPieces()[indexc].getLocation().setX(-1);
					System.out.println("1479");
					g.getBlackPieces()[indexc].getLocation().setY(-1);
					System.out.println("1481");
					//changeturntowhite();
					moveBlack(sourcex,sourcey,targetx,targety,firstsourcex,firstsourcey);
					changeturntowhite();
				}
				
			}

				}
				
			}

			
		}
	}
		//**************************
		
	}
	
	public void DeadWhite(int sourcex,int sourcey,int targetx,int targety,int firstsourcex,int firstsourcey) {
		//**************************
		Player pw= g.getWhitePlayer();
		if(g.IsEatable(pw, g.getWhitePieces())!=null)
		{
		System.out.println("Kan lazm tmoot");

		Soldier c= g.IsEatable(pw,g.getWhitePieces());
		System.out.println(c);
		if( ( sourcex!= (c.getLocation().getX()) &&  ( sourcey!= (c.getLocation().getY()))))
		{
			System.out.println("Kan lazm tmoot!!!!!!!!!!!!!!!");

			for(int j=0; j<g.getWhitePieces().length;j++)
			{
				if( (g.getWhitePieces()[j].getLocation().getX() == c.getLocation().getX()) && g.getWhitePieces()[j].getLocation().getY() == c.getLocation().getY())
				{
					System.out.println("yes you killed");
			int xScene=-1;
			int yScene=-1;
			if(c.getLocation().getX()==0)yScene=30;
			if(c.getLocation().getX()==1)yScene=90;
			if(c.getLocation().getX()==2)yScene=150;
			if(c.getLocation().getX()==3)yScene=210;
			if(c.getLocation().getX()==4)yScene=270;
			if(c.getLocation().getX()==5)yScene=330;
			if(c.getLocation().getX()==6)yScene=390;
			if(c.getLocation().getX()==7)yScene=450;
			
			if(c.getLocation().getY()==0)xScene=30;
			if(c.getLocation().getY()==1)xScene=90;
			if(c.getLocation().getY()==2)xScene=150;
			if(c.getLocation().getY()==3)xScene=210;
			if(c.getLocation().getY()==4)xScene=270;
			if(c.getLocation().getY()==5)xScene=330;
			if(c.getLocation().getY()==6)xScene=390;
			if(c.getLocation().getY()==7)xScene=450;
											

			Circle f= getSoldierOnScene(xScene,yScene);
			f.setVisible(false);
			for(int indexc=0; j<g.getWhitePieces().length;indexc++) {
				if(c.getLocation().getX()==g.getWhitePieces()[indexc].getLocation().getX() && c.getLocation().getY()==g.getWhitePieces()[indexc].getLocation().getY()) {
					board[c.getLocation().getX()][c.getLocation().getY()].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);
					g.getWhitePieces()[indexc].setIsAlive(false);
					System.out.println("1477");
					g.getWhitePieces()[indexc].getLocation().setX(-1);
					System.out.println("1479");
					g.getWhitePieces()[indexc].getLocation().setY(-1);
					System.out.println("1481");
					//changeturntowhite();
					moveWhite(sourcex,sourcey,targetx,targety,firstsourcex,firstsourcey);
					changeturntoBlack();
				}
				
			}

				}
				
			}

			
		}
	}
		//**************************
	}
	
}