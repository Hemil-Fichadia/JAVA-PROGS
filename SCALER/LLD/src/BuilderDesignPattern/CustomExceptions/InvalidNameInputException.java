package BuilderDesignPattern.CustomExceptions;

public class InvalidNameInputException extends Exception{
    public InvalidNameInputException(String message){
        super(message);
    }
}
