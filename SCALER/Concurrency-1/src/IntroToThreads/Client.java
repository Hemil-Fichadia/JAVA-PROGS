package IntroToThreads;

public class Client {
    public static void main(String[] args){
        System.out.println("Hello world, printed by "+Thread.currentThread().getName());

        HelloWorldPrinter helloworldprinter = new HelloWorldPrinter();
        Thread thread = new Thread(helloworldprinter);
        thread.start();
        /* As there are multiple threads are running in parallel, there is no order
        of task execution main thread can be executing first and then other thread
        can execute in any order.
        * */
        System.out.println("Hello world printed by "+Thread.currentThread().getName());
    }
}
