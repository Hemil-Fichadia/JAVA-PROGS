package BuilderDesignPattern;

import BuilderDesignPattern.CustomExceptions.InvalidBatchInputException;
import BuilderDesignPattern.CustomExceptions.InvalidNameInputException;
import BuilderDesignPattern.CustomExceptions.InvalidPhoneNumberInputException;
import BuilderDesignPattern.CustomExceptions.UnderAgeCandidateException;

public class Client {
    public static void main(String[] args) throws UnderAgeCandidateException, InvalidNameInputException, InvalidPhoneNumberInputException, InvalidBatchInputException {
        /* BUILDER DESIGN PATTERN
        Use-case :- Let's say we have a class with lot of attributes, and we even decided to
        validate the object before getting created.

        class Student{
            String name;
            int age;
            String batch;
            double psp;
            String university;
            int gradYear;
            String phone;
        }

        What we used to do was first create an object of the class and then set the attributes,
        but this time we want to validate before its creation, so what can we do to act it like the
        object is created only if all the attributes are satisfying the condition ?

        Firstly, the validations belongs to Student class, so validations are supposed to be carried
        out inside the Student class, and the one that is responsible for object creation needs to take
        all of them as argument as all args constructor and then initiate check for each attribute,
        and if the validation fails then it should throw some sort of exception so that values are
        not initialized to class attributes.
        * */

        ValidationClass validationClass = new ValidationClass("Hemil",
                24,
                "APR-23 Beginner Tuesday Morning-1",
                97.68, 2022, "Silver Oak", "+91-9272309809"
                );
        System.out.println("Name : " + validationClass.name +
                "\n age : " + validationClass.age +
                "\n batch : " + validationClass.batch +
                "\n psp : " + validationClass.psp +
                "\n Grad year : " + validationClass.gradYear +
                "\n University : " + validationClass.gradYear +
                "\n Phone Number : " +validationClass.phoneNumber
                );
        /* This one is with some invalid input and this thing is working
        * */
        ValidationClass validationClass1 = new ValidationClass("!Hemil",
                17,
                "APR-23 Beginner Tuesday Morning-1",
                97.68, 2022, "Silver Oak", "+91-9272309809"
        );
        System.out.println("Name : " + validationClass1.name +
                "\n age : " + validationClass1.age +
                "\n batch : " + validationClass1.batch +
                "\n psp : " + validationClass1.psp +
                "\n Grad year : " + validationClass1.gradYear +
                "\n University : " + validationClass1.gradYear +
                "\n Phone Number : " +validationClass1.phoneNumber
        );

        /* The way we followed here is very tedious in nature to fill the exact data at the respective
        place like we have to check that which comes next in parameter sequence and for the String
        data any kind of data can be fed like University name is fed to name attribute and batch is
        fed to University attribute and so on.

        Another issue is, like not all the attributes are going to be initialized at the time of
        object creation, like there can be a situation where some attributes are going to be
        decided later like rank, PSP, batch etc so those attributes are going to be set as default
        value and due to that, the way we achieved the functionality, is definitely not the best
        way we can go with.

        As we have quite a lot number of attributes, we would like to have some combination of
        constructors in order to provide the feature for creating an object with only those number
        of attributes to be assigned and throw exception accordingly, so it will be very difficult
        to create all combinations of constructors with unique method signature as two parameters
        as String argument are considered as one so even here we will have to manage a lot more
        things than it is required.

        So the level of complexity and least level of maintainability this approach packs with,
        which is not even possible to think of if there are 20 or more than 20 attributes.

        Conclusion :-
        It is difficult to understand and prone to errors as well.

        Possible solution :-
        Here our requirement is that a single parameter which is capable enough pass parameters in
        form of key value pairs like name : abc, age : 23, batch : april 23 morning, and the best
        contestant for it is a custom class because a HashMap is not capable of storing data types in
        dynamic fashion and if the key is a type of String then it is prone to errors so overall
        custom class is the best way to pass as an argument while creating an object and also provides
        compile time check as we are storing attribute data type specific things only.

        Now while creating Student object we will pass this helper object that have all the attributes
        just as Student class, and we will validate the input data coming from helper class so this helper
        class which have attributes same as the class for which it is supposed to deliver is called as
        builder class, and we name that builder class with the name of the class it is helping like here
        it would be StudentHelper.
        * */

        

    }
}
