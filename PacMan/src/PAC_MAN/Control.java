package PAC_MAN;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Control extends JFrame implements MouseListener {
	private ImageIcon me = new ImageIcon("resource/me.png");
	private ImageIcon cookie = new ImageIcon("resource/cookie.jpg");
	private ImageIcon cookies = new ImageIcon("resource/cookies.png");
	private ImageIcon ghost = new ImageIcon("resource/ghost20.png");
	private ImageIcon ghost1 = new ImageIcon("resource/RedGhost3.png");
	private ImageIcon powercookie = new ImageIcon("resource/powercookie.png");
	private ImageIcon powercookies = new ImageIcon("resource/powercookies.png");
	private ImageIcon PACMAN = new ImageIcon("resource/PACMAN.jpg");
	private ImageIcon pacman = new ImageIcon("resource/left.gif");
	private ImageIcon Left = new ImageIcon("resource/Left.jpg");
	private ImageIcon Right = new ImageIcon("resource/Right.jpg");
	private ImageIcon Left1 = new ImageIcon("resource/Left.jpg");
	private ImageIcon Right1 = new ImageIcon("resource/Right.jpg");

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
		cookies = new ImageIcon(
				cookies.getImage().getScaledInstance(120, 85, Image.SCALE_SMOOTH));
		ghost = new ImageIcon(
				ghost.getImage().getScaledInstance(280, 130, Image.SCALE_SMOOTH));
		powercookie = new ImageIcon(
				powercookie.getImage().getScaledInstance(270, 130, Image.SCALE_SMOOTH));
		powercookies = new ImageIcon(
				powercookies.getImage().getScaledInstance(70, 60, Image.SCALE_SMOOTH));
		Left = new ImageIcon(
				Left.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
		Right = new ImageIcon(
				Right.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
		Left1 = new ImageIcon(
				Left1.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH));
		Right1 = new ImageIcon(
				Right1.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH));

		JButton PACMANButton = new JButton(PACMAN);
		PACMANButton.setBounds(110, 20, 780, 150);
		PACMANButton.setBorderPainted(false);
		PACMANButton.setContentAreaFilled(false);
		PACMANButton.setFocusPainted(false);
		add(PACMANButton);
		
		JButton pacman1Button = new JButton(pacman);
		pacman1Button.setBounds(110, 210, 30, 30);
		pacman1Button.setBorderPainted(false);
		pacman1Button.setContentAreaFilled(false);
		pacman1Button.setFocusPainted(false);
		add(pacman1Button);
		
		JButton pacmanButton = new JButton(me);
		pacmanButton.setBounds(170, 190, 150, 80);
		pacmanButton.setBorderPainted(false);
		pacmanButton.setContentAreaFilled(false);
		pacmanButton.setFocusPainted(false);
		add(pacmanButton);
		
		JButton cookiesButton = new JButton(cookies);
		cookiesButton.setBounds(470, 200, 120, 85);
		cookiesButton.setBorderPainted(false);
		cookiesButton.setContentAreaFilled(false);
		cookiesButton.setFocusPainted(false);
		add(cookiesButton);
		
		JButton cookieButton = new JButton(cookie);
		cookieButton.setBounds(600, 190, 290, 100);
		cookieButton.setBorderPainted(false);
		cookieButton.setContentAreaFilled(false);
		cookieButton.setFocusPainted(false);
		add(cookieButton);
		
		JButton ghost1Button = new JButton(ghost1);
		ghost1Button.setBounds(100, 370, 55, 55);
		ghost1Button.setBorderPainted(false);
		ghost1Button.setContentAreaFilled(false);
		ghost1Button.setFocusPainted(false);
		add(ghost1Button);
		
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
		
		JButton powercookiesButton = new JButton(powercookies);
		powercookiesButton.setBounds(500, 370, 70, 60);
		powercookiesButton.setBorderPainted(false);
		powercookiesButton.setContentAreaFilled(false);
		powercookiesButton.setFocusPainted(false);
		add(powercookiesButton);
		
		JButton RightButton = new JButton(Right);
		RightButton.setBounds(490, 500, 60, 60);
		RightButton.setBorderPainted(false);
		RightButton.setContentAreaFilled(false);
		RightButton.setFocusPainted(false);
		RightButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				new Control1();
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				RightButton.setIcon(Right1);
				RightButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				RightButton.setIcon(Right);
				RightButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		add(RightButton);
	      
		JButton LeftButton = new JButton(Left);
		LeftButton.setBounds(430, 500, 60, 60);
		LeftButton.setBorderPainted(false);
		LeftButton.setContentAreaFilled(false);
		LeftButton.setFocusPainted(false);
		LeftButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				LeftButton.setIcon(Left1);
				LeftButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				LeftButton.setIcon(Left);
				LeftButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		add(LeftButton);

		JButton BackButton = new JButton("Back");
		BackButton.setFont(new Font(Font.DIALOG, Font.BOLD, 25));
		BackButton.setForeground(Color.white);
		BackButton.setBounds(430, 550, 120, 60);
		BackButton.setContentAreaFilled(false);
		BackButton.setBorderPainted(false);
		BackButton.setFocusPainted(false);
		BackButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				new MainFrame();
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				BackButton.setFont(new Font(Font.DIALOG, Font.BOLD, 35));
				BackButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				BackButton.setFont(new Font(Font.DIALOG, Font.BOLD, 25));
				BackButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		add(BackButton);
		setVisible(true);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}