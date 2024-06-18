package ObserverDesignPattern.Implementation;

import java.util.ArrayList;
import java.util.List;

public class Flipkart {
    private static Flipkart instance;
    private List<OnOrderPlacedSubscriber> onOrderPlacedSubscribersList;
    private Flipkart(){
        onOrderPlacedSubscribersList = new ArrayList<>();
    }
    public static Flipkart getInstance(){
        if(instance == null){
            instance = new Flipkart();
        }
        return instance;
    }
    public void registerSubscriber(OnOrderPlacedSubscriber subscriber){
        onOrderPlacedSubscribersList.add(subscriber);
    }
    public void unRegisterSubscriber(OnOrderPlacedSubscriber subscriber){
        onOrderPlacedSubscribersList.remove(subscriber);
    }
    public void onOrderPlacedSubscribers(){
        for(OnOrderPlacedSubscriber subscriber : onOrderPlacedSubscribersList){
            subscriber.announcedOrderPlaced();
        }
    }
}
