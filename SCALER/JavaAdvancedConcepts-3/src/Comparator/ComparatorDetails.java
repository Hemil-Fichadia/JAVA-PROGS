package Comparator;

import java.util.*;

public class ComparatorDetails {
    public static void main(String[] args){
        /* Previously we did Car class implement Comparable interface and then Override
        compareTo method and there we used to compare objects on the basis of some
        class attribute, so once we declared the compareTo, the objects are compared on the
        same basis every time we sort or insert objects in PriorityQueue.

        This time we have something new that comes with the Lambda expression and that is
        possible with the help of Comparator interface that have only one abstract method compare
        of return type int.

        If we want to hard code the objects in List then use Arrays.asList(); and insert objects
        inside parentheses.
        * */
        //This is mutable list
        List<Student> students = Arrays.asList(
                new Student("Hemil", 1, 98),
                new Student("Deepak", 2, 87),
                new Student("Parthiban", 3, 86),
                new Student("Rishi", 4, 76)
        );
        /* Just like compareTo method, reverse the inequality of the expression in order to
        sort it in reverse order.
        * */
        Comparator<Student> marksBasedComparison = (st1, st2) -> st1.marks - st2.marks;
        /* This is another way to write Collections.sort instead write List variable.sort(paramComparison)
        * */
        students.sort(marksBasedComparison);
        System.out.println(students);

        //Roll number based comparison
        Comparator<Student> rollNumberBasedComparison = (st1, st2) -> st1.rollNumber - st2.rollNumber;
        students.sort(rollNumberBasedComparison);
        System.out.println(students);
    }
}
