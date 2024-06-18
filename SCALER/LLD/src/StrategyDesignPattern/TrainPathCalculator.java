package StrategyDesignPattern;

public class TrainPathCalculator implements PathCalculatorStrategy{
    @Override
    public void findPath(String source, String destination) {
        System.out.println("Reach "+ source +" to "+ destination +" by catching "+destination+" train");
    }
}
