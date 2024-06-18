package DecoratorDesignPattern.Implementation.Toppings;

import DecoratorDesignPattern.Implementation.IceCream;

public class ChocochipToppings implements IceCream {
    private IceCream iceCream;
    public ChocochipToppings(IceCream iceCream){
        this.iceCream = iceCream;
    }
    @Override
    public int getCost() {
        return iceCream.getCost() + 20;
    }

    @Override
    public String getDescription() {
        return iceCream.getDescription() + "Chocochip toppings";
    }
}
