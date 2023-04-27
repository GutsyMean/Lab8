package circleCatcher;

import java.util.Random;
import javafx.animation.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.util.*;

public class RandomCircle extends Circle
{

	private static final int MAX_RADIUS = 50;
    private static final int MIN_RADIUS = 10;
 
	static Random rand = new Random();
	Circle circle = new Circle();
	TranslateTransition move = new TranslateTransition();
	
	CircleCatcher circleCatcher;

	public RandomCircle(int windowWidth, int windowHeight, CircleCatcher circleCatcher)
	{
		super(rand.nextInt(MIN_RADIUS,MAX_RADIUS));
		this.circleCatcher = circleCatcher;
		
		setFill(getRandomColor());
		move = new TranslateTransition(Duration.seconds(3), RandomCircle.this);
		move.setFromX(rand.nextDouble(getRadius(), windowWidth-getRadius()));
		move.setFromY(rand.nextDouble(getRadius(), windowHeight-getRadius()));
		move.setToX(rand.nextDouble(getRadius(), windowWidth-getRadius()));
		move.setToY(rand.nextDouble(getRadius(), windowHeight-getRadius()));
		move.setCycleCount(TranslateTransition.INDEFINITE);
		move.setAutoReverse(true);
		move.play();

		setOnMousePressed(event ->
		{
          move.stop();
		  move.setFromX(event.getSceneX());
          move.setFromY(event.getSceneY());
		  move.setToX(windowWidth/2);
          move.setToY(windowHeight/2);
          move.setCycleCount(1);
          move.play();
          circleCatcher.onCircleCaught();
		});
		
	}
    private Color getRandomColor() 
    {
        double red = Math.random();
        double green = Math.random();
        double blue = Math.random();
        return new Color(red, green, blue, 1.0);
    }
    
}
