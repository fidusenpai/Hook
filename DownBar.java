package com.company;

/* Andy, Zack, Shang-Lin
03/09/2018
This is the DownBar class. Creates lines that shrink from above. (shrinks down) It essentially works the same way as the RightBar class. *refer to RightBar class */

import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class DownBar extends Bar {

    public TimerTask testTask = new TimerTask() {
        public void run() {
            shrinkLines();
        }
    };

    DownBar(Point b1, Point bl1, int Length){
        super(b1, bl1, 50, 4, 0, Length);
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
        //Rectangle temp = new Rectangle();
        for(int i = 0; i < labels.size(); i++ ) {
            Rectangle temp = labels.get(i).getBounds();
            if (temp.getY() + temp.getHeight() < baseLine.getY() + 4) {
                labels.get(i).setBounds((int)temp.getX(), (int)temp.getY() + 1, (int)temp.getWidth(), (int)temp.getHeight());
            } else if(temp.getHeight() > 0) {
                labels.get(i).setBounds((int)temp.getX(), (int)temp.getY() + 1, (int)temp.getWidth(), (int)temp.getHeight() - 1);
            } else if(i == labels.size() - 1) {
                Done = true;
                shrinkTimer.cancel();
                baseLine.setVisible(false);
                base.setVisible(false);
            }
        }
    }

}
