//lab 1, task 4
import java.util.Scanner;

public class Prog4 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter a series of numbers: ");
		double[] arr = new double[16];
		
		for (int i = 0; i < 16; ++i){
			arr[i] = sc.nextDouble();
		}
		
		double min = arr[0]-arr[7];
		int index_start = 1;
		
		for (int i = 1; i < 8; ++i){
			if (min > arr[i] - arr[i+7]){
				min = arr[i] - arr[i+7];
				index_start = i + 1;
			}
		}
		
		System.out.println("Minimum of range is a" + index_start + " - a" + (index_start + 7) + " = " + min);
	}
}
//end of code
