package StrategyDesignPattern;

public class CarPathCalculator implements PathCalculatorStrategy{
    @Override
    public void findPath(String source, String destination) {
        System.out.println("Reach "+ source +" to "+ destination +" by driving car");
    }
}
