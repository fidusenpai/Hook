package com.company;

/* Andy, Zack, Shang-Lin
03/09/2018
Code for Level 2 setup*/

import java.awt.*;
import java.util.TimerTask;

@SuppressWarnings("serial")
//Allows for code to run smoothly (precautionary code)
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
            //Declares and creates the timer used to check collision of 2 bar(aka Lines)
            public void run() {
                if(isColliding(R1.labels.get(1), U1.labels.get(0))) {
                    //If any of the possible collisions happen between the two lines
                    collisionCompletion.cancel();
                    //Stop the timer
                    new LevelTwo();
                    dispose();
                    //Reset the level
                }
                if(checkDone()) {
                    //If the lines are all fully shrunk then
                    dispose();
                    new LevelThree();
                    //Generate the next level and get rid of level two and all of it's processes
                    collisionCompletion.cancel();
                }
            }
        };
        collisionCompletion.scheduleAtFixedRate(checkColCom, 40, 30);
        //creates a timertask for the line shrink so it doesn't shrink instantly
    }
}