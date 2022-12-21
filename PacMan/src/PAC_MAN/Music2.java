package PAC_MAN;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

import javazoom.jl.player.Player;

public class Music2 implements Runnable {
	Player jlPlayer2 = null;
	public Music2() {
	}

	public void run() {
		try {
		    FileInputStream fileInputStream1 = new FileInputStream("resource/PacMan20.mp3");
		    BufferedInputStream bufferedInputStream1 = new BufferedInputStream(fileInputStream1);
		    jlPlayer2 = new Player(bufferedInputStream1);
        } catch (Exception e) {
		    System.out.println(e.getMessage());
		}
		final Player player = jlPlayer2;
		try {
	        player.play();
	    } catch (Exception e) {
	        System.out.println(e.getMessage());
	    }
	}
}