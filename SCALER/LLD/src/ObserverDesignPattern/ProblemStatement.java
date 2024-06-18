package ObserverDesignPattern;

public class ProblemStatement {
    public static void main(String[] args){
        /* At amazon, when an order is placed, it performs some operations like notifying logistics,
        locating to the nearest warehouse to fulfill the order items, enabling order tracking system
        and a lot more. So let's say we want to build such a method that have some responsibilities
        like this
        Amazon{
            onOrderPlaced(){
                generateIvoice();
                notifySeller();
                updateInvetory();
                and lot more
            }
        }
        but if all such methods are there inside main class itself then it creates more cluster in
        an entity where we are just managing the main system related operations and in the future,
        there is a change required to be done regarding this orderPlaced() method, then we have to change
        this main class method itself, so to avoid unwanted changes, it is better to shift it some
        helper class which is generally named as "facade" which means front part of something,
        so here it will be AmazonOrderPlacedFacade which will contain all these methods

        Amazon{
            onOrderPlacedFacade(){
                amazonOrderPlaceFacade.onOrderPlaced();
            }
        }

        AmazonOrderPlacedFacade{
            InventoryService inventoryService;
            LogisticService logisticsService;
            GenerateInvoice generateInvoice;
            NotificationService notificationService;

            orderPlaced(){
                inventoryService.updateInventory;
                logisticService.updateLog();
                notificationService.notify();
                generateInvoice.generateInvoice();
            }

        }

        So with the help of this simple step, we made our main class more simple by moving
        the complex stuffs to helper/facade class.

        As an order is placed, all actions of onOrderPlaced() of facade class are triggered at once,
        now there can be some partners or sellers that are third party, so they don't come under
        the Inventory service part and some sellers are direct warehouse dealers, so they don't come
        under some other methods and this goes on with certain types of dealers, so we want to add
        or remove trigger actions at runtime, we can achieve it using if conditions, another way
        is to add or remove method from the code, and for that we have to make code changes everytime
        and redeploy it, but our requirement is to control method trigger in a different way even if they
        are under same method.
        * */
    }
}
