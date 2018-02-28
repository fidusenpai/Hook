import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class UpBar extends Bar {

	public TimerTask testTask = new TimerTask() {
		public void run() {
			shrinkLines();
		}
	};
	
	UpBar(Rectangle b1, Rectangle l1){
		super(b1, l1);
		base.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
					test.scheduleAtFixedRate(testTask, 0, 10);
			}
		});
	}
	
	public void shrinkLines() {
		Rectangle temp = labels.get(0).getBounds();
		labels.get(0).setBounds((int)temp.getX(), (int)temp.getY(), (int)temp.getWidth(), (int)temp.getHeight() - 1);
		if (labels.get(0).getHeight() == 0) {
			test.cancel();
			base.setVisible(false);
		}
	}
	
}
