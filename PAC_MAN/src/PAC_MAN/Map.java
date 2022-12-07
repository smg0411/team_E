package PAC_MAN;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Map extends Canvas {
	private Graphics bufferGraphics;
	private Image offScreen;
	private Dimension dim;
	private Image background;
	
	public Map() {
		background = new ImageIcon("resource/PACMAN.png").getImage();
	}
	private void initBuffer() {
		this.dim = getSize();
		this.offScreen = createImage(dim.width, dim.height);
		this.bufferGraphics = this.offScreen.getGraphics();
	}
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		initBuffer();
		screenDraw(bufferGraphics);
		g.drawImage(offScreen, 0, 0, this);
	}
	public void screenDraw(Graphics g) {
		g.drawImage(background, 0, 0, null);
		this.repaint();
	}
	@Override
	public void update(Graphics g) {
		// TODO Auto-generated method stub
	}
}
