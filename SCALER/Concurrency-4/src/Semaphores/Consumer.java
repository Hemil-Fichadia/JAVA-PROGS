package Semaphores;

import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Consumer implements Runnable{
    private Queue<Shirt> store;
    private int maxSize;
    private String name;
    private Semaphore producerSemaphore;
    private Semaphore consumerSemaphore;
    Consumer(Queue<Shirt> store, int maxSize, String name, Semaphore producerSemaphore, Semaphore consumerSemaphore){
        this.store = store;
        this.maxSize = maxSize;
        this.name = name;
        this.producerSemaphore = producerSemaphore;
        this.consumerSemaphore = consumerSemaphore;
    }

    @Override
    public void run() {
        /* We have infinite number of consumers, so we have endless loop
        where a consumer can only buy if the store have some shirts.
        * */
        while(true){
            try {
                consumerSemaphore.acquire(); //
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            store.poll();
            System.out.println(name+" bought the shirt, store size : " + store.size());
            producerSemaphore.release();
        }
    }
}
