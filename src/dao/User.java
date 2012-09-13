package dao;

public class User {
    private String userName;
    private String userIdentity;

    public User(String userName, String userIdentity) {
        this.userName = userName;
        this.userIdentity = userIdentity;
    }

    public String getName() {
        return userName;
    }

    public String getUserIdentity() {
        return userIdentity;
    }

    public String displayDetails() {
        return "Please talk to Librarian. Thank you.";
    }
}
