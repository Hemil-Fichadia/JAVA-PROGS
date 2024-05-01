package AccessModifier2;

import AccessModifier.Vehicle;

public class VehicleChild extends Vehicle {

    public static void main(String[] args){

        VehicleChild vc1 = new VehicleChild();
        /* As we know public is accessible everywhere so brand is public, so it is
        accessible, but type is also accessible here so that means protected attribute
        named "type" is accessible within the package and outside the package it is
        accessible in child class so here VehicleChild class is extending Vehicle class
        and that's why it is a child class not because it is named as child.
        * */
        vc1.brand = "Maruti";
        vc1.type = "4W";
        /*Uncommenting below line will throw this error
        java: power is not public in AccessModifier.Vehicle; cannot be accessed from outside package
        */
        //vc1.power = "300BHP";
        /*Uncommenting the below line will throw this error
        java: price has private access in AccessModifier.Vehicle
        * */
        //vc1.price = 600000;
        System.out.println("Brand of the child class : "+vc1.brand);
        System.out.println("Type of the child class : "+vc1.type);
    }
}
