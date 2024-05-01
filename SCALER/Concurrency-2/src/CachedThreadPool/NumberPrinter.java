package CachedThreadPool;

public class NumberPrinter implements Runnable{
    private int number;
    NumberPrinter(int x){
        number = x;
    }
    @Override
    public void run() {
        System.out.println(number + " - printed by "+Thread.currentThread().getName());
    }
}
