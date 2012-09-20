package dao;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<StockedBook> collections;

    public Library() {
        collections = new ArrayList<StockedBook>();
        collections.add(new StockedBook("C++ primer", 4, "Stanley B Lippman", "publisherA"));
        collections.add(new StockedBook("JAVA", 1, "Author1", "publisherB"));
        collections.add(new StockedBook("Ruby", 2, "SomeOne", "publisherC"));
        collections.add(new StockedBook("Python", 3, "anonymous", "publisherD"));
    }

    public void showAllCollectionBooks() {
        System.out.println("All Books Infomation:");
        System.out.println("--------------------------------------------------------------------");
        for (StockedBook book : collections) {
            book.printBookInfo();
        }
    }

    public void addBook(StockedBook stockedBook, User user) {
        if (collections.contains(stockedBook) && stockedBook.getCheckedStatus() == true) {
            return;
        }
        collections.add(stockedBook);
        stockedBook.setReserver(user);
    }

    public Integer searchBook(StockedBook bookToSearch) {
        if (collections.contains(bookToSearch)) {
            return collections.indexOf(bookToSearch);
        }
        return -1;
    }

    public String checkBookStatus(StockedBook book) {
        if (searchBook(book) < 0) {
            return Message.parseMessage("noBookFound").getMessage();

        }
        if (book.getCheckedStatus() == true) {
            return Message.parseMessage("alreadyReserved").getMessage();
        }
        return Message.parseMessage("successReservation").getMessage();
    }

    public void setBookReserved(StockedBook stockedBook) {
        stockedBook.setCheckedStatus(true);
    }

    public User getBookReserver(StockedBook book) {
        return book.getReserver();
    }

    public StockedBook findBookByName(String bookName) {
        for (StockedBook book : collections) {
            if (book.getBookName().equals(bookName)) {
                return book;
            }
        }
        return null;
    }

    public List<StockedBook> getCollections() {
        return collections;
    }
}
