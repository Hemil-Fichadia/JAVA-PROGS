package ObserverDesignPattern;

public class Description {
    /* Observer is design pattern is a behavioural design pattern.

    The problem in front of us is, that we want to trigger some actions if an event is triggered and
    here comes Observer design pattern as a saviour.

    The observer design pattern have a solution for this, is reverse dependencies, like think in reverse
    way now those actions wants to get triggered if that event happens so now those actions are connected
    to that event in such a way that when this event triggers, those affiliated actions wants to get
    executed.

    Here comes a new terminology, those class which are event are called as Publishers and those classes
    which executes themselves are called as Subscribers and these names do gives a hang of Publisher
    Subscriber model of youtube like as soon as a video gets uploaded, all the subscribers of the publishers
    are notified of the upload.

    Here Amazon will act like Publisher and if a service want to subscribe to it then it should have a
    subscribe method or a register method to add a service in its registry. Amazon's subscribers would be
    LogisticService, NotificationService, InventoryService etc.

    We have a method called as registry that can accept any kind of Subscriber like LogisticsService,
    NotificationService, InventoryService, if a method needs to accept all these kind of classes then
    they need to bind under a common interface named as AmazonOrderPlacedSubscribers and all those
    subscribers need to implement this which can have one method onOrderPlaced() and all those subscribers
    will implement on their own way.

    In register() method of Amazon class, we can maintain a List<AmazonOrderPlacedSubscriber> subs,
    and add those who are subscribed and in Unregister() method we can remove that subscriber from
    List<AmazonOrderPlacedSubscriber> subs, by simply doing subs.remove(aops) and finally in OrderPlaced()
    method iterate through list of subscribers and execute onOrderPlaced() methods of all the subscribers.

    Now the only part that is remaining how will we add subscribers to subs list ? the answer is simple,
    by database operation as we can get the information of all the subscribers, and if we want each and
    every class that is part of Amazon to be its subscriber, then we can achieve it by passing it to Amazon
    class's register method.
    * */
}
