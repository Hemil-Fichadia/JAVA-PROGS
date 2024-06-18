package StrategyDesignPattern;

public class GoogleMaps {
    /* This is GoogleMaps class whose responsibility is to call the findPath method of the respective
    mode of transport object received from PathCalculatorFactory class.
    The name itself suggests that we have used FactoryDesignPattern here for PathCalculator as we
    expect object of the class according to the mode of transport.
    * */
    public void loadUI(){
        System.out.println("Maps UI Loaded");
    }
    public void enableGPS(){
        System.out.println("GPS enabled");
    }
    public void findPath(String source, String destination, SupportedModesOfTransport modeOfTransport){
        PathCalculatorStrategy pathCalculator = PathCalculatorFactory.getPathCalculatorForModes(modeOfTransport);
        pathCalculator.findPath(source, destination);
    }
}
