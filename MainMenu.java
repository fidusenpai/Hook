package com.company;

/* Andy, Zack, Shang-Lin
03/09/2018
This is the main menu class. Generates what the user will first see upon loading the program. */

import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
//Allows for code to run smoothly (precautionary code)
public class MainMenu extends Level {
    //The Main Menu is a subclass to the Level super class
    private Button Exit = new Button("Exit");
    private Button StartGame = new Button("Start");
    private Label title = new Label("Hook");
    private Font menuFont = new Font("Courier", Font.BOLD, 40);
    private Font titleFont = new Font("Courier", Font.BOLD, 100);
		/* Generates the components for the Main Menu
		which is two buttons: One to allow the player to play and the other to allow the player to exit the program
		and a label that outputs the title of the game: Hook. */

    MainMenu(){
        super("Hook: Main Menu");
        //The main menu inherits the frame's properties for which the program will be on (see Level super class)
        title.setBounds(275, 100, 600, 100);
        title.setFont(titleFont);
        add(title);
        //Set the properties of the label and add it to the frame

        Exit.setBounds(100,600,600,50);
        Exit.setFont(menuFont);
        //Set the properties of the exit button
        Exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                System.exit(0);
                //When the exit button is clicked, close the program
            }
        });

        add(Exit);
        //Add the exit button to the frame

        StartGame.setBounds(100, 500, 600, 50);
        StartGame.setFont(menuFont);
        //Set the properties of the start button
        StartGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                new LevelOne();
                dispose();
                //When the start button is clicked, level one will generate and appear. The main menu closes and all of it's processes are eliminated
            }
        });

        add(StartGame);
        //Add the start button to the frame
    }
}
