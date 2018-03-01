import java.awt.*;
import java.util.ArrayList;
import java.util.Timer;

public class Bar {

	public ArrayList<Label> labels = new ArrayList<Label>();
	public Button base = new Button();
	public Boolean shrinking = false;
	public Label baseLine = new Label();
	public Timer shrinkTimer = new Timer();
	public Boolean Done = false;
	
	
	Bar(Rectangle b1, Rectangle bl1, int Direction, int Length){
		
		base.setBackground(Color.black);
		base.setBounds(b1);
		
		baseLine.setBounds(bl1);
		baseLine.setBackground(Color.black);
		
		addLabel(Direction, Length);
	}
	
//	public void addLabel(Rectangle l1) {
//		Label temp = new Label();
//		temp.setBackground(Color.black);
//		temp.setBounds(l1);
//		temp.setName("0");
//		labels.add(temp);
//	}
	
	public void addLabel(int Direction, int Length) {
		Label temp = new Label();
		Point coords = setStart();
		temp.setBackground(Color.black);
		temp.setName(Integer.toString(Direction));
		if(Direction == 0) {
			temp.setBounds((int)coords.getX(), (int)coords.getY()  - Length, 4, Length);
		} else if(Direction == 1) {
			temp.setBounds((int)coords.getX(), (int)coords.getY(), 4, Length);
		} else if(Direction == 2) {
			temp.setBounds((int)coords.getX() - Length, (int)coords.getY(), Length, 4);
		}	else if(Direction == 3) {
			temp.setBounds((int)coords.getX(), (int)coords.getY(), Length, 4);
		}
		
		labels.add(temp);
	}
	public Point setStart() {
		Label temp = new Label();
		Point output = new Point();
		if(labels.size() == 0) {
			if(baseLine.getWidth() > baseLine.getHeight()) {
				output.setLocation(baseLine.getX() + (baseLine.getWidth()/2)-2, baseLine.getY());
			} else {
				output.setLocation(baseLine.getX(), baseLine.getY() + (baseLine.getHeight()/2)-2);
			}
		} else{
			
			temp = labels.get(labels.size()-1);
			if (temp.getName().equals("0")) {
				output.setLocation(temp.getX(), temp.getY());
			} else if (temp.getName().equals("1")) {
				output.setLocation(temp.getX(), temp.getY() + temp.getHeight() - 4);
			} else if (temp.getName().equals("2")) {
				output.setLocation(temp.getX(), temp.getY());
			} else if (temp.getName().equals("3")) {
				output.setLocation(temp.getX() + temp.getWidth() - 4, temp.getY());
			}
		}
		
		
		return output;
		
	}
}
