import java.util.ArrayList;
import java.util.Observable;

public class Blackboard extends Observable {
  private ArrayList<Point> points;
  private ArrayList<Line> lines;
  private static Blackboard instance;
  
  public static Blackboard getInstance(){
    if (instance == null)
      instance = new Blackboard();
    return instance;
  }
  
  private Blackboard() {
    points = new ArrayList<Point>();
    lines = new ArrayList<Line>();
  }
  
  public ArrayList<Point> getPoints(){return points;}
  
  public ArrayList<Line> getLines(){return lines;}
  
  public void addPoint(Point p) {
    points.add(P);
    setChanged();
    notifyObservers();
  }
  
  public void setLines(ArrayList<Line> lines){
    this.lines = lines;
  }
}
