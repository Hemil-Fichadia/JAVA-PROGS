package ExceptionHandling;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ExceptionDemo {
    public static void main(String[] args) throws IOException {

        System.out.println("Line - 1");
        System.out.println("Line - 2");

        File file = new File("abc.txt");
        System.out.println("After file object");

        FileReader fileReader = new FileReader(file); // <-- program breaks at this point

        System.out.println("After fileReader");

        fileReader.read();

        System.out.println("Last line only executes if all goes okay");
    }
}
