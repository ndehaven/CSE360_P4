import java.util.List;
import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


/**
 * This class controls the Panel in which the user will be able to create dots based on the 
 * 
 * @author oolivas
 * @author ndehaven
 * @author amachira
 * @version 2022.07.08
 */


@SuppressWarnings("unused")
public class WorkAreaPanel extends JPanel implements MouseListener {
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
public WorkAreaPanel() {
	  
    setBackground(Color.GRAY);
    addMouseListener(this);
  }
  

	public void mouseReleased(MouseEvent e) {
	Point p = new Point(e.getX(), e.getY(), Color.DARK_GRAY); 
    BlackBoard.getInstance().addPoint(p);
    System.out.println(e.getX() + "," + e.getY()); 
    repaint();
  }
  

	
	// Our paintComponent is responsible for drawing our circles, lines and dots on the screen 
  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    
    //points
    List<Point> points = BlackBoard.getInstance().getPoints();
    if (points == null) {
    	return;
    }
    g.setColor(Color.BLACK);
    
    for (Point p : points) {
      if(Color.BLUE.equals(p.getColor())) {
        g.setColor(Color.BLUE);
      } 
      else if (Color.RED.equals(p.getColor())) {
        g.setColor(Color.RED);
      } else {
        g.setColor(Color.BLACK);
      }
      g.fillOval(p.getX()-5, p.getY()-5, 10, 10);
    }
    
    //lines
    List<Line> lines = BlackBoard.getInstance().getLines();
    if (lines == null) 
    	return;
    for (Line l : lines) {
      Point x1 = l.getEndPoint1();
      Point x2 = l.getEndPoint2();
      g.setColor(Color.ORANGE);
      g.drawLine(x1.getX(), x1.getY(), x2.getX(), x2.getY());
    }
    

//    List<Circle> circles = BlackBoard.getInstance().getCircles();
//    if (circles == null) 
//    	return; 
//    for (Circle c : circles) { 
//    	
//    	Point cc1 = c.getCenter();
//    	g.setColor(Color.GREEN); 
//    	g.drawOval(cc1.getX(), cc1.getY(), 400, 400);
//    	}
//    
  }

@Override
public void mouseClicked(MouseEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void mousePressed(MouseEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void mouseEntered(MouseEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void mouseExited(MouseEvent e) {
	// TODO Auto-generated method stub
	
}

}
