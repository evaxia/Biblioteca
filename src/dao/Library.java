package dao;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<StockedBook> collections;

    public Library() {
        collections = new ArrayList<StockedBook>();
    }

    public void showAllCollectionBooks() {
        System.out.println("All Books Infomation:\n------------------------------\nbook  1 edition  author  publisher");
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
}
