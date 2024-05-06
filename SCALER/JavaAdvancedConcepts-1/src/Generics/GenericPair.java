package Generics;

public class GenericPair <A, B>{
    /* This "A" and "B" are placeholders and the Generic data type of
    this class so variable first is of type A and variable second is of
    type B. So this A and B can be a type of anything.
    * */
    A first;
    B second;

    /* Here in function setFirst, the input parameter data type is also "A"
    as we are targeting variable first of this class. Similarly return type is
    also based on those placeholders in method getFirst the return type is "A".
    * */
    void setFirst(A first){
        this.first = first;
    }
    void setSecond(B second){
        this.second = second;
    }
    public A getFirst() {
        return first;
    }
    public B getSecond() {
        return second;
    }
    //Generic method
    /* Here we are making a method to accept argument of generic type but
    as it is static it can be called without creating an object as that method
    belongs to the class and that means it will not receive a generic or say a data
    type so without data type a generic is useless, so we need to make it receive a
    generic without creation of object by making it like static <T> doSomething(T data)
    so here this will allow it to decide the data type at run time.
    * */
    public static <T> void doSomething(T data){
        System.out.println(data);
    }
    //We can also have multiple generic data types in static method
    public static <U, K> void genericMethodWithTwoParameters(U data1, K data2){
        System.out.println(data1 + " " + data2);
    }
    /* As this is non-static method it will receive a generic with object creation,
    so we have to give the generic that is defined in the class.
    * */
    public A doAnything(A data){
        System.out.println(data);
        return null;
    }
}
