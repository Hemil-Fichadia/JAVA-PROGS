package CachedThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorExample {

    public static void main(String[] args){
        /* This is cached thread pool, so it creates threads on its own if required.
        * */
        ExecutorService executorService = Executors.newCachedThreadPool();
        for(int i = 1; i <= 100; i++){
            /*This line is for debug purpose, till this point, i-1 tasks would have been
            submitted to executor and if the tasks are greater than the pool size, then some
            tasks would be present in workerQueue, but this is dynamic for creation of threads
            so at some point it also may happen like there is only one thread present if most
            of the tasks are executed.
            Debug to explore these stuffs.
            */
            if(i == 5 || i == 10 || i == 99){
                System.out.println("DEBUG");
            }
            NumberPrinter numberPrinter = new NumberPrinter(i);
            executorService.execute(numberPrinter);
        }
    }
}
