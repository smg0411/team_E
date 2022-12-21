package PAC_MAN;

import java.util.Timer;
import java.util.TimerTask;

public class Main {
	static Music1 runnable = new Music1();
	static Music2 runnable1 = new Music2();
	static Thread thread = new Thread(runnable);
	static Thread thread1 = new Thread(runnable1);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Timer time = new Timer();
		TimerTask timetask = new TimerTask() {
			public void run() {
				try {
	            	thread1.start();
	            } catch (Exception e) {
	                System.out.println(e.getMessage());
	            }
			}
		};
		new MainFrame();
		thread.start();
		time.schedule(timetask, 6500);
	}
}