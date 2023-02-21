import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class ShowPoints extends Application
{
    private ArrayList<Circle> circleList = new ArrayList<Circle>();
    private static ArrayList<Point> pointList = new ArrayList<Point>();
    private Text pointText = new Text();
    private final double stageWidth = 1280;
    private final double stageHeight = 800;
    private Pane circlePane;
    private StackPane textPane;
    private Rectangle bgRect;
    private VBox paneBox;
    private Scene mainScene;
    private Circle tempCircle;
    
    @Override
    public void start(Stage primaryStage)
    {        
        //initialise all the panes and shapes
        circlePane = new Pane();
        textPane = new StackPane();
        bgRect = new Rectangle(stageWidth, stageHeight, Color.ANTIQUEWHITE);
        pointText.setText("");
        pointText.setFont(Font.font("Arial", 12));
        
        for (int i = 0; i < pointList.size(); i++)
        {
            circleList.add(new Circle(pointList.get(i).getX(), pointList.get(i).getY(), 5));    
        }
        //make all the circles the same color and fill
        for (int i = 0; i < circleList.size(); i++)
        {
            circleList.get(i).setStroke(Color.BLUE);
            circleList.get(i).setFill(Color.BLUE);
        }
        //put all elements in their respective spots
        circlePane.getChildren().add(bgRect);
        circlePane.getChildren().addAll(circleList);
        textPane.getChildren().add(pointText);
        
        //group them in a vBox
        paneBox = new VBox(circlePane, textPane);
        
        //continual sweep for all circles and their mouse interactions
        for (int i = 0; i < circleList.size(); i++)
        {
            circleList.get(i).setOnMouseEntered(new MouseEnterHandler());
            circleList.get(i).setOnMouseExited(new MouseExitHandler());
            circleList.get(i).setOnMousePressed(new MousePressHandler());
            circleList.get(i).setOnMouseReleased(new MouseReleaseHandler());
        }
        
        //main display section
        mainScene = new Scene(paneBox, stageWidth, stageHeight);
        primaryStage.setTitle("Show Points");
        primaryStage.setResizable(false);
        primaryStage.setScene(mainScene);
        primaryStage.show();
    }
    
    //Handler section
    //MousePress grabs the circle user clicks on and moves its data to a non-displayed Circle for temp storage
    class MousePressHandler implements EventHandler<MouseEvent>
    {
        @Override
        public void handle(MouseEvent m)
        {
            //grab mouse location for point2d comparison
            double x = m.getX();
            double y = m.getY();
            for (int i = 0; i < circleList.size(); i++)
            {
                if (circleList.get(i).contains(new Point2D(x, y)))
                {
                    tempCircle = new Circle(circleList.get(i).getCenterX(), circleList.get(i).getCenterY(), circleList.get(i).getRadius());
                }
            }
        }
    }
    
    //MouseRelease grabs the mouse location, then looks through CircleList for the one that matches Temp and replaces its X/Y info with the mouse X/Y
    class MouseReleaseHandler implements EventHandler<MouseEvent>
    {
        @Override
        public void handle(MouseEvent m)
        {
            
            double x = m.getX();
            double y = m.getY();
            for (int i = 0; i < circleList.size(); i++)
            {
                //if the temp circle matches the current index circle, then replace it
                if (tempCircle.getCenterX() == circleList.get(i).getCenterX() && tempCircle.getCenterY() == circleList.get(i).getCenterY())
                {
                    circleList.get(i).setCenterX(x);
                    circleList.get(i).setCenterY(y);
                }
            }
            
        }
    }
    
    //MouseEnter looks for the circle you're in, then hands off the centerX/Y data to pointText
    class MouseEnterHandler implements EventHandler<MouseEvent>
    {
        @Override
        public void handle(MouseEvent m)
        {
            StringBuilder sb = new StringBuilder();
            double x = m.getX();
            double y = m.getY();
            for (int i = 0; i < circleList.size(); i++)
            {
                if (circleList.get(i).contains(new Point2D(x, y)))
                {
                    sb.append("x=" + circleList.get(i).getCenterX() + " y=" + circleList.get(i).getCenterY());
                    pointText.setText(sb.toString());
                }
            }
            
            
        }
    }
    
    //MouseExit clears PointText
    class MouseExitHandler implements EventHandler<MouseEvent>
    {
        @Override
        public void handle(MouseEvent m)
        {
            pointText.setText("");
        }
    }
    
    //Main grabs the program argument and launches
    public static void main(String[] args) 
    {        
        pointList = getPointsFromFile(args[0]);
        Application.launch(args);
    }
    
    //Gets points from file and makes them an Array
    public static ArrayList<Point> getPointsFromFile(String filename)
    {
        ArrayList<Point> returnList = new ArrayList<Point>();
        File targetFile = new File(filename);
        try
        {
            Scanner pointScan = new Scanner(targetFile);
            while(pointScan.hasNext()) 
            {
                //get the x and get the value substring, chopping off the "X=" part and the semicolon
                String nextX = pointScan.next();
                String tempX = nextX.substring(2, nextX.length()-1);
                //get the y and get the value substring, chopping off the "Y=" part
                String nextY = pointScan.next();
                String tempY = nextY.substring(2, nextY.length());
                returnList.add(new Point(Float.valueOf(tempX), Float.valueOf(tempY)));
            }
            pointScan.close();
        }
        catch (FileNotFoundException fnf)
        {
            fnf.printStackTrace();
        }
        return returnList;
    }
}
