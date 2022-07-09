/*
Author: Aashritha Machiraju
Class description: Class divides the dots into clusters
*/



import java.awt.Color;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

@SuppressWarnings("deprecation")
public class KMCluster {
    ArrayList<Point> x;
    final int numberOfClass = 2;
    double cluster[];
    int counter[];
    Point newMean1;
    Point newMean2;
    Point prevMean1;
    Point prevMean2;
    int iteration;

    public KMCluster(ArrayList<Point> x, int numberOfClass) {
        this.x = x;
        this.cluster = new double[x.size()]; // initialize the cluster array; size of the array is the number of Point;
                                             // the array will contain the cluster/class number of each Point
        
        this.newMean1 = new Point(0, 0, Color.RED);
        this.newMean1.setX(x.get(0).getX());
        this.newMean1.setY(x.get(0).getY());
        this.newMean2 = new Point(0, 0, Color.RED);
        this.newMean2.setX(x.get(x.size() - 1).getX());
        this.newMean2.setY(x.get(x.size() - 1).getY());

        this.prevMean1 = new Point(0, 0, Color.RED);
        this.prevMean1.setX(x.get(0).getX());
        this.prevMean1.setY(x.get(0).getY());
        this.prevMean2 = new Point(0, 0, Color.RED);
        this.prevMean2.setX(x.get(x.size() - 1).getX());
        this.prevMean2.setY(x.get(x.size() - 1).getY());

        this.counter = new int[2]; // Counts the number of 0 for class 1 and 1 for class 2
        iteration = 0;

        initializeCounter();

        for (int i = 0; i < x.size(); i++) { // initialize the cluster array
            if (i > (int) (x.size() / 2)) {
                // System.out.println("i here: " + i);
                cluster[i] = 1; // assign the cluster/class number of each Point
            } else {
                // debug value
                cluster[i] = 0;
            }
        }

        kmeans();

    }

    private void initializeCounter() {
        counter[0] = 0; // initialize the counter array to 0 f
        counter[1] = 0; // initialize the counter array to 0
    }

    public void kmeans() {

        // calculate the new means
        double total_x_1 = 0;
        double total_y_1 = 0;
        double total_x_2 = 0;
        double total_y_2 = 0;
        for (int i = 0; i < x.size(); i++) {
            if (cluster[i] == 0) {
                total_x_1 += x.get(i).getX();
                total_y_1 += x.get(i).getY();
                counter[0]++;
            } else {
                total_x_2 += x.get(i).getX();
                total_y_2 += x.get(i).getY();
                counter[1]++;
            }

        }
        newMean1.setX((int) (total_x_1 / counter[0]));
        newMean1.setY((int) (total_y_1 / counter[0]));
        newMean2.setX((int) (total_x_2 / counter[1]));
        newMean2.setY((int) (total_y_2 / counter[1]));


        // If means r not equal, update the cluster array and rinse and repeat
        initializeCounter();

        for (int i = 0; i < x.size(); i++) {

            double value1 = calculateDistance(x.get(i), newMean1);
            double value2 = calculateDistance(x.get(i), newMean2);
            if (value1 <= value2) {
                cluster[i] = 0;
                counter[0]++;
            } else {
                cluster[i] = 1;
                counter[1]++;
            }

        }
        prevMean1 = newMean1;
        prevMean2 = newMean2;

//        kmeans();
    }

    private double calculateDistance(Point point, Point mean) {
        double x_dist = Math.pow(point.getX() - mean.getX(), 2);
        double y_dist = Math.pow(point.getY() - mean.getY(), 2);

        return Math.sqrt(x_dist + y_dist);
    }

    public double[] returnClusterLabels() {
        return cluster;
    }

    //returns the radii of the circle that needs to be drawn 
    public double[] returnRadius() {
        double cluster_0_total = 0;
        double cluster_1_total = 0;
        for (int i = 0; i < x.size(); i++) {
            if (cluster[i] == 0) {
                cluster_0_total += calculateDistance(x.get(i), newMean1);
            } else {
                cluster_1_total += calculateDistance(x.get(i), newMean2);
            }
        }

        double radius_1 = (double) cluster_0_total / counter[0];
        double radius_2 = (double) cluster_1_total / counter[1];

        double[] radius = {radius_1, radius_2};
        return radius;

    }

    public Point returnMean1() {
        Point mean = newMean1;
        return mean;
    }
    
    public Point returnMean2() { 
    	Point mean2 = newMean2; 
    	return mean2; 
    }

    
    
    
    
    
    
    
    
}
