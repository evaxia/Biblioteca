package service;

import dao.Library;

public class LibraryService {
    private Library library;

    public LibraryService() {
        library = new Library();
    }

    public void parseCommand(int commandNumber) {
        switch (commandNumber) {
            case 1:
                library.showAllCollectionBooks();
                break;
            case 2:
                System.out.println("TO BE ADDED");
<<<<<<< HEAD
=======

>>>>>>> finish first level select
                break;
            case 3:
                System.out.println("TO BE ADDED");
                break;
            default:
                break;
        }
    }
}
