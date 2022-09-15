//lab 3
public class TransportPlane extends Plane{
	private String cargo;
	
	@Override
	public void printInfo(){
		System.out.println("Flight name is \"" + name + "\"");
		System.out.println("Current speed is " + speed + " kt");
		System.out.println("This plane has " + wheelsCount + ((wheelsCount != 0) ? " wheels" : " wheel"));
		System.out.println("This plane carries " + cargo);
		System.out.println(name + "`s weight is " + weight + "\n");
	}
	
	public TransportPlane(String name, int speed, int wheelsCount, double weight, String cargo){
		super(name, speed, wheelsCount, 0, weight);
		this.cargo = cargo;
	}
}
//end of code
