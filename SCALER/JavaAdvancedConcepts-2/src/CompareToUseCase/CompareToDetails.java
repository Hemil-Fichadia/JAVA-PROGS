package CompareToUseCase;

import java.util.PriorityQueue;
import java.util.Queue;

public class CompareToDetails {
    public static void main(String[] args){
        /* Here we will witness the use-case of compareTo function
        using Car class, for which we will store objects inside MinHeap,
        and it will sort itself without Custom Comparator basis of the parameter
        we provide to be compared with other object.
        * */

        Car car1 = new Car("A", 1000, 280);
        Car car2 = new Car("B", 850, 220);
        Car car3 = new Car("C", 1200, 300);
        Car car4 = new Car("D", 550, 120);
        Car car5 = new Car("E", 780, 180);
        Car car6 = new Car("F", 2000, 400);

        Queue<Car> minHeap = new PriorityQueue<>();
        minHeap.add(car1);
        minHeap.add(car2);
        minHeap.add(car3);
        minHeap.add(car4);
        minHeap.add(car5);
        minHeap.add(car6);

        while(minHeap.size() > 0){
            System.out.println(minHeap.poll().toString());
        }
    }
}
