package com.company;

/* Andy, Zack, Shang-Lin
03/09/2018
This is the WinScreen class. Creates the window that tells the user that they have won! */

import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
//Allows for code to run smoothly (precautionary code)
public class WinScreen extends Level {
    //This class is a subclass to the super class: Level
    private Label win = new Label("You Have Won!");
    private Button Menu = new Button("Return to Main Menu");
    private Button Exit = new Button("Exit");
    private Font menuFont = new Font("Courier", Font.BOLD, 25);

    private final int XSIZE = 400, YSIZE = XSIZE;

    WinScreen(){
        setSize(XSIZE, YSIZE);
        //Create's a 400 x 400 frame

        win.setBounds(100, 50, 300, 100);
        win.setFont(menuFont);
        add(win);
        //Set the label win properties and add it to the frame

        Menu.setBounds(50, 150, 300, 100);
        Menu.setFont(menuFont);
        Menu.addActionListener(new ActionListener() {
            //The button will "listen" for when it is clicked
            public void actionPerformed(ActionEvent arg0) {
                new MainMenu();
                dispose();
                //When the button is clicked, reset the program and call a new main menu object, get rid of the win screen and any of it's processes
            }
        });
        add(Menu);
        //Set the button menu properties and add it to the frame

        Exit.setBounds(50, 250, 300, 100);
        Exit.setFont(menuFont);
        Exit.addActionListener(new ActionListener() {
            //The button will "listen" for when it is clicked
            public void actionPerformed(ActionEvent arg0) {
                System.exit(0);
                //When the button is clicked, exit the program
            }
        });
        add(Exit);
        //Set the button exit properties and add it to the frame
    }
}
