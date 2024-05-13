package JavaCollections;

import java.util.List;
import java.util.Vector;

public class ListDetails {
    public static void main(String[] args){
        /* ArrayList is a dynamic array which have capability of incrementing
        the size of array at the times required.
        We declare List like this

        List<Integer> list = new ArrayList<>();

        following this hierarchy of Collection interface, there is always an interface on
        the left side and a class on the right side, so that if we intend to change the implementation
        of the fundamental ArrayList to LinkedList so that transition is smooth, and it provides loose
        coupling.

        As we know that the reference is stored inside stack memory, and it stores the address
        of the real object and let's say it's 5K that is stored in heap memory, and that object
        contains the address of actual array object let's say it's @500 which have initial capacity
        of holding 10 elements, so as list fills up to 70%, it creates new object of size 1.5 times
        or 2 times of previous array in some case, and copies all the data from previous array
        to new array and that new address is @600, so this will point to new location that have
        capacity to hold 15 elements or 20 elements if the size is twice of the previous.
        The previous array of size 10 with address @500 is now de-referenced, so it is removed
        by garbage collector.

        When new array of twice the size of previous array is created, the copying part is of O(N),
        but it's not very often so this kind of time complexity is called "Amortized time complexity"
        where once in a while we perform a costly operation to optimize future operations.

        Vector :-
        Vector are thread safe and Synchronized, and so they are slower.
        ArrayList :- ArrayList are faster as they are non-synchronized.

        LinkedList :-
        The LinkedList that is provided in collections is doubly LinkedList not a singly LinkedList,
        when we create its object, it stores the reference in stack memory and object in heap memory
        and the object that is in heap memory stores the head and tail of LinkedList object so whatever
        is the operation, is executed in O(1) time complexity just like ArrayList so this is operationally
        more optimized compared to ArrayList implementation.
        * */
        List<Integer> vector = new Vector<>();
    }
}
