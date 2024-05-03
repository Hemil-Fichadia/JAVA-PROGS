package SynchronizedBlock;


public class Adder implements Runnable{
    private Count count;

    public Adder(Count count){
        this.count = count;
    }
    @Override
    public void run() {
        for(int i = 1; i <= 100000; i++){
            /*Here only count class is synchronized, so it is like any object of Count
            inside the synchronized block is only synchronized and locked while execution
            rest of the objects if there, are free to utilise if any thread is performing
            operation on it.
            So the synchronized keyword or block is useful when we have identified a single
            share resource that we want to make perform consistently and accurately, we define
            it in terms of synchronized block, so it will make sure that only one thread at a time
            is present inside that block.
            * */
            synchronized(Count.class){
                count.value += i;
            }
        }
    }
}
