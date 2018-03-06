/* NAMES
03/08/2018
This is the level class. Sets the properties of the frame/level. */

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Timer;

@SuppressWarnings("serial")
	//Allows for code to run smoothly (precautionary code)
public class Level extends Frame implements WindowListener{
	//This class can interact with the Frame's properties
	
	 //What does windowlisteners do here
	
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
		
		 //What does windowlisteners do here
	}
	
	Level(String Name){
		setSize(XSize, YSize);
		setLayout(null);
		setVisible(true);
		setTitle(Name);
		addWindowListener(this);
		//Constructor that takes in a string: "Name". Creates a visible 800x800 form with no layout and the Title being set as whatever "Name" is
	
		 //What does windowlisteners do here
	}
	
	public void addBar(Bar b1) {
		Bars.add(b1);
			//Add the bar(b1) to the arraylist
	}
	//Method that adds a bar to the arraylist *see Bar class
	
	public void add(Bar b1) {
		addBar(b1);
		add(b1.base);
		add(b1.baseLine);
		//adds the bars, baseline, and the button onto the frame
		for(int i = 0; i < b1.labels.size(); i++) { 
			//goes through entire arraylist of b1 and
			add(b1.labels.get(i));
				//adds them to the frame
		}
	}
	//Method that adds the bars, the baseline, and the button (as a set) onto the frame
	
	public Boolean checkDone() {
		boolean temp = true;
		for(int i = 0; i < Bars.size(); i++) {
			//Goes through the entire arraylist of bars
			if(!Bars.get(i).Done) {
				//If the bars have all reached the baseline then
				temp = false;
					//Set temp to be false
			}
			//If not then temp is still true
		}
		return temp;
			//Return temp
	}
	//Method to test if the line is done shrinking
	
	public Boolean isColliding(Label l1, Label l2) {
		if(l1.getBounds().intersects(l2.getBounds())) {
			//If the rectangle (l1) is intersecting with the other rectangle (l2) then
			return true;
				//return true
		}
		return false;
			//if not false
	}
	//Method that tests if any lines are colliding 
	
	@Override
	public void windowActivated(WindowEvent e) {
	}
		//Necessary methods to prevent crashing

	@Override
	public void windowClosed(WindowEvent e) {
	}
		//Necessary methods to prevent crashing

	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
		//Necessary methods to prevent crashing

	@Override
	public void windowDeactivated(WindowEvent e) {
	}
		//Necessary methods to prevent crashing

	@Override
	public void windowDeiconified(WindowEvent e) {
	}
		//Necessary methods to prevent crashing

	@Override
	public void windowIconified(WindowEvent e) {
	}
		//Necessary methods to prevent crashing

	@Override
	public void windowOpened(WindowEvent e) {
	}
		//Necessary methods to prevent crashing
}
