
public class HandlerLine implements Observer {

	@Override
	public void update(Observable o, Object args) {
        ArrayList<Line> lines = new ArrayList<Line>();
        ArrayList<Point> points = BlackBoard.getInstance().getPoints();

        //Starting from second point, will draw a line from previous point to this one
        for (int i = 1; i < points.size(); i++) {
            Point endPt1 = new Point(points.get(i-1).getX(), points.get(i-1).getY());
            Point endPt2 = new Point(points.get(i).getX(), points.get(i).getY());
            Line l = new Line(endPt1, endPt2);
            lines.add(l);
	}
        BlackBoard.getInstance().setLines(lines);
	}
	
	private float distance(Point a, Point b) {
		float xDiff = a.getX()-b.getX();
		float yDiff = a.getY() - b.getY();
		float dist = (float)Math.sqrt((xDiff*xDiff) + (yDiff*yDiff));
		
		return dist;
	}
}
