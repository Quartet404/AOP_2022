//lab 1, task 2
import java.util.Scanner;

public class Prog2 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter a: ");
		double a = sc.nextDouble();
		System.out.print("Enter b: ");
		double b = sc.nextDouble(); 
		
		if (a == 0){
			System.out.println("No Solution!");
		} else {
			System.out.println("x = " + (-b/a));
		}
		
	}
}
//end of code
