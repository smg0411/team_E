package PAC_MAN;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class CharacterSelect extends JFrame {
	private ImageIcon PACMAN = new ImageIcon("resource/PACMAN.jpg");
	private ImageIcon Pacman = new ImageIcon("resource/PACMAN1234.png");
	private ImageIcon Pacman1 = new ImageIcon("resource/PACMAN1234.png");
	private ImageIcon Pacman2 = new ImageIcon("resource/PACMAN1234.png");
	private ImageIcon Womanpacman = new ImageIcon("resource/womanpacman.png");
	private ImageIcon Womanpacman1 = new ImageIcon("resource/womanpacman.png");
	private ImageIcon Womanpacman2 = new ImageIcon("resource/womanpacman.png");
	private ImageIcon Turbopacman = new ImageIcon("resource/turbopacman.png");
	private ImageIcon Turbopacman1 = new ImageIcon("resource/turbopacman.png");
	private ImageIcon Turbopacman2 = new ImageIcon("resource/turbopacman.png");
	private ImageIcon Cookiepacman = new ImageIcon("resource/cookiepacman.png");
	private ImageIcon Cookiepacman1 = new ImageIcon("resource/cookiepacman.png");
	private ImageIcon Cookiepacman2 = new ImageIcon("resource/cookiepacman.png");
	private ImageIcon Scaredpacman = new ImageIcon("resource/scaredpacman.png");
	private ImageIcon Scaredpacman1 = new ImageIcon("resource/scaredpacman.png");
	private ImageIcon Scaredpacman2 = new ImageIcon("resource/scaredpacman.png");
	private ImageIcon Smallpacman = new ImageIcon("resource/PACMAN1234.png");
	private ImageIcon Smallpacman1 = new ImageIcon("resource/PACMAN1234.png");
	private ImageIcon Smallpacman2 = new ImageIcon("resource/PACMAN1234.png");
	private ImageIcon Dogpacman = new ImageIcon("resource/dogpacman.png");
	private ImageIcon Dogpacman1 = new ImageIcon("resource/dogpacman.png");
	private ImageIcon Dogpacman2 = new ImageIcon("resource/dogpacman.png");
	private ImageIcon Sonpacman = new ImageIcon("resource/sonpacman.png");
	private ImageIcon Sonpacman1 = new ImageIcon("resource/sonpacman.png");
	private ImageIcon Sonpacman2 = new ImageIcon("resource/sonpacman.png");
	private ImageIcon Ghostpacman = new ImageIcon("resource/ghostpacman.png");
	private ImageIcon Ghostpacman1 = new ImageIcon("resource/ghostpacman.png");
	private ImageIcon Ghostpacman2 = new ImageIcon("resource/ghostpacman.png");
	private ImageIcon start = new ImageIcon("resource/start.jpg");
	private ImageIcon start1 = new ImageIcon("resource/start.jpg");
	public static int CharacterMode = 1;
	public static Appearance appearance9;
	
	public CharacterSelect() {
		setSize(1000, 700);                       // 화면 크기 설정
		setTitle("PAC MAN!");                     // 텍스트 타이틀 
		getContentPane().setLayout(null);
		getContentPane().setBackground(Color.BLACK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);                      //창의 크기를 변경하지 못하게
		setLocationRelativeTo(null);  //창이 가운데 나오게
		
		Pacman = new ImageIcon(
				Pacman.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH));
		Pacman1 = new ImageIcon(
				Pacman1.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
		Pacman2 = new ImageIcon(
				Pacman2.getImage().getScaledInstance(350, 300, Image.SCALE_SMOOTH));
		Womanpacman = new ImageIcon(
				Womanpacman.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH));
		Womanpacman1 = new ImageIcon(
				Womanpacman1.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
		Womanpacman2 = new ImageIcon(
				Womanpacman2.getImage().getScaledInstance(350, 300, Image.SCALE_SMOOTH));
		Turbopacman = new ImageIcon(
				Turbopacman.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH));
		Turbopacman1 = new ImageIcon(
				Turbopacman1.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
		Turbopacman2 = new ImageIcon(
				Turbopacman2.getImage().getScaledInstance(350, 300, Image.SCALE_SMOOTH));
		Cookiepacman = new ImageIcon(
				Cookiepacman.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH));
		Cookiepacman1 = new ImageIcon(
				Cookiepacman1.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
		Cookiepacman2 = new ImageIcon(
				Cookiepacman2.getImage().getScaledInstance(350, 300, Image.SCALE_SMOOTH));
		Scaredpacman = new ImageIcon(
				Scaredpacman.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH));
		Scaredpacman1 = new ImageIcon(
				Scaredpacman1.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
		Scaredpacman2 = new ImageIcon(
				Scaredpacman2.getImage().getScaledInstance(350, 300, Image.SCALE_SMOOTH));
		Smallpacman = new ImageIcon(
				Smallpacman.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
		Smallpacman1 = new ImageIcon(
				Smallpacman1.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
		Smallpacman2 = new ImageIcon(
				Smallpacman2.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
		Dogpacman = new ImageIcon(
				Dogpacman.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH));
		Dogpacman1 = new ImageIcon(
				Dogpacman1.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
		Dogpacman2 = new ImageIcon(
				Dogpacman2.getImage().getScaledInstance(350, 300, Image.SCALE_SMOOTH));
		Sonpacman = new ImageIcon(
				Sonpacman.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH));
		Sonpacman1 = new ImageIcon(
				Sonpacman1.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
		Sonpacman2 = new ImageIcon(
				Sonpacman2.getImage().getScaledInstance(350, 300, Image.SCALE_SMOOTH));
		Ghostpacman = new ImageIcon(
				Ghostpacman.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH));
		Ghostpacman1 = new ImageIcon(
				Ghostpacman1.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
		Ghostpacman2 = new ImageIcon(
				Ghostpacman2.getImage().getScaledInstance(350, 300, Image.SCALE_SMOOTH));
		start1 = new ImageIcon(
				start1.getImage().getScaledInstance(300, 75, Image.SCALE_SMOOTH));
		
		JButton PACMANButton = new JButton(PACMAN);
		PACMANButton.setBounds(110, 20, 780, 150);
		PACMANButton.setBorderPainted(false);
		PACMANButton.setContentAreaFilled(false);
		PACMANButton.setFocusPainted(false);
		add(PACMANButton);
		
		JButton selectButton = new JButton("Select Character");
		selectButton.setBounds(140, 220, 350, 300);
		selectButton.setForeground(Color.white);
		selectButton.setFont(new Font(Font.DIALOG, Font.BOLD, 35));
		selectButton.setContentAreaFilled(false);
		selectButton.setBorderPainted(false);
		selectButton.setFocusPainted(false);
		selectButton.setVisible(true);
		add(selectButton);
		
		JButton subButton = new JButton("Pacman");
		subButton.setBounds(180, 520, 350, 50);
		subButton.setForeground(Color.white);
		subButton.setFont(new Font(Font.DIALOG, Font.BOLD, 35));
		subButton.setBorderPainted(false);
		subButton.setContentAreaFilled(false);
		subButton.setFocusPainted(false);
		subButton.setVisible(false);
		add(subButton);
		
		JButton subButton2 = new JButton("Pacman's Woman");
		subButton2.setBounds(180, 520, 350, 50);
		subButton2.setForeground(Color.white);
		subButton2.setFont(new Font(Font.DIALOG, Font.BOLD, 35));
		subButton2.setBorderPainted(false);
		subButton2.setContentAreaFilled(false);
		subButton2.setFocusPainted(false);
		subButton2.setVisible(false);
		add(subButton2);
		
		JButton subButton3 = new JButton("Cookie");
		subButton3.setBounds(180, 520, 350, 50);
		subButton3.setForeground(Color.white);
		subButton3.setFont(new Font(Font.DIALOG, Font.BOLD, 35));
		subButton3.setBorderPainted(false);
		subButton3.setContentAreaFilled(false);
		subButton3.setFocusPainted(false);
		subButton3.setVisible(false);
		add(subButton3);
		
		JButton subButton4 = new JButton("Turbo");
		subButton4.setBounds(180, 520, 350, 50);
		subButton4.setForeground(Color.white);
		subButton4.setFont(new Font(Font.DIALOG, Font.BOLD, 35));
		subButton4.setBorderPainted(false);
		subButton4.setContentAreaFilled(false);
		subButton4.setFocusPainted(false);
		subButton4.setVisible(false);
		add(subButton4);
		
		JButton subButton5 = new JButton("ScaredPacman");
		subButton5.setBounds(180, 520, 350, 50);
		subButton5.setForeground(Color.white);
		subButton5.setFont(new Font(Font.DIALOG, Font.BOLD, 35));
		subButton5.setBorderPainted(false);
		subButton5.setContentAreaFilled(false);
		subButton5.setFocusPainted(false);
		subButton5.setVisible(false);
		add(subButton5);
		
		JButton subButton6 = new JButton("GhostPacman");
		subButton6.setBounds(180, 520, 350, 50);
		subButton6.setForeground(Color.white);
		subButton6.setFont(new Font(Font.DIALOG, Font.BOLD, 35));
		subButton6.setBorderPainted(false);
		subButton6.setContentAreaFilled(false);
		subButton6.setFocusPainted(false);
		subButton6.setVisible(false);
		add(subButton6);
		
		JButton subButton7 = new JButton("ChildPacman");
		subButton7.setBounds(180, 520, 350, 50);
		subButton7.setForeground(Color.white);
		subButton7.setFont(new Font(Font.DIALOG, Font.BOLD, 35));
		subButton7.setBorderPainted(false);
		subButton7.setContentAreaFilled(false);
		subButton7.setFocusPainted(false);
		subButton7.setVisible(false);
		add(subButton7);
		
		JButton subButton8 = new JButton("DogPacman");
		subButton8.setBounds(180, 520, 350, 50);
		subButton8.setForeground(Color.white);
		subButton8.setFont(new Font(Font.DIALOG, Font.BOLD, 35));
		subButton8.setBorderPainted(false);
		subButton8.setContentAreaFilled(false);
		subButton8.setFocusPainted(false);
		subButton8.setVisible(false);
		add(subButton8);
		
		JButton subButton9 = new JButton("SonPacman");
		subButton9.setBounds(180, 520, 350, 50);
		subButton9.setForeground(Color.white);
		subButton9.setFont(new Font(Font.DIALOG, Font.BOLD, 35));
		subButton9.setBorderPainted(false);
		subButton9.setContentAreaFilled(false);
		subButton9.setFocusPainted(false);
		subButton9.setVisible(false);
		add(subButton9);
		
		JButton select1Button = new JButton(Pacman2);
		select1Button.setBounds(180, 220, 350, 300);
		select1Button.setBorderPainted(false);
		select1Button.setContentAreaFilled(false);
		select1Button.setFocusPainted(false);
		select1Button.setVisible(false);
		add(select1Button);
		
		JButton select2Button = new JButton(Womanpacman2);
		select2Button.setBounds(180, 220, 350, 300);
		select2Button.setBorderPainted(false);
		select2Button.setContentAreaFilled(false);
		select2Button.setFocusPainted(false);
		select2Button.setVisible(false);
		add(select2Button);
		
		JButton select3Button = new JButton(Cookiepacman2);
		select3Button.setBounds(180, 220, 350, 300);
		select3Button.setBorderPainted(false);
		select3Button.setContentAreaFilled(false);
		select3Button.setFocusPainted(false);
		select3Button.setVisible(false);
		add(select3Button);
		
		JButton select4Button = new JButton(Turbopacman2);
		select4Button.setBounds(180, 220, 350, 300);
		select4Button.setBorderPainted(false);
		select4Button.setContentAreaFilled(false);
		select4Button.setFocusPainted(false);
		select4Button.setVisible(false);
		add(select4Button);
		
		JButton select5Button = new JButton(Scaredpacman2);
		select5Button.setBounds(180, 220, 350, 300);
		select5Button.setBorderPainted(false);
		select5Button.setContentAreaFilled(false);
		select5Button.setFocusPainted(false);
		select5Button.setVisible(false);
		add(select5Button);
		
		JButton select6Button = new JButton(Ghostpacman2);
		select6Button.setBounds(180, 220, 350, 300);
		select6Button.setBorderPainted(false);
		select6Button.setContentAreaFilled(false);
		select6Button.setFocusPainted(false);
		select6Button.setVisible(false);
		add(select6Button);
		
		JButton select7Button = new JButton(Smallpacman2);
		select7Button.setBounds(180, 220, 350, 300);
		select7Button.setBorderPainted(false);
		select7Button.setContentAreaFilled(false);
		select7Button.setFocusPainted(false);
		select7Button.setVisible(false);
		add(select7Button);
		
		JButton select8Button = new JButton(Dogpacman2);
		select8Button.setBounds(180, 220, 350, 300);
		select8Button.setBorderPainted(false);
		select8Button.setContentAreaFilled(false);
		select8Button.setFocusPainted(false);
		select8Button.setVisible(false);
		add(select8Button);
		
		JButton select9Button = new JButton(Sonpacman2);
		select9Button.setBounds(180, 220, 350, 300);
		select9Button.setBorderPainted(false);
		select9Button.setContentAreaFilled(false);
		select9Button.setFocusPainted(false);
		select9Button.setVisible(false);
		add(select9Button);
		
		JButton PacmanButton = new JButton(Pacman);
		PacmanButton.setBounds(600, 220, 100, 100);
		PacmanButton.setBorderPainted(false);
		PacmanButton.setContentAreaFilled(false);
		PacmanButton.setFocusPainted(false);
		PacmanButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				selectButton.setVisible(false);
				select1Button.setVisible(true);
				select2Button.setVisible(false);
				select3Button.setVisible(false);
				select4Button.setVisible(false);
				select5Button.setVisible(false);
				select6Button.setVisible(false);
				select7Button.setVisible(false);
				select8Button.setVisible(false);
				select9Button.setVisible(false);
				subButton.setVisible(true);
				subButton2.setVisible(false);
				subButton3.setVisible(false);
				subButton4.setVisible(false);
				subButton5.setVisible(false);
				subButton6.setVisible(false);
				subButton7.setVisible(false);
				subButton8.setVisible(false);
				subButton9.setVisible(false);
				CharacterMode = 1;
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				PacmanButton.setIcon(Pacman1);
				PacmanButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				PacmanButton.setIcon(Pacman);
				PacmanButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		add(PacmanButton);
		
		JButton WomanButton = new JButton(Womanpacman);
		WomanButton.setBounds(720, 220, 100, 100);
		WomanButton.setBorderPainted(false);
		WomanButton.setContentAreaFilled(false);
		WomanButton.setFocusPainted(false);
		WomanButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				selectButton.setVisible(false);
				select1Button.setVisible(false);
				select2Button.setVisible(true);
				select3Button.setVisible(false);
				select4Button.setVisible(false);
				select5Button.setVisible(false);
				select6Button.setVisible(false);
				select7Button.setVisible(false);
				select8Button.setVisible(false);
				select9Button.setVisible(false);
				subButton.setVisible(false);
				subButton2.setVisible(true);
				subButton3.setVisible(false);
				subButton4.setVisible(false);
				subButton5.setVisible(false);
				subButton6.setVisible(false);
				subButton7.setVisible(false);
				subButton8.setVisible(false);
				subButton9.setVisible(false);
				CharacterMode = 2;
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				WomanButton.setIcon(Womanpacman1);
				WomanButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				WomanButton.setIcon(Womanpacman);
				WomanButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		add(WomanButton);
		
		JButton CookieButton = new JButton(Cookiepacman);
		CookieButton.setBounds(840, 220, 100, 100);
		CookieButton.setBorderPainted(false);
		CookieButton.setContentAreaFilled(false);
		CookieButton.setFocusPainted(false);
		CookieButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				selectButton.setVisible(false);
				select1Button.setVisible(false);
				select2Button.setVisible(false);
				select3Button.setVisible(true);
				select4Button.setVisible(false);
				select5Button.setVisible(false);
				select6Button.setVisible(false);
				select7Button.setVisible(false);
				select8Button.setVisible(false);
				select9Button.setVisible(false);
				subButton.setVisible(false);
				subButton2.setVisible(false);
				subButton3.setVisible(true);
				subButton4.setVisible(false);
				subButton5.setVisible(false);
				subButton6.setVisible(false);
				subButton7.setVisible(false);
				subButton8.setVisible(false);
				subButton9.setVisible(false);
				CharacterMode = 3;
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				CookieButton.setIcon(Cookiepacman1);
				CookieButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				CookieButton.setIcon(Cookiepacman);
				CookieButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		add(CookieButton);
		
		JButton TuboButton = new JButton(Turbopacman);
		TuboButton.setBounds(600, 340, 100, 100);
		TuboButton.setBorderPainted(false);
		TuboButton.setContentAreaFilled(false);
		TuboButton.setFocusPainted(false);
		TuboButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				selectButton.setVisible(false);
				select1Button.setVisible(false);
				select2Button.setVisible(false);
				select3Button.setVisible(false);
				select4Button.setVisible(true);
				select5Button.setVisible(false);
				select6Button.setVisible(false);
				select7Button.setVisible(false);
				select8Button.setVisible(false);
				select9Button.setVisible(false);
				subButton.setVisible(false);
				subButton2.setVisible(false);
				subButton3.setVisible(false);
				subButton4.setVisible(true);
				subButton5.setVisible(false);
				subButton6.setVisible(false);
				subButton7.setVisible(false);
				subButton8.setVisible(false);
				subButton9.setVisible(false);
				CharacterMode = 4;
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				TuboButton.setIcon(Turbopacman1);
				TuboButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				TuboButton.setIcon(Turbopacman);
				TuboButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		add(TuboButton);
		
		JButton ScaredButton = new JButton(Scaredpacman);
		ScaredButton.setBounds(720, 340, 100, 100);
		ScaredButton.setBorderPainted(false);
		ScaredButton.setContentAreaFilled(false);
		ScaredButton.setFocusPainted(false);
		ScaredButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				selectButton.setVisible(false);
				select1Button.setVisible(false);
				select2Button.setVisible(false);
				select3Button.setVisible(false);
				select4Button.setVisible(false);
				select5Button.setVisible(true);
				select6Button.setVisible(false);
				select7Button.setVisible(false);
				select8Button.setVisible(false);
				select9Button.setVisible(false);
				subButton.setVisible(false);
				subButton2.setVisible(false);
				subButton3.setVisible(false);
				subButton4.setVisible(false);
				subButton5.setVisible(true);
				subButton6.setVisible(false);
				subButton7.setVisible(false);
				subButton8.setVisible(false);
				subButton9.setVisible(false);
				CharacterMode = 5;
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				ScaredButton.setIcon(Scaredpacman1);
				ScaredButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				ScaredButton.setIcon(Scaredpacman);
				ScaredButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		add(ScaredButton);
		
		JButton GhostButton = new JButton(Ghostpacman);
		GhostButton.setBounds(840, 340, 100, 100);
		GhostButton.setBorderPainted(false);
		GhostButton.setContentAreaFilled(false);
		GhostButton.setFocusPainted(false);
		GhostButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				selectButton.setVisible(false);
				select1Button.setVisible(false);
				select2Button.setVisible(false);
				select3Button.setVisible(false);
				select4Button.setVisible(false);
				select5Button.setVisible(false);
				select6Button.setVisible(true);
				select7Button.setVisible(false);
				select8Button.setVisible(false);
				select9Button.setVisible(false);
				subButton.setVisible(false);
				subButton2.setVisible(false);
				subButton3.setVisible(false);
				subButton4.setVisible(false);
				subButton5.setVisible(false);
				subButton6.setVisible(true);
				subButton7.setVisible(false);
				subButton8.setVisible(false);
				subButton9.setVisible(false);
				CharacterMode = 6;
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				GhostButton.setIcon(Ghostpacman1);
				GhostButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				GhostButton.setIcon(Ghostpacman);
				GhostButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		add(GhostButton);
		
		JButton smallpacmanButton = new JButton(Smallpacman);
		smallpacmanButton.setBounds(600, 460, 100, 100);
		smallpacmanButton.setBorderPainted(false);
		smallpacmanButton.setContentAreaFilled(false);
		smallpacmanButton.setFocusPainted(false);
		smallpacmanButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				selectButton.setVisible(false);
				select1Button.setVisible(false);
				select2Button.setVisible(false);
				select3Button.setVisible(false);
				select4Button.setVisible(false);
				select5Button.setVisible(false);
				select6Button.setVisible(false);
				select7Button.setVisible(true);
				select8Button.setVisible(false);
				select9Button.setVisible(false);
				subButton.setVisible(false);
				subButton2.setVisible(false);
				subButton3.setVisible(false);
				subButton4.setVisible(false);
				subButton5.setVisible(false);
				subButton6.setVisible(false);
				subButton7.setVisible(true);
				subButton8.setVisible(false);
				subButton9.setVisible(false);
				CharacterMode = 7;
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				smallpacmanButton.setIcon(Smallpacman1);
				smallpacmanButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				smallpacmanButton.setIcon(Smallpacman);
				smallpacmanButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		add(smallpacmanButton);
		
		JButton dogButton = new JButton(Dogpacman);
		dogButton.setBounds(720, 460, 100, 100);
		dogButton.setBorderPainted(false);
		dogButton.setContentAreaFilled(false);
		dogButton.setFocusPainted(false);
		dogButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				selectButton.setVisible(false);
				select1Button.setVisible(false);
				select2Button.setVisible(false);
				select3Button.setVisible(false);
				select4Button.setVisible(false);
				select5Button.setVisible(false);
				select6Button.setVisible(false);
				select7Button.setVisible(false);
				select8Button.setVisible(true);
				select9Button.setVisible(false);
				subButton.setVisible(false);
				subButton2.setVisible(false);
				subButton3.setVisible(false);
				subButton4.setVisible(false);
				subButton5.setVisible(false);
				subButton6.setVisible(false);
				subButton7.setVisible(false);
				subButton8.setVisible(true);
				subButton9.setVisible(false);
				CharacterMode = 8;
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				dogButton.setIcon(Dogpacman1);
				dogButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				dogButton.setIcon(Dogpacman);
				dogButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		add(dogButton);
		
		JButton SonButton = new JButton(Sonpacman);
		SonButton.setBounds(840, 460, 100, 100);
		SonButton.setBorderPainted(false);
		SonButton.setContentAreaFilled(false);
		SonButton.setFocusPainted(false);
		SonButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				selectButton.setVisible(false);
				select1Button.setVisible(false);
				select2Button.setVisible(false);
				select3Button.setVisible(false);
				select4Button.setVisible(false);
				select5Button.setVisible(false);
				select6Button.setVisible(false);
				select7Button.setVisible(false);
				select8Button.setVisible(false);
				select9Button.setVisible(true);
				subButton.setVisible(false);
				subButton2.setVisible(false);
				subButton3.setVisible(false);
				subButton4.setVisible(false);
				subButton5.setVisible(false);
				subButton6.setVisible(false);
				subButton7.setVisible(false);
				subButton8.setVisible(false);
				subButton9.setVisible(true);
				CharacterMode = 9;
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				SonButton.setIcon(Sonpacman1);
				SonButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				SonButton.setIcon(Sonpacman);
				SonButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		add(SonButton);
		
		JButton BackButton = new JButton("Back");
		BackButton.setFont(new Font(Font.DIALOG, Font.BOLD, 25));
		BackButton.setForeground(Color.white);
		BackButton.setBounds(30, 580, 120, 60);
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
		
		JButton NextButton = new JButton(start);
		NextButton.setBounds(670, 580, 305, 60);
		NextButton.setContentAreaFilled(false);
		NextButton.setBorderPainted(false);
		NextButton.setFocusPainted(false);
		NextButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				Game.STATE = Game.START1;
				new Main2();
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				NextButton.setIcon(start1);
				NextButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				NextButton.setIcon(start);
				NextButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		add(NextButton);
		setVisible(true);
	}
}