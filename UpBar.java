import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class UpBar extends Bar {

	public TimerTask testTask = new TimerTask() {
		public void run() {
			shrinkLines();
		}
	};
	
	UpBar(Rectangle b1, Rectangle bl1 ,  int Length){
		super(b1, bl1, 1, Length);
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
					System.out.println(shrinking);
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
