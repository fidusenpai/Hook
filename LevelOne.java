package com.company;

/* Andy, Zack, Shang-Lin
03/09/2018
Code for Level 1 setup*/

import java.awt.*;
import java.util.TimerTask;

@SuppressWarnings("serial")
public class LevelOne extends Level {

    private Point button = new Point(200, 200);
    private Point base = new Point(250, 230);
    //Declare the point for the button and base

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
        //Gives window a name at the top of the GUI
        LeftBar l1 = new LeftBar(button, base, 200);
        add(l1);
        collisionCompletion.scheduleAtFixedRate(checkColCom, 40, 30);
        //creates a timertask for the line shrink so it doesn't shrink instantly
    }

}