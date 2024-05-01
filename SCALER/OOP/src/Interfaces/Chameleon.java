package Interfaces;

public class Chameleon implements Animal{

    @Override
    public void eat() {
        System.out.println("Chameleon is eating");
    }

    @Override
    public void walk() {
        System.out.println("Chameleon is walking");
    }

    @Override
    public void run() {
        System.out.println("Chameleon is running");
    }

    public static void main(String[] args){

        Animal animal = new Chameleon();
        animal.eat();
        animal.walk();
        /* This is special case method as it can override if it needs to be
        but if something is unique to an animal or very common to animals then
        we can use default methods they work as universal method to all implementing
        class and as well as gives the power to change it accordingly so in this way let's
        say we are implementing some behaviour like breathe then including in all
        classes separately increases code duplication so directly including the main logic
        in interface itself.
        * */
        animal.breathe("Chameleon");
        System.out.println("Chameleon's colour is : "+animal.changeColour());
    }
}
