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
	
	
	Bar(Point b1, Point bl1, int bl1x, int bl1y, int Direction, int Length){
		
		base.setBackground(Color.red);
		base.setBounds((int)b1.getX(), (int)b1.getY(), 30, 30);
		
		baseLine.setBounds((int)bl1.getX(), (int)bl1.getY(), bl1x, bl1y);
		baseLine.setBackground(Color.black);
		
		addLabel(Direction, Length, 0);
	}
	
	public void addLabel(int Direction, int Length, int spacing) {
		Label temp = new Label();
		Point coords = setStart();
		temp.setBackground(Color.black);
		temp.setName(Integer.toString(Direction));
		if(Direction == 0) {
			temp.setBounds((int)coords.getX(), (int)coords.getY()  - Length - spacing, 4, Length);
		} else if(Direction == 1) {
			temp.setBounds((int)coords.getX(), (int)coords.getY() + spacing, 4, Length);
		} else if(Direction == 2) {
			temp.setBounds((int)coords.getX() - Length - spacing, (int)coords.getY(), Length, 4);
		}	else if(Direction == 3) {
			temp.setBounds((int)coords.getX() + spacing, (int)coords.getY(), Length, 4);
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
	
	public void addHook(int Direction1, int Direction2) {
		addLabel(Direction1, 25, 0);
		addLabel(Direction2, 50, 0);
		if(Direction1 == 0){
			addLabel(1, 29, 0);
		} else if(Direction1 == 1) {
			addLabel(0, 21, 0);
		} else if(Direction1 == 2) {
			addLabel(3, 29, 0);
		} else if(Direction1 == 3) {
			addLabel(2, 21, 0);
		}
	}
}
