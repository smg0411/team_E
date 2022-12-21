package PAC_MAN;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.nio.channels.ClosedByInterruptException;

import javazoom.jl.player.Player;

public class Music1 implements Runnable {
	Player jlPlayer = null;
	public Music1() {
	}
	
	public void run() {
		// TODO Auto-generated method stub
	    try {
	        FileInputStream fileInputStream = new FileInputStream("resource/PacMan.mp3");
	        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
	        jlPlayer = new Player(bufferedInputStream);
	    } catch (Exception e) {
	        System.out.println(e.getMessage());
	    }
	    final Player player = jlPlayer;
	        
	    try {
	        player.play();
	    } catch (Exception e) {
	        System.out.println(e.getMessage());
	    }
	}
}