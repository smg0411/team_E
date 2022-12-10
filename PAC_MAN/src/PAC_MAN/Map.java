package PAC_MAN;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Map extends JFrame {
	private Graphics bufferGraphics;
	private Image offScreen;
	private Dimension dim;
	private Image background;
	public int width;
	public int height;
	
	public Tile[][] tiles;
	
	private int location = 30;
	
	public Map(String path) {
		setSize(1000, 700);                       // 화면 크기 설정
		setTitle("PAC MAN!");                     // 텍스트 타이틀 
		setResizable(false);                      // 윈도우 창 크기 고정
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLayout(null);
		//setBackground(Color.BLACK);
		
		
		setLocationRelativeTo(null);
		
		try {
			BufferedImage map = ImageIO.read(getClass().getResource(path));
			this.width  = map.getWidth();
			this.height = map.getHeight();
			
			int[] pixels = new int[width*height];
			
			map.getRGB(0, 0, width, height, pixels, 0, width);
			
			tiles = new Tile[width][height];
			
			for (int i=0; i<width; i++) {
				for (int k=0; k<height; k++) {
					int val = pixels[i+(k*width)];	
					if (val == 0xFF000000) {
						//벽
						tiles[i][k] = new Tile(i*32+location,k*32+location);
					}
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	private void initBuffer() {
		this.dim = getSize();
		this.offScreen = createImage(dim.width, dim.height);
		this.bufferGraphics = this.offScreen.getGraphics();
	}
	
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		this.render(g);

	}
	public void render(Graphics g) {
		for (int i=0; i<width; i++) {
			for (int k=0; k<height; k++) {
				if (tiles[i][k] != null) {
					tiles[i][k].render(g);
				}
			}
		}
	}
	@Override
	public void update(Graphics g) {
		// TODO Auto-generated method stub
	}
}
