package Interfaces;

public class Dog implements Animal{

    @Override
    public void eat() {
        System.out.println("Dog eats");
    }

    @Override
    public void walk() {
        System.out.println("Dog walks");
    }

    @Override
    public void run() {
        System.out.println("Dog runs");
    }

    @Override
    public String changeColour(){
        String state = "Does not change colour";
        return state;
    }

    public static void main(String[] args){
        /* Here class dog implements Animal interface, so it shows that
        it expects itself to call itself an Animal, so it needs to implement
        all identity behaviours of that category, and that's why a class
        implements and overrides all the behaviours of requested interface
        or category.
        * */
        Dog dog1 = new Dog();
        dog1.walk();
        /* This is special case method as it can override if it needs to be
        but if something is unique to an animal or very common to animals then
        we can use default methods they work as universal method to all implementing
        class and as well as gives the power to change it accordingly so in this way let's
        say we are implementing some behaviour like breathe then including in all
        classes separately increases code duplication so directly including the main logic
        in interface itself.
        * */
        Animal animal = new Dog();
        animal.breathe("Dog");
        System.out.println(animal.changeColour());
    }
}
