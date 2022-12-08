package PAC_MAN;

public abstract class Character  {
	
	public Character() {
		
	}
	
	//움직이기
	abstract void move_up();
	abstract void move_down();
	abstract void move_left();
	abstract void move_right();
	
	//사망
	abstract void death();
	
	//처치
	abstract void kill_character();
	
	//아이템 먹기
	abstract void pick_items();
	
}