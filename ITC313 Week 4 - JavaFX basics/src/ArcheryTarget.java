import javafx.application.Application;	//allows for overriding of start()
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;


public class ArcheryTarget extends Application
{
	@Override
	public void start(Stage primaryStage)
	{
		double stageWidth = 1280;
		double stageWidthMiddle = stageWidth / 2;
		double stageHeight = 800;
		double stageHeightMiddle = stageHeight / 2;
		double circleScaleFactor = 40;
		
		//create background using Rectangle: width stageWidth, height stageHeight, no rounding, x and y 0
		Rectangle backgroundRectangle = new Rectangle(stageWidth, stageHeight, Color.DARKSEAGREEN);
		
		//create outermost circle: WHITE, 450 radius(9* circleScaleFactor), screen centred, no stroke
		Circle whiteCircle = new Circle(stageWidthMiddle, stageHeightMiddle, 9 * circleScaleFactor, Color.WHITE);
		
		//create next circle: BLACK, 350 radius (7 * circleScaleFactor), screen centred
		Circle blackCircle = new Circle(stageWidthMiddle, stageHeightMiddle, 7 * circleScaleFactor, Color.BLACK);
		
		//create next circle: CYAN, 250 radius, (5 *)
		Circle cyanCircle = new Circle(stageWidthMiddle, stageHeightMiddle, 5 * circleScaleFactor, Color.CYAN);
		
		//create next circle: RED: 150 radius (3*)
		Circle redCircle = new Circle(stageWidthMiddle, stageHeightMiddle, 3 * circleScaleFactor, Color.RED);
		
		//create innermost circle: GOLD: 50 radius (1*)
		Circle goldCircle = new Circle(stageWidthMiddle, stageHeightMiddle, circleScaleFactor, Color.GOLD);
		
		//create a pane to hold all the objects (note order of addition is important)
		Pane archeryTargetPane = new Pane();
		archeryTargetPane.getChildren().add(backgroundRectangle);
		archeryTargetPane.getChildren().add(whiteCircle);
		archeryTargetPane.getChildren().add(blackCircle);
		archeryTargetPane.getChildren().add(cyanCircle);
		archeryTargetPane.getChildren().add(redCircle);
		archeryTargetPane.getChildren().add(goldCircle);
		
		//create the scene and put the pane in it
		Scene archeryTargetScene = new Scene(archeryTargetPane, stageWidth, stageHeight);
		primaryStage.setTitle("Archery Target");
		primaryStage.setResizable(false);
		primaryStage.setScene(archeryTargetScene);
		primaryStage.show();
		
	}

	public static void main(String[] args) 
	{
		Application.launch(args);
	}

}
