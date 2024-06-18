package StrategyDesignPattern;

public class Client {
    public static void main(String[] args){
        /* This is the client class which is acting like a client here and shows the sequential process
        of what happens when a client launches a google maps application in their smart devices.
        * */
        GoogleMaps googleMaps = new GoogleMaps();
        googleMaps.enableGPS();
        googleMaps.loadUI();
        googleMaps.findPath("Naranpura", "Gota", SupportedModesOfTransport.BIKE);
    }
}
