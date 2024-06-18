package DecoratorDesignPattern.Implementation.Toppings;

import DecoratorDesignPattern.Implementation.IceCream;

public class IcingSugarCrystalToppings implements IceCream {
    private IceCream iceCream;
    public IcingSugarCrystalToppings(IceCream iceCream){
        this.iceCream = iceCream;
    }
    @Override
    public int getCost() {
        return iceCream.getCost() + 15;
    }

    @Override
    public String getDescription() {
        return iceCream.getDescription() + "IcingSugarCrystal toppings";
    }
}
