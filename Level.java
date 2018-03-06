/* NAMES
03/08/2018
This is the level class. Sets the properties of the frame. */

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Timer;

@SuppressWarnings("serial")
	//Allows for code to run smoothly (precautionary code)
public class Level extends Frame implements WindowListener{
	//This class can interact with the Frame's properties
	private final int XSize = 800;
	private final int YSize = XSize;	
	private ArrayList<Bar> Bars = new ArrayList<Bar>();
	public Timer collisionCompletion = new Timer();
	
	Level(){
		setSize(XSize, YSize);
		setLayout(null);
		setVisible(true);
		addWindowListener(this);
		//Default Constructor. Creates a visible 800x800 form with no layout
	}
	
	Level(String Name){
		setSize(XSize, YSize);
		setLayout(null);
		setVisible(true);
		setTitle(Name);
		addWindowListener(this);
		//Constructor that takes in a string: "Name". Creates a visible 800x800 form with no layout and the Title being set as whatever "Name" is
	}
	
	public void addBar(Bar b1) {
		Bars.add(b1);
	}
	
	public void add(Bar b1) {
		addBar(b1);
		add(b1.base);
		add(b1.baseLine);
		for(int i = 0; i < b1.labels.size(); i++) {
			add(b1.labels.get(i));
		}
	}
	
	public Boolean checkDone() {
		boolean temp = true;
		for(int i = 0; i < Bars.size(); i++) {
			if(!Bars.get(i).Done) {
				temp = false;
			}
		}
		return temp;
	}
	
	public Boolean isColliding(Label l1,Label l2) {
		if(l1.getBounds().intersects(l2.getBounds())) {
			return true;
		}
		return false;
		
	}
	
	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
