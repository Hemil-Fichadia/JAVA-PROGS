package SOLIDPrinciples.Principle2;

public class O {
    /* O -> Open closed principle
    A code base should be open for Extension and closed for modification.
    That means if we are adding some feature to our software and that requires a lot
    of changes, then after finalizing those changes, we would even require to test the
    existing functionalities in order to make sure that everything is working fine.

    This principle is not 100% possible for all the cases because it's pretty much obvious
    that initially we would require some sort of room to make some changes in, and as
    are integrating new functionalities, that means we are binding it, and that is only
    possible if some sort of change is made.
    So instead of modifying the existing codebase, we should look forward to creating and
    adding new code units, but this not 100% practical, so new feature addition should require
    very less or no code changes in the existing code base.

    Take on the way we implemented the Bird class and the fly() method and rest of the methods
    like eat(), walk(), dance() etc.., now we are adding a new kind of bird with some different
    kind of behaviour, then there will be changes in all the mentioned methods, so this is
    violating single responsibility principle as adding a new bird is affecting all the existing
    functionalities, and it also violates open closed principle.

    The bird class is violating Single responsibility principle as well as Open closed principle,
    so the bird class is supposed to handle only those attributes and behaviours which are general
    or common throughout different breed of birds and the breed specific methods and attributes
    are supposed to be included in breed specific like how a pigeon will fly or ear or dance or
    what not is supposed to be included in pigeon class, so here we have to realise that it is
    responsible for every type of bird.

    So Bird class is only responsible for generic attributes and behaviours and any specific attribute
    or behaviour should belong to respective entity class.

    Now birds may fly differently, eat, walk, dance differently so in bird class we can just declare
    that method and other classes can implement its own way so for this we need to make these methods
    abstract and so the class should also be abstract, so when a class extends the bird class, it
    gets all the attributes and methods, and this has its own impact in terms of writing if-else
    condition or if we want to add a new species of bird just we need is to extend the bird class
    and implement all the methods accordingly.

    Everything seems working fine, until a new kind of species of bird arrives, that is penguin,
    so penguin will also extend the Bird class and with that fly() method will also be there, and
    it needs to implement that method but penguin cannot fly so that method should throw an exception.

    Client can store any object in Bird reference like Bird b1 = new Pigeon(); and with that,
    client can also do b1 = new Penguin(); and when client does b1.fly() then it will surprise
    them, and we should avoid surprises for client.

    An if an entity does not support a behaviour, then it should not have that method at first place
    instead keeping it empty or throwing some exception, so Penguin should not directly extend the Bird
    class, there should be some interface in-between so the idea suggests that there should be two
    interfaces <<flyingBirds>> and <<nonflyingBirds>> now all the birds that can fly will implement
    flyingBirds interface and those which not, will implement nonflyingBirds interface.

    Birds that can fly are sparrow, Pigeon, Owl, Eagle etc. will implement flyingBird interface which have
    fly() method and birds like Penguin, ostrich, Emu etc. will implement nonflyingBirds interface so if
    someone calls fly method for penguin, it won't even exist for it, and nonflyingBirds interface is
    only meant to serve the purpose if they all are grouped under one behaviour, else it has no purpose.

    Let's say we have some new behaviour that is dance so another behaviour will be non-dancing
    so say we are making another kind of interface for flyingAndDancing, flyingAndNonDancing,
    nonflyingAndDancing and nonflyingAndNonDancing, so even if we are trying to categorize birds
    according to behaviours then its actually explosion of interfaces with 2^n combinations, so
    our idea of categorization is not working efficiently and this situation is called as class
    explosion.

    We did this categorization in order to store the birds in a category, but now if we look
    forward to store all the birds which can fly, then there is an issue like the birds which
    can dance or cannot dance will be together and so this will affect it overall even if we
    try to take on that still the birds flying are together, but the point is now our categories
    have been bind with new

    This leads to next principle of Liskov's substitution principle.
    */
}
