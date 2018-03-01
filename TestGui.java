import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class TestGui extends Frame implements WindowListener {

	private Rectangle b1 = new Rectangle(10, 50, 30, 30);
	private Rectangle bl1 = new Rectangle(400, 400, 50, 4);
		
//	private Rectangle b2 = new Rectangle(500, 500, 30,30);
//	private Rectangle bl2  = new Rectangle(250, 150, 4, 30);
//		
//	private Rectangle b3 = new Rectangle(200, 200, 30, 20);
//	private Rectangle bl3 = new Rectangle(300, 750, 30, 4);
//		
//	private Rectangle b4 = new Rectangle(400, 400, 5,100);
//	private Rectangle bl4 = new Rectangle(500, 450, 4, 30); 
		
	TestGui(){
		
		setSize(800,800);
		setLayout(null);
		setVisible(true);
		addWindowListener(this);
		
		UpBar U1 = new UpBar(b1, bl1, 150);
		U1.addLabel(2, 50);
		
		add(U1.base);
		add(U1.baseLine);
		for(int i = 0; i < U1.labels.size(); i++) {
			add(U1.labels.get(i));
		}
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		System.exit(0);;
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

}