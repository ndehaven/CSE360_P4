import java.awt.*;
import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.event.*;


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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void menuSelected(MenuEvent e) {
		// TODO Auto-generated method stub
		
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
