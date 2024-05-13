package Lambdas;

import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class LambdasDetails {
    public static void main(String[] args){
        /* If we want to create object of an interface, we can't make it as an
        interface where it has methods that don't have body, so we cannot create an object
        of it.

        Let's say we want to make use of a method of an interface without implementing it to
        a class and then Override that method there and then make object of that class and call
        that method with its object. So this shows that if we look for to find any short-cut to
        use any interface declared method, there were none till now, but now we have in form of
        Lambdas.
        * */

        //Anonymous Class
        /* Here we are directly defining the method while calling the interface object as now
        we are committing to define that method of interface so java allows us to create object
        of interface.
        Here it's okay to create anonymous class here as this interface have only one method if
        any interface have multiple methods, and we create anonymous class, so we have to Override
        all those methods while creating its object, and that's not a clean way.
        * */
        SampleInterface obj1 = new SampleInterface() {
            @Override
            public void fun1(){
                System.out.println("Anonymous class");
            }
        };
        obj1.fun1();

        //Using BiConsumer functional interface
        BiConsumer<String, Integer> biConsumer = new BiConsumer<String, Integer>() {
            @Override
            public void accept(String s, Integer integer) {
                System.out.println("String "+ s + ", Integer " + integer);
            }
        };
        biConsumer.accept("Scaler", 1);

        //Lambda expression
        //This is the 3rd way to provide method body for an interface.
        /* Java introduced Lambda expression in java-8, but other languages had this even before
        java, so java was not the first one to introduce.
        If we use this kind of Lambda expression with interface having multiple methods then it will
        get confused with the choice for which method we are providing the implementation as we are not
        specifying the name while defining the logic.
        So lambda expressions are only used with functional interfaces as it have only one single abstract
        method, so as there is only one method that is body less, and we are providing logic for it only
        so those built-in functional interfaces are helpful as we don't need to define it everytime, we
        can just call it and make use accordingly.
        These built-in functional interfaces save us from creating new one every time, but if we are too
        specific about our use case, we can build one functional interface of our own and plug and play
        but the point is, to use Lambda expressions, interfaces must be equipped with only one method
        that is body-less or say abstract, so it is crystal clear for compiler to map the method and
        there is no ambiguity.

        Syntax of Lambda :-
        FunctionalInterface<T> name = (params) -> {
            //logic
        }
        * */
        //The data type passed in generic is mapped in parentheses, in sequence if there are more than one
        //Here x is considered as String
        Consumer<String> consumer = (x) -> {
            System.out.println("Consumer lambda implementation " + x);
        };
        consumer.accept("Scaler");
        //Here x is String and y is Integer
        BiConsumer<String, Integer> biConsumer1 = (x, y) -> {
            System.out.println("BiConsumer Lambda expression " + "String : "+ x + ", Integer : " + y);
        };
        biConsumer1.accept("Scaler", 1);
        //Binary operator means addition, subtraction
        BinaryOperator<Integer> binaryOperator = (x, y) -> {
            return x + y;
        };
        System.out.println("Binary operator Lambda expression : " + binaryOperator.apply(10, 15));

        //Predicate means boolean
        Predicate<String> predicate = (str) -> {
            return str.length() > 10;
        };
        System.out.println("Predicate Lambda expression :  " + predicate.test("Hemil"));

        //Same as above
        //Predicate means boolean
        //We can also write this expression like this if our implementation is of one line.
        Predicate<String> predicate1 = (str) -> str.length() > 10;
        System.out.println("Predicate Lambda expression :  " + predicate.test("Hemil Fichadia"));

        //Runnable is also a functional interface, this is one other way to make a task
        Runnable runnable = () -> {
            System.out.println("Hello world printed by : " + Thread.currentThread().getName());
        };
        Thread thread = new Thread(runnable);
        thread.start();

        //More optimal way to write it
        /* Thread internally takes Runnable interface, so it is understood by compiler
        the parentheses inside it is of type Runnable, so we can directly express is like this.
        * */
        Thread thread1 = new Thread(
                () -> System.out.println("Hello world printed by : " + Thread.currentThread().getName())
        );
        thread1.start();
    }
}
