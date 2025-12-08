package javaConsoleApp;

public class Location {
    private String name;
    private String category;
    private String description;

    public Location(String name, String category, String description) {
        this.name = name;
        this.category = category;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Name: " + name +
               "\nCategory: " + category +
               "\nDescription: " + description + "\n";
    }
}
