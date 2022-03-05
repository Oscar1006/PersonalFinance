package application;
	
import java.io.IOException;

import controller.AddController;
import controller.PrincipalController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import model.PersonalFinance;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;


public class Main extends Application {
	
	public static final String ICON_IMG = "file:../../images/icon.png";
	
	private Parent root;
	//private Stage currentStage;
	private Stage newStage;
	private Scene scene;
	private FXMLLoader loader;
	
	private PersonalFinance myFinance = new PersonalFinance();
	

	@Override
	public void start(Stage primaryStage) {
		
		PrincipalController principal;
		try {
			loader = new FXMLLoader(getClass().getResource("../ui/Principal.fxml"));
			
			root = loader.load();
			principal = loader.getController();
			principal.setMain(this);
			principal.initializeData();
			
			scene = new Scene(root);
			
			newStage = new Stage();
			newStage.setTitle("Finanzas personales");
			newStage.getIcons().add(new Image(ICON_IMG));
			newStage.setScene(scene);
			newStage.show();
			//currentStage = newStage;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void showAddModule() {
		AddController controller = new AddController();
		try {
			loader = new FXMLLoader(getClass().getResource("../ui/Add.fxml"));
			
			root = loader.load();
			controller = loader.getController();
			
			controller.setMain(this);
			//controller.intializeData();
			
			
			scene = new Scene(root);
			
			newStage = new Stage();
			newStage.setTitle("Añadir ingreso u gasto");
			newStage.getIcons().add(new Image(ICON_IMG));
			newStage.setScene(scene);
			newStage.show();
			//currentStage = newStage;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public PersonalFinance getFinance() {
		return myFinance;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
