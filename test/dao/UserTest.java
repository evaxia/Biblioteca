package dao;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UserTest {
    @Test
    public void should_create_user() {
        User user = new User("user", "10000");

        assertThat(user.getName(), is("user"));
        assertThat(user.getUserIdentity(), is("10000"));
    }

    @Test
    public void should_get_message_when_display_all_ueser_collection() {
        User user = new User("user", "10000");

        String out = user.displayDetails();

        assertThat(out, is("Please talk to Librarian. Thank you."));
    }

    @Test
    public void should_get_reserved_book_list_for_user() {
        User user = new User("user", "1000");
        StockedBook book = new StockedBook("book", 1, "author", "publisher");
        user.addReservedBook(book);

        assertThat(user.getReservedBookList().contains(book), is(true));
        assertThat(book.getReserver(), is(user));
    }
}
