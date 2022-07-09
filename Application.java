import java.awt.*;
import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class Application extends JFrame implements ActionListener, MenuListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	WorkAreaPanel workAreaPanel; 
	
	JMenuBar menuBar;
	JMenu fileMenu, connectionMenu, helpMenu;
	JMenuItem New, Load, Save, Line, Cluster, LineCluster, About;
	
	
	
	@SuppressWarnings("deprecation")
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
	
	ArrayList<Line> lines = new ArrayList<Line>();
	ArrayList<Circle> circles = new ArrayList<Circle>();
	ArrayList<Point> points = BlackBoard.getInstance().getPoints();


	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(New)) { 
			BlackBoard.getInstance().empty();
			 WorkAreaPanel newArea = new WorkAreaPanel();
			 workAreaPanel = newArea;
			 repaint(); 
		}
		
		else if (e.getSource().equals(Line)) { 
			

			for (int i = 1; i < points.size(); i++) {
				Point endPt1 = new Point(points.get(i-1).getX(), points.get(i-1).getY());
				Point endPt2 = new Point(points.get(i).getX(), points.get(i).getY());
				Line l = new Line(endPt1, endPt2);
				lines.add(l);
				BlackBoard.getInstance().setLines(lines);
				repaint(); 
			}
		}
		
		
		else if (e.getSource().equals(Cluster)) { 
			Object[] options = {0, 2};
	        Object miniMenu = (Integer)JOptionPane.showInputDialog(null, "Enter the amount of clusters you'd like:", 
	                "Cluster Selector", JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
	        System.out.println(miniMenu);
	        
	        if (miniMenu.equals(options[0]) ) { 
	        	// File code for 1 cluster only
	        }
	        else if (miniMenu.equals(options[1]) ) { 
	        	
	        	System.out.println("Cluster reached");
	        	KMCluster cluster = new KMCluster(points, 2);
	        	Point centerTest = cluster.returnMean1();
	        	Circle c = new Circle(centerTest, 200); 
	        	circles.add(c);
	        	BlackBoard.getInstance().setCircles(circles);
	        	repaint();
		}
	}
		
		else if (e.getSource().equals(Save)) {
			String filename = "Save.csv";
			Save(filename);
		}
		
		else if (e.getSource().equals(Load)){
            		String filename = "Save.csv";
            		Load(filename);
        	}
	}

	@Override
	public void menuSelected(MenuEvent e) {
		String userNames = "Team members: \nNoah\n Ash\n Omar";
 		JOptionPane.showMessageDialog(null, userNames, "About" ,JOptionPane.PLAIN_MESSAGE);
		
	}

	@Override
	public void menuDeselected(MenuEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void menuCanceled(MenuEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	private void Save(String filename){
        try{
            File output = new File(filename);
            if (output.exists()) {
                JOptionPane.showMessageDialog(null, "File already exists!");
            } else
            if(output.createNewFile()){
                FileWriter writer = new FileWriter(filename);
                writer.write(BlackBoard.getInstance().toString());
                writer.close();
                JOptionPane.showMessageDialog(null, "Successfully created file: " + filename);
            }
        } catch (IOException exception){
            JOptionPane.showMessageDialog(null, "An error occurred." + exception.getMessage());
            exception.printStackTrace();
        }
    }
	
	private void Load(String filename){
        Point temp;
        int x, y;
        try {
            File file = new File(filename);
            Scanner scanner = new Scanner(file);
            BlackBoard.getInstance().empty();
            while (scanner.hasNextLine()){
                String[] data = scanner.nextLine().split("[,]",0);
                x = Integer.parseInt(data[0]);
                y = Integer.parseInt(data[1]);
                temp = new Point(x,y);
                BlackBoard.getInstance().addPoint(temp);
            }
            scanner.close();
            repaint();
        } catch (FileNotFoundException exception){
            JOptionPane.showMessageDialog(null, "An error occurred. " + exception.getMessage());
        }
    }
}
