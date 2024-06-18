package StrategyDesignPattern;

public class PathCalculatorFactory {
    /* This is the Abstract Factory of PathCalculatorStrategy as the return type is that and it is
    responsible for returning object of the respective modes of transport.
    * */
    public static PathCalculatorStrategy getPathCalculatorForModes(SupportedModesOfTransport modeOfTransport){
        if(modeOfTransport.equals(SupportedModesOfTransport.WALK)){
            return new WalkPathCalculator();
        }
        else if(modeOfTransport.equals(SupportedModesOfTransport.BIKE)){
            return new BikePathCalculator();
        }
        else if(modeOfTransport.equals(SupportedModesOfTransport.CAR)){
            return new CarPathCalculator();
        }
        else if(modeOfTransport.equals(SupportedModesOfTransport.TRAIN)){
            return new TrainPathCalculator();
        }
        return null;
    }
}
