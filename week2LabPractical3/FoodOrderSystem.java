package week2LabPractical3;

//Author: Myint Zu
//Date: 04.10.2025
//Program Title: Online Food Ordering System

//import
import java.util.Scanner;

//base class
class Food {
	String name;
	double price;
	int prepTime;
	
	//constructor
	Food(String n, double p, int t) {
		name = n;
		price = p;
		prepTime = t;
	}
	
	//method to display food details
	void display() {
		System.out.println(name+"-RM" + price + "(Prep:" + prepTime + "mins)");
	}
	//default preparation method
	void prepare() {
		System.out.println("Preparing" + name + "in a general way..");
	}
}
//Pizza class with its own preparation method
class Pizza extends Food {
	Pizza() {
		super("Pizza", 25.0, 20); //call parent constructor
	}
	
	@Override
	void prepare() {
		System.out.println("Preparing Pizza: Rolling dough, adding toppings, and baking.");
	}
}
//Burger class with its own preparation method
class Burger extends Food {
	Burger() {
		super("Burger", 12.0, 10);
	}
	@Override
	void prepare() {
		System.out.println("Preparing Burger: Grilling patty, adding veggies, and serving.");
	}
}
//Main Class
public class FoodOrderSystem {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//create for objects
		Food pizza = new Pizza();
		Food burger = new Burger();
		//Show menu
		System.out.println("Welcome to Online Food Order System!");
		System.out.println("Menu:");
		pizza.display();
		burger.display();
		//take user choice
		System.out.print("\nEnter your choice(1 for Pizza, 2 for Burger): ");
		int choice = sc.nextInt();
		//process order
		if (choice == 1) {
			System.out.println("You Ordered: "+ pizza.name);
			pizza.prepare();
			System.out.println("Total Price: RM"+ pizza.price);
		} else if (choice == 2) {
			System.out.println("You Ordered: "+ burger.name);
			burger.prepare();
			System.out.println("Total Price: RM"+ burger.price);
		} else {
			System.out.println("Invalid choice!");
		}
		sc.close();
	}
}
