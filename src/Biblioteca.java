import service.FileParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Biblioteca {
    public static void main(String[] args) throws IOException {
        String welcome = "textfile/welcomePage";
        String listmenu = "textfile/listMenu";

        FileParser.fileParser(welcome);
        FileParser.fileParser(listmenu);

        String input = null;
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        while((input = bufferedReader.readLine()) != "exit") {
            //TODO an implementation of command template
        }

    }
}
