package ConstructorChaining;

public class D extends C{
    D(){
        /* If default constructor in parent is absent, and
        we only have a parametrized constructor, then, before
        any logic of child class gets executed, we need to have
        parent's constructor needs to be declared and in order to
        call it we have a keyword called "super(arguments)" which
        will by default call the immediate parent. So using super
        keyword even if the default constructor is present in
        class we can still trigger the parametrized constructor.
        * */
        super("1 param C's constructor");
        System.out.println("D's constructor");
    }
    public static void main(String[] args){
        /* The class D extends class C, C extends B,
        B extends A, so this is a chain reaction of
        constructors or say constructor chaining as when
        we will call D via an object then D's default constructor
        will call its immediate parent's constructor and so due
        to this principal D will call C, C will call B and B
        will call A, here calls are done by default constructors of
        all the classes.

        If we create some parametrized constructor then java does not
        provide us any default constructor and so the child class would
        not be able to call the default constructor of the parent class
        so when we are using inheritance, and if there is going to be
        some parametrized constructors then it is better to declare
        a default no args constructor also.

        Child is only capable of calling the parent's default constructor
        on its own but if somehow default constructor is not available then
        it won't be able to call its immediate parent's default constructor
        * */
        D d = new D();
    }
}
