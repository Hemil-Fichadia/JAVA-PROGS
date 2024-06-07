package BuilderDesignPattern;

import BuilderDesignPattern.CustomExceptions.InvalidBatchInputException;
import BuilderDesignPattern.CustomExceptions.InvalidNameInputException;
import BuilderDesignPattern.CustomExceptions.InvalidPhoneNumberInputException;
import BuilderDesignPattern.CustomExceptions.UnderAgeCandidateException;

public class Student {
    String name;
    int age;
    String batch;
    double psp;
    int gradYear;
    String university;
    String phoneNumber;

    public Student(StudentBuilder studentBuilder) throws InvalidNameInputException, UnderAgeCandidateException, InvalidBatchInputException, InvalidPhoneNumberInputException {
        if(studentBuilder.getName().contains("!") || studentBuilder.name.contains("@") || studentBuilder.name.contains("#") || studentBuilder.name.contains("%") || studentBuilder.name.contains("^") || studentBuilder.name.contains("&") || studentBuilder.name.contains("*")){
            throw new InvalidNameInputException("Please enter characters apart from special ");
        }
        else{
            this.name = studentBuilder.getName();
        }
        if(studentBuilder.age < 18){
            throw new UnderAgeCandidateException("Age should be 18 or above");
        }
        else{
            this.age = studentBuilder.getAge();
        }
        if(studentBuilder.batch.contains("!")){
            throw new InvalidBatchInputException("Invalid batch input");
        }
        else{
            this.batch = studentBuilder.getBatch();
        }
        this.psp = studentBuilder.getPsp();
        this.gradYear = studentBuilder.getGradYear();
        this.university = studentBuilder.getUniversity();
        if(studentBuilder.getPhoneNumber().length() != 14){
            throw new InvalidPhoneNumberInputException("Enter 10 digit phone number with country code with '-'");
        }
        else{
            this.phoneNumber = studentBuilder.getPhoneNumber();
        }
    }
}
