import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class ControlCircle extends Application 
{
    private CirclePane circlePane = new CirclePane();
    @Override
    public void start(Stage primaryStage)
    {
        //put two buttons in an HBox
        HBox hBox = new HBox();
        hBox.setSpacing(10);
        hBox.setAlignment(Pos.CENTER);
        Button btEnlarge = new Button("Enlarge");
        Button btShrink = new Button("Shrink");
        hBox.getChildren().add(btEnlarge);
        hBox.getChildren().add(btShrink);
        
        //create and register the handler
        btEnlarge.setOnAction(new EnlargeHandler());
        btShrink.setOnAction(new ShrinkHandler());
        
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(circlePane);
        borderPane.setBottom(hBox);
        BorderPane.setAlignment(hBox, Pos.CENTER);
        
        //create a sceene and place it in the stage
        Scene scene = new Scene(borderPane, 200, 150);
        primaryStage.setTitle("ControlCircle");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    class EnlargeHandler implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent e)
        {
            circlePane.enlarge();
        }
    }
    
    class ShrinkHandler implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent e)
        {
            circlePane.shrink();
        }
    }
    
    public static void main(String[] args) {
        Application.launch(args);
    }
}

class CirclePane extends StackPane
{
    private Circle circle = new Circle(50);
    
    public CirclePane()
    {
        getChildren().add(circle);
        circle.setStroke(Color.BLACK);
        circle.setFill(Color.WHITE);
    }
    
    public void enlarge()
    {
        circle.setRadius(circle.getRadius() + 2);        
    }
    
    public void shrink()
    {
        //stops shrinking - wonder why?
        circle.setRadius(circle.getRadius() > 2 ? circle.getRadius() - 2: circle.getRadius());
        //let's take the brakes off
        //circle.setRadius(circle.getRadius() - 2);
        //turns out nothing. Was expecting a crash, but it just can't show a negative radius. still builds up to -500 though
    }
}
