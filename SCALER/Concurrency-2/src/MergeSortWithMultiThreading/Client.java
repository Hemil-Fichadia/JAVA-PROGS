package MergeSortWithMultiThreading;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /* Merge sort :-
        The algorithm of merge sort uses a simple technique of dividing the array into
        two parts from mid, dividing doesn't mean that actually partitioning the main array,
        actually defining the range of first half and second half in each iteration and
        carrying out this step on each of the created halves, this process is continued
        till it narrow downs to single element and then sort them while merging it.

        We are going to achieve it with multi-threading and that also have capability of returning
        data when executed so that is Callable interface, why it is even possible with multi-threading ?
        as we are gradually dividing the array elements into a certain range, each of the divided
        part is sorted individually so the part that is being sorted separately can be sorted using
        a separate thread, and so we can think of it to carry out this operation in this way.
        * */

        List<Integer> numbers = List.of(1, 7, 8, 4, 6, 9, 5, 2, 10, 3);
        ExecutorService executorService = Executors.newCachedThreadPool();
        /* Here we are passing Executor service pool to the MergeSorter constructor as
        we were creating new pool at each call of the task class, but now we created that
        pool here and passed it in argument of the constructor, and so we can use the same
        thread pool in entire algorithm and task execution.
        * */
        MergeSorter mergeSorter = new MergeSorter(numbers, executorService);
        Future<List<Integer>> futureSortedArray = executorService.submit(mergeSorter);
        System.out.println(futureSortedArray.get());
    }
}
