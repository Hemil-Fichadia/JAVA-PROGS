package ObserverDesignPattern.Implementation;

public class InventoryService implements OnOrderPlacedSubscriber {
    InventoryService(){
        Flipkart flipkart = Flipkart.getInstance();
        flipkart.registerSubscriber(this);
    }
    @Override
    public void announcedOrderPlaced() {
        System.out.println("Notifying Inventory");
    }
}
