package ExceptionHandling;

public class UserNotFoundException extends Exception{
    /* If we extend Exception class that means we are extending checked exception
    and if we extend RuntimeException class that means we are extending unchecked exceptions
    and due to which compiler does not come into picture while.
    * */
    public UserNotFoundException(String message){
        super(message);
    }
}
