import java.awt.Button;
import java.awt.Color;
import java.awt.Label;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Bar {

	public ArrayList<Label> labels = new ArrayList<Label>();
	public Button base = new Button();
	public Boolean shrinking = false;
	public Timer test = new Timer();
	
	
	Bar(Rectangle b1, Rectangle l1){
		
		base.setBackground(Color.black);
		base.setBounds(b1);
		
		
		
		Label temp = new Label();
		temp.setBackground(Color.black);
		temp.setBounds(l1);
		labels.add(temp);
	}
	
	public void addLabel(Rectangle l1) {
		Label temp = new Label();
		temp.setBackground(Color.black);
		temp.setBounds(l1);
		labels.add(temp);
	}
}
