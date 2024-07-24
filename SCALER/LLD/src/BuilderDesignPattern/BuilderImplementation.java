package BuilderDesignPattern;

import BuilderDesignPattern.CustomExceptions.InvalidBatchInputException;
import BuilderDesignPattern.CustomExceptions.InvalidNameInputException;
import BuilderDesignPattern.CustomExceptions.InvalidPhoneNumberInputException;
import BuilderDesignPattern.CustomExceptions.UnderAgeCandidateException;

public class BuilderImplementation {

    public static void main(String[] args) throws UnderAgeCandidateException, InvalidNameInputException, InvalidPhoneNumberInputException, InvalidBatchInputException {
        /* Builder design pattern :-
        A helper class which is passed as an argument in a class's constructor while object creation
        is a builder design pattern.
        We will pass StudentBuilder class object as argument and inside Student constructor and initialize
        the values that we receive from it to the attributes of Student class and validate the object
        before its creation.
        */
        StudentBuilder studentBuilder = new StudentBuilder();
        studentBuilder.setName("Hemil");
        studentBuilder.setAge(24);
        studentBuilder.setBatch("APR-23 Beginner morning-1");
        studentBuilder.setGradYear(2022);
        studentBuilder.setPsp(81);
        studentBuilder.setUniversity("Silver Oak");
        studentBuilder.setPhoneNumber("+91-9834823456");
        Student student = new Student(studentBuilder);
        System.out.println("Name : " + student.name +
                "\n age : " + student.age +
                "\n batch : " + student.batch +
                "\n psp : " + student.psp +
                "\n Grad year : " + student.gradYear +
                "\n University : " + student.gradYear +
                "\n Phone Number : " +student.phoneNumber
        );
        /*
        We could have applied all the validations in the builder class, but if anyone observes the
        Student class they won't have any clue of what this class demands to be validated, so
        validations are supposed to be present inside Student class.

        Still here there is hardly any impact of Builder as we are only reducing the size of
        input parameter in Student class rest all operations are carried out on client side.
        It seems somewhat convincing, but now StudentBuilder and Student are two independent class and
        anyone can bypass the use of StudentBuilder class and can directly call the Student object
        and make use of it, but we want to make client to use StudentBuilder class instead directly using
        the Student class's constructor.

        Continued in FinalVersionStudentBuilder ...........
        * */
    }
}
