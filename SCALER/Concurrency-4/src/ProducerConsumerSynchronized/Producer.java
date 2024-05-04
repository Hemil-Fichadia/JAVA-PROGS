package ProducerConsumerSynchronized;

import java.util.Queue;

public class Producer implements Runnable{
    private Queue<Shirt> store;
    private int maxSize;
    private String name;
    Producer(Queue<Shirt> store, int maxSize, String name){
        this.store = store;
        this.maxSize = maxSize;
        this.name = name;
    }

    @Override
    public void run() {
        /* We have infinite producers so this loop will execute endless
        but shirt will only be added if the store have some empty slots means
        if the size of the store is less than maxSize.
        * */
        while(true){
            if(store.size() < maxSize){
                synchronized(store){
                    store.add(new Shirt());
                    System.out.println(name+" produced a shirt, size of store : "+ store.size());
                }
            }
        }
    }
}
