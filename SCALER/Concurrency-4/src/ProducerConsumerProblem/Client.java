package ProducerConsumerProblem;

import java.util.LinkedList;
import java.util.Queue;

public class Client {
    public static void main(String[] args){
        /* Producer Consumer problem
        1) Problem statement
        The problem statement states that, assume we have a store that sells shirts
        and there are six slots of shirts and each one can hold one shirt. There are
        producers that manufacture these shirts and there are infinite such producers,
        as it is a store so there are consumers as well, and they are also infinite,
        so we get shirts from producers, and whatever number of shirts are there in
        store can be bought by consumers.

        * Consider Store like a List<Shirt> where limit is maxSize and here it is 6. *

        2) The Rule
        How many producers can be there inside store at a time ? and how many consumers can
        be present inside store at a time ? so as we have infinite numbers of both, so can we
        say infinite ? No, as many number of empty slots are there inside store that many producers
        can be present inside store at a time and as many filled slots are there in store, that many
        number of consumers can be present inside store. So we will only allow a producer to enter store
        if there is an empty slot and only allow a consumer to enter store if there is a filled slot.

        3) Implementing the rule
        From above statement assume two slots are filled, so 2 consumers and 4 producers
        can be there inside store. So to improve the efficiency of our store, we can allow
        producers or consumers to work in parallel.

        4) Potential issue
        Now assume that a shirt has been sold so one slot is freed, so it will notify all the
        producers to fill that slot by adding new shirt. If more than one producer is notified
        and they to enter the store, then there might be a conflict as in multithreading environment,
        we cannot predict the order of execution.
        The point is, if there is only one slot is free, and more than one producer enters the store
        then it will result to inconsistent state where remaining producers are in waiting mode
        but inside store, similarly if there is only one shirt and there are multiple consumers
        inside store then again there will be inconsistency for one shirt, as one consumer will be
        getting shirt rest of them will be waiting inside store for shirt.

         5) Solution
         Only one producer or consumer should be present inside the store, this will make sure that
         there are no chances of inconsistent state.
         We also some ideas for it,
         1) Mutex - Reentrant lock on critical section,
         2) Synchronized block on critical section
        * */

        Queue<Shirt> store = new LinkedList<>();
        int maxSize = 6;
        //Producers
        Producer p1 = new Producer(store, maxSize, "P1");
        Producer p2 = new Producer(store, maxSize, "P2");
        Producer p3 = new Producer(store, maxSize, "P3");

        //Consumers
        Consumer c1 = new Consumer(store, maxSize, "C1");
        Consumer c2 = new Consumer(store, maxSize, "C2");
        Consumer c3 = new Consumer(store, maxSize, "C3");
        Consumer c4 = new Consumer(store, maxSize, "C4");

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

        /* Here in this code we will address the problem of inconsistent state where
        either store size will exceed or consumer will try to buy the shirt when store
        is empty.
        * */

    }
}
