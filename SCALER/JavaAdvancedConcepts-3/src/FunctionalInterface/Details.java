package FunctionalInterface;

public class Details {
    /* The interfaces that have only one Abstract method are called functional interfaces.
    If there are some other types of methods also apart from Abstract method, still it is
    considered as functional interface.

    There is also an annotation called @FunctionalInterface this annotation is not mandatory
    in the case of we are not going to add any other Abstract Methods but if there is a chance
    that someone might create another Abstract method, and if that happens then it looses the
    title of FunctionalInterface so this annotation of @FunctionalInterface restricts from adding
    more than one abstract method.

    By Abstract method I mean that the method those are just declared and there can exist any number
    of default methods.

    Functional Interface have importance in the world of lambdas, but if we recall that have we
    used some functional interfaces then they are as follows :-
    1) Runnable :- As it only have one method that is Run method
    2) Callable :- As it only have one method that is Call method
    3) Comparable :- As it only have one method that is compareTo method.
    4) Iterable :-
    5) Iterator :-

    There are some inbuilt such FunctionalInterface for respective use-case
    1) Consumer & BiConsumer
        1) Consumer<T> have only one method accept with void return type
        Method :- void accept(T t);
        So if we have some use-case like where we require only one method that
        takes only one parameter and returns nothing but does its task so for this
        kind of scenarios we don't need to create a functional interfaces of our own.

        Similarly, the rest of the built-in functional interfaces have respective property.

        2) BiConsumer<T, U>
        Method :- void accept(T t, U u);

    2) Predicate & BiPredicate
        1) Predicate<T>
        Method :- boolean Test(T t);

        2) BiPredicate<T, U>
        Method :- boolean Test(T t, U u);

    3) Function & BiFunction
        1) Function<T, R>
        Method :- R apply(T t);

        2) BiFunction<T, U, R>
        Method :- R apply(T t, U u);
    * */
}
