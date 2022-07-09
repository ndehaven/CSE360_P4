import java.util.ArrayList;
import java.util.Observable;

public class BlackBoard extends Observable {
    private ArrayList<Point> points;
    private ArrayList<Line> lines;
    private ArrayList<Circle> circles;
    private static Blackboard instance;

    public static BlackBoard getInstance() {
        if (instance == null)
            instance = new Blackboard();
        return instance;
    }

    private BlackBoard() {
        points = new ArrayList<Point>();
        lines = new ArrayList<Line>();
    }

    public ArrayList<Point> getPoints(){
        return points;
    }

    public ArrayList<Line> getLines() {
        return lines;
    }

    public void addPoint(Point p) {
        points.add(p);
        setChanged();
        notifyObservers();
    }
    public void empty(){
		points.clear();
		lines.clear();
		setChanged();
		notifyObservers();
	}

    public void setLines(ArrayList<Line> lines) {
        this.lines = lines;
    }
    //Returns String containing the X and Y values for all points on the screen. Each line is a point
	@Override
	public String toString(){
        String s = "";
        String xCommaY;
		for (Point pt : points){
			xCommaY = String.valueOf(pt.getX()) + ", " + String.valueOf(pt.getY() + ",\n ");
			s = s.concat(xCommaY);
		}
		return s;
	}


    public void setCircles(ArrayList<Circle> circles) {
        this.circles = circles;
    }
}
