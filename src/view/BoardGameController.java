package view;

import java.net.URL;



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
import Model.Square;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.Pane;
import java.time.Duration;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import view.TimerInterface;
import view.TimerThread;
import utils.SQUARE_COLOR;
import utils.Soldier_COLOR_AtSquare;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.cell.PropertyValueFactory;
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
	private Square[][] board;
	private int numofYellowSquares=0;
	public Game g;
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
	private TimerInterface gametime;
	private TimerInterface whitetime;
	private TimerInterface blacktime;
	private Duration duration;
	private Circle[] blackcircles = new Circle[12];// this array include the black circles
	private Circle[] whitecircles = new Circle[12];// this array include the white circles
	public boolean isLoad;
	private long endwhite;
	private long endblack;
	private long startwhite;
	private long startblack;


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


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		if (!NicknamesSetUpController.getWhitename().isEmpty() && !NicknamesSetUpController.getBlackname().isEmpty())
		{

			MainBoardController.BoardGame=this;


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
				CheckAndDoRedSquare();



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
						blackc++;
					}
					while(whitec<12)
					{
						whitecircles[whitec].setVisible(false);
						whitec++;
					}


					if(arrOfStr[arrOfStr.length-1].equals("B"))
					{
						TurnLbl.setText("Its the Black turn");
						turn=Soldier_COLOR_AtSquare.BLACK;
						startBlackTimer();
					}
					if(arrOfStr[arrOfStr.length-1].equals("W"))
					{
						TurnLbl.setText("Its the White turn");
						turn=Soldier_COLOR_AtSquare.WHITE;

						startWhiteTimer();
					}

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}



			}

		}	
			while(numofYellowSquares<3) {
				CheckAndDoYellowSquares();

			}
			
/// check for tghe white<30
			
		

	}

	@FXML
	void MoveToSquare(MouseEvent event) {
		if(redSoldier==null) {
		this.target=(Rectangle) event.getTarget();
		MoveSoldierToTarget();
		}
		else if(redSoldier.equals(this.soldier)) {
			this.target=(Rectangle) event.getTarget();
			MoveSoldierToTarget();
			redSoldier=null;
		}

	}

	@FXML
	void MoveSoldier(MouseEvent event) {
		this.soldier=(Circle) event.getTarget();
		int sourcex=TransForCordinateNum((int)this.soldier.getLayoutY()-30);
		System.out.printf("the row of the soldier is: %d\n",sourcex);
		int sourcey=TransForCordinateNum((int)this.soldier.getLayoutX()-30);
		System.out.printf("the col of the soldier is: %d\n",sourcey);
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

			if(board[targetx][targety].getSquareColor()==SQUARE_COLOR.BLACK || board[targetx][targety].getSquareColor()==SQUARE_COLOR.ORANGE) {


				//moving the black soldier to target square
				if(this.board[sourcex][sourcey].getSoldierColor() == Soldier_COLOR_AtSquare.BLACK )  {
					for(int i=0; i<g.getBlackPieces().length; i++) {
						if(g.getBlackPieces()[i].getLocation().getX()== sourcex && g.getBlackPieces()[i].getLocation().getY()== sourcey)
						{
							System.out.println("IS 5lsne w fot hon!");

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
										redSoldier=null;
										

									}

									if(sourcex==targetx-1 && sourcey==targety-1)
									{
										double soldiersourcex=this.soldier.getLayoutX();
										double soldiersourcey=this.soldier.getLayoutY();
										this.soldier.setLayoutX(soldiersourcex+60);
										this.soldier.setLayoutY(soldiersourcey+60);
										board[sourcex][sourcey].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);
										board[targetx][targety].setSoldierColor(Soldier_COLOR_AtSquare.BLACK);
										redSoldier=null;
										

									}

									if(targetx==7)
									{
										this.soldier.setFill(Color.BROWN);
										for(int j=0;j<g.getBlackPieces().length;j++)
										{
											if(g.getBlackPieces()[i].getLocation().getX()== targetx && g.getBlackPieces()[i].getLocation().getY()== targety)
											{
												g.getBlackPieces()[i].setIsQueen(true);
												redSoldier=null;
												
											}
										}
									}


								}
								// right black eat
								else if(targety==sourcey+2 && targetx==sourcex+2) {
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
												bPointsValue.setText((Integer.toString(g.getBlackPlayer().getPoints())));
												redSoldier=null;


												if(c!=null)
													//ethar and maisa
													if(c.getFill()==Color.WHITE);
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
															redSoldier=null;
															
														}	
													}	
												}


											}
										}
									}
								}
								else
									if(targety==sourcey-2 && targetx==sourcex+2) {
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
													bPointsValue.setText((Integer.toString(g.getBlackPlayer().getPoints())));
													redSoldier=null;
													
													if(c!=null)
														if(c.getFill()==Color.WHITE);
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
																redSoldier=null;
																
															}	
														}	
													}
												}
											}
										}
									}


							}

							// move black queen	
							else	
							{	
								int queenmove= g.getBlackPieces()[i].QueenMove(board, sourcex, sourcey, targetx, targety, Soldier_COLOR_AtSquare.BLACK);	
								if(queenmove == 0)	
								{	
									System.out.println("queen legal move");	
									Circle c=newlayout(targetx, targety, this.soldier);	

									this.soldier.setLayoutX(c.getLayoutX());	
									this.soldier.setLayoutY(c.getLayoutY());
									redSoldier=null;
									
								}	
								else	
									this.soldier.setVisible(false);	
							}

						}


					}

					turn = Soldier_COLOR_AtSquare.WHITE;
					blackgreentimer.stop();
					blackorangetimer.stop();
					TurnLbl.setText("Its the White turn");
					redSoldier=null;
					if(blackthread!=null)
						blackthread.interrupt();
					startWhiteTimer();
					
					startwhite=System.nanoTime();
					endblack=System.nanoTime();
				
					
					if(board[targetx][targety].getSquareColor()==SQUARE_COLOR.ORANGE) {
						// returning the orange square to black square
						Rectangle r1= getRectangle(targetx,targety);
						board[targetx][targety].setSquareColor(SQUARE_COLOR.BLACK);
						r1.setFill(Color.rgb(94,91,91));
					}
					

				}
				//moving the white soldier to target square
				else if(this.board[sourcex][sourcey].getSoldierColor() == Soldier_COLOR_AtSquare.WHITE) {
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
										redSoldier=null;
										
									}

									if(sourcex==targetx+1 && sourcey==targety+1)
									{
										double soldiersourcex=this.soldier.getLayoutX();
										double soldiersourcey=this.soldier.getLayoutY();
										this.soldier.setLayoutX(soldiersourcex-60);
										this.soldier.setLayoutY(soldiersourcey-60);
										board[sourcex][sourcey].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);
										board[targetx][targety].setSoldierColor(Soldier_COLOR_AtSquare.WHITE);
										redSoldier=null;
										


									}
									if(targetx==0)
									{
										this.soldier.setFill(Color.BLUE);
										for(int j=0;j<g.getWhitePieces().length;j++)
										{
											if(g.getWhitePieces()[i].getLocation().getX()== targetx && g.getWhitePieces()[i].getLocation().getY()== targety)
											{
												g.getWhitePieces()[i].setIsQueen(true);
												redSoldier=null;
												
											}
										}
									}





								}
								// eaten to the up right side
								else if(targety==sourcey+2 && targetx+2==sourcex) {
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
												redSoldier=null;
												
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
															redSoldier=null;
														
														}	
													}	
												}	


											}
										}
									}
								}
								//eaten to the up left side
								else if(targety==sourcey-2 && targetx+2==sourcex) {
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
												redSoldier=null;
												
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
															redSoldier=null;
															
														}	
													}	
												}	


											}
										}
									}
								}
							}
							// move black queen	
							else	
							{	
								int queenmove= g.getWhitePieces()[i].QueenMove(board, sourcex, sourcey, targetx, targety, Soldier_COLOR_AtSquare.WHITE);	
								if(queenmove == 0)	
								{	
									System.out.println("queen legal move");	
									Circle c=newlayout(targetx, targety, this.soldier);	

									this.soldier.setLayoutX(c.getLayoutX());	
									this.soldier.setLayoutY(c.getLayoutY());	
									redSoldier=null;
									
								}	
								else	
									this.soldier.setVisible(false);	
							}
						}
					}

					turn = Soldier_COLOR_AtSquare.BLACK;
					whitegreentimer.stop();
					whiteorangetimer.stop();
					TurnLbl.setText("Its the Black turn");
					if(whitethread!=null)
						whitethread.interrupt();
					startBlackTimer();
					
					startblack=System.nanoTime();
					endwhite=System.nanoTime();
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
				//takint the first dead soldier at the black pieces
				if(turn == Soldier_COLOR_AtSquare.BLACK) {   
					while(s==null && index<12) {
						if(g.getBlackPieces()[index].isIsAlive()==false) {
							s=g.getBlackPieces()[index];
						}
						index++;
					}
				}
				//takint the first dead soldier at the white pieces
				if(turn == Soldier_COLOR_AtSquare.WHITE) {   
					while(s==null && index<12) {
						if(g.getWhitePieces()[index].isIsAlive()==false) {
							s=g.getWhitePieces()[index];
						}
						index++;
					}
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Return Soldier");
					alert.setHeaderText("Please Enter The Row and Col Numbers you want to return the soldier to: ");
					alert.setContentText("Row Number:");
					TextField rown = new TextField();
					alert.setContentText("Coloumn Number:");
					TextField coln = new TextField();
					ButtonType buttonTypeApply = new ButtonType("Enter", ButtonData.APPLY);
					Optional<ButtonType> Confirm = alert.showAndWait();
					if (Confirm.get().getButtonData() == ButtonData.APPLY) {
						try {
							int x =Integer.parseInt(rown.getText());
							int y = Integer.parseInt(coln.getText());
							g.returnSoldier(s, x, y);
							//Sysdata.getInstance().removeQuestion(q);
							//setQuestionTable();
							//erorLabel.setText("Question deleted successfully.");
						} catch (Exception e) {
							//To DO
						}
					}

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
						board[targetx][targety].setSoldierColor(Soldier_COLOR_AtSquare.WHITE);
						g.getWhitePieces()[j].getLocation().setX(targetx);
						g.getWhitePieces()[j].getLocation().setY(targety);
					}
					}
					// returning the green square to black square
					Rectangle r1= getRectangle(targetx,targety);
					board[targetx][targety].setSquareColor(SQUARE_COLOR.BLACK);
					r1.setFill(Color.rgb(94,91,91));

					turn = Soldier_COLOR_AtSquare.BLACK;
					
					whitegreentimer.stop();
					whiteorangetimer.stop();
					TurnLbl.setText("Its the Black turn");
					if(whitethread!=null)
						whitethread.interrupt();
					startBlackTimer();
				redSoldier=null;
				endwhite=System.nanoTime();
				startblack=System.nanoTime();
					this.soldier=null;
					this.target=null;
					return 0;
				}
				else if(turn==Soldier_COLOR_AtSquare.BLACK) {
					g.getBlackPlayer().setPoints(g.getBlackPlayer().getPoints()+50);
					bPointsValue.setText((Integer.toString(g.getBlackPlayer().getPoints())));
					this.soldier= newlayout(targetx,targety,this.soldier);
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
					// returning the green square to black square
					Rectangle r1= getRectangle(targetx,targety);
					board[targetx][targety].setSquareColor(SQUARE_COLOR.BLACK);
					r1.setFill(Color.rgb(94,91,91));
					
					turn = Soldier_COLOR_AtSquare.WHITE;
					
					blackgreentimer.stop();
					blackorangetimer.stop();
					TurnLbl.setText("Its the White turn");
					if(blackthread!=null)
						blackthread.interrupt();
					startWhiteTimer();
					
					endblack=System.nanoTime();
					startwhite=System.nanoTime();
					
					redSoldier=null;
					
					this.soldier=null;
					this.target=null;
					
					return 0;
				}
			}
			if(board[targetx][targety].getSquareColor()==SQUARE_COLOR.RED) {
				if(turn==Soldier_COLOR_AtSquare.WHITE) {
					turn=Soldier_COLOR_AtSquare.WHITE;
					redSoldier=this.soldier;
					turn = Soldier_COLOR_AtSquare.WHITE;
					whitegreentimer.stop();
					whiteorangetimer.stop();
					TurnLbl.setText("Its the WHITE turn");
					if(whitethread!=null)
						whitethread.interrupt();
					startWhiteTimer();
					endwhite=System.nanoTime();
					startwhite=System.nanoTime();
					// returning the red square to black square
					Rectangle r1= getRectangle(targetx,targety);
					board[targetx][targety].setSquareColor(SQUARE_COLOR.BLACK);
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
					
				}	
				if(turn==Soldier_COLOR_AtSquare.BLACK) {
					turn=Soldier_COLOR_AtSquare.BLACK;
					redSoldier=this.soldier;
					turn = Soldier_COLOR_AtSquare.BLACK;
					blackgreentimer.stop();
					blackorangetimer.stop();
					TurnLbl.setText("Its the Black turn");
					if(blackthread!=null)
						blackthread.interrupt();
					startBlackTimer();
					endblack=System.nanoTime();
					startblack=System.nanoTime();
					// returning the red square to black square
					Rectangle r2= getRectangle(targetx,targety);
					board[targetx][targety].setSquareColor(SQUARE_COLOR.BLACK);
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
					
					
				}
				
			}
		
			}
			}
		
		catch (Exception e) {
				//ToDo
			}
		finally {
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
					bPointsValue.setText((Integer.toString(g.getBlackPlayer().getPoints())));
					
				}
				if(convert<60) {
					diffPoints=60-(int)convert;
					g.getBlackPlayer().setPoints(g.getBlackPlayer().getPoints()+diffPoints);
					bPointsValue.setText((Integer.toString(g.getBlackPlayer().getPoints())));
					
				}
				}
			
			// Resert the colored square to black(orange/green/red/blue)
		for(int i=0; i<8; i++) {
			for(int j=0; j<8; j++) {
				if(board[i][j]!=null) {
					if(board[i][j].getSquareColor()==SQUARE_COLOR.GREEN || board[i][j].getSquareColor()==SQUARE_COLOR.ORANGE || board[i][j].getSquareColor()==SQUARE_COLOR.RED || board[i][j].getSquareColor()==SQUARE_COLOR.BLUE) {
						board[i][j].setSquareColor(SQUARE_COLOR.BLACK);
						Rectangle colored= getRectangle(i,j);
						colored.setFill(Color.rgb(94,91,91));
						
					}
				}
			}
		}
		CheckAndDoRedSquare();
		CheckAndDoBlueSquare();
		if(theGameisEnd()==true) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Game is End");
			alert.setHeaderText("The game is ending, we hope you have fun!");
		}
		}
		return -1;


	}

	private boolean theGameisEnd() {
		
		int bcountdead=0; // the number of black soldiers that have dead 
		int wcountdead=0; // the number of white soldiers that have dead 

		for(int i=0; i<g.getBlackPieces().length;i++) {
			if(g.getBlackPieces()[i].isIsAlive()==false) {
				bcountdead++;
			}
			
		}
		if(bcountdead==12) {
			theWinner=whiteName;
			return true;
		}
		
		for(int i=0; i<g.getWhitePieces().length;i++) {
			if(g.getWhitePieces()[i].isIsAlive()==false) {
				wcountdead++;
			}
			
		}
		if(wcountdead==12) {
			theWinner=blackName;
			return true;
		}
		
//		if(g.IsBlocked(g.getWhitePlayer())==true) {
//			theWinner=blackName;
//			return true;
//		}
//		
//		if(g.IsBlocked(g.getBlackPlayer())==true) {
//			theWinner=whiteName;
//			return true;
//		}
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
System.out.println("Fat 3l if 1 b CheckAndDoYellowSquares");
				if(board[x][y].getSquareColor()==SQUARE_COLOR.BLACK && board[x][y].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY ) {
					
					Rectangle yellowSquare=getRectangle(x,y);
					
					if(yellowSquare!=null) {
					yellowSquare.setFill(Color.rgb(255,255,0));
					board[x][y].setSquareColor(SQUARE_COLOR.YELLOW);
					System.out.println("Fat 3l if 222 b CheckAndDoYellowSquares");
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
			if(g.IsEatable(pw,g.getWhitePieces())==false) {
				for(int i=0; i<g.getWhitePieces().length; i++) {
					// righ side
					if(((g.getWhitePieces()[i].getLocation().getX())-1)>0 && ((g.getWhitePieces()[i].getLocation().getY())+1)<8 && board[(g.getWhitePieces()[i].getLocation().getX())-1][(g.getWhitePieces()[i].getLocation().getY())+1].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY && board[(g.getWhitePieces()[i].getLocation().getX())-1][(g.getWhitePieces()[i].getLocation().getY())+1].getSquareColor()==SQUARE_COLOR.BLACK) {
						System.out.printf("X:%d Y:%d \n",(g.getWhitePieces()[i].getLocation().getX())-1,(g.getWhitePieces()[i].getLocation().getY())+1);
						Rectangle r= getRectangle((g.getWhitePieces()[i].getLocation().getX())-1,(g.getWhitePieces()[i].getLocation().getY())+1);
						board[(g.getWhitePieces()[i].getLocation().getX())-1][(g.getWhitePieces()[i].getLocation().getY())+1].setSquareColor(SQUARE_COLOR.RED);
						r.setFill(Color.rgb(255,0,0));
						return;
					}

					// left side
					if((g.getWhitePieces()[i].getLocation().getX()-1)>0 && ((g.getWhitePieces()[i].getLocation().getY()))-1>0 &&  board[(g.getWhitePieces()[i].getLocation().getX())-1][(g.getWhitePieces()[i].getLocation().getY())-1].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY && board[(g.getWhitePieces()[i].getLocation().getX())-1][(g.getWhitePieces()[i].getLocation().getY())-1].getSquareColor()==SQUARE_COLOR.BLACK) {
						Rectangle r= getRectangle((g.getWhitePieces()[i].getLocation().getX())-1,(g.getWhitePieces()[i].getLocation().getY())-1);
						System.out.println(2);
						board[(g.getWhitePieces()[i].getLocation().getX())-1][(g.getWhitePieces()[i].getLocation().getY())-1].setSquareColor(SQUARE_COLOR.RED);
						r.setFill(Color.rgb(255,0,0));
						return;
					}

				}

			}
		}


		if(turn==Soldier_COLOR_AtSquare.BLACK)
		{
			Player pb= g.getBlackPlayer();

			if(g.IsEatable(pb,g.getBlackPieces())==false) {
				for(int i=0; i<g.getBlackPieces().length; i++) {
					// righ side
					if(g.getBlackPieces()[i].getLocation().getY()-1>1 && board[(g.getBlackPieces()[i].getLocation().getX())+1][(g.getBlackPieces()[i].getLocation().getY())-1].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY && board[(g.getBlackPieces()[i].getLocation().getX())+1][(g.getBlackPieces()[i].getLocation().getY())-1].getSquareColor()==SQUARE_COLOR.BLACK) {
						Rectangle r= getRectangle((g.getBlackPieces()[i].getLocation().getX())+1,(g.getBlackPieces()[i].getLocation().getY())-1);
						board[(g.getWhitePieces()[i].getLocation().getX())+1][(g.getWhitePieces()[i].getLocation().getY())-1].setSquareColor(SQUARE_COLOR.RED);
						r.setFill(Color.rgb(255,0,0));
						return;
					}

					// left side
					if(g.getBlackPieces()[i].getLocation().getX()<7 && g.getBlackPieces()[i].getLocation().getY()<7 && board[(g.getBlackPieces()[i].getLocation().getX())+1][(g.getBlackPieces()[i].getLocation().getY())+1].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY && board[(g.getBlackPieces()[i].getLocation().getX())+1][(g.getBlackPieces()[i].getLocation().getY())+1].getSquareColor()==SQUARE_COLOR.BLACK) {
						Rectangle r= getRectangle((g.getBlackPieces()[i].getLocation().getX())+1,(g.getBlackPieces()[i].getLocation().getY())+1);
						board[(g.getBlackPieces()[i].getLocation().getX())+1][(g.getBlackPieces()[i].getLocation().getY())+1].setSquareColor(SQUARE_COLOR.RED);
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
		Random rand = new Random();
		int x = rand.nextInt(8); 
		int y = rand.nextInt(8);
		int cntSoldier=0; //counter for the soldiers
		int cntQueen=0; //counter for the queens.
		//if it's the white player turn
		if(turn==Soldier_COLOR_AtSquare.WHITE) {
			for(int i=0; i < g.getWhitePieces().length; i++) {
				//count the alive soldiers
				if(g.getWhitePieces()[i].isIsAlive() && g.getWhitePieces()[i].getColor() == Soldier_COLOR_AtSquare.WHITE) {
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
						if(board[x][y]!=null) 
						{
							if(board[x][y].getSquareColor()!=null) {

								if(board[x][y].getSquareColor()==SQUARE_COLOR.BLACK && board[x][y].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY ) {
									board[x][y].setSquareColor(SQUARE_COLOR.BLUE);
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
				if(g.getBlackPieces()[i].isIsAlive() && g.getBlackPieces()[i].getColor() == Soldier_COLOR_AtSquare.BLACK) {
					//count the alive soldiers
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
					if(!g.getBlackPieces()[j].isIsAlive())
						if(board[x][y]!=null) 
						{
							if(board[x][y].getSquareColor()!=null) {

								if(board[x][y].getSquareColor()==SQUARE_COLOR.BLACK && board[x][y].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY ) {
									board[x][y].setSquareColor(SQUARE_COLOR.BLUE);
									r.setFill(Color.rgb(4,56,218));
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
								board[(g.getWhitePieces()[i].getLocation().getX())-1][(g.getWhitePieces()[i].getLocation().getY())+1].setSquareColor(SQUARE_COLOR.GREEN);
								r.setFill(Color.rgb(10,160,25));
								return;
							}
							}
							
							if(g.getWhitePieces()[i].getLocation().getY()==7) {
								 if(board[(g.getWhitePieces()[i].getLocation().getX())-1][(g.getWhitePieces()[i].getLocation().getY())-1].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY && board[(g.getWhitePieces()[i].getLocation().getX())-1][(g.getWhitePieces()[i].getLocation().getY())-1].getSquareColor()==SQUARE_COLOR.BLACK) {

								//fill green
								Rectangle r= getRectangle((g.getWhitePieces()[i].getLocation().getX())-1,(g.getWhitePieces()[i].getLocation().getY())-1);
								board[(g.getWhitePieces()[i].getLocation().getX())-1][(g.getWhitePieces()[i].getLocation().getY())-1].setSquareColor(SQUARE_COLOR.GREEN);
								r.setFill(Color.rgb(10,160,25));
								return;
							}
							}
							else if(g.getWhitePieces()[i].getLocation().getY()>0 && g.getWhitePieces()[i].getLocation().getY()<7) {
							 if(board[(g.getWhitePieces()[i].getLocation().getX())-1][(g.getWhitePieces()[i].getLocation().getY())-1].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY && board[(g.getWhitePieces()[i].getLocation().getX())-1][(g.getWhitePieces()[i].getLocation().getY())-1].getSquareColor()==SQUARE_COLOR.BLACK) {
								//fill green
								Rectangle r= getRectangle((g.getWhitePieces()[i].getLocation().getX())-1,(g.getWhitePieces()[i].getLocation().getY())-1);
								board[(g.getWhitePieces()[i].getLocation().getX())-1][(g.getWhitePieces()[i].getLocation().getY())-1].setSquareColor(SQUARE_COLOR.GREEN);
								r.setFill(Color.rgb(10,160,25));
								return;
							}
							if(g.getWhitePieces()[i].getLocation().getX()<6 && g.getWhitePieces()[i].getLocation().getY()<6 && board[(g.getWhitePieces()[i].getLocation().getX())-1][(g.getWhitePieces()[i].getLocation().getY())+1].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY && board[(g.getWhitePieces()[i].getLocation().getX())-1][(g.getWhitePieces()[i].getLocation().getY())+1].getSquareColor()==SQUARE_COLOR.BLACK) {
								//fill green
								Rectangle r= getRectangle((g.getWhitePieces()[i].getLocation().getX())-1,(g.getWhitePieces()[i].getLocation().getY())+1);
								board[(g.getWhitePieces()[i].getLocation().getX())-1][(g.getWhitePieces()[i].getLocation().getY())+1].setSquareColor(SQUARE_COLOR.GREEN);
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
								board[(g.getBlackPieces()[i].getLocation().getX())+1][(g.getBlackPieces()[i].getLocation().getY())+1].setSquareColor(SQUARE_COLOR.GREEN);
								r.setFill(Color.rgb(10,160,25));
								return;
							}
							}
							
							if(g.getBlackPieces()[i].getLocation().getY()==7) {
								if(board[(g.getBlackPieces()[i].getLocation().getX())+1][(g.getBlackPieces()[i].getLocation().getY())-1].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY && board[(g.getBlackPieces()[i].getLocation().getX())+1][(g.getBlackPieces()[i].getLocation().getY())-1].getSquareColor()==SQUARE_COLOR.BLACK) {
									//fill green
									Rectangle r= getRectangle((g.getBlackPieces()[i].getLocation().getX())+1,(g.getBlackPieces()[i].getLocation().getY())-1);
									board[(g.getBlackPieces()[i].getLocation().getX())+1][(g.getBlackPieces()[i].getLocation().getY())-1].setSquareColor(SQUARE_COLOR.GREEN);
									r.setFill(Color.rgb(10,160,25));
									return;
								}
								}
							else if(g.getBlackPieces()[i].getLocation().getY()>0 && g.getBlackPieces()[i].getLocation().getY()<7) {

							if(board[(g.getBlackPieces()[i].getLocation().getX())+1][(g.getBlackPieces()[i].getLocation().getY())-1].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY && board[(g.getBlackPieces()[i].getLocation().getX())+1][(g.getBlackPieces()[i].getLocation().getY())-1].getSquareColor()==SQUARE_COLOR.BLACK) {
								//fill green
								Rectangle r= getRectangle((g.getBlackPieces()[i].getLocation().getX())+1,(g.getBlackPieces()[i].getLocation().getY())-1);
								board[(g.getBlackPieces()[i].getLocation().getX())+1][(g.getBlackPieces()[i].getLocation().getY())-1].setSquareColor(SQUARE_COLOR.GREEN);
								r.setFill(Color.rgb(10,160,25));
								return;
							}
				
							if(g.getBlackPieces()[i].getLocation().getX()<6 && g.getBlackPieces()[i].getLocation().getY()<6 && board[(g.getBlackPieces()[i].getLocation().getX())+1][(g.getBlackPieces()[i].getLocation().getY())+1].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY && board[(g.getBlackPieces()[i].getLocation().getX())+1][(g.getBlackPieces()[i].getLocation().getY())+1].getSquareColor()==SQUARE_COLOR.BLACK) {
								//fill green
								Rectangle r= getRectangle((g.getBlackPieces()[i].getLocation().getX())+1,(g.getBlackPieces()[i].getLocation().getY())+1);
								board[(g.getBlackPieces()[i].getLocation().getX())+1][(g.getBlackPieces()[i].getLocation().getY())+1].setSquareColor(SQUARE_COLOR.GREEN);
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

	public void startWhiteTimer() 
	{
		whitetime=new DigitTimerGroup(WhiteTimer);
		whitethread = new TimerThread(whitetime);
		whitethread.setDaemon(true);
		whitethread.start();
		 whitegreentimer = new Timer(10000, new ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent arg0) {
				CheckAndDoGreenSquare();
			}
		});
		whitegreentimer.start(); // Go go go!
	whitegreentimer.setRepeats(false); // Only execute once
		//Greentimer.stop();

		
		 whiteorangetimer = new Timer(20000, new ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent arg0) {
				CheckAndDoOrangeSquare();
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
		 blackgreentimer = new Timer(10000, new ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent arg0) {
				CheckAndDoGreenSquare();
			}
		});
	
		blackgreentimer.start(); // Go go go!
		blackgreentimer.setRepeats(false); // Only execute once
		//timer.stop();
		
		 blackorangetimer = new Timer(20000, new ActionListener() {
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
	

}