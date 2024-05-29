package SOLIDPrinciples.Principle3;

public class L {
    /* We are looking forward to solve the issue of birds with some specific behaviours
    can be stored in a single behaviours, for that the bird which supports a method
    should only have that behaviour, if we can achieve this anyhow, then we can store
    behaviour specific birds in a list.

    Here comes the significance of interface, we will be having interface for each specific
    non-general behaviour, like if a bird can fly then it will implement <<flyable>> interface
    btw << >> this is symbol for interface so if a bird can fly and dance both then it will
    implement both the interfaces, as a class can implement multiple interfaces.

    So now if we want to make a list of birds which can fly, we can directly store into a list
    of type flyable.

    L -> Liskov's principle :- Object of any child class should be as it is substitutable in the
    variable of parent class reference without making any extra code changes, extra code changes
    means no special treatment.
    * */
}
