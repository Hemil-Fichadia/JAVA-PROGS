package ExceptionHandling;

public class ExceptionDetails {
    public static void main(String[] args){
        /* Exception :-
        Exception means something unusual or unexpected that have occurred that needs to
        be addressed to move ahead.

        We have an algorithm that reads a file that is supposed to be present in the given location,
        but due to user side error that file is not present, so it should throw FileNotFoundException
        similarly if a user is trying to carry out an operation that divides by zero, then it should
        throw ArithmeticException and if the algorithm is accessing some index of array that is not
        in the range of it then program will throw ArrayIndexOutOfBound Exception.

        These were some scenarios where there is a potential of something unusual to occur at the
        run time so as these cases can only arise at run time so these are exceptions not errors.
        Error means mistake, that is either related to logical or syntactical, syntactical errors are
        caught by compiler and logical errors are addressed by developers by running test cases, but
        the issues or unexpected things that happen at the run time are categorized as Exceptions.

        What if we don't handle exception ? then program will crash or stop, so we need to handle
        exception on our own.

        Assume that we have an algorithm that reads file and processes the data after reading, but
        the file is missing from the expected location, so if the lines after the file reading logic,
        will have some unique kind of exception like NullPointerException so the developer might get
        misdirected due to it so due to this reason, the program crashes at the line where exception
        occurs, that also means the lines after file reading logic will be skipped.

        Run and confirm it in ExceptionDemo class.
        * */
    }
}
