package Polymorphism;

public class Instructor extends User{
    Instructor(){
        System.out.println("Instructor constructor");
    }

    public static void main(String[] args){
        /* Polymorphism, poly means many and morph means forms
        means one that have many forms.
        Now we know one thing that User is a parent class and Instructor is
        a child class so this shows IS-A relation like Instructor IS-A User,
        So we can store child's object in parent's reference like this
        User u = new Instructor();
        User u = new Student();

        So in this example a User have many forms like instructor, student
        T.A. so this is also a kind of polymorphism as User have many forms.

        If we are maintaining a zoo and if we don't maintain a hierarchy among
        the animals then each and every animal is individual, and so we have to create
        a separate facility for each of them but let's assume that we are categorizing
        each of them according to some common properties and how aggressive they are
        among their species or some different species so there will be a common class
        animal and then child classes of it like mammals, amphibians, reptiles and
        according to that each and every animal is stored, so we can declare this
        kind of object Animal mammal = new Mammal() or Mammal monkey = new Monkey();
        but this is not possible, Dog dog = new Animal(); like every dog is an animal
        but every animal is not a dog so we cannot store parent's object inside child's
        reference, we can store child's object in parent's reference and this will help in
        scenarios like if we want to store all the animals inside a List then we need to
        make the List<Animal> so that each and every type of animal can be stored, and if
        we were maintaining each of the animal separately then it would require to make
        a separate list for every kind of animal.
        * */
        Instructor i1 = new Instructor();
    }
}
