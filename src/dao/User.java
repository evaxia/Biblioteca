package dao;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String userName;
    private List<StockedBook> reservedBookList;
    private String password;
    private Boolean loggedInStatus;

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
        this.loggedInStatus = false;
        reservedBookList = new ArrayList<StockedBook>();
    }

    public String getName() {
        return userName;
    }

    public void displayDetails() {
        if(reservedBookList.size() == 0 ){
            System.out.println("You have no book reserved.you may input 2 command to reserve new book!");
            return;
        }
        System.out.println("All book reserved for you:");
        for (StockedBook stockedBook : reservedBookList) {
            stockedBook.printBookInfo();
        }
        System.out.println("-----------------------------------------------");
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

    public String getPassword() {
        return password;
    }

    public Boolean getLoggedInStatus() {
        return loggedInStatus;
    }

    public void setLoggedInStatus(Boolean loggedInStatus) {
        this.loggedInStatus = loggedInStatus;
    }
}
