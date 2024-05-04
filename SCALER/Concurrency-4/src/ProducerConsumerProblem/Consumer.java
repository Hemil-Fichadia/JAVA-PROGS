package ProducerConsumerProblem;

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
        int count = 0;
        while(count < 100000){
            if(store.size() > 0){
                Shirt purchasedShirt = store.poll();
                System.out.println(name+" bought the shirt with id : "+purchasedShirt.getId() + ", store size : " + store.size());
                count += 1;
            }
        }
    }
}
