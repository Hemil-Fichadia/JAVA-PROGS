package MergeSortWithMultiThreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MergeSorter implements Callable<List<Integer>> {
    private List<Integer> arrayToSort;
    private ExecutorService executorService;

    public MergeSorter(List<Integer> arrayToSort, ExecutorService executorService){
        this.arrayToSort = arrayToSort;
        this.executorService = executorService;
    }

    @Override
    public List<Integer> call() throws Exception {
        if(arrayToSort.size() <= 1){
            return arrayToSort;
        }

        //Divide array into two parts
        int mid = arrayToSort.size() / 2;

        List<Integer> leftArray = new ArrayList<>();
        List<Integer> rightArray = new ArrayList<>();

        //Add elements to respective halves to the respective list
        for(int i = 0; i < mid; i++){
            leftArray.add(arrayToSort.get(i));
        }
        for(int i = mid; i < arrayToSort.size(); i++){
            rightArray.add(arrayToSort.get(i));
        }

        //Sort leftArray and rightArray with two separate threads
        MergeSorter leftMergeSorter = new MergeSorter(leftArray, executorService);
        MergeSorter rightMergeSorter = new MergeSorter(rightArray, executorService);

        //This will manage the number of threads needed to be created
        //ExecutorService executorService = Executors.newCachedThreadPool();

        /* Futures :-
        Here comes something very important as well as a pioneer of blocking vs
        non-blocking execution pattern, let's say we have some lines of code
        This is example of sequential code.
        int num = 0;
        void fun(){
            num += 100;
        }
        System.out.println(num) <-- this will only execute after method fun is executed

        So this was the example of sequential execution, but in case of non-blocking execution,
        the line below need the processed data to carry out the further operations and say
        we have created the variables that receive the processed data from threads but in
        the case of non-blocking execution, there is no guarantee that while the below line
        of code is executed the variables will definitely have the data.
        So we receive the Future of that variables or the real data, like it will need to
        wait before executing further line of code till it receives the expected data.
        The executor service returns Future of the real data, this Future is kind of an
        assurance like when we submit the code, the executor service don't have the
        exact timing when it will get the data from thread.
        So while placing the submit request, we don't need to wait, but we might need to wait
        when we actually need that data.
        * */
        Future<List<Integer>> futureLeftSortedArray = executorService.submit(leftMergeSorter);
        Future<List<Integer>> futureRightSortedArray = executorService.submit(rightMergeSorter);

        //Merged sorted arraylist
        List<Integer> sortedArray = new ArrayList<>();
        //Extracting data from the future
        List<Integer> leftSortedArray = futureLeftSortedArray.get(); //<-- This is a blocking call
        List<Integer> rightSortedArray = futureRightSortedArray.get(); //<-- This is a blocking call

        int p1 = 0, p2 = 0;
        while (p1 < leftSortedArray.size() && p2 < rightSortedArray.size()) {

            if(leftSortedArray.get(p1) < rightSortedArray.get(p2)){
                sortedArray.add(leftSortedArray.get(p1));
                p1 += 1;
            }
            else{
                sortedArray.add(rightSortedArray.get(p2));
                p2 += 1;
            }
        }
        while(p1 < leftSortedArray.size()){
            sortedArray.add(leftSortedArray.get(p1));
            p1 += 1;
        }
        while(p2 < rightSortedArray.size()){
            sortedArray.add(rightSortedArray.get(p2));
            p2 += 1;
        }

        return sortedArray;
    }
}
