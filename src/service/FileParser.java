package service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileParser {
    public static void fileParser(String fileName) throws IOException {
        FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = null;
        while((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }
    }
}
