package Executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorExample {

    public static void main(String[] args){
        /* We assign the number of threads to executor, and it regulates the incoming
        tasks, assigns it to any of the free thread and if none of the threads are free
        then it pushes tasks to a waiting queue and waits for a thread to be released to
        assign allotted task.
        Once we assign a thread count to executor, it manages the task allotment to the available
        threads and if none of them are free to take task then those tasks are pushed to waiting
        queue and as everything is happening, order is not maintained which task will be executed
        first it all depends upon how and what is being processed. So we have to actually monitor
        how much memory is being used up while having x number of threads and on basis of the
        application and usage we can tailor the amount of threads that are allotted to executor.
        * */
        /* So after using executor service, we are printing 1 to 100, all with separate threads,
        so at max 10 threads are going to be utilised.
        We have to test and decide a balance point between memory usage and performance as we
        increase the number of threads, performance of the program gets improved but on the stake
        of JAVA Heap memory, so we have to monitor while testing.
        * */
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for(int i = 1; i <= 100; i++){
            /*This line is for debug purpose, till this point, i-1 tasks would have been
            submitted to executor and if the tasks are greater than the pool size, then some
            tasks would be present in workerQueue. Debug to explore these stuffs.
            */
            if(i == 5 || i == 10 || i == 99){
                System.out.println("DEBUG");
            }
            NumberPrinter numberPrinter = new NumberPrinter(i);
            executorService.execute(numberPrinter);
        }
        /* Now here we have fixed the size of threads, but there is also other thing like
        newCachedThreadPool() which will assign the task if any current thread is free and
        will create a new one if none of them are free to take the task.
        * */
    }
}
