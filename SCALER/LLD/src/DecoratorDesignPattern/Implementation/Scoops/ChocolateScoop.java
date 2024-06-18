package DecoratorDesignPattern.Implementation.Scoops;

import DecoratorDesignPattern.Implementation.IceCream;

public class ChocolateScoop implements IceCream {
    private IceCream iceCream;

    public ChocolateScoop(IceCream iceCream){
        this.iceCream = iceCream;
    }
    @Override
    public int getCost() {
        return iceCream.getCost() + 45;
    }

    @Override
    public String getDescription() {
        return iceCream.getDescription() + "Chocolate scoop";
    }
}
