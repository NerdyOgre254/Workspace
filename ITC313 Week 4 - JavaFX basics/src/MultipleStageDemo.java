import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MultipleStageDemo extends Application{

	@Override
	public void start(Stage primaryStage)
	{
		//create a scene and place a button in the scene
		Scene scene = new Scene(new Button("OK"), 1920, 1080);
		primaryStage.setTitle("MyJavaFX");	//set the stage title
		primaryStage.setScene(scene);	//place the scene in the stage
		primaryStage.setResizable(false);	//stop user from resizing
		primaryStage.show();	//display the stage
		
		Stage stage = new Stage();	//create a new stage
		stage.setTitle("Second Stage");	//set the stage title
		//set a scene with a button in the stage
		stage.setScene(new Scene(new Button("new stage"), 1280, 800));
		stage.show();
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}

}
