import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;

public class ButtonInPane extends Application
{
	@Override
	public void start(Stage primaryStage)
	{
		//create a scene and place a button in it
		StackPane pane = new StackPane();
		pane.getChildren().add(new Button("OK"));	//add a button as a child of the stackPane
		Scene scene = new Scene(pane, 1280, 800);	//adds the pane to the scene
		primaryStage.setTitle("Button in a pane");	//set the stage title
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}

}
