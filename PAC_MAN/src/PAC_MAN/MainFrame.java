package PAC_MAN;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class MainFrame extends JFrame implements ComponentListener {
	private Screen screen;
	
	public MainFrame() {
		this.screen = new Screen();

		add(screen);
		
		setSize(1000, 700);                       // 화면 크기 설정
		setTitle("PACK MAN!");                     // 텍스트 타이틀 
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);                      //창의 크기를 변경하지 못하게 
		setLocationRelativeTo(null);              //창이 가운데 나오게
		setVisible(true); 						// 화면 보이게 설정
		
	}
	
	@Override
	public void componentResized(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentMoved(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentShown(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentHidden(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

}
