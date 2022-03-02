package application;
	
import java.io.IOException;

//import controller.PrincipalController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;


public class Main extends Application {
	
	private Parent root;
	//private Stage currentStage;
	private Stage newStage;
	private Scene scene;
	private FXMLLoader loader;
	
	
	@Override
	public void start(Stage primaryStage) {
		//PrincipalController principal = new PrincipalController();
		try {
			loader = new FXMLLoader(getClass().getResource("../ui/Principal.fxml"));
			
			root = loader.load();
			//principal = loader.getController();
			//principal.setMain(this);
			//principal.intializeData();
			
			
			scene = new Scene(root);
			
			newStage = new Stage();
			newStage.getIcons().add(new Image("file:../../images/icon.png"));
			newStage.setScene(scene);
			newStage.show();
			//currentStage = newStage;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
