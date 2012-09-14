package service;

import org.junit.Test;

public class LibraryServiceTest {
    @Test
    public void should_parser_command_when_list_menu() {
        LibraryService libraryService = new LibraryService();

        libraryService.parseCommand(1);


    }
}
