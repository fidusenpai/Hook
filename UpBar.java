/* NAMES
03/08/2018
This is the Upbar class. Shrinks the bar down. */

import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class UpBar extends Bar {
	//Is a subclass to the bar class
	public TimerTask testTask = new TimerTask() {
		public void run() {
			//When the timer runs 
			shrinkLines();
				//Call this method
		}
	};
	
	UpBar(Point b1, Point bl1, int Length){
		super(b1, bl1, 50, 4, 1, Length);
		base.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
					if(shrinking) {
						shrinkTimer.cancel();
						shrinking = false;
						base.setBackground(Color.red);
					} else {
						testTask = new TimerTask() {
							public void run() {
								shrinkLines();
							}
						};
						shrinkTimer = new Timer();
						shrinkTimer.scheduleAtFixedRate(testTask, 0, 10);
						shrinking = true;
						base.setBackground(Color.green);
					}
			}
		});
	}
	
	public void shrinkLines() {
		for(int i = 0; i < labels.size(); i++ ) {
			Rectangle temp = labels.get(i).getBounds();
			if (temp.getY() > baseLine.getY()) {
				labels.get(i).setBounds((int)temp.getX(), (int)temp.getY()- 1, (int)temp.getWidth(), (int)temp.getHeight());
			} else if(temp.getHeight() > 0) {
				labels.get(i).setBounds((int)temp.getX(), (int)temp.getY(), (int)temp.getWidth(), (int)temp.getHeight() - 1);
			} else if(i == labels.size() - 1) {
				Done = true;
				shrinkTimer.cancel();
				baseLine.setVisible(false);
				base.setVisible(false);
			}
		}
	}
	
}
