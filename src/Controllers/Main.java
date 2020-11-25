package Controllers;
	
import Model.Question;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root=FXMLLoader.load(getClass().getResource("/view/MainBoardScreen.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setTitle("Home Page");
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			for(Question q:Sysdata.getInstance().getQuestionsarr())
			{
				System.out.println("hi");

				System.out.println(q);
			}
				
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
