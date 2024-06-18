package ObserverDesignPattern.Implementation;

public class Client {
    public static void main(String[] args){
        Flipkart flipkart = Flipkart.getInstance();
        EmailService emailService = new EmailService();
        InventoryService inventoryService = new InventoryService();
        InvoiceService invoiceService = new InvoiceService();
        flipkart.onOrderPlacedSubscribers();
    }
}
