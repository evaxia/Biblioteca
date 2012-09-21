package service;

import dao.Library;
import dao.StockedBook;
import dao.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LibraryService {
    private Library library;

    public LibraryService() {
        library = new Library();
    }

    public void parseCommand(int commandNumber) throws IOException {
        switch (commandNumber) {
            case 1:
                library.showAllCollectionBooks();
                break;
            case 2:
                reserveBookForUser(getBookToBeReserved());
                break;
            case 3:
                System.out.println("Please talk to Librarian. Thank you.");
                break;
            default:
                System.out.println("Select a valid option!!");
                break;
        }
        System.out.println("please input command number:");
    }

    public void reserveBookForUser(StockedBook book) throws IOException {
        User user = new User("user", "1000");
        if(book == null) {
            System.out.println("Sorry we don't have that book yet.");
            return;
        }
        user.addReservedBook(book);
    }

    protected StockedBook getBookToBeReserved() throws IOException {
        System.out.println("Please Input Book Name:");
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        return library.findBookByName(bufferedReader.readLine());
    }
}
