package GenericsAndInheritanceAndBounds;

import java.util.List;

public class GenericInheritance {
    public void animalOrExtendedByAnimal(List<? extends Animal> animalList){

    }

    public void dogOrAnySuperClassOfDog(List<? super Dog> superDogList){

    }
    public static void main(String[] args){
        /* There are also some functionalities created in generics
        related to inheritance, but why it was introduced, let's understand it first.

        We have a parent class Animal that is extended by child class Dog and Cat,
        so we can store object of Dog or Cat in reference of Animal like this Animal animal = new Dog();
        so let's say we are storing Animal objects in a List<Animal> so can we can store objects of Dog
        and Cat as it is inside this List<Animal>, but if we try to store a List<Dog> inside this
        List<Animal>, then can we store it ? ..................................
        A tough one, as per the nature of inheritance, it should be, but it won't as List<Animal> is not
        extended by class List<Dog>, why this is not supported ? assume somewhere we are expecting Dog
        object, and we are passing Animal List so if we try to execute animal.bark() it will not support
        this operation so here even if we are following the inheritance pattern, still this is not
        solvable with conventional approach. Here comes the Generics version of it where it makes a
        method enough capable of receiving any of type Animal or objects that are extended by Animal.

        This is the syntax for making List capable of accepting class Animal or class that extend Animal
        we have to write like this List<? extends Animal>
        * */
    }
}
