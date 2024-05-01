package Interfaces;

public interface Animal {
    /* These are just method declaration, methods are not
    defined here so methods are without bodies so these kind
    of methods are called abstract methods, so these methods
    don't have access modifiers as they don't have any actual
    body so there is nothing to be restricted about the access
    methods.
    If any entity wants to call itself an animal then it need
    to implement all the methods of Animal means it needs to
    satisfy all the behaviours of an Animal.
    As Animal is not a real entity, we cannot create its object
    like this Animal animal = new Animal() but we can make
    object of any of it implementing class like Dog or Cat
    like this Animal animal = new Dog(); or Animal animal = new Cat();
    * */
    void eat();
    void walk();
    void run();

    /* Let's say the animal interface is implemented by 100s of animals
    like cat, dog, mantis, cow etc, and there comes a new species with
    a unique capability of changing colour, so if intend to include that
    capability or behaviour, first we need to add that to animal interface
    but now all other animals need to override this newly introduced
    behaviour so to address this kind of issues java 8 came up with a
    solution of default method.
    This is special case method as it can override if it needs to be
    but if something is unique to an animal or very common to animals then
    we can use default methods they work as universal method to all implementing
    class and as well as gives the power to change it accordingly so in this way let's
    say we are implementing some behaviour like breathe then including in all
    classes separately increases code duplication so directly including the main logic
    in interface itself.
    * */
    default void breathe(String name){
        System.out.println(name+" is breathing");
    }
    default String changeColour(){
        String[] colours = {"Green", "Red", "Blue", "Orange", "Yellow", "Magenta", "Maroon"};
        int min = 0;
        int max = colours.length - 1;
        int pick = (int)(min + Math.random() * (max - min));
        return colours[pick];
    }
}
