package DecoratorDesignPattern.Implementation.Cones;

import DecoratorDesignPattern.Implementation.IceCream;

public class StrawberryCone implements IceCream {
    private IceCream iceCream;
    public StrawberryCone(){

    }

    public StrawberryCone(IceCream iceCream){
        this.iceCream = iceCream;
    }

    @Override
    public int getCost() {
        if(iceCream != null){
            return iceCream.getCost() + 30;
        }
        return 30;
    }

    @Override
    public String getDescription() {
        if(iceCream != null){
            return iceCream.getDescription() + "Strawberry cone";
        }
        return "Strawberry cone";
    }
}
