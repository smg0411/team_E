package PAC_MAN;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;

public class Screen extends Canvas implements KeyListener{

	private Image PMImg;

	public Screen() {
		ImageIcon icon = new ImageIcon("src/resource/PM.jpg");
		this.PMImg = icon.getImage();
		
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
