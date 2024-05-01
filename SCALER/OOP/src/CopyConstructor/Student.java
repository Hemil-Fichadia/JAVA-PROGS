package CopyConstructor;

import java.util.Arrays;

public class Student {

    String name;
    int age;
    String batch;
    double psp;

    //default constructor
    Student(){

    }
    //Copy constructor
    /* This is a shallow copy of original object not a deep copy
    Now a deep copy is like each and every value are same but the
    object reference or say memory allocation is different here
    String is an object type data or non-primitive data so when
    we assigned value of st1 to st3 the name variable of object
    st3 and name object of st1 are pointing to same name's object,
    so actually we could have made new string object and then
    assigned the value to it, so it was possible here in this
    case.
    * */
    Student(String name, int age, String batch, double psp){
        this.name = name;
        this.age = age;
        this.batch = batch;
        this.psp = psp;
    }

    /* This is a deep copy of the object st3 as we
    are copying all the attributes and even creating
    non-primitive new objects and then allocating
    new memory and assigning same values.
    * */
    Student(Student student){
        //make a new String object and assign value of st1 to make deep copy
        this.name = new String(student.name);
//        this.name = student.name;
        this.age = student.age;

        //make a new String object and assign value of st1 to make deep copy
        this.batch = new String(student.batch);
//        this.batch = student.batch;
        this.psp = student.psp;
    }

    static void printName(String funName){
        funName = funName.toUpperCase();
        System.out.println("function name : "+funName);
    }

    static void printArray(int[] arr){
        arr[4] = 10;
        System.out.println(Arrays.toString(arr));
    }

    static void printInt(int num){
        num = 5;
        System.out.println("Num inside function : "+num);
    }
    public static void main(String[] args){
        Student st1 = new Student();
        /* Here we are trying to create copy of the st1 object
        where values of all the attributes is exactly same as st1
        object's values.
        So the below is not the exact copy of the st1 the st2 is just
        pointing to the similar reference as st1 so both are pointing
        to same object, but we need to make a copy object, so we have
        to copy all the attribute to attribute, okay, so we can make
        it.
        * */
        Student st2 = st1;

        Student st3 = new Student("Hemil", 24, "Morning", 100.0);
        System.out.println("st3 name "+st3.name);
        System.out.println(st3.age);
        System.out.println("st3 batch "+st3.batch);
        System.out.println(st3.psp);

        Student st4 = new Student(st3);
        System.out.println("st4 name "+st4.name);
        System.out.println(st4.age);
        System.out.println("st4 batch "+st4.batch);
        System.out.println(st4.psp);
        System.out.print("st3's name and st4's name are equal but are references same : ");
        System.out.println(st3.name == st4.name);

        /* But consider a case where the Student class have list of sessions that is a
        separate class and in that each session class there is an Instructor class so
        there is sequential dependency of non-primitive data, so technically it is
        almost impossible to create a complete deep copy in this case.
        class Student{
            String name;
            int age;
            String batch;
            List<Session> sessions;
            double psp;
        }
        class Session{
            Duration duration;
            String topic;
            Instructor instructor;
        }
        class Instructor{
            String name;
            String company;
        }
        So here in this case there are too many inter dependent
        objects and so replacing all is nearly impossible.
        * */

        /* Pass by value and Pass by Reference
        Java is pass by value so when we pass the object or a primitive
        the value itself is passed and in case of an object, the value stored
        in that variable is address of that object that is in heap memory so actually
        value is passed, the point is case of object the value itself is that memory
        address and then if any change is made to the internal variable of the function
        means a new object is created inside function then the original object is not
        affected but similarly if the same object is manipulated then it can cause a
        problem.

        In Java when we pass a variable in a function then
        its actual value is passed not the reference because
        if that is pass by reference then if the value is changed
        inside the function then the actual value present outside
        the function will also be changed so java is pass by
        value.

        So for actual pass by value consider an example of passing an
        Integer value so even if we change its value inside function still
        the original value is not affected.
        * */

        String name = new String("Hemil");
        printName(name);
        System.out.println(name);

        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(arr));
        printArray(arr);

        int num = 3;
        printInt(num);
        System.out.println(num);
    }
}
