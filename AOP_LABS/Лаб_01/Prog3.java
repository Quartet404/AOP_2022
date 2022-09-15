//lab 1, task 3
import java.util.Scanner;

public class Prog3 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter n: ");
		int n = sc.nextInt();
		double sum = 0;
		
		for (int k = 1; k <= n; ++k){
			sum += Math.pow(-1, k)/(k*k*(k+1));
		}
		
		System.out.println("Result of calculations: " + sum);
	}
}
//end of code
