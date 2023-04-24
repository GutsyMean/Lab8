package circleCatcher;

import java.util.Random;
import javafx.animation.*;
import javafx.event.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.util.*;

public class RandomCircle extends Circle
{

	private static final int MAX_RADIUS = 50;
    private static final int MIN_RADIUS = 10;
    
    private PathTransition animation;

    private double startX;
    private double startY;
//    private double windowWidth;
//    private double windowHeight;
    private double endX;
    private double endY;
    
	static Random rand = new Random();
	Circle circle = new Circle();
	
	public RandomCircle(int windowWidth, int windowHeight)
	{
		super(rand.nextInt(MIN_RADIUS,MAX_RADIUS));
//		this.windowWidth = windowWidth;
//		this.windowHeight = windowHeight;
		
		setFill(getRandomColor());
		setLayoutX(rand.nextInt(300));
		setLayoutY(rand.nextInt(200));
		initAnimation(windowWidth, windowHeight);
		initMousePressedHandler((windowWidth / 2), (windowHeight / 2));
		
	}
	
	private void initAnimation(int windowWidth, int windowHeight) 
	{
		startX = getLayoutX();
		startY = getLayoutY();
	    endX = rand.nextDouble(300);
	    endY = rand.nextDouble(200);
        Path path = new Path();
        path.getElements().add(new MoveTo(startX, startY));
        path.getElements().add(new LineTo(endX, endY));
        path.getElements().add(new LineTo(startX, startY));
        animation = new PathTransition(Duration.seconds(rand.nextInt(1,3)), path, this);
        animation.setCycleCount(PathTransition.INDEFINITE);
        animation.play();
    }

    private void initMousePressedHandler(int centerX, int centerY) 
    {
        setOnMousePressed(new EventHandler<MouseEvent>() 
        {
            @Override
            public void handle(MouseEvent event) 
            {
                animation.stop();
//                Path path = new Path();
//                path.getElements().add(new MoveTo(startX, startY));
//                path.getElements().add(new LineTo(centerX, centerY));
//                PathTransition transition = new PathTransition(Duration.seconds(1), path, RandomCircle.this);
//                transition.play();
               

                TranslateTransition moveToCenter = new TranslateTransition(Duration.seconds(1), RandomCircle.this);
                moveToCenter.setToX(centerX - getCenterX());
                moveToCenter.setToY(centerY - getCenterY());

                moveToCenter.play();
            }
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
