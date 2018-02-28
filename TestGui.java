import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class TestGui extends Frame implements WindowListener {

	private Rectangle b1 = new Rectangle(150, 150, 30, 30);
	private Rectangle l1 = new Rectangle((int)(b1.getX() + (b1.getWidth() / 2) - 2), (int)(b1.getY() + (b1.getHeight() / 2)), 4, 150);
	
	TestGui(){
		
		setSize(800,800);
		setLayout(null);
		setVisible(true);
		addWindowListener(this);
		
		UpBar U1 = new UpBar(b1, l1);
		
		add(U1.base);
		for(int i =0; i < U1.labels.size(); i++) {
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