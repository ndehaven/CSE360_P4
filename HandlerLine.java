
public class HandlerLine implements Observer {

	@Override
	public void update(Observable o, Object args) {
        
	}
	
	private float distance(Point a, Point b) {
		float xDiff = a.getX()-b.getX();
		float yDiff = a.getY() - b.getY();
		float dist = (float)Math.sqrt((xDiff*xDiff) + (yDiff*yDiff));
		
		return dist;
	}
}
