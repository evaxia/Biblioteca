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
                System.out.println("TO BE ADDED");
                break;
            default:
                break;
        }
    }

    public void reserveBookForUser(StockedBook book) throws IOException {
        User user = new User("user", "1000");
        if (library.isBookInLibrary(book)) {
            user.addReservedBook(book);
        }

    }

    protected StockedBook getBookToBeReserved() throws IOException {
        System.out.println("Please Input Book Name:");
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        return library.findBookByName(bufferedReader.readLine());
    }


}
