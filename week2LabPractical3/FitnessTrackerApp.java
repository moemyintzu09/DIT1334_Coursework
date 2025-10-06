package week2LabPractical3;

//Author: Myint Zu
//Date: 04.10.2025
//Program Title: Fitness Tracker App

//import 
import java.util.Scanner;

//Base class
abstract class Activity {
	String name;
	int duration; //in minutes
	double distance; //in km
	
	//constructor
	Activity(String name, int duration, double distance) {
		this.name = name;
		this.duration = duration;
		this.distance = distance;
	}
	//abstract method
	abstract double calculateCalories();
	void showReport() {
		System.out.println("\n--"+ name +"Report--");
		System.out.println("Duration: "+ duration +"mins");
		System.out.println("Distance: "+ distance +"km");
		System.out.println("Calories Burned: "+ calculateCalories());
	}
}

//inheritance
class Cycling extends Activity {
	Cycling(int duration, double distance) {
		super("Cycling", duration, distance);
	}
	
	//polymorphism
	double calculateCalories() {
		return distance * 40; //formula for cycling
	}
}

//inheritance
class Swimming extends Activity {
	Swimming(int duration, double distance) {
		super("Swimming", duration, distance);
	}
	
	//polymorphism
	double calculateCalories() {
		return duration * 8; //formula for swimming
	}
}

//inheritance
class Running extends Activity {
  Running(int duration, double distance) {
      super("Running", duration, distance);
  }
  //polymorphism
  double calculateCalories() {
      return distance * 60; // formula for running
  }
}
//main class
public class FitnessTrackerApp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//input
		System.out.println("Choose activity: 1=Running, 2=Cycling, 3=Swimming");
		int choice = sc.nextInt();
		System.out.println("Enter duration(minutes): ");
		int duration = sc.nextInt();
		System.out.println("Enter distance (km): ");
		double distance = sc.nextDouble();		
		//polymorphism
		Activity activity;
		if (choice == 1) {
			activity = new Running(duration, distance);
		} else if (choice == 2) {
			activity = new Cycling(duration, distance);
		} else {
			activity = new Swimming(duration, distance);
		}		
		//method call or object
		activity.showReport();		
		sc.close();		
	}
}
