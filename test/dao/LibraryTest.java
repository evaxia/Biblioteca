package dao;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class LibraryTest {
    private StockedBook stockedBook;
    private Library library;

    @Before
    public void setUp() {
        stockedBook = new StockedBook("book", 1, "author", "publisher");
        library = new Library();

    }

    @Test
    public void should_display_all_book_library_has() {
        library.addBook(stockedBook, null);

        String output = library.showAllCollectionBooks();

        assertThat(output, is("All Books Infomation:\n------------------------------\nbook  1 edition  author  publisher"));
    }

    @Test
    public void should_return_index_when_search_book_in_library_() {
        library.addBook(stockedBook, null);

        Integer index = library.searchBook(stockedBook);

        assertThat(index, is(0));
    }

    @Test
    public void should_return_negative_when_search_book_in_library_() {
        Integer index = library.searchBook(stockedBook);

        assertThat(index, is(-1));
    }

    @Test
    public void should_check_existed_and_reserved_book_status() {
        library.addBook(stockedBook, null);
        library.setBookReserved(stockedBook);

        String status = library.checkBookStatus(stockedBook);

        assertThat(status, is("Sorry, this book has already been reserved."));
    }

    @Test
    public void should_check_existed_and_not_reserved_book_status() {
        library.addBook(stockedBook, null);

        String status = library.checkBookStatus(stockedBook);

        assertThat(status, is("Thank You! Enjoy the book."));
    }

    @Test
    public void should_return_error_message_when_checked_book_not_existed() {
        String status = library.checkBookStatus(stockedBook);

        assertThat(status, is("Sorry we don't have that book yet."));
    }

    @Test
    public void should_return_owner_of_reserved_book() {
        User expectedUser = new User("user", "10000");
        library.addBook(stockedBook, expectedUser);

        User reserver = library.getBookReserver(stockedBook);

        assertThat(reserver, is(expectedUser));
    }
}
