package Polymorphism;

public class B extends A{
    String univName;
    /* This is Method Overriding / Runtime polymorphism
    When a child class changes the behaviour of a method without changing
    the signature of the method is called method overriding.
    Here there is a fun method in class A and also a fun method in class B
    the difference is class A's fun() method prints "Hello" and class B's
    fun() method prints "Hey".

    If we try to change method signature, means change the number of arguments
    or change the return type of the method then it will result to compilation
    error and so here we are not doing it, so the only thing we are changing is
    the internal logic of the fun() method so if we simply create A's object and
    call fun() method then it will print "Hello" but if we store B's object in
    A's reference and then call the fun() method like this A a1 = new B();
    a1.fun() then it will print "Hey", the reason is quite simple, while
    compilation, compiler just checks for the left hand side of the variables
    or makes sure that exact data type is stored in a variable, and objects
    are created at runtime and if the fun() method is called with B's object
    then there will be ambiguity like whose method should be called A or B
    so to eliminate this ambiguity, java calls the method whose object is
    created not whose reference is made so even if we do A a1 = new B() and
    then call fun() method still it will print "Hey" as it prefers to object
    of the class and as this is decided at runtime this Runtime polymorphism.
    * */
    @Override
    void fun(){
        System.out.println("Hey");
    }

    public static void main(String[] args){
        A a = new A();
        a.fun(); //<-- This will print Hello
        A a1 = new B();
        a1.fun(); //<-- This will print Hey
    }
}
