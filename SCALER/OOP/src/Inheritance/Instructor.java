package Inheritance;

public class Instructor extends User{

    Instructor(){
        System.out.println("Instructor's constructor");
    }
    String batchName;
    double avgRating;

    public static void main(String[] args){
        /* Representation of hierarchy in terms of class
        is called inheritance like animal is the main category but the
        types like mammals, reptiles, amphibians etcetra are teh sub-categories of
        animals, and they all extend animal category so this is also a hierarchy.

        Here user is the parent class and Instructor is child class and this is
        decided by extends keyword whichever class extends some class or say
        here instructor class extends user class so instructor is child and
        user is parent class.

        At runtime the objects are created and as a child extends parent so
        parent's object is created first and then child's object is created
        as child's default constructor calls parent's default constructor.
        and a class can only extend a single class only, java doesn't support
        multiple inheritance, so we cannot do A extends B, C.

        IS-A relation
        Student IS-A User
        Instructor IS-A User
        TA IS-A User
        * */
        Instructor instructor = new Instructor();
        instructor.batchName = "apr23morn";
        instructor.avgRating = 8.6;
        instructor.email = "instructorname@scaler.com";
        instructor.login("Instructor");
        System.out.println(instructor.batchName);
    }
}
