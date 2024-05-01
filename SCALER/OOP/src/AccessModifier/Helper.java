package AccessModifier;

public class Helper {
    public static void main(String[] args){
        Vehicle v1 = new Vehicle();
        /* Inside same package, every access modifier except private
        is accessible
        * */
        System.out.println("Brand : "+v1.brand);
        System.out.println("Type of vehicle : "+v1.type);
        System.out.println("Power of vehicle"+v1.power);
        /*uncommenting below line will throw following error
        java: price has private access in AccessModifier.Vehicle
        */
//        System.out.println("Price of vehicle : "+v1.price);
    }

}
