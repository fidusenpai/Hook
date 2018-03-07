/* NAMES
03/08/2018
This is the Upbar class. Shrinks the bar down. */

import java.awt.*;
import java.util.TimerTask;

@SuppressWarnings("serial")
public class LevelOne extends Level {

	private Point button = new Point(200, 200);
	private Point base = new Point(250, 230);
	private TimerTask checkColCom = new TimerTask() {
		public void run() {
			if(checkDone()) {
				dispose();
				new LevelTwo();
				collisionCompletion.cancel();
			}
		}
	};
	
	LevelOne(){
		super("Hook: Level One");
		
		LeftBar l1 = new LeftBar(button, base, 200);
		
		add(l1);
		
		collisionCompletion.scheduleAtFixedRate(checkColCom, 40, 30);
	}
	
}
