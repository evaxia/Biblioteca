package service;

import dao.Library;
import dao.StockedBook;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class LibraryServiceTest {
    private Library library;

    @Before
    public void setUp() {
        library = new Library();
    }
    @Test
    public void should_parser_command_when_list_menu() throws IOException {
        LibraryService libraryService = new LibraryService();

        libraryService.parseCommand(1);
    }

    @Test
    public void should_reserve_book_for_user() throws IOException {
        LibraryService libraryService = new LibraryService();

        StockedBook book = library.getCollections().get(0);
        libraryService.reserveBookForUser(book);

        assertThat(book.getCheckedStatus(), is(true));
        assertThat(book.getReserver().getName(), is("user"));
    }

}
