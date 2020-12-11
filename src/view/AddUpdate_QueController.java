package view;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import utils.E_Difficulty;

public class AddUpdate_QueController implements Initializable {

    @FXML
    private AnchorPane pane;

    @FXML
    private TextField QueText;

    @FXML
    private TextField Ans1TEXT;

    @FXML
    private RadioButton Ans1RD;

    @FXML
    private TextField Ans4TEXT;

    @FXML
    private TextField Ans3TEXT;

    @FXML
    private TextField Ans2TEXT;

    @FXML
    private RadioButton Ans2RD;

    @FXML
    private RadioButton Ans3RD;

    @FXML
    private RadioButton Ans4RD;

    @FXML
    private Label erorLabel;

    @FXML
    private Button addBtn;

    @FXML
    private ComboBox<E_Difficulty> difficultyCombo;

    @FXML
    void addQuestion(ActionEvent event) {

    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
