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

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
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
	private Soldier_COLOR_AtSquare turn=Soldier_COLOR_AtSquare.WHITE;
	private Square[][] board;
	private int numofYellowSquares=0;
	public Game g;
	private String whiteName;//the white player name
	private String blackName;//the black player name
	private Rectangle r=null;
	//soldier that has chosen to be moved
	private Circle soldier=null;
	// target square the soldier want to turn to
	private Rectangle target=null;
	//this Pane is the CurrentRowPane: help us at the CheckAndDoYellow methods
	private Pane rowPane=null;
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
			gametime=new DigitTimerGroup(gameTimer);
			gamethread = new TimerThread(gametime);
			gamethread.setDaemon(true);
			gamethread.start();
			startWhiteTimer();



			// setting the current player in the board game
			whiteName = NicknamesSetUpController.getWhitename();
			blackName = NicknamesSetUpController.getBlackname();
			Player white = new Player(NicknamesSetUpController.getWhitename() , 0);
			Player black = new Player(NicknamesSetUpController.getBlackname() , 0);
			WhiteNickText.setEditable(false);
			BlackNickText.setEditable(false);

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


			if(!NicknamesSetUpController.isLoad())
			{

				Date d = new Date();
				Time t = new Time(0, 0, 0);

				g = new Game(white, black,d,t);
				g.initiateGame();
				this.board=g.getBoard();

//				while(numofYellowSquares<3) {
//					CheckAndDoYellowSquares();
//
//				}

				for( int i=0; i<12;i++) {
					int x=g.getBlackPieces()[i].getLocation().getX();
					int y=g.getBlackPieces()[i].getLocation().getY();
					System.out.printf("%d %d\n",x,y);
				}

				TurnLbl.setText("Its the White turn");

				//CheckAndDoRedSquare();



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

					int whitec=0;
					int blackc=0;
					for(int row=0;row<8;row++)
					{

						for(int col=0;col<8;col+=2)
						{

							if(g.getBoard()[row][col]!=null&&
									g.getBoard()[row][col].getSquareColor().equals(SQUARE_COLOR.BLACK)
									&& !g.getBoard()[row][col].getSoldierColor().equals(Soldier_COLOR_AtSquare.EMPTY))
							{

								if(g.getBoard()[row][col].getSoldierColor().equals(Soldier_COLOR_AtSquare.BLACK))
								{
									blackcircles[blackc]=newlayout(row, col, blackcircles[blackc]);

									g.getBlackPieces()[blackc].getLocation().setX(row);
									g.getBlackPieces()[blackc].getLocation().setY(col);
									
									g.getBoard()[row][col].setS(g.getBlackPieces()[blackc]);
									System.out.println(g.getBoard()[row][col].getS());

									g.getBoard()[row][col].getS().setLocation(g.getBoard()[row][col]);
									
									System.out.println("this is black:" + row+"-"+col);
									b11=newlayout(4, 1, b11);
									blackc++;

								}
								if(g.getBoard()[row][col].getSoldierColor().equals(Soldier_COLOR_AtSquare.WHITE))
								{
									whitecircles[whitec]=newlayout(row, col, blackcircles[whitec]);
									g.getWhitePieces()[whitec].getLocation().setX(row);
									g.getWhitePieces()[whitec].getLocation().setY(col);
									
									g.getBoard()[row][col].setS(g.getWhitePieces()[whitec]);
									System.out.println(g.getBoard()[row][col].getS());
									g.getBoard()[row][col].getS().setLocation(g.getBoard()[row][col]);
									whitecircles[whitec].setLayoutX(whitecircles[whitec].getLayoutX());
									whitecircles[whitec].setLayoutY(whitecircles[whitec].getLayoutY());
									whitec++;
									System.out.println("this is white:" + row+"-"+col);
								}


							}
							else System.out.println("aaaaaaaaaaaaaaaa");
						}

					}


				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}



			}

		}	

	}
	
	//ON ACTION & Helping methods

	@FXML
	void MoveToSquare(MouseEvent event) {

		this.target=(Rectangle) event.getTarget();
		MoveSoldierToTarget();
	}

	@FXML
	void MoveSoldier(MouseEvent event) {
		this.soldier=(Circle) event.getTarget();
		int firstsourcex=(int) this.soldier.getLayoutX();
		int firstsourcey=(int) this.soldier.getLayoutY();
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

	//this function transfer the coordinate from the row and column( 0<c<7) to layout x and layouty
	private int TransForScene(int c) {
		int layout=0;
		while(c>0) {
			layout=layout+60;
			c--;
		}
		return layout;
	}


	private int MoveSoldierToTarget() {
		if(soldier!=null && target!=null) {
			int firstsourcex=(int) this.soldier.getLayoutX();
			int firstsourcey=(int) this.soldier.getLayoutY();
			int firsttargetx=(int) target.getLayoutX();
			int firsttargety=(int) target.getLayoutX();
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

           if(board[targetx][targety].getSquareColor()==SQUARE_COLOR.BLACK) {

			//moving the black soldier to target square
			if(this.board[sourcex][sourcey].getSoldierColor() == Soldier_COLOR_AtSquare.BLACK )  {
				for(int i=0; i<g.getBlackPieces().length; i++) {
					if(g.getBlackPieces()[i].getLocation().getX()== sourcex && g.getBlackPieces()[i].getLocation().getY()== sourcey)
							 {
						if(!g.getBlackPieces()[i].isIsQueen()) {
						System.out.println("okkkkkkkkkk");
						int isOk =(g.getBlackPieces()[i]).moveBlack( sourcex, sourcey, targetx,targety,board);
						if(isOk==0) {

							System.out.println("is ok");
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
						// right black eat
						else if(targety==sourcey+2 && targetx==sourcex+2) {
							System.out.println("else1");
							if(board[sourcex+1][sourcey+1].getSoldierColor()==Soldier_COLOR_AtSquare.WHITE) {
								for(int j=0; j<g.getWhitePieces().length; j++) {
									if(g.getWhitePieces()[j].getLocation().getX()== sourcex+1 && g.getWhitePieces()[j].getLocation().getY()== sourcey+1) {
										// remove the white soldier
										System.out.println("HEREEEEE");
										g.getWhitePieces()[j].setIsAlive(false);
										g.getWhitePieces()[j].getLocation().setX(-1);
										g.getWhitePieces()[j].getLocation().setY(-1);
										board[sourcex+1][sourcey+1].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);
										int xcsene= (firstsourcex)+60;//nzed 3l func
										System.out.println(xcsene);
								
										int yscene=(firstsourcey)+60;//...
										System.out.println(yscene);
										Circle c=getSoldierOnScene(xcsene,yscene);
										//******
										this.soldier.setLayoutX(firstsourcex+120);
										this.soldier.setLayoutY(firstsourcey+120);
										board[sourcex][sourcey].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);
										board[targetx][targety].setSoldierColor(Soldier_COLOR_AtSquare.BLACK);
		                                g.getBlackPieces()[i].getLocation().setX(targetx);
		                                g.getBlackPieces()[i].getLocation().setY(targety);

                                    
										
										
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
												}	
											}	
										}
										
										
									}
							}
							}
						}
						else
							 if(targety==sourcey-2 && targetx==sourcex+2) {
									System.out.println("else1");
									if(board[sourcex+1][sourcey-1].getSoldierColor()==Soldier_COLOR_AtSquare.WHITE) {
										for(int j=0; j<g.getWhitePieces().length; j++) {
											if(g.getWhitePieces()[j].getLocation().getX()== sourcex+1 && g.getWhitePieces()[j].getLocation().getY()== sourcey-1) {
												// remove the soldier
												System.out.println("HEREEEEE");
												g.getWhitePieces()[j].setIsAlive(false);
												g.getWhitePieces()[j].getLocation().setX(-1);
												g.getWhitePieces()[j].getLocation().setY(-1);
												board[sourcex+1][sourcey-1].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);
												int xcsene= (firstsourcex)-60;//nzed 3l func
												System.out.println(xcsene);
										
												int yscene=(firstsourcey)+60;//...
												System.out.println(yscene);
												Circle c=getSoldierOnScene(xcsene,yscene);
												//******
												this.soldier.setLayoutX(firstsourcex-120);
												this.soldier.setLayoutY(firstsourcey+120);
												board[sourcex][sourcey].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);
												board[targetx][targety].setSoldierColor(Soldier_COLOR_AtSquare.BLACK);
												 g.getBlackPieces()[i].getLocation().setX(targetx);
					                              g.getBlackPieces()[i].getLocation().setY(targety);

												
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
														}	
													}	
												}
											}
									}
									}
								}
							//System.out.println("not ok");
							
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
								}	
								else	
									this.soldier.setVisible(false);	
							}
							
				}
					
					
				}
				endblack=System.nanoTime();
				long elapsedTime = endblack - startblack;
				long convert = TimeUnit.SECONDS.convert(elapsedTime, TimeUnit.NANOSECONDS);
				if(convert>=30)
				{
					//CheckAndDoGreenSquare();
				}
				if(convert >= 90)
				{
					//CheckAndDoOrangeSquare();
				}
				turn = Soldier_COLOR_AtSquare.WHITE;
				TurnLbl.setText("Its the White turn");
				blackthread.interrupt();
				startWhiteTimer();

			}
			//moving the white soldier to target square
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
						// eaten to the up right side
						else if(targety==sourcey+2 && targetx+2==sourcex) {
							System.out.println("else1");
							if(board[sourcex-1][sourcey+1].getSoldierColor()==Soldier_COLOR_AtSquare.BLACK) {
								System.out.println("if2");
								for(int j=0; j<g.getBlackPieces().length; j++) {
									if(g.getBlackPieces()[j].getLocation().getX()== sourcex-1 && g.getBlackPieces()[j].getLocation().getY()== sourcey+1) {
										// remove the soldier
										System.out.println("HEREEEEE");
										g.getBlackPieces()[j].setIsAlive(false);
										g.getBlackPieces()[j].getLocation().setX(-1);
										g.getBlackPieces()[j].getLocation().setY(-1);
										board[sourcex-1][sourcey+1].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);
										int xcsene= (firstsourcex)+60;//nzed 3l func
										System.out.println(xcsene);
								
										int yscene=(firstsourcey)-60;//...
										System.out.println(yscene);
										Circle c=getSoldierOnScene(xcsene,yscene);
										//******
										this.soldier.setLayoutX(firstsourcex+120);
										this.soldier.setLayoutY(firstsourcey-120);
										board[sourcex][sourcey].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);
										board[targetx][targety].setSoldierColor(Soldier_COLOR_AtSquare.WHITE);
										g.getWhitePieces()[i].getLocation().setX(targetx);
			                            g.getWhitePieces()[i].getLocation().setY(targety);

										
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
						//eaten to the up left side
						else if(targety==sourcey-2 && targetx+2==sourcex) {
							System.out.println("else1");
							if(board[sourcex-1][sourcey-1].getSoldierColor()==Soldier_COLOR_AtSquare.BLACK) {
								System.out.println("if2");
								for(int j=0; j<g.getBlackPieces().length; j++) {
									if(g.getBlackPieces()[j].getLocation().getX()== sourcex-1 && g.getBlackPieces()[j].getLocation().getY()== sourcey-1) {
										// remove the soldier
										System.out.println("HEREEEEE");
										g.getBlackPieces()[j].setIsAlive(false);
										g.getBlackPieces()[j].getLocation().setX(-1);
										g.getBlackPieces()[j].getLocation().setY(-1);
										board[sourcex-1][sourcey-1].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);
										int xcsene= (firstsourcex)-60;//nzed 3l func
										System.out.println(xcsene);
								
										int yscene=(firstsourcey)-60;//...
										System.out.println(yscene);
										Circle c=getSoldierOnScene(xcsene,yscene);
										//******
										this.soldier.setLayoutX(xcsene-60);
										this.soldier.setLayoutY(yscene-60);
										board[sourcex][sourcey].setSoldierColor(Soldier_COLOR_AtSquare.EMPTY);
										board[targetx][targety].setSoldierColor(Soldier_COLOR_AtSquare.WHITE);
			                            
			                            g.getWhitePieces()[i].getLocation().setX(targetx);
			                            g.getWhitePieces()[i].getLocation().setY(targety);

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
							}	
							else	
								this.soldier.setVisible(false);	
						}
					}
				}
				endwhite=System.nanoTime();
				long elapsedTime = endwhite - startwhite;
				long convert = TimeUnit.SECONDS.convert(elapsedTime, TimeUnit.NANOSECONDS);
				if(convert>=30)
				{
					//CheckAndDoGreenSquare();
				}
				if(convert >= 90)
				{
					//CheckAndDoOrangeSquare();
				}
				turn = Soldier_COLOR_AtSquare.BLACK;
				TurnLbl.setText("Its the Black turn");
				whitethread.interrupt();
				startBlackTimer();
			}

			this.soldier=null;
			this.target=null;
			//CheckAndDoRedSquare();
			//CheckAndDoBlueSquare();
			return 0;
		}
           
           if(board[targetx][targety].getSquareColor()==SQUARE_COLOR.BLUE) {
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
	}
		return -1;


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
					board[x][y].setSquareColor(SQUARE_COLOR.YELLOW);
					setRectangleToYellow(x,y);

					numofYellowSquares++;
				}
			}
		}


	}

	// this function make red square randomly if there is no option to eat at this turn
	public void CheckAndDoRedSquare() {
		if(turn==Soldier_COLOR_AtSquare.WHITE)
		{
			Player pw= g.getWhitePlayer();

			if(g.IsEatable(pw)==false) {
				for(int i=0; i<g.getWhitePieces().length; i++) {
					// righ side
					if(board[(g.getWhitePieces()[i].getLocation().getX())-1][(g.getWhitePieces()[i].getLocation().getY())+1].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY) {
						System.out.println(1);
						System.out.printf("X:%d Y:%d \n",(g.getWhitePieces()[i].getLocation().getX())-1,(g.getWhitePieces()[i].getLocation().getY())+1);
						Rectangle r= getRectangle((g.getWhitePieces()[i].getLocation().getX())-1,(g.getWhitePieces()[i].getLocation().getY())+1);
						board[(g.getWhitePieces()[i].getLocation().getX())-1][(g.getWhitePieces()[i].getLocation().getY())+1].setSquareColor(SQUARE_COLOR.RED);
						r.setFill(Color.rgb(255,0,0));
						return;
					}

					// left side
					if(board[(g.getWhitePieces()[i].getLocation().getX())-1][(g.getWhitePieces()[i].getLocation().getY())-1].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY) {
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

			if(g.IsEatable(pb)==false) {
				for(int i=0; i<g.getBlackPieces().length; i++) {
					// righ side
					if(board[(g.getBlackPieces()[i].getLocation().getX())+1][(g.getBlackPieces()[i].getLocation().getY())-1].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY) {
						Rectangle r= getRectangle((g.getBlackPieces()[i].getLocation().getX())+1,(g.getBlackPieces()[i].getLocation().getY())-1);
						System.out.println(3);
						board[(g.getWhitePieces()[i].getLocation().getX())+1][(g.getWhitePieces()[i].getLocation().getY())-1].setSquareColor(SQUARE_COLOR.RED);
						r.setFill(Color.rgb(255,0,0));
						return;
					}

					// left side
					if(board[(g.getBlackPieces()[i].getLocation().getX())+1][(g.getBlackPieces()[i].getLocation().getY())+1].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY) {
						Rectangle r= getRectangle((g.getBlackPieces()[i].getLocation().getX())+1,(g.getBlackPieces()[i].getLocation().getY())+1);
						System.out.println(4);
						board[(g.getWhitePieces()[i].getLocation().getX())+1][(g.getWhitePieces()[i].getLocation().getY())+1].setSquareColor(SQUARE_COLOR.RED);
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
				/*public void CheckAndDoGreenSquare() {
					if(turn == Soldier_COLOR_AtSquare.WHITE) {
						for(int i=0; i<g.getWhitePieces().length; i++) {
							if(board[(g.getWhitePieces()[i].getLocation().getX())-1][(g.getWhitePieces()[i].getLocation().getY())-1].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY) {
								//fill green
								Rectangle r= getRectangle((g.getWhitePieces()[i].getLocation().getX())-1,(g.getWhitePieces()[i].getLocation().getY())-1);
								board[(g.getWhitePieces()[i].getLocation().getX())-1][(g.getWhitePieces()[i].getLocation().getY())-1].setSquareColor(SQUARE_COLOR.GREEN);
								r.setFill(Color.rgb(10,160,25));
							}
							if(board[(g.getWhitePieces()[i].getLocation().getX())-1][(g.getWhitePieces()[i].getLocation().getY())+1].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY) {
								//fill green
								Rectangle r= getRectangle((g.getWhitePieces()[i].getLocation().getX())-1,(g.getWhitePieces()[i].getLocation().getY())+1);
								board[(g.getWhitePieces()[i].getLocation().getX())-1][(g.getWhitePieces()[i].getLocation().getY())+1].setSquareColor(SQUARE_COLOR.GREEN);
								r.setFill(Color.rgb(10,160,25));
							}
						}
					}
					if(turn == Soldier_COLOR_AtSquare.BLACK) {
						for(int i=0; i<g.getBlackPieces().length; i++) {
							if(board[(g.getBlackPieces()[i].getLocation().getX())+1][(g.getBlackPieces()[i].getLocation().getY())-1].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY) {
								//fill green
								Rectangle r= getRectangle((g.getBlackPieces()[i].getLocation().getX())+1,(g.getBlackPieces()[i].getLocation().getY())-1);
								board[(g.getBlackPieces()[i].getLocation().getX())+1][(g.getBlackPieces()[i].getLocation().getY())-1].setSquareColor(SQUARE_COLOR.GREEN);
								r.setFill(Color.rgb(10,160,25));
							}
							if(board[(g.getBlackPieces()[i].getLocation().getX())+1][(g.getBlackPieces()[i].getLocation().getY())+1].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY) {
								//fill green
								Rectangle r= getRectangle((g.getBlackPieces()[i].getLocation().getX())+1,(g.getBlackPieces()[i].getLocation().getY())+1);
								board[(g.getBlackPieces()[i].getLocation().getX())+1][(g.getBlackPieces()[i].getLocation().getY())+1].setSquareColor(SQUARE_COLOR.GREEN);
								r.setFill(Color.rgb(10,160,25));
							}
						}
					}
				}
				*/
				
				/*public void CheckAndDoOrangeSquare() {
					if(turn == Soldier_COLOR_AtSquare.WHITE) {
						for(int i=0; i<g.getWhitePieces().length; i++) {
							if(board[(g.getWhitePieces()[i].getLocation().getX())-1][(g.getWhitePieces()[i].getLocation().getY())-1].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY) {
								//Checks if the left up square is empty, if yes fill it green
								Rectangle r= getRectangle((g.getWhitePieces()[i].getLocation().getX())-1,(g.getWhitePieces()[i].getLocation().getY())-1);
								board[(g.getWhitePieces()[i].getLocation().getX())-1][(g.getWhitePieces()[i].getLocation().getY())-1].setSquareColor(SQUARE_COLOR.GREEN);
								r.setFill(Color.rgb(220,110,15));
							}
							if(board[(g.getWhitePieces()[i].getLocation().getX())-1][(g.getWhitePieces()[i].getLocation().getY())+1].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY) {
								//Chceks if the right up square is empty, if yes fill it green
								Rectangle r= getRectangle((g.getWhitePieces()[i].getLocation().getX())-1,(g.getWhitePieces()[i].getLocation().getY())+1);
								board[(g.getWhitePieces()[i].getLocation().getX())-1][(g.getWhitePieces()[i].getLocation().getY())+1].setSquareColor(SQUARE_COLOR.GREEN);
								r.setFill(Color.rgb(220,110,15));
							}
						}
					}
					if(turn == Soldier_COLOR_AtSquare.BLACK) {
						for(int i=0; i<g.getBlackPieces().length; i++) {
							if(board[(g.getBlackPieces()[i].getLocation().getX())+1][(g.getBlackPieces()[i].getLocation().getY())-1].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY) {
								//Checks if the left down square is empty, if yes fill it orange
								Rectangle r= getRectangle((g.getBlackPieces()[i].getLocation().getX())+1,(g.getBlackPieces()[i].getLocation().getY())-1);
								board[(g.getBlackPieces()[i].getLocation().getX())+1][(g.getBlackPieces()[i].getLocation().getY())-1].setSquareColor(SQUARE_COLOR.ORANGE);
								r.setFill(Color.rgb(220,110,15));
							}
							if(board[(g.getBlackPieces()[i].getLocation().getX())+1][(g.getBlackPieces()[i].getLocation().getY())+1].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY) {
								//Checks if the left down square is empty, if yes fill it orange
								Rectangle r= getRectangle((g.getBlackPieces()[i].getLocation().getX())+1,(g.getBlackPieces()[i].getLocation().getY())+1);
								board[(g.getBlackPieces()[i].getLocation().getX())+1][(g.getBlackPieces()[i].getLocation().getY())+1].setSquareColor(SQUARE_COLOR.ORANGE);
								r.setFill(Color.rgb(220,110,15));
							}
						}
					}
				}
				*/


	// this function take the square coordinates: 0<=x<8 & 0<=x<8
	//this function returns a rectangle r in the scene-builder that appropriate to the coordinates x and y 
	public Rectangle getRectangle(int x, int y) {

		int xviewscene=y*60;//checks the function	
		int yviewscene=	x*60;//checks the function

		if(xviewscene==60 && yviewscene==0) {
			return s0;
		}
		if(xviewscene==180 && yviewscene==0) {
			return s1;
		}
		if(xviewscene==300 && yviewscene==0) {
			return s2;
		}
		if(xviewscene==420 && yviewscene==0) {
			return s3;
		}
		if(xviewscene==0 && yviewscene==60) {
			return s4;
		}
		if(xviewscene==120 && yviewscene==60) {
			return s5;
		}
		if(xviewscene==240 && yviewscene==60) {
			return s6;
		}
		if(xviewscene==360 && yviewscene==60) {
			return s7;
		}
		if(xviewscene==60 && yviewscene==120) {
			return s8;
		}
		if(xviewscene==180 && yviewscene==120) {
			return s9;
		}
		if(xviewscene==300 && yviewscene==120) {
			return s10;
		}
		if(xviewscene==420 && yviewscene==120) {
			return s11;
		}
		if(xviewscene==0 && yviewscene==180) {
			return s12;
		}
		if(xviewscene==120 && yviewscene==180) {
			return s13;
		}
		if(xviewscene==240 && yviewscene==180) {
			return s14;
		}
		if(xviewscene==360 && yviewscene==180) {
			return s15;
		}
		if(xviewscene==60 && yviewscene==240) {
			return s16;
		}
		if(xviewscene==180 && yviewscene==240) {
			return s17;
		}
		if(xviewscene==300 && yviewscene==240) {
			return s18;
		}
		if(xviewscene==420 && yviewscene==240) {
			return s19;
		}
		if(xviewscene==0 && yviewscene==300) {
			return s20;
		}
		if(xviewscene==120 && yviewscene==300) {
			return s21;
		}
		if(xviewscene==240 && yviewscene==300) {
			return s22;
		}
		if(xviewscene==360 && yviewscene==300) {
			return s23;
		}
		if(xviewscene==60 && yviewscene==360) {
			return s24;
		}
		if(xviewscene==180 && yviewscene==360) {
			return s25;
		}
		if(xviewscene==300 && yviewscene==360) {
			return s26;
		}
		if(xviewscene==420 && yviewscene==360) {
			return s27;
		}
		if(xviewscene==0 && yviewscene==420) {
			return s28;
		}
		if(xviewscene==120 && yviewscene==420) {
			return s29;
		}
		if(xviewscene==240 && yviewscene==420) {
			return s30;
		}
		if(xviewscene==360 && yviewscene==420) {
			return s31;
		}


		return null;

	}



	public void setRectangleToYellow(int x, int y) {
		int xviewscene=x*60;//checks the function	
		int yviewscene=	y*60;//checks the function

		if(xviewscene==60 && yviewscene==0) {
			s0.setFill(Color.rgb(255,255,0));
			return;
		}
		if(xviewscene==180 && yviewscene==0) {
			s1.setFill(Color.rgb(255,255,0));
			return;
		}
		if(xviewscene==300 && yviewscene==0) {
			s2.setFill(Color.rgb(255,255,0));
			return;
		}
		if(xviewscene==420 && yviewscene==0) {
			s3.setFill(Color.rgb(255,255,0));
			return;
		}
		if(xviewscene==0 && yviewscene==60) {
			s4.setFill(Color.rgb(255,255,0));
			return;
		}
		if(xviewscene==120 && yviewscene==60) {
			s5.setFill(Color.rgb(255,255,0));
			return;
		}
		if(xviewscene==240 && yviewscene==60) {
			s6.setFill(Color.rgb(255,255,0));
			return;
		}
		if(xviewscene==360 && yviewscene==60) {
			s7.setFill(Color.rgb(255,255,0));
			return;
		}
		if(xviewscene==60 && yviewscene==120) {
			s8.setFill(Color.rgb(255,255,0));
			return;
		}
		if(xviewscene==180 && yviewscene==120) {
			s9.setFill(Color.rgb(255,255,0));
			return;
		}
		if(xviewscene==300 && yviewscene==120) {
			s10.setFill(Color.rgb(255,255,0));
			return;
		}
		if(xviewscene==420 && yviewscene==120) {
			s11.setFill(Color.rgb(255,255,0));
			return;
		}
		if(xviewscene==0 && yviewscene==180) {
			s12.setFill(Color.rgb(255,255,0));
			return;
		}
		if(xviewscene==120 && yviewscene==180) {
			s13.setFill(Color.rgb(255,255,0));
			return;
		}
		if(xviewscene==240 && yviewscene==180) {
			s14.setFill(Color.rgb(255,255,0));
			return;
		}
		if(xviewscene==360 && yviewscene==180) {
			s15.setFill(Color.rgb(255,255,0));
			return;
		}
		if(xviewscene==60 && yviewscene==240) {
			s16.setFill(Color.rgb(255,255,0));
			return;
		}
		if(xviewscene==180 && yviewscene==240) {
			s17.setFill(Color.rgb(255,255,0));
			return;
		}
		if(xviewscene==300 && yviewscene==240) {
			s18.setFill(Color.rgb(255,255,0));
			return;
		}
		if(xviewscene==420 && yviewscene==240) {
			s19.setFill(Color.rgb(255,255,0));
			return;
		}
		if(xviewscene==0 && yviewscene==300) {
			s20.setFill(Color.rgb(255,255,0));
			return;
		}
		if(xviewscene==120 && yviewscene==300) {
			s21.setFill(Color.rgb(255,255,0));
			return;
		}
		if(xviewscene==240 && yviewscene==300) {
			s22.setFill(Color.rgb(255,255,0));
			return;
		}
		if(xviewscene==360 && yviewscene==300) {
			s23.setFill(Color.rgb(255,255,0));
			return;
		}
		if(xviewscene==60 && yviewscene==360) {
			s24.setFill(Color.rgb(255,255,0));
			return;
		}
		if(xviewscene==180 && yviewscene==360) {
			s25.setFill(Color.rgb(255,255,0));
			return;
		}
		if(xviewscene==300 && yviewscene==360) {
			s26.setFill(Color.rgb(255,255,0));
			return;
		}
		if(xviewscene==420 && yviewscene==360) {
			s27.setFill(Color.rgb(255,255,0));
			return;
		}
		if(xviewscene==0 && yviewscene==420) {
			s28.setFill(Color.rgb(255,255,0));
			return;
		}
		if(xviewscene==120 && yviewscene==420) {
			s29.setFill(Color.rgb(255,255,0));
			return;
		}
		if(xviewscene==240 && yviewscene==420) {
			s30.setFill(Color.rgb(255,255,0));
			return;
		}
		if(xviewscene==360 && yviewscene==420) {
			s31.setFill(Color.rgb(255,255,0));
			return;
		}


		return;

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
	
	public DigitTimerGroup startWhiteTimer() 
	{
		whitetime=new DigitTimerGroup(WhiteTimer);
		whitethread = new TimerThread(whitetime);
		whitethread.setDaemon(true);
		whitethread.start();
		return (DigitTimerGroup) whitetime;
	}
	
	public void startBlackTimer() 
	{
		blacktime=new DigitTimerGroup(BlackTimer);
		blackthread = new TimerThread(blacktime);
		blackthread.setDaemon(true);
		blackthread.start();
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
		System.out.println(c.getLayoutX() +"//"+ c.getLayoutY());	
		return c;	
	}

}