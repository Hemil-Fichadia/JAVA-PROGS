package DecoratorDesignPattern.Implementation.Scoops;

import DecoratorDesignPattern.Implementation.IceCream;

public class BlueberryScoop implements IceCream {
    private IceCream iceCream;
    public BlueberryScoop(IceCream iceCream){
        this.iceCream = iceCream;
    }

    @Override
    public int getCost() {
        return iceCream.getCost() + 55;
    }

    @Override
    public String getDescription() {
        return iceCream.getDescription() + "Blueberry scoop";
    }
}
