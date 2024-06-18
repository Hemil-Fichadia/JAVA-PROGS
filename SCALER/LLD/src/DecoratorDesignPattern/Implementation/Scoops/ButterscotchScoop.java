package DecoratorDesignPattern.Implementation.Scoops;

import DecoratorDesignPattern.Implementation.IceCream;

public class ButterscotchScoop implements IceCream {
    private IceCream iceCream;
    public ButterscotchScoop(IceCream iceCream){
        this.iceCream = iceCream;
    }
    @Override
    public int getCost() {
        return iceCream.getCost() + 40;
    }

    @Override
    public String getDescription() {
        return iceCream.getDescription() + "Butterscotch scoop";
    }
}
