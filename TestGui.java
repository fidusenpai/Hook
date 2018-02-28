import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class TestGui extends Frame implements WindowListener {

	private Rectangle b1 = new Rectangle(10, 50, 30, 30);
	private Rectangle bl1 = new Rectangle(150, 150, 30, 4);
	private Rectangle l1 = new Rectangle((int)(bl1.getX() + bl1.getWidth() / 2 - 2), (int)bl1.getY(), 4, 150);
	private Rectangle l1_1 = new Rectangle((int)(bl1.getX() + bl1.getWidth() / 2 - 2), (int)bl1.getY() + 200, 4, 150);
	
	private Rectangle b2 = new Rectangle(500, 500, 30,30);
	private Rectangle bl2  = new Rectangle(250, 150, 4, 30);
	private Rectangle l2 = new Rectangle((int)bl2.getX(), (int)(bl2.getY() + bl2.getHeight() / 2 - 2), 150, 4);
	
	private Rectangle b3 = new Rectangle(200, 200, 30, 20);
	private Rectangle bl3 = new Rectangle(300, 750, 30, 4);
	private Rectangle l3 = new Rectangle((int)(bl3.getX() + bl3.getWidth() / 2 - 2), (int)bl3.getY() - 150, 4, 150);
	
	private Rectangle b4 = new Rectangle(400, 400, 5,100);
	private Rectangle bl4 = new Rectangle(500, 450, 4, 30); 
	private Rectangle l4 = new Rectangle((int)bl2.getX() - 150, (int)(bl2.getY() + bl2.getHeight() / 2 - 2), 150, 4);
	
	TestGui(){
		
		setSize(800,800);
		setLayout(null);
		setVisible(true);
		addWindowListener(this);
		
		UpBar U1 = new UpBar(b1, bl1, l1);
		U1.addLabel(l1_1);
		
		LeftBar L1 = new LeftBar(b2, bl2, l2);
		
		DownBar D1= new DownBar(b3, bl3, l3);
		
		RightBar R1 = new RightBar(b4, bl4, l4);
		
		add(R1.base);
		add(R1.baseLine);
		for(int i =0; i < R1.labels.size(); i++) {
			add(R1.labels.get(i));
		}
		
		add(D1.base);
		add(D1.baseLine);
		for(int i =0; i < D1.labels.size(); i++) {
			add(D1.labels.get(i));
		}
		
		add(L1.base);
		add(L1.baseLine);
		for(int i =0; i < L1.labels.size(); i++) {
			add(L1.labels.get(i));
		}
		
		add(U1.base);
		add(U1.baseLine);
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