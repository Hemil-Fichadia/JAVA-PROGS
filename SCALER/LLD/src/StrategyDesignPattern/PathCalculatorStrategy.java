package StrategyDesignPattern;

public interface PathCalculatorStrategy {
    /* This is the main Strategy interface which is the only of Strategy design pattern being used
    here as we have different modes of transport and they all are independent of each other so they
    are separated in respective classes and they all implement this PathCalculatorStrategy interface.
    * */
    void findPath(String source, String destination);
}
