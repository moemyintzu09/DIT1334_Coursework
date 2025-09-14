package w1_LabPractical1; //my package name
import java.util.Scanner;//scanner tool
import java.util.scanner;

public class question2 {//my class name
	public static void main(String[] args) {//this line is compulsory
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter a number: ");//ask user to enter the number
		int number = input.nextInt(); //store input as number
		
		if (number% 2 == 0) {//else-if function 
			System.out.println(number + "is Even.");//show "Even" if number is even
		} else {
			System.out.println(number+"is Odd."); //show "Odd" if number is odd
		}
	}//this line is compulsory to complete the public static void main's "{"

}//this line is compulsory to complete the public class's "{"
