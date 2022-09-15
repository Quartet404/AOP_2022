//lab 1, task 5
import java.util.Scanner;

public class Prog5 {
	public static double f(double x){
		return x - x*x*x/3 + x*x*x*x*x/5;
	}
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		System.out.println("\tx\tf(x)");
		for (double x = 0; x <= 14; ++x){
			System.out.println((int)x+1 + ":\t" + x/2 + "\t" + f(x/2));
		}
	}
}
//end of code
