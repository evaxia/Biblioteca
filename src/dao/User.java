package dao;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String userName;
    private String userIdentity;
    private List<StockedBook> reservedBookList;

    public User(String userName, String userIdentity) {
        this.userName = userName;
        this.userIdentity = userIdentity;
        reservedBookList = new ArrayList<StockedBook>();
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

    public List<StockedBook> getReservedBookList() {
        return reservedBookList;
    }

    public void addReservedBook(StockedBook book) {
        reservedBookList.add(book);
        book.setCheckedStatus(true);
        book.setReserver(this);
        System.out.println("Thank You! Enjoy the book.");
    }

    public void showAllUserBooks() {
        System.out.println("All books reserved for User " +userName);
        System.out.println("----------------------------------------------------");
        for (StockedBook book : reservedBookList) {
            book.printBookInfo();
        }
    }
}
