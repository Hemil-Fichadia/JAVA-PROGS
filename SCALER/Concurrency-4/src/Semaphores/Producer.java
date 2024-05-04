package Semaphores;

import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Producer implements Runnable{
    private Queue<Shirt> store;
    private int maxSize;
    private String name;
    private Semaphore producerSemaphore;
    private Semaphore consumerSemaphore;
    Producer(Queue<Shirt> store, int maxSize, String name, Semaphore producerSemaphore, Semaphore consumerSemaphore){
        this.store = store;
        this.maxSize = maxSize;
        this.name = name;
        this.producerSemaphore = producerSemaphore;
        this.consumerSemaphore = consumerSemaphore;
    }

    @Override
    public void run() {
        /* We have infinite producers so this loop will execute endless
        but shirt will only be added if the store have some empty slots means
        if the size of the store is less than maxSize.
        * */
        while(true){
            /* Here we used to have if condition like, if the store size is less than maxSize
            only then call a producer, but here the semaphore is handling that case by having
            the count of threads reduced at each acquire call and the one that is released is
            added by one so the step that we did earlier in client class of reducing one thread
            from producer and adding one to consumer, so reducing is done when we acquire and
            adding of producer thread is done when we release it.
            * */
            try {
                producerSemaphore.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            store.add(new Shirt());
            System.out.println(name+" produced a shirt, size of store : "+ store.size());
            consumerSemaphore.release();
        }
    }
}
