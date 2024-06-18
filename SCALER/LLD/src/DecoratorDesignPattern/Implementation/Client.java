package DecoratorDesignPattern.Implementation;

import DecoratorDesignPattern.Implementation.Cones.ChocolateCone;
import DecoratorDesignPattern.Implementation.Cones.OrangeCone;
import DecoratorDesignPattern.Implementation.Scoops.ButterscotchScoop;
import DecoratorDesignPattern.Implementation.Scoops.ChocolateScoop;
import DecoratorDesignPattern.Implementation.Scoops.StrawberryScoop;
import DecoratorDesignPattern.Implementation.Toppings.CaramelCrystalToppings;

public class Client {
    public static void main(String[] args){
        IceCream iceCream = new CaramelCrystalToppings(
                new ButterscotchScoop(
                        new StrawberryScoop(
                                new ChocolateScoop(
                                        new OrangeCone(
                                                new ChocolateCone()
                                        )
                                )
                        )
                )
        );
        System.out.println("IceCream contents : "+iceCream.getDescription());
        System.out.println("Cost : "+iceCream.getCost());
    }
}
