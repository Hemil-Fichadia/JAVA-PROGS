package AccessModifier;

public class SubVehicle extends Vehicle{

    public static void main(String[] args){

        /* Similarly in child class all the methods and attributes except for
        private are accessible.
        * */
        SubVehicle sv1 = new SubVehicle();
        sv1.brand = "Hero";
        sv1.type = "2W";
        sv1.power = "500BHP";
        //price is private, so it will throw error
        //sv1.price = 300000;
        System.out.println("Child class SubVehicle brand : "+sv1.brand);
        System.out.println("Child class SubVehicle type : "+sv1.type);
        System.out.println("Child class SubVehicle power : "+sv1.power);

    }
}
