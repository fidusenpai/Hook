package com.company;

/* Andy, Zack, Shang-Lin
03/09/2018
Code for Level 1 setup*/

import java.awt.*;
import java.util.TimerTask;

@SuppressWarnings("serial")
//Allows for code to run smoothly (precautionary code)
public class LevelOne extends Level {

    private Point button = new Point(200, 240);
    private Point base = new Point(250, 230);
    //Declare the point for the button and base

    private TimerTask checkColCom = new TimerTask() {
        //Run code of the Level
        public void run() {
            Time += 1;
            //Increases time by 1 every 30 ms after the initial 40 ms
            if(checkDone()) {
                //If all the lines are fully shrunk then
                WinScreen.EndTime += Time;
                //Add the time used on this level to the total time
                dispose();
                new LevelTwo();
                //generate the next level and get rid of level one and any of it's processes
                collisionCompletion.cancel();
            }
        }
    };

    LevelOne(){
        super("Hook: Level One", "#FFE082");
        //Gives window a name at the top of the GUI, and set the background a colour
        LeftBar l1 = new LeftBar(button, base, 200);
        //Create the lines
        add(l1);
        //Add the line to the form
        collisionCompletion.scheduleAtFixedRate(checkColCom, 40, 30);
        //creates a timertask for the line shrink so it doesn't shrink instantly
    }
}