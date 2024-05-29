package SOLIDPrinciples;

public class DesignPrinciple {
    /* Design principles :-
    Principle means set of rules, and when these principles are aligned with
    some intentions to make the design of our software system more refined in certain
    areas, then it is termed as design principle, and some of those parameters are:-
    1) Extensible :-
    2) Maintainable
    3) Readable
    4) Reusable
    5) Modular

    The principle that makes our code to be able to serve these traits is
    S.O.L.I.D principle.
    S -> Single responsibility principle
    O -> Open closed principle
    L -> Liskov's substitution principle
    I -> Interface Segregation principle
    D -> Dependency Inversion principle

    Problem statement to understand significance of SOLID design principles :-
    *) Assume that we are building a software system that is capable of storing any kind of bird
    and is also capable of adding new birds with some different behaviours.
    The challenge that is attached with this problem statement is that some birds have some
    behaviours some birds eat or dance differently or some even don't, so when we will dive deep
    for creating a class that can support all kind of behavioural patterns that is found across the
    breed of birds.

    When we are staring to build this requirement from scratch, we don't really care for the best
    design directly, we start with small steps like first of all what all attributes and behaviours are
    going to be there for our entity which is a bird here, and they are as follows :-

    class Bird{
        String name
        int age
        String color
        int weight
        int wingsDiameter
        custom type

        fly()
        eat()
        walk()
        voice()
    }

    Now if we create an object of this bird class then we have to pass every parameter's value
    like this
    Bird b1 = new Bird();
    b1.name = .......
    b1.age = .......
    b1.color = ........
    b1.wingsDiameter = ............
    b1.type = .............
    type means pigeon, sparrow, owl, peacock etc
    Bird b2 = new Bird();
    b2.name = .......
    b2.age = ............
    b2.color = .......
    b2.wingsDiameter = ..........
    b2.type = ...........
    now if we want to compare two birds then we can compare them by type

    We will gradually improve the design by implementing all the principles and will observe how
    it is supposed to be handled in certain situations.

    Continued in Principle1
    * */
}
