import java.awt.*;
import java.awt.event.*;


@SuppressWarnings("serial")
public class Level extends Frame implements WindowListener{

	private final int XSize = 800;
	private final int YSize = XSize;
	
	Level(){
		setSize(XSize, YSize);
		setLayout(null);
		setVisible(true);
		addWindowListener(this);
	}
	
	Level(String Name){
		setSize(XSize, YSize);
		setLayout(null);
		setVisible(true);
		setTitle(Name);
		addWindowListener(this);
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
		System.exit(0);
		
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
