//This class controls the Line and allows the user to create the points that the line will be drawn through 

public class Line {

	private Point endPoint1; 
	private Point endPoint2; 
	
	
	public Line(Point endPoint1, Point endPoint2) { 
		this.endPoint1 = endPoint1; 
		this.endPoint2 = endPoint2; 
		
		
		
	}
	
	public Point getEndPoint1() { 
		return this.endPoint1;
	}
	
	public Point getEndPoint2() { 
		return this.endPoint2; 
	}
}
