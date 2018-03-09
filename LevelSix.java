package com.company;

/* Andy, Zack, Shang-Lin
03/09/2018
Code for Level 6 setup*/

import java.awt.Point;
import java.util.TimerTask;

@SuppressWarnings("serial")
//Allows for code to run smoothly (precautionary code)
public class LevelSix extends Level {
    //All other levels have the same concept of creating the buttons, baselines, lines, putting them onto the form and checking for any collisions
    //If the user wins the level then proceed to next level
    //*see Level One and Level Two if necessary

    private Point button1 = new Point(100, 100);
    private Point base1 = new Point(100, 300);

    private Point button2 = new Point(200, 100);
    private Point base2 = new Point(490, 200);

    private Point button3 = new Point(300, 100);
    private Point base3 = new Point(100, 600);

    private Point button4 = new Point(400, 100);
    private Point base4 = new Point(290, 700);

    private Point button5 = new Point(500, 100);
    private Point base5 = new Point(700, 400);

    private Point button6 = new Point(600, 100);
    private Point base6 = new Point(700, 500);

    private Point button7 = new Point(650, 100);
    private Point base7 = new Point(600, 200);

    private Point button8 = new Point(700, 100);
    private Point base8 = new Point(200, 200);

    private Point button9 = new Point(750, 100);
    private Point base9 = new Point(300, 200);

    LevelSix(){
        super("Hook: Level Six");

        LeftBar L1 = new LeftBar(button1, base1, 400);
        L1.addLabel(3, 200, 30);
        add(L1);

        UpBar U1 = new UpBar(button2, base2, 200);
        add(U1);

        LeftBar L2 = new LeftBar(button3, base3, 200);
        L2.addLabel(3, 400, 60);
        add(L2);

        DownBar D1 = new DownBar(button4, base4, 100);
        D1.addHook(2,0);
        D1.addLabel(0,50, 0);
        add(D1);

        RightBar R1 = new RightBar(button5, base5, 50);
        R1.addLabel(2, 250, 60);
        R1.addLabel(2, 250, 30);
        add(R1);

        RightBar R2 = new RightBar(button6, base6, 200);
        add(R2);

        UpBar U2 = new UpBar(button7, base7, 110);
        U2.addLabel(1, 75, 30);
        U2.addHook(3,1);
        U2.addLabel(1, 60, 0);
        U2.addLabel(1, 75, 30);
        U2.addLabel(1,50, 30);
        add(U2);

        UpBar U3 = new UpBar(button8, base8, 110);
        U3.addLabel(1, 80, 30);
        U3.addLabel(1, 75, 30);
        add(U3);

        UpBar U4 = new UpBar(button9, base9, 110);
        U4.addLabel(1, 200, 30);
        add(U4);

        TimerTask checkColCom = new TimerTask() {
            public void run() {
                if(isColliding(U1.labels.get(0), L1.labels.get(1)) || isColliding(U3.labels.get(1), L1.labels.get(0)) || isColliding(U4.labels.get(1), L1.labels.get(0)) || isColliding(R1.labels.get(2), U4.labels.get(1)) || isColliding(R1.labels.get(1), U2.labels.get(3)) || isColliding(U3.labels.get(2), R1.labels.get(2)) || isColliding(R1.labels.get(1), U2.labels.get(5)) || isColliding(R1.labels.get(1), U2.labels.get(6)) || isColliding(R1.labels.get(1), U2.labels.get(7)) || isColliding(U2.labels.get(7), R2.labels.get(0)) || isColliding(U2.labels.get(6), R2.labels.get(0)) || isColliding(U2.labels.get(7), L2.labels.get(1)) || isColliding(L2.labels.get(1), D1.labels.get(0)) ||  isColliding(L2.labels.get(1), D1.labels.get(2)) || isColliding(L2.labels.get(1), D1.labels.get(4)) || isColliding(D1.labels.get(1), L2.labels.get(0)) || isColliding(D1.labels.get(3), L2.labels.get(1)) || isColliding(U2.labels.get(4), R1.labels.get(1)))  {
                    collisionCompletion.cancel();
                    new LevelSix();
                    dispose();
                }
                if(checkDone()) {
                    dispose();
                    new WinScreen();
                    //*see winscreen class
                    collisionCompletion.cancel();
                }
            }
        };
        collisionCompletion.scheduleAtFixedRate(checkColCom, 40, 30);
    }
}
