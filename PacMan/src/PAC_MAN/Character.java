package PAC_MAN;

import java.awt.image.BufferedImage;

public class Character { // Appearance에서 받아온 유령이미지와 팩맨 이미지를 저장
	public static BufferedImage[] pacman;
	public static BufferedImage[] ghost;
	public static BufferedImage[] smartGhost;
	public Character(){
		pacman = new BufferedImage[32];
		ghost = new BufferedImage[8];
		smartGhost = new BufferedImage[4];
		
		// 인덱스값에 따라 이미지가 달라짐
		pacman[0]=Game.appearance.getAppearance(0, 0, 32, 32);
		pacman[1]=Game.appearance.getAppearance(32,0, 32, 32);
		pacman[2]=Game.appearance.getAppearance(64, 0, 32, 32);
		pacman[3]=Game.appearance.getAppearance(96, 0, 32, 32);
		
		pacman[4]=Game.appearance2.getAppearance(5, 0, 90, 92);
		pacman[5]=Game.appearance2.getAppearance(95,0,90, 92);
		pacman[6]=Game.appearance2.getAppearance(185, 0,90, 92);
		pacman[7]=Game.appearance2.getAppearance(275, 0, 90, 92);
		
		pacman[8]=Game.appearance3.getAppearance(3, 0, 70, 73);
		pacman[9]=Game.appearance3.getAppearance(73,0, 70, 73);
		pacman[10]=Game.appearance3.getAppearance(143, 0, 70, 73);
		pacman[11]=Game.appearance3.getAppearance(213, 0, 70, 73);
		
		pacman[12]=Game.appearance4.getAppearance(0, 0, 63, 66);
		pacman[13]=Game.appearance4.getAppearance(63,0, 63, 66);
		pacman[14]=Game.appearance4.getAppearance(126, 0, 63, 66);
		pacman[15]=Game.appearance4.getAppearance(189, 0, 63, 66);
		
		pacman[16]=Game.appearance5.getAppearance(0, 0, 63, 61);
		pacman[17]=Game.appearance5.getAppearance(63,0, 63, 61);
		pacman[18]=Game.appearance5.getAppearance(126, 0, 63, 61);
		pacman[19]=Game.appearance5.getAppearance(192, 0, 63, 61);
		
		pacman[20]=Game.appearance6.getAppearance(0, 0, 42, 42);
		pacman[21]=Game.appearance6.getAppearance(0, 0, 42, 42);
		pacman[22]=Game.appearance6.getAppearance(0, 0, 42, 42);
		pacman[23]=Game.appearance6.getAppearance(0, 0, 42, 42);
		
		pacman[24]=Game.appearance8.getAppearance(0, 0, 61, 61);
		pacman[25]=Game.appearance8.getAppearance(61,0, 61, 61);
		pacman[26]=Game.appearance8.getAppearance(122, 0, 61, 61);
		pacman[27]=Game.appearance8.getAppearance(183, 0, 61, 61);
		
		pacman[28]=Game.appearance9.getAppearance(0, 0, 61, 66);
		pacman[29]=Game.appearance9.getAppearance(61,0, 61, 66);
		pacman[30]=Game.appearance9.getAppearance(122, 0, 61, 66);
		pacman[31]=Game.appearance9.getAppearance(186, 0, 63, 66);
		
		
		

		ghost[0]=Game.appearance.getAppearance(0, 32, 32, 32);
		ghost[1]=Game.appearance.getAppearance(32, 32, 32, 32);
		ghost[2]=Game.appearance.getAppearance(64, 32, 32, 32);
		ghost[3]=Game.appearance.getAppearance(96, 32, 32, 32);
		ghost[4]=Game.appearance.getAppearance(0, 64, 32, 32);
		ghost[5]=Game.appearance.getAppearance(32, 64, 32, 32);
		ghost[6]=Game.appearance.getAppearance(64, 64, 32, 32);
		ghost[7]=Game.appearance.getAppearance(96, 64, 32, 32);	
		
		smartGhost[0]=Game.appearance.getAppearance(0, 96, 32, 32);
		smartGhost[1]=Game.appearance.getAppearance(32, 96, 32, 32);
		smartGhost[2]=Game.appearance.getAppearance(64, 96, 32, 32);
		smartGhost[3]=Game.appearance.getAppearance(96, 96, 32, 32);
	}	 
}