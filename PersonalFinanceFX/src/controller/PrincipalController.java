package controller;

import java.time.LocalDate;
import java.util.GregorianCalendar;
import java.util.List;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.Expense;
import model.Income;

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
	private TableView<Income> tvIncome;

	@FXML
	private TableColumn<Income, String> tcIncome;

	@FXML
	private TableView<Expense> tvExpenses;

	@FXML
	private TableColumn<Expense, String> tcExpenses;

	@FXML
	private void initialize() {

		// Table view
		tvIncome.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		tvExpenses.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		
		tcIncome.setCellValueFactory(new PropertyValueFactory<>("amount"));
		tcExpenses.setCellValueFactory(new PropertyValueFactory<>("amount"));
		
		

	}

	public void initializeData() {
		ObservableList<Income> in = FXCollections.observableArrayList(main.getFinance().getIncome());
		tvIncome.setItems(in);
		ObservableList<Expense> out = FXCollections.observableArrayList(main.getFinance().getExpenses());
		tvExpenses.setItems(out);

		labelBalance.setText(String.valueOf(main.getFinance().getBalance()));
	}

	@FXML
	public void filter() {
		if (rbtnFilter.isSelected()) {
			dpSince.setDisable(false);
			dpUntil.setDisable(false);
		} else {
			
			dpSince.setDisable(true);
			dpUntil.setDisable(true);
		}
		
		if (dpSince.getValue() != null && dpUntil.getValue() != null) {
			String newBalance = "";
			LocalDate ldSince = dpSince.getValue();
			GregorianCalendar gcSince = new GregorianCalendar(ldSince.getYear(), ldSince.getMonthValue(),
					ldSince.getDayOfMonth());
			LocalDate ldUntil = dpUntil.getValue();
			GregorianCalendar gcUntil = new GregorianCalendar(ldUntil.getYear(), ldUntil.getMonthValue(),
					ldUntil.getDayOfMonth());

			ObservableList<Income> in = FXCollections.observableArrayList(main.getFinance().getIncome(gcSince, gcUntil));
			tvIncome.setItems(in);

			ObservableList<Expense> out = FXCollections.observableArrayList(main.getFinance().getExpense(gcSince, gcUntil));
			tvExpenses.setItems(out);

			newBalance = String.valueOf(main.getFinance().getBalance(gcSince, gcUntil));
			labelBalance.setText(newBalance);
		}
		
		if (!rbtnFilter.isSelected()) {
			initializeData();
		}

	}

	@FXML
	public void add() {
		main.showAddModule();
	}
	@FXML
	public void update() {
		initializeData();

	}

	@FXML
	public void delete() {
		Alert alert = new Alert(AlertType.ERROR);
		if(tvIncome.getSelectionModel().getSelectedItems().isEmpty() && tvExpenses.getSelectionModel().getSelectedItems().isEmpty()) {
			alert.setTitle("Error");
			Stage stage =(Stage)alert.getDialogPane().getScene().getWindow();
			stage.getIcons().add(new Image(Main.ICON_IMG));
			alert.setContentText("Por favor seleccione lo que desea eliminar");
			alert.showAndWait();	
		}else {
			List<Income> incomeToDelete = tvIncome.getSelectionModel().getSelectedItems();
			main.getFinance().deleteIncome(incomeToDelete);
			List<Expense> expensesToDelete = tvExpenses.getSelectionModel().getSelectedItems();
			main.getFinance().deleteExpense(expensesToDelete);
			initializeData();
		}
	}

}
