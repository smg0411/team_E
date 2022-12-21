package PAC_MAN;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Item extends Rectangle{

	public Item(int x, int y) {
		setBounds(x+7, y+7, 17, 17);
	}
	
	public void render(Graphics g) {
		g.setColor(new Color(0,255,255));
		g.fillRect(x,y,width,height);
	}
}