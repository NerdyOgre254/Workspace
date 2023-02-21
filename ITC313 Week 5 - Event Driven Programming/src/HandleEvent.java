import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class HandleEvent extends Application
{
    @Override   //override the start method in the Application class
    public void start(Stage primaryStage)
    {
        //create a pane and set its properties
        HBox pane = new HBox(10);   //find out what HBox is
        pane.setAlignment(Pos.CENTER);
        Button btOK = new Button("OK");
        Button btCancel = new Button("CANCEL");
        OKHandlerClass handler1 = new OKHandlerClass(); //calling the constructor of an OKHandler Class seen below
        btOK.setOnAction(handler1); //registers the OK button to Handler1
        CancelHandlerClass handler2 = new CancelHandlerClass();
        btCancel.setOnAction(handler2);
        pane.getChildren().addAll(btOK, btCancel);  //adds ok and cancel buttons to pane
        
        //Create a scene and place it on the stage
        Scene scene = new Scene(pane);
        primaryStage.setTitle("HandleEvent");   //set the stage title
        primaryStage.setScene(scene);   //place the scene in the stage
        primaryStage.show();//display the stage
    }

    //launch from console
    public static void main(String[] args) {
        Application.launch(args);
    }

}

class OKHandlerClass implements EventHandler<ActionEvent>
{
    @Override
    public void handle(ActionEvent e)
    {
        System.out.println("OK button clicked");
    }
}

class CancelHandlerClass implements EventHandler<ActionEvent>
{
    @Override
    public void handle(ActionEvent e)
    {
        System.out.println("Cancel button clicked");
    }
}