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
	TranslateTransition move = new TranslateTransition();
	
	public RandomCircle(int windowWidth, int windowHeight)
	{
		super(rand.nextInt(MIN_RADIUS,MAX_RADIUS));
//		this.windowWidth = windowWidth;
//		this.windowHeight = windowHeight;
		move = new TranslateTransition(Duration.seconds(3), RandomCircle.this);
		setFill(getRandomColor());
		move.setFromX(rand.nextDouble(getRadius(), windowWidth-getRadius()));
		move.setFromY(rand.nextDouble(getRadius(), windowHeight-getRadius()));
		move.setToX(rand.nextDouble(getRadius(), windowWidth-getRadius()));
		move.setToY(rand.nextDouble(getRadius(), windowHeight-getRadius()));
		move.setCycleCount(TranslateTransition.INDEFINITE);
		move.setAutoReverse(true);
		move.play();
		//setCenterX(rand.nextDouble(getRadius(), windowWidth-getRadius()));
		//setCenterY(rand.nextDouble(getRadius(), windowHeight-getRadius()));
		
		//initAnimation(windowWidth, windowHeight);

		setOnMousePressed(event ->
		{
			//animation.stop();
//          Path path = new Path();
//          path.getElements().add(new MoveTo(startX, startY));
//          path.getElements().add(new LineTo(centerX, centerY));
//          PathTransition transition = new PathTransition(Duration.seconds(1), path, RandomCircle.this);
//          transition.play();
         

          //TranslateTransition moveToCenter = new TranslateTransition(Duration.seconds(1), RandomCircle.this);
          //moveToCenter.setToX((windowWidth/2));
          move.stop();
		  move.setFromX(event.getSceneX());
          move.setFromY(event.getSceneY());
		  move.setToX(300);
          move.setToY(200);
          //moveToCenter.setToY((windowHeight/2));
          System.out.println(getCenterX());
          System.out.println(getCenterY());
          move.setAutoReverse(false);
          move.setCycleCount(1);
//          System.out.println(windowWidth/2);

          move.play();
		});

//		initMousePressedHandler((windowWidth / 2), (windowHeight / 2));
		
	}
	
	private void initAnimation(int windowWidth, int windowHeight) 
	{
		//startX = move.getCenterX();
		startY = getCenterY();
	    endX = rand.nextDouble(getRadius(), windowWidth-getRadius());
	    endY = rand.nextDouble(getRadius(), windowHeight-getRadius());
	    
        Path path = new Path();
        path.getElements().add(new MoveTo(startX, startY));
        path.getElements().add(new LineTo(endX, endY));
        path.getElements().add(new LineTo(startX, startY));
        animation = new PathTransition(Duration.seconds(rand.nextInt(4,5)), path, this);
        animation.setCycleCount(PathTransition.INDEFINITE);
        animation.play();
        
    }

//    private void initMousePressedHandler(int centerX, int centerY) 
//    {
//        setOnMousePressed(new EventHandler<MouseEvent>() 
//        {
//            @Override
//            public void handle(MouseEvent event) 
//            {
//                animation.stop();
////                Path path = new Path();
////                path.getElements().add(new MoveTo(startX, startY));
////                path.getElements().add(new LineTo(centerX, centerY));
////                PathTransition transition = new PathTransition(Duration.seconds(1), path, RandomCircle.this);
////                transition.play();
//               
//
//                TranslateTransition moveToCenter = new TranslateTransition(Duration.seconds(1), RandomCircle.this);
//                moveToCenter.setToX(centerX - getCenterX());
//                moveToCenter.setToY(centerY - getCenterY());
//
//                moveToCenter.play();
//            }
//        });
//    }
    private Color getRandomColor() 
    {

        double red = Math.random();
        double green = Math.random();
        double blue = Math.random();
        return new Color(red, green, blue, 1.0);


    }
    
}
