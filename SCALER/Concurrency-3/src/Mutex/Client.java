package Mutex;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Client {
    public static void main(String[] args) throws InterruptedException {
        /* Mutex means only one thread executes the task at a time and this is
        carried out by acquiring a lock on the critical resource and release it
        when task is complete.
        So the releasing of lock acts like a notifying mechanism to all those threads
        which are waiting to enter, so operating system will choose one thread randomly
        to enter inside critical section.

        Properties of lock :-
        1) Only one thread can acquire a lock at any point of time.
        2) Once a thread releases the lock, other threads will automatically be
        notified.
        So is this lock satisfying the parameters of a good synchronization solution ?
        Yes, it is, it is following MUTEX, it is following progress as at least one thread is
        running at a time, bounded waiting and No busy waiting.

        * */
        Count count = new Count(0);

        /*This is the lock object that will be common amongst threads working on
        shared piece of resource.
        */
        Lock lock = new ReentrantLock();

        //Adder and Subtractor will share same count class
        /* Inside Adder and Subtractor class, the for loop whole is critical section
        as it is responsible for task execution, so we should acquire lock on loop itself.
        * */
        Adder adder = new Adder(count, lock);
        Subtractor subtractor = new Subtractor(count, lock);

        Thread t1 = new Thread(adder);
        Thread t2 = new Thread(subtractor);

        t1.start();
        t2.start();
        /*We have to use join function here of threads as execution reaches the
        print line, it cannot be predicted that threads would have finished the execution
        so join will make a blocking call for program execution of this file.
        */
        t1.join(); //<-- This is a blocking call
        t2.join(); //<-- This is a blocking call
        /* When we may execute this line that doesn't mean that both tasks would have executed,
        we are in a multithreaded environment, so we cannot expect anything to be precise at a
        moment, so we have to make sure that whenever we try to work with any variable or a program
        that includes multithreading, then somehow the final result is mostly expected in a shared
        resources, but that is totally opposite for a distributed tasks like all the tasks are being
        executed in a separate thread then whichever we receive first, is also processed first, and
        threads are also used for it.
        * */
        System.out.println("Mutex client : "+count.value);
    }
}
