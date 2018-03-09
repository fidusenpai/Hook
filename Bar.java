package com.company;

/* Andy, Zack, Shang-Lin
03/09/2018
This is the Bar class. Creates lines, the baselines, and the buttons. */

import java.awt.*;
import java.util.ArrayList;
import java.util.Timer;

public class Bar {
    public ArrayList<Label> labels = new ArrayList<Label>();
    public Button TheButton = new Button();
    public Label baseLine = new Label();
    public Timer shrinkTimer = new Timer();
    //This timer will be needed to shrink the lines
    public Boolean Done = false , shrinking = false;
    public final byte BSize = 30, LineThickness = 4;

    Bar(Point b1, Point bl1, int bl1x, int bl1y, int Direction, int Length){
        TheButton.setBackground(Color.red);
        TheButton.setBounds((int)b1.getX(), (int)b1.getY(), BSize, BSize);
        //The button's properties are set

        baseLine.setBounds((int)bl1.getX(), (int)bl1.getY(), bl1x, bl1y);
        baseLine.setBackground(Color.black);
        //The baseline's properties are set

        addLabel(Direction, Length, 0);
        //Creates a new label (Line) by calling on the addLabel method
    }

    public void addLabel(int Direction, int Length, int spacing) {
        Label temp = new Label();
        Point coords = setStart();
        //See setStart method
        temp.setBackground(Color.black);
        temp.setName(Integer.toString(Direction));
        //setName is a variable that stores the direction of the line
        if(Direction == 0) {
            temp.setBounds((int)coords.getX(), (int)coords.getY()  - Length - spacing, LineThickness, Length);
        } else if(Direction == 1) {
            temp.setBounds((int)coords.getX(), (int)coords.getY() + spacing, LineThickness, Length);
        } else if(Direction == 2) {
            temp.setBounds((int)coords.getX() - Length - spacing, (int)coords.getY(), Length, LineThickness);
        }else if(Direction == 3) {
            temp.setBounds((int)coords.getX() + spacing, (int)coords.getY(), Length, LineThickness);
        }
        //If the direction is (0 = up  1 = down 2 = left  3 = right) then set the properties of the lines to it's respected dimensions
        labels.add(temp);
        //Add the label (line) to the arraylist
    }
    //Method to create a new line

    public Point setStart() {
        Label temp = new Label();
        Point output = new Point();
        //if theres no labels yet
        if(labels.size() == 0) {
            //create a label from the center of the baseline
            if(baseLine.getWidth() > baseLine.getHeight()) {
                output.setLocation(baseLine.getX() + (baseLine.getWidth()/2)-2, baseLine.getY());
            } else {
                output.setLocation(baseLine.getX(), baseLine.getY() + (baseLine.getHeight()/2)-2);
            }
        } else{
            //otherwise, find where the end corner of the previous bar is
            temp = labels.get(labels.size()-1);
            if (temp.getName().equals("0")) {
                output.setLocation(temp.getX(), temp.getY());
            } else if (temp.getName().equals("1")) {
                output.setLocation(temp.getX(), temp.getY() + temp.getHeight() - LineThickness);
            } else if (temp.getName().equals("2")) {
                output.setLocation(temp.getX(), temp.getY());
            } else if (temp.getName().equals("3")) {
                output.setLocation(temp.getX() + temp.getWidth() - LineThickness, temp.getY());
            }
            //(0 = up  1 = down 2 = left  3 = right)
        }
        //output the starting location
        return output;
    }
    //This method just tells where the line will start (centre of baseline)

    public void addHook(int Direction1, int Direction2) {
        addLabel(Direction1, 25, 0);
        addLabel(Direction2, 50, 0);
        //Figures out what the opposite direction of direction 1 is, and creates a label that is in a direction
        if(Direction1 == 0){
            addLabel(1, 29, 0);
        } else if(Direction1 == 1) {
            addLabel(0, 21, 0);
        } else if(Direction1 == 2) {
            addLabel(3, 29, 0);
        } else if(Direction1 == 3) {
            addLabel(2, 21, 0);
        }
        //If Direction1 = 0 then create a line that is going down, = 1 then a line going up, = 2 then a line going right, = 3 then a line going left
    }
    //Method that creates a hook on a line
}