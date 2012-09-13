package dao;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StockedBookTest {
    @Test
    public void should_create_book() {
        StockedBook book = new StockedBook("book1", 1, "authorA", "publisherA");

        assertThat(book.getBookName(), is("book1"));
        assertThat(book.getVersion(), is(1));
        assertThat(book.getAuthorName(), is("authorA"));
        assertThat(book.getPublisher(), is("publisherA"));
        assertThat(book.getCheckedStatus(), is(false));
    }
}
