package week2LabPractical3;//my package name

//Author: Myint Zu
//Date: 04.10.2025
//Program Title: Movie Ticket Booking System

//import
import java.util.Scanner;

//abstraction
abstract class Seat {
	String category;
	double basePrice;
	
	Seat(String category, double basePrice) {
		this.category = category;
		this.basePrice = basePrice;
	}
	
	//abstract method
	abstract double calculatePrice();
}

//inheritance and polymorphism
class RegularSeat extends Seat {
	RegularSeat(double basePrice) {
		super("Regular", basePrice);
	}
	//override abstract method
	double calculatePrice() {
		return basePrice; //no extra charge
	}
}

class VIPSeat extends Seat {
	VIPSeat(double basePrice) {
		super("VIP", basePrice);
	}
	double calculatePrice() {
		return basePrice * 1.5; //50% more expensive
	}
}

//encapsulation
class Movie {
	private String title;
	private String showtime;
	private double ticketPrice;
	
	Movie(String title, String showtime, double ticketPrice) {
		this.title = title;
		this.showtime = showtime;
		this.ticketPrice = ticketPrice;
	}
	public String getTitle() {
		return title;
	}
	public String getShowtime() {
		return showtime;
	}
	public double getTicketPrice() {
		return ticketPrice;
	}
}


//main class
public class MovieTicket {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//details input
		System.out.print("Enter movie title: ");
		String title = sc.nextLine();
		System.out.print("Enter showtime: ");
		String time = sc.nextLine();
		System.out.print("Enter base ticket price RM: ");
		double basePrice = sc.nextDouble();
		
		Movie movie = new Movie (title, time, basePrice);
		
		//seat selected
		System.out.println("\nChoose the seat: ");
		System.out.println("1. Regular");
		System.out.println("2. VIP");
		System.out.print("Enter choice: ");
		int choice = sc.nextInt();
		
		Seat seat;
		if (choice == 1) {
			seat = new RegularSeat(movie.getTicketPrice());
		} else if (choice == 2) {
			seat = new VIPSeat (movie.getTicketPrice());
		} else {
			System.out.println("Invalid choice.");
			seat = new RegularSeat(movie.getTicketPrice());
			
		}
		double finalPrice = seat.calculatePrice();
		
		//output
		System.out.println("\n==Booking Summary==");
		System.out.println("Movie: "+ movie.getTitle());
		System.out.println("Showtime: "+ movie.getShowtime());
		System.out.println("Seat Category: "+ seat.category);
		System.out.println("Ticket Price: RM"+ finalPrice);
		System.out.println("Booking Confirmed! Enjoy the Movie~");
		
		sc.close();
	}

}
