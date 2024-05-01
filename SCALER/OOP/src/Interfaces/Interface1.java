package Interfaces;

public interface Interface1 {
    /* A concept that is not exactly a real entity (not having attributes and method
    definition), but that concept is categorized by the type of behaviour it supports.

    Let's define one such entity say Animal, an entity which can eat, run and walk is
    considered to be an Animal, is an animal a real entity ? No, it isn't, but its just
    one such categorization which allows to one entity to be separately identified.

    As it is just a category, it cannot provide with the actual definition of
    these methods like eat,walk and run so the actual definition of these
    methods should be provided by the real entities which actually implement
    this category, as those real entities can have different ways to eat
    walk and run.

    Here comes the concept of interface,
    Interface :- It is blueprint of behaviours.
    Declares set of behaviours that must be implemented by the entity in
    order to be considered to belonging to that category.
    * */

    /* If we declare an attribute in an interface, then it automatically
    becomes public static final means it will become entirely constant
    so whichever class implements that interface will get the same value across
     the operations, we actually need this kind of attributes in very rare
     scenario where value should be available and that is completely constant
     not any operation can change its value or change its state.
    * */
    int count = 2;
    void fun1();

    /* STACK is a data structure that have these functionalities
    push()
    pop()
    isEmpty()
    so a data structure have these functionalities can be addressed as
    a STACK but a stack data structure can be implemented using various
    other data structures like array and linked-list so let's say we create
    an interface of STACK that is implemented by both kind of stacks one is
    arrayBasedStack and other is linkedListBasedStack so first we used
    arrayBasedStack like this Stack stack = new ArrayBasedStack() and later
    we needed some extra with performance with linkedListBasedStack so we just
    need to change this way Stack stack = new LinkedListBasedStack() so where
    ever stack variable is we just need to replace the implementation we don't
    need to change every single method that uses stack as we made it easy with
    this interface based approach.
    * */

    /* The greatest learning here is, how well a system will perform depends
    on one of the pillar here and that is about how well an interface is made
    what all parameters have been thought of while creating it.
    "SO PROGRAM TO INTERFACE, NOT TO IMPLEMENTATION"
    So using interface, we can achieve a flexibly coupled program not
    a tight coupled program and that makes our codebase scale able as
    well as maintainable.
    * */
}
