package com.company;

/* Andy, Zack, Shang-Lin
03/09/2018
This is the LeftBar class. Creates lines that shrink from the right. (shrinks left) It essentially works the same way as the RightBar class. *refer to RightBar class. */

import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class LeftBar extends Bar {

    public TimerTask testTask = new TimerTask(){
        public void run() {
            shrinkLines();
        }
    };;

    LeftBar(Point b1, Point bl1, int Length){
        super(b1, bl1, 4, 50, 3, Length);
        base.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent arg0) {
                if(shrinking) {
                    shrinkTimer.cancel();
                    shrinking = false;
                    base.setBackground(Color.red);
                } else {
                    testTask = new TimerTask() {
                        public void run() {
                            shrinkLines();
                        }
                    };
                    shrinkTimer = new Timer();
                    shrinkTimer.scheduleAtFixedRate(testTask, 0, 10);
                    shrinking = true;
                    base.setBackground(Color.green);
                }
            }
        });
    }

    public void shrinkLines() {
        for(int i = 0; i < labels.size(); i++ ) {
            Rectangle temp = labels.get(i).getBounds();
            if (temp.getX() > baseLine.getX()) {
                labels.get(i).setBounds((int)temp.getX() - 1, (int)temp.getY(), (int)temp.getWidth(), (int)temp.getHeight());
            } else if(temp.getWidth() > 0) {
                labels.get(i).setBounds((int)temp.getX(), (int)temp.getY(), (int)temp.getWidth() - 1, (int)temp.getHeight());
            } else if(i == labels.size() - 1) {
                Done = true;
                shrinkTimer.cancel();
                baseLine.setVisible(false);
                base.setVisible(false);
            }
        }
    }
}