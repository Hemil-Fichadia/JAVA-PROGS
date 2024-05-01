import java.util.*;
import java.lang.*;

class ListNode{
    int data;
    ListNode next;
    ListNode(int x){
        data = x;
        next = null;
    }
}

class LinkedList1 {
    /*Declare this ListNode class inside the main class here LinkedList1 is the main class, and we have to make the
    ListNode class inside the main class it will work even if we made it static it won't affect the main programs
    but if we declare it outside just to make it non-static, the intellij file system will take across the project
    files and will the throw the duplicate class error either declare it once outside the main class of any file
    or else declare it inside every file's main class.
    */
    //The LinkedList basic building block.
//    static class ListNode{
//        int data;
//        ListNode next;
//        ListNode(int x){
//            data = x;
//            next = null;
//        }
//    }

    static void printLinkedList(ListNode head){
        if(head == null){
            System.out.println("LinkedList empty");
            return;
        }
        ListNode temp = head;
        while(temp != null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    static ListNode insertNodeAtPosition(ListNode head, int data, int position){
        ListNode insertNode = new ListNode(data);
        if(position == 0 || head == null){
            insertNode.next = head;
            head = insertNode;
            return head;
        }
        ListNode temp = head;
        for(int i = 1; i <= position-1; i++){
            if(temp.next == null){
                break;
            }
            temp = temp.next;
        }
        insertNode.next = temp.next;
        temp.next = insertNode;
        return head;
    }

    static ListNode deleteNodeAtPosition(ListNode head, int position){
        ListNode temp = head;
        if(head == null){
            return head;
        }
        if(temp.next == null){
            head = head.next;
            return head;
        }
        if(position == 0){
            head = head.next;
            temp.next = null;
            return head;
        }

        for(int i = 1; i <= position-1; i++){
            if(temp.next.next == null){
                break;
            }
            temp = temp.next;
        }
        ListNode deleteNode = temp.next;
        temp.next = temp.next.next;
        deleteNode.next = null;
        return head;
    }

    static ListNode reverseLinkedList(ListNode head){
        if(head == null){
            return null;
        }
        ListNode reverseHead = null;
        ListNode temp = head;
        while(head != null){
            head = head.next;
            temp.next = reverseHead;
            reverseHead = temp;
            temp = head;
        }
        return reverseHead;
    }

    static int midOfLinkedList(ListNode head){
        if(head == null){
            return -1;
        }
        if(head.next == null){
            return head.data;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.data;
    }

    static ListNode reverseBetweenGivenPoints(ListNode head, int B, int C){
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode beforeStart = dummy;
        ListNode start = dummy;
        for(int i = 1; i <= B-1; i++){
            beforeStart = beforeStart.next;
        }
        start = beforeStart.next;

        ListNode end = dummy;
        ListNode afterEnd = dummy;
        for(int i = 1; i <= C; i++){
            end = end.next;
        }
        afterEnd = end.next;

        beforeStart.next = null;
        end.next = null;

        ListNode reverseHead = reverseLinkedList(start);

        beforeStart.next = end;
        start.next = afterEnd;

        return dummy.next;
    }

    static ListNode removeFromEnd(ListNode head, int B){
        if(head == null || B == 0){
            return null;
        }
        ListNode temp = head;
        if(temp.next == null){
            return null;
        }
        int size = 0;
        while(temp != null){
            temp = temp.next;
            size++;
        }

        int position = 0;
        if(B > size){
            return head = head.next;
        }
        else{
            position = size - B;
        }

        if(position == 0){
            return head = head.next;
        }
        int count = 1;
//        System.out.println(position);
        temp = head;
        while(count <= position-1){
            temp = temp.next;
            count++;
        }
        temp.next = temp.next.next;
        return head;
    }

    public static void main(String[] args) {

        //*******************************************************************************
        //Basics of class and objects
        /* A class is simply a blueprint and an object is the actual creation of that blueprint like
        this class Test contains jsut the attributes and method like printData but there isn't any
        data for real as nothing is stored inside it unitl an object is created. When an object is
        created, all the information is passed into the constructor while its creation or it will be
        initialized with its default values.
        class Test{
            int id;
            int salary;
            String name;
            int age;
            Test(int a, int b, String c, int d){
                id = a;
                salary = b;
                name = c;
                age = d;
            }
            void printData(){
                System.out.pritnln(id);
                System.out.pritnln(salary);
                System.out.pritnln(name);
                System.out.pritnln(age);
            }
        }
        Object is created like this :-
        Test t1          =       new Test(3214, 30000, Jhon, 25);
             ^                         ^
             |                         |
             |                         |
            This is                 This the actual object
        object reference

        We can print or initialize any attribute with the help of '.' dot operator like t1.id=3312,
        t1.salary=50000 etc and can even access methods with it like t1.printData();
        ----------------------------------------------------------------------------------
        **Basics of LinkedLists
        As the name suggest the linked list is the data structure that is based on linking
        of blocks. It can be understood well with the help of an example
        class ListNode{
            int data;
            ListNode next;
            ListNode(int a){
                data = a;
                next = null;
            }
        }
        This is a simple independent block of a linked list and which is made with help of a class
        attributes like data and next and a constructor which is used to initialize some essential
        values at the time of object creation itself as a constructor is invoked at the time of
        object creation like ListNode node = new ListNode(10) the 10 which is passed in the argument
        of constructor as the constructor of the ListNode class is parametrized which means it is
        not a default construcotr.
        Here the next attibute in class ListNode actually holds the address of next block of linked
        list.
        If we establish such links between the various blocks in form of classes it can form a
        link based structure which will form a linked list and to achieve that we don't need to
        initialize class again and again just create different objects of ListNode and place the
        address in the next attribute.
        For example :- ListNode node = new ListNode(10); and ListNode temp = node; this both node
        and temp are pointing the same 10 value list node suppose its address is #ad1 so currently
        node = temp = #ad1 if we do node.next = new ListNode(20) then the #ad1 object's next will
        store address #ad2 with data 20 and move temp to #ad2 by doing temp = temp.next and by repeating
        the same process we can create as many linked blocks we want.
        */

        //********************************************************************************
        //Q1 Print the entire linked list
        /* Iterate over the whole given LinkedList and for that we require to pass head of the list
        to our function initialize a temporary temp variable which will acutally iterate over the
        list if we move our head forward we will lose our main LinkedList starting point so use temp
        variable and move it forward by doing temp = temp.next which will make it store the address
        of its sucessive block as the next attribute holds the address of its next block address
        iterate till the temp is not null.
        */
        // int[] A = {10, 20, 30, 40, 50, 60, 70, 80};
        // ListNode head = new ListNode(A[0]);
        // ListNode temp = head;
        // for(int i = 1; i < A.length; i++){
        //     temp.next = new ListNode(A[i]);
        //     temp = temp.next;
        // }
        // printLinkedList(head);

        //***********************************************************************************
        //Q2 Insert in LinkedList
        /* Here we are asked to insert a block with value B at position C this have certain edge
        cases like position asked to insert is out of the range or insert at the start so lets first
        consider how to insert in the given linked list. Suppose we have to insert data 40 at 5th
        position consider 0-based indexing the lists don't actually consists indexes it is our assumption
        in order to quantify our search so go to 5-1 = 4th positon then make new node with data and
        point its next to the 5th position and point the 4th's next to new node this are just the steps
        the code is like ListNode insetNode = new ListNode(B); iterate and take temp to C-1 position
        now make insertNode.next = temp.next and temp.next = insertNode.
        If the C=0 then make insertNode.next = head, head = insertNode and return head. If C>length
        just insert at last means iterate while loop till temp != null by making insertNode.next = temp.next
        temp.next = insertNode.
        Take a note that you are already standing at 0th position as temp = head of the linked
        list and  I  have added 0 in the array to relate the 0-based indexing.
        */
        // int[] A = {0, 10, 20, 30, 40, 50, 60, 70, 80};
        // ListNode head = new ListNode(A[0]);
        // ListNode temp = head;
        // for(int i = 1; i < A.length; i++){
        //     temp.next = new ListNode(A[i]);
        //     temp = temp.next;
        // }
        // // ListNode head = null;
        // ListNode ansHead = insertNodeAtPosition(head, 25, 4);
        // printLinkedList(ansHead);

        //*********************************************************************************
        //Q3 Delete in linked list
        /* Here we have to delete a node at the given position from the given linked list.
        Deleting also have all the edge cases just as same as inserting like if the head itself is
        null then return head itself and if the deletion index is out of range then delete the last
        one. In order to delete a node we simpley simply need to reach at position-1 then make that
        temp.next point to temp.next.next and before that try to make that temp.next node to point
        null so that it can be deleted by java garbage collector.
        */
        // int[] A = {0, 10, 20, 30, 40, 50, 60, 70, 80};
        // // int[] A = {10};
        // ListNode head = new ListNode(A[0]);
        // ListNode temp = head;
        // for(int i = 1; i < A.length; i++){
        //     temp.next = new ListNode(A[i]);
        //     temp = temp.next;
        // }
        // ListNode ansHead = deleteNodeAtPosition(head, 7);
        // printLinkedList(ansHead);

        //**********************************************************************************
        //Q6 Reverse the given LinkedList and return head
        /* Here we are asked to reverse the whole given LinkedList without using any extra space
        and return the head of it, and we cannot even change data of any linked list block. So a
        simple idea here is created a reference named reverseHead then iterate over the main linked
        list detach one block add in front of the reverseHead and shift reverseHead to that new
        added block. The steps goes like this first assign temp = head make head = head.next so
        we don't lose the rest of the list now make temp.next = null so the current block is detached
        now make temp.next = reverseHead then make reverseHead = temp and then make temp = head
        and repeat the process of detaching one block and adding behind reverseHead and at the end
        the return reverseHead as it would be storing the reversed list.
        */
//        int[] A = {10, 20, 30, 40, 50, 60, 70, 80};
//        ListNode head = new ListNode(A[0]);
//        ListNode temp  = head;
//        for(int i = 1; i < A.length; i++){
//            temp.next = new ListNode(A[i]);
//            temp = temp.next;
//        }
//        ListNode ansHead = reverseLinkedList(head);
//        printLinkedList(ansHead);

        //*******************************************************************************
        //Q7 Find the middle element of a linked list
        /* Here we have to retrun the middle element of a linked list and the simple idea would
        be iterated over it and calculate the size and half it and return the element at the half
        of it but this will need multiple iterations there is a technique with which we can just
        get it in single iterarion with help of fast and slow pointer as the name suggests the
        slow pointer takes one step at a time and fast takes two and when the fast pointer is at
        the second last block in the even length list and last block of the odd list the slow will
        always be at mid of the list.
        */
//        int[] A = {10, 20, 30, 40, 50, 60, 70, 80};
//        ListNode head = new ListNode(A[0]);
//        ListNode temp  = head;
//        for(int i = 1; i < A.length; i++){
//            temp.next = new ListNode(A[i]);
//            temp = temp.next;
//        }
//        System.out.println(midOfLinkedList(head));

        //********************************************************************************
        //Q4 Reverse the LinkedList-2
        /* Here we have to reverse the linked list from point B to C in the given linked list.
        So this can be done with a simple idea like first detaching the linked list from start to
        end while storing the start and end points from where it is detached reverse the seprated
        linked list and then reconnect to both points of main linked list. Now the steps goes like
        first make dummy node with value -1 attached before head of the list and initialize two
        references start and befreStart the start will store the starting of the concerned part
        of the linked list and the beforeStart will hold the point on the main list iterate and
        take beforeStart to the B-1 point and make start = beforeStart.next now in the similar way
        make two references end and afterEnd end will store the end of the list and afterEnd will
        store the point on the main list to reconnect the reversed list to the main list.
        A point to be noted here is what if it is asked to reverse from 0 to 3 means we have to
        reverse it and reattach to the main list but in that case we won't be having any connecting
        point for the main list for starting so adding a dummmy node with value -1 makes it easy to
        handle the case of reversing from start to a given point.
        */
        // int[] A = {10, 20, 30, 40, 50, 60, 70, 80, 90};
        // ListNode head = new ListNode(A[0]);
        // ListNode temp = head;
        // for(int i = 1; i < A.length; i++){
        //     temp.next = new ListNode(A[i]);
        //     temp = temp.next;
        // }
        // ListNode ansHead = reverseBetweenGivenPoints(head, 3, 8);
        // printLinkedList(ansHead);

        //********************************************************************************
        //Q5 Remove Nth node from the list end
        /* Here we have to remove the nth node from the end so simply linked lists don't have
        indices, we assume it so we have to iterate over it and count the n-1 position and then
        remove the next node to it. Here We need to take care of one thing like if the size=5
        and B=3 so we have to remove 3rd node from end that means the position=size-B=5-3=2
        that means we have to connect 2 -> 4 so 3 will be removed but before that if we stop at
        2 and then connect it to 4 then the job is done but if we write the condition count<=position
        then our loop will even iterate if its count=position so it will make an extra iteration So
        iterate till position-1 instead.
        */
        int[] A = {1,2,3,4,5};
        // int[] A = {1,2,3,4,5,6,7,8,9,10};
        ListNode head = new ListNode(A[0]);
        ListNode temp = head;
        for(int i = 1; i < A.length; i++){
            temp.next = new ListNode(A[i]);
            temp = temp.next;
        }
        ListNode ansHead = removeFromEnd(head, 4);
        printLinkedList(ansHead);
    }
}