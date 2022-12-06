package PAC_MAN;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.BufferedInputStream;
import java.io.FileInputStream;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JFrame;

public class Control extends JFrame implements ComponentListener {
	private ImageIcon me = new ImageIcon("resource/me.png");
	private ImageIcon cookie = new ImageIcon("resource/cookie.jpg");
	private ImageIcon ghost = new ImageIcon("resource/ghost.png");
	private ImageIcon powercookie = new ImageIcon("resource/powercookie.png");
	private ImageIcon PACMAN = new ImageIcon("resource/PACMAN.jpg");
	
	public Control() {
		setSize(1000, 700);                       // 화면 크기 설정
		setTitle("PAC MAN!");                     // 텍스트 타이틀 
		getContentPane().setLayout(null);
		getContentPane().setBackground(Color.BLACK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);                      //창의 크기를 변경하지 못하게 s
		setLocationRelativeTo(null);              //창이 가운데 나오게
		
		me = new ImageIcon(
				me.getImage().getScaledInstance(150, 80, Image.SCALE_SMOOTH));
		cookie = new ImageIcon(
				cookie.getImage().getScaledInstance(290, 100, Image.SCALE_SMOOTH));
		ghost = new ImageIcon(
				ghost.getImage().getScaledInstance(280, 130, Image.SCALE_SMOOTH));
		powercookie = new ImageIcon(
				powercookie.getImage().getScaledInstance(270, 130, Image.SCALE_SMOOTH));
		
		JButton PACMANButton = new JButton(PACMAN);
		PACMANButton.setBounds(110, 20, 780, 150);
		PACMANButton.setBorderPainted(false);
		PACMANButton.setContentAreaFilled(false);
		PACMANButton.setFocusPainted(false);
		add(PACMANButton);
		
		JButton pacmanButton = new JButton(me);
		pacmanButton.setBounds(170, 190, 150, 80);
		pacmanButton.setBorderPainted(false);
		pacmanButton.setContentAreaFilled(false);
		pacmanButton.setFocusPainted(false);
		add(pacmanButton);
		
		JButton cookieButton = new JButton(cookie);
		cookieButton.setBounds(600, 190, 290, 100);
		cookieButton.setBorderPainted(false);
		cookieButton.setContentAreaFilled(false);
		cookieButton.setFocusPainted(false);
		add(cookieButton);
		
		JButton ghostButton = new JButton(ghost);
		ghostButton.setBounds(170, 350, 280, 130);
		ghostButton.setBorderPainted(false);
		ghostButton.setContentAreaFilled(false);
		ghostButton.setFocusPainted(false);
		add(ghostButton);
		
		JButton powercookieButton = new JButton(powercookie);
		powercookieButton.setBounds(600, 350, 270, 130);
		powercookieButton.setBorderPainted(false);
		powercookieButton.setContentAreaFilled(false);
		powercookieButton.setFocusPainted(false);
		add(powercookieButton);
		
		setVisible(true);
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
