//lab 2
import java.util.Scanner;

public class Matrix{
	private double[][] arr;
	
	public Matrix(){
		arr = new double[2][3];
		for (int i = 0; i < 2; ++i){
			for (int j = 0; j < 3; ++j){
				arr[i][j] = Math.random()*200 - 100;
			}
		}
	}
	public Matrix(Scanner sc){
		System.out.println("Enter numbers: ");
		arr = new double[2][3];
		for (int i = 0; i < 2; ++i){
			System.out.print("Line " + (i+1) + ": ");
			for (int j = 0; j < 3; ++j){
				if (sc.hasNextDouble()) {
					arr[i][j] = sc.nextDouble();
				} else {
					System.out.println("Error!!! Wrong input");
					Runtime.getRuntime().exit(1);
				}
			}
		}
		System.out.println();
	}
	
	public void print(){
		for (int i = 0; i < 2; ++i){
			for (int j = 0; j < 3; ++j){
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public void transpose(){
		for (int i = 0; i < 3; ++i){
			for (int j = 0; j < 2; ++j){
				System.out.print(arr[j][i] + "\t");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public void add(Matrix b){
		for (int i = 0; i < 2; ++i){
			for (int j = 0; j < 3; ++j){
				this.arr[i][j] += b.arr[i][j];
			}
		}
	}
	
	public void multiple(double m){
		for (int i = 0; i < 2; ++i){
			for (int j = 0; j < 3; ++j){
				this.arr[i][j] *= m;
			}
		}
	}
}
//end of code
