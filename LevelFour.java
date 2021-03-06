package com.company;

/* Andy, Zack, Shang-Lin
03/09/2018
Code for Level 4 setup*/

import java.awt.Point;
import java.util.TimerTask;

@SuppressWarnings("serial")
//Allows for code to run smoothly (precautionary code)
public class LevelFour extends Level {
    //All other levels have the same concept of creating the buttons, baselines, lines, putting them onto the form and checking for any collisions
    //If the user wins the level then proceed to next level
    //*see Level One and Level Two if necessary

    private Point button1 = new Point(100, 310);
    private Point base1 = new Point(150, 300);

    private Point button2 = new Point(475, 620);
    private Point base2 = new Point(465, 600);

    private Point button3 = new Point(620, 410);
    private Point base3 = new Point(600, 400);

    private Point button4 = new Point(210, 620);
    private Point base4 = new Point(200, 600);

    LevelFour(){
        super("Hook: Level Four", "#BBDEFB");

        LeftBar L1 = new LeftBar(button1, base1, 100);
        add(L1);

        DownBar D1 = new DownBar(button2, base2, 250);
        add(D1);

        RightBar R1 = new RightBar(button3, base3, 95);
        R1.addLabel(2, 300, 30);
        add(R1);

        DownBar D2 = new DownBar(button4, base4, 160);
        D2.addLabel(0, 70, 30);
        D2.addLabel(0, 70, 30);
        add(D2);

        TimerTask checkColCom = new TimerTask() {
            public void run() {
                Time += 1;
                if(isColliding(D2.labels.get(2), L1.labels.get(0)) || isColliding(D2.labels.get(1), R1.labels.get(1)) || isColliding(D1.labels.get(0), R1.labels.get(1))) {
                    collisionCompletion.cancel();
                    new LevelFour();
                    WinScreen.EndTime += Time;
                    dispose();
                }
                if(checkDone()) {
                    new LevelFive();
                    WinScreen.EndTime += Time;
                    dispose();
                    collisionCompletion.cancel();
                }
            }
        };
        collisionCompletion.scheduleAtFixedRate(checkColCom, 40, 30);
    }
}