package DecoratorDesignPattern.Implementation.Cones;

import DecoratorDesignPattern.Implementation.IceCream;

public class ChocolateCone implements IceCream {
    private IceCream iceCream;
    public ChocolateCone(){

    }
    public ChocolateCone(IceCream iceCream){
        this.iceCream = iceCream;
    }

    @Override
    public int getCost() {
        if(iceCream != null){
            return iceCream.getCost() + 20;
        }
        return 20;
    }

    @Override
    public String getDescription() {
        if(iceCream != null){
            return iceCream.getDescription() + "Chocolate cone";
        }
        return "Chocolate cone";
    }
}
