package SOLIDPrinciples.Principle5;

public class D {
    /* D -> Dependency Inversion principle
    Dependency Inversion principle states :- No 2 concrete classes should depend on each other
    directly instead they should depend on each other via an interface.

    Let's assume that in our code, Pigeon and Sparrow have exact same flying behaviour, and so
    we created a class named pigeonSparrowFlyingBehaviour, that will hold the method of flying
    behaviour, so we will call that flying method when we need, but in this way we have made class
    Pigeon and Sparrow to directly depend on class pigeonSparrowFlyingBehaviour instead we can
    create an interface named flyingBehaviour which have method fly() and which is implemented
    by pigeonSparrowFlyingBehaviour so now whenever we require fly() method, we can store object
    of pigeonSparrowFlyingBehaviour inside its parent reference flyingBehaviour and now where ever
    we need this kind of flyingBehaviour we can make a new class of such birdFlyingBehaviour and
    make it implement flyingBehaviour interface which will make sure that none of the class are
    tightly coupled.
    * */
}
