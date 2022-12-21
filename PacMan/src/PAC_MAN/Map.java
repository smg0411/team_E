package PAC_MAN;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

public class Map {
	public int width;  //40
	public int height; //25
	
	public Tile[][] tiles;
	
	public List<Seed> seeds;
	public List<Ghost> Ghosts;
	public List<Item> items;
	public List<SmartGhost> smartGhosts; 
	
	
	private int location=30;
	
	public Map(String path) { 
		try {
			seeds=new ArrayList<>();
			Ghosts=new ArrayList<>();
			items=new ArrayList<>();
			smartGhosts = new ArrayList<>();
			
			BufferedImage map = ImageIO.read(getClass().getResource(path));
			this.width=map.getWidth();
			this.height=map.getHeight();
			
			int[] pixels = new int[width*height]; 
		
			map.getRGB(0, 0, width, height, pixels, 0, width);
			
			tiles =new Tile[width][height]; 

			for(int i=0;i<width;i++) {
				for(int j=0;j<height;j++) {
					int val = pixels[i+(j*width)];
					if(val==0xFF000A7C) {
						
						tiles[i][j]=new Tile(i*32+location, j*32+location);
					}
					else if(val==0xFFFFD800) {
						if (CharacterSelect.CharacterMode == 1) {
							Game.pacman.x=i*32+location;
							Game.pacman.y=j*32+location;
						}
						else if (CharacterSelect.CharacterMode == 2) {
							Game.womanpacman.x=i*32+location;
							Game.womanpacman.y=j*32+location;
						}
						else if (CharacterSelect.CharacterMode == 3) {
							Game.cookiepacman.x=i*32+location;
							Game.cookiepacman.y=j*32+location;
						}
						else if (CharacterSelect.CharacterMode == 4) {
							Game.turbopacman.x=i*32+location;
							Game.turbopacman.y=j*32+location;
						}
						else if (CharacterSelect.CharacterMode == 5) {
							Game.scaredpacman.x=i*32+location;
							Game.scaredpacman.y=j*32+location;
						}
						else if (CharacterSelect.CharacterMode == 6) {
							Game.ghostpacman.x=i*32+location;
							Game.ghostpacman.y=j*32+location;
						}
						else if (CharacterSelect.CharacterMode == 7) {
							Game.childpacman.x=i*32+location;
							Game.childpacman.y=j*32+location;
						}
						else if (CharacterSelect.CharacterMode == 8) {
							Game.dogpacman.x=i*32+location;
							Game.dogpacman.y=j*32+location;
						}
						else if (CharacterSelect.CharacterMode == 9) {
							Game.sonnypacman.x=i*32+location;
							Game.sonnypacman.y=j*32+location;
						}
					}
					else if(val==0xFFFF0000) {
						
						Ghosts.add(new Ghost(i*32+location, j*32+location));
					}
					else if(val == 0xFFB83DBA) {
						items.add(new Item(i*32+location, j*32+location));
					}
					else if(val==0xFFb97a56) {
						smartGhosts.add(new SmartGhost(i*32+location, j*32+location));
					}
					else{
						
						seeds.add(new Seed(i*32+location, j*32+location));
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public void tick() { 
		for(int i=0;i<Ghosts.size();i++) {
			Ghosts.get(i).tick();
		}
		for(int i=0;i<smartGhosts.size();i++) {
			smartGhosts.get(i).tick();
		}
		
	}
	
	public void render(Graphics g) { 
		for(int i=0;i<width;i++) {
			for(int j=0;j<height;j++) {
				if(tiles[i][j]!=null)
					tiles[i][j].render(g);
			}
		}
		
		for(int i=0;i<seeds.size();i++) {
			seeds.get(i).render(g);
		}
		for(int i=0;i<items.size();i++) {
			items.get(i).render(g);
		}
		for(int i=0;i<Ghosts.size();i++) {
			Ghosts.get(i).render(g);
		}
		for(int i=0;i<smartGhosts.size();i++) {
			smartGhosts.get(i).render(g);
		}
		
	}
}