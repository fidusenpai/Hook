package com.company;

/* Andy, Zack, Shang-Lin
03/09/2018
This is the Bar class. Creates lines, the baselines, and the buttons. */

import java.awt.*;
import java.util.ArrayList;
import java.util.TimerTask;

public class MovingObjRight{
    public ArrayList<Label> moving = new ArrayList<>();

    public TimerTask testTask = new TimerTask(){
        public void run() {
            Move();
        }
    };;

    MovingObjRight(int m1, int m2, int ml1x, int ml1y){
        Label temp = new Label();
        temp.setBackground(Color.black);
        temp.setBounds(m1, m2, ml1x, ml1y);

        moving.add(temp);
    }

    public void Move(){
        if (moving.get(0).getX() < 600){
            moving.get(0).setLocation(moving.get(0).getX() + 5, moving.get(0).getY());
        }
        else
            moving.get(0).setLocation(moving.get(0).getX() - 5, moving.get(0).getY());

    }
}

