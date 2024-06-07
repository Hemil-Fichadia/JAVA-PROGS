package PrototypeDesignPattern.StudentPrototype;

public interface Prototype<T> {
    /* Here we have used Generics which shows that this interface will be used at multiple
    places in project and which have data type flexibility and this interface will be implemented
    by Student class.
    * */
    T clone();
}
