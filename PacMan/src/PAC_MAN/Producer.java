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

public class Producer extends JFrame implements MouseListener {
	private ImageIcon name0 = new ImageIcon("resource/name0.jpg");
	private ImageIcon name1 = new ImageIcon("resource/name1.jpg");
	private ImageIcon name2 = new ImageIcon("resource/name2.jpg");
	private ImageIcon name3 = new ImageIcon("resource/name3.jpg");
	private ImageIcon number0 = new ImageIcon("resource/number0.jpg");
	private ImageIcon number1 = new ImageIcon("resource/number1.jpg");
	private ImageIcon number2 = new ImageIcon("resource/number2.jpg");
	private ImageIcon number3 = new ImageIcon("resource/number3.jpg");
	private ImageIcon PACMAN = new ImageIcon("resource/PACMAN.jpg");
	private ImageIcon Com = new ImageIcon("resource/Computer.jpg");
	
	
	public Producer() {
		
		setSize(1000, 700);                       // 화면 크기 설정
		setTitle("PAC MAN!");                     // 텍스트 타이틀 
		getContentPane().setLayout(null);
		getContentPane().setBackground(Color.BLACK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);                      //창의 크기를 변경하지 못하게 s
		setLocationRelativeTo(null);              //창이 가운데 나오게
		
		JButton PACMANButton = new JButton(PACMAN);
		PACMANButton.setBounds(110, 20, 780, 150);
		PACMANButton.setBorderPainted(false);
		PACMANButton.setContentAreaFilled(false);
		PACMANButton.setFocusPainted(false);
		add(PACMANButton);
		
		JButton ComButton = new JButton(Com);
		ComButton.setBounds(110, 170, 780, 150);
		ComButton.setBorderPainted(false);
		ComButton.setContentAreaFilled(false);
		ComButton.setFocusPainted(false);
		add(ComButton);
		
		// 이름
		
		JButton NameButton = new JButton(name0);
		NameButton.setBounds(300, 330, 120, 85);
		NameButton.setBorderPainted(false);
		NameButton.setContentAreaFilled(false);
		NameButton.setFocusPainted(false);
		add(NameButton);
		
		JButton Name1Button = new JButton(name1);
		Name1Button.setBounds(300, 430, 120, 85);
		Name1Button.setBorderPainted(false);
		Name1Button.setContentAreaFilled(false);
		Name1Button.setFocusPainted(false);
		add(Name1Button);
		
		JButton Name2Button = new JButton(name2);
		Name2Button.setBounds(700, 330, 120, 85);
		Name2Button.setBorderPainted(false);
		Name2Button.setContentAreaFilled(false);
		Name2Button.setFocusPainted(false);
		add(Name2Button);
		
		JButton Name3Button = new JButton(name3);
		Name3Button.setBounds(700, 430, 120, 85);
		Name3Button.setBorderPainted(false);
		Name3Button.setContentAreaFilled(false);
		Name3Button.setFocusPainted(false);
		add(Name3Button);
		
		// 학번
		
		JButton numberButton = new JButton(number0);
		numberButton.setBounds(150, 330, 150, 85);
		numberButton.setBorderPainted(false);
		numberButton.setContentAreaFilled(false);
		numberButton.setFocusPainted(false);
		add(numberButton);
		
		JButton number1Button = new JButton(number1);
		number1Button.setBounds(150, 430, 150, 85);
		number1Button.setBorderPainted(false);
		number1Button.setContentAreaFilled(false);
		number1Button.setFocusPainted(false);
		add(number1Button);
		
		JButton number2Button = new JButton(number2);
		number2Button.setBounds(550, 330, 150, 85);
		number2Button.setBorderPainted(false);
		number2Button.setContentAreaFilled(false);
		number2Button.setFocusPainted(false);
		add(number2Button);
		
		JButton number3Button = new JButton(number3);
		number3Button.setBounds(550, 430, 150, 85);
		number3Button.setBorderPainted(false);
		number3Button.setContentAreaFilled(false);
		number3Button.setFocusPainted(false);
		add(number3Button);
		
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