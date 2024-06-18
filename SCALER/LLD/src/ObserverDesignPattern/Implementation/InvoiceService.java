package ObserverDesignPattern.Implementation;

public class InvoiceService implements OnOrderPlacedSubscriber{
    InvoiceService(){
        Flipkart flipkart = Flipkart.getInstance();
        flipkart.registerSubscriber(this);
    }
    @Override
    public void announcedOrderPlaced() {
        System.out.println("Invoice generated");
    }
}
