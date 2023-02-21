import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class ShowCircle extends Application
{
	@Override
	public void start(Stage primaryStage)
	{
		//create a circle
		Circle circle = new Circle();	//create the circle object
		circle.setCenterX(100);			//set the horizontal center to 100
		circle.setCenterY(100);			//set the vertical center to 100
		circle.setRadius(50);			//set the radius to 50px
		circle.setStroke(Color.BLACK);	//set the edge color to black
		circle.setFill(Color.WHITE);	//set the fill color to white
		
		Rectangle rectSample = new Rectangle();
		rectSample.setX(0);
		rectSample.setY(0);
		rectSample.setWidth(1280);
		rectSample.setHeight(800);
		rectSample.setFill(Color.DARKSEAGREEN);
		
		//create a pane to hold the circle
		Pane pane = new Pane();
		pane.getChildren().add(rectSample);
		
		//Create a scene and place the pane in the stage
		Scene scene = new Scene(pane, 1280, 800);
		primaryStage.setTitle("ShowCircle"); //set stage title
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

	public static void main(String[] args) 
	{
		Application.launch(args);
	}

}
