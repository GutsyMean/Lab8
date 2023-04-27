package circleCatcher;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CircleCatcher extends Application
{

	private static final int WINDOW_WIDTH = 600;
	private static final int WINDOW_HEIGHT = 400;
	private static final int NUM_CIRCLES = 1;
	
	private Pane pane;
    private Text message;
    private int numCirclesInMiddle;
    private Scene scene;
    
	@Override
	public void start(Stage primaryStage)  
    {	    
    	pane = new Pane();
    	scene = new Scene(pane, WINDOW_WIDTH, WINDOW_HEIGHT);

    	message = new Text("You caught all the circles!");
        message.setFill(Color.BLACK);
        message.setX(((scene.getWidth()/2)-50)- message.getBoundsInLocal().getWidth()/2);
        message.setY(((scene.getHeight()/2)-100)- message.getBoundsInLocal().getHeight()/2);
        message.setFont(Font.font("Arial", 20));
        message.setVisible(false);
        pane.getChildren().add(message);
        
    	for (int i = 0; i < NUM_CIRCLES; i++)
    	{
    		RandomCircle circle = new RandomCircle(WINDOW_WIDTH, WINDOW_HEIGHT, this);
    		pane.getChildren().add(circle);
    	}

    	primaryStage.setTitle("Circle Catcher");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
	public void onCircleCaught() 
	{
        numCirclesInMiddle++;
        if (numCirclesInMiddle == NUM_CIRCLES)
            message.setVisible(true);
    }
	public static void main(String[] args) 
	{
		launch(args);
	}

}
