package service;

import dao.Library;
import dao.StockedBook;
import dao.User;
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
        libraryService.reserveBookForUser();

        assertThat(book.getCheckedStatus(), is(true));
        assertThat(book.getReserver().getName(), is("user"));
    }

    @Test
    public void should_verify_user_when_reserve_book() {
        User user = new User("userA", "1000");
        LibraryService libraryService = new LibraryService();

        libraryService.addUser(user);
        boolean isValid = libraryService.isRegisteredUser(user);

        assertThat(isValid, is(true));
    }

    @Test
    public void should_return_false_when_user_not_existed() {
        User user = new User("user", "1000900");
        LibraryService libraryService = new LibraryService();

        boolean isValid = libraryService.isRegisteredUser(user);

        assertThat(isValid, is(false));
    }
}
