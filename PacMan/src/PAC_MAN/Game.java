package PAC_MAN;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Game extends Canvas implements Runnable,KeyListener{
	static Music1 runnable = new Music1();
	static Music2 runnable1 = new Music2();
	static Thread Thread = new Thread(runnable);
	static Thread Thread1 = new Thread(runnable1);
	private boolean isRunning = false;
	
	public static final int WIDTH = 1280;
	public static final int HEIGHT = 900;
	public static final String TITLE = "Pacman";
	
	private Thread thread;
	
	public static Map map;
	
	public static Pacman pacman;
	public static Pacman_Woman womanpacman;
	public static Pacman_Cookie cookiepacman;
	public static Pacman_Turbo turbopacman;
	public static Pacman_Scared scaredpacman;
	public static Pacman_Ghost ghostpacman;
	public static Pacman_Child childpacman;
	public static Pacman_Dog dogpacman;
	public static Pacman_Sonny sonnypacman;
	
	public static Appearance appearance;
	public static Appearance appearance2;
	public static Appearance appearance3;
	public static Appearance appearance4;
	public static Appearance appearance5;
	public static Appearance appearance6;

	public static Appearance appearance8;
	public static Appearance appearance9;
	
	public static Score score;
	public static Image heart;

	public static final int START = 0;
	public static final int GAME = 1;
	public static final int END = 2;
	public static final int START1 = 3;
	public static boolean FINISH = false;
	public static boolean WIN =false;
	public static boolean CLEAR =false;
	public static int LEVEL = 1;
	public static int life = 3;

	public static int STATE = -1;
	public int a;
	
	public static boolean isEnter;
	
	private int time = 0;
	private int targetFrames =  35;
	public static boolean showText = true;
	private int menu_width = 600;
	private int menu_height = 400;
	private int xx = Game.WIDTH/2 - menu_width/2;
	private int yy = Game.HEIGHT/2 - menu_height/2;
	
		
	/********************************************************************************************************/
	
	public Game() {
		Dimension dimension = new Dimension(Game.WIDTH, Game.HEIGHT);
		setPreferredSize(dimension);
		setMinimumSize(dimension);
		setMaximumSize(dimension);
		addKeyListener(this);
		
		
		heart = new ImageIcon("res\\heart\\heart.png").getImage();
		score = new Score("res\\scoreboard\\scoreboard.txt");
		pacman = new Pacman(Game.WIDTH/2, Game.HEIGHT/2); 
		womanpacman = new Pacman_Woman(Game.WIDTH/2, Game.HEIGHT/2);
		cookiepacman = new Pacman_Cookie(Game.WIDTH/2, Game.HEIGHT/2); 
		turbopacman = new Pacman_Turbo(Game.WIDTH/2, Game.HEIGHT/2); 
		scaredpacman = new Pacman_Scared(Game.WIDTH/2, Game.HEIGHT/2); 
		ghostpacman = new Pacman_Ghost(Game.WIDTH/2, Game.HEIGHT/2); 
		childpacman = new Pacman_Child(Game.WIDTH/2, Game.HEIGHT/2);
		dogpacman = new Pacman_Dog(Game.WIDTH/2, Game.HEIGHT/2); 
		sonnypacman = new Pacman_Sonny(Game.WIDTH/2, Game.HEIGHT/2); 
		map=new Map("/map/Map2.png");
		appearance = new Appearance("/appearance/appearance.png");
		appearance2 = new Appearance("/appearance/womanpacman.png");
		appearance3 = new Appearance("/appearance/cookieman.png");
		appearance4 = new Appearance("/appearance/turbopacman.png");
		appearance5 = new Appearance("/appearance/scaredpacman.png");
		appearance6 = new Appearance("/appearance/ghostpacman.png");
		appearance8 = new Appearance("/appearance/dogpacman.png");
		appearance9 = new Appearance("/appearance/sonpacman.png");

		new Character();
	}
	
	
	/********************************************************************************************************/	
	
	public synchronized void start() {
		if(isRunning)
			return;
		isRunning = true;
		thread = new Thread(this);
		thread.start();
	}
	
	/********************************************************************************************************/

	public synchronized void stop() {
		if(!isRunning)
			return;
		isRunning = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/********************************************************************************************************/
	
	private void render() { 
		BufferStrategy bs = getBufferStrategy(); 
		
		if(bs==null) { 
			createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.black);
		g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);

		if(STATE == GAME) {
			map.render(g);
			score.render(g);
			
			if(CharacterSelect.CharacterMode == 1) {
				pacman.render(g);
			}
			else if(CharacterSelect.CharacterMode == 2) {
				womanpacman.render(g);
			}
			else if(CharacterSelect.CharacterMode == 3) {
				cookiepacman.render(g);
			}
			else if(CharacterSelect.CharacterMode == 4) {
				turbopacman.render(g);
			}
			else if(CharacterSelect.CharacterMode == 5) {
				scaredpacman.render(g);
			}
			else if(CharacterSelect.CharacterMode == 6) {
				ghostpacman.render(g);
			}
			else if(CharacterSelect.CharacterMode == 7) {
				childpacman.render(g);
			}
			else if(CharacterSelect.CharacterMode == 8) {
				dogpacman.render(g);
			}
			else if(CharacterSelect.CharacterMode == 9) {
				sonnypacman.render(g);
			}
				

			g.setColor(Color.white);
			g.setFont(new Font(Font.DIALOG, Font.BOLD, 25));
			g.drawString("SCORE", 30, 800);
			for (int i = 0; i < life; i++) {
				g.drawImage(heart, i * 90 + 1000, 775, this);
		    }
		}
		else if(STATE == START) {
			g.setColor(new Color(0, 0, 150));
			g.fillRect(xx, yy, menu_width, menu_height);
			g.setColor(Color.white);
			g.setFont(new Font(Font.DIALOG, Font.BOLD, 25));
		
			if(showText) {
				if(FINISH){	
					g.drawString("YOU ARE DEAD", xx+200, yy+100);
					g.drawString("Your Score is "+score.score, xx+190, yy+140);
					g.drawString("Your Rank is "+score.rank, xx+200, yy+180);
					g.drawString("Press enter to restart the game", xx+122, yy+250);
				}
				else if(CLEAR) {
					g.drawString("!!! CLEAR !!!", xx+215, yy+130);
					g.drawString("Press enter to start the game", xx+125, yy+180);
				}
				else {
					g.drawString("Press enter to start the game", xx+125, yy+180);
				}
			}
		}
		else if(STATE==END) {
			stop();
		}
		g.dispose(); 
		bs.show();
	}
		
	/********************************************************************************************************/

	private void tick() {
		Timer time1 = new Timer();
		TimerTask timetask1 = new TimerTask() {
			public void run() {
				try {
					Thread1.start();
	            } catch (Exception e) {
	                System.out.println(e.getMessage());
	            }
			}
			
		};
		if(STATE == GAME) {

			if(CharacterSelect.CharacterMode == 1) {
				pacman.tick();
			}
			else if(CharacterSelect.CharacterMode == 2) {
				womanpacman.tick();
			}
			else if(CharacterSelect.CharacterMode == 3) {
				cookiepacman.tick();
			}
			else if(CharacterSelect.CharacterMode == 4) {
				turbopacman.tick();
			}
			else if(CharacterSelect.CharacterMode == 5) {
				scaredpacman.tick();
			}
			else if(CharacterSelect.CharacterMode == 6) {
				ghostpacman.tick();
			}
			else if(CharacterSelect.CharacterMode == 7) {
				childpacman.tick();
			}
			else if(CharacterSelect.CharacterMode == 8) {
				dogpacman.tick();
			}
			else if(CharacterSelect.CharacterMode == 9) {
				sonnypacman.tick();
			}
			map.tick();
		}
		else if(STATE == START1) {
			pacman = new Pacman(Game.WIDTH/2, Game.HEIGHT/2); 
			womanpacman = new Pacman_Woman(Game.WIDTH/2, Game.HEIGHT/2);
			cookiepacman = new Pacman_Cookie(Game.WIDTH/2, Game.HEIGHT/2); 
			turbopacman = new Pacman_Turbo(Game.WIDTH/2, Game.HEIGHT/2); 
			scaredpacman = new Pacman_Scared(Game.WIDTH/2, Game.HEIGHT/2); 
			ghostpacman = new Pacman_Ghost(Game.WIDTH/2, Game.HEIGHT/2); 
			childpacman = new Pacman_Child(Game.WIDTH/2, Game.HEIGHT/2);
			dogpacman = new Pacman_Dog(Game.WIDTH/2, Game.HEIGHT/2); 
			sonnypacman = new Pacman_Sonny(Game.WIDTH/2, Game.HEIGHT/2); 
			map=new Map("/map/Map2.png");
			appearance = new Appearance("/appearance/appearance.png");
			appearance2 = new Appearance("/appearance/womanpacman.png");
			appearance3 = new Appearance("/appearance/cookieman.png");
			appearance4 = new Appearance("/appearance/turbopacman.png");
			appearance5 = new Appearance("/appearance/scaredpacman.png");
			appearance6 = new Appearance("/appearance/ghostpacman.png");
			
			appearance8 = new Appearance("/appearance/dogpacman.png");
			appearance9 = new Appearance("/appearance/sonpacman.png");
			Thread.start();
			time1.schedule(timetask1, 6500);
			STATE=GAME;
		}
		else if(STATE == START) {
			time++;
			if(time==targetFrames) {
				time=0;
				if(showText) {
					showText=false;
				}
				else
					showText=true;
			} 
			if(isEnter) {
				if(CLEAR) {
					Game.CLEAR = false;
				
				}
				pacman = new Pacman(Game.WIDTH/2, Game.HEIGHT/2); 
				womanpacman = new Pacman_Woman(Game.WIDTH/2, Game.HEIGHT/2);
				cookiepacman = new Pacman_Cookie(Game.WIDTH/2, Game.HEIGHT/2); 
				turbopacman = new Pacman_Turbo(Game.WIDTH/2, Game.HEIGHT/2); 
				scaredpacman = new Pacman_Scared(Game.WIDTH/2, Game.HEIGHT/2); 
				ghostpacman = new Pacman_Ghost(Game.WIDTH/2, Game.HEIGHT/2); 
				childpacman = new Pacman_Child(Game.WIDTH/2, Game.HEIGHT/2);
				dogpacman = new Pacman_Dog(Game.WIDTH/2, Game.HEIGHT/2); 
				sonnypacman = new Pacman_Sonny(Game.WIDTH/2, Game.HEIGHT/2); 
				map=new Map("/map/Map2.png");
				appearance = new Appearance("/appearance/appearance.png");
				appearance2 = new Appearance("/appearance/womanpacman.png");
				appearance3 = new Appearance("/appearance/cookieman.png");
				appearance4 = new Appearance("/appearance/turbopacman.png");
				appearance5 = new Appearance("/appearance/scaredpacman.png");
				appearance6 = new Appearance("/appearance/ghostpacman.png");
				
				appearance8 = new Appearance("/appearance/dogpacman.png");
				appearance9 = new Appearance("/appearance/sonpacman.png");
				STATE=GAME;
			}
		}
	}
	
	/********************************************************************************************************/
	public void run() {
		requestFocus();
		int fps = 0; 
		double timer = System.currentTimeMillis();
		long lastTime = System.nanoTime();
		double targetTick = 100.0;
		double delta = 0;
		double ns = 1000000000 / targetTick;
		
		

		while(isRunning) {
			long now = System.nanoTime();
			delta = delta + ((now-lastTime)/ns);
			lastTime = now;
			
			while(delta >=1) { 
				tick();
				render(); 
				fps++; 
				delta--;
			}
			if(System.currentTimeMillis()-timer>=1000) { 
				fps=0;
				timer = timer+1000;
			}
		}
		stop();
	}

	/**
	 * @return ***********************************************************************************************************/	
	public void keyPressed(KeyEvent e) {
		if(STATE == GAME) {
			if(e.getKeyCode()==KeyEvent.VK_RIGHT)
				if(CharacterSelect.CharacterMode == 1) {
					pacman.right = true;
				}
				else if(CharacterSelect.CharacterMode == 2) {
					womanpacman.right = true;
				}
				else if(CharacterSelect.CharacterMode == 3) {
					cookiepacman.right = true;
				}
				else if(CharacterSelect.CharacterMode == 4) {
					turbopacman.right = true;
				}
				else if(CharacterSelect.CharacterMode == 5) {
					scaredpacman.right = true;
				}
				else if(CharacterSelect.CharacterMode == 6) {
					ghostpacman.right = true;
				}
				else if(CharacterSelect.CharacterMode == 7) {
					childpacman.right = true;
				}
				else if(CharacterSelect.CharacterMode == 8) {
					dogpacman.right = true;
				}
				else if(CharacterSelect.CharacterMode == 9) {
					sonnypacman.right = true;
				}
			if(e.getKeyCode()==KeyEvent.VK_LEFT)
				if(CharacterSelect.CharacterMode == 1) {
					pacman.left = true;
				}
				else if(CharacterSelect.CharacterMode == 2) {
					womanpacman.left = true;
				}
				else if(CharacterSelect.CharacterMode == 3) {
					cookiepacman.left = true;
				}
				else if(CharacterSelect.CharacterMode == 4) {
					turbopacman.left = true;
				}
				else if(CharacterSelect.CharacterMode == 5) {
					scaredpacman.left = true;
				}
				else if(CharacterSelect.CharacterMode == 6) {
					ghostpacman.left = true;
				}
				else if(CharacterSelect.CharacterMode == 7) {
					childpacman.left = true;
				}
				else if(CharacterSelect.CharacterMode == 8) {
					dogpacman.left = true;
				}
				else if(CharacterSelect.CharacterMode == 9) {
					sonnypacman.left = true;
				}
			if(e.getKeyCode()==KeyEvent.VK_UP)
				if(CharacterSelect.CharacterMode == 1) {
					pacman.up = true;
				}
				else if(CharacterSelect.CharacterMode == 2) {
					womanpacman.up = true;
				}
				else if(CharacterSelect.CharacterMode == 3) {
					cookiepacman.up = true;
				}
				else if(CharacterSelect.CharacterMode == 4) {
					turbopacman.up = true;
				}
				else if(CharacterSelect.CharacterMode == 5) {
					scaredpacman.up = true;
				}
				else if(CharacterSelect.CharacterMode == 6) {
					ghostpacman.up = true;
				}
				else if(CharacterSelect.CharacterMode == 7) {
					childpacman.up = true;
				}
				else if(CharacterSelect.CharacterMode == 8) {
					dogpacman.up = true;
				}
				else if(CharacterSelect.CharacterMode == 9) {
					sonnypacman.up = true;
				}
			if(e.getKeyCode()==KeyEvent.VK_DOWN)
				if(CharacterSelect.CharacterMode == 1) {
					pacman.down = true;
				}
				else if(CharacterSelect.CharacterMode == 2) {
					womanpacman.down = true;
				}
				else if(CharacterSelect.CharacterMode == 3) {
					cookiepacman.down = true;
				}
				else if(CharacterSelect.CharacterMode == 4) {
					turbopacman.down = true;
				}
				else if(CharacterSelect.CharacterMode == 5) {
					scaredpacman.down = true;
				}
				else if(CharacterSelect.CharacterMode == 6) {
					ghostpacman.down = true;
				}
				else if(CharacterSelect.CharacterMode == 7) {
					childpacman.down = true;
				}
				else if(CharacterSelect.CharacterMode == 8) {
					dogpacman.down = true;
				}
				else if(CharacterSelect.CharacterMode == 9) {
					sonnypacman.down = true;
				}
		}
		else if(STATE == START) {
			if(e.getKeyCode()==KeyEvent.VK_ENTER) {
				isEnter = true;
			}
		}
	}

	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_RIGHT)
			if(CharacterSelect.CharacterMode == 1) {
				pacman.right = false;
			}
			else if(CharacterSelect.CharacterMode == 2) {
				womanpacman.right = false;
			}
			else if(CharacterSelect.CharacterMode == 3) {
				cookiepacman.right = false;
			}
			else if(CharacterSelect.CharacterMode == 4) {
				turbopacman.right = false;
			}
			else if(CharacterSelect.CharacterMode == 5) {
				scaredpacman.right = false;
			}
			else if(CharacterSelect.CharacterMode == 6) {
				ghostpacman.right = false;
			}
			else if(CharacterSelect.CharacterMode == 7) {
				childpacman.right = false;
			}
			else if(CharacterSelect.CharacterMode == 8) {
				dogpacman.right = false;
			}
			else if(CharacterSelect.CharacterMode == 9) {
				sonnypacman.right = false;
			}
		if(e.getKeyCode()==KeyEvent.VK_LEFT)
			if(CharacterSelect.CharacterMode == 1) {
				pacman.left = false;
			}
			else if(CharacterSelect.CharacterMode == 2) {
				womanpacman.left = false;
			}
			else if(CharacterSelect.CharacterMode == 3) {
				cookiepacman.left = false;
			}
			else if(CharacterSelect.CharacterMode == 4) {
				turbopacman.left = false;
			}
			else if(CharacterSelect.CharacterMode == 5) {
				scaredpacman.left = false;
			}
			else if(CharacterSelect.CharacterMode == 6) {
				ghostpacman.left = false;
			}
			else if(CharacterSelect.CharacterMode == 7) {
				childpacman.left = false;
			}
			else if(CharacterSelect.CharacterMode == 8) {
				dogpacman.left = false;
			}
			else if(CharacterSelect.CharacterMode == 9) {
				sonnypacman.left = false;
			}
		if(e.getKeyCode()==KeyEvent.VK_UP)
			if(CharacterSelect.CharacterMode == 1) {
				pacman.up = false;
			}
			else if(CharacterSelect.CharacterMode == 2) {
				womanpacman.up = false;
			}
			else if(CharacterSelect.CharacterMode == 3) {
				cookiepacman.up = false;
			}
			else if(CharacterSelect.CharacterMode == 4) {
				turbopacman.up = false;
			}
			else if(CharacterSelect.CharacterMode == 5) {
				scaredpacman.up = false;
			}
			else if(CharacterSelect.CharacterMode == 6) {
				ghostpacman.up = false;
			}
			else if(CharacterSelect.CharacterMode == 7) {
				childpacman.up = false;
			}
			else if(CharacterSelect.CharacterMode == 8) {
				dogpacman.up = false;
			}
			else if(CharacterSelect.CharacterMode == 9) {
				sonnypacman.up = false;
			}
		if(e.getKeyCode()==KeyEvent.VK_DOWN)
			if(CharacterSelect.CharacterMode == 1) {
				pacman.down = false;
			}
			else if(CharacterSelect.CharacterMode == 2) {
				womanpacman.down = false;
			}
			else if(CharacterSelect.CharacterMode == 3) {
				cookiepacman.down = false;
			}
			else if(CharacterSelect.CharacterMode == 4) {
				turbopacman.down = false;
			}
			else if(CharacterSelect.CharacterMode == 5) {
				scaredpacman.down = false;
			}
			else if(CharacterSelect.CharacterMode == 6) {
				ghostpacman.down = false;
			}
			else if(CharacterSelect.CharacterMode == 7) {
				childpacman.down = false;
			}
			else if(CharacterSelect.CharacterMode == 8) {
				dogpacman.down = false;
			}
			else if(CharacterSelect.CharacterMode == 9) {
				sonnypacman.down = false;
			}
	}

	public void keyTyped(KeyEvent e) {
		
	}
	/********************************************************************************************************/
	
	/********************************************************************************************************/
}