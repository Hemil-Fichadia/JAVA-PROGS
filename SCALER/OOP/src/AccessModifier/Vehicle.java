package AccessModifier;

public class Vehicle {

    /* Encapsulation :-
        1) Holds attributes and behaviour together
        2) Protects members from non-legitimate access
        Here attributes means variables and behaviour means methods
        and member as collective
        ************************************************************************
        Access Modifiers
        1) public :- Anyone can access a public member

        2) private :- Only accessible from within the class

        3) protected :- Accessible within the same package as well as child class
        in different package.

        4) default :- Accessible within the same package
        * */
    public String brand;
    protected String type;
    String power; // default access modifier
    private int price;

    public void driveVehicle(){
        /* Within the same class every kind of access modifier attribute or method
        is accessible
        * */
        brand = "TATA";
        type = "4W";
        power = "1000BHP";
        price = 500000;
    }
}
