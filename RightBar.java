import java.util.*;
import java.awt.*;
import java.awt.event.*;

//Subclass

//See Upbar

public class RightBar extends Bar {
	
	public TimerTask testTask = new TimerTask(){
		public void run() {
			shrinkLines();
		}
	};;
	
	RightBar(Rectangle b1, Rectangle bl1 , Rectangle l1){
		super(b1, bl1, l1);
		base.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
					if(shrinking) {
						shrinkTimer.cancel();
						shrinking = false;
					} else {
						testTask = new TimerTask() {
							public void run() {
								shrinkLines();
							}
						};
						shrinkTimer = new Timer();
						shrinkTimer.scheduleAtFixedRate(testTask, 0, 10);
						shrinking = true;
					}
			}
		});
	}
	
	public void shrinkLines() {
		for(int i = 0; i < labels.size(); i++ ) {
			Rectangle temp = labels.get(i).getBounds();
			if (temp.getX() + temp.getWidth() > baseLine.getX() + 4) {
				labels.get(i).setBounds((int)temp.getX() + 1, (int)temp.getY(), (int)temp.getWidth(), (int)temp.getHeight());
			} else if(temp.getWidth() > 0) {
				labels.get(i).setBounds((int)temp.getX() + 1, (int)temp.getY(), (int)temp.getWidth() - 1, (int)temp.getHeight());
			} else if(i == labels.size() - 1) {
				Done = true;
				shrinkTimer.cancel();
				baseLine.setVisible(false);
				base.setVisible(false);
			}
		}
	}
}
