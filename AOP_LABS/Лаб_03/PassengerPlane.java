//lab 3
public class PassengerPlane extends Plane{
	@Override
	public void printInfo(){
		System.out.println("Flight name is \"" + name + "\"");
		System.out.println("Current speed is " + speed + " kt");
		System.out.println("This plane has " + wheelsCount + ((wheelsCount != 0) ? " wheels" : " wheel") + " and " + passengerAmount + " passengers on the board");
		System.out.println(name + "`s weight is " + weight + "\n");
	}
	
	public PassengerPlane(String name, int speed, int wheelsCount, int passengerAmount, double weight){
		super(name, speed, wheelsCount, passengerAmount, weight);
	}
}
//end of code
