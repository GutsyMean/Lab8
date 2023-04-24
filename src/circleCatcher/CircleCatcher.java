package circleCatcher;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class CircleCatcher extends Application
{
	private static final int WINDOW_WIDTH = 600;
	private static final int WINDOW_HEIGHT = 400;
	private static final int NUM_CIRCLES = 10;
	
	public void start(Stage primaryStage)  
    {
    	Pane pane = new Pane();
    	for (int i = 0; i < NUM_CIRCLES; i++)
    	{
    		RandomCircle circle = new RandomCircle(WINDOW_WIDTH, WINDOW_HEIGHT);
    		pane.getChildren().add(circle);
    	}
    	Scene scene = new Scene(pane, WINDOW_WIDTH, WINDOW_HEIGHT);

    	primaryStage.setTitle("Circle Catcher");
        primaryStage.setScene(scene);
//        primaryStage.setWidth(WINDOW_WIDTH);
//        primaryStage.setHeight(WINDOW_HEIGHT);
        primaryStage.show();
    }
	
	public static void main(String[] args) 
	{
		launch(args);
	}

}
