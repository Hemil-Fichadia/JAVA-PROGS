package StrategyDesignPattern;

public class BikePathCalculator implements PathCalculatorStrategy{
    @Override
    public void findPath(String source, String destination) {
        System.out.println("Reach "+ source +" to "+ destination +" by riding bike");
    }
}
