package circleCatcher;

import java.util.Random;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class RandomCircle extends Circle
{
	private int radius;
	private int centerX;
	private int centerY;
	private int randRed;
	private int randGreen;
	private int randBlue;
	
	Random rand = new Random();
	Circle circle = new Circle();
	Color color = new Color(randRed, randGreen, randBlue, 1.0);

	
	public RandomCircle()
	{
		radius = rand.nextInt(20, 200);
		centerX = rand.nextInt(600);
		centerY = rand.nextInt(400);
		
		randRed = rand.nextInt(254);
		randGreen = rand.nextInt(254);
		randBlue = rand.nextInt(254);
		
		
		circle = new Circle(centerX, centerY, radius, color);	
		
	}
	public Circle getRandomCircle()
	{
		return circle;
	}
}
