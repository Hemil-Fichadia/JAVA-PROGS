package Semaphores;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Semaphore;

public class Client {
    public static void main(String[] args){
        /* How semaphores will help in our consumer producer problem to manage
        our threads efficiently ?
        Semaphore is a class in java which allows multiple threads to be present
        in a critical section at a time. So it is just an integer variable that represents
        number of threads allowed in a critical section.

        Semaphore producerSemaphore = new Semaphore(6);
        Semaphore consumerSemaphore = new Semaphore(0);
        if(producerSemaphore > 0){
            store.produce();
            producerSemaphore -= 1;
            consumerSemaphore += 1;
        }//This is what it would be like

        So what will we do is, create two producer and consumer semaphore and assign them with
        maxSize and 0 respectively as initially store will be empty so all the producers will
        be there in the store now as one producer entered the store and produced the shirt, it
        will notify a consumer that a shirt is produced so the overall count of producer will
        reduce by one and consumer will increment by 1, so consumer semaphore will be having
        value as 1 now, so this is what semaphores handle by themselves by simple methods like
        producerSemaphore.acquire() will check if the value is greater than 0 then it will enter
        the critical section and consumerSemaphore.release() method notify the consumer that a shirt
        is produced.
        We have to manage one variable that indicates the size of producer or consumer semaphore
        on the basis of current state of store.
        * */

        Queue<Shirt> store = new ConcurrentLinkedQueue<>();
        int maxSize = 6;

        Semaphore producerSemaphore = new Semaphore(maxSize);
        Semaphore consumerSemaphore = new Semaphore(0);
        //Producers
        Producer p1 = new Producer(store, maxSize, "P1", producerSemaphore, consumerSemaphore);
        Producer p2 = new Producer(store, maxSize, "P2", producerSemaphore, consumerSemaphore);
        Producer p3 = new Producer(store, maxSize, "P3", producerSemaphore, consumerSemaphore);

        //Consumers
        Consumer c1 = new Consumer(store, maxSize, "C1", producerSemaphore, consumerSemaphore);
        Consumer c2 = new Consumer(store, maxSize, "C2", producerSemaphore, consumerSemaphore);
        Consumer c3 = new Consumer(store, maxSize, "C3",producerSemaphore, consumerSemaphore);
        Consumer c4 = new Consumer(store, maxSize, "C4",producerSemaphore, consumerSemaphore);

        //Start the process
        Thread t1 = new Thread(p1);
        t1.start();
        Thread t2 = new Thread(p2);
        t2.start();
        Thread t3 = new Thread(p3);
        t3.start();

        Thread t4 = new Thread(c1);
        t4.start();
        Thread t5 = new Thread(c2);
        t5.start();
        Thread t6 = new Thread(c3);
        t6.start();
        Thread t7 = new Thread(c4);
        t7.start();

        /* Using semaphores, we can also make the execution of the threads in an expected order
        like let's say we have three threads T1, T2 and T3 and we want that first T1 executes then
        T2 and then T3 so what we can do is initialize three semaphores each for one thread and
        assign value 1, 0, 0 respectively.
        Now first thread-1 will acquire and then release thread-2 then thread-2 will acquire and
        release thread-3 and thread-3 will acquire and nothing to release so in this way we achieved
        an order of execution.
        * */
    }
}
