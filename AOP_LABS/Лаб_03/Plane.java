//lab 3

public class Plane extends Mashine{
	protected int wheelsCount;
	protected int passengerAmount;
	protected double weight;
	
	@Override
	public int getWheelsCount(){
		return wheelsCount;
	}
	
	@Override
	public int getSpeed(){
		return speed;
	}
	
	@Override
	public int getPassengerAmount(){
		return passengerAmount;
	}
	
	public double getWeight(){
		return weight;
	}
	
	public void printInfo(){
		System.out.println("Flight name is \"" + name + "\"");
		System.out.println("Current speed is " + speed + " kt");
		System.out.println("This plane has " + wheelsCount + ((wheelsCount != 0) ? " wheels" : " wheel"));
		System.out.println("There is " + passengerAmount + " passengers on the board");
		System.out.println(name + "`s weight is " + weight + "\n");
	}
	
	public Plane(String name, int speed, int wheelsCount, int passengerAmount, double weight){
		super(name, speed);
		this.wheelsCount = wheelsCount;
		this.passengerAmount = passengerAmount;
		this.weight = weight;
	}
	
	public void test(){
		System.out.println(name);
	}
}
//end of code
