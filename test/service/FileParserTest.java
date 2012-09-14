package service;

import org.junit.Test;

import java.io.IOException;

public class FileParserTest {
    @Test
    public void should_read_existed_file() throws IOException {
        String fileName = "textfile/listMenu";

        FileParser.fileParser(fileName);
    }
}
