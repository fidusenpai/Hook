package com.company;

/* Andy, Zack, Shang-Lin
03/09/2018
This is the level class. Code for generating mandatory components for a Level */

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Timer;

@SuppressWarnings("serial")
//Allows for code to run smoothly (precautionary code)
public class Level extends Frame implements WindowListener{
    //This class can interact with the Frame's properties and allows for the user to close the program and interact with the buttons on the top right corner of the program

    private final int XSize = 800, YSize = XSize;
    private ArrayList<Bar> Bars = new ArrayList<Bar>();
    public Timer collisionCompletion = new Timer();
    //This timer will be necessary to check for collision
    public long Time;

    Level(String Name, String Colour){
        setBackground(Color.decode(Colour));
        //Sets the background colour
        setSize(XSize, YSize);
        setLayout(null);
        setVisible(true);
        setTitle(Name);
        addWindowListener(this);
        //Constructor that takes in a string: "Name". Creates a visible 800x800 form with no layout and the Title being set as whatever "Name" is
    }

    public void add(Bar b1) {
        Bars.add(b1);
        //Add the bar(b1) to the arraylist
        add(b1.TheButton);
        add(b1.baseLine);
        //Adds the bars, baseline, and the button onto the frame
        for(int i = 0; i < b1.labels.size(); i++) {
            //Goes through entire arraylist of the buttons and
            add(b1.labels.get(i));
            //Adds them to the frame
        }
    }
    //Method that adds the bars, the baseline, and the button (as a set) onto the frame

    public Boolean checkDone() {
        boolean temp = true;
        for(int i = 0; i < Bars.size(); i++) {
            //Goes through the entire arraylist of bars
            if(!Bars.get(i).Done) {
                //If the bars have all reached the baseline then
                temp = false;
                //Set temp to be false
            }
            //If not then there are still lines that haven't been fully shrunk
        }
        return temp;
        //Return temp
    }
    //Method to test if the lines are done shrinking

    public Boolean isColliding(Label l1, Label l2) {
        if(l1.getBounds().intersects(l2.getBounds())) {
            //If the rectangle (l1) is intersecting with the other rectangle (l2) then (checks this by seeing if their "hitboxes" are colliding)
            return true;
            //return true
        }
        return false;
        //if not false
    }
    //Method that tests if any lines are colliding

    @Override
    public void windowActivated(WindowEvent e) {
    }
    //Necessary methods to prevent crashing

    @Override
    public void windowClosed(WindowEvent e) {
    }
    //Necessary methods to prevent crashing

    @Override
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }
    //Necessary methods to prevent crashing

    @Override
    public void windowDeactivated(WindowEvent e) {
    }
    //Necessary methods to prevent crashing

    @Override
    public void windowDeiconified(WindowEvent e) {
    }
    //Necessary methods to prevent crashing

    @Override
    public void windowIconified(WindowEvent e) {
    }
    //Necessary methods to prevent crashing

    @Override
    public void windowOpened(WindowEvent e) {
    }
    //Necessary methods to prevent crashing
}