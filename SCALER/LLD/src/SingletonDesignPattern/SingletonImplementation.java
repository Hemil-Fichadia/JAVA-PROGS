package SingletonDesignPattern;

public class SingletonImplementation {
    public static void main(String[] args){
        /* How can we make a class singleton, for that a class should only have one object
        per application context, so only one object is present of that class throughout the project.

        Now we are looking forward to make a class singleton or follow singleton design pattern and
        to achieve that, we need to identify which entity is responsible for object creation for
        a class, so, the entity which is responsible for object creation for a class is "constructor",
        till a constructor is accessible, any number of objects can be created out of it.

        In order to restrict object creation, we need to apply some restriction to constructor of that
        class and that we can do by making "constructor" of that class "private", now it is not
        possible to create even a single object, but we know that private attributes and behaviours
        from within the class, so we need to make a public getInstance() method which is responsible
        for returning an instance of that class, but wait without any object, how can we call any
        method of a class, this shows that this method needs to be object independent in order
        to deliver an object of that class, so that getInstance also needs to be "static" as well.

        If we really understand the scenario, then one thing is clear that method is returning an
        instance of that class, but each time it is called, a new object is created even if its
        object exists, so we need to add a filter that checks if the instance exists, then
        directly return it else create and return the instance.


        * */
        /* This object creation will throw error as we are accessing a private constructor from
        outside the class.
        * */
        //SingletonClass singletonClass = new SingletonClass(); <-- Here it will throw error.

        SingletonClass singletonClass = SingletonClass.getInstance();
        singletonClass.printInfo();
        System.out.println(singletonClass.hashCode());
        System.out.println(singletonClass.getInstance().hashCode());

        if(singletonClass.hashCode() == singletonClass.getInstance().hashCode()){
            System.out.println("It is a singleton class");
        }
        /* Pros of Singleton :-
        Using resource efficiently

        Cons :-
        Difficult to test a singleton class.
        * */
    }
}
