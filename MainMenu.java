import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class MainMenu extends Level {
	
	private Button Exit = new Button("Exit");
	private Font menuFont = new Font("Courier", Font.BOLD, 40);
	
	MainMenu(){
		super("Hook: Main Menu");
		Exit.setBounds(100,600,600,50);
		Exit.setFont(menuFont);
		Exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		add(Exit);
		
	}
	
}
