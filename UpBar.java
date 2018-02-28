import java.util.*;
import java.awt.*;
import java.awt.event.*;

//Subclass

public class UpBar extends Bar {

	public TimerTask testTask = new TimerTask() {
		public void run() {
			shrinkLines();
				//When the timer is running, shrink the line
		}
	};
	
	UpBar(Rectangle b1, Rectangle bl1 , Rectangle l1){
		super(b1, bl1, l1);
			//Calls on super class and sets the properties
		base.addActionListener(new ActionListener() {
			//Adds an actionlistener to the button
			
			public void actionPerformed(ActionEvent arg0) {
					if(shrinking) {
						//if the line is shrinking then
						shrinkTimer.cancel();
							//Stop the timer
						shrinking = false;
							//Set shrinking to false to indicate that it has stopped shrinking
					}
					else {
						//if it's not shrinking then
						testTask = new TimerTask() {
							public void run() {
								shrinkLines();
									//Create a new timertask (shrinkTimer.cancel gets rid of the timertask) and shrinks the line when the timer goes off
							}
						};
						shrinkTimer = new Timer();
							//Create a new timer as mentioned above
						shrinkTimer.scheduleAtFixedRate(testTask, 0, 10);
							//Sets the timer's properties
						shrinking = true;
							//Set shrinking to true to inficate that it is shrinking
					}
			}
		});
	}
	
	public void shrinkLines() {
		for(int i = 0; i < labels.size(); i++ ) {
			//Goes through the arraylist
			Rectangle temp = labels.get(i).getBounds();
				//Creates a new rectangle with the boundaries of the labels in the arraylist
			if (temp.getY() > baseLine.getY()) {
				//if the line isn't done shrinking then
				labels.get(i).setBounds((int)temp.getX(), (int)temp.getY()- 1, (int)temp.getWidth(), (int)temp.getHeight());
					//Continue to shrink
			} else if(temp.getHeight() > 0) {
				//However, if the rectangle's height is greater than 0 then
				labels.get(i).setBounds((int)temp.getX(), (int)temp.getY(), (int)temp.getWidth(), (int)temp.getHeight() - 1);
					//Continue to shrink?
			} else if(i == labels.size() - 1) {
				//If the lines are done shrinking then
				Done = true;
				shrinkTimer.cancel();
				baseLine.setVisible(false);
				base.setVisible(false);
					//Let the program know by setting done to true, stopping the timer, causing the line and base to be invisible
			}
		}
	}
	
}
