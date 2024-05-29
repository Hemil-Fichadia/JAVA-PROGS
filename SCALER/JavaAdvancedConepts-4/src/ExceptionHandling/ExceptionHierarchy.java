package ExceptionHandling;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ExceptionHierarchy {

    /*  Throws :-
        Throws is used only if we intend to pass on that exception to the functionality provider
        or to the caller, and we can throw multiple exception using comma separator.
        Throws is used at method level.

        Throw :-
        Throw is used where we need to handle exception on our own like if user enters 0, then
        throw RuntimeException just like that.
    * */
    static void fun1() throws IOException {
        File file = new File("abc.txt");
        FileReader fileReader = new FileReader(file);
        fileReader.read();
    }

    public static void main(String[] args){
        /*                                     Exception Hierarchy

                                                                    Throwable
                                                                        ^
                                                                        |
                                                                        |
                                           ---------------------------------------------------------
                                           ^                                                       ^
                                           |                                                       |
                                           |                                                       |
                                       Exception                                                 Error <--- Our program cannot recover in case of error
                                           ^                                                       ^
                                           |                                                       |
                                           |                                                       |
                          --------------------------------------                       -------------------------
                          ^                     ^       ^      ^                       ^                        ^
                          |                     |       |      |                       |                        |
                          |                     |       |      |                       |                        |
                   RunTimeException             File    SQL    IOE                  StackOver                 Memory
                          ^                     Not                                 Flow                      Limit
                          |                     Found
                          |                     Exception
                --------------------------
                ^           ^            ^
                |           |            |
                |           |            |
              Null        Arithmetic     Array
              Pointer     Exception      IndexOutOfBound
              Exception                  Exception

        There are two kind of Exceptions,
        1) That are directly extending Exception class
        2) That are extending RunTimeException

        *) Checked vs Unchecked Exceptions
            1) Unchecked Exceptions / RunTimeExceptions:-
            The class which are directly extending RunTimeException class
            are called as unchecked exceptions.

            2) Checked Exceptions / CompileTime Exceptions:-
            The class which directly extends Exception class are called
            checked exceptions. The classes that extends Exceptions class directly are
            FileNotFoundException, InputMismatchException SQLException etc. this shows that these
            exceptions can arise even if we have written code correctly.
        * */
        //fun1();
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        int b = input.nextInt();
        if(b == 0){
            throw new RuntimeException("Please enter some non-zero Integer value");
        }
    }
}
