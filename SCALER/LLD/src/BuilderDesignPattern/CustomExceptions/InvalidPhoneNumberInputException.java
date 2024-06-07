package BuilderDesignPattern.CustomExceptions;

public class InvalidPhoneNumberInputException extends Exception{
    public InvalidPhoneNumberInputException(String message){
        super(message);
    }
}
