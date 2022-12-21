package PAC_MAN;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Main2 {
	private static final String Alpha = null;

	public Main2() {
		Game game = new Game();
		JFrame frame = new JFrame();
		frame.setTitle(Game.TITLE);
		
		JButton PACMANButton = new JButton("!!! Let's Go !!!");
		PACMANButton.setBounds(570, 270, 134, 80);
		PACMANButton.setBorderPainted(false);
		PACMANButton.setContentAreaFilled(false);
		frame.add(PACMANButton);
		
		frame.add(game);
		frame.setResizable(false);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		Timer time = new Timer();
		TimerTask timetask = new TimerTask() {
			public void run() {
				try {
					Ghost.speed = 2;
					SmartGhost.speed = 1;
	            	PACMANButton.setVisible(false);
	            } catch (Exception e) {
	                System.out.println(e.getMessage());
	            }
			}
		};
		time.schedule(timetask, 6500);
		game.start();
	}
}