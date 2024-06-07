package Polymorphism;

public class C extends B{
    String company;

    public static void main(String[] args){
        /* A is extended by B and B is extended by C so this the
        hierarchy. We can make this kind of object call A a = new C();
        now with that understand this, the syntax are checked at compile
        time and in case of checking the which reference will hold which kind
        of object then it is not possible at compile time so compiler only
        checks the left hand side of some declaration and the objects are
        created at runtime so actual objects are created when the project
        runs on a server but when we create object like this A a = new C();
        and try to access some attribute of C like a.company = "google" but
        compiler only allows us to access the members of data type of left
        hand side so in order to access C's we need to type cast it to C
        so like this (C)a.company = "google" but this will only solve the
        compilation problems it can cause some issues while runtime
        * */
        A a1 = new C();
        a1.fun();

        A a = new C();
        ((C)a).company = "google"; //This is not a good practice

        /* Let's say we are creating a List<Object> list = new ArrayList<>();
        and so we can store like this also
        list.add("scaler");
        list.add(1);

        Now it was assumed that it would contain String values but
        the values are of object type.
        Now when we are try to catch the value of list like this
        String s = list.get(1); so this will throw a compilation
        error, but we can get rid of it by type casting it to String
        String s = (String)list.get(1) but it was expected to have
        only string values but something else was found so this is the
        case of runtime error.
        * */

        C c = new C();
        /*This will print "Hey" as it will point to the method of its
        immediate parent and that is B which is having fun() method with
        logic printing "Hey".
        */
        c.fun();
    }
}
