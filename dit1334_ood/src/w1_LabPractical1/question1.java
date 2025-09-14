package w1_LabPractical1;//my package name
import java.util.Scanner; //scanner tool
import java.util.scanner;

public class question1 { //my class name 
	public static void main (String[] args) {// this line is compulsory
		Scanner input = new Scanner(System.in);
		
		
		System.out.print("Enter first number: ");//ask user to enter the first number
		int num1 = input.nextInt();//store input number as num1
		
		System.out.print("Enter second number: ");//ask user to enter the second number
		int num2 = input.nextInt();//store second input number as num2
		
		int sum = num1+num2;//addition two numbers that entered as num1 and num2
		System.out.println("The sum is: "+ sum); //show result 
		
	}//this line is compulsory to complete the public static void main's "{"
}//this line is compulsory to complete the public class's "{"
