package SharedCount;

public class Client {

    public static void main(String[] args) throws InterruptedException {
        /* This time we are working with a shared resource that is a count variable
        which is set to 0 and 2 threads are working on it simultaneously, say thread T1
        will add numbers from 1 to 100 to count and thread T2 will subtract 1 to 100 to
        count, if we try to predict what will be the final state of the count variable
        then its feels pretty obvious like it should be 0 only as one thread adds a number
        and another thread subtracts it as one thread at a time should access count variable
        and that at the end should result to 0, but sometimes things don't work out in life
        as we predicted but anyway its multi-threading, already the order of execution was
        the problem but now comes another one and that is synchronization problem.
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
        System.out.println("Shared count : "+count.value);

        /*So the value will come out to be random but not 0, and even you may get 0, but it's
        not stable when the size of processing is substantially high, but that is not the only
        problem here another issue is when we update the counter, language fetches the value to
        a temporary variable and then  updates it, and in mean time, it may happen that any other
        thread might also be accessing and processing that value, so consider like this, T1 reads
        count as 3, and adds it with 1 that will result to 4, and updates it with 4 but meanwhile
        thread T2 also read value as 3, and subtracted it and updated it with 2 so now this time
        the last operation was of subtraction, but it might happen next time first four operations
        are of subtraction then adder one, and this is synchronization problem.

        Synchronization problem :-
        If same variable or same resource is being shared by 2 or more than 2 threads, and they
        all are trying to modify it, then we will get unexpected results.

        1) Critical section :-
        A piece of code or a program where there is potential of issues arising due to
        multithreading operation carried out on a shared piece resource.

        2) Race condition :-
        It is a condition where multiple threads are in a race to enter inside a critical
        section, but if both of the threads work with some kind of coordination then, it is
        possible to make sure there is not any conflict.

        3) Preemption :-
        Preemption means gets stopped.
        Whatever piece of code we write and execute as a thread, but after all the task of
        execution is done by a core and one at a time, let's assume thread T1 is carrying out
        an operation on count variable, and it was in mid of updating the count by 1 but in
        between the execution of T1 came T2 and read the value of count as 0, but it is an
        outdated value of count as it was supposed to be 1 but now T2 will subtract 1 from it
        and update it with -1.
        So this preemption means this switching of CPU and this can also lead to Synchronization
        problem.
        So if a thread gets preempted when it was in transient of carrying out some operation
        in critical section, then this can lead to synchronization problem.

        Properties of good synchronization solution is :-
        1) Mutex (Mutual Exclusion)
        Only one thread should be allowed in critical section at a time.
        In this way each thread is carrying out an operation at a time so there is no chance
        of conflicts occurring as only one thread is allowed at time to execute.
        This way, another thing also comes in picture as only one thread is allowed at time but
        if all the threads are waiting then the overall process will be on halt.

        2) Progress :-
        The overall system should keep on progressing.

        3) Bounded waiting :-
        No thread should have to wait imminently, like always one thread is waiting and all
        other threads are executing so this should not happen all active threads should be getting chance
        to execute.
        So there should be a bound on how much a thread should be waiting inside a critical section.

        4) No busy waiting :-
        When a thread continuously needs to check whether it can enter inside a critical section or
        not.
        * */
    }
}
