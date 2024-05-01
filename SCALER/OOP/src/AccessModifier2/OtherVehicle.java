package AccessModifier2;

import AccessModifier.Vehicle;

public class OtherVehicle {

    public static void main(String[] args){
        /* Outside the main package, only public attributes and methods
        are accessible.
        so in Vehicle class, brand is public, type is protected, power is default
        and price is private.
        so default and protected are accessible both in same package but
        in different package both are not accessible.
        private is only accessible from within class itself so there is no question about
        accessing it in other file or other package.
        * */
        Vehicle v1 = new Vehicle();
        v1.brand = "TVS";
    }

}
