import javafx.application.Application;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

public class ResizableCircleRectangle extends Application 
{
    //create a circle and rectangle
    private Circle circle = new Circle(60);
    private Rectangle rectangle = new Rectangle(120,120);
    
    private StackPane pane = new StackPane();
    
    @Override
    public void start(Stage primaryStage)
    {
        circle.setFill(Color.GRAY);
        rectangle.setFill(Color.WHITE);
        rectangle.setStroke(Color.BLACK);
        pane.getChildren().addAll(rectangle, circle);
        
        //scne
        Scene scene = new Scene(pane, 140, 140);
        primaryStage.setTitle("Fish");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        pane.widthProperty().addListener(ov -> resize());
        pane.heightProperty().addListener(ov -> resize());
    }
    
    private void resize()
    {
        double length = Math.min(pane.getWidth(), pane.getHeight());
        circle.setRadius(length / 2 - 15);
        rectangle.setWidth(length-30);
        rectangle.setHeight(length -30);
    }
    
    public static void main(String[] args)
    {
        Application.launch(args);
    }

}
