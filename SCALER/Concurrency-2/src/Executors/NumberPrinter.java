package Executors;

public class NumberPrinter implements Runnable{
    private int number;
    NumberPrinter(int x){
        number = x;
    }

    /*Here we are using Runnable interface, and so we are overriding the run method
    but run method is of void return type let's assume if we want to return something
    after execution of each task then we need something that is capable of doing so.
    So here comes a new another interface to make a class thread executable and that is
    Callable interface.
    * */
    @Override
    public void run() {
        System.out.println(number + " - printed by "+Thread.currentThread().getName());
    }
}
