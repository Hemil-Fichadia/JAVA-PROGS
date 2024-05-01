package IntroToThreads;

public class HelloWorldPrinter implements Runnable{
    @Override
    public void run() {
        System.out.println("Hello world printed by "+Thread.currentThread().getName());
    }
}
