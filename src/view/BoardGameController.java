package view;

import java.net.URL;

import java.sql.Time;
import java.util.Date;
import java.util.Random;
import java.util.ResourceBundle;
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

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import utils.SQUARE_COLOR;
import utils.Soldier_COLOR_AtSquare;

public class BoardGameController implements Initializable{
	private Square[][] board;
    private static final String Yellow = null;
	private int numofYellowSquares=0;
    public Game g;
    //soldier that has choosen to be moved
    private Circle soldier=null;
    // target square the soldier want to turn to
    private Rectangle target=null;
    //this Pane is the CurrentRowPane: help us at the CheckAndDoYellow methods
    private Pane rowPane=null;

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
    private Pane BoardPane = new Pane();

    @FXML
    private Pane Pane0= new Pane();
    @FXML
    private Pane Pane1= new Pane();
    @FXML
    private Pane Pane2= new Pane();
    @FXML
    private Pane Pane3= new Pane();
    @FXML
    private Pane Pane4= new Pane();
    @FXML
    private Pane Pane5= new Pane();
    @FXML
    private Pane Pane6= new Pane();
    @FXML
    private Pane Pane7= new Pane();

    @FXML
    void MoveToSquare(MouseEvent event) {
    	
    	this.target=(Rectangle) event.getTarget();
    	MoveSoldierToTarget();
    }
    
    @FXML
    void MoveSoldier(MouseEvent event) {
    	this.soldier=(Circle) event.getTarget();

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
    private int TransForRowNum(int x) {
    	int rowNum=0;
		while(x>=49) {
			x=x-49;
			rowNum++;
		}
		return rowNum;
	}
    
    private int TransForColNum(int y) {
    	int colNum=0;

		while(y>=57) {
			y=y-57;
			colNum++;
		}
		return colNum;
	}
    
    private int TransForColNumForSoldier(int y) {
    	int colNum=0;
    	if(y==28)
    		return 0;
    	else {
    		while(y>=57) {
    			y=y-57;
    			colNum++;
 
    		}
	}
		return colNum;
    }
    
    private int MoveSoldierToTarget() {
    	if(soldier!=null && target!=null) {
    	//turns the soldier cordenaties to: 0<x<7 & 0<y<7
       	double soldierXSquare=soldier.getParent().getLayoutY();
    	int sourcex=TransForRowNum((int)soldierXSquare);
    	System.out.println(sourcex);

    	double soldierYSquare=soldier.getLayoutX();
    	int sourcey=TransForColNumForSoldier((int)soldierYSquare);
    	System.out.println(sourcey);
    	
    	
    	//turns the square target cordenaties to: 0<x<7 & 0<y<7
    	System.out.println(target.getLayoutX());
    	int targety=TransForColNum((int) target.getLayoutX());
		System.out.printf("the col num is:%d\n",targety);

    	double oldRow = target.getParent().getLayoutY();
    	System.out.println(oldRow);
    	int targetx=TransForRowNum((int)oldRow);
		System.out.printf("the row num is:%d\n",targetx);
		//moving the black soldier to target square
		if(this.board[sourcex][sourcey].getSoldierColor() == Soldier_COLOR_AtSquare.BLACK) {
			for(int i=0; i<g.getBlackPieces().length; i++) {
				if(g.getBlackPieces()[i].getLocation().getX()== sourcex && g.getBlackPieces()[i].getLocation().getY()== sourcey) {
				int isOk =(g.getBlackPieces()[i]).moveBlackSoldier( sourcex, sourcey, targetx,targety,board);
				if(isOk==0) {
					// turns the number of the x array to layoutY(the row that the soldier want to go to.
					//double targetXInView=TurnstheX(targetx);
					//double targetYInView=TurnstheY(targety);
					double targetYInView=28;
					this.soldier.setLayoutX(targetYInView);
					System.out.printf("y:%f\n",targetYInView);
					//changing the row num--> changing the parent

					
										
				}
				}
			}
			
		}
		
		
		this.soldier=null;
		this.target=null;
		return 0;
    	}
    	
    	return -1;
   
    	
    }
	
 // this function turn the y from : 0<x<7 to: 0<colNumInView<399
    private double TurnstheY(int targety) {
    	int colNum=0;
    		while(targety>0) {
    			colNum=colNum+57;
    			targety--;

    		}

    	return colNum;
    	}
// this function turn the x from : 0<x<7 to: 0<rowNumInView<343
private double TurnstheX(int targetx) {
	int colNum=0;
		while(targetx>0) {
			colNum=colNum+49;
			targetx--;

		}

	return colNum;
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
			this.board=g.getBoard();
//			for(int r=0; r<8;r++) {
//				for(int c=0; c<8;c++) {
//					//the board is null!!!
//					System.out.println(board[r][c].toString());
//
//				}
//			}
			
			//CheckAndDoYellowSquares();
			

		}
		
	}
	
	
	// this function checks if the number of the yellow squares is less than 3, if it is so it add one yellow squares
	public void CheckAndDoYellowSquares() {
		while(numofYellowSquares<3) {
			Random rand = new Random();
			int x = rand.nextInt(8); 
	        int y = rand.nextInt(8);
	        Rectangle r=null;
	        
	        if(g.getBoard()[x][y].getSoldierColor()==Soldier_COLOR_AtSquare.EMPTY ) {
	         g.getBoard()[x][y].setSquareColor(SQUARE_COLOR.YELLOW);
	        int xviewscene=x*49;//cheks the func	
	        int yviewscene=	y*57;//cheks the func
	        
	        
	        
	        if(xviewscene==0) {
	        	this.rowPane=this.Pane0;
		        // the square at the rowPane
	 	       
	 	       if(r.getLayoutX()==0) {
		 	       r = ((Rectangle) this.rowPane.getChildren());
	 	    	   s0.setFill(Color.rgb(255,255,0));
	 		        numofYellowSquares++;  
	 	       }
	 	       else if(r.getLayoutX()==171) {
		 	       r = ((Rectangle) this.rowPane.getChildren());
	 	    	   s1.setFill(Color.rgb(255,255,0));
	 		        numofYellowSquares++;  
	 	       }
	 	      else if(r.getLayoutX()==285) {
	 	    	 r = ((Rectangle) this.rowPane.getChildren());
	 	    	   s2.setFill(Color.rgb(255,255,0));
	 		        numofYellowSquares++;  
	 	       }
	 	     else if(r.getLayoutX()==399) {
	 	    	r = ((Rectangle) this.rowPane.getChildren());
	 	    	   s3.setFill(Color.rgb(255,255,0));
	 		        numofYellowSquares++;  
	 	       }
 
	        }
	        if(xviewscene==49) {
	        	this.rowPane=this.Pane1;
	        			 	       
		 	       if(r.getLayoutX()==0) {
		 	    	  r = ((Rectangle) this.rowPane.getChildren());
		 	    	   s4.setFill(Color.rgb(255,255,0));
		 		        numofYellowSquares++;  
		 	       }
		 	       else if(r.getLayoutX()==114) {
		 	    	  r = ((Rectangle) this.rowPane.getChildren());
		 	    	   s5.setFill(Color.rgb(255,255,0));
		 		        numofYellowSquares++;  
		 	       }
		 	      else if(r.getLayoutX()==228) {
		 	    	 r = ((Rectangle) this.rowPane.getChildren());
		 	    	   s6.setFill(Color.rgb(255,255,0));
		 		        numofYellowSquares++;  
		 	       }
		 	     else if(r.getLayoutX()==342) {
		 	    	r = ((Rectangle) this.rowPane.getChildren());
		 	    	   s7.setFill(Color.rgb(255,255,0));
		 		        numofYellowSquares++;  
		 	       }
	 
	        }
	        if(xviewscene==98) {
	        	this.rowPane=this.Pane2;
	    		       
	     	 	       if(yviewscene==0) {
	     	 	    	 // the square at the rowPane
	     	 	    	 r = ((Rectangle) this.rowPane.getChildren());
	     	 	    	   s8.setFill(Color.rgb(255,255,0));
	     	 		        numofYellowSquares++;  
	     	 	       }
	     	 	       else if(yviewscene==171) {
	     	 	    	 r = ((Rectangle) this.rowPane.getChildren());
	     	 	    	   s9.setFill(Color.rgb(255,255,0));
	     	 		        numofYellowSquares++;  
	     	 	       }
	     	 	      else if(yviewscene==285) {
	     	 	    	r = ((Rectangle) this.rowPane.getChildren());
	     	 	    	   s10.setFill(Color.rgb(255,255,0));
	     	 		        numofYellowSquares++;  
	     	 	       }
	     	 	     else if(yviewscene==399) {
	     	 	    	r = ((Rectangle) this.rowPane.getChildren());
	     	 	    	   s11.setFill(Color.rgb(255,255,0));
	     	 		        numofYellowSquares++;  
	     	 	       }
	        }
	        if(xviewscene==147) {
	        	this.rowPane=this.Pane3;
	        			 	       
	   		 	       if(yviewscene==0) {
	   		 	    	r = ((Rectangle) this.rowPane.getChildren());
	   		 	    	   s12.setFill(Color.rgb(255,255,0));
	   		 		        numofYellowSquares++;  
	   		 	       }
	   		 	       else if(yviewscene==114) {
	   		 	    	r = ((Rectangle) this.rowPane.getChildren());
	   		 	    	   s13.setFill(Color.rgb(255,255,0));
	   		 		        numofYellowSquares++;  
	   		 	       }
	   		 	      else if(yviewscene==228) {
	   		 	    	r = ((Rectangle) this.rowPane.getChildren());
	   		 	    	   s14.setFill(Color.rgb(255,255,0));
	   		 		        numofYellowSquares++;  
	   		 	       }
	   		 	     else if(yviewscene==342) {
	   		 	    	r = ((Rectangle) this.rowPane.getChildren());
	   		 	    	   s15.setFill(Color.rgb(255,255,0));
	   		 		        numofYellowSquares++;  
	   		 	       }
	        }
	        if(xviewscene==196) {
	        	
	        	this.rowPane=this.Pane4;
		        // the square at the rowPane
  	 	       
  	 	       if(yviewscene==0) {
  	 	    	r = ((Rectangle) this.rowPane.getChildren());
  	 	    	   s16.setFill(Color.rgb(255,255,0));
  	 		        numofYellowSquares++;  
  	 	       }
  	 	       else if(yviewscene==171) {
  	 	    	r = ((Rectangle) this.rowPane.getChildren());
  	 	    	   s17.setFill(Color.rgb(255,255,0));
  	 		        numofYellowSquares++;  
  	 	       }
  	 	      else if(yviewscene==285) {
  	 	    	r = ((Rectangle) this.rowPane.getChildren());
  	 	    	   s18.setFill(Color.rgb(255,255,0));
  	 		        numofYellowSquares++;  
  	 	       }
  	 	     else if(yviewscene==399) {
  	 	    	r = ((Rectangle) this.rowPane.getChildren());
  	 	    	   s19.setFill(Color.rgb(255,255,0));
  	 		        numofYellowSquares++;  
  	 	       }
	        }
	        if(xviewscene==245) {
	        	r = ((Rectangle) this.rowPane.getChildren());
	        	this.rowPane=this.Pane5;
		 	       
 		 	       if(yviewscene==0) {
 		 	    	 r = ((Rectangle) this.rowPane.getChildren());
 		 	    	   s20.setFill(Color.rgb(255,255,0));
 		 		        numofYellowSquares++;  
 		 	       }
 		 	       else if(yviewscene==114) {
 		 	    	 r = ((Rectangle) this.rowPane.getChildren());
 		 	    	   s21.setFill(Color.rgb(255,255,0));
 		 		        numofYellowSquares++;  
 		 	       }
 		 	      else if(yviewscene==228) {
 		 	    	r = ((Rectangle) this.rowPane.getChildren());
 		 	    	   s22.setFill(Color.rgb(255,255,0));
 		 		        numofYellowSquares++;  
 		 	       }
 		 	     else if(yviewscene==342) {
 		 	    	r = ((Rectangle) this.rowPane.getChildren());
 		 	    	   s23.setFill(Color.rgb(255,255,0));
 		 		        numofYellowSquares++;  
 		 	       }
	        }
	        if(xviewscene==294) {
	        	this.rowPane=this.Pane6;
	    		        // the square at the rowPane
		     	 	       
		     	 	       if(yviewscene==0) {
		     	 	    	 r = ((Rectangle) this.rowPane.getChildren());
		     	 	    	   s24.setFill(Color.rgb(255,255,0));
		     	 		        numofYellowSquares++;  
		     	 	       }
		     	 	       else if(yviewscene==171) {
		     	 	    	 r = ((Rectangle) this.rowPane.getChildren());
		     	 	    	   s25.setFill(Color.rgb(255,255,0));
		     	 		        numofYellowSquares++;  
		     	 	       }
		     	 	      else if(yviewscene==285) {
		     	 	    	r = ((Rectangle) this.rowPane.getChildren());
		     	 	    	   s26.setFill(Color.rgb(255,255,0));
		     	 		        numofYellowSquares++;  
		     	 	       }
		     	 	     else if(yviewscene==399) {
		     	 	    	r = ((Rectangle) this.rowPane.getChildren());
		     	 	    	   s27.setFill(Color.rgb(255,255,0));
		     	 		        numofYellowSquares++;  
		     	 	       }
	        }
	        if(xviewscene==343) {
	        	this.rowPane=this.Pane7;
		 	       
 		 	       if(yviewscene==0) {
 		 	    	 r = ((Rectangle) this.rowPane.getChildren());
 		 	    	   s28.setFill(Color.rgb(255,255,0));
 		 		        numofYellowSquares++;  
 		 	       }
 		 	       else if(yviewscene==114) {
 		 	    	 r = ((Rectangle) this.rowPane.getChildren());
 		 	    	   s29.setFill(Color.rgb(255,255,0));
 		 		        numofYellowSquares++;  
 		 	       }
 		 	      else if(yviewscene==228) {
 		 	    	r = ((Rectangle) this.rowPane.getChildren());
 		 	    	   s30.setFill(Color.rgb(255,255,0));
 		 		        numofYellowSquares++;  
 		 	       }
 		 	     else if(yviewscene==342) {
 		 	    	r = ((Rectangle) this.rowPane.getChildren());
 		 	    	   s31.setFill(Color.rgb(255,255,0));
 		 		        numofYellowSquares++;  
 		 	       }
	        }
	        
	        
	        }
			
		}
		
	}
	
	
	



			

	

}