package com.company;

/* Andy, Zack, Shang-Lin
03/09/2018
This is the RightBar class. Creates lines that shrink from the left (shrinks right). */

import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class RightBar extends Bar {
    //The RightBar is a subclass to the superclass Bar
    public TimerTask testTask = new TimerTask(){
        public void run() {
            shrinkLines();
            //When the timer is running, shrink the line *see Shrink Lines
        }
    };;

    RightBar(Point b1, Point bl1, int Length){
        super(b1, bl1, 4, 50, 2, Length);
        //The rightbar inherits the Bar's constructor. Essentially will create the button, TheButtonline and line(see Bar super class)
        TheButton.addActionListener(new ActionListener() {
            //Have the button "listen" to when it is clicked
            public void actionPerformed(ActionEvent arg0) {
                //After being clicked on
                if(shrinking) {
                    //If the line is shrinking then
                    shrinkTimer.cancel();
                    shrinking = false;
                    TheButton.setBackground(Color.red);
                    //Pause the shrinking and change the button's colour to red
                } else {
                    //However, if the line isn't shrinking then
                    testTask = new TimerTask() {
                        //Create a new timertask
                        public void run() {
                            //When the timer is running, shrink the line
                            shrinkLines();
                        }
                    };
                    shrinkTimer = new Timer();
                    shrinkTimer.scheduleAtFixedRate(testTask, 0, 10);
                    shrinking = true;
                    TheButton.setBackground(Color.green);
                    //When the button is clicked and the line isn't shrinking then make the line shrink and have the button turn green
                }
            }
        });
    }

    public void shrinkLines() {
        for(int i = 0; i < labels.size(); i++ ) {
            //Loop through the entire arraylist of lines
            Rectangle temp = labels.get(i).getBounds();
            if (temp.getX() + temp.getWidth() < baseLine.getX() + 4) {
                labels.get(i).setBounds((int)temp.getX() + 1, (int)temp.getY(), (int)temp.getWidth(), (int)temp.getHeight());
            } else if(temp.getWidth() > 0) {
                labels.get(i).setBounds((int)temp.getX() + 1, (int)temp.getY(), (int)temp.getWidth() - 1, (int)temp.getHeight());
                //if the line hasn't been fully shrunk then shrink the lines by
            } else if(i == labels.size() - 1) {
                Done = true;
                shrinkTimer.cancel();
                baseLine.setVisible(false);
                TheButton.setVisible(false);
            }
        }
    }
}