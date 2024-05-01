package Abstraction;

public class Dog extends Animal{
    /* this class Dog extends abstract class Animal
    and just like interface, it needs to override all
    the abstract methods of Animal class.
    * */
    @Override
    void eat() {
        System.out.println("Dog is eating");
    }

    @Override
    void walk() {
        System.out.println("Dog is walking");
    }

    public static void main(String[] args){
        Animal animal = new Dog();
        animal.eat();
        animal.walk();
        animal.breathe();
    }
}
