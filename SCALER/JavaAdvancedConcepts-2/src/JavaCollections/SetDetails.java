package JavaCollections;

public class SetDetails {
    public static void main(String[] args){
        /* Set is used when we require all unique elements in it after it is stored.
        We can declare Set like this
        Set<Integer> set = new HashSet<>();
        There are three types of set
        1) HashSet
        2) LinkedHashSet
        3) TreeSet

        Whichever set we use, the operations like
        add()
        remove()
        size()
        contains()

        these all operations executes in O(1) time complexity, but for average case
        if we store data like String, then it takes O(length) time complexity to
        carry out is O(l).

        The internal data structure that is working for taking unique elements is HashTable
        and internally HashTable is bucket of LinkedList or Array of LinkedList which terms that
        each element of that array is an individual LinkedList like this


                    INTERNALS OF HASH TABLE

                   --------       -------         -------
                   |      |----> |Linked | ----> |List   |
               0   |bucket|       -------         --------
                   --------       -------         -------
                   |      |----> |       | ----> |       |
               1   |      |       -------         --------
                   --------       -------         -------
                   |      |----> |       | ----> |       |
               2   |      |       -------         --------
                   --------       -------         -------
                   |      |----> |       | ----> |       |
               3   |      |       -------         --------
                   --------       -------         -------
                   |      |----> |       | ----> |       |
               4   |      |       -------         --------
                   --------
        Initially set creates some buckets, as it is a Hash based data structure, it before
        inserting any value it calls Hash function that returns the Hash value of given data.
        In order to make the Hash value fall in the range of number of buckets, it takes mod
        with the final Hash value, and it will fall in the range of 0 to N-1, so whichever
        bucket number it gets, it adds to respective bucket and each bucket is array of Doubly
        LinkedList, so if for other data it gets the same bucket then it creates a chain at
        the respective bucket and adds at the end of doubly LinkedList.

        If we add data that is already present inside HashSet, still it follows the similar
        process of calling Hash function getting the hash value then taking mod with total
        bucket count that will give the bucket number this data will be belonging to but
        before inserting, it iterates and checks if the similar Hash value is present then
        ignore this one else add this one at the end of the LinkedList. So what ever operation
        we carry out on set, it will follow the exact procedure.

        As we have understood that average time complexity of set is O(1), but in each of the operation
        we carry out requires iteration on existing data, so question here is how come it is
        even able to make it O(1) for any of the case ?

        Loading Factor :-
        Here comes the concept of loading factor X

        X = Average number of elements per bucket

        X = Total number of elements
            -------------------------
            Total number of buckets

        If X increases, time complexity of each operation of HashSet increases, so in order to
        optimise the time complexity of HashSet operation, we need to lower down the value of X.

        JAVA maintains some threshold value of X so that value of X is always below the limit of it
        and in order to achieve that, it needs to increment the count of buckets, and it actually doubles
        it, and this process of doubling the buckets is called "ReHashing". So the process which makes sure
        that average number of elements per bucket are less than threshold.

        

        * */
    }
}
