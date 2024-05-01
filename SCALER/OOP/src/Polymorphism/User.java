package Polymorphism;

public class User {
    User(){
        System.out.println("user constructor");
    }

    void sayHello(){
        System.out.println("Hello");
    }

    void sayHello(String name){
        System.out.println("Hello "+name);
    }


    public static void main(String[] args){
        /* Method Overloading / Compile time polymorphism
        Here there are two methods of same name and same return type but the parameters
        are different, in first method, there are no parameters at all and in second method
        there is only single parameter of String type so this is possible but a method with
        same name and similar parameters but different return type is not allowed so actually
        return type does not matter, the arrangement of parameters and count of parameters
        matters and this identity of methods is called method signature and same method
        signature is not considered as any kind of polymorphism.
        * */
        User user = new User();
        user.sayHello(); //<-- this will call the method with no parameters
        user.sayHello("Hemil"); //<-- this will call the method with single String parameter

    }
}
