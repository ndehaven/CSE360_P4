
/*
Author: Aashritha Machiraju
Class Description: This class calls KMeans and colors the dots.
*/


import java.util.Random;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;


@SuppressWarnings({ "deprecation" })
public class HandlerCluster implements Observer {
	
	@Override
	public void update(Observable o, Object arg) {
		BlackBoard bb = (BlackBoard) o;
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

		

	}

}
