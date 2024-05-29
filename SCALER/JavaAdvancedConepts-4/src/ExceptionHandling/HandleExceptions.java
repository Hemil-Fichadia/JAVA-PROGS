package ExceptionHandling;

import java.util.InputMismatchException;
import java.util.Scanner;

public class HandleExceptions {
    static void fun1(){
        Scanner input = new Scanner(System.in);
        try{
            int a = input.nextInt();
            int b = input.nextInt();
            int ans = a / b;
            System.out.println(ans);
            if(a == 10){
                return;
            }
        }
        catch(ArithmeticException ae){
            System.out.println("Cannot divide by 0, please enter some non-zero value");
        }
        catch(InputMismatchException inme){
            System.out.println("Please enter integral non-zero value");
        }
        catch(Exception e){
            System.out.println("Some exception has occurred");
        }
        finally {
            /* This finally block is very useful in cases of reading a file, making a network
            call to database etc. so how it helps is, when file read task is done, we make sure we
            close the file, so that it is accessible to other threads or users and similarly, if
            the database operation is carried out for a certain amount of execution, so we need
            to release the resources of it and that is supposed to be done even if there is kind
            of failure.
            * */
            System.out.println("This will execute no matter what happens, even if there is a return statement");
        }
    }

    public static void main(String[] args){
        /* It is important to handle exceptions, as we want to make sure that our program
        does not stop abruptly and give a sensible message to user like file is not available
        at the expected destination, cannot divide by 0 enter some other number, enter only
        whole or integer numbers etc.

        So whichever block of code is expected to throw some exception at any given point of time,
        is included inside try block and the exception that can occur is caught in catch block
        try{
            line - 1
            line - 2
            line - 3
        }
        catch(Exception e){
            System.out.println("message for user");
        }
        So whenever any exception is encountered at any line, from there itself the program
        flow is diverted to respective catch block.
        What I mean by respective catch block is, if we have only included ArithmeticException catch
        block and if there is a FileNotFoundException, then it will not be handled as expected,
        although it is handled at class level, so we don't actually need to implement it method level,
        but this is just an example of what is supposed to be done in case if we are not sure what
        kind of exception can occur, So we have provision of having multiple catch blocks with single
        try, and it will serve the purpose, and we also have the main Exception class itself that
        can catch all kind of exceptions so after adding all potential exception catch blocks, at last
        Exception class can be added at the end for making our code fail proof.
        * */
        fun1();

        /* *) final vs finally vs finalize
        final is a keyword, if used with an attribute, then makes it constant, if used with a method
        then it cannot be overridden and if used with a class, then it cannot be extended.

        finally is used with try catch block to execute a program that is important irrespective of
        try block have successful execution or not.

        finalize is a method which is used to explicitly make garbage collector collect it.
        * */
    }
}
