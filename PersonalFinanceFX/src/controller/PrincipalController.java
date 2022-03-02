package controller;

import application.Main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableView;


public class PrincipalController {

	Main main;
	
	public void setMain(Main main) {
		this.main = main;
		
	}
	 @FXML
	    private DatePicker dpSince;

	    @FXML
	    private DatePicker dpUntil;

	    @FXML
	    private Label labelBalance;

	    @FXML
	    private RadioButton rbtnFilter;

	    @FXML
	    private TableView<?> tvFinance;

	    @FXML
	    void add(ActionEvent event) {

	    }

	    @FXML
	    void delete(ActionEvent event) {

	    }

	    @FXML
	    void filter(ActionEvent event) {

	    }

}
