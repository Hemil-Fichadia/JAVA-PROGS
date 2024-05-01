package Interfaces;

public class Cat implements Animal{
    @Override
    public void eat() {
        System.out.println("Cat is eating");
    }

    @Override
    public void walk() {
        System.out.println("Cat is walking");
    }

    @Override
    public void run() {
        System.out.println("Cat is running");
    }

    @Override
    public String changeColour(){
        String state = "Does not change colour";
        return state;
    }

    public static void main(String[] args){
        //This is normal object creation and we can do it
        Cat cat1 = new Cat();
        cat1.walk();

        /*This is object creation done using interface, and we can store
        child's object in parent's reference, so it will call the methods of
        the class whose object is created.
        */
        Animal animal = new Cat();
        animal.run();

        /* This is special case method as it can override if it needs to be
        but if something is unique to an animal or very common to animals then
        we can use default methods they work as universal method to all implementing
        class and as well as gives the power to change it accordingly so in this way let's
        say we are implementing some behaviour like breathe then including in all
        classes separately increases code duplication so directly including the main logic
        in interface itself.
        * */
        animal.breathe("Cat");
        System.out.println(animal.changeColour());
    }
}
