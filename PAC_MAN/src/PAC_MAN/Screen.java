package PAC_MAN;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;

public class Screen extends Canvas implements KeyListener {
	private Graphics bufferGraphics;
	private Image offScreen;
	private Dimension dim;
	private Image PMImg;
	private int stage = 1;

	public Screen() {
		ImageIcon icon = new ImageIcon("resource/PM.jpg");
		this.PMImg = icon.getImage();
		
	}
	
	private void initBuffer() {
		this.dim = getSize();
		this.offScreen = createImage(dim.width, dim.height);
		this.bufferGraphics = this.offScreen.getGraphics();
	}
	
	@Override
	public void paint(Graphics g) {
		g.drawImage(PMImg, 0, 0, this);
	}
	
	
	@Override
	public void update(Graphics g) {
		// TODO Auto-generated method stub
		paint(g);
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}