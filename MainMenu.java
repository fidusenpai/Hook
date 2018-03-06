/* NAMES
03/08/2018
This is the main menu class. Generates what the user will first see upon loading the program. */

import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
//Allows for code to run smoothly (precautionary code)
public class MainMenu extends Level {
	
	private Button Exit = new Button("Exit");
	private Button StartGame = new Button("Start");
	private Label title = new Label("Hook");
	private Font menuFont = new Font("Courier", Font.BOLD, 40);
	private Font titleFont = new Font("Courier", Font.BOLD, 100);
	
	MainMenu(){
		super("Hook: Main Menu");
		
		title.setBounds(275, 100, 600, 100);
		title.setFont(titleFont);
		add(title);
		
		Exit.setBounds(100,600,600,50);
		Exit.setFont(menuFont);
		Exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		add(Exit);
		
		StartGame.setBounds(100, 500, 600, 50);
		StartGame.setFont(menuFont);
		StartGame.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new LevelOne();
				dispose();
			}
		});
		add(StartGame);
	}
	
}
