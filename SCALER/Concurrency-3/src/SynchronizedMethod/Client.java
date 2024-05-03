package SynchronizedMethod;

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

        /* " If we declare any method synchronized in a class then only one thread can be present
        inside any synchronized method of that object at a time. "

        This means that synchronization is applicable to a common object at a time not among all
        the present object so here there is context around same object as it is linked to a method
        not to an attribute.

        So if any API we are using that is to be used inside multithreading environment, then that
        functionality or API is supposed to provide us thread safe functionality.

        So assume that we are having multiple synchronized methods in a class, now that each of the
        methods are sharing the same attribute or different can be a different point of observation,
        but let's say more than one thread are present inside an object, now just think for a second,
        if more than one threads are allowed to be present inside a shared resource then what is the
        purpose of declaring it synchronized or how it will act different from methods of that object
        that are not synchronized, so using simple common sense here, only one thread can be present
        at an instance inside an object, and it will access any of the one synchronized methods.
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
        System.out.println("Synchronized method : "+count.getValue());
    }
}
