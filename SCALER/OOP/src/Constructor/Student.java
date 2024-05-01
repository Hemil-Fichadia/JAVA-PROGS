package Constructor;

public class Student {
    String name;
    int age;
    String batch;
    double psp;

    /*default constructor just to show the code that runs
    behind the scene no need to implement it.
    */
    Student(){
        //write logic here
    }

    /* If we create a custom constructor then java will not provide
    us default constructor.
    How it works :-
    It initializes the object first with their default values, and
    then it starts executing the logic written inside it.
    * */
    Student(String name, int age, String batch, double psp){
        /* "this" keyword is used to refer to current object so if
        the parameters names are similar, so we can differentiate while
        initializing values.
        * */
        System.out.println("DEBUG");//debug here and observe the part
        this.name = name;
        this.age = age;
        this.batch = batch;
        this.psp = psp;
    }
    /*different types of constructor can be made according to use cases
    and this is also concept of over loading.
    */
    Student(String name, int age){
        this.name = name;
        this.age = age;
    }
    public static void main(String[] args){
        /* A class is a blueprint of an entity and an object is a real instance of that class
        which actually holds the states of attributes and processes the behaviour.
        Say we have a class Student, and we create an object of it like this
        Student st = new Student(); so "st" is just a variable storing reference of the
        real object the new keyword allocates the memory and the objects are stored in
        heap memory and Student() is an actual constructor.

        Default Constructor :-
        The name of a constructor is exactly same as the name of the class and default access
        modifier of a constructor is not default its actually public.
        If we don't create our own constructor in a class, then a default constructor
        is provided by the language. It creates new object of the class and sets
        default value of that data type.
        * */
        Student st = new Student();
//        Student st = new Student("Hemil", 24, "morning", 100.0);
        //initialize break point here and debug to observe default value getting initialized.
        System.out.println("DEBUG");
        System.out.println(st);

    }
}
