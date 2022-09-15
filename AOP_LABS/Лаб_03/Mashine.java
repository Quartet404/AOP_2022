//lab 3

public abstract class Mashine implements Run{
	protected final int MIN_SPEED = 0;
	protected final int MAX_SPEED = 1000;
	protected final int MIN_PASSENGERS = 0;
	protected final int MAX_PASSENGERS = 200;
	protected String name;
	protected int speed = MIN_SPEED;
	
	public Mashine(String name, int speed){
		this.name = name;
		if (speed >= MIN_SPEED && speed <= MAX_SPEED){
			this.speed = speed;
		}
		else { 
			System.out.println("Швидкість поза межами можливих значень!");
			System.exit(1);
		}
	}
	
	@Override
	public void printName(){
		System.out.println("Транспорт називається " + name);
	}
	
}
//end of code
