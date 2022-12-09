package PAC_MAN;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Map extends JFrame {
	private Graphics bufferGraphics;
	private Image offScreen;
	private Dimension dim;
	private Image background;
	
	public Map() {
		setSize(1000, 700);                       // 화면 크기 설정
		setTitle("PAC MAN!");                     // 텍스트 타이틀 
		setLayout(null);
		setBackground(Color.BLACK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);                      //창의 크기를 변경하지 못하게 s
		setLocationRelativeTo(null);
		setVisible(true);
		background = new ImageIcon("resource/MapDesign.png").getImage();
		
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
