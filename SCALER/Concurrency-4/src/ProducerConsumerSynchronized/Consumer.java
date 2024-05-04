package ProducerConsumerSynchronized;

import java.util.Queue;

public class Consumer implements Runnable{
    private Queue<Shirt> store;
    private int maxSize;
    private String name;
    Consumer(Queue<Shirt> store, int maxSize, String name){
        this.store = store;
        this.maxSize = maxSize;
        this.name = name;
    }

    @Override
    public void run() {
        /* We have infinite number of consumers, so we have endless loop
        where a consumer can only buy if the store have some shirts.
        * */
        while(true){
            if(store.size() > 0){
                synchronized(store){
                    store.poll();
                    System.out.println(name+" bought the shirt, store size : " + store.size());
                }
            }
        }
    }
}
