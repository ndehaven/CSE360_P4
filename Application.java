import java.awt.*;
import javax.swing.*;

public class Application extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	WorkAreaPanel workAreaPanel; 
	
	
	public static void main(String[]args) { 
		Application app = new Application(); 
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setSize(800,800);
		app.setVisible(true);
		Blackboard.getInstance().addObserver(new HandlerLine());
		Blackboard.getInstance().addObserver(new HandlerCluster());
	}
	
	public Application() { 
		
		super("Project 360"); 
		workAreaPanel = new WorkAreaPanel(); 
		setLayout(new BorderLayout()); 
		this.add(workAreaPanel, BorderLayout.CENTER);
		
		
	}
}