package lab7;

public class User {
    protected String userID;
    protected String name;

    public User(String userID, String name) {
        this.userID = userID;
        this.name = name;
    }

    public String getUserID() { return userID; }
    public String getName() { return name; }

    public String getRole() {
        return "General User";
    }
}
