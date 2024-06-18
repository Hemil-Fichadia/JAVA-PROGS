package DecoratorDesignPattern.Implementation.Toppings;

import DecoratorDesignPattern.Implementation.IceCream;

public class CaramelCrystalToppings implements IceCream {
    private IceCream iceCream;
    public CaramelCrystalToppings(IceCream iceCream){
        this.iceCream = iceCream;
    }
    @Override
    public int getCost() {
        return iceCream.getCost() + 25;
    }

    @Override
    public String getDescription() {
        return iceCream.getDescription() + "Caramel crystal toppings";
    }
}
