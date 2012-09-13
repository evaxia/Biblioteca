import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Biblioteca {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("textfile/welcomePage"));
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }
    }
}
