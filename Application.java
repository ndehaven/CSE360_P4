import java.awt.*;
import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import java.awt.event.*;
import java.util.ArrayList;


public class Application extends JFrame implements ActionListener, MenuListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	WorkAreaPanel workAreaPanel; 
	
	JMenuBar menuBar;
	JMenu fileMenu, connectionMenu, helpMenu;
	JMenuItem New, Load, Save, Line, Cluster, LineCluster, About;
	
	
	public static void main(String[]args) { 
		Application app = new Application(); 
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setSize(800,800);
		app.setVisible(true);
		BlackBoard.getInstance().addObserver(new HandlerLine());
		BlackBoard.getInstance().addObserver(new HandlerCluster());
	}
	
	public Application() { 
		
		super("Project 360"); 
		menuBar = new JMenuBar();
		fileMenu = new JMenu("File");
		connectionMenu = new JMenu("Connections");
		helpMenu = new JMenu("Help");

		Load = new JMenuItem("Load");
		New = new JMenuItem("New");
		Save = new JMenuItem("Save");
		Line = new JMenuItem("Line");
		Cluster = new JMenuItem("Cluster");
		LineCluster = new JMenuItem("LineCluster");
		About = new JMenuItem("About");
	 
		New.addActionListener(this);
		Load.addActionListener(this);
		Save.addActionListener(this);
		Line.addActionListener(this);
		Cluster.addActionListener(this);
		LineCluster.addActionListener(this);
			
		helpMenu.addMenuListener(this);
	
		fileMenu.add(New);
		fileMenu.add(Load);
		fileMenu.add(Save);
		connectionMenu.add(Line);
		connectionMenu.add(Cluster);
		connectionMenu.add(LineCluster);
		helpMenu.add(About); 
		
		
		menuBar.add(fileMenu);
		menuBar.add(connectionMenu);
		menuBar.add(helpMenu);

	
		this.setJMenuBar(menuBar);
		this.setVisible(true);
		this.pack();
		workAreaPanel = new WorkAreaPanel(); 
		setLayout(new BorderLayout()); 
		this.add(workAreaPanel, BorderLayout.CENTER);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(New)) { 
			BlackBoard.getInstance().empty();
			 WorkAreaPanel newArea = new WorkAreaPanel();
			 workAreaPanel = newArea;
			 repaint(); 
		}
		
		else if (e.getSource().equals(Line)) { 
			ArrayList<Line> lines = new ArrayList<Line>();
			ArrayList<Point> points = BlackBoard.getInstance().getPoints();
			for (int i = 1; i < points.size(); i++) {
	            Point endPt1 = new Point(points.get(i-1).getX(), points.get(i-1).getY());
	            Point endPt2 = new Point(points.get(i).getX(), points.get(i).getY());
	            Line l = new Line(endPt1, endPt2);
	            lines.add(l);
			BlackBoard.getInstance().setLines(lines);
			repaint(); 
			}
		}

		
	}

	@Override
	public void menuSelected(MenuEvent e) {
		String userNames = "Team members: \nNoah\n Ash\n Omar";
 		JOptionPane.showMessageDialog(null, userNames, "About" ,JOptionPane.PLAIN_MESSAGE);
 		
 		System.out.println(e.getSource());
	}

	@Override
	public void menuDeselected(MenuEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void menuCanceled(MenuEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}

