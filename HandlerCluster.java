import java.util.Random;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;


public class HandlerCluster implements Observer {
	
	@Override
	public void update(Observable o, Object arg) {
		Blackboard bb = (Blackboard) o;
		ArrayList<Point>  array_points = bb.getPoints();
		KMCluster cluster = new KMCluster(array_points, 2);
    	double cluster_index[] = cluster.returnClusterLabels();

		// coloring the points
		for (int i = 0; i < cluster_index.length; i++) {
			// System.out.println("Cluster " + i + ": " + cluster_index[i]);
			if (cluster_index[i] == 0) {
				array_points.get(i).setColor(Color.RED);
			} 
			else {
				array_points.get(i).setColor(Color.BLUE);
			}
		}

		// Circles parameters
		Point[] centeres = cluster.returnMean();
		Point center0 = centeres[0];
		Point center1 = centeres[1];
		double[] radius = cluster.returnRadius();
		int radius_0 = (int)radius[0];
		int radius_1 = (int)radius[1];

		// Draw the Circles
		ArrayList<Circle> circles = new ArrayList<Circle>();
		Circle circle0 = new Circle(center0, radius_0);
		Circle circle1 = new Circle(center1, radius_1);
		circles.add(circle0);
		circles.add(circle1);
		bb.setCircles(circles);


		// Draw the lines
		// Use the centers and draw a line in between them
		ArrayList<Line> lines = new ArrayList<Line>();
		lines.add(new Line(center0, center1));
		bb.setLines(lines);

	}

}
