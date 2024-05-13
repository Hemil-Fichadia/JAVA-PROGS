package Streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamDetails {
    public static void main(String[] args){
        /* Stream :- Streams are wrapper on data sources for doing operations on the items present
        inside it, so it is nothing but a short and crisp way to iterate or say process the data in
        a dat structure like List.
        * */
        List<Integer> numbers = Arrays.asList(1, 2, 4, 3, 7, 5, 10, 8);

        Stream<Integer> stream = numbers.stream();

        Stream<Integer> stream1 = Stream.of(1, 2, 4, 3, 5, 7, 10);

        //Builder way of creating a stream.
        Stream.Builder<Integer> streamBuilder = Stream.builder();
        streamBuilder.add(1);
        streamBuilder.add(2);
        streamBuilder.add(3);
        streamBuilder.add(5);
        streamBuilder.add(10);
        streamBuilder.add(7);
        streamBuilder.add(8);
        streamBuilder.add(6);
        streamBuilder.build();
    }
}
