package BuilderDesignPattern;

import BuilderDesignPattern.CustomExceptions.InvalidBatchInputException;
import BuilderDesignPattern.CustomExceptions.InvalidNameInputException;
import BuilderDesignPattern.CustomExceptions.InvalidPhoneNumberInputException;
import BuilderDesignPattern.CustomExceptions.UnderAgeCandidateException;

public class ValidationClass {
    String name;
    int age;
    String batch;
    double psp;
    int gradYear;
    String university;
    String phoneNumber;

    public ValidationClass(String name, int age, String batch, double psp, int gradYear, String university, String phoneNumber) throws InvalidNameInputException, UnderAgeCandidateException, InvalidBatchInputException, InvalidPhoneNumberInputException {
        if(name.contains("!") || name.contains("@") || name.contains("#") || name.contains("%") || name.contains("^") || name.contains("&") || name.contains("*")){
            throw new InvalidNameInputException("Please enter characters apart from special ");
        }
        else{
            this.name = name;
        }
        if(age < 18){
            throw new UnderAgeCandidateException("Age should be 18 or above");
        }
        else{
            this.age = age;
        }
        if(batch.contains("!")){
            throw new InvalidBatchInputException("Invalid batch input");
        }
        else{
            this.batch = batch;
        }
        this.psp = psp;
        this.gradYear = gradYear;
        this.university = university;
        if(phoneNumber.length() != 14){
            throw new InvalidPhoneNumberInputException("Enter 10 digit phone number with country code with '-'");
        }
        else{
            this.phoneNumber = phoneNumber;
        }
    }
}
