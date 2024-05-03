package SynchronizedBlock;

public class Client {

    public static void main(String[] args) throws InterruptedException {
        /* JAVA provides implicit lock on every object.
        So we can use synchronized keyword here and its working is quite simple,
        we need to make the object synchronized that is critical section and her it is
        the count updating tasks classes, adder and subtractor, so making that block of
        code inside synchronized block will only allow one thread to carry out operation
        at a time.
        So Reentrant lock, lock everything inside it, but using synchronized block it only acquires
        lock on the access of object that we are specifying so let's say some resource is having
        a global scope, and it is locked inside, then the processes that are dependent on it are
        interrupted.
        So using synchronized block specifically acquires the lock on the only declared class
        so assume like we are using Reentrant lock and there are some other classes also present
        inside critical section that are not the part of actual threads conflict, so these will
        also be locked inside it.

        There is a catch to it,
        use synchronized block only when there is only single source of shared resource
        else if we synchronize multiple classes at a time then other threads working
        on it will be interrupted so better choice is to make an explicit lock like
        Reentrant lock.
        * */
        Count count = new Count(0);
        //Adder and Subtractor will share same count class
        Adder adder = new Adder(count);
        Subtractor subtractor = new Subtractor(count);

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
        System.out.println("Synchronized block"+count.value);

        /* Here client is handling the synchronization, but let's say if some class have a private
        attribute and that attribute is only accessed by some getter setter methods so client
        cannot handle synchronization from its side, and raw methods without handling synchronization
        are a case of total chaos, so this time the API or the class which is providing a functionality
        needs to handle synchronization on its own and for that we have synchronization method.
        * */
    }
}
