package com.company;

/* Andy, Zack, Shang-Lin
03/09/2018
Code for Level 5 setup*/

import java.awt.Point;
import java.util.TimerTask;

@SuppressWarnings("serial")
//Allows for code to run smoothly (precautionary code)
public class LevelFive extends Level {
    //All other levels have the same concept of creating the buttons, baselines, lines, putting them onto the form and checking for any collisions
    //If the user wins the level then proceed to next level
    //*see Level One and Level Two if necessary

    private Point button1 = new Point(100, 210);
    private Point base1 = new Point(150, 200);

    private Point button2 = new Point(410, 100);
    private Point base2 = new Point(400, 150);

    private Point button3 = new Point(510, 100);
    private Point base3 = new Point(500, 150);

    private Point button4 = new Point(620, 460);
    private Point base4 = new Point(600, 450);

    private Point button5 = new Point(223, 670);
    private Point base5 = new Point(213, 650);

    private Point button6 = new Point(620, 610);
    private Point base6 = new Point(600, 600);

    LevelFive(){
        super("Hook: Level Five");

        LeftBar L1 = new LeftBar(button1, base1, 75);
        L1.addLabel(3, 500, 30);
        add(L1);

        UpBar U1 = new UpBar(button2, base2, 65);
        U1.addLabel(1, 250, 30);
        add(U1);

        UpBar U2 = new UpBar(button3, base3, 65);
        U2.addLabel(1, 450, 30);
        add(U2);

        RightBar R1 = new RightBar(button4, base4, 50);
        R1.addLabel(2, 53, 50);
        R1.addHook(1, 2);
        R1.addLabel(2, 165, 0);
        add(R1);

        DownBar D1 = new DownBar(button5, base5, 152);
        D1.addHook(2, 0);
        D1.addLabel(0, 250, 0);
        add(D1);

        RightBar R2 = new RightBar(button6, base6, 60);
        R2.addLabel(2, 250, 30);
        R2.addLabel(2, 50, 60);
        add(R2);

        TimerTask checkColCom = new TimerTask() {
            public void run() {
                if(isColliding(L1.labels.get(1), D1.labels.get(4)) || isColliding(L1.labels.get(1), U1.labels.get(1)) || isColliding(L1.labels.get(1), U2.labels.get(1)) || isColliding(U1.labels.get(1), R1.labels.get(4)) || isColliding(U2.labels.get(1), R1.labels.get(1)) || isColliding(D1.labels.get(0), R2.labels.get(2)) || isColliding(U2.labels.get(1), R2.labels.get(1)) || isColliding(D1.labels.get(3), R1.labels.get(5)) || isColliding(D1.labels.get(1), R2.labels.get(2))) {
                    collisionCompletion.cancel();
                    new LevelFive();
                    dispose();
                }
                if(checkDone()) {
                    dispose();
                    new LevelSix();
                    collisionCompletion.cancel();
                }
            }
        };
        collisionCompletion.scheduleAtFixedRate(checkColCom, 40, 30);
    }
}