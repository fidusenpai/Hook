import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class WinScreen extends Level {

	private Label win = new Label("You Have Won!");
	private Button Menu = new Button("Return to Main Menu");
	private Button Exit = new Button("Exit");
	private Font menuFont = new Font("Courier", Font.BOLD, 25);
	
	WinScreen(){
		setSize(400, 400);
		
		win.setBounds(100, 50, 300, 100);
		win.setFont(menuFont);
		add(win);
		
		Menu.setBounds(50, 150, 300, 100);
		Menu.setFont(menuFont);
		Menu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new MainMenu();
				dispose();
			}
		});
		add(Menu);
		
		Exit.setBounds(50, 250, 300, 100);
		Exit.setFont(menuFont);
		Exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		add(Exit);
	}
}
