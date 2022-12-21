import java.awt.image.BufferedImage;

public class Character { 
	public static BufferedImage[] pacman;
	public static BufferedImage[] ghost;
	public static BufferedImage[] slowghost;
	
	public Character(){
		pacman = new BufferedImage[4];
		ghost = new BufferedImage[8];
		
		
		
		pacman[0]=Game.appearance.getAppearance(0, 0);
		pacman[1]=Game.appearance.getAppearance(32,0);
		pacman[2]=Game.appearance.getAppearance(64, 0);
		pacman[3]=Game.appearance.getAppearance(96, 0);

		ghost[0]=Game.appearance.getAppearance(0, 32);
		ghost[1]=Game.appearance.getAppearance(32, 32);
		ghost[2]=Game.appearance.getAppearance(64, 32);
		ghost[3]=Game.appearance.getAppearance(96, 32);
		ghost[4]=Game.appearance.getAppearance(0, 64);
		ghost[5]=Game.appearance.getAppearance(32, 64);
		ghost[6]=Game.appearance.getAppearance(64, 64);
		ghost[7]=Game.appearance.getAppearance(96, 64);
		
		

	

	}
	 
}
