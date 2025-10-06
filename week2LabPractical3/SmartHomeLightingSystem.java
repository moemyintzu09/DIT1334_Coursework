package week2LabPractical3;

import java.util.Scanner;

//Author name: Myint Zu
//Date create: 25.09.2025
//Purpose of Code: Create Chapter's 1 Abstraction Simple Code

//library that being imported when necessary 

//class for Light object
class Light {
	String roomName;
	boolean isOn;
	int brightness;
	
	//Constructor 
	Light(String room) {
		roomName = room;
		isOn = false;	//light start off
		brightness = 50;//default brightness
	}
	
	void turnOn() { 
		isOn = true;
		System.out.println(roomName + "lignt is ON.");
	}
	void turnOff() {
		isOn = false;
		System.out.println(roomName + "light is OFF.");
	}
	
	void setBrightness(int level) {
		if (level >= 0 && level <=100) {
			brightness = level;
			System.out.println(roomName + "brightness set to" + brightness + "%.");
		} else {
			System.out.println("Error: Brightness must be between 0 and 100.");
		}
	}
	
	void showStatus() {
		System.out.println("\nRoom:" + roomName);
		System.out.println("Light is" + (isOn ? "ON" : "OFF"));
		System.out.println("Brightness:" + brightness + "%");
	}
}
//Main Class
public class SmartHomeLightingSystem {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);		
		//input room name
		System.out.println("Enter room Name: ");
		String room = input.nextLine();		
		//create a light object
		Light light = new Light(room);
		
		while(true) {
			System.out.println("\nEnter command (on/off/brightness/status/exit):");
			String command = input.nextLine().toLowerCase();
			
			if (command.equals("on")) {
				light.turnOn();
			} else if (command.equals("off")) {
				light.turnOff();
			} else if (command.equals("brightness")) {
				System.out.println("Enter brightness (0-100):" );
				int level = input.nextInt();
				input.nextLine(); //input
				light.setBrightness(level);
			} else if (command.equals("status")) {
				light.showStatus();
			} else if (command.equals("exit")) {
				System.out.println("Goodbye!");
				break;
			} else {
				System.out.println("Invalid command. Try again!");
			}
		}		
		input.close();
	}
}
