import java.util.ArrayList;
import java.util.Observable;


public class BlackBoard extends Observable{

	private ArrayList<Point> points;
	private ArrayList<Line> lines;
	private static BlackBoard instance; 
	
	public static BlackBoard getInstance() { 
		if (instance == null) { 
			instance = new BlackBoard(); 
		}
		return instance; 
		
	}
	
	private BlackBoard() { 
		points = new ArrayList<Point>(); 
		lines = new ArrayList<Line>(); 
		
	}
	
	public ArrayList<Point> getPoints() { 
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
	
	public void setLines(ArrayList<Line> lines) {
		this.lines = lines;
	}


	
}
