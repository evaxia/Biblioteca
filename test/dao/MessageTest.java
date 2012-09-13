package dao;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MessageTest {
    @Test
    public void should_display_message_for_invalid_select() {
        Message info = Message.parseMessage("invalidSelect");

        assertThat(info.getMessage(), is("Select a valid option!!"));
    }

    @Test
    public void should_display_message_for_success_reservation() {
        Message info = Message.parseMessage("successReservation");

        assertThat(info.getMessage(), is("Thank You! Enjoy the book."));
    }

    @Test
    public void should_display_message_for_no_book_found_in_library() {
        Message info = Message.parseMessage("noBookFound");

        assertThat(info.getMessage(), is("Sorry we don't have that book yet."));
    }

    @Test
    public void should_display_message_for_get_more_information_() {
        Message info = Message.parseMessage("forMoreDetails");

        assertThat(info.getMessage(), is("Please talk to Librarian. Thank you."));
    }
}
