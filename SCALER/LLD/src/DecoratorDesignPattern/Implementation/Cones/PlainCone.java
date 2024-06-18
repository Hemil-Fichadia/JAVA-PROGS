package DecoratorDesignPattern.Implementation.Cones;

import DecoratorDesignPattern.Implementation.IceCream;

public class PlainCone implements IceCream {
    private IceCream iceCream;
    public PlainCone(){

    }
    public PlainCone(IceCream iceCream){
        this.iceCream = iceCream;
    }

    @Override
    public int getCost() {
        if(iceCream != null){
            return iceCream.getCost() + 15;
        }
        return 15;
    }

    @Override
    public String getDescription() {
        if(iceCream != null){
            return iceCream.getDescription() + "Plain cone";
        }
        return "Plain cone";
    }
}
