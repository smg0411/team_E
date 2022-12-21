import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Timer;
import java.util.TimerTask;

public class Pacman extends Rectangle{
	
	public boolean right;
	public boolean left;
	public boolean up;
	public boolean down;
	private int speed = 2;
	private int imageIndex = 0;
	
	private Timer m;
	private TimerTask m_task;
	Score curScore;
	
	public Pacman(int x, int y) {
		curScore=Game.score;
		curScore.score=0;
		setBounds(x, y, 28, 28);
	}
	
	public void SetSpeed(int speed) {
		this.speed = speed;
	}
	
	private boolean canMove(int next_x, int next_y) { 
		
		Rectangle bounds = new Rectangle(next_x, next_y, width, height);
		Map map = Game.map;
		
		for(int i=0;i<map.tiles.length;i++){
			for(int j=0;j<map.tiles[0].length;j++){
				if(map.tiles[i][j]!=null){
					if(bounds.intersects(map.tiles[i][j])) {
						return false;
					}
				}
			}
		}
		
		return true;
	}
	
	public void tick() { 
		if(right&&canMove(x+speed, y)){
			x=x+speed;
			imageIndex = 0;
		}
		if(left&&canMove(x-speed, y)) {
			x=x-speed;
			imageIndex = 1;
		}
		if(up&&canMove(x, y-speed)) {
			y=y-speed;
			imageIndex = 2;
		}
		if(down&&canMove(x, y+speed)) {
			y=y+speed;
			imageIndex = 3;
		}
		
		Map map = Game.map;
		
		for(int i=0;i<map.seeds.size();i++){ 
			if(this.intersects(map.seeds.get(i))) {
				curScore.score+=10;
				map.seeds.remove(i);
				break;
			}
		}
		
		if(map.seeds.size()==0) {
			if(Game.LEVEL == 3) {
				Game.STATE = Game.END;
			}
			Game.LEVEL ++;
			for (int i=0; i<Game.map.Ghosts.size();i++) {
				Game.map.Ghosts.get(i).ChangeSpeed((Game.LEVEL*1)+1);
			}
			Game.STATE = Game.START;
			
			return;
		}
		
		for(int i=0; i<map.items.size();i++) {
			if(this.intersects(map.items.get(i))) {
				curScore.score+=30;
				
				m = new Timer();
				m_task = new TimerTask() {
				
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
					
						for (int k=0; k<Game.map.Ghosts.size();k++) {
							Game.map.Ghosts.get(k).ChangeGhostMode(Ghost.NORMAL);
							Game.map.Ghosts.get(k).ChangeSpeed((Game.LEVEL*1)+1);
							
					}
				}
				};
				
				map.items.remove(i);
		
			
				for (int k=0; k<Game.map.Ghosts.size();k++) {
					Game.map.Ghosts.get(k).ChangeGhostMode(Ghost.SLOW);
					Game.map.Ghosts.get(k).ChangeSpeed(1);
				}
				m.schedule(m_task, 10000);
				break;
			}
		}
		
		for(int i=0;i<Game.map.Ghosts.size();i++){ 
			
			Ghost temp = Game.map.Ghosts.get(i);
			if(temp.intersects(this)) {
				if(Game.life == 0) {
					
					Game.FINISH = true;
					
					curScore.insertScore();
					return;
				}
				Game.life = Game.life-1; 
				Game.STATE = Game.START;
				
				break;
				
			}
		}
		
		
	}
	
	public void render(Graphics g){
		g.drawImage(Character.pacman[imageIndex], x, y, width, height, null);
	}
}
