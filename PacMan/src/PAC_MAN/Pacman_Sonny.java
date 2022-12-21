package PAC_MAN;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Timer;
import java.util.TimerTask;

public class Pacman_Sonny extends Rectangle {

	public boolean right;
	public boolean left;
	public boolean up;
	public boolean down;
	private int speed = 6;
	private int imageIndex = 28;


	
	private Timer m;
	private TimerTask m_task;
	Score curScore;
	
	public Pacman_Sonny(int x, int y) {
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
			imageIndex = 28;
		}
		if(left&&canMove(x-speed, y)) {
			x=x-speed;
			imageIndex = 29;
		}
		if(up&&canMove(x, y-speed)) {
			y=y-speed;
			imageIndex = 30;
		}
		if(down&&canMove(x, y+speed)) {
			y=y+speed;
			imageIndex = 31;
		}
		
		Map map = Game.map;
		
		for(int i=0;i<map.seeds.size();i++){ 
			if(this.intersects(map.seeds.get(i))) {
				if (map.seeds.size()==295) {
					curScore.score += 50;
					//seed295 = true;
				}
				if (map.seeds.size()==285) {
					curScore.score += 50;
					//seed285 = true;
				}
				if (map.seeds.size()==275) {
					curScore.score += 50;
					//seed275 = true;
				}
				if (map.seeds.size()==265) {
					curScore.score += 50;
					//seed265 = true;
				}
				if (map.seeds.size()==255) {
					curScore.score += 50;
					//seed255 = true;
				}
				if (map.seeds.size()==245) {
					curScore.score += 50;
					//seed245 = true;
				}
				if (map.seeds.size()==235) {
					curScore.score += 50;
					//seed235 = true;
				}
				if (map.seeds.size()==225) {
					curScore.score += 50;
					//seed225 = true;
				}
				if (map.seeds.size()==215) {
					curScore.score += 50;
					//seed215 = true;
				}
				if (map.seeds.size()==205) {
					curScore.score += 50;
					//seed205 = true;
				}
				if (map.seeds.size()==195) {
					curScore.score += 50;
					//seed195 = true;
				}
				if (map.seeds.size()==185) {
					curScore.score += 50;
					//seed185 = true;
				}
				if (map.seeds.size()==175) {
					curScore.score += 50;
					//seed175 = true;
				}
				if (map.seeds.size()==165) {
					curScore.score += 50;
					//seed165 = true;
				}
				if (map.seeds.size()==155) {
					curScore.score += 50;
					//seed155 = true;
				}
				if (map.seeds.size()==145) {
					curScore.score += 50;
					//seed145 = true;
				}
				if (map.seeds.size()==135) {
					curScore.score += 50;
					//seed135 = true;
				}
				if (map.seeds.size()==125) {
					curScore.score += 50;
					//seed125 = true;
				}
				if (map.seeds.size()==115) {
					curScore.score += 50;
					//seed115 = true;
				}
				if (map.seeds.size()==105) {
					curScore.score += 50;
					//seed105 = true;
				}
				if (map.seeds.size()==95) {
					curScore.score += 50;
					//seed95 = true;
				}
				if (map.seeds.size()==85) {
					curScore.score += 50;
					//seed85 = true;
				}
				if (map.seeds.size()==75) {
					curScore.score += 50;
					//seed75 = true;
				}
				if (map.seeds.size()==65) {
					curScore.score += 50;
					//seed65 = true;
				}
				if (map.seeds.size()==55) {
					curScore.score += 50;
					//seed55 = true;
				}
				if (map.seeds.size()==45) {
					curScore.score += 50;
					//seed45 = true;
				}
				if (map.seeds.size()==35) {
					curScore.score += 50;
					//seed35 = true;
				}
				if (map.seeds.size()==25) {
					curScore.score += 50;
					//seed25 = true;
				}
				if (map.seeds.size()==15) {
					curScore.score += 50;
					//seed15 = true;
				}
				if (map.seeds.size()==5) {
					curScore.score += 50;
					//seed5 = true;
				}
				else {
					curScore.score+=10;
				}
				map.seeds.remove(i);
				break;
			}
		}
		
		if(map.seeds.size()==0) {
			if(Game.LEVEL == 3) {
				Game.STATE = Game.END;
			}
			Game.CLEAR = false;
			Game.STATE=Game.START1;
			return;
		}
		
		for(int i=0; i<map.items.size();i++) {
			if(this.intersects(map.items.get(i))) {
				curScore.score+=30;
				Game.CLEAR = true;
				m = new Timer();
				m_task = new TimerTask() {
					@Override
					public void run() {
						// TODO Auto-generated method stub
						Ghost.speed = Game.LEVEL * 2;
						for (int k=0; k<Game.map.Ghosts.size();k++) {
							Game.map.Ghosts.get(k).ChangeGhostMode(Ghost.NORMAL);
							
					}
				}
				};
				
				map.items.remove(i);
		
				Ghost.speed = 1;
				for (int k=0; k<Game.map.Ghosts.size();k++) {
					Game.map.Ghosts.get(k).ChangeGhostMode(Ghost.SLOW);
				}
				m.schedule(m_task, 10000);
				break;
			}
		}
		
		for(int i=0;i<Game.map.Ghosts.size();i++){ 
			Ghost temp = Game.map.Ghosts.get(i);
			if(temp.intersects(this)) {
				Game.life = Game.life-1; 
				Game.STATE = Game.START;
				if(Game.life == 0) {
					Game.STATE = Game.START;
					Game.FINISH = true;
					curScore.insertScore();
					Game.life = 3;
					return;
				}
				break;
			}
		}	
		
		for (int i=0; i<Game.map.smartGhosts.size(); i++) {
			SmartGhost temp2 = Game.map.smartGhosts.get(i);
			if(temp2.intersects(this)) {
				Game.life = Game.life -1;
				Game.STATE = Game.START;
				if(Game.life == 0) {
					Game.STATE = Game.START;
					Game.FINISH = true;
					curScore.insertScore();
					Game.life = 3;
					return;
				}
				break;
			}
		}
	}
	public void render(Graphics g){
		g.drawImage(Character.pacman[imageIndex], x, y, width, height, null);
	}
}
