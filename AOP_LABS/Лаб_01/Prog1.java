//lab 1, task 1
import java.util.Scanner;

public class Prog1 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter rectangle length: ");
		double a = sc.nextDouble();
		System.out.print("Enter rectangle width: ");
		double b = sc.nextDouble(); 
		
		double perimetr = 2*(a+b);
		double square = a*b;
		double diagonal = Math.sqrt(a*a+b*b);
		
		System.out.println("Perimetr of rectangle: " + perimetr);
		System.out.println("Area of rectangle: " + square);
		System.out.println("Diagonal of rectangle: " + diagonal);
	}
}
//end of code
