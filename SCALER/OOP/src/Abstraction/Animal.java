package Abstraction;

public abstract class Animal {
    /* As this is a class, so it will have methods and attributes
    but when we are not sure about how a method will be implemented,
    and also want non-static and non-finalized attributes, we should
    go with abstract class as interface makes methods abstract but
    attributes are made static and final so this is the area where we
    can use abstract methods also and make attributes non-static
    and non-final.
    Abstract means body-less

    Abstract class may or may not have abstract methods means a class
    can be abstract even without abstract methods, and we can even make
    class abstract if we want to restrict object creation of any class
    like we made a BaseModel class in E-commerce project, so we can make
    it abstract as it is barely useful individually but its main purpose
    is to hold those methods and attributes those are common across the
    models.
    * */
    String name;
    int age;

    /*
    * These methods are abstract as we are not sure for the
    * implementation of it but just declaring it here, so we
    * have to make it abstract*/
    abstract void eat();
    abstract void walk();
    /* This acts as a default method as it has body and
    have execution logic.
    * */
    void breathe(){
        System.out.println("Inhale");
        System.out.println("Exhale");
    }

    public static void main(String[] args){
        //We cannot create object of an abstract class;
        //Animal animal = new Animal();
    }
}
