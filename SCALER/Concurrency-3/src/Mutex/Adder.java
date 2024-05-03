package Mutex;

import java.util.concurrent.locks.Lock;

public class Adder implements Runnable{
    private Count count;
    private Lock lock;
    Adder(Count count, Lock lock){
        this.count = count;
        this.lock = lock;
    }

    @Override
    public void run() {
        /* If we take the lock outside the for loop, then adder will execute its whole task
        first and then release the lock and this will make other threads to wait longer.
        So we should be cautious while using lock, and we should only acquire lock on critical
        section so that other threads can carry out operation on critical section as well.
        */
        //lock.lock();
        for(int i = 1; i <= 100000; i++){
            lock.lock();
            count.value += i;
            lock.unlock();
        }
        //lock.unlock();
    }
}
