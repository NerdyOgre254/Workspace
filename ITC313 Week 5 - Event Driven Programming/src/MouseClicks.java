import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;


public class MouseClicks extends Application
{
    private Scene scene;
    private Pane pane;
    
    @Override
    public void start(Stage primaryStage)
    {
        primaryStage.setTitle("Mouse Clicker");
        
        pane = new Pane();
        scene = new Scene(pane, 300, 300);
        scene.setFill(Color.WHITE);
        
        scene.setOnMouseClicked(new MouseClickHandler());;
        
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    class MouseClickHandler implements EventHandler<MouseEvent>
    {
        @Override
        public void handle(MouseEvent m)
        {
            double x = m.getX();
            double y = m.getY();
            
            Circle circle = new Circle(x, y, 10);
            circle.setStroke(Color.DEEPPINK);
            circle.setFill(Color.TRANSPARENT);
            pane.getChildren().add(circle);
        }
    }
    
    public static void main(String[] args) {
        Application.launch(args);
    }
}
