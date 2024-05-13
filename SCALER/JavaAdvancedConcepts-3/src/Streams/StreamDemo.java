package Streams;



import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args){
        List<Integer> numbers = Arrays.asList(1, 9, 7, 5, 4, 2, 10, 14, 17, 19);

        //Using stream extract odd numbers
        List<Integer> oddNumbers = numbers.stream().filter((x) -> x % 2 != 0).toList();

        System.out.println(oddNumbers);

        /* How the stream is working  here ?
        1. List is converted to Stream first
        2. Stream will loop over the elements in the list
        3. Every element will be passed in the method
        4. Lambda function will be applied over each element
        5. The elements that satisfies the condition are added to stream
        6. Convert stream to List
        * */

        List<Student> students = Arrays.asList(
                new Student("Hemil", 1, 98),
                new Student("Deepak", 2, 87),
                new Student("Parthiban", 3, 82),
                new Student("Rishi", 4, 76),
                new Student("Naveen", 5, 77)
        );
        //Iterate over students and store all the elements that satisfy the condition
        System.out.println(students.stream().filter((x) -> x.marks >= 80).toList());

        /* Map method in stream takes Function interface, so it will accept two data types
        and return the answer in one data type.
        */
        //Iterate over students and get marks of each student
        System.out.println(students.stream().map(student -> student.marks).toList());


        List<String> words = Arrays.asList("scaler", "bangalore", "india", "class", "oops", "stream", "java");
        //count number of words that have length greater than given target
        int len = 4;
        System.out.println(words.stream().filter(x -> x.length() > len).count());
    }
}
