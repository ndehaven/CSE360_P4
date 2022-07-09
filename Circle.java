

// This class controls the Circle and allows the user set a radius and mean for the circle to be drawn 
public class Circle {
	
	
	
	public Point center;
    public int radius;

    public Circle(Point center, int radius) {
        this.center = center;
        this.radius = radius;
    }

    public Point getCenter() {
        return center;
    }

    public int getRadius() {
        return radius;
    }

}
