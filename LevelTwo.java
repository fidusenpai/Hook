import java.awt.*;
import java.util.TimerTask;

@SuppressWarnings("serial")
public class LevelTwo extends Level {

	private Point button1 = new Point(250, 250);
	private Point base1 = new Point(600, 400);
	
	private Point button2 = new Point(550, 100);
	private Point base2 = new Point(375, 200);
	
	
	
	LevelTwo(){
		super("Hook: Level Two");
		
		RightBar R1 = new RightBar(button1, base1, 175);
		R1.addLabel(2, 75, 50);
		add(R1);
		
		UpBar U1 = new UpBar(button2, base2, 400);
		add(U1);
		
		TimerTask checkColCom = new TimerTask() {
			public void run() {
				if(isColliding(R1.labels.get(1), U1.labels.get(0))) {
					collisionCompletion.cancel();
					new LevelTwo();
					dispose();
				}
				if(checkDone()) {
					dispose();
					new LevelThree();
					//new LevelTwo();
					collisionCompletion.cancel();
					
				}
			}
		};
		
		collisionCompletion.scheduleAtFixedRate(checkColCom, 40, 30);
	}
	
}
