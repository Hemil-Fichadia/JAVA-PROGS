package Generics;

import java.util.ArrayList;
import java.util.List;

public class GenericsDetails {
    public static void main(String[] args){
        /* Till this point, we have been using Generics heavily but were not aware of it,
        but this is the time when we will get aware of such an entity which was visually in
        front of us but needed that conceptual point of view, will now be clarified.
         We used to create a custom data types in case of storing some coordinates or some
         values in group and storing them as a collective single object, but the attributes
         were hard coded inside it, so it was only applicable for a defined case, so if we want
         to make use of it in most of the cases where data type can be anything, so common sense
         tells that the data type should be made general and that's what Generics is all about.

         There also comes one thing in mind about making data type as Object, Object is the
         parent class of every class in java, so by making all the attributes of a class object
         type, so we can store any kind of data there but this compromises with the data
         that can be stored inside it, let's say the values of attributes are supposed to be
         double, and we have made our program around it, but someone intentionally stored String
         to it, so there is no compilation error as it is an Object type, so it will accept
         all kind of input data, and we are type casting it to double and catching to a double
         value but at run time when the TypeMisMatchException, and it will crash program.

         Generics were introduced in JAVA-5 but before that, at every place where data type were
         variable, Object was used and everything was handled on the basis of pure understanding
         but then later on Generics saved all from doing this hefty work of making extremely general
         data type to somewhat controlled general data type.

         So Generics do solve the problem by assigning given data type to all the places
         where it was supposed to place it and this gives flexibility with compile time safety.
         We have defined list like this List<Integer>, List<Double>, List<String>, ...... etc
         so have java developers generated all types of list classes ? NO AT ALL, those angular
         brackets "< >" are Generics, so we can write generics like this List<T> or List<U> this
         "T" or "U" inside angular brackets, these are just placeholders, they can be represented
         by anything.

        * */
        Pair pair = new Pair();
        //Object type variables
        //There won't be any compile time error
        pair.first = 1.2373;
        pair.second = "1.12333";

        //Catching values accordingly
        //double x = (double)pair.first; //Solved compile time error by type casting it
        //double y = (double)pair.second; //Solved compile time error by type casting it
        // This will throw runtime error of string cannot be cast to double
        //System.out.println("DEBUG");

        //Using GenericPair
        GenericPair<String, String> genericPair = new GenericPair<>();
        genericPair.first = "Scaler";
        genericPair.second = "Academy";
        System.out.println(genericPair.first + " " + genericPair.second);

        //We cannot use primitive data type in place of generics
        GenericPair<Double, Double> genericPair1 = new GenericPair<>();
        genericPair1.first = 1.6768;
        genericPair1.second = 1.8888;
        System.out.println(genericPair1.first + " " + genericPair1.second);

        //RAW DATA TYPE
        /* The thing that I described above about Object data type was used in place
        of variable data type, so similarly if we are using hashmap for variable
        data purpose, the data type was not given in hashmap while declaring it, it
        was just declared like this HashMap hm = new HashMap(); so here the considered
        data type is Object, so we can store like this
        hm.put("India", 144);
        hm.put(1.09, 2);
        it shows that there is no restriction in storing the data so whichever logic
        is applied at the end, there is no guarantee of it to working at the end as there
        is no compile time safety.

        BACKWARD COMPATIBILITY
        When java added support for Generics, the companies which have code base in
        the format of Object data type were also working and when those code bases also
        got new methods with generics even they were compatible, so what happens after
        compilation that the code with generics and code without generics are on the same
        page after compilation.
        This is the feature of backward compatibility in java but how is this possible,
        let's observe it in terms of working.

        TYPE ERASURE
        To support backward compatibility, java keeps the scope of data types till compile
        time only and later on it converts it to object type means it just makes it general,
        so it's easy to handle and process as well and this process of erasing the type of
        data type is called type erasure.
        * */
        //Demonstration of Type erasure
        List<Integer> numbers = new ArrayList<>();
        List<String> names = new ArrayList<>();
        List<Double> doubles = new ArrayList<>();
        /* When you debug at this point you will find out after debug pointer
        that there are just ArrayList not the ArrayList of type double or Integer
        or String just ArrayList of object.
        * */
        System.out.println("DEBUG");
    }
}
