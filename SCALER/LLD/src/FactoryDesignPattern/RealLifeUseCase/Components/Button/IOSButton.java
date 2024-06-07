package FactoryDesignPattern.RealLifeUseCase.Components.Button;

public class IOSButton implements Button{
    @Override
    public void showButton() {
        System.out.println("Showing IOS button");
    }

    @Override
    public void clickButton() {
        System.out.println("Clicking IOS button");
    }
}
