package BuilderDesignPattern.FinalVersionStudentBuilder;

import BuilderDesignPattern.CustomExceptions.InvalidBatchInputException;
import BuilderDesignPattern.CustomExceptions.InvalidNameInputException;
import BuilderDesignPattern.CustomExceptions.InvalidPhoneNumberInputException;
import BuilderDesignPattern.CustomExceptions.UnderAgeCandidateException;
import BuilderDesignPattern.StudentBuilder;

public class BuilderImplementation {
    public static void main(String[] args) throws UnderAgeCandidateException, InvalidNameInputException, InvalidPhoneNumberInputException, InvalidBatchInputException {
        /* Now our objective is to make Student class's constructor directly depend on builder class
        and first builder object is created, and then it is fed to Student constructor, so first
        we need to make Student's constructor private, and then we need to make sure that StudentBuilder
        class is also the part of Student class so make Student class return object of StudentBuilder
        class so create a method inside Student class and this method is going to be in picture
        before object creation of Student's object, so it needs to be static and public.
        */
        //Here student class is returning builder method.
        /*Even this will not work as we are trying to achieve something that is incomplete
        and, so we have made Student class's constructor private and this is the line before
        we made the final change in the Student class and integrated the builder class inside
        Student class.
        */
//        StudentBuilder studentBuilder = Student.getBuilder();

        /* Now Student constructor is private and Builder is not really helping in creation of Student
        object so something is needed inside the builder method that builds the student object and
        directly passes it to Student's constructor, but wait this will not happen as Student's
        constructor itself is private, so we cannot call it inside Builder class and so, due this
        there comes another idea of nesting classes like include Builder class inside Student class
        itself.
        So the main benefit here, is that we are giving the responsibility to the class that is supposed
        to be handling the building part, now builder is having a build method which returns Student's
        object directly for use and that's the best part of this approach.

        The thing that we are trying to achieve here is, we want to make Student class and Builder
        class work for each other, and so we gradually optimised it and drew to a conclusion about
        integrating a getBuilder method in Student class so Student class itself is acting as
        Builder object provider, now still the Student class was accessible so Builder class was
        able to get bypass by client, so now we made Student class constructor private, and so we
        integrated Builder class inside Student class and before that we had a build method inside
        StudentBuilder class which was responsible to return Student object with values of StudentBuilder
        assigned to it but now as the Student class's constructor was private, so we had to integrate
        the whole class inside Student class but now getBuilder method was showing error as it is
        static and the class was not so the class StudentBuilder was to be made static.

        The actual thing we are trying to achieve is, to pass input in such a way
        Student student = Student.getBuilder()
                                 .setName("Hemil")
                                 .setAge(28)
                                 .setBatch("April-23 beginner morning-1")
                                 .setPsp(90.0)
                                 .build();
        by observing it, one thing is clear that once we get the builder object, we are setting all the
        parameters one by one but after getting builder object we are setting name, so it is legit but the
        operations that are carried out later needs builder object too and setName is of return type void
        and that's why we will change the return type of all the set methods to StudentBuilder, and this
        will solve the final issue, then we need to return "this" so it will refer to current class that is
        StudentBuilder, and we will be able to give input in above-mentioned fashion.
        */
        Student student = Student.getBuilder()
                            .setName("Hemil")
                              .setAge(24)
                                .setBatch("April-23 beginner morning-1")
                                 .setPsp(97.0)
                                  .setGradYear(2022)
                                    .setUniversity("Silver-oak")
                                     .setPhoneNumber("+91-9756061688")
                                        .build();
        /* Now in this way, there are no chance of mistakes that can happen related to entering data
        or StudentBuilder and Student being two separate class as now they are working together
        and the last benefit of it is, that we can directly set all the parameters at one go and
        get the Student object.

        The build method that is returning the Student object, is taking current StudentBuilder's
        object and then passing it in Student class's constructor, and it is accessible as they both
        are in the range of private attribute, and so at the last we will put all the validations
        inside build method as we will only build if they pass the requirements.
        * */

    }
}
