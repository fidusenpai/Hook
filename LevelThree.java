package com.company;

/* Andy, Zack, Shang-Lin
03/09/2018
Code for Level 3 setup*/
import java.awt.Point;
import java.util.TimerTask;

@SuppressWarnings("serial")
public class LevelThree extends Level {

    private Point button1 = new Point(200, 600);
    private Point base1 = new Point(200, 400);

    private Point button2 = new Point(550, 100);
    private Point base2 = new Point(400, 600);

    LevelThree(){
        super("Hook: Level Three");

        LeftBar L1 = new LeftBar(button1, base1, 200);
        L1.addHook(0, 3);
        L1.addLabel(3, 100, 0);
        add(L1);

        DownBar D1 = new DownBar(button2, base2, 190);
        D1.addLabel(0, 150, 60);
        add(D1);

        TimerTask checkColCom = new TimerTask() {
            public void run() {
                if(isColliding(L1.labels.get(2), D1.labels.get(1)) || isColliding(L1.labels.get(3), D1.labels.get(0))) {
                    collisionCompletion.cancel();
                    new LevelThree();
                    dispose();
                }
                if(checkDone()) {
                    new LevelFour();
                    dispose();
                    //new LevelTwo();
                    collisionCompletion.cancel();

                }
            }
        };

        collisionCompletion.scheduleAtFixedRate(checkColCom, 40, 30);
    }


}