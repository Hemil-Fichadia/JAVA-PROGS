package StrategyDesignPattern;

public class WalkPathCalculator implements PathCalculatorStrategy{
    @Override
    public void findPath(String source, String destination) {
        System.out.println("Reach "+ source +" to "+ destination +" by walk");
    }
}
