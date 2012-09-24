package service;

import dao.Library;
import dao.StockedBook;
import dao.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class LibraryService {
    private Library library;
    private List<User> users;
    private User currentUser;

    public LibraryService() {
        currentUser = null;
        library = new Library();
        users = new ArrayList<User>();
        users.add(new User("eva", "user"));
        users.add(new User("blair", "user"));
        users.add(new User("damon", "user"));
        users.add(new User("nikita", "user"));
        users.add(new User("penny", "user"));

    }

    public void parseCommand(int commandNumber) throws IOException {
        switch (commandNumber) {
            case 1:
                library.showAllCollectionBooks();
                break;
            case 2:
                reserveBookForUser();
                break;
            case 3:
                checkUserInfo();
                break;
            default:
                System.out.println("Select a valid option!!");
                break;
        }
        System.out.println("please input command number:");
    }

    private void checkUserInfo() throws IOException {
        if(currentUser != null) {
            currentUser.displayDetails();
            return;
        }
        if(!getCurrentUser())return;
        currentUser.displayDetails();

    }

    public void reserveBookForUser() throws IOException {
        if(!getCurrentUser())return;
        StockedBook book = getBookToBeReserved();

        if (book == null) {
            System.out.println("Sorry we don't have that book yet.");
            return;
        }
        currentUser.addReservedBook(book);
    }

    private boolean getCurrentUser() throws IOException {
        if(currentUser == null) {
            System.out.println("Please log in first!!");
            User user = getUserInfo();
            if(!isRegisteredUser(user)){
                System.out.println("Your are not valid User!");
                return false;
            }
            currentUser = user;
        }
        return true;
    }

    public User getUserInfo() throws IOException {
        System.out.println("please input your name:");
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String name = bufferedReader.readLine();
        System.out.println("please input your password:");
        String password = bufferedReader.readLine();
        return new User(name, password);
    }

    protected StockedBook getBookToBeReserved() throws IOException {
        System.out.println("Please Input Book Name:");
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        return library.findBookByName(bufferedReader.readLine());
    }


    public void addUser(User user) {
        users.add(user);
    }

    public boolean isRegisteredUser(User user) {
        for (User existedUser : users) {
            if(user.getName().equals(existedUser.getName()) && user.getPassword().equals(existedUser.getPassword())) {
                user.setLoggedInStatus(true);
                return true;
            }
        }
        return false;
    }
}
