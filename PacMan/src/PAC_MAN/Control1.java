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

public class Control1 extends JFrame implements MouseListener {
	private ImageIcon PACMAN = new ImageIcon("resource/PACMAN.jpg");
	private ImageIcon Left = new ImageIcon("resource/Left.jpg");
	private ImageIcon Right = new ImageIcon("resource/Right.jpg");
	private ImageIcon Left1 = new ImageIcon("resource/Left.jpg");
	private ImageIcon Right1 = new ImageIcon("resource/Right.jpg");
	private ImageIcon Keyboard = new ImageIcon("resource/Keyboard.jpg");
	private ImageIcon heart =new ImageIcon("resource/heart.png");
	private ImageIcon cookies = new ImageIcon("resource/cookies.png");
	
	public Control1() {
		setSize(1000, 700);                       // 화면 크기 설정
		setTitle("PAC MAN!");                     // 텍스트 타이틀 
		getContentPane().setLayout(null);
		getContentPane().setBackground(Color.BLACK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);                      //창의 크기를 변경하지 못하게 s
		setLocationRelativeTo(null);              //창이 가운데 나오게
		Left = new ImageIcon(
				Left.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
		Right = new ImageIcon(
				Right.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
		Left1 = new ImageIcon(
				Left1.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH));
		Right1 = new ImageIcon(
				Right1.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH));
		Keyboard = new ImageIcon(
				Keyboard.getImage().getScaledInstance(190, 150, Image.SCALE_SMOOTH));
		cookies = new ImageIcon(
				cookies.getImage().getScaledInstance(100, 80, Image.SCALE_SMOOTH));
		
		JButton PACMANButton = new JButton(PACMAN);
		PACMANButton.setBounds(110, 20, 780, 150);
		PACMANButton.setBorderPainted(false);
		PACMANButton.setContentAreaFilled(false);
		PACMANButton.setFocusPainted(false);
		add(PACMANButton);
	      
		JButton KeyButton = new JButton(Keyboard);
		KeyButton.setBounds(130, 190, 190, 150);
		KeyButton.setBorderPainted(false);
		KeyButton.setContentAreaFilled(false);
		KeyButton.setFocusPainted(false);
		add(KeyButton);
		
		JButton Key1Button = new JButton("키보드 방향키로 팩맨을 움직입니다.");
		Key1Button.setBounds(330, 230, 400, 100);
		Key1Button.setForeground(Color.white);
		Key1Button.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		Key1Button.setBorderPainted(false);
		Key1Button.setContentAreaFilled(false);
		Key1Button.setFocusPainted(false);
		add(Key1Button);
		
		JButton heartButton = new JButton(heart);
		heartButton.setBounds(180, 350, 100, 100);
		heartButton.setBorderPainted(false);
		heartButton.setContentAreaFilled(false);
		heartButton.setFocusPainted(false);
		add(heartButton);
		
		JButton heart1Button = new JButton("팩맨의 생명을 나타냅니다.");
		heart1Button.setBounds(350, 350, 280, 60);
		heart1Button.setForeground(Color.white);
		heart1Button.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		heart1Button.setBorderPainted(false);
		heart1Button.setContentAreaFilled(false);
		heart1Button.setFocusPainted(false);
		add(heart1Button);
		
		JButton scoreButton = new JButton("SCORE");
		scoreButton.setBounds(130, 440, 200, 80);
		scoreButton.setForeground(Color.white);
		scoreButton.setFont(new Font(Font.DIALOG, Font.BOLD, 30));
		scoreButton.setBorderPainted(false);
		scoreButton.setContentAreaFilled(false);
		scoreButton.setFocusPainted(false);
		add(scoreButton);
		
		JButton score1Button = new JButton("쿠키를 먹으면 점수가 올라갑니다.");
		score1Button.setBounds(270, 430, 500, 100);
		score1Button.setForeground(Color.white);
		score1Button.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		score1Button.setBorderPainted(false);
		score1Button.setContentAreaFilled(false);
		score1Button.setFocusPainted(false);
		add(score1Button);
	      
		JButton RightButton = new JButton(Right);
		RightButton.setBounds(490, 520, 60, 60);
		RightButton.setBorderPainted(false);
		RightButton.setContentAreaFilled(false);
		RightButton.setFocusPainted(false);
		RightButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
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
	    LeftButton.setBounds(430, 520, 60, 60);
	    LeftButton.setBorderPainted(false);
	    LeftButton.setContentAreaFilled(false);
	    LeftButton.setFocusPainted(false);
	    LeftButton.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mousePressed(MouseEvent e) {
	    		new Control();
	    		dispose();
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
	    BackButton.setBounds(430, 570, 120, 60);
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