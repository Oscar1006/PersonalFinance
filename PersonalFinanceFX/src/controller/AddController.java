package controller;

import java.time.LocalDate;

import application.Main;
import javafx.fxml.FXML;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyEvent;
import javafx.util.Callback;

public class AddController {

	Main main;

	public void setMain(Main main) {
		this.main = main;
	}

	@FXML
	private DatePicker dpDate;

	@FXML
	private RadioButton rbExpense;

	@FXML
	private RadioButton rbIncome;

	private ToggleGroup toggleIN_EX;

	@FXML
	private TextField txtAmount;

	@FXML
	private TextField txtDescription;

	@FXML
	public void initialize() {
		// Toggle income and expense buttons
		toggleIN_EX = new ToggleGroup();
		rbIncome.setToggleGroup(toggleIN_EX);
		rbExpense.setToggleGroup(toggleIN_EX);
		rbIncome.setSelected(true);
		
		// Date picker
		Callback<DatePicker, DateCell> dayCellFactory = dp -> new DateCell() {
			@Override
			public void updateItem(LocalDate item, boolean empty) {
				super.updateItem(item, empty);
				this.setDisable(false);

				// Disable past days
				if (item.isAfter(LocalDate.now())) {
					this.setDisable(true);
				}
			}
		};
		dpDate.setDayCellFactory(dayCellFactory);

	}
	
	@FXML
	public void onlyNumbers(KeyEvent event) {
		char c = event.getCharacter().charAt(0);
		if(!Character.isDigit(c)) {
			event.consume();
		}
	}

	@FXML
	public void addElement() {

	}

}
