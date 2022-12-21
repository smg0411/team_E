import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

public class Game extends Canvas implements Runnable,KeyListener{

	private boolean isRunning = false;
	
	public static final int WIDTH = 1280;
	public static final int HEIGHT = 900;
	public static final String TITLE = "Pacman";
	
	private Thread thread;
	
	public static Pacman pacman;
	public static Map map;
	public static Appearance appearance;
	public static Score score;

	public static final int START = 0;
	public static final int GAME = 1;
	public static final int END = 2;
	public static boolean FINISH = false;
	public static boolean WIN =false;
	public static boolean CLEAR =false;
	public static int LEVEL = 1;
	public static int life = 3;

	public static int STATE = -1;
	
	public boolean isEnter = false;
	
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
		
		STATE=START;
		WIN=false;
		FINISH=false;
		
		
	
		score = new Score("res\\scoreboard\\scoreboard.txt");
		pacman = new Pacman(Game.WIDTH/2, Game.HEIGHT/2); 
		map=new Map("/map/map0.png");
		appearance = new Appearance("/appearance/appearance.png");
		
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

		if(STATE==GAME) {
			pacman.render(g);
			map.render(g);
			score.render(g);
			
			g.setColor(Color.white);
			g.setFont(new Font(Font.DIALOG, Font.BOLD, 25));
			g.drawString("SCORE", 30, 870);
			
		}
		
		else if(STATE==START) { 
			
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
				else	
					g.drawString("Press enter to start the game", xx+125, yy+200);
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
		if(STATE==GAME) {
			pacman.tick();
			map.tick();
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
				isEnter=false;
				pacman = new Pacman(Game.WIDTH/2, Game.HEIGHT/2);
				map=new Map("/map/map0.png");
				appearance = new Appearance("/appearance/appearance.png");
				STATE=GAME;
				if(CLEAR) {
					for (int i=0;i<Game.map.Ghosts.size();i++) {
						Game.map.Ghosts.get(i).ChangeSpeed((Game.LEVEL*1)+1);
						Game.CLEAR = false;
					}
				}
			}
		}
	}
	
	/********************************************************************************************************/
	
	public static void main(String[] args) {
		Game game = new Game();
		JFrame frame = new JFrame();
		frame.setTitle(Game.TITLE);
		frame.add(game);
		frame.setResizable(false);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
		frame.setVisible(true);
		game.start();
	}
	
	/***************************************************************************************************/

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

	/*************************************************************************************************************/

	public void keyPressed(KeyEvent e) {
		if(STATE == GAME) {
			if(e.getKeyCode()==KeyEvent.VK_RIGHT)
				pacman.right=true;
			if(e.getKeyCode()==KeyEvent.VK_LEFT)
				pacman.left=true;
			if(e.getKeyCode()==KeyEvent.VK_UP)
				pacman.up=true;
			if(e.getKeyCode()==KeyEvent.VK_DOWN)
				pacman.down=true;
		}
		
		else if(STATE==START) {
			if(e.getKeyCode()==KeyEvent.VK_ENTER) {
				isEnter = true;
			}
		}
	}

	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_RIGHT)
			pacman.right=false;
		if(e.getKeyCode()==KeyEvent.VK_LEFT)
			pacman.left=false;
		if(e.getKeyCode()==KeyEvent.VK_UP)
			pacman.up=false;
		if(e.getKeyCode()==KeyEvent.VK_DOWN)
			pacman.down=false;
	}

	public void keyTyped(KeyEvent e) {
		
	}

}
