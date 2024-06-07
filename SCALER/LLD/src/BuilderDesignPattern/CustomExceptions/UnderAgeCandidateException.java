package BuilderDesignPattern.CustomExceptions;

public class UnderAgeCandidateException extends Exception{
    public UnderAgeCandidateException(String message){
        super(message);
    }
}
