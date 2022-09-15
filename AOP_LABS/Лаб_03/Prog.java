//lab 3
import java.util.Scanner;

public class Prog {
		
	public static void main(String[] args){
		Plane one = new PassengerPlane("RI-691", 189, 7, 282, 50.2);
		Plane two = new TransportPlane("AC-130", 200, 5, 70.3);
		one.printInfo();
		two.printInfo();
	}
}
//end of code
