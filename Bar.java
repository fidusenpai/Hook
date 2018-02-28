import java.awt.Button;
import java.awt.Color;
import java.awt.Label;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Timer;

public class Bar {

	public ArrayList<Label> labels = new ArrayList<Label>();
	public Button base = new Button();
	public Boolean shrinking = false;
	public Label baseLine = new Label();
	public Timer shrinkTimer = new Timer();
	public Boolean Done = false;
	
	
	Bar(Rectangle b1, Rectangle bl1,  Rectangle l1){
		
		base.setBackground(Color.black);
		base.setBounds(b1);
		
		baseLine.setBounds(bl1);
		baseLine.setBackground(Color.black);
		
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
