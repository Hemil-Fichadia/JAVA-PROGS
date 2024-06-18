package ObserverDesignPattern.Implementation;

public class EmailService implements OnOrderPlacedSubscriber{
    EmailService(){
        Flipkart flipkart = Flipkart.getInstance();
        flipkart.registerSubscriber(this);
    }
    @Override
    public void announcedOrderPlaced() {
        System.out.println("Sending email");
    }
}
