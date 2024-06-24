package ObserverDesignPattern.Implementation;

public class Client {
    public static void main(String[] args){
        /* Here Flipkart class is the main class that is having all the functionalities and which is
        also a singleton class, it has methods related to register and unregister a subscriber, and
        it contains a List of the subscribers of the OnOrderPlaced event, and they are added at the
        time of their object creation and client calls the flipkart.onOrderPlacedSubscribers() method
        that iterates through the list and calls the announcedOrderPlaced() method of all the subscribers
        classes as those services which are subscribed to OnOrderPlaced event.
        */
        Flipkart flipkart = Flipkart.getInstance();
        EmailService emailService = new EmailService();
        InventoryService inventoryService = new InventoryService();
        InvoiceService invoiceService = new InvoiceService();
        flipkart.onOrderPlacedSubscribers();
    }
}
