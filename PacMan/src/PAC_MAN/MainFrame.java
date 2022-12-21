package PAC_MAN;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.BufferedInputStream;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JFrame;

public class MainFrame extends JFrame implements ComponentListener {
	private static final long serialVersionUID = 1L;
	private ImageIcon start = new ImageIcon("resource/start.jpg");
	private ImageIcon control = new ImageIcon("resource/control.jpg");
	private ImageIcon about = new ImageIcon("resource/about.jpg");
	private ImageIcon start1 = new ImageIcon("resource/start.jpg");
	private ImageIcon control1 = new ImageIcon("resource/control.jpg");
	private ImageIcon about1 = new ImageIcon("resource/about.jpg");
	private ImageIcon PACMAN = new ImageIcon("resource/PACMAN.jpg");
	private ImageIcon GAME = new ImageIcon("resource/gamestart.jpg");
	private ImageIcon SoundOn = new ImageIcon("resource/soundon.jpg");
	private ImageIcon SoundOn1 = new ImageIcon("resource/soundon.jpg");
	private ImageIcon SoundOff = new ImageIcon("resource/soundoff.jpg");
	private ImageIcon SoundOff1 = new ImageIcon("resource/soundoff.jpg");
	private ImageIcon Producer = new ImageIcon("resource/Producer.jpg");
	private ImageIcon Producer1 = new ImageIcon("resource/Producer.jpg");
	private ImageIcon About = new ImageIcon("resource/About.jpg");
	private ImageIcon About1 = new ImageIcon("resource/About.jpg");
	private Main main;
	private Game game = new Game();
	static Music1 runnable = new Music1();
	static Music2 runnable1 = new Music2();
	static Thread thread = new Thread(runnable);
	static Thread thread1 = new Thread(runnable1);
	
	public MainFrame() {
		setSize(1000, 700);                       // 화면 크기 설정
		setTitle("PAC MAN!");                     // 텍스트 타이틀 
		getContentPane().setLayout(null);
		getContentPane().setBackground(Color.BLACK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);                      //창의 크기를 변경하지 못하게
		setLocationRelativeTo(null);              //창이 가운데 나오게
		
		start1 = new ImageIcon(
				start1.getImage().getScaledInstance(300, 75, Image.SCALE_SMOOTH));
		control1 = new ImageIcon(
				control1.getImage().getScaledInstance(280, 70, Image.SCALE_SMOOTH));
		about1 = new ImageIcon(
				about1.getImage().getScaledInstance(200, 58, Image.SCALE_SMOOTH));
		SoundOn = new ImageIcon(
				SoundOn.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
		SoundOn1 = new ImageIcon(
				SoundOn1.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH));
		SoundOff = new ImageIcon(
				SoundOff.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
		SoundOff1 = new ImageIcon(
				SoundOff1.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH));
		GAME = new ImageIcon(
				GAME.getImage().getScaledInstance(650, 110, Image.SCALE_SMOOTH));
		Producer1 = new ImageIcon(
				Producer1.getImage().getScaledInstance(250, 70, Image.SCALE_SMOOTH));
		About1 = new ImageIcon(
				About1.getImage().getScaledInstance(170, 70, Image.SCALE_SMOOTH));
		
		Timer time = new Timer();
		TimerTask timetask = new TimerTask() {
			public void run() {
				try {
	            	thread1.start();
	            } catch (Exception e) {
	                System.out.println(e.getMessage());
	            }
			}
		};

		JButton PACMANButton = new JButton(PACMAN);
		PACMANButton.setBounds(110, 20, 780, 150);
		PACMANButton.setBorderPainted(false);
		PACMANButton.setContentAreaFilled(false);
		PACMANButton.setFocusPainted(false);
		add(PACMANButton);
		
		JButton GAMEButton = new JButton(GAME);
		GAMEButton.setBounds(170, 200, 650, 110);
		GAMEButton.setBorderPainted(false);
		GAMEButton.setContentAreaFilled(false);
		GAMEButton.setFocusPainted(false);
		add(GAMEButton);
		
		JButton aboutButton = new JButton(About);
		aboutButton.setBounds(570, 450, 200, 70);
		aboutButton.setBorderPainted(false);
		aboutButton.setContentAreaFilled(false);
		aboutButton.setFocusPainted(false);
		aboutButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				EventQueue.invokeLater(() -> {
					var ex = new Game3();
					ex.setVisible(true);
				});
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				aboutButton.setIcon(About1);
				aboutButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				aboutButton.setIcon(About);
				aboutButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		add(aboutButton);
		
		JButton MadeButton = new JButton(Producer);   
		MadeButton.setBounds(520, 520, 300, 70);
		MadeButton.setBorderPainted(false);
		MadeButton.setContentAreaFilled(false);
		MadeButton.setFocusPainted(false);
		MadeButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				new Producer();
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				MadeButton.setIcon(Producer1);
				MadeButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				MadeButton.setIcon(Producer);
				MadeButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		add(MadeButton);  
		
		JButton startButton = new JButton(start);
		startButton.setBounds(200, 450, 305, 60);
		startButton.setBorderPainted(false);
		startButton.setContentAreaFilled(false);
		startButton.setFocusPainted(false);
		startButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				main.thread.stop();
				main.thread1.stop();
				new CharacterSelect();
				dispose();
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				startButton.setIcon(start1);
				startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				startButton.setIcon(start);
				startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		add(startButton);
		
		JButton controlButton = new JButton(control);
		controlButton.setBounds(210, 520, 270, 60);
		controlButton.setBorderPainted(false);
		controlButton.setContentAreaFilled(false);
		controlButton.setFocusPainted(false);
		controlButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				new Control();
				dispose();
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				controlButton.setIcon(control1);
				controlButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				controlButton.setIcon(control);
				controlButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		add(controlButton);
		
		JButton soundoffButton = new JButton(SoundOff);
		soundoffButton.setBounds(30, 580, 60, 60);
		soundoffButton.setBorderPainted(false);
		soundoffButton.setContentAreaFilled(false);
		soundoffButton.setFocusPainted(false);
		
		JButton soundonButton = new JButton(SoundOn);
		soundonButton.setBounds(30, 580, 60, 60);
		soundonButton.setBorderPainted(false);
		soundonButton.setContentAreaFilled(false);
		soundonButton.setFocusPainted(false);
		
		soundoffButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				soundoffButton.setVisible(false);
				soundonButton.setVisible(true);
				thread.start();
				time.schedule(timetask, 6500);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				soundoffButton.setIcon(SoundOff1);
				soundoffButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				soundoffButton.setIcon(SoundOff);
				soundoffButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});

		soundonButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				main.thread.stop();
				main.thread1.stop();
				soundonButton.setVisible(false);
				soundoffButton.setVisible(true);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				soundonButton.setIcon(SoundOn1);
				soundonButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				soundonButton.setIcon(SoundOn);
				soundonButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		add(soundonButton);
		add(soundoffButton);
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