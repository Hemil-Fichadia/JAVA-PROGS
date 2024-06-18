package DecoratorDesignPattern.Implementation.Cones;

import DecoratorDesignPattern.Implementation.IceCream;

public class OrangeCone implements IceCream {
    private IceCream iceCream;
    public OrangeCone(){

    }
    public OrangeCone(IceCream iceCream){
        this.iceCream = iceCream;
    }

    @Override
    public int getCost() {
        if(iceCream != null){
            return iceCream.getCost() + 25;
        }
        return 25;
    }

    @Override
    public String getDescription() {
        if(iceCream != null){
            return iceCream.getDescription() + "Orange cone";
        }
        return "Orange cone";
    }
}
