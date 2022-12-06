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
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JFrame;

import javazoom.jl.player.Player;

public class MainFrame extends JFrame implements ComponentListener {
	private static final long serialVersionUID = 1L;
	private Screen screen;
	private ImageIcon start = new ImageIcon("resource/start.jpg");
	private ImageIcon control = new ImageIcon("resource/control.jpg");
	private ImageIcon start1 = new ImageIcon("resource/start.jpg");
	private ImageIcon control1 = new ImageIcon("resource/control.jpg");
	private ImageIcon PACMAN = new ImageIcon("resource/PACMAN.jpg");
	
	public MainFrame() {
		this.screen = new Screen();
		Timer time = new Timer();
		TimerTask timetask = new TimerTask() {
			public void run() {
				bgplay1();
			}
		};
		
		add(screen);
		
		setSize(1000, 700);                       // 화면 크기 설정
		setTitle("PAC MAN!");                     // 텍스트 타이틀 
		getContentPane().setLayout(null);
		getContentPane().setBackground(Color.BLACK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);                      //창의 크기를 변경하지 못하게 s
		setLocationRelativeTo(null);              //창이 가운데 나오게
		
		start1 = new ImageIcon(
				start1.getImage().getScaledInstance(300, 75, Image.SCALE_SMOOTH));
		control1 = new ImageIcon(
				control1.getImage().getScaledInstance(280, 70, Image.SCALE_SMOOTH));
		
		JButton PACMANButton = new JButton(PACMAN);
		PACMANButton.setBounds(110, 20, 780, 150);
		PACMANButton.setBorderPainted(false);
		PACMANButton.setContentAreaFilled(false);
		PACMANButton.setFocusPainted(false);
		add(PACMANButton);
		
		JButton startButton = new JButton(start);
		startButton.setBounds(348, 490, 305, 60);
		startButton.setBorderPainted(false);
		startButton.setContentAreaFilled(false);
		startButton.setFocusPainted(false);
		startButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
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
		controlButton.setBounds(365, 560, 270, 60);
		controlButton.setBorderPainted(false);
		controlButton.setContentAreaFilled(false);
		controlButton.setFocusPainted(false);
		controlButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				new Control();
				setVisible(false);
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
		
		setVisible(true);
		bgplay();
		time.schedule(timetask, 6000);
	}
	
	public void bgplay() {
		Player jlPlayer = null;
        try {
            FileInputStream fileInputStream = new FileInputStream("resource/PacMan.mp3");
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
            jlPlayer = new Player(bufferedInputStream);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        final Player player = jlPlayer;
        new Thread() {
            public void run() {
                try {
                	player.play();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }.start();
    }
	
	public void bgplay1() {
		Player jlPlayer2 = null;
        try {
            FileInputStream fileInputStream1 = new FileInputStream("resource/PacMan20.mp3");
            BufferedInputStream bufferedInputStream1 = new BufferedInputStream(fileInputStream1);
            jlPlayer2 = new Player(bufferedInputStream1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        final Player player = jlPlayer2;
        new Thread() {
            public void run() {
                try {
                	player.play();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }.start();
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
