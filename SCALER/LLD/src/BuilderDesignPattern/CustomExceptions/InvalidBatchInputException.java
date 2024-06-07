package BuilderDesignPattern.CustomExceptions;

public class InvalidBatchInputException extends Exception{
    public InvalidBatchInputException(String message){
        super(message);
    }
}
