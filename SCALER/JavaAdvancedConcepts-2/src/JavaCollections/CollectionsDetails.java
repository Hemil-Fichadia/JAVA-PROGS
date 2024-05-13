package JavaCollections;

public class CollectionsDetails {
    public static void main(String[] args){
        /*
        Collections :- Collections is a set of classes or interface to manage data.

                                                               Collections hierarchy

                                                               Iterable (Interface)
                                                                   ^
                                                                   |
                                                                   |
                                                              Collection (Interface)
                                                                   ^
                                                                   |
                                                                   |
                         ------------------------------------------------------------------------------------------------ Extends
                         ^                                         ^                                                    ^
                         |                                         |                                                    |
                         |                                         |                                                    |
                         |                                         |                                                    |
                    List(Interface)                          Queue(Interface)                                      Set(Interface)
                         ^                                         ^                                                    ^
                         |                                         |                                                    |
                         |                                         |                                                    |
             --------------------------                   ---------------------------                  --------------------------------- Extends
            ^            ^             ^                   ^                         ^                 ^                ^               ^
            |            |             |                   |                         |                 |                |               |
            |            |             |                   |                         |                 |                |               |
         Vector       ArrayList     LinkedList -------->Dequeue                PriorityQueue        SortedSet        HashSet        LinkedHashSet
         (Class)      (Class)       (Class)             (Interface)            (Class)              (Interface)      (Class)        (Class)
            ^                                              ^                                           ^
            |                                              |                                           |
            |                                              |                                           |
        Stack(Class)                                   ArrayDeque(Class)                            TreeSet(Class)



        This is the hierarchy of famous Collection interface, here each arrow denotes that it is
        either extended or implemented by the class or interface above it.

        * */
    }
}
