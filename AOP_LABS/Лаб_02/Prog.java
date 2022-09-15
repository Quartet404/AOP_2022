//lab 2
import java.util.Scanner;

class Prog {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		double mul = 0;
		Matrix a = new Matrix();
		a.print();
		
		Matrix b = new Matrix(sc);
		a.add(b);
		a.print();
		a.transpose();
		
		System.out.print("Enter multiplier: ");
		if (sc.hasNextDouble()){
			mul = sc.nextDouble();
		} else {
			System.out.print("Wrong input!!");
			Runtime.getRuntime().exit(1);
		}
		a.multiple(mul);
		a.print();
	}
}
//end of code
