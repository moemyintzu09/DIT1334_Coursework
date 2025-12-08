package javaConsoleApp;

import java.util.ArrayList;
import java.util.Scanner;

public class CampusLocationHelper {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<Location> locationList = new ArrayList<>();

    // Option 1 - Add Location
    public static void addLocation() {
        System.out.println("\n--- Add New Location ---");
        System.out.print("Enter location name: ");
        String name = sc.nextLine();

        System.out.print("Enter category (e.g., Building, Office, Facility): ");
        String category = sc.nextLine();

        System.out.print("Enter description: ");
        String description = sc.nextLine();

        locationList.add(new Location(name, category, description));
        System.out.println("Location added successfully!\n");
    }

    // Option 2 - View All Locations
    public static void viewLocations() {
        System.out.println("\n--- All Locations ---");

        if (locationList.isEmpty()) {
            System.out.println("No locations to display.\n");
            return;
        }

        for (Location loc : locationList) {
            System.out.println(loc.toString());
        }
    }

    // Option 3 - Search by Category
    public static void searchByCategory() {
        System.out.println("\n--- Search By Category ---");
        System.out.print("Enter category: ");
        String category = sc.nextLine();

        boolean found = false;

        for (Location loc : locationList) {
            if (loc.getCategory().equalsIgnoreCase(category)) {
                System.out.println(loc.toString());
                found = true;
            }
        }

        if (!found) {
            System.out.println("No locations found for this category.\n");
        }
    }

    // MAIN MENU
    public static void main(String[] args) {

        int choice = 0;

        do {
            System.out.println("====== Campus Location Helper ======");
            System.out.println("1. Add Location");
            System.out.println("2. View All Locations");
            System.out.println("3. Search By Category");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid input! Numbers only.\n");
                continue;
            }

            switch (choice) {
                case 1: addLocation(); break;
                case 2: viewLocations(); break;
                case 3: searchByCategory(); break;
                case 4: System.out.println("Goodbye!"); break;
                default: System.out.println("Invalid choice! Try again.\n");
            }
        } while (choice != 4);
    }
}
