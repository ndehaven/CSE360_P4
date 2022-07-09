import java.awt.*;

// This class controls the Points and allows the user to be able 
// to set the location of the Point and the color attached to it 
public class Point{
  private int x;
  private int y;
  private Color color;
  
  public Point(int x, int y, Color color) {
    this.x = x;
    this.y = y;
    this.color = color;
  }
  
  public Point (int x, int y) {this(x,y, Color.BLACK);}
  
  public int getX() {return x;}
  
  public int getY() {return y;}
  
  public void setX(int xnew)
  {
	  this.x = xnew;
  }
  
  public void setY(int ynew)
  {
	  this.y = ynew;
  }
  
  public Color getColor() {return color;}
  
  public void setColor(Color color) {this.color = color;}
  
  @Override
  public boolean equals(Object o) {
    Point other = (Point) o;
    return this.x == other.x && this.y == other.y;
  }
}
